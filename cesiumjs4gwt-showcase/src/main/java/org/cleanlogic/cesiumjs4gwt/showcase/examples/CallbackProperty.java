/*
 * Copyright 2018 iserge.
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
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.LabelGraphics;
import org.cesiumjs.cs.datasources.graphics.PolylineGraphics;
import org.cesiumjs.cs.datasources.graphics.options.LabelGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.PolylineGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.lang.Math;

/**
 * CallbackProperty example.
 *
 * @author Serge Silaev aka iSergio
 */
public class CallbackProperty extends AbstractExample {
    private final double startLatitude = 35;
    private final double startLongitude = -120;
    private final JulianDate startTime = JulianDate.now();
    private final Cartographic startCartographic = Cartographic.fromDegrees(startLongitude, startLatitude);
    private final Cartographic scratch = new Cartographic();
    private final EllipsoidGeodesic geodesic = new EllipsoidGeodesic();
    private double endLongitude;
    private Entity redLine;
    // use scratch object to avoid new allocations per frame.
    private Cartographic endCartographic = new Cartographic();

    @Inject
    public CallbackProperty(ShowcaseExampleStore store) {
        super("Callback Property", "Callback property", new String[]{
                "Showcase", "3D Tiles", "Callback property"}, store);
    }

    @Override
    public void buildPanel() {
        final ViewerPanel csVPanel = new ViewerPanel();
        csVPanel.getViewer().clock().shouldAnimate = true;

        PolylineGraphicsOptions polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.positions =
                new org.cesiumjs.cs.datasources.properties.CallbackProperty<>(
                        (time, result) -> {
                            endLongitude = startLongitude + 0.001 * JulianDate.secondsDifference(time, startTime);
                            return Cartesian3.fromDegreesArray(
                                    new double[]{startLongitude, startLatitude, endLongitude, startLatitude},
                                    Ellipsoid.WGS84(), (Cartesian3[]) result);
                        }, false);

        polylineGraphicsOptions.width = new ConstantProperty<>(5);
        polylineGraphicsOptions.material = new ColorMaterialProperty(Color.RED());
        EntityOptions options = new EntityOptions();
        options.polyline = new PolylineGraphics(polylineGraphicsOptions);
        redLine = csVPanel.getViewer().entities().add(options);

        LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
        labelGraphicsOptions.text = new org.cesiumjs.cs.datasources.properties.CallbackProperty<>(
                this::getLength, false);
        labelGraphicsOptions.font = new ConstantProperty<>("20px sans-serif");
        labelGraphicsOptions.pixelOffset = new ConstantProperty<>(new Cartesian2(0.0, 20));
        options = new EntityOptions();
        options.positionCallback = new org.cesiumjs.cs.datasources.properties.CallbackProperty<>(
                this::getMidpoint, false);
        options.label = new LabelGraphics(labelGraphicsOptions);

        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(options);

        contentPanel.add(new HTML("<p></p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CallbackProperty.txt";
        return sourceCodeURLs;
    }

    private Cartesian3 getMidpoint(JulianDate time, Cartesian3 result) {
        // Get the end position from the polyLine's callback.
        Cartesian3 endPoint = ((Cartesian3[]) redLine.polyline.positions.getValue(time))[1];
        endCartographic = Cartographic.fromCartesian(endPoint);
        geodesic.setEndPoints(startCartographic, endCartographic);
        Cartographic midpointCartographic = geodesic.interpolateUsingFraction(0.5, scratch);
        return Cartesian3.fromRadians(midpointCartographic.longitude, midpointCartographic.latitude);
    }

    private String getLength(JulianDate time, String result) {
        // Get the end position from the polyLine's callback.
        Cartesian3 endPoint = ((Cartesian3[]) redLine.polyline.positions.getValue(time))[1];
        endCartographic = Cartographic.fromCartesian(endPoint);

        geodesic.setEndPoints(startCartographic, endCartographic);
        double lengthInMeters = Math.round(geodesic.surfaceDistance());
        return NumberFormat.getFormat("#.#").format(lengthInMeters / 1000) + " km";
    }
}