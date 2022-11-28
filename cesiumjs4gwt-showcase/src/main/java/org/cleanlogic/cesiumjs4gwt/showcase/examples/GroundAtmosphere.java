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

package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.providers.EllipsoidTerrainProvider;
import org.cesiumjs.cs.scene.Globe;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.InputEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderBox;

/**
 * @author Serge Silaev aka iSergio
 */
public class GroundAtmosphere extends AbstractExample {
    private ViewerPanel csVPanel;
    private Globe globe;

    private SliderBox lightingFadeOutDistanceSlider;
    private TextBox lightingFadeOutDistanceTBox;

    private SliderBox lightingFadeInDistanceSlider;
    private TextBox lightingFadeInDistanceTBox;

    private SliderBox nightFadeOutDistanceSlider;
    private TextBox nightFadeOutDistanceTBox;

    private SliderBox nightFadeInDistanceSlider;
    private TextBox nightFadeInDistanceTBox;

    private double lightingFadeOutDistance;
    private double lightingFadeInDistance;
    private double nightFadeOutDistance;
    private double nightFadeInDistance;

    @Inject
    public GroundAtmosphere(ShowcaseExampleStore store) {
        super("Ground Atmosphere", "Adjust hue, saturation, and brightness of the sky/atmosphere.",
                new String[]{"Atmosphere", "Sky", "hue", "saturation", "brightness"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.sceneModePicker = false;
        csVPanel = new ViewerPanel(viewerOptions);

        Scene scene = csVPanel.getViewer().scene();
        globe = scene.globe;

        lightingFadeOutDistance = globe.lightingFadeOutDistance;
        lightingFadeInDistance = globe.lightingFadeInDistance;
        nightFadeOutDistance = globe.nightFadeOutDistance;
        nightFadeInDistance = globe.nightFadeInDistance;

        HorizontalPanel lightingFadeOutDistanceHPanel = new HorizontalPanel();
        lightingFadeOutDistanceHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        lightingFadeOutDistanceHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        lightingFadeOutDistanceHPanel.setSpacing(10);
        lightingFadeOutDistanceSlider = new SliderBox(1e6, 10000000, 1e8, 1e6);
        lightingFadeOutDistanceSlider.setStep(1);
        lightingFadeOutDistanceSlider.setWidth("150px");
        lightingFadeOutDistanceSlider.addInputHandler(this::onInput);
        lightingFadeOutDistanceTBox = new TextBox();
        lightingFadeOutDistanceTBox.addChangeHandler(new MChangeHandler());
        lightingFadeOutDistanceTBox.setText("" + 10 * 1e6);
        lightingFadeOutDistanceTBox.setSize("100px", "12px");
        lightingFadeOutDistanceHPanel.add(lightingFadeOutDistanceSlider);
        lightingFadeOutDistanceHPanel.add(lightingFadeOutDistanceTBox);

        HorizontalPanel lightingFadeInDistanceHPanel = new HorizontalPanel();
        lightingFadeInDistanceHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        lightingFadeInDistanceHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        lightingFadeInDistanceHPanel.setSpacing(10);
        lightingFadeInDistanceSlider = new SliderBox(1e6, 20000000, 1e8, 1e6);
        lightingFadeInDistanceSlider.setStep(1);
        lightingFadeInDistanceSlider.setWidth("150px");
        lightingFadeInDistanceSlider.addInputHandler(this::onInput);
        lightingFadeInDistanceTBox = new TextBox();
        lightingFadeInDistanceTBox.addChangeHandler(new MChangeHandler());
        lightingFadeInDistanceTBox.setText("" + 20 * 1e6);
        lightingFadeInDistanceTBox.setSize("100px", "12px");
        lightingFadeInDistanceHPanel.add(lightingFadeInDistanceSlider);
        lightingFadeInDistanceHPanel.add(lightingFadeInDistanceTBox);

        HorizontalPanel nightFadeOutDistanceHPanel = new HorizontalPanel();
        nightFadeOutDistanceHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        nightFadeOutDistanceHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        nightFadeOutDistanceHPanel.setSpacing(10);
        nightFadeOutDistanceSlider = new SliderBox(1e6, 10000000, 1e8, 1e6);
        nightFadeOutDistanceSlider.setStep(1);
        nightFadeOutDistanceSlider.setWidth("150px");
        nightFadeOutDistanceSlider.addInputHandler(this::onInput);
        nightFadeOutDistanceTBox = new TextBox();
        nightFadeOutDistanceTBox.addChangeHandler(new MChangeHandler());
        nightFadeOutDistanceTBox.setText("" + 10 * 1e6);
        nightFadeOutDistanceTBox.setSize("100px", "12px");
        nightFadeOutDistanceHPanel.add(nightFadeOutDistanceSlider);
        nightFadeOutDistanceHPanel.add(nightFadeOutDistanceTBox);

        HorizontalPanel nightFadeInDistanceHPanel = new HorizontalPanel();
        nightFadeInDistanceHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        nightFadeInDistanceHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        nightFadeInDistanceHPanel.setSpacing(10);
        nightFadeInDistanceSlider = new SliderBox(1e6, 50000000, 1e8, 1e6);
        nightFadeInDistanceSlider.setStep(1);
        nightFadeInDistanceSlider.setWidth("150px");
        nightFadeInDistanceSlider.addInputHandler(this::onInput);
        nightFadeInDistanceTBox = new TextBox();
        nightFadeInDistanceTBox.addChangeHandler(new MChangeHandler());
        nightFadeInDistanceTBox.setText("" + 50 * 1e6);
        nightFadeInDistanceTBox.setSize("100px", "12px");
        nightFadeInDistanceHPanel.add(nightFadeInDistanceSlider);
        nightFadeInDistanceHPanel.add(nightFadeInDistanceTBox);

        CheckBox groundAtmosphereCBox = new CheckBox();
        groundAtmosphereCBox.setWidth("100px");
        groundAtmosphereCBox.setValue(true);
        groundAtmosphereCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                globe.showGroundAtmosphere = event.getValue();
            }
        });

