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
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.CustomShader;
import org.cesiumjs.cs.scene.enums.LightingModel;
import org.cesiumjs.cs.scene.options.CustomShaderOptions;
import org.cesiumjs.cs.scene.options.Cesium3DTilesetOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class CustomShaders3DTiles  extends AbstractExample {

    @Inject
    public CustomShaders3DTiles(ShowcaseExampleStore store) {
        super("Custom Shaders 3D Tiles",
                "Experimental custom shader",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "experimental"}, store, "1.88");
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        CustomShaderOptions customShaderOptions = new CustomShaderOptions();
        customShaderOptions.lightingModel = LightingModel.UNLIT();
        customShaderOptions.fragmentShaderText = "void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n"
                + "{\n"
                + "    material.diffuse = vec3(0.0, 0.0, 1.0);\n"
                + "    material.diffuse.g = -fsInput.attributes.positionEC.z / 1.0e4;\n"
                + "}\n";

        Cesium3DTilesetOptions options = Cesium3DTilesetOptions.create(IonResource.fromAssetId(75343));
        options.customShader = new CustomShader(customShaderOptions);
        Cesium3DTileset tileset = new Cesium3DTileset(options);
        csVPanel.getViewer().scene().primitives().add(tileset);
        csVPanel.getViewer().zoomTo(tileset);

        contentPanel.add(new HTML(
                "<p>Experimental custom shader.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CustomShaders3DTiles.txt";
        return sourceCodeURLs;
    }
}