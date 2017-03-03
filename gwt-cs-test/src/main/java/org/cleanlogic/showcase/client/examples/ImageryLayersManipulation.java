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

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.ImageryLayerCollection;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.scene.ImageryLayer;
import org.cesiumjs.cs.scene.WebMapServiceParameters;
import org.cesiumjs.cs.scene.providers.*;
import org.cesiumjs.cs.scene.providers.options.*;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;
import org.cleanlogic.showcase.client.examples.slider.Slider;
import org.cleanlogic.showcase.client.examples.slider.SliderEvent;
import org.cleanlogic.showcase.client.examples.slider.SliderListener;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ImageryLayersManipulation extends AbstractExample {
    private ImageryLayerCollection imageryLayers;
    private List<ImageryLayer> layers = new ArrayList<>();
    private HashMap<String, ImageryLayer> baseLayers = new HashMap<>();
    private HashMap<String, ImageryLayer> additionalLayers = new HashMap<>();
    private ImageryLayer selectedLayer;

    private Callback<Void, Void> _callback;

    @Inject
    public ImageryLayersManipulation(ShowcaseExampleStore store) {
        super("Imagery Layers Manipulation", "Layer imagery from multiple sources, including WMS servers, Bing Maps, ArcGIS Online, OpenStreetMaps, and more, and adjust the alpha of each independently", new String[]{"Showcase", "Cesium", "3d", "Viewer"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.baseLayerPicker = false;
        ViewerPanel csVPanel = new ViewerPanel(viewerOptions);

        imageryLayers = csVPanel.getViewer().imageryLayers();

        setupLayers();
        updateLayerList();

        _callback.onSuccess(null);

        HorizontalPanel baseLayersHPanel = new HorizontalPanel();
        baseLayersHPanel.setSpacing(5);
        baseLayersHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        baseLayersHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        final ListBox baseLayersLBox = new ListBox();
        baseLayersHPanel.add(baseLayersLBox);

        Slider baseLayersSlider = new Slider("baseLayersAlpha", 0, 100, 100);
        baseLayersSlider.setWidth("200px");
        baseLayersSlider.addListener(new MSliderListener());
        baseLayersHPanel.add(baseLayersSlider);

        baseLayersLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                ListBox source = (ListBox) changeEvent.getSource();
                ImageryLayer baseLayer = baseLayers.get(source.getSelectedValue());

                int activeLayerIndex = 0;
                int numLayers = layers.size();
                for (int i = 0; i < numLayers; ++i) {
                    if (baseLayers.containsValue(layers.get(i))) {
                        activeLayerIndex = i;
                    }
                }
                ImageryLayer activeLayer = layers.get(activeLayerIndex);
                float alpha = activeLayer.alpha;
                boolean show = activeLayer.show;
                imageryLayers.remove(activeLayer, false);
                imageryLayers.add(baseLayer, numLayers - activeLayerIndex - 1);
                baseLayer.show = show;
                baseLayer.alpha = alpha;
                updateLayerList();

                selectedLayer = baseLayer;
            }
        });

        Callback<Void, Void> cesiumCreated = new Callback<Void, Void>() {
            @Override
            public void onFailure(Void aVoid) {
                //
            }

            @Override
            public void onSuccess(Void aVoid) {
                for (Map.Entry<String, ImageryLayer> entry : baseLayers.entrySet()) {
                    baseLayersLBox.addItem(entry.getKey(), entry.getKey());
                }
            }
        };
        addCallback(cesiumCreated);

        contentPanel.add(new HTML("<p>Layer imagery from multiple sources, including WMS servers, Bing Maps, ArcGIS Online, OpenStreetMaps, and more, and adjust the alpha of each independently.</p>"));
        contentPanel.add(baseLayersHPanel);
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ImageryLayersManipulation.txt";
        return sourceCodeURLs;
    }

    private class MSliderListener implements SliderListener {
        @Override
        public void onStart(SliderEvent e) {

        }

        @Override
        public boolean onSlide(SliderEvent e) {
            Slider source = e.getSource();
            selectedLayer.alpha = (float)source.getValue() / 100.0f;
            return true;
        }

        @Override
        public void onChange(SliderEvent e) {

        }

        @Override
        public void onStop(SliderEvent e) {

        }
    }

    private void setupLayers() {
        addBaseLayerOption("Bing Maps Aerial", null);

        BingMapsImageryProviderOptions bingMapsImageryProviderOptions = new BingMapsImageryProviderOptions();
        bingMapsImageryProviderOptions.url = "https://dev.virtualearth.net";
        bingMapsImageryProviderOptions.mapStyle = BingMapsStyle.ROAD();
        addBaseLayerOption("Bing Maps Road", new BingMapsImageryProvider(bingMapsImageryProviderOptions));

        ArcGisMapServerImageryProviderOptions arcGisMapServerImageryProviderOptions = new ArcGisMapServerImageryProviderOptions();
        arcGisMapServerImageryProviderOptions.url = "https://server.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer";
        addBaseLayerOption("ArcGIS World Street Maps", new ArcGisMapServerImageryProvider(arcGisMapServerImageryProviderOptions));

        addBaseLayerOption("OpenStreetMaps", Cesium.createOpenStreetMapImageryProvider());

        OpenStreetMapImageryProviderOptions openStreetMapImageryProviderOptions = new OpenStreetMapImageryProviderOptions();
        openStreetMapImageryProviderOptions.url = "https://otile1-s.mqcdn.com/tiles/1.0.0/osm/";
        addBaseLayerOption("MapQuest OpenStreetMaps", Cesium.createOpenStreetMapImageryProvider(openStreetMapImageryProviderOptions));

        openStreetMapImageryProviderOptions = new OpenStreetMapImageryProviderOptions();
        openStreetMapImageryProviderOptions.url = "https://stamen-tiles.a.ssl.fastly.net/watercolor/";
        openStreetMapImageryProviderOptions.fileExtension = "jpg";
        openStreetMapImageryProviderOptions.credit = new Credit("Map tiles by Stamen Design, under CC BY 3.0. Data by OpenStreetMap, under CC BY SA.");
        addBaseLayerOption("Stamen Maps", Cesium.createOpenStreetMapImageryProvider(openStreetMapImageryProviderOptions));

        TileMapServiceImageryProviderOptions tileMapServiceImageryProviderOptions = new TileMapServiceImageryProviderOptions();
        tileMapServiceImageryProviderOptions.url = GWT.getModuleBaseURL() + "JavaScript/Cesium/Assets/Textures/NaturalEarthII";
        addBaseLayerOption("Natural Earth II (local)", Cesium.createTileMapServiceImageryProvider(tileMapServiceImageryProviderOptions));

        WebMapTileServiceImageryProviderOptions webMapTileServiceImageryProviderOptions = new WebMapTileServiceImageryProviderOptions();
        webMapTileServiceImageryProviderOptions.url = "http://basemap.nationalmap.gov/arcgis/rest/services/USGSShadedReliefOnly/MapServer/WMTS";
        webMapTileServiceImageryProviderOptions.layer = "USGSShadedReliefOnly";
        webMapTileServiceImageryProviderOptions.style = "default";
        webMapTileServiceImageryProviderOptions.format = "image/jpeg";
        webMapTileServiceImageryProviderOptions.tileMatrixSetID = "default028mm";
        webMapTileServiceImageryProviderOptions.maximumLevel = 19;
        webMapTileServiceImageryProviderOptions.credit = new Credit("U. S. Geological Survey");
        addBaseLayerOption("USGS Shaded Relief (via WMTS)", new WebMapTileServiceImageryProvider(webMapTileServiceImageryProviderOptions));


        WebMapServiceParameters parameters = new WebMapServiceParameters();
        parameters.format = "image/png";
        parameters.transparent = true;
        WebMapServiceImageryProviderOptions webMapServiceImageryProviderOptions = new WebMapServiceImageryProviderOptions();
        webMapServiceImageryProviderOptions.url = "https://mesonet.agron.iastate.edu/cgi-bin/wms/goes/conus_ir.cgi?";
        webMapServiceImageryProviderOptions.layers = "goes_conus_ir";
        webMapServiceImageryProviderOptions.credit = new Credit("Infrared data courtesy Iowa Environmental Mesonet");
        webMapServiceImageryProviderOptions.parameters = parameters;
        addAdditionalLayerOption("United States GOES Infrared", new WebMapServiceImageryProvider(webMapServiceImageryProviderOptions), 1, true);

        parameters = new WebMapServiceParameters();
        parameters.format = "image/png";
        parameters.transparent = true;
        webMapServiceImageryProviderOptions = new WebMapServiceImageryProviderOptions();
        webMapServiceImageryProviderOptions.url = "https://mesonet.agron.iastate.edu/cgi-bin/wms/nexrad/n0r.cgi?";
        webMapServiceImageryProviderOptions.layers = "nexrad-n0r";
        webMapServiceImageryProviderOptions.credit = new Credit("Radar data courtesy Iowa Environmental Mesonet");
        webMapServiceImageryProviderOptions.parameters = parameters;
        addAdditionalLayerOption("United States GOES Infrared", new WebMapServiceImageryProvider(webMapServiceImageryProviderOptions), 1, true);

        tileMapServiceImageryProviderOptions = new TileMapServiceImageryProviderOptions();
        tileMapServiceImageryProviderOptions.url = GWT.getModuleBaseURL() + "images/cesium_maptiler/Cesium_Logo_Color";
        addAdditionalLayerOption("TileMapService Image", Cesium.createTileMapServiceImageryProvider(tileMapServiceImageryProviderOptions), 0.2f, true);

        SingleTileImageryProviderOptions singleTileImageryProviderOptions = new SingleTileImageryProviderOptions();
        singleTileImageryProviderOptions.url = GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png";
        singleTileImageryProviderOptions.rectangle = Rectangle.fromDegrees(-115.0, 38.0, -107, 39.75);
        addAdditionalLayerOption("Single Image", new SingleTileImageryProvider(singleTileImageryProviderOptions), 1.0f, true);


        addAdditionalLayerOption("Grid", new GridImageryProvider(), 1.0f, false);

        addAdditionalLayerOption("Tile Coordinates", new TileCoordinatesImageryProvider(), 1.0f, false);
    }

    private void addBaseLayerOption(String name, ImageryProvider imageryProvider) {
        ImageryLayer layer = null;
        if (imageryProvider == null) {
            layer = imageryLayers.get(0);
            selectedLayer = layer;
        } else {
            layer = new  ImageryLayer(imageryProvider);
        }
        baseLayers.put(name, layer);
    }

    private void addAdditionalLayerOption(String name, ImageryProvider imageryProvider, float alpha, boolean show) {
        ImageryLayer layer = imageryLayers.addImageryProvider(imageryProvider);
        layer.alpha = alpha;
        layer.show = show;
        additionalLayers.put(name, layer);
    }

    private void updateLayerList() {
        int numLayers = imageryLayers.length();
        layers.clear();
        for (int i = numLayers - 1; i >= 0; --i) {
            layers.add(imageryLayers.get(i));
        }
    }

    public void addCallback(Callback<Void, Void> callback) {
        _callback = callback;
    }
}
