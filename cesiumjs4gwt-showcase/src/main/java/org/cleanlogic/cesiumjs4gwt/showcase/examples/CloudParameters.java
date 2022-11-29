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
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.collections.CloudCollection;
import org.cesiumjs.cs.collections.options.CloudCollectionOptions;
import org.cesiumjs.cs.collections.options.CumulusCloudAddOptions;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.scene.CumulusCloud;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.InputEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderBox;

import javax.inject.Inject;

public class CloudParameters extends AbstractExample {
    static final class ICloudParameters {
        boolean scaleWithMaximumSize = true;
        double scaleX = 25;
        double scaleY = 12;
        double maximumSizeX = 25;
        double maximumSizeY = 12;
        double maximumSizeZ = 15;
        boolean renderSlice = true; // if false, renders the entire surface of the ellipsoid
        double slice = 0.36;
        double brightness = 1.0;
    }

    ICloudParameters cloudParameters = new ICloudParameters();

    CumulusCloud cloud = null;

    private SliderBox scaleXSlider;
    private TextBox scaleXTBox;
    private SliderBox scaleYSlider;
    private TextBox scaleYTBox;
    private SliderBox maxSizeXSlider;
    private TextBox maxSizeXTBox;
    private SliderBox maxSizeYSlider;
    private TextBox maxSizeYTBox;
    private SliderBox maxSizeZSlider;
    private TextBox maxSizeZTBox;
    private SliderBox sliceSlider;
    private TextBox sliceTBox;
    private SliderBox brightnessSlider;
    private TextBox brightnessTBox;

