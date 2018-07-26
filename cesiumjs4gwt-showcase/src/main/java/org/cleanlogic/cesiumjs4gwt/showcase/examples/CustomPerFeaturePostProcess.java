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
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.PickedObject;
import org.cesiumjs.cs.core.ScreenSpaceEventHandler;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.PostProcess;
import org.cesiumjs.cs.scene.PostProcessStage;
import org.cesiumjs.cs.scene.Primitive;
import org.cesiumjs.cs.scene.options.PostProcessStageOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class CustomPerFeaturePostProcess extends AbstractExample {
    private ViewerPanel csVPanel;

    @Inject
    public CustomPerFeaturePostProcess(ShowcaseExampleStore store) {
        super("Custom Per-Feature Post Process", "Custom per-feature post processing effect.", new String[]{"Custom post process", "per feature"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.shouldAnimate = true;
        csVPanel = new ViewerPanel(viewerOptions);

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb");
        EntityOptions options = new EntityOptions();
        options.name = GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb";
        options.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-123.0744619, 44.0503706));
        options.model = new ModelGraphics(modelGraphicsOptions);
        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(options);

        // Shade selected model with highlight.
        String fragmentShaderSource =
                "uniform sampler2D colorTexture;\n" +
                        "varying vec2 v_textureCoordinates;\n" +
                        "uniform vec4 highlight;\n" +
                        "void main() {\n" +
                        "    vec4 color = texture2D(colorTexture, v_textureCoordinates);\n" +
                        "    if (czm_selected()) {\n" +
                        "        vec3 highlighted = highlight.a * highlight.rgb + (1.0 - highlight.a) * color.rgb;\n" +
                        "        gl_FragColor = vec4(highlighted, 1.0);\n" +
                        "    } else { \n" +
                        "        gl_FragColor = color;\n" +
                        "    }\n" +
                        "}\n";
        JsObject uniforms = JsObject.create();
        uniforms.setProperty("highlight", new Cesium.Function() {
            @Override
            public Color function(Object... args) {
                return new Color(1.0, 0.0, 0.0, 0.5);
            }
        });
        PostProcessStageOptions postProcessStageOptions = PostProcessStageOptions.create(fragmentShaderSource);
        postProcessStageOptions.uniforms = uniforms;

        final PostProcess stage = csVPanel.getViewer().scene().postProcessStages.add(new PostProcessStage(postProcessStageOptions));
        JsObject.setProperty(stage, "selected", new Primitive[0]);

        ScreenSpaceEventHandler handler = new ScreenSpaceEventHandler(csVPanel.getViewer().scene().canvas());
        handler.setInputAction(new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                MouseMoveEvent mouseMoveEvent = (MouseMoveEvent) event;
                PickedObject pickedObject = csVPanel.getViewer().scene().pick(mouseMoveEvent.endPosition);
                if (pickedObject != null) {
                    JsObject.setProperty(stage, "selected", new Primitive[] {pickedObject.primitive});
                } else {
                    JsObject.setProperty(stage, "selected", new Primitive[0]);
                }
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);

        contentPanel.add(new HTML("<p>Post processing effects.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CustomPerFeaturePostProcess.txt";
        return sourceCodeURLs;
    }
}