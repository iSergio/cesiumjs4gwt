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
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Cartographic;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseClickEvent;
import org.cesiumjs.cs.core.providers.ArcGISTiledElevationTerrainProvider;
import org.cesiumjs.cs.core.providers.options.ArcGISTiledElevationTerrainProviderOptions;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.I3SNode;
import org.cesiumjs.cs.scene.options.Cesium3DTilesetOptions;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.scene.providers.I3SDataProvider;
import org.cesiumjs.cs.scene.providers.options.I3SDataProviderOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class I3SFeaturePicking extends AbstractExample {
    @Inject
    public I3SFeaturePicking(ShowcaseExampleStore store) {
        super("I3S Feature Picking",
                "I3S Feature Picking Cesium Demo",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "I3S"}, store, "1.99");
    }

    @Override
    public void buildPanel() {
        ViewerOptions options = new ViewerOptions();
        options.terrainProvider = Cesium.createWorldTerrain();
        options.animation = false;
        options.timeline = false;
        ViewerPanel csVPanel = new ViewerPanel(options);

        // More datasets to tour can be added here...
        // The url passed to I3SDataProvider supports loading a single Indexed 3D Scene (I3S) layer
        // (.<host>/SceneServer/layers/<id>) or a collection of scene layers (.<host>/SceneServer) from a SceneServer.
        JsObject tours = JsObject.create();
        tours.setProperty("New York", "https://tiles.arcgis.com/tiles/z2tnIkrLQ2BRzr6P/arcgis/rest/services/NYC_Attributed_v17/SceneServer");
        // Initialize a terrain provider which provides geoid conversion between gravity related (typically I3S datasets) and ellipsoidal based
        // height systems (Cesium World Terrain).
        // If this is not specified, or the URL is invalid no geoid conversion will be applied.
        // The source data used in this transcoding service was compiled from https://earth-info.nga.mil/#tab_wgs84-data and is based on EGM2008 Gravity Model
        ArcGISTiledElevationTerrainProvider geoidService = new ArcGISTiledElevationTerrainProvider(
                ArcGISTiledElevationTerrainProviderOptions.create("https://tiles.arcgis.com/tiles/z2tnIkrLQ2BRzr6P/arcgis/rest/services/EGM2008/ImageServer"));
        // Create i3s and Cesium3DTileset options to pass optional parameters useful for debugging and visualizing
        Cesium3DTilesetOptions tilesetOptions = new Cesium3DTilesetOptions();
        tilesetOptions.skipLevelOfDetail = false;
        tilesetOptions.debugShowBoundingVolume = false;
        I3SDataProviderOptions i3SDataProviderOptions = I3SDataProviderOptions.create(tours.getString("New York"))
                .setTraceFetches(false).setGeoidTiledTerrainProvider(geoidService).setCesium3dTilesetOptions(tilesetOptions);

        I3SDataProvider i3sProvider = new I3SDataProvider(i3SDataProviderOptions);

        // Center camera on I3S once it's loaded
        i3sProvider.readyPromise().then((Void) -> {
            Cartographic center = Rectangle.center(i3sProvider.extent());
            center.height = 10000.0;
            csVPanel.getViewer().camera.setView(new ViewOptions().setDestination(Ellipsoid.WGS84().cartographicToCartesian(center)));
        });
        // Add the i3s layer provider as a primitive data type
        csVPanel.getViewer().scene().primitives().add(i3sProvider);

        // An entity object which will hold info about the currently selected feature for infobox display
        Entity selectedEntity = new Entity();

        final Viewer viewer = csVPanel.getViewer();
        // Show metadata in the InfoBox.
        viewer.screenSpaceEventHandler().setInputAction(event -> {
            MouseClickEvent clickEvent = (MouseClickEvent) event;
            // Pick a new feature
            JsObject pickedFeature = (JsObject) (Object) viewer.scene().pick(clickEvent.position);
            if (!Cesium.defined(pickedFeature)) {
                return;
            }

            Cartesian3 pickedPosition = viewer.scene().pickPosition(clickEvent.position);
            if (Cesium.defined(pickedFeature.getObject("content"))
                    && Cesium.defined(pickedFeature.getJsObject("content").getJsObject("tile").getJsObject("i3sNode"))) {
                I3SNode i3sNode = (I3SNode) (Object) pickedFeature.getJsObject("content").getJsObject("tile").getJsObject("i3sNode");
                if (pickedPosition != null) {
                    i3sNode.loadFields().then(Void -> {
                        String description = "No attributes";
                        String name = null;
                        JsObject fields = i3sNode.getFieldsForPickedPosition(pickedPosition);
                        if (JsObject.keys(fields).length() > 0) {
                            description = "<table class=\"cesium-infoBox-defaultTable\"><tbody>";
                            for (int i = 0; i < JsObject.keys(fields).length(); i++) {
                                String fieldName = JsObject.keys(fields).get(i);
                                if (JsObject.hasOwnProperty(i3sNode.fields(), fieldName)) {
                                    description += "<tr><th>" + fieldName + "</th><td>";
                                    description += JsObject.getString(fields, fieldName) + "</td></tr>";
                                    if (name == null) {
                                        name = JsObject.getString(fields, fieldName);
                                    }
                                }
                            }
                            description += "</tbody></table>";
                        }
                        if (name == null) {
                            name = "unknown";
                        }
                        selectedEntity.name = name;
                        selectedEntity.description = new ConstantProperty<>(description);
                        viewer.selectedEntity = selectedEntity;
                    });
                }
            }

        }, ScreenSpaceEventType.LEFT_CLICK());

        contentPanel.add(new HTML(
                "<p>Pick features from an I3S 3D Object Layer.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "I3SFeaturePicking.txt";
        return sourceCodeURLs;
    }
}
