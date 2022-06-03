/*
 * Copyright 2019 iserge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.DistanceDisplayCondition;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.Quaternion;
import org.cesiumjs.cs.core.TranslationRotationScale;
import org.cesiumjs.cs.core.enums.ClockRange;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.LabelGraphics;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.LabelGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.datasources.properties.NodeTransformationProperty;
import org.cesiumjs.cs.datasources.properties.SampledNumberProperty;
import org.cesiumjs.cs.datasources.properties.SampledPositionProperty;
import org.cesiumjs.cs.datasources.properties.VelocityOrientationProperty;
import org.cesiumjs.cs.datasources.properties.VelocityVectorProperty;
import org.cesiumjs.cs.js.JsDate;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cesiumjs.cs.datasources.properties.CallbackProperty;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class TimeDynamicWheels extends AbstractExample {
    private VelocityVectorProperty<Cartesian3> velocityVectorProperty;
    // Store the wheel's rotation over time in a SampledProperty.
    private final SampledNumberProperty<Double> wheelAngleProperty = SampledNumberProperty.create();
    private final Cartesian3 velocityVector = new Cartesian3();

    @Inject
    public TimeDynamicWheels(ShowcaseExampleStore store) {
        super("Time Dynamic Wheels", "Dynamically rotate a model's wheels based on its velocity using node transformations",
                new String[]{"Entity", "gltf"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions options = new ViewerOptions();
        options.shouldAnimate = true;
        ViewerPanel csVPanel = new ViewerPanel(options);
        Viewer viewer = csVPanel.getViewer();

        // Make sure viewer is at the desired time.
        JulianDate start = JulianDate.fromDate(new JsDate(2018, 11, 12, 15));
        double totalSeconds = 10;
        JulianDate stop = JulianDate.addSeconds(start, totalSeconds, new JulianDate());
        viewer.clock().startTime = start.clone();
        viewer.clock().stopTime = stop.clone();
        viewer.clock().currentTime = start.clone();
        viewer.clock().clockRange = ClockRange.LOOP_STOP();
        viewer.timeline().zoomTo(start, stop);

        // Create a path for our vehicle by lerping between two positions.
        SampledPositionProperty position = new SampledPositionProperty();
        Cartesian3 startPosition = new Cartesian3(-2379556.799372864, -4665528.205030263, 3628013.106599678);
        Cartesian3 endPosition = new Cartesian3(-2379603.7074103747, -4665623.48990283, 3627860.82704567);
        // A velocity vector property will give us the entity's speed and direction at
        // any given time.
        velocityVectorProperty = new VelocityVectorProperty<>(position, false);
        double wheelAngle = 0;

        int numberOfSamples = 100;
        for (int i = 0; i <= numberOfSamples; ++i) {
            double factor = (double) i / numberOfSamples;
            JulianDate time = JulianDate.addSeconds(start, factor * totalSeconds, new JulianDate());

            // Lerp using a non-linear factor so that the vehicle accelerates.
            double locationFactor = Math.pow(factor, 2.);
            Cartesian3 location = Cartesian3.lerp(startPosition, endPosition, locationFactor, new Cartesian3());
            position.addSample(time, location);
            // Rotate the wheels based on how fast the vehicle is moving at each timestep.
            velocityVectorProperty.getValue(time, velocityVector);
            double metersPerSecond = Cartesian3.magnitude(velocityVector);
            double wheelRadius = 0.52;// in meters.
            double circumference = Math.PI * wheelRadius * 2;
            double rotationsPerSecond = metersPerSecond / circumference;

            wheelAngle += ((Math.PI * 2 * totalSeconds) / numberOfSamples) * rotationsPerSecond;
            wheelAngleProperty.addSample(time, wheelAngle);
        }

        NodeTransformationProperty<TranslationRotationScale> wheelTransformation = new NodeTransformationProperty<>();
        wheelTransformation.rotation = new CallbackProperty<>(this::rotationCallback, false);

        JsObject nodeTransformations = JsObject.create();
        nodeTransformations.setProperty("Wheels", wheelTransformation);
        nodeTransformations.setProperty("Wheels_mid", wheelTransformation);
        nodeTransformations.setProperty("Wheels_rear", wheelTransformation);
        Cesium.log(nodeTransformations);

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/GroundVehicle/GroundVehicle.glb");
        modelGraphicsOptions.runAnimations = new ConstantProperty<>(false);
        modelGraphicsOptions.nodeTransformationsObject = nodeTransformations;

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = position;
        entityOptions.orientation = new VelocityOrientationProperty(position);
        entityOptions.model = new ModelGraphics(modelGraphicsOptions);

        LabelGraphicsOptions labelOptions = new LabelGraphicsOptions();
        labelOptions.text = new CallbackProperty<>(this::updateSpeedLabel, false);
        labelOptions.font = new ConstantProperty<>( "20px sans-serif");
        labelOptions.showBackground = new ConstantProperty<>(true);
        labelOptions.distanceDisplayCondition = new ConstantProperty<>(new DistanceDisplayCondition(0.0, 100.0));
        labelOptions.eyeOffset = new ConstantProperty<>(new Cartesian3(0, 3.5, 0));
        entityOptions.label = new LabelGraphics(labelOptions);
        Cesium.log(entityOptions.label);

        Entity vehicleEntity = viewer.entities().add(entityOptions);

        viewer.trackedEntity = vehicleEntity;
        vehicleEntity.viewFrom = new ConstantProperty<>(new Cartesian3(-10.0, 7.0, 4.0));

        contentPanel
                .add(new HTML("<p>Dynamically rotate a model's wheels based on its velocity using node transformations</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    private Quaternion rotationCallback(JulianDate time, Quaternion result) {
        return Quaternion.fromAxisAngle(Cartesian3.UNIT_X(), wheelAngleProperty.getValue(time), result);
    }

    private String updateSpeedLabel(JulianDate time, String result) {
        velocityVectorProperty.getValue(time, velocityVector);
          double metersPerSecond = Cartesian3.magnitude(velocityVector);
          double kmPerHour = Math.round(metersPerSecond * 3.6);

        return kmPerHour + "km/hr";
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "TimeDynamicWheels.txt";
        return sourceCodeURLs;
    }
}