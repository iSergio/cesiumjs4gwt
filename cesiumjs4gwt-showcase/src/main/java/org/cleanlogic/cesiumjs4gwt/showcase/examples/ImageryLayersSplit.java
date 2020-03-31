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
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.ImageryLayerCollection;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.scene.ImageryLayer;
import org.cesiumjs.cs.scene.enums.ImagerySplitDirection;
import org.cesiumjs.cs.scene.providers.ArcGisMapServerImageryProvider;
import org.cesiumjs.cs.scene.providers.TileMapServiceImageryProvider;
import org.cesiumjs.cs.scene.providers.options.TileMapServiceImageryProviderOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.Slider;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderListener;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ImageryLayersSplit extends AbstractExample {

    @Inject
    public ImageryLayersSplit(ShowcaseExampleStore store) {
        super("Imagery Layers Split", "Use the split property to only show layers on one side of a slider.", new String[]{"Showcase", "Cesium", "3d", "Viewer", "Slider", "Split"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.imageryProvider = ArcGisMapServerImageryProvider.create("https://server.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer");
        viewerOptions.baseLayerPicker = false;
        final ViewerPanel csVPanel = new ViewerPanel(viewerOptions);

        ImageryLayerCollection layers = csVPanel.getViewer().imageryLayers();
        TileMapServiceImageryProviderOptions tileMapServiceImageryProviderOptions = new TileMapServiceImageryProviderOptions();
        tileMapServiceImageryProviderOptions.url = "https://cesiumjs.org/blackmarble";
        tileMapServiceImageryProviderOptions.credit = Credit.create("Black Marble imagery courtesy NASA Earth Observatory");
        tileMapServiceImageryProviderOptions.flipXY = true;
        ImageryLayer blackMarble = layers.addImageryProvider(new TileMapServiceImageryProvider(tileMapServiceImageryProviderOptions));
        blackMarble.splitDirection = ImagerySplitDirection.LEFT();

        csVPanel.getViewer().scene().imagerySplitPosition = 0.5;

        Slider slider = new Slider("Slider", 0, 100, 50);
        slider.setStep(1);
        slider.setWidth("100%");
        slider.addListener(new SliderListener() {
            @Override
            public void onStart(SliderEvent e) {
                //
            }

            @Override
            public boolean onSlide(SliderEvent e) {
                Slider source = e.getSource();
                double value = source.getValue() / 100.;
                csVPanel.getViewer().scene().imagerySplitPosition = value;
                return true;
            }

            @Override
            public void onChange(SliderEvent e) {
                //
            }

            @Override
            public void onStop(SliderEvent e) {
                //
            }
        });

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(slider, 0, 5);

        contentPanel.add(aPanel);
        contentPanel.add(new HTML("<p>Use the split property to only show layers on one side of a slider.</p>"));

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ImageryLayersSplit.txt";
        return sourceCodeURLs;
    }
}
