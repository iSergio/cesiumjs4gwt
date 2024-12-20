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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.scene.ImageryLayer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.InputEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderBox;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class ImageryAdjustment extends AbstractExample {
    private SliderBox brightnessSlider;
    private SliderBox contrastSlider;
    private SliderBox hueSlider;
    private SliderBox saturationSlider;
    private SliderBox gammaSlider;

    TextBox brightnessTBox;
    TextBox contrastTBox;
    TextBox hueTBox;
    TextBox saturationTBox;
    TextBox gammaTBox;

    ViewerPanel csVPanel;

    float brightness = 0.f;
    float contrast = 0.f;
    float hue = 0.f;
    float saturation = 0.f;
    float gamma = 0.f;

    @Inject
    public ImageryAdjustment(ShowcaseExampleStore store) {
        super("Imagery Adjustment", "Adjust brightness, contrast, hue, saturation, and gamma of an imagery layer",
                new String[]{"Showcase", "Cesium", "3d", "Viewer"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();
        csVPanel.getViewer().imageryLayers().layerAdded.addEventListener(new UpdateViewModel());
        csVPanel.getViewer().imageryLayers().layerRemoved.addEventListener(new UpdateViewModel());
        csVPanel.getViewer().imageryLayers().layerMoved.addEventListener(new UpdateViewModel());

        brightnessSlider = new SliderBox(0, 1, 3, 0.02);
        brightnessSlider.setWidth("150px");
        brightnessSlider.addInputHandler(this::onInput);
        brightnessTBox = new TextBox();
        brightnessTBox.addChangeHandler(new MChangeHandler());
        brightnessTBox.setText("" + 1);
        brightnessTBox.setSize("30px", "12px");

        HorizontalPanel brightnessHPanel = new HorizontalPanel();
        brightnessHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        brightnessHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        brightnessHPanel.setSpacing(10);
        brightnessHPanel.add(brightnessSlider);
        brightnessHPanel.add(brightnessTBox);

        contrastSlider = new SliderBox(0, 1, 3, 0.02);
        contrastSlider.setWidth("150px");
        contrastSlider.addInputHandler(this::onInput);
        contrastTBox = new TextBox();
        contrastTBox.addChangeHandler(new MChangeHandler());
        contrastTBox.setText("" + 1);
        contrastTBox.setSize("30px", "12px");

        HorizontalPanel contrastHPanel = new HorizontalPanel();
        contrastHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        contrastHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        contrastHPanel.setSpacing(10);
        contrastHPanel.add(contrastSlider);
        contrastHPanel.add(contrastTBox);

        hueSlider = new SliderBox(0, 0, 3, 0.02);
        hueSlider.setWidth("150px");
        hueSlider.addInputHandler(this::onInput);
        hueTBox = new TextBox();
        hueTBox.addChangeHandler(new MChangeHandler());
        hueTBox.setText("" + 0);
        hueTBox.setSize("30px", "12px");

        HorizontalPanel hueHPanel = new HorizontalPanel();
        hueHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        hueHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        hueHPanel.setSpacing(10);
        hueHPanel.add(hueSlider);
        hueHPanel.add(hueTBox);

        saturationSlider = new SliderBox(0, 1, 3, 0.02);
        saturationSlider.setWidth("150px");
        saturationSlider.addInputHandler(this::onInput);
        saturationTBox = new TextBox();
        saturationTBox.addChangeHandler(new MChangeHandler());
        saturationTBox.setText("" + 1);
        saturationTBox.setSize("30px", "12px");

        HorizontalPanel saturationHPanel = new HorizontalPanel();
        saturationHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        saturationHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        saturationHPanel.setSpacing(10);
        saturationHPanel.add(saturationSlider);
        saturationHPanel.add(saturationTBox);

        gammaSlider = new SliderBox(0, 1, 3, 0.02);
        gammaSlider.setWidth("150px");
        gammaSlider.addInputHandler(this::onInput);
        gammaTBox = new TextBox();
        gammaTBox.addChangeHandler(new MChangeHandler());
        gammaTBox.setText("" + 1);
        gammaTBox.setSize("30px", "12px");

        HorizontalPanel gammaHPanel = new HorizontalPanel();
        gammaHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        gammaHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        gammaHPanel.setSpacing(10);
        gammaHPanel.add(gammaSlider);
        gammaHPanel.add(gammaTBox);

        FlexTable flexTable = new FlexTable();
        flexTable.setCellSpacing(1);
        flexTable.setCellPadding(1);
        flexTable.setHTML(1, 0, "<font color=\"white\">Brightness</font>");
        flexTable.setWidget(1, 1, brightnessHPanel);
        flexTable.setHTML(2, 0, "<font color=\"white\">Contrast</font>");
        flexTable.setWidget(2, 1, contrastHPanel);
        flexTable.setHTML(3, 0, "<font color=\"white\">Hue</font>");
        flexTable.setWidget(3, 1, hueHPanel);
        flexTable.setHTML(4, 0, "<font color=\"white\">Saturation</font>");
        flexTable.setWidget(4, 1, saturationHPanel);
        flexTable.setHTML(5, 0, "<font color=\"white\">Gamma</font>");
        flexTable.setWidget(5, 1, gammaHPanel);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Adjust brightness, contrast, hue, saturation, and gamma of an imagery layer.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    private void onInput(InputEvent event) {
        SliderBox source = (SliderBox) event.getSource();
        float value = source.getValue().floatValue();
        if (source.getElement().getId().equalsIgnoreCase("brightness")) {
            csVPanel.getViewer().imageryLayers().get(0).brightness = value;
            brightnessTBox.setValue(String.valueOf(value));
        } else if (source.getElement().getId().equalsIgnoreCase("contrast")) {
            csVPanel.getViewer().imageryLayers().get(0).contrast = value;
            contrastTBox.setValue(String.valueOf(value));
        } else if (source.getElement().getId().equalsIgnoreCase("hue")) {
            csVPanel.getViewer().imageryLayers().get(0).hue = value;
            hueTBox.setValue(String.valueOf(value));
        } else if (source.getElement().getId().equalsIgnoreCase("saturation")) {
            csVPanel.getViewer().imageryLayers().get(0).saturation = value;
            saturationTBox.setValue(String.valueOf(value));
        } else if (source.getElement().getId().equalsIgnoreCase("gamma")) {
            csVPanel.getViewer().imageryLayers().get(0).gamma = value;
            gammaTBox.setValue(String.valueOf(value));
        }
    }

    private final class MChangeHandler implements ChangeHandler {
        @Override
        public void onChange(ChangeEvent changeEvent) {
            TextBox source = (TextBox) changeEvent.getSource();
            float value = Float.parseFloat(source.getText());
            if (source.equals(brightnessTBox)) {
                brightnessSlider.setValue((int) (value * 100));
            } else if (source.equals(contrastTBox)) {
                contrastSlider.setValue((int) (value * 100));
            } else if (source.equals(hueTBox)) {
                hueSlider.setValue((int) (value * 100));
            } else if (source.equals(saturationTBox)) {
                saturationSlider.setValue((int) (value * 100));
            } else if (source.equals(gammaTBox)) {
                gammaSlider.setValue((int) (value * 100));
            }
        }
    }

    private final class UpdateViewModel implements Event.Listener {
        @Override
        public void function(Object... o) {
            if (csVPanel.getViewer().imageryLayers().length() > 0) {
                ImageryLayer layer = csVPanel.getViewer().imageryLayers().get(0);
                brightness = layer.brightness;
                contrast = layer.contrast;
                hue = layer.hue;
                saturation = layer.saturation;
                gamma = layer.gamma;

                if (brightnessSlider != null && contrastSlider != null && hueSlider != null && saturationSlider != null
                        && gammaSlider != null) {
                    brightnessSlider.setValue((int) (brightness * 100));
                    contrastSlider.setValue((int) (contrast * 100));
                    hueSlider.setValue((int) (hue * 100));
                    saturationSlider.setValue((int) (saturation * 100));
                    gammaSlider.setValue((int) (gamma * 100));
                }
                if (brightnessTBox != null && contrastTBox != null && hueTBox != null && saturationTBox != null
                        && gammaTBox != null) {
                    brightnessTBox.setValue("" + brightness);
                    contrastTBox.setValue("" + brightness);
                    hueTBox.setValue("" + brightness);
                    saturationTBox.setValue("" + brightness);
                    gammaTBox.setValue("" + brightness);
                }
            }
        }
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ImageryAdjustment.txt";
        return sourceCodeURLs;
    }
}