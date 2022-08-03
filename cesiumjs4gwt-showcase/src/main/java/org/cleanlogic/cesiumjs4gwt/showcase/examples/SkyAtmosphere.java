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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.scene.Camera;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.InputEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderBox;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class SkyAtmosphere extends AbstractExample {
    private ViewerPanel csVPanel;

    private SliderBox hueShiftSlider;
    private SliderBox saturationShiftSlider;
    private SliderBox brightnessShiftSlider;

    private TextBox hueShiftTBox;
    private TextBox saturationShiftTBox;
    private TextBox brightnessShiftTBox;

    @Inject
    public SkyAtmosphere(ShowcaseExampleStore store) {
        super("Sky Atmosphere", "Adjust hue, saturation, and brightness of the sky/atmosphere",
                new String[]{"Showcase", "Cesium", "3d", "atmosphere", "fog", "lighting", "hue", "saturation", "brightness"},
                store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();
        Camera camera = csVPanel.getViewer().camera;
        ViewOptions viewOptions = new ViewOptions();
        viewOptions.destinationPos = Cartesian3.fromDegrees(-75.5847, 40.0397, 1000.0);
        viewOptions.orientation = new HeadingPitchRoll(-Math.PI_OVER_TWO(), 0.2, 0.0);
        camera.setView(viewOptions);

        HorizontalPanel hueShiftHPanel = new HorizontalPanel();
        hueShiftHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        hueShiftHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        hueShiftHPanel.setSpacing(10);
        hueShiftSlider = new SliderBox(-1, 0.5, 1, 0.01);
        hueShiftSlider.setWidth("150px");
        hueShiftSlider.addInputHandler(this::onSliderInput);
        hueShiftTBox = new TextBox();
        hueShiftTBox.addChangeHandler(new MChangeHandler());
        hueShiftTBox.setText("0");
        hueShiftTBox.setSize("30px", "12px");
        hueShiftHPanel.add(hueShiftSlider);
        hueShiftHPanel.add(hueShiftTBox);

        HorizontalPanel saturationShiftHPanel = new HorizontalPanel();
        saturationShiftHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        saturationShiftHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        saturationShiftHPanel.setSpacing(10);
        saturationShiftSlider = new SliderBox(-1, 0.5, 1, 0.01);
        saturationShiftSlider.setStep(1);
        saturationShiftSlider.setWidth("150px");
        saturationShiftSlider.addInputHandler(this::onSliderInput);
        saturationShiftTBox = new TextBox();
        saturationShiftTBox.addChangeHandler(new MChangeHandler());
        saturationShiftTBox.setText("0");
        saturationShiftTBox.setSize("30px", "12px");
        saturationShiftHPanel.add(saturationShiftSlider);
        saturationShiftHPanel.add(saturationShiftTBox);

        HorizontalPanel brightnessShiftHPanel = new HorizontalPanel();
        brightnessShiftHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        brightnessShiftHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        brightnessShiftHPanel.setSpacing(10);
        brightnessShiftSlider = new SliderBox(-1, 0.5, 1, 0.01);
        brightnessShiftSlider.setWidth("150px");
        brightnessShiftSlider.addInputHandler(this::onSliderInput);
        brightnessShiftTBox = new TextBox();
        brightnessShiftTBox.addChangeHandler(new MChangeHandler());
        brightnessShiftTBox.setText("0");
        brightnessShiftTBox.setSize("30px", "12px");
        brightnessShiftHPanel.add(brightnessShiftSlider);
        brightnessShiftHPanel.add(brightnessShiftTBox);

        CheckBox lightingCBox = new CheckBox();
        lightingCBox.setWidth("100px");
        lightingCBox.setValue(true);
        lightingCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
                csVPanel.getViewer().scene().globe.enableLighting = !csVPanel.getViewer().scene().globe.enableLighting;
            }
        });

        CheckBox fogCBox = new CheckBox();
        fogCBox.setWidth("100px");
        fogCBox.setValue(true);
        fogCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
                csVPanel.getViewer().scene().fog.enabled = !csVPanel.getViewer().scene().fog.enabled;
            }
        });

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">hueShift</font>");
        flexTable.setWidget(1, 1, hueShiftHPanel);
        flexTable.setHTML(2, 0, "<font color=\"white\">saturationShift</font>");
        flexTable.setWidget(2, 1, saturationShiftHPanel);
        flexTable.setHTML(3, 0, "<font color=\"white\">brightnessShift</font>");
        flexTable.setWidget(3, 1, brightnessShiftHPanel);
        flexTable.setHTML(4, 0, "<font color=\"white\">Toggle Lighting</font>");
        flexTable.setWidget(4, 1, lightingCBox);
        flexTable.setHTML(5, 0, "<font color=\"white\">Toggle Fog</font>");
        flexTable.setWidget(5, 1, fogCBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Adjust hue, saturation, and brightness of the sky/atmosphere.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    private void onSliderInput(InputEvent event) {
        SliderBox source = (SliderBox) event.getSource();
        double value = Double.parseDouble(source.getValue());
        if (source == hueShiftSlider) {
            csVPanel.getViewer().scene().skyAtmosphere.hueShift = (float) value;
            hueShiftTBox.setText(value + "");
        } else if (source == saturationShiftSlider) {
            csVPanel.getViewer().scene().skyAtmosphere.saturationShift = (float) value;
            saturationShiftTBox.setText(value + "");
        } else if (source == brightnessShiftSlider) {
            csVPanel.getViewer().scene().skyAtmosphere.brightnessShift = (float) value;
            brightnessShiftTBox.setText(value + "");
        }
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "SkyAtmosphere.txt";
        return sourceCodeURLs;
    }

    private class MChangeHandler implements ChangeHandler {
        @Override
        public void onChange(ChangeEvent changeEvent) {
            TextBox source = (TextBox) changeEvent.getSource();
            double value = Double.parseDouble(source.getValue());
            if (source == hueShiftTBox) {
                csVPanel.getViewer().scene().skyAtmosphere.hueShift = (float) value;
                hueShiftSlider.setValue((int) (value * 100));
            } else if (source == saturationShiftTBox) {
                csVPanel.getViewer().scene().skyAtmosphere.saturationShift = (float) value;
                saturationShiftSlider.setValue((int) (value * 100));
            } else if (source == brightnessShiftTBox) {
                csVPanel.getViewer().scene().skyAtmosphere.brightnessShift = (float) value;
                brightnessShiftSlider.setValue((int) (value * 100));
            }
        }
    }
}
