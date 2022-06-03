/*
 * Copyright 2022 iSergio, Gis4Fun.
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
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.DistanceDisplayCondition;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.Matrix3;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.core.enums.ClockRange;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.LabelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.LabelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.CallbackProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.datasources.properties.SampledNumberProperty;
import org.cesiumjs.cs.datasources.properties.SampledPositionProperty;
import org.cesiumjs.cs.datasources.properties.VelocityOrientationProperty;
import org.cesiumjs.cs.datasources.properties.VelocityVectorProperty;
import org.cesiumjs.cs.js.JsDate;
import org.cesiumjs.cs.scene.Model;
import org.cesiumjs.cs.scene.enums.ModelAnimationLoop;
import org.cesiumjs.cs.scene.options.FromGltfOptions;
import org.cesiumjs.cs.scene.options.ModelAnimationOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class ManuallyControlledAnimation  extends AbstractExample {
    private VelocityVectorProperty<Cartesian3> velocityVectorProperty;
    private Cartesian3 velocityVector = new Cartesian3();

    @Inject
    public ManuallyControlledAnimation(ShowcaseExampleStore store) {
        super("Manually Controlled Animation",
                "Manually control a model's animations.",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "Animation"}, store, "1.94");
    }

    @Override
    public void buildPanel() {
        ViewerOptions options = new ViewerOptions();
        options.shouldAnimate = true;
        ViewerPanel csVPanel = new ViewerPanel(options);
        Viewer viewer = csVPanel.getViewer();

        //Make sure viewer is at the desired time.
        JulianDate start = JulianDate.fromDate(new JsDate(2018, 11, 12, 15));
        int totalSeconds = 30;
        JulianDate stop = JulianDate.addSeconds(start, totalSeconds, new JulianDate());
        viewer.clock().startTime = start.clone();
        viewer.clock().stopTime = stop.clone();
        viewer.clock().currentTime = start.clone();
        viewer.clock().clockRange = ClockRange.LOOP_STOP();
        viewer.timeline().zoomTo(start, stop);

        // Create a path for our model by lerping between two positions.
        SampledPositionProperty position = new SampledPositionProperty();
        SampledNumberProperty<Double> distance = SampledNumberProperty.create();
        Cartesian3 startPosition = new Cartesian3(-2379556.799372864, -4665528.205030263, 3628013.106599678);
        Cartesian3 endPosition = new Cartesian3(-2379603.7074103747, -4665623.48990283, 3627860.82704567);
        // A velocity vector property will give us the entity's speed and direction at any given time.
        velocityVectorProperty = new VelocityVectorProperty<>(position, false);

        int numberOfSamples = 100;
        Cartesian3 prevLocation = startPosition;
        double totalDistance = 0;
        for (int i = 0; i <= numberOfSamples; ++i) {
            double factor = (double) i / numberOfSamples;
            JulianDate time = JulianDate.addSeconds(start, factor * totalSeconds, new JulianDate());

            // Lerp using a non-linear factor so that the model accelerates.
            double locationFactor = Math.pow(factor, 2);
            Cartesian3 location = Cartesian3.lerp(startPosition, endPosition, locationFactor, new Cartesian3());
            position.addSample(time, location);
            distance.addSample(time, (totalDistance += Cartesian3.distance(location, prevLocation)));
            prevLocation = location;
        }

        // Add our model.
        FromGltfOptions gltfOptions = new FromGltfOptions();
        gltfOptions.url = GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb";
        gltfOptions.scale = 4;
        Model modelPrimitive = (Model) viewer.scene().primitives().add(Model.fromGltf(gltfOptions));

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = position;
        // Automatically set the model's orientation to the direction it's facing.
        entityOptions.orientation = new VelocityOrientationProperty(position);
        LabelGraphicsOptions labelOptions = new LabelGraphicsOptions();
        labelOptions.text = new CallbackProperty<>(this::updateSpeedLabel, false);
        labelOptions.font = new ConstantProperty<>( "20px sans-serif");
        labelOptions.showBackground = new ConstantProperty<>(true);
        labelOptions.distanceDisplayCondition = new ConstantProperty<>(new DistanceDisplayCondition(0.0, 100.0));
        labelOptions.eyeOffset = new ConstantProperty<>(new Cartesian3(0, 7.2, 0));
        entityOptions.label = new LabelGraphics(labelOptions);
        Entity modelLabel = viewer.entities().add(entityOptions);

        modelPrimitive.readyPromise().then(model -> {
            ModelAnimationOptions animationOptions = new ModelAnimationOptions();
            animationOptions.loop = ModelAnimationLoop.REPEAT();
            animationOptions.animationTime = (duration, seconds) -> distance.getValue(viewer.clock().currentTime) / duration;
            animationOptions.multiplier = 0.25;
            model.activeAnimations.addAll(animationOptions);

            Matrix3 rot = new Matrix3();
            viewer.scene().preUpdate().addEventListener((Event.Listener) o -> {
                JulianDate time = viewer.clock().currentTime;
                Cartesian3 pos = position.getValue(time);
                Cartesian3 vel = velocityVectorProperty.getValue(time);
                Cartesian3.normalize(vel, vel);
                Transforms.rotationMatrixFromPositionVelocity(pos, vel, viewer.scene().globe.ellipsoid, rot);
                Matrix4.fromRotationTranslation(rot, pos, model.modelMatrix);
            });
        });
        viewer.trackedEntity = modelLabel;
        modelLabel.viewFrom = new ConstantProperty<>(new Cartesian3(-30.0, -10.0, 10.0));

        contentPanel.add(new HTML(
                "<p>Manually control a model's animations.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ManuallyControlledAnimation.txt";
        return sourceCodeURLs;
    }

    private String updateSpeedLabel(JulianDate time, Object result) {
        velocityVectorProperty.getValue(time, velocityVector);
        double metersPerSecond = Cartesian3.magnitude(velocityVector);
        long kmPerHour = Math.round(metersPerSecond * 3.6);

        return kmPerHour + " km/hr";
    }
}