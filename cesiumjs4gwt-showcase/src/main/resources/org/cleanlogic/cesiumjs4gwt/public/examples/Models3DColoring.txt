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
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.scene.enums.ColorBlendMode;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.InputEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderBox;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class Models3DColoring extends AbstractExample {
    private ViewerPanel csVPanel;
    private SliderBox mixSlider;
    private TextBox mixTBox;

    private SliderBox alphaSlider;
    private TextBox alphaTBox;

    private SliderBox silhouetteAlphaSlider;
    private TextBox silhouetteAlphaTBox;

    private SliderBox silhouetteSizeSlider;
    private TextBox silhouetteSizeTBox;

    // private Color color = Color.RED();
    private String colorStr = "red";
    private float alpha = 1.0f;
    private Number colorBlendMode = ColorBlendMode.HIGHLIGHT();
    private double colorBlendAmount = 0.5f;

    private Color silhouetteColor = Color.RED();
    private String silhouetteColorStr = "red";
    private float silhouetteAlpha = 1.0f;
    private float silhouetteSize = 2.0f;

    @Inject
    public Models3DColoring(ShowcaseExampleStore store) {
        super("3D Models Coloring", "Create 3D models coloring",
                new String[]{"Showcase", "Cesium", "3d", "gltf", "glb", "models", "ColorBlendMode"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions csViewerOptions = new ViewerOptions();
        csViewerOptions.infoBox = false;
        csViewerOptions.selectionIndicator = false;
        csViewerOptions.shadows = false;
        csViewerOptions.shouldAnimate = true;
        csVPanel = new ViewerPanel(csViewerOptions);

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(
                GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb");
        modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(128);
        modelGraphicsOptions.maximumScale = new ConstantProperty<>(20000);
        modelGraphicsOptions.color = new ConstantProperty<>(getColor("red", alpha));
        modelGraphicsOptions.colorBlendMode = new ConstantProperty<>(ColorBlendMode.HIGHLIGHT());
        modelGraphicsOptions.colorBlendAmount = new ConstantProperty<>(colorBlendAmount);
        modelGraphicsOptions.silhouetteColor = new ConstantProperty<>(getColor("red", alpha));
        modelGraphicsOptions.silhouetteSize = new ConstantProperty<>(silhouetteSize);

        ModelGraphics modelGraphics = new ModelGraphics(modelGraphicsOptions);

        Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, 5000.0);
        double heading = Math.toRadians(135);
        double pitch = 0;
        double roll = 0;
        org.cesiumjs.cs.core.HeadingPitchRoll hpr = new org.cesiumjs.cs.core.HeadingPitchRoll(heading, pitch, roll);
        Quaternion orientation = Transforms.headingPitchRollQuaternion(position, hpr);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.name = GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb";
        entityOptions.position = new ConstantPositionProperty(position);
        entityOptions.orientation = new ConstantProperty<>(orientation);
        entityOptions.model = modelGraphics;
        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(entityOptions);

        ListBox modeLBox = new ListBox();
        modeLBox.addItem("Hightlight", "0");
        modeLBox.addItem("Replace", "1");
        modeLBox.addItem("Mix", "2");
        modeLBox.addChangeHandler(this::onModeLBoxChange);

        ListBox colorLBox = new ListBox();
        colorLBox.addItem("White", "White");
        colorLBox.addItem("Red", "Red");
        colorLBox.addItem("Green", "Green");
        colorLBox.addItem("Blue", "Blue");
        colorLBox.addItem("Yellow", "Yellow");
        colorLBox.addItem("Gray", "Gray");
        colorLBox.setSelectedIndex(1);
        colorLBox.addChangeHandler(this::onColorLBoxChange);

        alphaSlider = new SliderBox(0, 1, 1, 0.01);
        alphaSlider.setWidth("100px");
        alphaSlider.addInputHandler(this::onSliderInput);
        alphaTBox = new TextBox();
        alphaTBox.setSize("30px", "12px");
        alphaTBox.setValue("" + 1);
        alphaTBox.addChangeHandler(this::onTextChange);

        mixSlider = new SliderBox(0, 0.5, 1, 0.01);
        mixSlider.setVisible(false);
        mixSlider.addInputHandler(this::onSliderInput);
        mixTBox = new TextBox();
        mixTBox.setSize("30px", "12px");
        mixTBox.setValue("0.5");
        mixTBox.setVisible(false);
        mixTBox.addChangeHandler(this::onTextChange);

        ListBox silhouetteColorLBox = new ListBox();
        silhouetteColorLBox.addItem("Red", "Red");
        silhouetteColorLBox.addItem("Green", "Green");
        silhouetteColorLBox.addItem("Blue", "Blue");
        silhouetteColorLBox.addItem("Yellow", "Yellow");
        silhouetteColorLBox.addItem("Gray", "Gray");
        silhouetteColorLBox.addChangeHandler(this::onSilhouetteColorLBoxChange);

        silhouetteAlphaSlider = new SliderBox(0, 1, 1, 0.01);
        silhouetteAlphaSlider.addInputHandler(this::onSliderInput);
        silhouetteAlphaTBox = new TextBox();
        silhouetteAlphaTBox.setSize("30px", "12px");
        silhouetteAlphaTBox.setValue("" + 1);
        silhouetteAlphaTBox.addChangeHandler(this::onTextChange);

        silhouetteSizeSlider = new SliderBox(0, 2, 10, 0.01);
        silhouetteSizeSlider.addInputHandler(this::onSliderInput);
        silhouetteSizeTBox = new TextBox();
        silhouetteSizeTBox.setSize("30px", "12px");
        silhouetteSizeTBox.setValue("" + 2);
        silhouetteSizeTBox.addChangeHandler(this::onTextChange);

        final ListBox modelsLBox = new ListBox();
        modelsLBox.addItem("Aircraft", "0");
        modelsLBox.addItem("Ground vehicle", "1");
        modelsLBox.addItem("Hot Air Balloon", "2");
        modelsLBox.addItem("Milk truck", "3");
        modelsLBox.addItem("Skinned character", "4");
        modelsLBox.addChangeHandler(this::onModelsLBoxChange);

        CheckBox shadowsCBox = new CheckBox("Shadows");
        shadowsCBox.getElement().getStyle().setColor("white");
        shadowsCBox.setWidth("100px");
        shadowsCBox.setValue(true);
        shadowsCBox.addValueChangeHandler(event -> csVPanel.getViewer().shadows = event.getValue());

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Model Color</font>");
        flexTable.setHTML(2, 0, "<font color=\"white\">Mode</font>");
        flexTable.setWidget(2, 1, modeLBox);
        flexTable.setHTML(3, 0, "<font color=\"white\">Color</font>");
        flexTable.setWidget(3, 1, colorLBox);
        flexTable.setHTML(4, 0, "<font color=\"white\">Alpha</font>");
        flexTable.setWidget(4, 1, alphaSlider);
        flexTable.setWidget(4, 2, alphaTBox);
        flexTable.setHTML(5, 0, "<font color=\"white\">Mix</font>");
        flexTable.setWidget(5, 1, mixSlider);
        flexTable.setWidget(5, 2, mixTBox);
        flexTable.setHTML(6, 0, "<font color=\"white\">Model Silhouette</font>");
        flexTable.setHTML(7, 0, "<font color=\"white\">Color</font>");
        flexTable.setWidget(7, 1, silhouetteColorLBox);
        flexTable.setHTML(8, 0, "<font color=\"white\">Alpha</font>");
        flexTable.setWidget(8, 1, silhouetteAlphaSlider);
        flexTable.setWidget(8, 2, silhouetteAlphaTBox);
        flexTable.setHTML(9, 0, "<font color=\"white\">Size</font>");
        flexTable.setWidget(9, 1, silhouetteSizeSlider);
        flexTable.setWidget(9, 2, silhouetteSizeTBox);

        flexTable.setWidget(10, 0, modelsLBox);
        flexTable.setWidget(10, 1, shadowsCBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Create 3D coloring models.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    private void onModeLBoxChange(ChangeEvent event) {
        ListBox source = (ListBox) event.getSource();
        mixSlider.setVisible(false);
        mixTBox.setVisible(false);
        if (source.getSelectedValue().equalsIgnoreCase("0")) {
            colorBlendMode = ColorBlendMode.HIGHLIGHT();
        } else if (source.getSelectedValue().equalsIgnoreCase("1")) {
            colorBlendMode = ColorBlendMode.REPLACE();
        } else if (source.getSelectedValue().equalsIgnoreCase("2")) {
            colorBlendMode = ColorBlendMode.MIX();
            mixSlider.setVisible(true);
            mixTBox.setVisible(true);
        }

        csVPanel.getViewer().trackedEntity.model.colorBlendMode = new ConstantProperty<>(colorBlendMode);
    }

    private void onColorLBoxChange(ChangeEvent event) {
        ListBox source = (ListBox) event.getSource();
        colorStr = source.getSelectedValue();
        csVPanel.getViewer().trackedEntity.model.color = new ConstantProperty<>(getColor(source.getSelectedValue(), alpha));
    }

    private void onSilhouetteColorLBoxChange(ChangeEvent event) {
        ListBox source = (ListBox) event.getSource();
        silhouetteColorStr = source.getSelectedValue();
        silhouetteColor = getColor(source.getSelectedValue(), alpha);
        csVPanel.getViewer().trackedEntity.model.silhouetteColor = new ConstantProperty<>(
                getColor(silhouetteColorStr, silhouetteAlpha));
    }

    private void onSliderInput(InputEvent event) {
        SliderBox source = (SliderBox) event.getSource();
        float value = Float.parseFloat(source.getValue());
        if (source == alphaSlider) {
            onAlphaInput(value);
        } else if (source == mixSlider) {
            onMixInput((double) value);
        } else if (source == silhouetteAlphaSlider) {
            onSilhouetteAlphaInput(value);
        } else if (source == silhouetteSizeSlider) {
            onSilhouetteSizeInput(value);
        }
    }

    private void onAlphaInput(float value) {
        alphaTBox.setValue(String.valueOf(value));
        alpha = value;
        csVPanel.getViewer().trackedEntity.model.color = new ConstantProperty<>(getColor(colorStr, alpha));
    }

    private void onMixInput(double value) {
        mixTBox.setValue(String.valueOf(value));
        colorBlendAmount = value;
        csVPanel.getViewer().trackedEntity.model.colorBlendAmount = new ConstantProperty<>(colorBlendAmount);
    }

    private void onSilhouetteAlphaInput(float value) {
        silhouetteAlphaTBox.setValue(String.valueOf(value));
        silhouetteAlpha = value;
        csVPanel.getViewer().trackedEntity.model.silhouetteColor = new ConstantProperty<>(
                getColor(silhouetteColorStr, silhouetteAlpha));
    }

    private void onSilhouetteSizeInput(float value) {
        silhouetteSizeTBox.setValue(String.valueOf(value));
        silhouetteSize = value;
        csVPanel.getViewer().trackedEntity.model.silhouetteSize = new ConstantProperty<>(silhouetteSize);
    }

    private void createModel(String url, double height) {
        csVPanel.getViewer().entities().removeAll();

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(url);
        modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(128);
        modelGraphicsOptions.maximumScale = new ConstantProperty<>(20000);
        modelGraphicsOptions.color = new ConstantProperty<>(getColor(colorStr, alpha));
        modelGraphicsOptions.colorBlendAmount = new ConstantProperty<>(colorBlendMode);
        modelGraphicsOptions.silhouetteColor = new ConstantProperty<>(silhouetteColor);
        modelGraphicsOptions.silhouetteSize = new ConstantProperty<>(silhouetteSize);
        ModelGraphics modelGraphics = new ModelGraphics(modelGraphicsOptions);

        Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, height);
        double heading = Math.toRadians(135);
        double pitch = 0;
        double roll = 0;
        org.cesiumjs.cs.core.HeadingPitchRoll hpr = new org.cesiumjs.cs.core.HeadingPitchRoll(heading, pitch, roll);
        Quaternion orientation = Transforms.headingPitchRollQuaternion(position, hpr);
        EntityOptions entityOptions = new EntityOptions();
        entityOptions.name = url;
        entityOptions.position = new ConstantPositionProperty(position);
        entityOptions.orientation = new ConstantProperty<>(orientation);
        entityOptions.model = modelGraphics;
        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(entityOptions);
    }

    private Color getColor(String colorName, float alpha) {
        Color color = null;
        if (colorName.equalsIgnoreCase("White")) {
            color = Color.WHITE();
        } else if (colorName.equalsIgnoreCase("Red")) {
            color = Color.RED();
        } else if (colorName.equalsIgnoreCase("Green")) {
            color = Color.GREEN();
        } else if (colorName.equalsIgnoreCase("Blue")) {
            color = Color.BLUE();
        } else if (colorName.equalsIgnoreCase("Yellow")) {
            color = Color.YELLOW();
        } else if (colorName.equalsIgnoreCase("Gray")) {
            color = Color.GRAY();
        }
        return Color.fromAlpha(color, alpha, null);
    }

    private void onTextChange(ChangeEvent event) {
        TextBox source = (TextBox) event.getSource();
        float value = Float.parseFloat(source.getValue());
        if (source == alphaTBox) {
            alphaSlider.setValue((int) (value * 100));
            alpha = value;
            csVPanel.getViewer().trackedEntity.model.color = new ConstantProperty<>(getColor(colorStr, alpha));
        } else if (source == mixTBox) {
            mixSlider.setValue((int) (value * 100));
            colorBlendAmount = value;
            csVPanel.getViewer().trackedEntity.model.colorBlendAmount = new ConstantProperty<>(colorBlendAmount);
        } else if (source == silhouetteAlphaTBox) {
            silhouetteAlphaSlider.setValue((int) (value * 100));
            silhouetteAlpha = value;
            csVPanel.getViewer().trackedEntity.model.silhouetteColor = new ConstantProperty<>(
                    getColor(silhouetteColorStr, silhouetteAlpha));
        } else if (source == silhouetteSizeTBox) {
            silhouetteSizeSlider.setValue((int) (value * 100));
            silhouetteSize = value;
            csVPanel.getViewer().trackedEntity.model.silhouetteSize = new ConstantProperty<>(silhouetteSize);
        }
    }

    private void onModelsLBoxChange(ChangeEvent event) {
        ListBox source = (ListBox) event.getSource();
        csVPanel.getViewer().entities().removeAll();
        switch (source.getSelectedValue()) {
            case "0":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb", 5000.0);
                break;
            case "1":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/GroundVehicle/GroundVehicle.glb", 0);
                break;
            case "2":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumBalloon/CesiumBalloon.glb", 1000.0);
                break;
            case "3":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumMilkTruck/CesiumMilkTruck.glb", 0);
                break;
            case "4":
                createModel(GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb", 0);
                break;
            default:
                break;
        }
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Models3DColoring.txt";
        return sourceCodeURLs;
    }
}
