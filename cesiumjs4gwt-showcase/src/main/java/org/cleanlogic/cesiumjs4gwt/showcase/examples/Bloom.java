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
import com.google.inject.Inject;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.scene.PostProcessStageComposite;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.InputEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderBox;

/**
 * @author Serge Silaev aka iSergio
 */
public class Bloom extends AbstractExample {
    private ViewerPanel csVPanel;
    private CheckBox bloomCBox;
    private CheckBox glowOnlyCBox;
    private SliderBox contrastSlider;
    private SliderBox brightnessSlider;
    private SliderBox deltaSlider;
    private SliderBox sigmaSlider;
    private SliderBox stepSizeSlider;

    @Inject
    public Bloom(ShowcaseExampleStore store) {
        super("Bloom", "Add bloom effect to the scene", new String[]{
                "Bloom", "Post processing"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        int numberOfBalloons = 13;
        double lonIncrement = 0.00025;
        double initialLon = -122.99875;
        double lat = 44.0503706;
        double height = 100.0;
        for (int i = 0; i < numberOfBalloons; i++) {
            double lon = initialLon + i * lonIncrement;
            createModel(lon, lat, height);
        }

        bloomCBox = new CheckBox();
        bloomCBox.setValue(true);
        bloomCBox.addValueChangeHandler(new MValueChangeHandler());

        glowOnlyCBox = new CheckBox();
        glowOnlyCBox.setValue(false);
        glowOnlyCBox.addValueChangeHandler(new MValueChangeHandler());

        contrastSlider = new SliderBox(-255, 128, 255, 0.01);
        contrastSlider.setWidth("150px");
        contrastSlider.addInputHandler(this::updatePostProcess);

        brightnessSlider = new SliderBox(-1, -0.3, 1, 0.01);
        brightnessSlider.setWidth("150px");
        brightnessSlider.addInputHandler(this::updatePostProcess);

        deltaSlider = new SliderBox(1, 1, 5, 0.01);
        deltaSlider.setWidth("150px");
        deltaSlider.addInputHandler(this::updatePostProcess);

        sigmaSlider = new SliderBox(1, 3.78, 10, 0.01);
        sigmaSlider.setWidth("150px");
        sigmaSlider.addInputHandler(this::updatePostProcess);

        stepSizeSlider = new SliderBox(0, 5, 7, 0.01);
        stepSizeSlider.setWidth("150px");
        stepSizeSlider.addInputHandler(this::updatePostProcess);

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Bloom</font>");
        flexTable.setWidget(1, 1, bloomCBox);
        flexTable.setHTML(2, 0, "<font color=\"white\">Glow only</font>");
        flexTable.setWidget(2, 1, glowOnlyCBox);
        flexTable.setHTML(3, 0, "<font color=\"white\">Contrast</font>");
        flexTable.setWidget(3, 1, contrastSlider);
        flexTable.setHTML(4, 0, "<font color=\"white\">Brightness</font>");
        flexTable.setWidget(4, 1, brightnessSlider);
        flexTable.setHTML(5, 0, "<font color=\"white\">Delta</font>");
        flexTable.setWidget(5, 1, deltaSlider);
        flexTable.setHTML(6, 0, "<font color=\"white\">Sigma</font>");
        flexTable.setWidget(6, 1, sigmaSlider);
        flexTable.setHTML(7, 0, "<font color=\"white\">Step Size</font>");
        flexTable.setWidget(7, 1, stepSizeSlider);

        AbsolutePanel absPanel = new AbsolutePanel();
        absPanel.add(csVPanel);
        absPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Post processing effects.</p>"));
        contentPanel.add(absPanel);

        initWidget(contentPanel);
        updatePostProcess(null);

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

    private void updatePostProcess(InputEvent event) {
        PostProcessStageComposite bloom = csVPanel.getViewer().scene().postProcessStages.bloom();
        bloom.enabled = bloomCBox.getValue();
        bloom.uniforms.setProperty("glowOnly", glowOnlyCBox.getValue());
        bloom.uniforms.setProperty("contrast", Double.parseDouble(contrastSlider.getValue()));
        bloom.uniforms.setProperty("brightness", Double.parseDouble(brightnessSlider.getValue()));
        bloom.uniforms.setProperty("delta", Double.parseDouble(deltaSlider.getValue()));
        bloom.uniforms.setProperty("sigma", Double.parseDouble(sigmaSlider.getValue()));
        bloom.uniforms.setProperty("stepSize", Double.parseDouble(stepSizeSlider.getValue()));
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Bloom.txt";
        return sourceCodeURLs;
    }

    private class MValueChangeHandler implements ValueChangeHandler<Boolean> {
        @Override
        public void onValueChange(ValueChangeEvent<Boolean> event) {
            updatePostProcess(null);
        }
    }
}
