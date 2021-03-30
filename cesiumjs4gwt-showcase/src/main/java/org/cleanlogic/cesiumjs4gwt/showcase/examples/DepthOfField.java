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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.scene.PostProcessStageComposite;
import org.cesiumjs.cs.scene.PostProcessStageLibrary;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.Slider;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderListener;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class DepthOfField extends AbstractExample {
    private final int numberOfBalloons = 13;
    private final double lonIncrement = 0.00025;
    private final double initialLon = -122.99875;
    private final double lat = 44.0503706;
    private final double height = 100.0;
    private ViewerPanel csVPanel;
    private CheckBox depthOfFieldCBox;
    private Slider focalDistanceSlider;
    private Slider deltaSlider;
    private Slider sigmaSlider;
    private Slider stepSizeSlider;
    private PostProcessStageComposite depthOfField;

    @Inject
    public DepthOfField(ShowcaseExampleStore store) {
        super("Depth of Field", "Depth of field", new String[]{"Depth of field", "Post processing"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        for (int i = 0; i < numberOfBalloons; i++) {
            double lon = initialLon + i * lonIncrement;
            createModel(lon, lat, height);
        }

        depthOfFieldCBox = new CheckBox();
        depthOfFieldCBox.setValue(true);
        depthOfFieldCBox.addValueChangeHandler(new MValueChangeHandler());

        focalDistanceSlider = new Slider("focalDistanceSlider", 0, 500, 87);
        focalDistanceSlider.setStep(1);
        focalDistanceSlider.setWidth("150px");
        focalDistanceSlider.addListener(new MSliderListener());

        deltaSlider = new Slider("deltaSlider", 10, 200, 100);
        deltaSlider.setStep(1);
        deltaSlider.setWidth("150px");
        deltaSlider.addListener(new MSliderListener());

        sigmaSlider = new Slider("sigmaSlider", 50, 500, 378);
        sigmaSlider.setStep(1);
        sigmaSlider.setWidth("150px");
        sigmaSlider.addListener(new MSliderListener());

        stepSizeSlider = new Slider("stepSizeSlider", 0, 700, 246);
        stepSizeSlider.setStep(1);
        stepSizeSlider.setWidth("150px");
        stepSizeSlider.addListener(new MSliderListener());

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Depth Of Field</font>");
        flexTable.setWidget(1, 1, depthOfFieldCBox);
        flexTable.setHTML(2, 0, "<font color=\"white\">Focal Distance</font>");
        flexTable.setWidget(2, 1, focalDistanceSlider);
        flexTable.setHTML(3, 0, "<font color=\"white\">Delta</font>");
        flexTable.setWidget(3, 1, deltaSlider);
        flexTable.setHTML(4, 0, "<font color=\"white\">Sigma</font>");
        flexTable.setWidget(4, 1, sigmaSlider);
        flexTable.setHTML(5, 0, "<font color=\"white\">Step Size</font>");
        flexTable.setWidget(5, 1, stepSizeSlider);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Post processing effects.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        depthOfField = csVPanel.getViewer().scene().postProcessStages
                .add(PostProcessStageLibrary.createDepthOfFieldStage());
        if (!PostProcessStageLibrary.isDepthOfFieldSupported(csVPanel.getViewer().scene())) {
            Cesium.log("This browser does not support the depth of field post process.");
        }

        updatePostProcess();

        Cartesian3 target = Cartesian3.fromDegrees(initialLon + lonIncrement, lat, height + 7.5);
        Cartesian3 offset = new Cartesian3(-37.048378684557974, -24.852967044804245, 4.352023653686047);
        csVPanel.getViewer().scene().camera().lookAt(target, offset);
    }

    private void createModel(double lon, double lat, double height) {
        Cartesian3 position = Cartesian3.fromDegrees(lon, lat, height);

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(
                GWT.getModuleBaseURL() + "SampleData/models/CesiumBalloon/CesiumBalloon.glb");
        EntityOptions options = new EntityOptions();
        options.name = GWT.getModuleBaseURL() + "SampleData/models/CesiumBalloon/CesiumBalloon.glb";
        options.position = new ConstantPositionProperty(position);
        options.model = new ModelGraphics(modelGraphicsOptions);
        csVPanel.getViewer().entities().add(options);
    }

    private void updatePostProcess() {
        depthOfField.enabled = depthOfFieldCBox.getValue();
        depthOfField.uniforms.setProperty("focalDistance", focalDistanceSlider.getValue());
        depthOfField.uniforms.setProperty("delta", deltaSlider.getValue() / 100.);
        depthOfField.uniforms.setProperty("sigma", sigmaSlider.getValue() / 100.);
        depthOfField.uniforms.setProperty("stepSize", stepSizeSlider.getValue() / 100.);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "DepthOfField.txt";
        return sourceCodeURLs;
    }

    private class MValueChangeHandler implements ValueChangeHandler<Boolean> {
        @Override
        public void onValueChange(ValueChangeEvent<Boolean> event) {
            updatePostProcess();
        }
    }

    private class MSliderListener implements SliderListener {
        @Override
        public void onStart(SliderEvent e) {
            //
        }

        @Override
        public boolean onSlide(SliderEvent e) {
            updatePostProcess();
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
    }
}