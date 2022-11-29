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
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.scene.PostProcessStage;
import org.cesiumjs.cs.scene.PostProcessStageLibrary;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.InputEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderBox;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class LensFlare extends AbstractExample {
    private ViewerPanel csVPanel;

    private CheckBox lensFlareCBox;
    private SliderBox intensitySlider;
    private SliderBox distortionSlider;
    private SliderBox dispersionSlider;
    private SliderBox haloWidthSlider;
    private SliderBox dirtAmountSlider;

    private PostProcessStage lensFlare;

    @Inject
    public LensFlare(ShowcaseExampleStore store) {
        super("LensFlare", "Lens Flare", new String[]{"Lens Flare", "Post processing"}, store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        lensFlareCBox = new CheckBox();
        lensFlareCBox.setValue(false);
        lensFlareCBox.addValueChangeHandler(event -> updatePostProcess(null));

        intensitySlider = new SliderBox(0, 2, 10, 0.01);
        intensitySlider.setWidth("150px");
        intensitySlider.addInputHandler(this::updatePostProcess);

        distortionSlider = new SliderBox(1, 10, 20, 0.01);
        distortionSlider.setWidth("150px");
        distortionSlider.addInputHandler(this::updatePostProcess);

        dispersionSlider = new SliderBox(0, 0.4, 1, 0.01);
        dispersionSlider.setWidth("150px");
        dispersionSlider.addInputHandler(this::updatePostProcess);

        haloWidthSlider = new SliderBox(0, 0.4, 1, 0.01);
        haloWidthSlider.setWidth("150px");
        haloWidthSlider.addInputHandler(this::updatePostProcess);

        dirtAmountSlider = new SliderBox(0, 0.4, 1, 0.01);
        dirtAmountSlider.setWidth("150px");
        dirtAmountSlider.addInputHandler(this::updatePostProcess);

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Lens Flare</font>");
        flexTable.setWidget(1, 1, lensFlareCBox);
        flexTable.setHTML(2, 0, "<font color=\"white\">Intensity</font>");
        flexTable.setWidget(2, 1, intensitySlider);
        flexTable.setHTML(3, 0, "<font color=\"white\">Distortion</font>");
        flexTable.setWidget(3, 1, distortionSlider);
        flexTable.setHTML(4, 0, "<font color=\"white\">Dispersion</font>");
        flexTable.setWidget(4, 1, dispersionSlider);
        flexTable.setHTML(5, 0, "<font color=\"white\">Halo Width</font>");
        flexTable.setWidget(5, 1, haloWidthSlider);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Post processing effects.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        lensFlare = csVPanel.getViewer().scene().postProcessStages
                .add(PostProcessStageLibrary.createLensFlareStage());

        updatePostProcess(null);

        org.cesiumjs.cs.scene.Camera camera = csVPanel.getViewer().scene().camera();
        camera.position = new Cartesian3(40010447.97500168, 56238683.46406788, 20776576.752223067);
        camera.direction = new Cartesian3(-0.5549701431494752, -0.7801872010801355, -0.2886452346452218);
        camera.up = new Cartesian3(-0.3016252360948521, -0.13464820558887716, 0.9438707950150912);
        camera.right = Cartesian3.cross(camera.direction, camera.up, new Cartesian3());

        csVPanel.getViewer().clock().currentTime = new JulianDate(2458047, 27399.860215000022);
    }

    private void updatePostProcess(InputEvent event) {
        lensFlare.enabled = lensFlareCBox.getValue();
        lensFlare.uniforms().setProperty("intensity", intensitySlider.getValue());
        lensFlare.uniforms().setProperty("distortion", distortionSlider.getValue());
        lensFlare.uniforms().setProperty("ghostDispersal", dispersionSlider.getValue());
        lensFlare.uniforms().setProperty("haloWidth", haloWidthSlider.getValue());
        lensFlare.uniforms().setProperty("dirtAmount", dirtAmountSlider.getValue());
        lensFlare.uniforms().setProperty("earthRadius", Ellipsoid.WGS84().maximumRadius());
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "LensFlare.txt";
        return sourceCodeURLs;
    }
}