        CheckBox lightingBox = new CheckBox();
        lightingBox.setWidth("100px");
        lightingBox.setValue(false);
        lightingBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                globe.enableLighting = event.getValue();
            }
        });

        ListBox terrainsLBox = new ListBox();
        terrainsLBox.setWidth("160px");
        terrainsLBox.addItem("Cesium World Terrain - no effects", "0");
        terrainsLBox.addItem("Cesium World Terrain w/ Vertex Normals", "1");
        terrainsLBox.addItem("Cesium World Terrain w/ Water", "2");
        terrainsLBox.addItem("Cesium World Terrain w/ Vertex Normals and Water", "3");
        terrainsLBox.addItem("EllipsoidTerrainProvider", "4");
        terrainsLBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                ListBox source = (ListBox) changeEvent.getSource();
                switch (source.getSelectedValue()) {
                    case "0": {
                        csVPanel.getViewer().terrainProvider = Cesium.createWorldTerrain();
                    }
                    break;
                    case "1": {
                        Cesium.CreateWorldTerrainOptions options = new Cesium.CreateWorldTerrainOptions();
                        options.requestVertexNormals = true;
                        csVPanel.getViewer().terrainProvider = Cesium.createWorldTerrain(options);
                    }
                    break;
                    case "2": {
                        Cesium.CreateWorldTerrainOptions options = new Cesium.CreateWorldTerrainOptions();
                        options.requestWaterMask = true;
                        csVPanel.getViewer().terrainProvider = Cesium.createWorldTerrain(options);
                    }
                    break;
                    case "3": {
                        Cesium.CreateWorldTerrainOptions options = new Cesium.CreateWorldTerrainOptions();
                        options.requestVertexNormals = true;
                        options.requestWaterMask = true;
                        csVPanel.getViewer().terrainProvider = Cesium.createWorldTerrain(options);
                    }
                    break;
                    case "4": {
                        csVPanel.getViewer().terrainProvider = new EllipsoidTerrainProvider();
                    }
                    break;
                    default:
                        break;
                }
            }
        });

        PushButton resetFadeDistancesPBtn = new PushButton();
        resetFadeDistancesPBtn.setText("Reset Fade Distances");
        resetFadeDistancesPBtn.setWidth("160px");
        resetFadeDistancesPBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                globe.lightingFadeOutDistance = lightingFadeOutDistance;
                globe.lightingFadeInDistance = lightingFadeInDistance;
                globe.nightFadeOutDistance = nightFadeOutDistance;
                globe.nightFadeInDistance = nightFadeInDistance;

                lightingFadeOutDistanceSlider.setValue((int) (lightingFadeOutDistance / 1e6));
                lightingFadeInDistanceSlider.setValue((int) (lightingFadeInDistance / 1e6));
                nightFadeOutDistanceSlider.setValue((int) (nightFadeOutDistance / 1e6));
                nightFadeInDistanceSlider.setValue((int) (nightFadeInDistance / 1e6));

                lightingFadeOutDistanceTBox.setValue(String.valueOf(lightingFadeOutDistance), true);
                lightingFadeInDistanceTBox.setValue(String.valueOf(lightingFadeInDistance), true);
                nightFadeOutDistanceTBox.setValue(String.valueOf(nightFadeOutDistance), true);
                nightFadeInDistanceTBox.setValue(String.valueOf(nightFadeInDistance), true);
            }
        });

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Lighting Fade Out Distance</font>");
        flexTable.setWidget(1, 1, lightingFadeOutDistanceHPanel);
        flexTable.setHTML(2, 0, "<font color=\"white\">Lighting Fade In Distance</font>");
        flexTable.setWidget(2, 1, lightingFadeInDistanceHPanel);
        flexTable.setHTML(3, 0, "<font color=\"white\">Night Fade Out Distance</font>");
        flexTable.setWidget(3, 1, nightFadeOutDistanceHPanel);
        flexTable.setHTML(4, 0, "<font color=\"white\">Night Fade In Distance</font>");
        flexTable.setWidget(4, 1, nightFadeInDistanceHPanel);
        flexTable.setHTML(5, 0, "<font color=\"white\">Ground atmosphere</font>");
        flexTable.setWidget(5, 1, groundAtmosphereCBox);
        flexTable.setHTML(6, 0, "<font color=\"white\">Lighting</font>");
        flexTable.setWidget(6, 1, lightingBox);
        flexTable.setWidget(7, 1, terrainsLBox);
        flexTable.setWidget(8, 1, resetFadeDistancesPBtn);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Adjust hue, saturation, and brightness of the sky/atmosphere.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    private class MChangeHandler implements ChangeHandler {
        @Override
        public void onChange(ChangeEvent changeEvent) {
            TextBox source = (TextBox) changeEvent.getSource();
            double value = Double.parseDouble(source.getValue());
            if (source == lightingFadeOutDistanceTBox) {
                globe.lightingFadeOutDistance = value;
                lightingFadeOutDistanceSlider.setValue((int) (value / 1e6));
            } else if (source == lightingFadeInDistanceTBox) {
                globe.lightingFadeInDistance = value;
                lightingFadeInDistanceSlider.setValue((int) (value / 1e6));
            } else if (source == nightFadeOutDistanceTBox) {
                globe.nightFadeOutDistance = value;
                nightFadeOutDistanceSlider.setValue((int) (value / 1e6));
            } else if (source == nightFadeInDistanceTBox) {
                globe.nightFadeInDistance = value;
                nightFadeInDistanceSlider.setValue((int) (value / 1e6));
            }
        }
    }

    private void onInput(InputEvent event) {
        SliderBox source = (SliderBox) event.getSource();
        double value = source.getValue();
        if (source == lightingFadeOutDistanceSlider) {
            globe.lightingFadeOutDistance = value;
            lightingFadeOutDistanceTBox.setText(String.valueOf(value));
        } else if (source == lightingFadeInDistanceSlider) {
            globe.lightingFadeInDistance = value;
            lightingFadeInDistanceTBox.setText(String.valueOf(value));
        } else if (source == nightFadeOutDistanceSlider) {
            globe.nightFadeOutDistance = value;
            nightFadeOutDistanceTBox.setText(String.valueOf(value));
        } else if (source == nightFadeInDistanceSlider) {
            globe.nightFadeInDistance = value;
            nightFadeInDistanceTBox.setText(String.valueOf(value));
        }
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "GroundAtmosphere.txt";
        return sourceCodeURLs;
    }
}
