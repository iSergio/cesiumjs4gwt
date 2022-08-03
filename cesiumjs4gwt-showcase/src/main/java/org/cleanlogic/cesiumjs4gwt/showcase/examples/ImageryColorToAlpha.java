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
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import org.cesiumjs.cs.collections.ImageryLayerCollection;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.scene.ImageryLayer;
import org.cesiumjs.cs.scene.providers.SingleTileImageryProvider;
import org.cesiumjs.cs.scene.providers.options.SingleTileImageryProviderOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderBox;

/**
 * @author Serge Silaev aka iSergio
 */
public class ImageryColorToAlpha extends AbstractExample {
    private ImageryLayer singleTileLayer;

    @Inject
    public ImageryColorToAlpha(ShowcaseExampleStore store) {
        super("Imagery Color To Alpha", "Apply simple color-to-alpha on imagery layers.",
                new String[]{"Showcase", "color to alpha"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        ImageryLayerCollection layers = csVPanel.getViewer().scene().imageryLayers();

        // Set oceans on Bing base layer to transparent
        ImageryLayer baseLayer = layers.get(0);
        baseLayer.colorToAlpha = new Color(0.0, 0.016, 0.059, 1.0f);
        baseLayer.colorToAlphaThreshold = 0.2;

        // Add a bump layer with adjustable threshold
        SingleTileImageryProviderOptions options = new SingleTileImageryProviderOptions();
        options.url = GWT.getModuleBaseURL() + "images/earthbump1k.jpg";
        options.rectangle = Rectangle.fromDegrees(-180.0, -90.0, 180.0, 90.0);
        singleTileLayer = layers.addImageryProvider(new SingleTileImageryProvider(options));
        singleTileLayer.colorToAlpha = new Color(0.0, 0.0, 0.0, 1.0);
        singleTileLayer.colorToAlphaThreshold = 0.1;

        SliderBox thresholdSlider = new SliderBox(0, 0.1, 1, 0.01);
        thresholdSlider.setWidth("150px");
        thresholdSlider.addInputHandler(event -> {
            SliderBox source = (SliderBox) event.getSource();
            singleTileLayer.colorToAlphaThreshold = Double.parseDouble(source.getValue());
        });

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Threshold</font>");
        flexTable.setWidget(1, 1, thresholdSlider);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Apply simple color-to-alpha on imagery layers.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ImageryColorToAlpha.txt";
        return sourceCodeURLs;
    }
}