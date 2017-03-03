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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.providers.CesiumTerrainProvider;
import org.cesiumjs.cs.core.providers.EllipsoidTerrainProvider;
import org.cesiumjs.cs.core.providers.GeoserverTerrainProvider;
import org.cesiumjs.cs.core.providers.VRTheWorldTerrainProvider;
import org.cesiumjs.cs.core.providers.options.CesiumTerrainProviderOptions;
import org.cesiumjs.cs.core.providers.options.GeoserverTerrainProviderOptions;
import org.cesiumjs.cs.core.providers.options.VRTheWorldTerrainProviderOptions;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.BillboardGraphics;
import org.cesiumjs.cs.datasources.graphics.LabelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.BillboardGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.LabelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Terrain extends AbstractExample {
    private ViewerPanel csVPanel;
    private List<Cartographic> terrainSamplePositions;
    public CesiumTerrainProvider cesiumTerrainProviderMeshes;

    @Inject
    public Terrain(ShowcaseExampleStore store) {
        super("Terrain", "Visualize worldwide, high-resolution terrain", new String[]{"Showcase", "Cesium", "3d", "Terrain", "CesiumTerrain", "GeoserverTerrain", "Promise"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        CesiumTerrainProviderOptions cesiumTerrainProviderOptions = new CesiumTerrainProviderOptions();
        cesiumTerrainProviderOptions.url = "https://assets.agi.com/stk-terrain/world";
        cesiumTerrainProviderOptions.requestWaterMask = true;
        cesiumTerrainProviderOptions.requestVertexNormals = true;
        cesiumTerrainProviderMeshes = new CesiumTerrainProvider(cesiumTerrainProviderOptions);
        csVPanel.getViewer().terrainProvider = cesiumTerrainProviderMeshes;

        Cartesian3 target = new Cartesian3(300770.50872389384, 5634912.131394585, 2978152.2865545116);
        Cartesian3 offset = new Cartesian3(6344.974098678562, -793.3419798081741, 2499.9508860763162);
        csVPanel.getViewer().camera.lookAt(target, offset);
        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());

        ListBox terrainsLBox = new ListBox();
        terrainsLBox.setWidth("130px");
        terrainsLBox.addItem("CesiumTerrainProvider - STK World Terrain", "0");
        terrainsLBox.addItem("CesiumTerrainProvider - STK World Terrain - no effects", "1");
        terrainsLBox.addItem("CesiumTerrainProvider - STK World Terrain w/ Lighting", "2");
        terrainsLBox.addItem("CesiumTerrainProvider - STK World Terrain w/ Water", "3");
        terrainsLBox.addItem("EllipsoidTerrainProvider", "4");
        terrainsLBox.addItem("VRTheWorldTerrainProvider", "5");
        terrainsLBox.addItem("GeoserverTerrainProvider", "6");

        terrainsLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                ListBox source = (ListBox) changeEvent.getSource();
                switch (source.getSelectedValue()) {
                    case "0": {
                        csVPanel.getViewer().terrainProvider = cesiumTerrainProviderMeshes;
                        csVPanel.getViewer().scene().globe.enableLighting = true;
                    } break;
                    case "1": {
                        CesiumTerrainProviderOptions options = new CesiumTerrainProviderOptions();
                        options.url = "https://assets.agi.com/stk-terrain/world";
                        csVPanel.getViewer().terrainProvider = new CesiumTerrainProvider(options);
                    } break;
                    case "2": {
                        CesiumTerrainProviderOptions options = new CesiumTerrainProviderOptions();
                        options.url = "https://assets.agi.com/stk-terrain/world";
                        options.requestVertexNormals = true;
                        csVPanel.getViewer().terrainProvider = new CesiumTerrainProvider(options);
                        csVPanel.getViewer().scene().globe.enableLighting = true;
                    } break;
                    case "3": {
                        CesiumTerrainProviderOptions options = new CesiumTerrainProviderOptions();
                        options.url = "https://assets.agi.com/stk-terrain/world";
                        options.requestWaterMask = true;
                        csVPanel.getViewer().terrainProvider = new CesiumTerrainProvider(options);
                        csVPanel.getViewer().scene().globe.enableLighting = true;
                    } break;
                    case "4": {
                        csVPanel.getViewer().terrainProvider = new EllipsoidTerrainProvider();
                    } break;
                    case "5": {
                        VRTheWorldTerrainProviderOptions options = new VRTheWorldTerrainProviderOptions();
                        options.url = "http://www.vr-theworld.com/vr-theworld/tiles1.0.0/73/";
                        csVPanel.getViewer().terrainProvider = new VRTheWorldTerrainProvider(options);
                    } break;
                    case "6": {
                        GeoserverTerrainProviderOptions options = new GeoserverTerrainProviderOptions();
                        options.url = "http://sergeserver.noip.me/geobase-portal/ows";
                        options.layerName = "geoserver:geobase:SRTM90";
                        options.styleName = "geobase:grayToColor";
                        csVPanel.getViewer().terrainProvider = new GeoserverTerrainProvider(options);
                    } break;
                    default: break;
                }
            }
        });

        ListBox targetsLBox = new ListBox();
        targetsLBox.addItem("Mount Everest", "0");
        targetsLBox.addItem("Half Dome", "1");
        targetsLBox.addItem("San Francisco Bay", "2");
        targetsLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                ListBox source = (ListBox) changeEvent.getSource();
                switch (source.getSelectedValue()) {
                    case "0": {
                        Cartesian3 target = new Cartesian3(300770.50872389384, 5634912.131394585, 2978152.2865545116);
                        Cartesian3 offset = new Cartesian3(6344.974098678562, -793.3419798081741, 2499.9508860763162);
                        csVPanel.getViewer().camera.lookAt(target, offset);
                        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
                    } break;
                    case "1": {
                        Cartesian3 target = new Cartesian3(-2489625.0836225147, -4393941.44443024, 3882535.9454173897);
                        Cartesian3 offset = new Cartesian3(-6857.40902037546, 412.3284835694358, 2147.5545426812023);
                        csVPanel.getViewer().camera.lookAt(target, offset);
                        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
                    } break;
                    case "2": {
                        Cartesian3 target = new Cartesian3(-2708814.85583248, -4254159.450845907, 3891403.9457429945);
                        Cartesian3 offset = new Cartesian3(70642.66030209465, -31661.517948317807, 35505.179997143336);
                        csVPanel.getViewer().camera.lookAt(target, offset);
                        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
                    }
                    default: break;
                }
            }
        });

        ToggleButton lightingTBtn = new ToggleButton("Toggle Lighting");
        lightingTBtn.setWidth("130px");
        lightingTBtn.setValue(true);
        lightingTBtn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
                csVPanel.getViewer().scene().globe.enableLighting = !csVPanel.getViewer().scene().globe.enableLighting;
            }
        });

        ToggleButton fogTBtn = new ToggleButton("Toggle Fog");
        fogTBtn.setWidth("130px");
        fogTBtn.setValue(true);
        fogTBtn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
                csVPanel.getViewer().scene().fog.enabled = !csVPanel.getViewer().scene().fog.enabled;
            }
        });
        Button sampleBtn = new Button("Sample Everest Terrain");
        sampleBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                int gridWidth = 41;
                int gridHeight = 41;
                double everestLatitude = Math.toRadians(27.988257);
                double everestLongitude = Math.toRadians(86.925145);
                double rectangleHalfSize = 0.005;
                Rectangle e = new Rectangle(everestLongitude - rectangleHalfSize, everestLatitude - rectangleHalfSize, everestLongitude + rectangleHalfSize, everestLatitude + rectangleHalfSize);
                terrainSamplePositions = new ArrayList<>();
                for (int y = 0; y < gridHeight; ++y) {
                    for (int x = 0; x < gridWidth; ++x) {
                        double lon = Math.lerp(e.west, e.east, (double)x / (gridWidth -1.));
                        double lat = Math.lerp(e.south, e.north, (double)y / (gridHeight - 1.));
                        Cartographic position = new Cartographic(lon, lat);
                        terrainSamplePositions.add(position);

                    }
                }

                Promise<Cartographic[], Void> promise = Cesium.sampleTerrain(csVPanel.getViewer().terrainProvider, 9, terrainSamplePositions.toArray(new Cartographic[terrainSamplePositions.size()]));
                promise.then(new Fulfill<Cartographic[]>() {
                    @Override
                    public void onFulfilled(Cartographic[] value) {
                        sampleTerrainSuccess();
                    }
                });
            }
        });

        VerticalPanel vPanel = new VerticalPanel();
        vPanel.add(targetsLBox);
        vPanel.add(terrainsLBox);
        vPanel.add(lightingTBtn);
        vPanel.add(fogTBtn);
        vPanel.add(sampleBtn);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(vPanel, 20, 20);

        contentPanel.add(new HTML("<p>Visualize worldwide, high-resolution terrain.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Terrain.txt";
        return sourceCodeURLs;
    }

    private void sampleTerrainSuccess() {
        Ellipsoid ellipsoid = Ellipsoid.WGS84();
        csVPanel.getViewer().scene().globe.depthTestAgainstTerrain = true;

        csVPanel.getViewer().entities().suspendEvents();
        csVPanel.getViewer().entities().removeAll();

        for (Cartographic position : terrainSamplePositions) {
            BigDecimal bd = new BigDecimal(position.height).setScale(1, RoundingMode.HALF_EVEN);

            BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
            billboardGraphicsOptions.verticalOrigin = new ConstantProperty<>(VerticalOrigin.BOTTOM());
            billboardGraphicsOptions.scale = new ConstantProperty<>(0.7);
            billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/facility.gif");

            LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
            labelGraphicsOptions.text = new ConstantProperty<>(bd.toString());
            labelGraphicsOptions.horizontalOrigin = new ConstantProperty<>(HorizontalOrigin.CENTER());//HorizontalOrigin.CENTER());
            labelGraphicsOptions.scale = new ConstantProperty<>(0.3);
            labelGraphicsOptions.pixelOffset = new ConstantProperty<>(new Cartesian2(0, -14));
            labelGraphicsOptions.fillColor = new ConstantProperty<>(Color.RED());
            labelGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());

            EntityOptions entityOptions = new EntityOptions();
            entityOptions.name = bd.toString();
            entityOptions.position = new ConstantPositionProperty(ellipsoid.cartographicToCartesian(position));
            entityOptions.billboard = new BillboardGraphics(billboardGraphicsOptions);
            entityOptions.label = new LabelGraphics(labelGraphicsOptions);
            csVPanel.getViewer().entities().add(new Entity(entityOptions));
        }

        csVPanel.getViewer().entities().resumeEvents();
    }
}
