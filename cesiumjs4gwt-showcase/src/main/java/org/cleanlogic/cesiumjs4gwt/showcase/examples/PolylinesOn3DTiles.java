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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.PolylineGraphics;
import org.cesiumjs.cs.datasources.graphics.options.PolylineGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.datasources.properties.PolylineDashMaterialProperty;
import org.cesiumjs.cs.datasources.properties.options.PolylineDashMaterialPropertyOptions;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.ClassificationType;
import org.cesiumjs.cs.scene.options.Cesium3DTilesetOptions;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class PolylinesOn3DTiles extends AbstractExample {
    Scene scene;

    Cesium3DTileset powerplant;
    Entity pipes;

    Cesium3DTileset building;
    Entity route;

    @Inject
    public PolylinesOn3DTiles(ShowcaseExampleStore store) {
        super("Polylines on 3D Tiles", "Display polylines on BIM and Photogrammetry 3D Tiles.",
                new String[]{"BIM", "Photogrammetry", "3D Tiles", "Polylines"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        scene = csVPanel.getViewer().scene();

        Cesium3DTilesetOptions tilesetOptions = Cesium3DTilesetOptions.create(IonResource.fromAssetId(8564));
        tilesetOptions.show = false;

        powerplant = (Cesium3DTileset) scene.primitives().add(new Cesium3DTileset(tilesetOptions));

        PolylineDashMaterialPropertyOptions polylineDashMaterialPropertyOptions = new PolylineDashMaterialPropertyOptions();
        polylineDashMaterialPropertyOptions.color = new ConstantProperty<>(Color.YELLOW());
        polylineDashMaterialPropertyOptions.dashLength = new ConstantProperty<>(20.0);

        PolylineGraphicsOptions polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.positions = new ConstantProperty<>(
                Cartesian3.fromDegreesArray(new double[]{-76.36053390920833, 34.949935893493596, -76.36055481641581,
                        34.94993589886988, -76.36055477047704, 34.94992280693651}));
        polylineGraphicsOptions.width = new ConstantProperty<>(6);
        polylineGraphicsOptions.material = new PolylineDashMaterialProperty(polylineDashMaterialPropertyOptions);
        polylineGraphicsOptions.show = new ConstantProperty<>(false);
        polylineGraphicsOptions.clampToGround = new ConstantProperty<>(true);
        polylineGraphicsOptions.classificationType = new ConstantProperty<>(ClassificationType.CESIUM_3D_TILE());

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);

        pipes = csVPanel.getViewer().entities().add(entityOptions);

        building = (Cesium3DTileset) scene.primitives()
                .add(new Cesium3DTileset(Cesium3DTilesetOptions.create(IonResource.fromAssetId(6074))));

        polylineDashMaterialPropertyOptions = new PolylineDashMaterialPropertyOptions();
        polylineDashMaterialPropertyOptions.color = new ConstantProperty<>(Color.YELLOW());

        polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.positions = new ConstantProperty<>(Cartesian3.fromDegreesArray(new double[]{
                -75.59604807301078, 40.03948512841901, -75.59644577413066, 40.039316280505446, -75.59584544997564,
                40.03846271524258, -75.59661425371488, 40.03814087821916, -75.59664726332451, 40.03818297772907}));
        polylineGraphicsOptions.width = new ConstantProperty<>(6);
        polylineGraphicsOptions.material = new PolylineDashMaterialProperty(polylineDashMaterialPropertyOptions);
        polylineGraphicsOptions.show = new ConstantProperty<>(false);
        polylineGraphicsOptions.clampToGround = new ConstantProperty<>(true);
        polylineGraphicsOptions.classificationType = new ConstantProperty<>(ClassificationType.CESIUM_3D_TILE());

        entityOptions = new EntityOptions();
        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);

        route = csVPanel.getViewer().entities().add(entityOptions);

        ListBox tileSetsLBox = new ListBox();
        tileSetsLBox.addItem("BIM", "0");
        tileSetsLBox.addItem("Photogrammetry", "1");
        tileSetsLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                ListBox source = (ListBox) event.getSource();

                ViewOptions viewOptions = new ViewOptions();
                if (source.getSelectedValue().equals("0")) {
                    building.show = false;
                    route.polyline.show = new ConstantProperty<>(false);
                    powerplant.show = true;
                    pipes.polyline.show = new ConstantProperty<>(true);

                    viewOptions.destinationPos = new Cartesian3(1234151.4883992162, -5086036.79436967, 3633328.4278331124);
                    viewOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(5.593695742186853, -1.0786797635545216,
                            6.27892466154778);
                } else if (source.getSelectedValue().equals("1")) {
                    building.show = true;
                    route.polyline.show = new ConstantProperty<>(true);
                    powerplant.show = false;
                    pipes.polyline.show = new ConstantProperty<>(false);

                    viewOptions.destinationPos = new Cartesian3(1216596.5376729995, -4736445.416889214, 4081406.990364228);
                    viewOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(5.153176564030707, -0.9701972964526693,
                            6.277883257569513);
                }
                scene.camera().setView(viewOptions);
            }
        });

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(tileSetsLBox, 20, 20);

        contentPanel.add(new HTML("<p>Display polylines on BIM and Photogrammetry 3D Tiles.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        powerplant.show = true;
        pipes.polyline.show = new ConstantProperty<>(true);
        ViewOptions viewOptions = new ViewOptions();
        viewOptions.destinationPos = new Cartesian3(1234151.4883992162, -5086036.79436967, 3633328.4278331124);
        viewOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(5.593695742186853, -1.0786797635545216,
                6.27892466154778);
        scene.camera().setView(viewOptions);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "PolylinesOn3DTiles.txt";
        return sourceCodeURLs;
    }
}