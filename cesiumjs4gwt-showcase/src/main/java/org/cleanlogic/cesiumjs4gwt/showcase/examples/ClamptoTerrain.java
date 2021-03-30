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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.inject.Inject;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.*;
import org.cesiumjs.cs.datasources.graphics.options.*;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.*;
import org.cesiumjs.cs.datasources.properties.options.ImageMaterialPropertyOptions;
import org.cesiumjs.cs.datasources.properties.options.PolylineOutlineMaterialPropertyOptions;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.scene.enums.ClassificationType;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

/**
 * @author Serge Silaev aka iSergio
 */
public class ClamptoTerrain extends AbstractExample {
    private ViewerPanel csVPanel;

    @Inject
    public ClamptoTerrain(ShowcaseExampleStore store) {
        super("Clamp to Terrain", "Clamp primitives to the terrain.", new String[]{"Clamp", "Primitive", "Terrain"},
                store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.terrainProvider = Cesium.createWorldTerrain();
        csVPanel = new ViewerPanel(viewerOptions);

        csVPanel.getViewer().scene().globe.depthTestAgainstTerrain = true;

        ListBox primitiveLBox = new ListBox();
        primitiveLBox.setWidth("160px");
        primitiveLBox.addItem("Draw Point with Label", "0");
        primitiveLBox.addItem("Draw Billboard", "1");
        primitiveLBox.addItem("Draw Corridor", "2");
        primitiveLBox.addItem("Draw Polygon", "3");
        primitiveLBox.addItem("Draw Textured Polygon", "4");
        primitiveLBox.addItem("Draw Rectangle", "5");
        primitiveLBox.addItem("Draw Model", "6");
        primitiveLBox.addItem("Sample line positions and draw with depth test disabled", "7");
        primitiveLBox.addItem("Draw polyline on terrain", "8");
        primitiveLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                csVPanel.getViewer().entities().removeAll();
                ListBox source = (ListBox) event.getSource();
                switch (source.getSelectedValue()) {
                    case "0":
                        drawPointWithLabel();
                        break;
                    case "1":
                        drawBillboard();
                        break;
                    case "2":
                        drawCorridor();
                        break;
                    case "3":
                        drawPolygon();
                        break;
                    case "4":
                        drawTexturedPolygon();
                        break;
                    case "5":
                        drawRectangle();
                        break;
                    case "6":
                        drawModel();
                        break;
                    case "7":
                        drawSampleLine();
                        break;
                    case "8":
                        drawPolyline();
                        break;
                    default:
                        break;
                }
            }
        });

        FlexTable flexTable = new FlexTable();
        flexTable.setWidget(1, 0, primitiveLBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Clamp primitives to the terrain.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        drawPointWithLabel();
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ClamptoTerrain.txt";
        return sourceCodeURLs;
    }

    private void drawPointWithLabel() {
        PointGraphicsOptions pointGraphicsOptions = new PointGraphicsOptions();
        pointGraphicsOptions.color = new ConstantProperty<>(Color.SKYBLUE());
        pointGraphicsOptions.pixelSize = new ConstantProperty<>(10);
        pointGraphicsOptions.outlineColor = new ConstantProperty<>(Color.YELLOW());
        pointGraphicsOptions.outlineWidth = new ConstantProperty<>(3);
        pointGraphicsOptions.heightReference = new ConstantProperty<>(HeightReference.CLAMP_TO_GROUND());

        LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
        labelGraphicsOptions.text = new ConstantProperty<>("Clamped to ground");
        labelGraphicsOptions.heightReference = new ConstantProperty<>(HeightReference.CLAMP_TO_GROUND());
        labelGraphicsOptions.horizontalOrigin = new ConstantProperty<>(HorizontalOrigin.LEFT());
        labelGraphicsOptions.verticalOrigin = new ConstantProperty<>(VerticalOrigin.BASELINE());
        labelGraphicsOptions.fillColor = new ConstantProperty<>(Color.BLACK());
        labelGraphicsOptions.showBackground = new ConstantProperty<>(true);
        labelGraphicsOptions.backgroundColor = new ConstantProperty<>(new Color(1, 1, 1, 0.7));
        labelGraphicsOptions.backgroundPadding = new ConstantProperty<>(new Cartesian2(8, 4));
        labelGraphicsOptions.disableDepthTestDistance = new ConstantProperty<>(Double.POSITIVE_INFINITY); // draws the label
        // in front of
        // terrain

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-122.1958, 46.1915));
        entityOptions.point = new PointGraphics(pointGraphicsOptions);
        entityOptions.label = new LabelGraphics(labelGraphicsOptions);
        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(entityOptions);
    }

    private void drawBillboard() {
        BillboardGraphicsOptions billboardGraphicsOptions = new BillboardGraphicsOptions();
        billboardGraphicsOptions.image = new ConstantProperty<>(GWT.getModuleBaseURL() + "images/facility.gif");
        billboardGraphicsOptions.heightReference = new ConstantProperty<>(HeightReference.CLAMP_TO_GROUND());

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantProperty<>(Cartesian3.fromDegrees(-122.1958, 46.1915));
        entityOptions.billboard = new BillboardGraphics(billboardGraphicsOptions);

        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(entityOptions);
    }

    private void drawCorridor() {
        CorridorGraphicsOptions corridorGraphicsOptions = new CorridorGraphicsOptions();
        corridorGraphicsOptions.width = new ConstantProperty(2000.0);
        corridorGraphicsOptions.material = new ColorMaterialProperty(Color.GREEN().withAlpha(0.5f));
        corridorGraphicsOptions.positions = new ConstantProperty<>(
                Cartesian3.fromDegreesArray(new double[]{-122.19, 46.1914, -122.21, 46.21, -122.23, 46.21}));

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.corridor = new CorridorGraphics(corridorGraphicsOptions);

        csVPanel.getViewer().zoomTo(csVPanel.getViewer().entities().add(entityOptions));
    }

    private void drawPolygon() {
        PolygonGraphicsOptions polygonGraphicsOptions = new PolygonGraphicsOptions();
        polygonGraphicsOptions.hierarchy = new ConstantProperty<>(new PolygonHierarchy(
                new Cartesian3[]{new Cartesian3(-2358138.847340281, -3744072.459541374, 4581158.5714175375),
                        new Cartesian3(-2357231.4925370603, -3745103.7886602185, 4580702.9757762635),
                        new Cartesian3(-2355912.902205431, -3744249.029778454, 4582402.154378103),
                        new Cartesian3(-2357208.0209552636, -3743553.4420488174, 4581961.863286629)}));
        polygonGraphicsOptions.material = new ColorMaterialProperty(Color.BLUE().withAlpha(0.5f));

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.polygon = new PolygonGraphics(polygonGraphicsOptions);

        csVPanel.getViewer().zoomTo(csVPanel.getViewer().entities().add(entityOptions));
    }

    private void drawTexturedPolygon() {
        if (!Entity.supportsMaterialsforEntitiesOnTerrain(csVPanel.getViewer().scene())) {
            Window.alert("Terrain Entity materials are not supported on this platform");
            return;
        }

        ImageMaterialPropertyOptions imageMaterialPropertyOptions = new ImageMaterialPropertyOptions();
        imageMaterialPropertyOptions.image = new ConstantProperty<>(
                GWT.getModuleBaseURL() + "images/Cesium_Logo_Color.jpg");

        PolygonGraphicsOptions polygonGraphicsOptions = new PolygonGraphicsOptions();
        polygonGraphicsOptions.hierarchy = new ConstantProperty<>(new PolygonHierarchy(
                new Cartesian3[]{new Cartesian3(-2358138.847340281, -3744072.459541374, 4581158.5714175375),
                        new Cartesian3(-2357231.4925370603, -3745103.7886602185, 4580702.9757762635),
                        new Cartesian3(-2355912.902205431, -3744249.029778454, 4582402.154378103),
                        new Cartesian3(-2357208.0209552636, -3743553.4420488174, 4581961.863286629)}));
        polygonGraphicsOptions.material = new ImageMaterialProperty(imageMaterialPropertyOptions);
        polygonGraphicsOptions.stRotation = new ConstantProperty<>(Math.toRadians(45));
        polygonGraphicsOptions.classificationType = new ConstantProperty<>(ClassificationType.TERRAIN());

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.polygon = new PolygonGraphics(polygonGraphicsOptions);

        csVPanel.getViewer().zoomTo(csVPanel.getViewer().entities().add(entityOptions));
    }

    private void drawRectangle() {
        RectangleGraphicsOptions rectangleGraphicsOptions = new RectangleGraphicsOptions();
        rectangleGraphicsOptions.coordinates = new ConstantProperty<>(Rectangle.fromDegrees(-122.3, 46.0, -122.0, 46.3));
        rectangleGraphicsOptions.material = new ColorMaterialProperty(Color.RED().withAlpha(0.5f));

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.rectangle = new RectangleGraphics(rectangleGraphicsOptions);

        csVPanel.getViewer().zoomTo(csVPanel.getViewer().entities().add(entityOptions));
    }

    private void drawModel() {
        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(
                GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb");
        modelGraphicsOptions.heightReference = new ConstantProperty<>(HeightReference.CLAMP_TO_GROUND());
        modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(128);
        modelGraphicsOptions.maximumScale = new ConstantProperty<>(100);

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-122.1958, 46.1915));
        entityOptions.model = new ModelGraphics(modelGraphicsOptions);

        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(entityOptions);
    }

    private void drawSampleLine() {
        int length = 1000;

        double startLon = Math.toRadians(86.953793);
        double endLon = Math.toRadians(86.896497);

        double lat = Math.toRadians(27.988257);

        Cartographic[] terrainSamplePositions = new Cartographic[length];
        for (int i = 0; i < length; ++i) {
            double lon = Math.lerp(endLon, startLon, (double) i / ((double) length - 1.));
            Cartographic position = new Cartographic(lon, lat);
            terrainSamplePositions[i] = position;
        }

        Cesium.sampleTerrainMostDetailed(csVPanel.getViewer().terrainProvider, terrainSamplePositions)
                .then(new Fulfill<Cartographic[]>() {
                    @Override
                    public void onFulfilled(Cartographic[] samples) {
                        double offset = 10.0;
                        for (Cartographic sample : samples) {
                            sample.height += offset;
                        }

                        PolylineGraphicsOptions polylineGraphicsOptions = new PolylineGraphicsOptions();
                        polylineGraphicsOptions.positions = new ConstantProperty<>(
                                Ellipsoid.WGS84().cartographicArrayToCartesianArray(samples));
                        polylineGraphicsOptions.followSurface = new ConstantProperty<>(false);
                        polylineGraphicsOptions.width = new ConstantProperty<>(5.0);

                        PolylineOutlineMaterialPropertyOptions polylineOutlineMaterialPropertyOptions = new PolylineOutlineMaterialPropertyOptions();
                        polylineOutlineMaterialPropertyOptions.color = new ConstantProperty<>(Color.ORANGE());
                        polylineOutlineMaterialPropertyOptions.outlineWidth = new ConstantProperty<>(2);
                        polylineOutlineMaterialPropertyOptions.outlineColor = new ConstantProperty<>(Color.BLACK());
                        polylineGraphicsOptions.material = new PolylineOutlineMaterialProperty(
                                polylineOutlineMaterialPropertyOptions);

                        polylineOutlineMaterialPropertyOptions = new PolylineOutlineMaterialPropertyOptions();
                        polylineOutlineMaterialPropertyOptions.color = new ConstantProperty<>(Color.RED());
                        polylineOutlineMaterialPropertyOptions.outlineWidth = new ConstantProperty<>(2);
                        polylineOutlineMaterialPropertyOptions.outlineColor = new ConstantProperty<>(Color.BLACK());
                        polylineGraphicsOptions.depthFailMaterial = new PolylineOutlineMaterialProperty(
                                polylineOutlineMaterialPropertyOptions);

                        EntityOptions entityOptions = new EntityOptions();
                        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);

                        csVPanel.getViewer().entities().add(entityOptions);

                        Cartesian3 target = new Cartesian3(300770.50872389384, 5634912.131394585, 2978152.2865545116);
                        csVPanel.getViewer().camera.lookAt(target,
                                new Cartesian3(6344.974098678562, -793.3419798081741, 2499.9508860763162));
                        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
                    }
                });
    }

    private void drawPolyline() {
        if (!Entity.supportsPolylinesOnTerrain(csVPanel.getViewer().scene())) {
            Window.alert("Polylines on terrain are not supported on this platform");
            return;
        }

        PolylineOutlineMaterialPropertyOptions polylineOutlineMaterialPropertyOptions = new PolylineOutlineMaterialPropertyOptions();
        polylineOutlineMaterialPropertyOptions.color = new ConstantProperty<>(Color.ORANGE());
        polylineOutlineMaterialPropertyOptions.outlineWidth = new ConstantProperty<>(2);
        polylineOutlineMaterialPropertyOptions.outlineColor = new ConstantProperty<>(Color.BLACK());

        PolylineGraphicsOptions polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.positions = new ConstantProperty<>(
                Cartesian3.fromDegreesArray(new double[]{86.953793, 27.928257, 86.953793, 27.988257, 86.896497, 27.988257}));
        polylineGraphicsOptions.clampToGround = new ConstantProperty<>(true);
        polylineGraphicsOptions.width = new ConstantProperty<>(5.0);
        polylineGraphicsOptions.material = new PolylineOutlineMaterialProperty(polylineOutlineMaterialPropertyOptions);

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);

        csVPanel.getViewer().entities().add(entityOptions);

        Cartesian3 target = new Cartesian3(300770.50872389384, 5634912.131394585, 2978152.2865545116);
        Cartesian3 offset = new Cartesian3(6344.974098678562, -793.3419798081741, 2499.9508860763162);
        csVPanel.getViewer().camera.lookAt(target, offset);
        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
    }
}