    @Inject
    public CloudParameters(ShowcaseExampleStore store) {
        super("Cloud Parameters",
                "Modify the appearance of a procedural cumulus cloud",
                new String[]{"Showcase", "Cesium", "3d", "Clouds", "Params"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        Viewer viewer = csVPanel.getViewer();
        Scene scene = viewer.scene();
        Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, 50);

        // These noise parameters are set to default, but can be changed
        // to produce different cloud results. However, the noise is precomputed,
        // so this cannot be changed dynamically.
        CloudCollectionOptions cloudCollectionOptions = new CloudCollectionOptions();
        cloudCollectionOptions.noiseDetail = 16.0;
        cloudCollectionOptions.noiseOffset = Cartesian3.ZERO();
        CloudCollection clouds = (CloudCollection) scene.primitives().add(new CloudCollection(cloudCollectionOptions));

        CumulusCloudAddOptions options = new CumulusCloudAddOptions();
        options.position = position;
        options.scale = new Cartesian2(cloudParameters.scaleX, cloudParameters.scaleY);
        options.maximumSize = new Cartesian3(cloudParameters.maximumSizeX, cloudParameters.maximumSizeY, cloudParameters.maximumSizeZ);
        options.slice = cloudParameters.renderSlice ? cloudParameters.slice : -1.0;
        options.brightness = cloudParameters.brightness;
        cloud = clouds.add(options);

        viewer.camera.lookAt(position, new Cartesian3(30, 30, -10));

        CheckBox maxScaleCBox = new CheckBox();
        maxScaleCBox.setWidth("100px");
        maxScaleCBox.setValue(true);
        maxScaleCBox.addValueChangeHandler(value -> {
            if (value.getValue()) {
                cloudParameters.scaleX = cloudParameters.maximumSizeX;
                cloudParameters.scaleY = cloudParameters.maximumSizeY;
            }
            enableScaleXY(!value.getValue());
        });

        HorizontalPanel scaleXHPanel = new HorizontalPanel();
        scaleXHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        scaleXHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        scaleXHPanel.setSpacing(10);
        scaleXSlider = new SliderBox(5., cloudParameters.scaleX, 50., 1.);
        scaleXSlider.setStep(1);
        scaleXSlider.setWidth("150px");
        scaleXSlider.addInputHandler(this::onSliderInput);
        scaleXTBox = new TextBox();
        scaleXTBox.setText(cloudParameters.scaleX + "");
        scaleXTBox.setSize("30px", "12px");
        scaleXHPanel.add(scaleXSlider);
        scaleXHPanel.add(scaleXTBox);

        HorizontalPanel scaleYHPanel = new HorizontalPanel();
        scaleYHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        scaleYHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        scaleYHPanel.setSpacing(10);
        scaleYSlider = new SliderBox(5., cloudParameters.scaleY, 50., 1.);
        scaleYSlider.setWidth("150px");
        scaleYSlider.addInputHandler(this::onSliderInput);
        scaleYTBox = new TextBox();
        scaleYTBox.setText(cloudParameters.scaleY + "");
        scaleYTBox.setSize("30px", "12px");
        scaleYHPanel.add(scaleYSlider);
        scaleYHPanel.add(scaleYTBox);

        HorizontalPanel maxSizeXHPanel = new HorizontalPanel();
        maxSizeXHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        maxSizeXHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        maxSizeXHPanel.setSpacing(10);
        maxSizeXSlider = new SliderBox(5., cloudParameters.maximumSizeX, 50., 1.);
        maxSizeXSlider.setWidth("150px");
        maxSizeXSlider.addInputHandler(this::onSliderInput);
        maxSizeXTBox = new TextBox();
        maxSizeXTBox.setText(cloudParameters.maximumSizeX + "");
        maxSizeXTBox.setSize("30px", "12px");
        maxSizeXHPanel.add(maxSizeXSlider);
        maxSizeXHPanel.add(maxSizeXTBox);

        HorizontalPanel maxSizeYHPanel = new HorizontalPanel();
        maxSizeYHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        maxSizeYHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        maxSizeYHPanel.setSpacing(10);
        maxSizeYSlider = new SliderBox(5., cloudParameters.maximumSizeY, 50., 1.0);
        maxSizeYSlider.setWidth("150px");
        maxSizeYSlider.addInputHandler(this::onSliderInput);
        maxSizeYTBox = new TextBox();
        maxSizeYTBox.setText(cloudParameters.maximumSizeY + "");
        maxSizeYTBox.setSize("30px", "12px");
        maxSizeYHPanel.add(maxSizeYSlider);
        maxSizeYHPanel.add(maxSizeYTBox);

        HorizontalPanel maxSizeZHPanel = new HorizontalPanel();
        maxSizeZHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        maxSizeZHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        maxSizeZHPanel.setSpacing(10);
        maxSizeZSlider = new SliderBox(5., cloudParameters.maximumSizeZ, 50., 1.);
        maxSizeZSlider.setWidth("150px");
        maxSizeZSlider.addInputHandler(this::onSliderInput);
        maxSizeZTBox = new TextBox();
        maxSizeZTBox.setText(cloudParameters.maximumSizeZ + "");
        maxSizeZTBox.setSize("30px", "12px");
        maxSizeZHPanel.add(maxSizeZSlider);
        maxSizeZHPanel.add(maxSizeZTBox);

        CheckBox renderSliceCBox = new CheckBox();
        renderSliceCBox.setWidth("100px");
        renderSliceCBox.setValue(true);
        renderSliceCBox.addValueChangeHandler(event -> {
            if (event.getValue()) {
                sliceSlider.setEnabled(event.getValue());
                sliceTBox.setEnabled(event.getValue());
                cloud.slice = (float) cloudParameters.slice;
            } else {
                cloud.slice = -1.0f;
            }
        });

        HorizontalPanel sliceHPanel = new HorizontalPanel();
        sliceHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        sliceHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        sliceHPanel.setSpacing(10);
        sliceSlider = new SliderBox(0., cloudParameters.slice, 1., 0.01);
        sliceSlider.setWidth("150px");
        sliceSlider.addInputHandler(this::onSliderInput);
        sliceTBox = new TextBox();
        sliceTBox.setText(cloudParameters.slice + "");
        sliceTBox.setSize("30px", "12px");
        sliceHPanel.add(sliceSlider);
        sliceHPanel.add(sliceTBox);

        ListBox colorsLBox = new ListBox();
        colorsLBox.addItem("White", Color.WHITE().toCssHexString());
        colorsLBox.addItem("Red", Color.RED().toCssColorString());
        colorsLBox.addItem("Green", Color.GREEN().toCssHexString());
        colorsLBox.addItem("Blue", Color.BLUE().toCssHexString());
        colorsLBox.addItem("Yellow", Color.YELLOW().toCssHexString());
        colorsLBox.addItem("Gray", Color.GRAY().toCssHexString());
        colorsLBox.addChangeHandler(event -> {
            ListBox source = (ListBox) event.getSource();
            String value = source.getSelectedValue();
            cloud.color = Color.fromCssColorString(value, new Color());
        });

        HorizontalPanel brightnessHPanel = new HorizontalPanel();
        brightnessHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        brightnessHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        brightnessHPanel.setSpacing(10);
        brightnessSlider = new SliderBox(0, 1, 1, 0.01);
        brightnessSlider.addInputHandler(this::onSliderInput);
        brightnessTBox = new TextBox();
        brightnessTBox.setText(cloudParameters.brightness + "");
        brightnessTBox.setSize("30px", "12px");
        brightnessHPanel.add(brightnessSlider);
        brightnessHPanel.add(brightnessTBox);

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Scale with Max Size</font>");
        flexTable.setWidget(1, 1, maxScaleCBox);
        flexTable.setWidget(2, 0, new HTML("<font color=\"white\">Scale X</font>"));
        flexTable.setWidget(2, 1, scaleXHPanel);
        flexTable.setWidget(3, 0, new HTML("<font color=\"white\">Scale Y</font>"));
        flexTable.setWidget(3, 1, scaleYHPanel);
        flexTable.setHTML(4, 0, "<font color=\"white\">Maximum Size X</font>");
        flexTable.setWidget(4, 1, maxSizeXHPanel);
        flexTable.setHTML(5, 0, "<font color=\"white\">Maximum Size Y</font>");
        flexTable.setWidget(5, 1, maxSizeYHPanel);
        flexTable.setHTML(6, 0, "<font color=\"white\">Maximum Size Z</font>");
        flexTable.setWidget(6, 1, maxSizeZHPanel);
        flexTable.setHTML(7, 0, "<font color=\"white\">Render Slice</font>");
        flexTable.setWidget(7, 1, renderSliceCBox);
        flexTable.setWidget(8, 0, new HTML("<font color=\"white\">Slice</font>"));
        flexTable.setWidget(8, 1, sliceHPanel);
        flexTable.setHTML(9, 0, "<font color=\"white\">Color</font>");
        flexTable.setWidget(9, 1, colorsLBox);
        flexTable.setHTML(10, 0, "<font color=\"white\">Brightness</font>");
        flexTable.setWidget(10, 1, brightnessHPanel);

        enableScaleXY(false);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML(
                "<p>Modify the appearance of a procedural cumulus cloud.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    private void enableScaleXY(boolean enable) {
        scaleXSlider.setEnabled(enable);
        scaleXTBox.setEnabled(enable);
        scaleYSlider.setEnabled(enable);
        scaleYTBox.setEnabled(enable);
    }

    private void onSliderInput(InputEvent event) {
        SliderBox source = (SliderBox) event.getSource();
        double value = source.getValue();
        if (source.equals(scaleXSlider)) {
            onScaleXInput(String.valueOf(value));
        } else if (source.equals(scaleYSlider)) {
            onScaleYInput(String.valueOf(value));
        } else if (source.equals(maxSizeXSlider)) {
            onMaxSizeXInput(String.valueOf(value));
        } else if (source.equals(maxSizeYSlider)) {
            onMaxSizeYInput(String.valueOf(value));
        } else if (source.equals(maxSizeZSlider)) {
            onMaxSizeZInput(String.valueOf(value));
        } else if (source.equals(sliceSlider)) {
            onSliceInput(String.valueOf(value));
        } else if (source.equals(brightnessSlider)) {
            onBrightnessInput(String.valueOf(value));
        }
    }

    private void onScaleXInput(String value) {
        cloud.scale = new Cartesian2(Double.parseDouble(value), cloud.scale.y);
        scaleXTBox.setText(value);
    }

    private void onScaleYInput(String value) {
        cloud.scale = new Cartesian2(cloud.scale.x, Double.parseDouble(value));
        scaleYTBox.setText(value);
    }

    private void onMaxSizeXInput(String value) {
        cloud.maximumSize = new Cartesian3(Double.parseDouble(value), cloud.maximumSize.y, cloud.maximumSize.z);
        if (cloudParameters.scaleWithMaximumSize) {
            cloud.scale = new Cartesian2(Double.parseDouble(value), cloud.scale.y);
        }
        maxSizeXTBox.setText(value);
    }

    private void onMaxSizeYInput(String value) {
        cloud.maximumSize = new Cartesian3(cloud.maximumSize.x, Double.parseDouble(value), cloud.maximumSize.z);
        if (cloudParameters.scaleWithMaximumSize) {
            cloud.scale = new Cartesian2(cloud.scale.x, Double.parseDouble(value));
        }
        maxSizeYTBox.setText(value);
    }

    private void onMaxSizeZInput(String value) {
        cloud.maximumSize = new Cartesian3(cloud.maximumSize.x, cloud.maximumSize.y, Double.parseDouble(value));
        maxSizeZTBox.setText(value);
    }

    private void onSliceInput(String value) {
        cloud.slice = Float.parseFloat(value);
        cloudParameters.slice = cloud.slice;
        sliceTBox.setText(value);
    }

    private void onBrightnessInput(String value) {
        cloud.brightness = Float.parseFloat(value);;
        brightnessTBox.setText(value);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CloudParameters.txt";
        return sourceCodeURLs;
    }
}
