/*
 * Copyright 2016 iserge.
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
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Configuration;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.scene.Camera;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanelAbstract;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;
import org.cleanlogic.showcase.client.examples.slider.Slider;
import org.cleanlogic.showcase.client.examples.slider.SliderEvent;
import org.cleanlogic.showcase.client.examples.slider.SliderListener;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class AtmosphereColor extends AbstractExample {
    private ViewerPanel _csVPanel;

    private Slider _hueShiftSlider;
    private Slider _saturationShiftSlider;
    private Slider _brightnessShiftSlider;

    private TextBox _hueShiftTBox;
    private TextBox _saturationShiftTBox;
    private TextBox _brightnessShiftTBox;
    private class ViewerPanel implements IsWidget {
        private ViewerPanelAbstract _csPanelAbstract;

        private ViewerPanel() {
            super();
            asWidget();
        }

        @Override
        public Widget asWidget() {
            if (_csPanelAbstract == null) {
                final Configuration csConfiguration = new Configuration();
                csConfiguration.setPath(GWT.getModuleBaseURL() + "JavaScript/Cesium");
                _csPanelAbstract = new ViewerPanelAbstract(csConfiguration) {
                    @Override
                    public Viewer createViewer(Element element) {
                        Viewer csViewer = new Viewer(element);
                        Camera camera = csViewer.camera;
                        ViewOptions viewOptions = new ViewOptions();
                        viewOptions.destinationPos = Cartesian3.fromDegrees(-75.5847, 40.0397, 1000.0);
                        viewOptions.orientation = new HeadingPitchRoll(-Math.PI_OVER_TWO(), 0.2, 0.0);
                        camera.setView(viewOptions);
                        return csViewer;
                    }
                };
            }
            return _csPanelAbstract;
        }

        private Viewer getViewer() {
            return _csPanelAbstract.getViewer();
        }
    }

    @Inject
    public AtmosphereColor(ShowcaseExampleStore store) {
        super("Atmosphere Color", "Atmosphere configuration example", new String[]{"Showcase", "Cesium", "3d", "atmosphere", "fog", "lighting", "hue", "saturation", "brightness"}, store);
    }

    @Override
    public void buildPanel() {
        _csVPanel = new ViewerPanel();

        HorizontalPanel hueShiftHPanel = new HorizontalPanel();
        hueShiftHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        hueShiftHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        hueShiftHPanel.setSpacing(10);
        Label hueShiftLbl = new Label("hueShift");
        _hueShiftSlider = new Slider("hueShift", -100, 100, 0);
        _hueShiftSlider.setStep(1);
        _hueShiftSlider.setWidth("250px");
        _hueShiftSlider.addListener(new MSliderListener());
        _hueShiftTBox = new TextBox();
        _hueShiftTBox.addChangeHandler(new MChangeHandler());
        _hueShiftTBox.setText("0");
        _hueShiftTBox.setSize("30px", "12px");
        hueShiftHPanel.add(hueShiftLbl);
        hueShiftHPanel.add(_hueShiftSlider);
        hueShiftHPanel.add(_hueShiftTBox);

        HorizontalPanel saturationShiftHPanel = new HorizontalPanel();
        saturationShiftHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        saturationShiftHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        saturationShiftHPanel.setSpacing(10);
        Label saturationShiftLbl = new Label("saturationShift");
        _saturationShiftSlider = new Slider("saturationShift", -100, 100, 0);
        _saturationShiftSlider.setStep(1);
        _saturationShiftSlider.setWidth("250px");
        _saturationShiftSlider.addListener(new MSliderListener());
        _saturationShiftTBox = new TextBox();
        _saturationShiftTBox.addChangeHandler(new MChangeHandler());
        _saturationShiftTBox.setText("0");
        _saturationShiftTBox.setSize("30px", "12px");
        saturationShiftHPanel.add(saturationShiftLbl);
        saturationShiftHPanel.add(_saturationShiftSlider);
        saturationShiftHPanel.add(_saturationShiftTBox);

        HorizontalPanel brightnessShiftHPanel = new HorizontalPanel();
        brightnessShiftHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        brightnessShiftHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        brightnessShiftHPanel.setSpacing(10);
        Label brightnessShiftLbl = new Label("brightnessShift");
        _brightnessShiftSlider = new Slider("brightnessShift", -100, 100, 0);
        _brightnessShiftSlider.setStep(1);
        _brightnessShiftSlider.setWidth("250px");
        _brightnessShiftSlider.addListener(new MSliderListener());
        _brightnessShiftTBox = new TextBox();
        _brightnessShiftTBox.addChangeHandler(new MChangeHandler());
        _brightnessShiftTBox.setText("0");
        _brightnessShiftTBox.setSize("30px", "12px");
        brightnessShiftHPanel.add(brightnessShiftLbl);
        brightnessShiftHPanel.add(_brightnessShiftSlider);
        brightnessShiftHPanel.add(_brightnessShiftTBox);

        ToggleButton lightingTBtn = new ToggleButton("Toggle Lighting");
        lightingTBtn.setWidth("100px");
        lightingTBtn.setValue(true);
        lightingTBtn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
                _csVPanel.getViewer().scene().globe.enableLighting = !_csVPanel.getViewer().scene().globe.enableLighting;
            }
        });

        ToggleButton fogTBtn = new ToggleButton("Toggle Fog");
        fogTBtn.setWidth("100px");
        fogTBtn.setValue(true);
        fogTBtn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> valueChangeEvent) {
                _csVPanel.getViewer().scene().fog.enabled = !_csVPanel.getViewer().scene().fog.enabled;
            }
        });

        contentPanel.add(new HTML("<p>This example shows simple Cesium application</p>"));
        contentPanel.add(hueShiftHPanel);
        contentPanel.add(saturationShiftHPanel);
        contentPanel.add(brightnessShiftHPanel);
        contentPanel.add(lightingTBtn);
        contentPanel.add(fogTBtn);
        contentPanel.add(_csVPanel);

        initWidget(contentPanel);
    }

    private class MSliderListener implements SliderListener {

        @Override
        public void onStart(SliderEvent e) {

        }

        @Override
        public boolean onSlide(SliderEvent e) {
            Slider source = e.getSource();
            double value = source.getValue() / 100.;
            if (source == _hueShiftSlider) {
                _csVPanel.getViewer().scene().skyAtmosphere.hueShift = (float)value;
                _hueShiftTBox.setText(value + "");
            }
            else if (source == _saturationShiftSlider) {
                _csVPanel.getViewer().scene().skyAtmosphere.saturationShift = (float)value;
                _saturationShiftTBox.setText(value + "");
            }
            else if (source == _brightnessShiftSlider) {
                _csVPanel.getViewer().scene().skyAtmosphere.brightnessShift = (float)value;
                _brightnessShiftTBox.setText(value + "");
            }
            return true;
        }

        @Override
        public void onChange(SliderEvent e) {

        }

        @Override
        public void onStop(SliderEvent e) {

        }
    }

    private class MChangeHandler implements ChangeHandler {
        @Override
        public void onChange(ChangeEvent changeEvent) {
            TextBox source = (TextBox)changeEvent.getSource();
            double value = Double.parseDouble(source.getValue());
            if (source == _hueShiftTBox) {
                _csVPanel.getViewer().scene().skyAtmosphere.hueShift = (float)value;
                _hueShiftSlider.setValue((int)(value * 100));
            }
            else if (source == _saturationShiftTBox) {
                _csVPanel.getViewer().scene().skyAtmosphere.saturationShift = (float)value;
                _saturationShiftSlider.setValue((int)(value * 100));
            }
            else if (source == _brightnessShiftTBox) {
                _csVPanel.getViewer().scene().skyAtmosphere.brightnessShift = (float)value;
                _brightnessShiftSlider.setValue((int)(value * 100));
            }
        }
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "AtmosphereColor.txt";
        return sourceCodeURLs;
    }
}
