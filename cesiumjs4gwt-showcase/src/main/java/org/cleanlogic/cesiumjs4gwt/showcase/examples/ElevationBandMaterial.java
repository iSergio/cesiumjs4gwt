/*
 * Copyright 2021 iserge.
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
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.Slider;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderListener;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ElevationBandMaterial extends AbstractExample {
    private boolean gradient = false;
    private double band1Position = 7000.0;
    private double band2Position = 7500.0;
    private double band3Position = 8000.0;
    private double bandThickness = 100.0;
    private double bandTransparency = 0.5;
    private double backgroundTransparency = 0.75;

    private ViewerPanel csVPanel;

    private Slider backgroundTransparencySlider;
    private Slider bandTransparencySlider;
    private Slider bandThicknessSlider;
    private Slider band1PositionSlider;
    private Slider band2PositionSlider;
    private Slider band3PositionSlider;
    private CheckBox gradientCBox;

    @Inject
    public ElevationBandMaterial(ShowcaseExampleStore store) {
        super("Elevation Band Material",
                "Apply elevation band material to the globe",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "Elevation", "Band", "Material"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        csVPanel.getViewer().terrainProvider = Cesium.createWorldTerrain(Cesium.CreateWorldTerrainOptions.create(true));

        ViewOptions cameraViewOptions = new ViewOptions();
        cameraViewOptions.destinationPos = new Cartesian3(290637.5534733206, 5637471.593707632, 2978256.8126927214);
        cameraViewOptions.orientation = new HeadingPitchRoll(4.747266966349747, -0.2206998858596192, 6.280340554587955);
        csVPanel.getViewer().camera.setView(cameraViewOptions);

        backgroundTransparencySlider = new Slider("backgroundTransparency", 1, 100, 75);
        backgroundTransparencySlider.setStep(1);
        backgroundTransparencySlider.setWidth("150px");
        backgroundTransparencySlider.addListener(new MSliderListener());

        bandTransparencySlider = new Slider("bandTransparency", 1, 100, 50);
        bandTransparencySlider.setStep(1);
        bandTransparencySlider.setWidth("150px");
        bandTransparencySlider.addListener(new MSliderListener());

        bandThicknessSlider = new Slider("bandThickness", 10, 1000, 100);
        bandThicknessSlider.setStep(1);
        bandThicknessSlider.setWidth("150px");
        bandThicknessSlider.addListener(new MSliderListener());

        band1PositionSlider = new Slider("band1Position", 4000, 8848, 7000);
        band1PositionSlider.setStep(1);
        band1PositionSlider.setWidth("150px");
        band1PositionSlider.addListener(new MSliderListener());

        band2PositionSlider = new Slider("band2Position", 4000, 8848, 7500);
        band2PositionSlider.setStep(1);
        band2PositionSlider.setWidth("150px");
        band2PositionSlider.addListener(new MSliderListener());

        band3PositionSlider = new Slider("band3Position", 4000, 8848, 8000);
        band3PositionSlider.setStep(1);
        band3PositionSlider.setWidth("150px");
        band3PositionSlider.addListener(new MSliderListener());

        gradientCBox = new CheckBox();
        gradientCBox.setValue(false);
        gradientCBox.addValueChangeHandler(event -> {
            gradient = event.getValue();
            updateMaterial();
        });

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Background Transparency</font>");
        flexTable.setWidget(1, 1, backgroundTransparencySlider);
        flexTable.setHTML(2, 0, "<font color=\"white\">Band Transparency</font>");
        flexTable.setWidget(2, 1, bandTransparencySlider);
        flexTable.setHTML(3, 0, "<font color=\"white\">Band Thickness</font>");
        flexTable.setWidget(3, 1, bandThicknessSlider);
        flexTable.setHTML(4, 0, "<font color=\"white\">Band 1 Position</font>");
        flexTable.setWidget(4, 1, band1PositionSlider);
        flexTable.setHTML(5, 0, "<font color=\"white\">Band 2 Position</font>");
        flexTable.setWidget(5, 1, band2PositionSlider);
        flexTable.setHTML(6, 0, "<font color=\"white\">Band 3 Position</font>");
        flexTable.setWidget(6, 1, band3PositionSlider);
        flexTable.setHTML(7, 0, "<font color=\"white\">Gradient</font>");
        flexTable.setWidget(7, 1, gradientCBox);

        AbsolutePanel absPanel = new AbsolutePanel();
        absPanel.add(csVPanel);
        absPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML(
                "<p>Apply elevation band material to the globe.</p>"));
        contentPanel.add(absPanel);

        initWidget(contentPanel);

        updateMaterial();
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ElevationBandMaterial.txt";
        return sourceCodeURLs;
    }

    public void updateMaterial() {
        List<ElevationBandMaterialBand> layers = new ArrayList<>();

        ElevationBandMaterialBand band = ElevationBandMaterialBand.create(new ElevationBandMaterialEntry[]{
                ElevationBandMaterialEntry.create(4200.0, new Color(0., 0., 0.2, backgroundTransparency)),
                ElevationBandMaterialEntry.create(8000.0, new Color(1., 1., 1., backgroundTransparency)),
                ElevationBandMaterialEntry.create(8500.0, new Color(1., 0., 0., backgroundTransparency))
        });
        band.extendDownwards = true;
        band.extendUpwards = true;

        layers.add(band);

        double gridStartHeight = 4200.0;
        double gridEndHeight = 8848.0;
        int gridCount = 50;
        for (int i = 0; i < gridCount; i++) {
            double lerper = i / (gridCount - 1.);
            double heightBelow = Math.lerp(gridStartHeight, gridEndHeight, lerper);
            double heightAbove = heightBelow + 10.0;
            double alpha = Math.lerp(0.2, 0.4, lerper) * backgroundTransparency;

            layers.add(ElevationBandMaterialBand.create(new ElevationBandMaterialEntry[]{
                    ElevationBandMaterialEntry.create(heightBelow, new Color(1., 1., 1., alpha)),
                    ElevationBandMaterialEntry.create(heightAbove, new Color(1., 1., 1., alpha))
            }));
        }

        double antialias = java.lang.Math.min(10.0, bandThickness * 0.1);

        if (!gradient) {
            ElevationBandMaterialBand band1 = ElevationBandMaterialBand.create(new ElevationBandMaterialEntry[]{
                    ElevationBandMaterialEntry.create(band1Position - bandThickness * 0.5 - antialias,
                            new Color(0., 0., 1., 0.0)),
                    ElevationBandMaterialEntry.create(band1Position - bandThickness * 0.5,
                            new Color(0., 0., 1., bandTransparency)),
                    ElevationBandMaterialEntry.create(band1Position + bandThickness * 0.5,
                            new Color(0., 0., 1., bandTransparency)),
                    ElevationBandMaterialEntry.create(band1Position + bandThickness * 0.5 + antialias,
                            new Color(0., 0., 1., 0.))
            });

            ElevationBandMaterialBand band2 = ElevationBandMaterialBand.create(new ElevationBandMaterialEntry[]{
                    ElevationBandMaterialEntry.create(band2Position - bandThickness * 0.5 - antialias,
                            new Color(0., 1., 0., 0.0)),
                    ElevationBandMaterialEntry.create(band2Position - bandThickness * 0.5,
                            new Color(0., 1., 0., bandTransparency)),
                    ElevationBandMaterialEntry.create(band2Position + bandThickness * 0.5,
                            new Color(0., 1., 0., bandTransparency)),
                    ElevationBandMaterialEntry.create(band2Position + bandThickness * 0.5 + antialias,
                            new Color(0., 1., 0., 0.))
            });

            ElevationBandMaterialBand band3 = ElevationBandMaterialBand.create(new ElevationBandMaterialEntry[]{
                    ElevationBandMaterialEntry.create(band3Position - bandThickness * 0.5 - antialias,
                            new Color(1., 0., 0., 0.0)),
                    ElevationBandMaterialEntry.create(band3Position - bandThickness * 0.5,
                            new Color(1., 0., 0., bandTransparency)),
                    ElevationBandMaterialEntry.create(band3Position + bandThickness * 0.5,
                            new Color(1., 0., 0., bandTransparency)),
                    ElevationBandMaterialEntry.create(band3Position + bandThickness * 0.5 + antialias,
                            new Color(1., 0., 0., 0.))
            });

            layers.add(band1);
            layers.add(band2);
            layers.add(band3);
        } else {
            ElevationBandMaterialBand combinedBand = ElevationBandMaterialBand.create(new ElevationBandMaterialEntry[]{
                    ElevationBandMaterialEntry.create(band1Position - bandThickness * 0.5,
                            new Color(0., 0., 1., bandTransparency)),
                    ElevationBandMaterialEntry.create(band2Position,
                            new Color(0., 1., 0., bandTransparency)),
                    ElevationBandMaterialEntry.create(band3Position + bandThickness * 0.5,
                            new Color(1., 0., 0., bandTransparency))
            });

            layers.add(combinedBand);
        }

        csVPanel.getViewer().scene().globe.material = Cesium.createElevationBandMaterial(Cesium.ElevationBandMaterialOptions.create(
                csVPanel.getViewer().scene(), layers.toArray(new ElevationBandMaterialBand[0])
        ));
    }

    private class MSliderListener implements SliderListener {

        @Override
        public void onStart(SliderEvent e) {

        }

        @Override
        public boolean onSlide(SliderEvent e) {
            Slider source = e.getSource();
            double value = source.getValue();
            if (source == backgroundTransparencySlider) {
                backgroundTransparency = value / 100.;
            } else if (source == bandTransparencySlider) {
                bandTransparency = value / 100.;
            } else if (source == bandThicknessSlider) {
                bandThickness = value;
            } else if (source == band1PositionSlider) {
                band1Position = value;
            } else if (source == band2PositionSlider) {
                band2Position = value;
            } else if (source == band3PositionSlider) {
                band3Position = value;
            }

            updateMaterial();

            return true;
        }

        @Override
        public void onChange(SliderEvent e) {

        }

        @Override
        public void onStop(SliderEvent e) {

        }
    }
}
