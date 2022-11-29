/*
 * Copyright 2021 iserge, Gis4Fun.
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
import com.google.gwt.typedarrays.client.Uint8ArrayNative;
import com.google.gwt.typedarrays.shared.Uint8Array;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.core.enums.PixelFormat;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseClickEvent;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.scene.Model;
import org.cesiumjs.cs.scene.enums.CustomShaderTranslucencyMode;
import org.cesiumjs.cs.scene.enums.TextureMagnificationFilter;
import org.cesiumjs.cs.scene.enums.TextureMinificationFilter;
import org.cesiumjs.cs.scene.CustomShader;
import org.cesiumjs.cs.scene.TextureUniform;
import org.cesiumjs.cs.scene.enums.UniformType;
import org.cesiumjs.cs.scene.options.CustomShaderOptions;
import org.cesiumjs.cs.scene.options.FromGltfOptions;
import org.cesiumjs.cs.scene.options.TextureUniformOptions;
import org.cesiumjs.cs.scene.options.CameraFlyToOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class CustomShadersModels extends AbstractExample {
    private ViewerPanel csVPanel;
    private Cartesian3 position;
    private HeadingPitchRoll hpr;
    private Transforms.LocalFrameToFixedFrame fixedFrameTransform;

    private final String balloon = GWT.getModuleBaseURL() + "SampleData/models/CesiumBalloon/CesiumBalloon.glb";
    private final String drone = GWT.getModuleBaseURL() + "SampleData/models/CesiumDrone/CesiumDrone.glb";
    private final String pawns = GWT.getModuleBaseURL() + "SampleData/models/CesiumDrone/Pawns.glb";
    private final String milkTruck = GWT.getModuleBaseURL() + "SampleData/models/CesiumMilkTruck/CesiumMilkTruck.glb";
    private final String groundVehicle = GWT.getModuleBaseURL() + "SampleData/models/GroundVehicle/GroundVehicle.glb";
    private final String pointCloudWave = GWT.getModuleBaseURL() + "SampleData/models/PointCloudWave/PointCloudWave.glb";

    private CustomShader expandModelShader;
    private CustomShader textureUniformShader;
    private CustomShader checkerboardMaskShader;
    private CustomShader checkerboardAlphaShader;
    private CustomShader checkerboardHolesShader;
    private CustomShader gradientShader;
    private CustomShader modifyPbrShader;
    private CustomShader pointCloudWaveShader;

    private boolean needsDrag = false;
    private boolean dragActive = false;

    @Inject
    public CustomShadersModels(ShowcaseExampleStore store) {
        super("Custom Shaders Models",
                "Create 3D models using glTF 3D Tiles Next",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "experimental"}, store, "1.88");
    }

    @Override
    public void buildPanel() {
        ViewerOptions options = new ViewerOptions();
        options.orderIndependentTranslucency = false;
        csVPanel = new ViewerPanel(options);

        csVPanel.getViewer().clock().currentTime = JulianDate.fromIso8601("2021-11-09T20:27:37.016064475348684937Z");

        // Model positioning ===============================================

        position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, 0);
        hpr = new HeadingPitchRoll(0, 0, 0);
        fixedFrameTransform = Transforms.localFrameToFixedFrameGenerator("north", "west");

        // Custom Shader Definitions ========================================

        // Dragging the mouse will expand/shrink the model.
        expandModelShader = new CustomShader(new CustomShaderOptions()
                .addUniform("u_drag", UniformType.VEC2(), new Cartesian2(0.0, 0.0))
                .setVertexShaderText(
                        "    // If the mouse is dragged to the right, the model grows\n" +
                        "    // If the mouse is dragged to the left, the model shrinks\n" +
                        "    void vertexMain(VertexInput vsInput, inout czm_modelVertexOutput vsOutput)\n" +
                        "    {\n" +
                        "        vsOutput.positionMC += 0.01 * u_drag.x * vsInput.attributes.normalMC;\n" +
                        "    }"));

        textureUniformShader = new CustomShader(new CustomShaderOptions()
                .addUniform("u_time", UniformType.FLOAT(), 0)
                .addUniform("u_stripes", UniformType.SAMPLER_2D(), TextureUniform.create(GWT.getModuleBaseURL() + "SampleData/cesium_stripes.png"))
                .setFragmentShaderText(
                        "    void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n" +
                        "    {\n" +
                        "        vec2 texCoord = fsInput.attributes.texCoord_0 + 0.1 * vec2(u_time, 0.0);\n" +
                        "        material.diffuse = texture2D(u_stripes, texCoord).rgb;\n" +
                        "    }"));

        TextureUniform checkerboardTexture = makeCheckerboardTexture(8);

        // Use the checkerboard red channel as a mask
        checkerboardMaskShader = new CustomShader(new CustomShaderOptions()
                .addUniform("u_checkerboard", UniformType.SAMPLER_2D(), checkerboardTexture)
                .setFragmentShaderText(
                        "    void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n" +
                        "    {\n" +
                        "        vec2 texCoord = fsInput.attributes.texCoord_0;\n" +
                        "        vec4 checkerboard = texture2D(u_checkerboard, texCoord);\n" +
                        "        material.diffuse = mix(material.diffuse, vec3(0.0), checkerboard.r);\n" +
                        "    }"));

        // Color like a checkerboard but make the transparency vary with
        // the diagonal
        checkerboardAlphaShader = new CustomShader(new CustomShaderOptions()
                .addUniform("u_checkerboard", UniformType.SAMPLER_2D(), checkerboardTexture)
                .setTranslucencyMode(CustomShaderTranslucencyMode.TRANSLUCENT())
                .setFragmentShaderText(
                        "    void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n" +
                        "    {\n" +
                        "        vec2 texCoord = fsInput.attributes.texCoord_0;\n" +
                        "        vec4 checkerboard = texture2D(u_checkerboard, texCoord);\n" +
                        "        material.diffuse = checkerboard.rgb;\n" +
                        "        material.alpha = checkerboard.a;\n" +
                        "    }"));
        // Use the checkerboard to cut holes in the model
        checkerboardHolesShader = new CustomShader(new CustomShaderOptions()
                .addUniform("u_checkerboard", UniformType.SAMPLER_2D(), checkerboardTexture)
                .setFragmentShaderText(
                        "    void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n" +
                        "    {\n" +
                        "        vec2 texCoord = fsInput.attributes.texCoord_0;\n" +
                        "        vec4 checkerboard = texture2D(u_checkerboard, texCoord);\n" +
                        "        if (checkerboard.r > 0.0) {\n" +
                        "            discard;\n" +
                        "        }\n" +
                        "    }"));

        TextureUniform gradientTexture = makeGradientTexture();
        // Color the texture along its UV coordinates.
        gradientShader = new CustomShader(new CustomShaderOptions()
                .addUniform("u_gradient", UniformType.SAMPLER_2D(), gradientTexture)
                .setFragmentShaderText(
                        "    void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n" +
                        "    {\n" +
                        "        material.diffuse = texture2D(u_gradient, fsInput.attributes.texCoord_0).rgb;\n" +
                        "    }"));

        // Dragging the mouse will modify the PBR values
        modifyPbrShader = new CustomShader(new CustomShaderOptions()
                .addUniform("u_drag", UniformType.VEC2(), new Cartesian2(0., 0.))
                .setFragmentShaderText(
                        "    // Click and drag to vary the PBR values\n" +
                        "    void fragmentMain(FragmentInput vsInput, inout czm_modelMaterial material)\n" +
                        "    {\n" +
                        "        float dragDistance = length(u_drag);\n" +
                        "        float variation = smoothstep(0.0, 300.0, dragDistance);\n" +
                        "    // variation adds an golden tint to the specular highlights\n" +
                        "        material.specular = mix(material.specular, vec3(0.8, 0.5, 0.1), variation);\n" +
                        "    // variation makes the material glossier\n" +
                        "        material.roughness = clamp(1.0 - variation, 0.01, 1.0);\n" +
                        "    // variation mixes some red into the diffuse color\n" +
                        "        material.diffuse += vec3(0.5, 0.0, 0.0) * variation;\n" +
                        "    }"));

        pointCloudWaveShader = new CustomShader(new CustomShaderOptions()
                .addUniform("u_time", UniformType.FLOAT(), 0)
                .setVertexShaderText(
                        "    void vertexMain(VertexInput vsInput, inout czm_modelVertexOutput vsOutput)\n" +
                        "    {\n" +
                        "    // This model's x and y coordinates are in the range [0, 1], which\n" +
                        "    // conveniently doubles as UV coordinates.\n" +
                        "        vec2 uv = vsInput.attributes.positionMC.xy;\n" +
                        "    // Make the point cloud undulate in a complex wave that varies in\n" +
                        "    // both space and time. The amplitude is based on the original shape\n" +
                        "    // of the point cloud (which already is a wavy surface). The wave\n" +
                        "    // is computed relative to the center of the model, hence the\n" +
                        "    // transformations from [0, 1] -> [-1, 1] -> [0, 1]\n" +
                        "        float amplitude = 2.0 * vsInput.attributes.positionMC.z - 1.0;\n" +
                        "        float wave = amplitude * sin(2.0 * czm_pi * uv.x - 2.0 * u_time) * sin(u_time);\n" +
                        "        vsOutput.positionMC.z = 0.5 + 0.5 * wave;\n" +
                        "    // Make the points pulse in and out by changing their size\n" +
                        "        vsOutput.pointSize = 10.0 + 5.0 * sin(u_time);\n" +
                        "    }")
                .setFragmentShaderText(
                        "    void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n" +
                        "    {\n" +
                        "    // Make the points circular instead of square\n" +
                        "        float distance = length(gl_PointCoord - 0.5);\n" +
                        "        if (distance > 0.5) {\n" +
                        "            discard;\n" +
                        "        }\n" +
                        "    // Make a sinusoid color palette that moves in the general direction\n" +
                        "    // of the wave, but at a different speed.\n" +
                        "    // Coefficients were chosen arbitrarily\n" +
                        "        vec2 uv = fsInput.attributes.positionMC.xy;\n" +
                        "        material.diffuse = 0.2 * fsInput.attributes.color_0.rgb;\n" +
                        "        material.diffuse += vec3(0.2, 0.3, 0.4) + vec3(0.2, 0.3, 0.4) * sin(2.0 * czm_pi * vec3(3.0, 2.0, 1.0) * uv.x - 3.0 * u_time);\n" +
                        "    }"));

        // Event handlers =====================================================
        double startTime = performanceNow();
        csVPanel.getViewer().scene().postUpdate().addEventListener((Event.Listener) o -> {
            double elapsedTimeSeconds = (performanceNow() - startTime) / 1000;
            textureUniformShader.setUniform("u_time", elapsedTimeSeconds);
            pointCloudWaveShader.setUniform("u_time", elapsedTimeSeconds);
        });

        Cartesian2 dragCenter = new Cartesian2();
        csVPanel.getViewer().screenSpaceEventHandler().setInputAction(event -> {
            if (!needsDrag) {
                return;
            }
            MouseClickEvent movement = (MouseClickEvent) event;

            PickedObject pickedFeature = csVPanel.getViewer().scene().pick(movement.position);
            if (!Cesium.defined(pickedFeature)) {
                return;
            }

            csVPanel.getViewer().scene().screenSpaceCameraController().enableInputs = false;

            // set the new drag center
            dragActive = true;
            movement.position.clone(dragCenter);
        }, ScreenSpaceEventType.LEFT_DOWN());

        Cartesian2 scratchDrag = new Cartesian2();
        csVPanel.getViewer().screenSpaceEventHandler().setInputAction(event -> {
            if (!needsDrag) {
                return;
            }
            MouseMoveEvent movement = (MouseMoveEvent) event;

            if (dragActive) {
                // get the mouse position relative to the center of the screen
                Cartesian2 drag = Cartesian2.subtract(movement.endPosition, dragCenter, scratchDrag);

                // Update uniforms
                expandModelShader.setUniform("u_drag", drag);
                modifyPbrShader.setUniform("u_drag", drag);
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());

        csVPanel.getViewer().screenSpaceEventHandler().setInputAction(event -> {
            if (!needsDrag) {
                return;
            }

            csVPanel.getViewer().scene().screenSpaceCameraController().enableInputs = true;

            dragActive = false;
        }, ScreenSpaceEventType.LEFT_UP());

        ListBox listBox = new ListBox();
        listBox.addItem("Custom Texture");
        listBox.addItem("Procedural Texture");
        listBox.addItem("Translucent materials");
        listBox.addItem("Use Texture as Mask");
        listBox.addItem("Procedural Gradient Texture");
        listBox.addItem("Modify PBR values via Mouse Drag");
        listBox.addItem("Expand Model via Mouse Drag");
        listBox.addItem("Animated Point Cloud");
        listBox.addChangeHandler(event -> {
            String value = ((ListBox) event.getSource()).getSelectedItemText();
            switch (value) {
                case "Custom Texture": selectModel(groundVehicle, textureUniformShader); needsDrag = false; break;
                case "Procedural Texture": selectModel(balloon, checkerboardMaskShader); needsDrag = false; break;
                case "Translucent materials": selectModel(balloon, checkerboardAlphaShader); needsDrag = false; break;
                case "Use Texture as Mask": selectModel(balloon, checkerboardHolesShader); needsDrag = false; break;
                case "Procedural Gradient Texture": selectModel(balloon, gradientShader); needsDrag = false; break;
                case "Modify PBR values via Mouse Drag": selectModel(groundVehicle, modifyPbrShader); needsDrag = true; break;
                case "Expand Model via Mouse Drag": selectModel(milkTruck, expandModelShader); needsDrag = true; break;
                case "Animated Point Cloud": selectModel(pointCloudWave, pointCloudWaveShader); needsDrag = false; break;
                default: break;
            }
        });

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(listBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML(
                "<p>Create 3D models using glTF 3D Tiles Next.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        selectModel(groundVehicle, textureUniformShader);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CustomShadersModels.txt";
        return sourceCodeURLs;
    }

    // make a checkerboard texture with an alpha that increases with the
    // diagonal number
    private TextureUniform makeCheckerboardTexture(int textureSize) {
        Uint8Array checkerboard = Uint8ArrayNative.create(4 * textureSize * textureSize);

        int maxDiagonal = 2 * (textureSize - 1);
        for (int i = 0; i < textureSize; i++) {
            for (int j = 0; j < textureSize; j++) {
                int index = i * textureSize + j;
                // Checking the parity of the diagonal number gives a checkerboard
                // pattern.
                int diagonal = i + j;
                if (diagonal % 2 == 0) {
                    // set the square red. We only need to set the red channel!
                    checkerboard.set(4 * index, 255);
                }
                // otherwise we'd set the square to black. But arrays are already
                // initialized to 0s so nothing needed here.

                // for the alpha channel, map the diagonal number to [0, 255]
                checkerboard.set(4 * index + 3, (255 * diagonal) / maxDiagonal);
            }
        }
        return new TextureUniform(new TextureUniformOptions()
                .setTypedArray(checkerboard)
                .setWidth(textureSize)
                .setHeight(textureSize)
                .setMinificationFilter(TextureMinificationFilter.NEAREST())
                .setMagnificationFilter(TextureMagnificationFilter.NEAREST()));
    }

    // This example is to demonstrate the conventions used for orienting
    // the texture. +x is to the right and +y is from **bottom to top**.
    // This is to be consistent with WebGL conventions.
    //
    // This example also demonstrates how to use a different pixel format,
    // in this case, RGB.
    private TextureUniform makeGradientTexture() {
        int size = 256;
        Uint8Array typedArray = Uint8ArrayNative.create(3 * size * size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int index = i * size + j;
                // red increases in the +x direction (to the right)
                typedArray.set(3 * index + 0, j);
                // Green increases in the +y direction (from bottom to top)
                typedArray.set(3 * index + 1, i);
                // blue is 0 so it is omitted.
            }
        }

        return new TextureUniform(new TextureUniformOptions()
                .setTypedArray(typedArray)
                .setWidth(size)
                .setHeight(size)
                .setPixelFormat(PixelFormat.RGB()));
    }

    private void selectModel(String url, CustomShader customShader) {
        csVPanel.getViewer().scene().primitives().removeAll();
        FromGltfOptions fromGltfOptions = FromGltfOptions.create(url);
        fromGltfOptions.customShader = customShader;
        fromGltfOptions.modelMatrix = Transforms.headingPitchRollToFixedFrame(position, hpr, Ellipsoid.WGS84(), fixedFrameTransform);
        Model model = (Model) csVPanel.getViewer().scene().primitives().add(Model.fromGltf(fromGltfOptions));
        model.readyPromise().then(m -> csVPanel.getViewer().camera.flyToBoundingSphere(m.boundingSphere(), new CameraFlyToOptions().setDuration(0.5)));
    }

    private static native double performanceNow() /*-{
        return performance.now();
    }-*/;
}