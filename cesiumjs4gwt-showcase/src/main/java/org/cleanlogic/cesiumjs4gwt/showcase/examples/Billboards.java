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

package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.BillboardGraphics;
import org.cesiumjs.cs.datasources.graphics.options.BillboardGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsImage;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class Billboards extends AbstractExample {
    private ViewerPanel csVPanel = null;
    private TerrainProvider terrainProvider = null;

    @Inject
    public Billboards(ShowcaseExampleStore store) {
        super("Billboards", "Add billboard images and markers to the scene",
                new String[]{"Showcase", "Cesium", "3d", "Billboards", "Promise"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();
        addBillboard();

        ListBox billboardsLBox = new ListBox();
        billboardsLBox.addItem("Add billboard", "0");
        billboardsLBox.addItem("Set billboard properties at creation", "1");
        billboardsLBox.addItem("Change billboard properties", "2");
        billboardsLBox.addItem("Size billboard in meters", "3");
        billboardsLBox.addItem("Add multiple billboards", "4");
        billboardsLBox.addItem("Scale by viewer distance", "5");
        billboardsLBox.addItem("Fade by viewer distance", "6");
        billboardsLBox.addItem("Offset by viewer distance", "7");
        billboardsLBox.addItem("Add marker billboards", "8");
        billboardsLBox.addItem("Disable the depth test when clamped to ground", "9");
        billboardsLBox.addChangeHandler(changeEvent -> {
            ListBox source = (ListBox) changeEvent.getSource();
            reset();
            switch (source.getSelectedValue()) {
                case "0":
                    addBillboard();
                    break;
                case "1":
                    setBillboardProperties();
                    break;
                case "2":
                    changeBillboardProperties();
                    break;
                case "3":
                    sizeBillboardInMeters();
                    break;
                case "4":
                    addMultipleBillboards();
                    break;
                case "5":
                    scaleByDistance();
                    break;
                case "6":
                    fadeByDistance();
                    break;
                case "7":
                    offsetByDistance();
                    break;
                case "8":
                    addMarkerBillboards();
                    break;
                case "9":
                    disableDepthTest();
                    break;
                default:
                    break;
            }
        });

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(billboardsLBox, 20, 20);

        contentPanel.add(new HTML("<p>Add billboard images and markers to the scene.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Billboards.txt";
        return sourceCodeURLs;
    }

    private void addBillboard() {
        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png");
        BillboardGraphics billboardGraphics = new BillboardGraphics(billboardGraphicsOptions);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        entityOptions.billboard = billboardGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));
    }

    private void setBillboardProperties() {
        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png"); // default:
        // undefined
        billboardGraphicsOptions.show = new ConstantProperty<>(true); // default
        billboardGraphicsOptions.pixelOffset = new ConstantProperty<>(new Cartesian2(0, -50)); // default: (0, 0)
        billboardGraphicsOptions.eyeOffset = new ConstantProperty<>(new Cartesian3(0, 0, 0)); // default
        billboardGraphicsOptions.horizontalOrigin = new ConstantProperty<>(HorizontalOrigin.CENTER());// default
        billboardGraphicsOptions.verticalOrigin = new ConstantProperty<>(VerticalOrigin.BOTTOM()); // default: CENTER
        billboardGraphicsOptions.scale = new ConstantProperty<>(2.0); // default: 1.0
        billboardGraphicsOptions.color = new ConstantProperty<>(Color.LIME()); // default: WHITE
        billboardGraphicsOptions.rotation = new ConstantProperty<>(Math.PI_OVER_FOUR()); // default: 0.0
        billboardGraphicsOptions.alignedAxis = new ConstantProperty<>(Cartesian3.ZERO()); // default
        billboardGraphicsOptions.width = new ConstantProperty<>(100.); // default: undefined
        billboardGraphicsOptions.height = new ConstantProperty<>(25.); // default: undefined
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        entityOptions.billboard = new BillboardGraphics(billboardGraphicsOptions);
        csVPanel.getViewer().entities().add(new Entity(entityOptions));
    }

    private void changeBillboardProperties() {
        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png");
        BillboardGraphics billboardGraphics = new BillboardGraphics(billboardGraphicsOptions);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883, 300000.0));
        entityOptions.billboard = billboardGraphics;
        Entity entity = csVPanel.getViewer().entities().add(new Entity(entityOptions));
        entity.billboard.scale = new ConstantProperty<>(3.0);
        entity.billboard.color = new ConstantProperty<>(Color.WHITE().withAlpha(0.25f));
    }

    private void sizeBillboardInMeters() {
        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png");
        billboardGraphicsOptions.sizeInMeters = new ConstantProperty<>(true);
        BillboardGraphics billboardGraphics = new BillboardGraphics(billboardGraphicsOptions);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        entityOptions.billboard = billboardGraphics;
        Entity entity = csVPanel.getViewer().entities().add(new Entity(entityOptions));
        csVPanel.getViewer().zoomTo(entity);
    }

    private void addMultipleBillboards() {
        String logoUrl = GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png";
        String facilityUrl = GWT.getModuleBaseURL() + "images/facility.gif";

        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(logoUrl);
        BillboardGraphics billboardGraphics = new BillboardGraphics(billboardGraphicsOptions);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        entityOptions.billboard = billboardGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(facilityUrl);
        billboardGraphics = new BillboardGraphics(billboardGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-80.50, 35.14));
        entityOptions.billboard = billboardGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(facilityUrl);
        billboardGraphics = new BillboardGraphics(billboardGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-80.12, 25.46));
        entityOptions.billboard = billboardGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));
    }

    private void scaleByDistance() {
        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/facility.gif");
        billboardGraphicsOptions.scaleByDistance = new ConstantProperty<>(new NearFarScalar(1.5e2, 2.0, 1.5e7, 0.5));
        BillboardGraphics billboardGraphics = new BillboardGraphics(billboardGraphicsOptions);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        entityOptions.billboard = billboardGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));
    }

    private void fadeByDistance() {
        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png");
        billboardGraphicsOptions.translucencyByDistance = new ConstantProperty<>(new NearFarScalar(1.5e2, 2.0, 1.5e7, 0.5));
        BillboardGraphics billboardGraphics = new BillboardGraphics(billboardGraphicsOptions);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        entityOptions.billboard = billboardGraphics;
        csVPanel.getViewer().entities().add(new Entity(entityOptions));
    }

    private void offsetByDistance() {
        Resource.fetchImage(GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png").then(
                logoImg -> {
                    Resource.fetchImage(GWT.getModuleBaseURL() + "images/facility.gif").then(
                            facilityImg -> {
                                createFacility(logoImg, facilityImg);
                            },
                            value -> LOGGER.info("Facility not loaded")
                    );
                },
                value -> LOGGER.info("facility imagery not loaded")
        );
    }

    private void addMarkerBillboards() {
        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/whiteShapes.png");
        billboardGraphicsOptions.imageSubRegion = new ConstantProperty<>(new BoundingRectangle(49, 43, 18, 18));
        billboardGraphicsOptions.color = new ConstantProperty<>(Color.LIME());
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.billboard = new BillboardGraphics(billboardGraphicsOptions);
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/whiteShapes.png");
        billboardGraphicsOptions.imageSubRegion = new ConstantProperty<>(new BoundingRectangle(61, 23, 18, 18));
        billboardGraphicsOptions.color = new ConstantProperty<>(new Color(0, 0.5, 1.0, 1.0));
        entityOptions = new EntityOptions();
        entityOptions.billboard = new BillboardGraphics(billboardGraphicsOptions);
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-84.0, 39.0));
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/whiteShapes.png");
        billboardGraphicsOptions.imageSubRegion = new ConstantProperty<>(new BoundingRectangle(67, 80, 14, 14));
        billboardGraphicsOptions.color = new ConstantProperty<>(new Color(0.5, 0.9, 1.0, 1.0));
        entityOptions = new EntityOptions();
        entityOptions.billboard = new BillboardGraphics(billboardGraphicsOptions);
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-70.0, 41.0));
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/whiteShapes.png");
        billboardGraphicsOptions.imageSubRegion = new ConstantProperty<>(new BoundingRectangle(27, 103, 22, 22));
        billboardGraphicsOptions.color = new ConstantProperty<>(Color.RED());
        entityOptions = new EntityOptions();
        entityOptions.billboard = new BillboardGraphics(billboardGraphicsOptions);
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-73.0, 37.0));
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/whiteShapes.png");
        billboardGraphicsOptions.imageSubRegion = new ConstantProperty<>(new BoundingRectangle(105, 105, 18, 18));
        billboardGraphicsOptions.color = new ConstantProperty<>(Color.YELLOW());
        entityOptions = new EntityOptions();
        entityOptions.billboard = new BillboardGraphics(billboardGraphicsOptions);
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-79.0, 35.0));
        csVPanel.getViewer().entities().add(new Entity(entityOptions));
    }

    private void reset() {
        csVPanel.getViewer().camera.flyHome(0);
        csVPanel.getViewer().entities().removeAll();
        if (terrainProvider != null) {
            csVPanel.getViewer().scene().globe.terrainProvider = terrainProvider;
            terrainProvider = null;
            csVPanel.getViewer().scene().globe.depthTestAgainstTerrain = false;
        }
    }

    private void createFacility(JsImage logoImg, JsImage facilityImg) {
        int facilityHeight = facilityImg.height;

        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(facilityImg);
        billboardGraphicsOptions.horizontalOrigin = new ConstantProperty<>(HorizontalOrigin.CENTER());
        billboardGraphicsOptions.verticalOrigin = new ConstantProperty<>(VerticalOrigin.BOTTOM());
        BillboardGraphics billboardGraphics = new BillboardGraphics(billboardGraphicsOptions);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.billboard = billboardGraphics;
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        csVPanel.getViewer().entities().add(new Entity(entityOptions));

        billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(logoImg);
        billboardGraphicsOptions.horizontalOrigin = new ConstantProperty<>(HorizontalOrigin.CENTER());
        billboardGraphicsOptions.verticalOrigin = new ConstantProperty<>(VerticalOrigin.BOTTOM());
        billboardGraphicsOptions.pixelOffset = new ConstantProperty<>(new Cartesian2(0.0, -facilityHeight));
        billboardGraphicsOptions.pixelOffsetScaleByDistance = new ConstantProperty<>(
                new NearFarScalar(1.0e3, 1.0, 1.5e6, 0.0));
        billboardGraphicsOptions.translucencyByDistance = new ConstantProperty<>(
                new NearFarScalar(1.0e3, 1.0, 1.5e6, 0.1));
        billboardGraphics = new BillboardGraphics(billboardGraphicsOptions);
        entityOptions = new EntityOptions();
        entityOptions.billboard = billboardGraphics;
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-75.59777, 40.03883));
        csVPanel.getViewer().entities().add(new Entity(entityOptions));
    }

    private void disableDepthTest() {
        terrainProvider = csVPanel.getViewer().terrainProvider;
        csVPanel.getViewer().terrainProvider = Cesium.createWorldTerrain();
        csVPanel.getViewer().scene().globe.depthTestAgainstTerrain = true;

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-122.1958, 46.1915));
        BillboardGraphicsOptions graphicsOptions = new BillboardGraphicsOptions();
        graphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/facility.gif");
        graphicsOptions.heightReference = new ConstantProperty<>(HeightReference.CLAMP_TO_GROUND());
        graphicsOptions.disableDepthTestDistance = new ConstantProperty<>(Double.POSITIVE_INFINITY);
        entityOptions.billboard = new BillboardGraphics(graphicsOptions);
        csVPanel.getViewer().entities().add(entityOptions);

        csVPanel.getViewer().scene().camera().setView(new ViewOptions()
                .setDestination(new Cartesian3(-2357576.243142461, -3744417.5604860787, 4581807.855903771))
                .setOrientation(new HeadingPitchRoll(5.9920811504170475, -0.6032820429886212, 6.28201303164098)));
    }
}
