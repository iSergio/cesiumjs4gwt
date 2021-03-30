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
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.scene.PostProcessStage;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class CustomPostProcess extends AbstractExample {
    private ViewerPanel csVPanel;

    @Inject
    public CustomPostProcess(ShowcaseExampleStore store) {
        super("Custom Post Process", "Custom post processing effect",
                new String[]{"Custom post process", "Post processing"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.shouldAnimate = true;
        csVPanel = new ViewerPanel(viewerOptions);

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(
                GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb");
        EntityOptions options = new EntityOptions();
        options.name = GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb";
        options.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-123.0744619, 44.0503706));
        options.model = new ModelGraphics(modelGraphicsOptions);
        csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(options);

        String fragmentShaderSource = "uniform sampler2D colorTexture; \n" + "varying vec2 v_textureCoordinates; \n"
                + "const int KERNEL_WIDTH = 16; \n" + "void main(void) \n" + "{ \n"
                + "    vec2 step = 1.0 / czm_viewport.zw; \n"
                + "    vec2 integralPos = v_textureCoordinates - mod(v_textureCoordinates, 8.0 * step); \n"
                + "    vec3 averageValue = vec3(0.0); \n" + "    for (int i = 0; i < KERNEL_WIDTH; i++) \n" + "    { \n"
                + "        for (int j = 0; j < KERNEL_WIDTH; j++) \n" + "        { \n"
                + "            averageValue += texture2D(colorTexture, integralPos + step * vec2(i, j)).rgb; \n"
                + "        } \n" + "    } \n" + "    averageValue /= float(KERNEL_WIDTH * KERNEL_WIDTH); \n"
                + "    gl_FragColor = vec4(averageValue, 1.0); \n" + "} \n";
        csVPanel.getViewer().scene().postProcessStages.add(PostProcessStage.create(fragmentShaderSource));

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);

        contentPanel.add(new HTML("<p>Post processing effects.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CustomPostProcess.txt";
        return sourceCodeURLs;
    }
}