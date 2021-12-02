/*
 * Copyright 2021 iserge, Gis4Fun.
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

import com.google.gwt.core.client.*;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseClickEvent;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.*;
import org.cesiumjs.cs.scene.options.CameraFlyToOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class Tiles3DNextCDBYemen extends AbstractExample {
    private Viewer viewer;

    private Cesium3DTileFeature highlightedFeature = null;
    private Color highlightedOriginalColor = new Color();

    private Cesium3DTileFeature selectedFeature = null;
    private Color selectedOriginalColor = new Color();

    private boolean enablePicking = true;

    @Inject
    public Tiles3DNextCDBYemen(ShowcaseExampleStore store) {
        super("3D Tiles Next CDB Yemen",
                "Load a 3D Tile Next tileset converted from CDB",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "experimental"}, store, "1.88");
    }

    @Override
    public void buildPanel() {
        Cesium.ExperimentalFeatures.enableModelExperimental = true;

        ViewerPanel csVPanel = new ViewerPanel();
        viewer = csVPanel.getViewer();

        viewer.clock().currentTime = JulianDate.fromIso8601("2021-11-09T07:27:37.016064475348684937Z");
        Scene scene = viewer.scene();
        scene.light.intensity = 7.0;

        // 3D Tiles Next converted from CDB of Aden, Yemen (CDB provided by Presagis)
        Cesium3DTileset terrainTileset = (Cesium3DTileset) scene.primitives().add(Cesium3DTileset.create(IonResource.fromAssetId(667809)));

        Cesium3DTileset buildingsTileset = (Cesium3DTileset) scene.primitives().add(Cesium3DTileset.create(IonResource.fromAssetId(666747)));
        buildingsTileset.maximumScreenSpaceError = 12;

        CameraTransform tileset = new CameraTransform();
        tileset.destination = new Cartesian3(4397999.822774582, 4404502.67774069, 1397782.4709840622);
        tileset.direction = new Cartesian3(-0.29335588497705106, -0.6066709587467911, 0.7388454997917905);
        tileset.up = new Cartesian3(0.6240972421637774, 0.46391380837591956, 0.6287182283994301);

        CameraTransform airport = new CameraTransform();
        airport.destination = new Cartesian3(4394719.151490939, 4402317.401942875, 1406608.6602404779);
        airport.direction = new Cartesian3(0.4146699515908668, -0.8887814163588482, 0.1952342828060377);
        airport.up = new Cartesian3(0.8415067525520951, 0.4561872920946922, 0.28941240460723);

        CameraTransform crater = new CameraTransform();
        crater.destination = new Cartesian3(4398179.160380196, 4402518.469409466, 1399161.7612076725);
        crater.direction = new Cartesian3(-0.2800903637088597, -0.6348021519070498, 0.7201219452923355);
        crater.up = new Cartesian3(0.6319189548885261, 0.4427783126727723, 0.6361020360596605);

        CameraTransform port = new CameraTransform();
        port.destination = new Cartesian3(4399698.85724341, 4399019.639078034, 1405153.7766045567);
        port.direction = new Cartesian3(-0.5651458936543287, 0.17696574231117793, -0.8057873447342694);
        port.up = new Cartesian3(0.4886488937394081, 0.8587605935024302, -0.15411846642958343);

        buildingsTileset.readyPromise().then(t -> {
            Cartesian3 center = Cartesian3.fromDegrees(45.04192, 12.753525, 2000);
            double heading = Math.toRadians(50.0);
            double pitch = Math.toRadians(-20.0);
            double range = 5000.0;

            flyCameraTo(tileset, 0.);
        });

        // --- Style ---

        String[][] conditions = new String[][] {
                {"${HGT} !== undefined && ${HGT} < 5", "color('#f5fd2d')"},
                {"${HGT} !== undefined && ${HGT} >= 5 && ${HGT} < 10", "color('#d3a34a')"},
                {"${HGT} !== undefined && ${HGT} >= 10 && ${HGT} < 15", "color('#947e75')"},
                {"${HGT} !== undefined && ${HGT} >= 15 && ${HGT} < 20", "color('#565a9f')"},
                {"${HGT} !== undefined && ${HGT} > 20", "color('#223bc3')"},
                {"true", "color('white')"},
        };
        JsObject style = JsObject.create();
        style.setProperty("color", JsObject.create());
        style.getJsObject("color").setProperty("conditions", stringArrayToJsArrayString(conditions));
        Cesium3DTileStyle buildingStyle = new Cesium3DTileStyle(style);

        conditions = new String[][] {
                {"${name} === 'OCEAN'", "color('#436d9d')"},
                {"${name} === 'LAKE'", "color('#3987c9')"},
                {"${name} === 'CALCAREOUS'", "color('#BBB6B1')"},
                {"${name} === 'GRASS'", "color('#567d46')"},
                {"${name} === 'FOREST'", "color('green')"},
                {"${name} === 'CITY'", "color('lightgray')"},
                {"${name} === 'ASPHALTROAD'", "color('#434343')"},
                {"${name} === 'ASPHALT'", "color('#463d39')"},
                {"${name} === 'CONCRETE'", "color('#b9b4ab')"},
                {"${name} === 'DRYGROUND'", "color('#9B7653')"},
                {"${name} === 'WETGROUND'", "color('#5a4332')"},
                {"${name} === 'SAND'", "color('gold')"},
                {"true", "color('#9B7653')"},
        };
        style = JsObject.create();
        style.setProperty("color", JsObject.create());
        style.getJsObject("color").setProperty("conditions", stringArrayToJsArrayString(conditions));
        Cesium3DTileStyle terrainStyle = new Cesium3DTileStyle(style);

        // --- Picking ---

        ScreenSpaceEventHandler handler = new ScreenSpaceEventHandler(scene.canvas());

        DivElement metadataOverlay = RootPanel.get().getElement().getOwnerDocument().createDivElement();
        metadataOverlay.addClassName("backdrop");
        metadataOverlay.getStyle().setDisplay(Style.Display.NONE);
        metadataOverlay.getStyle().setPosition(Style.Position.ABSOLUTE);
        metadataOverlay.getStyle().setBottom(0., Style.Unit.PX);
        metadataOverlay.getStyle().setLeft(0., Style.Unit.PX);
//        nameOverlay.style["pointer-events"] = "none";
        metadataOverlay.getStyle().setPadding(4.0, Style.Unit.PX);
        metadataOverlay.getStyle().setBackgroundColor("#303030");
        metadataOverlay.getStyle().setWhiteSpace(Style.WhiteSpace.PRE_LINE);
        metadataOverlay.getStyle().setFontSize(16., Style.Unit.PX);
        metadataOverlay.getStyle().setBorderStyle(Style.BorderStyle.SOLID);

        csVPanel.getViewer().container().appendChild(metadataOverlay);

        handler.setInputAction(event -> {
            MouseMoveEvent movement = (MouseMoveEvent) event;
            if (enablePicking) {
                // If a feature was previously highlighted, undo the highlight
                if (Cesium.defined(highlightedFeature)) {
                    highlightedFeature.color = highlightedOriginalColor;
                    highlightedFeature = null;
                }

                PickedObject feature = scene.pick(movement.endPosition);
                boolean featurePicked = feature instanceof Cesium3DTileFeature;

                boolean isTerrainFeature = featurePicked && ((Cesium3DTileFeature) feature).hasProperty("substrates");
                boolean isBuildingFeature = featurePicked && ((Cesium3DTileFeature) feature).hasProperty("HGT");

                if (isTerrainFeature) {
                    metadataOverlay.getStyle().setDisplay(Style.Display.BLOCK);
                    metadataOverlay.getStyle().setBottom(viewer.canvas().getClientHeight() - movement.endPosition.y, Style.Unit.PX);
                    metadataOverlay.getStyle().setLeft(movement.endPosition.x, Style.Unit.PX);

                    StringBuilder tableHtmlScratch =
                            new StringBuilder("<table><thead><tr><td>Material:</td><th><tt>" +
                                    ((Cesium3DTileFeature) feature).getProperty("name") +
                                    "</tt></tr></thead><tbody>");

                    JsArrayString materialsScratch = (JsArrayString) (Object) ((Cesium3DTileFeature) feature).getProperty("substrates");
                    JsArrayString weightsScratch = (JsArrayString) (Object) ((Cesium3DTileFeature) feature).getProperty("weights");
                    tableHtmlScratch.append("<tr><td colspan='2' style='text-align: center;'><b>Substrates</b></td></tr>");
                    for (int i = 0; i < materialsScratch.length(); i++) {
                        tableHtmlScratch.append("<tr><td><tt>")
                                .append(materialsScratch.get(i).substring(3))
                                .append("</tt></td><td style='text-align: right;'><tt>")
                                .append(weightsScratch.get(i))
                                .append("%</tt></td></tr>");
                    }
                    tableHtmlScratch.append("</tbody></table>");
                    metadataOverlay.setInnerHTML(tableHtmlScratch.toString());
                } else {
                    metadataOverlay.getStyle().setDisplay(Style.Display.NONE);
                }

                if (isBuildingFeature) {
                    // Highlight the feature if it's not already selected.
                    if (feature != selectedFeature) {
                        highlightedFeature = (Cesium3DTileFeature) feature;
                        Color.clone(((Cesium3DTileFeature) feature).color, highlightedOriginalColor);
                        ((Cesium3DTileFeature) feature).color = Color.MAGENTA();
                    }
                }
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());

        handler.setInputAction(event -> {
            MouseClickEvent movement = (MouseClickEvent) event;
            // If a feature was previously selected, undo the highlight
            if (Cesium.defined(selectedFeature)) {
                selectedFeature.color = selectedOriginalColor;
                selectedFeature = null;
            }

            PickedObject feature = scene.pick(movement.position);
            boolean featurePicked = feature instanceof Cesium3DTileFeature;
            boolean isBuildingFeature = featurePicked && ((Cesium3DTileFeature) feature).hasProperty("HGT");

            if (isBuildingFeature) {
                // Select the feature if it's not already selected
                if (selectedFeature == feature) {
                    return;
                }
                selectedFeature = (Cesium3DTileFeature) feature;

                // Save the selected feature's original color
                if (feature == highlightedFeature) {
                    Color.clone(highlightedOriginalColor, selectedOriginalColor);
                    highlightedFeature = null;
                } else {
                    Color.clone(((Cesium3DTileFeature) feature).color, selectedOriginalColor);
                }
                ((Cesium3DTileFeature) feature).color = Color.LIME();

                StringBuilder tableHtmlScratch = new StringBuilder("<table class='cesium-infoBox-defaultTable'>");
                tableHtmlScratch.append("<tr><th colspan=2>Property Name</th><th>ID</th><th>Type</th><th>Value</th></tr><tbody>");
                JsObject metadataClass = JsObject.getObject(feature, "content").getJsObject("batchTable").getJsObject("_propertyTable").getJsObject("class");
                String[] propertyNames = ((Cesium3DTileFeature) feature).getPropertyNames();
                int length = propertyNames.length;
                for (int i = 0; i < length; ++i) {
                    String propertyName = propertyNames[i];

                    // Skip these properties, since they are always empty.
                    if (propertyName.equals("APID") || propertyName.equals("FACC") || propertyName.equals("RWID")) {
                        continue;
                    }

                    JsObject propertyValue = ((Cesium3DTileFeature) feature).getProperty(propertyName);
                    JsObject properties = metadataClass.getJsObject("properties");
                    JsObject property = properties.getJsObject(propertyName);

                    tableHtmlScratch.append("<tr style='font-family: monospace'><th style='min-width:200px'><a href='' style='text-decoration:none'>" +
                            property.getString("name") +
                            "</a></th><th><a href='' title='" +
                            property.getString("description") +
                            "' style='text-decoration:none'>ℹ️</a></th><th><b>" +
                            property.getString("id") +
                            "</b></th><td>" +
                            property.getString("componentType") +
                            "</td><td>" +
                            propertyValue +
                            "</td></tr>");
                }
                tableHtmlScratch.append("</tbody></table>");
                viewer.selectedEntity.description = new ConstantProperty<String>(tableHtmlScratch.toString());
            }
        }, ScreenSpaceEventType.LEFT_CLICK());

        ListBox tilesetBox = new ListBox();
        tilesetBox.addItem("Overview");
        tilesetBox.addItem("Airport");
        tilesetBox.addItem("Crater");
        tilesetBox.addItem("Port");
        tilesetBox.addChangeHandler(event -> {
            String value = ((ListBox) event.getSource()).getSelectedItemText();
            switch (value) {
                case "Overview": flyCameraTo(tileset, 2.); break;
                case "Airport": flyCameraTo(airport, 2.); break;
                case "Crater": flyCameraTo(crater, 2.); break;
                case "Port": flyCameraTo(port, 2.); break;
                default: break;
            }
        });

        ListBox styleBox = new ListBox();
        styleBox.addItem("No style");
        styleBox.addItem("Style buildings based on height");
        styleBox.addItem("Style terrain based on materials");
        styleBox.addChangeHandler(event -> {
            String value = ((ListBox) event.getSource()).getSelectedItemText();
            switch (value) {
                case "No style": {
                    resetHighlight();
                    buildingsTileset.style = null;
                    terrainTileset.style = null;
                    break;
                }
                case "Style buildings based on height": {
                    resetHighlight();
                    buildingsTileset.style = buildingStyle;
                    terrainTileset.style = null;
                    break;
                }
                case "Style terrain based on materials": {
                    buildingsTileset.style = null;
                    terrainTileset.style = terrainStyle;
                    break;
                }
                default: break;
            }
        });

        CheckBox enablePickingCBox = new CheckBox("Enable picking");
        enablePickingCBox.getElement().getStyle().setColor("white");
        enablePickingCBox.setWidth("100px");
        enablePickingCBox.setValue(this.enablePicking);
        enablePickingCBox.addValueChangeHandler(event -> enablePicking = event.getValue());

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(tilesetBox);
        hPanel.add(styleBox);
        hPanel.add(enablePickingCBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML(
                "<p>Load a 3D Tile Next tileset converted from CDB.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DNextCDBYemen.txt";
        return sourceCodeURLs;
    }

    private static class CameraTransform {
        protected Cartesian3 destination;
        protected Cartesian3 direction;
        protected Cartesian3 up;
    }

    private void flyCameraTo(CameraTransform cameraTransform, double duration) {
        // Fly to a nice overview of the city.
        viewer.camera.flyTo(new CameraFlyToOptions()
                .setDuration(duration)
                .setDestination(cameraTransform.destination)
                .setOrientation(cameraTransform.direction, cameraTransform.up)
                .setEasingFunction(EasingFunction.QUADRATIC_IN_OUT()));
    }

    private void resetHighlight() {
        if (selectedFeature != null) {
            selectedFeature.color = selectedOriginalColor;
            selectedFeature = null;
        }
        if (highlightedFeature != null) {
            highlightedFeature.color = highlightedOriginalColor;
            highlightedFeature = null;
        }
    }

    private JsArray<JsArrayString> stringArrayToJsArrayString(String[][] array) {
        JsArray<JsArrayString> result = JavaScriptObject.createArray().cast();

        for (int i = 0; i < array.length; i++) {
            result.push(JsArrayString.createArray().cast());
            for (int j = 0; j < array[i].length; j++) {
                result.get(i).push(array[i][j]);
            }
        }

        return result;
    }
}
