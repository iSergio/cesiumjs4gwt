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

package org.cleanlogic.showcase.client.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.providers.EllipsoidTerrainProvider;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.providers.ImageryProvider;
import org.cesiumjs.cs.scene.providers.IonImageryProvider;
import org.cesiumjs.cs.scene.providers.options.IonImageryProviderOptions;
import org.cesiumjs.cs.widgets.BaseLayerPicker;
import org.cesiumjs.cs.widgets.ProviderViewModel;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.BaseLayerPickerViewModelOptions;
import org.cesiumjs.cs.widgets.options.ProviderViewModelOptions;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class CustomBaseLayerPicker extends AbstractExample {

    @Inject
    public CustomBaseLayerPicker(ShowcaseExampleStore store) {
        super("Custom BaseLayerPicker widget", "Configure custom BaseLayerPicker widget", new String[]{"Showcase", "Cesium", "3d", "BaseLayerPicker", "BaseLayerPickerViewModel"}, store);
    }

    @Override
    public void buildPanel() {
        DivElement divElement = RootPanel.get().getElement().getOwnerDocument().createDivElement();
        divElement.setId("baseLayerPickerContainer");
        divElement.setPropertyString("style", "position:absolute;top:50px;right:42px;width:38px;height:38px;");

        List<ProviderViewModel> imageryViewModels = new ArrayList<>();
        List<ProviderViewModel> terrainViewModels = new ArrayList<>();

        ProviderViewModelOptions options = new ProviderViewModelOptions();
        options.name = "Open\u00adStreet\u00adMap";
        options.iconUrl = GWT.getModuleBaseURL() + "cs/CesiumUnminified/Widgets/Images/ImageryProviders/openStreetMap.png";
        options.tooltip = "OpenStreetMap (OSM) is a collaborative project to create a free editable map of the world.\nhttp://www.openstreetmap.org";
        options.imageryProviderCreationFunction = new ProviderViewModel.ImageryProviderCreationFunction() {
            @Override
            public ImageryProvider function() {
                return Cesium.createOpenStreetMapImageryProvider("https://a.tile.openstreetmap.org/");
            }
        };
        imageryViewModels.add(new ProviderViewModel(options));

        options = new ProviderViewModelOptions();
        options.name = "Earth at Night";
        options.iconUrl = GWT.getModuleBaseURL() + "cs/CesiumUnminified/Widgets/Images/ImageryProviders/blueMarble.png";
        options.tooltip = "The lights of cities and villages trace the outlines of civilization \n" +
                "        in this global view of the Earth at night as seen by NASA/NOAA\\'s Suomi NPP satellite.";
        options.imageryProviderCreationFunction = new ProviderViewModel.ImageryProviderCreationFunction() {
            @Override
            public ImageryProvider function() {
                return new IonImageryProvider(IonImageryProviderOptions.create(3812));
            }
        };
        imageryViewModels.add(new ProviderViewModel(options));

        options = new ProviderViewModelOptions();
        options.name = "Natural Earth\u00a0II";
        options.iconUrl = GWT.getModuleBaseURL() + "cs/CesiumUnminified/Widgets/Images/ImageryProviders/naturalEarthII.png";
        options.tooltip = "The lights of cities and villages trace the outlines of civilization \n" +
                "        in this global view of the Earth at night as seen by NASA/NOAA\\'s Suomi NPP satellite.";
        options.imageryProviderCreationFunction = new ProviderViewModel.ImageryProviderCreationFunction() {
            @Override
            public ImageryProvider function() {
                return Cesium.createTileMapServiceImageryProvider(GWT.getModuleBaseURL() + "cs/CesiumUnminified/Assets/Textures/NaturalEarthII");
            }
        };
        imageryViewModels.add(new ProviderViewModel(options));

        options = new ProviderViewModelOptions();
        options.name = "EllipsoidTerrainProvider";
        options.iconUrl = GWT.getModuleBaseURL() + "cs/CesiumUnminified/Widgets/Images/ImageryProviders/naturalEarthII.png";
        options.tooltip = "Some Terrain Description.";
        options.terrainProviderCreationFunction = new ProviderViewModel.TerrainProviderCreationFunction() {
            @Override
            public TerrainProvider function() {
                return new EllipsoidTerrainProvider();
            }
        };
        terrainViewModels.add(new ProviderViewModel(options));

        options = new ProviderViewModelOptions();
        options.name = "WorldTerrain";
        options.iconUrl = GWT.getModuleBaseURL() + "cs/CesiumUnminified/Widgets/Images/ImageryProviders/naturalEarthII.png";
        options.tooltip = "WorldTerrain.";
        options.terrainProviderCreationFunction = new ProviderViewModel.TerrainProviderCreationFunction() {
            @Override
            public TerrainProvider function() {
                return Cesium.createWorldTerrain(Cesium.CreateWorldTerrainOptions.create(true, true));
            }
        };
        terrainViewModels.add(new ProviderViewModel(options));

        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.imageryProvider = (ImageryProvider) JsObject.undefined();
        viewerOptions.baseLayerPicker = false;
        ViewerPanel csVPanel = new ViewerPanel(viewerOptions);
        csVPanel.getViewer().scene().imageryLayers().removeAll(true);

        csVPanel.getViewer().container().getFirstChildElement().appendChild(divElement);

        BaseLayerPickerViewModelOptions baseLayerPickerOptions = BaseLayerPickerViewModelOptions.create(csVPanel.getViewer().scene().globe);
        baseLayerPickerOptions.imageryProviderViewModels = imageryViewModels.toArray(new ProviderViewModel[0]);
        baseLayerPickerOptions.terrainProviderViewModels = terrainViewModels.toArray(new ProviderViewModel[0]);

        BaseLayerPicker baseLayerPicker = new BaseLayerPicker(divElement, baseLayerPickerOptions);

        contentPanel.add(new HTML("<p>Configure custom BaseLayerPicker widget.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CustomBaseLayerPicker.txt";
        return sourceCodeURLs;
    }
}
