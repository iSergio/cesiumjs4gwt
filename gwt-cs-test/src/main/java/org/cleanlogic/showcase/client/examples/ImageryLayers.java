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
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.ImageryLayerCollection;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.scene.ImageryLayer;
import org.cesiumjs.cs.scene.providers.ArcGisMapServerImageryProvider;
import org.cesiumjs.cs.scene.providers.SingleTileImageryProvider;
import org.cesiumjs.cs.scene.providers.options.ArcGisMapServerImageryProviderOptions;
import org.cesiumjs.cs.scene.providers.options.SingleTileImageryProviderOptions;
import org.cesiumjs.cs.scene.providers.options.TileMapServiceImageryProviderOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ImageryLayers extends AbstractExample {
    @Inject
    public ImageryLayers(ShowcaseExampleStore store) {
        super("Imagery Layers", "Create imagery layers from multiple sources", new String[]{"Showcase", "Cesium", "3d", "Viewer"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        ArcGisMapServerImageryProviderOptions arcGisMapServerImageryProviderOptions = new ArcGisMapServerImageryProviderOptions();
        arcGisMapServerImageryProviderOptions.url = "https://server.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer";
        viewerOptions.imageryProvider = new ArcGisMapServerImageryProvider(arcGisMapServerImageryProviderOptions);
        viewerOptions.baseLayerPicker = false;
        ViewerPanel csVPanel = new ViewerPanel(viewerOptions);


        ImageryLayerCollection layers = csVPanel.getViewer().imageryLayers();
        TileMapServiceImageryProviderOptions tileMapServiceImageryProviderOptions = new TileMapServiceImageryProviderOptions();
        tileMapServiceImageryProviderOptions.url = "https://cesiumjs.org/blackmarble";
        tileMapServiceImageryProviderOptions.credit = new Credit("Black Marble imagery courtesy NASA Earth Observatory");
        tileMapServiceImageryProviderOptions.flipXY = true;
        ImageryLayer blackMarble = layers.addImageryProvider(Cesium.createTileMapServiceImageryProvider(tileMapServiceImageryProviderOptions));
        blackMarble.alpha = 0.5f;
        blackMarble.brightness = 2.0f;

        SingleTileImageryProviderOptions singleTileImageryProviderOptions = new SingleTileImageryProviderOptions();
        singleTileImageryProviderOptions.url = GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png";
        singleTileImageryProviderOptions.rectangle = Rectangle.fromDegrees(-75.0, 28.0, -67.0, 29.75);
        layers.addImageryProvider(new SingleTileImageryProvider(singleTileImageryProviderOptions));

        contentPanel.add(new HTML("<p>Create imagery layers from multiple sources.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ImageryLayers.txt";
        return sourceCodeURLs;
    }
}