/*
 * Copyright 2017 iserge.
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

package org.cleanlogic.showcase.client.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.enums.ClockRange;
import org.cesiumjs.cs.core.interpolation.HermitePolynomialApproximation;
import org.cesiumjs.cs.core.interpolation.LagrangePolynomialApproximation;
import org.cesiumjs.cs.core.interpolation.LinearApproximation;
import org.cesiumjs.cs.core.options.TimeIntervalOptions;
import org.cesiumjs.cs.core.providers.CesiumTerrainProvider;
import org.cesiumjs.cs.core.providers.options.CesiumTerrainProviderOptions;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.PathGraphics;
import org.cesiumjs.cs.datasources.graphics.PointGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.PathGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.PointGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.*;
import org.cesiumjs.cs.datasources.properties.options.PolylineGlowMaterialPropertyOptions;
import org.cesiumjs.cs.datasources.properties.options.SampledPropertyInterpolationOptions;
import org.cesiumjs.cs.js.JsDate;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Interpolation extends AbstractExample {
    private ViewerPanel csVPanel;

    private JulianDate _start;
    private JulianDate _stop;
    private Entity _entity;

    @Inject
    public Interpolation(ShowcaseExampleStore store) {
        super("Interpolation", "Interpolation example", new String[]{"Showcase", "Cesium", "3d", "Interpolation", "Timeline", "Interval"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();


        csVPanel.getViewer().scene().globe.enableLighting = false;
        CesiumTerrainProviderOptions cesiumTerrainProviderOptions = new CesiumTerrainProviderOptions();
        cesiumTerrainProviderOptions.url = "https://assets.agi.com/stk-terrain/world";
        cesiumTerrainProviderOptions.requestWaterMask = true;
        cesiumTerrainProviderOptions.requestVertexNormals = true;
        csVPanel.getViewer().terrainProvider = new CesiumTerrainProvider(cesiumTerrainProviderOptions);

        csVPanel.getViewer().scene().globe.depthTestAgainstTerrain = true;

        Math.setRandomNumberSeed(3);

        _start = JulianDate.fromDate(new JsDate(2015, 2, 25, 16));
        _stop = JulianDate.addSeconds(_start, 360, new JulianDate());

        csVPanel.getViewer().clock().startTime = _start.clone();
        csVPanel.getViewer().clock().stopTime = _stop.clone();
        csVPanel.getViewer().clock().currentTime = _start.clone();
        csVPanel.getViewer().clock().clockRange = ClockRange.LOOP_STOP();
        csVPanel.getViewer().clock().multiplier = 10;

        csVPanel.getViewer().timeline().zoomTo(_start, _stop);

        PositionProperty position = computeCirclularFlight(-112.110693, 36.0994841, 0.03);
        TimeIntervalOptions timeIntervalOptions = new TimeIntervalOptions();
        timeIntervalOptions.start = _start;
        timeIntervalOptions.stop = _stop;

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.gltf");
        modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(64);

        PolylineGlowMaterialPropertyOptions polylineGlowMaterialPropertyOptions = new PolylineGlowMaterialPropertyOptions();
        polylineGlowMaterialPropertyOptions.glowPower = new ConstantProperty<>(0.1);
        polylineGlowMaterialPropertyOptions.color = new ConstantProperty<>(Color.YELLOW());
        PathGraphicsOptions pathGraphicsOptions = new PathGraphicsOptions();
        pathGraphicsOptions.resolution = new ConstantProperty<>(1);
        pathGraphicsOptions.material = new PolylineGlowMaterialProperty(polylineGlowMaterialPropertyOptions);
        pathGraphicsOptions.width = new ConstantProperty<>(10);

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.availability = new TimeIntervalCollection(new TimeInterval[] {new TimeInterval(timeIntervalOptions)});
        entityOptions.position = position;
        entityOptions.orientation = new VelocityOrientationProperty(position);
        entityOptions.model = new ModelGraphics(modelGraphicsOptions);
        entityOptions.path = new PathGraphics(pathGraphicsOptions);
        _entity = csVPanel.getViewer().entities().add(entityOptions);

        ListBox interpolationsLBox = new ListBox();
        interpolationsLBox.addItem("Interpolation: Linear Approximation", "0");
        interpolationsLBox.addItem("Interpolation: Lagrange Polynomial Approximation", "1");
        interpolationsLBox.addItem("Interpolation: Hermite Polynomial Approximation", "2");
        interpolationsLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                ListBox source = (ListBox) changeEvent.getSource();
                SampledPropertyInterpolationOptions sampledPropertyInterpolationOptions = new SampledPropertyInterpolationOptions();
                switch (source.getSelectedValue()) {
                    case "0":
                        sampledPropertyInterpolationOptions.interpolationDegree = 1;
                        sampledPropertyInterpolationOptions.interpolationAlgorithm = LinearApproximation.instance();
                        ((SampledPositionProperty)_entity.position).setInterpolationOptions(sampledPropertyInterpolationOptions);
                        break;
                    case "1":
                        sampledPropertyInterpolationOptions.interpolationDegree = 5;
                        sampledPropertyInterpolationOptions.interpolationAlgorithm = LagrangePolynomialApproximation.instance();
                        ((SampledPositionProperty)_entity.position).setInterpolationOptions(sampledPropertyInterpolationOptions);
                        break;
                    case "2":
                        sampledPropertyInterpolationOptions.interpolationDegree = 2;
                        sampledPropertyInterpolationOptions.interpolationAlgorithm = HermitePolynomialApproximation.instance();
                        ((SampledPositionProperty)_entity.position).setInterpolationOptions(sampledPropertyInterpolationOptions);
                        break;
                    default:
                        break;
                }
            }
        });

        Button viewTopDownBtn = new Button("View Top Down");
        viewTopDownBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Viewer viewer = csVPanel.getViewer();
                viewer.trackedEntity = (Entity)JsObject.undefined();
                viewer.zoomTo(viewer.entities(), new HeadingPitchRange(0, Math.toRadians(-90), 0));

            }
        });
        Button viewSideBtn = new Button("View Side");
        viewSideBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Viewer viewer = csVPanel.getViewer();
                viewer.trackedEntity = (Entity)JsObject.undefined();
                viewer.zoomTo(viewer.entities(), new HeadingPitchRange(Math.toRadians(-90), Math.toRadians(-15), 7500.0));
            }
        });
        Button viewAircraftBtn = new Button("View Aircraft");
        viewAircraftBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Viewer viewer = csVPanel.getViewer();
                viewer.trackedEntity = _entity;
            }
        });

        HorizontalPanel btnHPanel = new HorizontalPanel();
        btnHPanel.setSpacing(5);
        btnHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        btnHPanel.add(interpolationsLBox);
        btnHPanel.add(viewTopDownBtn);
        btnHPanel.add(viewSideBtn);
        btnHPanel.add(viewAircraftBtn);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(btnHPanel, 20, 20);

        contentPanel.add(new HTML("<p>This example shows simple Cesium application</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Interpolation.txt";
        return sourceCodeURLs;
    }

    private PositionProperty computeCirclularFlight(double lon, double lat, double radius) {
        SampledPositionProperty property = new SampledPositionProperty();
        for (int i = 0; i <= 360; i += 45) {
            double radians = Math.toRadians(i);
            JulianDate time = JulianDate.addSeconds(_start, i, new JulianDate());
            Cartesian3 position = Cartesian3.fromDegrees(
                    lon + (radius * 1.5 * java.lang.Math.cos(radians)),
                    lat + (radius * java.lang.Math.sin(radians)),
                    Math.nextRandomNumber() * 500 + 1750);
            property.addSample(time, position);
            PointGraphicsOptions pointGraphicsOptions = new PointGraphicsOptions();
            pointGraphicsOptions.pixelSize = new ConstantProperty<>(8);
            pointGraphicsOptions.color = new ConstantProperty<>(Color.TRANSPARENT());
            pointGraphicsOptions.outlineColor = new ConstantProperty<>(Color.YELLOW());
            pointGraphicsOptions.outlineWidth = new ConstantProperty<>(3);
            EntityOptions entityOptions = new EntityOptions();
            entityOptions.position = new ConstantPositionProperty(position);
            entityOptions.point = new PointGraphics(pointGraphicsOptions);
            csVPanel.getViewer().entities().add(entityOptions);
        }
        return property;
    }
}
