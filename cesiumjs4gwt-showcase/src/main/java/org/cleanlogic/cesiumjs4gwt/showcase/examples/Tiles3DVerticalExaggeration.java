/*
 * Copyright 2024 iSergio, Gis4Fun.
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
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.InputEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderBox;

import javax.inject.Inject;

public class Tiles3DVerticalExaggeration  extends AbstractExample {
    private SliderBox exaggerationSlider;
    private TextBox exaggerationTBox;
    private SliderBox relativeHeightSlider;
    private TextBox relativeHeightTBox;

    private Scene scene;

    @Inject
    public Tiles3DVerticalExaggeration(ShowcaseExampleStore store) {
        super("3D Tiles Vertical Exaggeration", "Apply Vertical Exaggeration to 3D Tiles.",
                new String[]{"Showcase", "Cesium", "3D Tiles", "Exaggeration"}, store, "1.113");
    }

    @Override
    public void buildPanel() {
        ViewerOptions options = new ViewerOptions();
        options.timeline = false;
        options.animation = false;
        options.sceneModePicker = false;
        options.baseLayerPicker = false;
        // The globe does not need to be displayed,
        options.globe = null;
        // since the Photorealistic 3D Tiles include terrain
        ViewerPanel csVPanel = new ViewerPanel(options);

        Viewer viewer = csVPanel.getViewer();
        scene = viewer.scene();
        scene.verticalExaggeration = 3.0;

        ViewOptions viewOptions = new ViewOptions();
        viewOptions.destinationPos = new Cartesian3(-2710292.813384663, -4360657.061518585, 3793571.786860543);
        viewOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(5.794062761901799, -0.30293409742984756, 0.0009187098191985044);
        scene.camera().setView(viewOptions);

        scene.skyAtmosphere.show = true;

        Cesium.createGooglePhotorealistic3DTileset().then(value -> scene.primitives().add(value));

        HorizontalPanel exaggerationHPanel = new HorizontalPanel();
        exaggerationHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        exaggerationHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        exaggerationHPanel.setSpacing(10);
        exaggerationSlider = new SliderBox(1., scene.verticalExaggeration, 5., 0.01);
        exaggerationSlider.setStep(0.01);
        exaggerationSlider.setWidth("150px");
        exaggerationSlider.addInputHandler(this::onSliderInput);
        exaggerationTBox = new TextBox();
        exaggerationTBox.setText(scene.verticalExaggeration + "");
        exaggerationTBox.setSize("30px", "12px");
        exaggerationHPanel.add(exaggerationSlider);
        exaggerationHPanel.add(exaggerationTBox);

        HorizontalPanel relativeHeightHPanel = new HorizontalPanel();
        relativeHeightHPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        relativeHeightHPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        relativeHeightHPanel.setSpacing(10);
        relativeHeightSlider = new SliderBox(-1000, scene.verticalExaggerationRelativeHeight, 9000, 1.);
        relativeHeightSlider.setStep(1);
        relativeHeightSlider.setWidth("150px");
        relativeHeightSlider.addInputHandler(this::onSliderInput);
        relativeHeightTBox = new TextBox();
        relativeHeightTBox.setText(scene.verticalExaggerationRelativeHeight + "");
        relativeHeightTBox.setSize("30px", "12px");
        relativeHeightHPanel.add(relativeHeightSlider);
        relativeHeightHPanel.add(relativeHeightTBox);

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Exaggeration</font>");
        flexTable.setWidget(1, 1, exaggerationHPanel);
        flexTable.setWidget(2, 0, new HTML("<font color=\"white\">Relative Height</font>"));
        flexTable.setWidget(2, 1, relativeHeightHPanel);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML(
                "<p>3D Tiles Vertical Exaggeration.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DVerticalExaggeration.txt";
        return sourceCodeURLs;
    }

    private void onSliderInput(InputEvent event) {
        SliderBox source = (SliderBox) event.getSource();
        double value = source.getValue();
        if (source.equals(exaggerationSlider)) {
            onExaggerationInput(value);
        } else if (source.equals(relativeHeightSlider)) {
            onRelativeHeightInput(value);
        }
    }

    private void onExaggerationInput(double value) {
        scene.verticalExaggeration = value;
        exaggerationTBox.setText(String.valueOf(value));
    }

    private void onRelativeHeightInput(double value) {
        scene.verticalExaggerationRelativeHeight = value;
        relativeHeightTBox.setText(String.valueOf(value));
    }
}
