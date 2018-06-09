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
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Reject;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.PostProcessStage;
import org.cesiumjs.cs.scene.PostProcessStageComposite;
import org.cesiumjs.cs.scene.PostProcessStageLibrary;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.Slider;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderListener;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class AmbientOcclusion extends AbstractExample {
    private ViewerPanel csVPanel;

    private CheckBox ambientOcclusionCBox;
    private CheckBox ambientOcclusionOnlyCBox;
    private Slider intensitySlider;
    private Slider lengthCapSlider;
    private Slider stepSizeSlider;
    private Slider biasSlider;
    private Slider blurStepSize;

    @Inject
    public AmbientOcclusion(ShowcaseExampleStore store) {
        super("Ambient Occlusion", "Ambient Occlusion", new String[]{"Showcase", "Cesium", "3d", "Post processing"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        if (!csVPanel.getViewer().scene().postProcessStages.ambientOcclusion().isSupported(csVPanel.getViewer().scene())) {
            Cesium.log("This browser does not support the ambient occlusion post process.");
        }

        // Power Plant design model provided by Bentley Systems
        Cesium3DTileset tileset = Cesium3DTileset.create(IonResource.fromAssetId(3837));
        tileset.readyPromise().then(new Fulfill<Cesium3DTileset>() {
            @Override
            public void onFulfilled(Cesium3DTileset value) {
                csVPanel.getViewer().scene().primitives().add(value);
            }
        }, new Reject<Void>() {
            @Override
            public void onRejected(Void value) {
                Cesium.log("Error load tileset");
            }
        });

        ambientOcclusionCBox = new CheckBox();
        ambientOcclusionCBox.setValue(true);
        ambientOcclusionCBox.addValueChangeHandler(new MValueChangeHandler());

        ambientOcclusionOnlyCBox = new CheckBox();
        ambientOcclusionOnlyCBox.setValue(false);
        ambientOcclusionOnlyCBox.addValueChangeHandler(new MValueChangeHandler());

        intensitySlider = new Slider("intensitySlider", 1, 10, 3);
        intensitySlider.setStep(1);
        intensitySlider.setWidth("150px");
        intensitySlider.addListener(new MSliderListener());

        lengthCapSlider = new Slider("lengthCapSlider", 0, 100, 3);
        lengthCapSlider.setStep(1);
        lengthCapSlider.setWidth("150px");
        lengthCapSlider.addListener(new MSliderListener());

        stepSizeSlider = new Slider("stepSizeSlider", 100, 1000, 1);
        stepSizeSlider.setStep(1);
        stepSizeSlider.setWidth("150px");
        stepSizeSlider.addListener(new MSliderListener());

        biasSlider = new Slider("biasSlider", 0, 100, 1);
        biasSlider.setStep(1);
        biasSlider.setWidth("150px");
        biasSlider.addListener(new MSliderListener());

        blurStepSize = new Slider("blurStepSize", 0, 400, 86);
        blurStepSize.setStep(1);
        blurStepSize.setWidth("150px");
        blurStepSize.addListener(new MSliderListener());

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Ambient Occlusion</font>");
        flexTable.setWidget(1, 1, ambientOcclusionCBox);
        flexTable.setHTML(2, 0, "<font color=\"white\">Ambient Occlusion Only</font>");
        flexTable.setWidget(2, 1, ambientOcclusionOnlyCBox);
        flexTable.setHTML(3, 0, "<font color=\"white\">Intensity</font>");
        flexTable.setWidget(3, 1, intensitySlider);
        flexTable.setHTML(4, 0, "<font color=\"white\">Length Cap</font>");
        flexTable.setWidget(4, 1, lengthCapSlider);
        flexTable.setHTML(5, 0, "<font color=\"white\">Step Size</font>");
        flexTable.setWidget(5, 1, stepSizeSlider);
        flexTable.setHTML(6, 0, "<font color=\"white\">Bias</font>");
        flexTable.setWidget(6, 1, biasSlider);
        flexTable.setHTML(7, 0, "<font color=\"white\">Blur Step Size</font>");
        flexTable.setWidget(7, 1, blurStepSize);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Post processing effects.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
        updatePostProcess();

        org.cesiumjs.cs.scene.Camera camera = csVPanel.getViewer().scene().camera();
        camera.position = new Cartesian3(1234127.2294710164, -5086011.666443127, 3633337.0413351045);
        camera.direction = new Cartesian3(-0.5310064396211631, -0.30299013818088416, -0.7913464078682514);
        camera.right = new Cartesian3(-0.8468592075426076, 0.1574051185945647, 0.507989282604011);
        camera.up = Cartesian3.cross(camera.right, camera.direction, new Cartesian3());
    }

    private void updatePostProcess() {
        PostProcessStageComposite ambientOcclusion = csVPanel.getViewer().scene().postProcessStages.ambientOcclusion();
        ambientOcclusion.enabled = ambientOcclusionCBox.getValue() || ambientOcclusionOnlyCBox.getValue();
        ambientOcclusion.uniforms.setProperty("ambientOcclusionOnly", ambientOcclusionOnlyCBox.getValue());
        ambientOcclusion.uniforms.setProperty("intensity", intensitySlider.getValue());
        ambientOcclusion.uniforms.setProperty("bias", biasSlider.getValue() / 100.0);
        ambientOcclusion.uniforms.setProperty("lengthCap", lengthCapSlider.getValue() / 100.0);
        ambientOcclusion.uniforms.setProperty("stepSize", stepSizeSlider.getValue() / 100.0);
        ambientOcclusion.uniforms.setProperty("blurStepSize", blurStepSize.getValue() / 100.0);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "AmbientOcclusion.txt";
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
