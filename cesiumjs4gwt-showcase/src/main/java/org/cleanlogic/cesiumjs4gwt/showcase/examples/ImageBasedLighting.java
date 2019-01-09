/*
 * Copyright 2019 iserge.
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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Reject;
import org.cesiumjs.cs.scene.Camera;
import org.cesiumjs.cs.scene.Model;
import org.cesiumjs.cs.scene.ScreenSpaceCameraController;
import org.cesiumjs.cs.scene.options.FromGltfOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.Slider;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderEvent;
import org.cleanlogic.cesiumjs4gwt.showcase.examples.slider.SliderListener;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ImageBasedLighting extends AbstractExample {
    public Viewer viewer;
    private Model model;
    private String environmentMapURL;
    private Cartesian3[] coefficients;

    private Slider luminanceAtZenithSlider;
    private TextBox luminanceAtZenithTBox;
    @Inject
    public ImageBasedLighting(ShowcaseExampleStore store) {
        super("Image-Based Lighting", "Use image-based lighting to light a model", new String[]{"Model", "lighting"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();
        viewer = csVPanel.getViewer();

        environmentMapURL = GWT.getModuleBaseURL() + "SampleData/EnvironmentMap/kiara_6_afternoon_2k_ibl.ktx";
        String modelURL = GWT.getModuleBaseURL() + "SampleData/models/Pawns/Pawns.glb";

        // This environment map was processed using Google's Filament project. To process your own:
        // 1 - Download the Filament release (https://github.com/google/filament/releases).
        // 2 - Run `cmgen --type=ktx --deploy=/path/to/output /path/to/image.hdr`. Other formats are also supported. Run `cmgen --help` for all options.
        // 3 - Take the generated coefficients and the KTX file and load them in CesiumJS as shown below.

        Cartesian3 L00  = new Cartesian3( 0.170455150831422,  0.163151083190219,  0.196966760289763);
        Cartesian3 L1_1 = new Cartesian3(-0.066550267689383, -0.022088055746048,  0.078835009246127);
        Cartesian3 L10  = new Cartesian3( 0.038364097478591,  0.045714300098753,  0.063498904606215);
        Cartesian3 L11  = new Cartesian3(-0.014365363312810, -0.026490613715151, -0.050189404066020);
        Cartesian3 L2_2 = new Cartesian3(-0.051532786917890, -0.050777795729986, -0.056449044453032);
        Cartesian3 L2_1 = new Cartesian3( 0.043454596136534,  0.046672590104157,  0.057530107646610);
        Cartesian3 L20  = new Cartesian3(-0.001640466274110,  0.001286638231156,  0.007228908989616);
        Cartesian3 L21  = new Cartesian3(-0.042260855700641, -0.046394335094707, -0.057562936365585);
        Cartesian3 L22  = new Cartesian3(-0.004953478914091, -0.000479681664876,  0.008508150106928);
        coefficients = new Cartesian3[] {L00, L1_1, L10, L11, L2_2, L2_1, L20, L21, L22};

        double height = 0.0;
        org.cesiumjs.cs.core.HeadingPitchRoll hpr = new org.cesiumjs.cs.core.HeadingPitchRoll(0.0, 0.0, 0.0);
        Cartesian3 origin = Cartesian3.fromDegrees(-123.0744619, 44.0503706, height);
        Matrix4 modelMatrix = Transforms.headingPitchRollToFixedFrame(origin, hpr);

        FromGltfOptions fromGltfOptions = new FromGltfOptions();
        fromGltfOptions.url = modelURL;
        fromGltfOptions.modelMatrix = modelMatrix;
        fromGltfOptions.minimumPixelSize = 128.0;
        model = (Model) csVPanel.getViewer().scene().primitives().add(Model.fromGltf(fromGltfOptions));
        model.readyPromise().then(new Fulfill<Model>() {
            @Override
            public void onFulfilled(Model value) {
                Camera camera = viewer.camera;

                // Zoom to model
                ScreenSpaceCameraController controller = viewer.scene().screenSpaceCameraController();
                double r = 2.0 * Math.max(model.boundingSphere().radius, camera.frustum.near);
                controller.minimumZoomDistance = r * 0.5;

                Cartesian3 center = Matrix4.multiplyByPoint(model.modelMatrix, model.boundingSphere().center, new Cartesian3());
                double heading = Math.toRadians(230.0);
                double pitch = Math.toRadians(-20.0);
                camera.lookAt(center, new org.cesiumjs.cs.core.HeadingPitchRange(heading, pitch, r * 2.0));
                camera.lookAtTransform(Matrix4.IDENTITY());

                model.sphericalHarmonicCoefficients = coefficients;
                model.specularEnvironmentMaps = environmentMapURL;
            }
        }, new Reject<Void>() {
            @Override
            public void onRejected(Void value) {
                Window.alert("Error");
            }
        });

        luminanceAtZenithSlider = new Slider("LuminanceAtZenith", 0, 200, 50);
        luminanceAtZenithSlider.setStep(1);
        luminanceAtZenithSlider.addListener(new SliderListener() {
            @Override
            public void onStart(SliderEvent e) {
                //
            }

            @Override
            public boolean onSlide(SliderEvent e) {
                Slider source = e.getSource();
                double value = source.getValue() / 100.0;
                model.luminanceAtZenith = value;
                luminanceAtZenithTBox.setValue(value + "");
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
        });
        luminanceAtZenithTBox = new TextBox();
        luminanceAtZenithTBox.setSize("30px", "12px");
        luminanceAtZenithTBox.setValue("" + 0.5);
        luminanceAtZenithTBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                TextBox source = (TextBox) event.getSource();
                float value = Float.parseFloat(source.getValue());
                luminanceAtZenithSlider.setValue((int) (value * 100));
                model.luminanceAtZenith = value;
            }
        });

        CheckBox useProceduralImageCBox = new CheckBox("Use procedural image");
        useProceduralImageCBox.getElement().getStyle().setColor("white");
        useProceduralImageCBox.setWidth("100px");
        useProceduralImageCBox.setValue(false);
        useProceduralImageCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                if (!event.getValue()) {
                    model.sphericalHarmonicCoefficients = coefficients;
                    model.specularEnvironmentMaps = environmentMapURL;
                } else {
                    model.sphericalHarmonicCoefficients = (Cartesian3[]) JsObject.undefined();
                    model.specularEnvironmentMaps = (String) JsObject.undefined();
                }
            }
        });

        FlexTable flexTable = new FlexTable();
        flexTable.setHTML(1, 0, "<font color=\"white\">Luminance at Zenith</font>");
        flexTable.setWidget(1, 1, luminanceAtZenithSlider);
        flexTable.setWidget(1, 2, luminanceAtZenithTBox);
        flexTable.setWidget(2, 1, useProceduralImageCBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(flexTable, 20, 20);

        contentPanel.add(new HTML("<p>Use image-based lighting to light a model.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ImageBasedLighting.txt";
        return sourceCodeURLs;
    }
}
