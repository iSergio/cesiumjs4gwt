/*
 * Copyright 2022 iSergio, Gis4Fun.
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
import com.google.gwt.user.client.ui.ListBox;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.experimental.CustomShader;
import org.cesiumjs.cs.scene.experimental.options.CustomShaderOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CustomShadersPropertyTextures extends AbstractExample {
    @Inject
    public CustomShadersPropertyTextures(ShowcaseExampleStore store) {
        super("Custom Shaders Property Textures",
                "Custom shaders property textures on 3D Tiles",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "Next", "Tiles"}, store, "1.92");
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();
        Scene scene = csVPanel.getViewer().scene();
        scene.terrainProvider = Cesium.createWorldTerrain();
        scene.globe.depthTestAgainstTerrain = false;

        // MAXAR OWT Muscatatuk photogrammetry dataset with property textures
        // containing horizontal and vertical uncertainty
        Cesium3DTileset tileset = (Cesium3DTileset) scene.primitives().add(Cesium3DTileset.create(IonResource.fromAssetId(905848)));

        csVPanel.getViewer().zoomTo(tileset);

        List<CustomShader> shaders = new ArrayList<>();
        shaders.add((CustomShader) JsObject.undefined());
        shaders.add(new CustomShader(new CustomShaderOptions().setFragmentShaderText(
                "void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n" +
                "{\n" +
                "    int horizontalUncertainty = fsInput.metadata.r3dm_uncertainty_ce90sum;\n" +
                "    material.diffuse = vec3(float(horizontalUncertainty) / 255.0);\n" +
                "}")));
        shaders.add(new CustomShader(new CustomShaderOptions().setFragmentShaderText(
                "void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n" +
                "{\n" +
                "    int verticalUncertainty = fsInput.metadata.r3dm_uncertainty_le90sum;\n" +
                "    material.diffuse = vec3(float(verticalUncertainty) / 255.0);\n" +
                "}"
        )));
        shaders.add(new CustomShader(new CustomShaderOptions().setFragmentShaderText(
                "void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n" +
                "{\n" +
                "    int uncertainty = fsInput.metadata.r3dm_uncertainty_ce90sum + fsInput.metadata.r3dm_uncertainty_le90sum;\n" +
                "    material.diffuse = vec3(float(uncertainty) / 255.0);\n" +
                "}"
        )));

        final ListBox shadersLBox = new ListBox();
        shadersLBox.addItem("Default View", "0");
        shadersLBox.addItem("Horizontal Uncertainty", "1");
        shadersLBox.addItem("Vertical Uncertainty", "2");
        shadersLBox.addItem("Combined Uncertainty", "3");
        shadersLBox.addChangeHandler(hdr -> {
            ListBox source = (ListBox) hdr.getSource();
            tileset.customShader = shaders.get(Integer.parseInt(source.getSelectedValue()));
        });

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(shadersLBox, 20, 20);

        contentPanel.add(new HTML(
                "<p>Custom shaders property textures on 3D Tiles.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CustomShadersPropertyTextures.txt";
        return sourceCodeURLs;
    }
}
