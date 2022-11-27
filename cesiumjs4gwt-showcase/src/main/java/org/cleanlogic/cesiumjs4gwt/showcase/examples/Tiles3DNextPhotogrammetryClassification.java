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
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseClickEvent;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Cesium3DTileFeature;
import org.cesiumjs.cs.scene.Cesium3DTileStyle;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.Cesium3DTileColorBlendMode;
import org.cesiumjs.cs.scene.experimental.CustomShader;
import org.cesiumjs.cs.scene.experimental.enums.LightingModel;
import org.cesiumjs.cs.scene.experimental.enums.UniformType;
import org.cesiumjs.cs.scene.experimental.options.CustomShaderOptions;
import org.cesiumjs.cs.scene.options.CameraFlyToOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class Tiles3DNextPhotogrammetryClassification  extends AbstractExample {
    private Cesium3DTileset tileset;
    private CustomShader unlitShader;
    private Cesium3DTileStyle classificationStyle;
    private CustomShader translucentWindowsShader;
    private CustomShader materialShader;
    private CustomShader selectFeatureShader;
    private boolean enablePicking = true;

    @Inject
    public Tiles3DNextPhotogrammetryClassification(ShowcaseExampleStore store) {
        super("3D Tiles Next Photogrammetry Classification",
                "Load a photogrammetry dataset with feature ID textures from EXT_mesh_features",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "experimental"}, store, "1.88");
    }

    @Override
    public void buildPanel() {
        ViewerOptions options = new ViewerOptions();
        options.terrainProvider = Cesium.createWorldTerrain();
        options.infoBox = false;
        options.orderIndependentTranslucency = false;
        ViewerPanel csVPanel = new ViewerPanel(options);


        csVPanel.getViewer().clock().currentTime = JulianDate.fromIso8601("2021-11-09T20:27:37.016064475348684937Z");

        Scene scene = csVPanel.getViewer().scene();

        tileset = Cesium3DTileset.create(IonResource.fromAssetId(666297));

        Cartesian3 translation = new Cartesian3(-1.398521324920626, 0.7823052871729486, 0.7015244410592609);
        tileset.modelMatrix = Matrix4.fromTranslation(translation);

        tileset.maximumScreenSpaceError = 8.0;
        scene.pickTranslucentDepth = true;
        scene.light.intensity = 7.0;

        scene.primitives().add(tileset);
        csVPanel.getViewer().zoomTo(tileset);

        // Fly to a nice overview of the city.
        csVPanel.getViewer().camera.flyTo(new CameraFlyToOptions()
                .setDestination(new Cartesian3(-2703640.80485846, -4261161.990345464, 3887439.511104276))
                .setOrientation(new HeadingPitchRoll(0.22426651143535548, -0.2624145362506527, 0.000006972977223185239)));

        // Styles =============================================================================

        classificationStyle = new Cesium3DTileStyle();
        JsObject.setProperty(classificationStyle, "color", "color(${color})");

        // Shaders ============================================================================

        // Dummy shader that sets the UNLIT lighting mode. For use with the classification style
        String emptyFragmentShader = "void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material) {}";
        unlitShader = new CustomShader(new CustomShaderOptions()
                .setLightingModel(LightingModel.UNLIT()).setFragmentShaderText(emptyFragmentShader));

        translucentWindowsShader = new CustomShader(new CustomShaderOptions().setLightingModel(LightingModel.UNLIT())
                .setTranslucent(true).setFragmentShaderText(String.join("\n", new String[] {
                        "const float WINDOW = 0.0;",
                        "const float SKYLIGHT = 4.0;",
                        "const float TOTAL_FEATURES = 12.0;",
                        "",
                        "void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material) {",
                        "  // NOTE: This is exposing internal details of the shader. It would be better if this was added to fsInput somewhere...",
                        "  float featureId = floor(texture2D(FEATURE_ID_TEXTURE, FEATURE_ID_TEXCOORD).FEATURE_ID_CHANNEL * 255.0 + 0.5);",
                        "",
                        "  if (featureId == WINDOW || featureId == SKYLIGHT) {",
                        "    material.alpha = 0.4;",
                        "    material.roughness = 0.1;",
                        "  }",
                        "}",
                })));

        materialShader = new CustomShader(new CustomShaderOptions().setLightingModel(LightingModel.PBR())
                .setTranslucent(true).setFragmentShaderText(String.join("\n", new String[] {
                        "const float WINDOW = 0.0;",
                        "const float FRAME = 1.0;",
                        "const float WALL = 2.0;",
                        "const float ROOF = 3.0;",
                        "const float SKYLIGHT = 4.0;",
                        "const float AIR_CONDITIONER_WHITE = 5.0;",
                        "const float AIR_CONDITIONER_BLACK = 6.0;",
                        "const float AIR_CONDITIONER_TALL = 7.0;",
                        "const float CLOCK = 8.0;",
                        "const float PILLARS = 9.0;",
                        "const float STREET_LIGHT = 10.0;",
                        "const float TRAFFIC_LIGHT = 11.0;",
                        "",
                        "void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material) {",
                        "  // NOTE: This is exposing internal details of the shader. It would be better if this was added to fsInput somewhere...",
                        "  float featureId = floor(texture2D(FEATURE_ID_TEXTURE, FEATURE_ID_TEXCOORD).FEATURE_ID_CHANNEL * 255.0 + 0.5);",
                        "",
                        "  if (featureId == CLOCK) {",
                        "    // Shiny brass",
                        "    material.specular = vec3(0.98, 0.90, 0.59);",
                        "    material.roughness = 0.3;",
                        "  } else if (",
                        "    featureId == STREET_LIGHT ||",
                        "    featureId == AIR_CONDITIONER_BLACK ||",
                        "    featureId == AIR_CONDITIONER_WHITE ||",
                        "    featureId == AIR_CONDITIONER_TALL ||",
                        "    featureId == ROOF",
                        "  ) {",
                        "    // dull aluminum",
                        "    material.specular = vec3(0.91, 0.92, 0.92);",
                        "    material.roughness = 0.5;",
                        "  } else if (featureId == WINDOW || featureId == SKYLIGHT) {",
                        "    // make translucent, but also set an orange emissive color so it looks like",
                        "    // it's lit from inside",
                        "    material.emissive = vec3(1.0, 0.3, 0.0);",
                        "    material.alpha = 0.5;",
                        "  } else if (featureId == WALL || featureId == FRAME || featureId == PILLARS) {",
                        "    // paint the walls and pillars white to contrast the brass clock",
                        "    material.diffuse = mix(material.diffuse, vec3(1.0), 0.8);",
                        "    material.roughness = 0.9;",
                        "  } else {",
                        "    // brighten everything else",
                        "    material.diffuse += 0.05;",
                        "    material.roughness = 0.9;",
                        "  }",
                        "}",
                })));

        Number NOTHING_SELECTED = 12;
        selectFeatureShader = new CustomShader(new CustomShaderOptions()
                .setLightingModel(LightingModel.PBR())
                .addUniform("u_selectedFeature", UniformType.FLOAT(), NOTHING_SELECTED)
                .setFragmentShaderText(String.join("\n", new String[] {
                        "const float NOTHING_SELECTED = 12.0;",
                        "void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material) {",
                        "  // NOTE: This is exposing internal details of the shader. It would be better if this was added to fsInput somewhere...",
                        "  float featureId = floor(texture2D(FEATURE_ID_TEXTURE, FEATURE_ID_TEXCOORD).FEATURE_ID_CHANNEL * 255.0 + 0.5);",
                        "",
                        "  if (u_selectedFeature < NOTHING_SELECTED && featureId == u_selectedFeature) {",
                        "    material.specular = vec3(1.00, 0.85, 0.57);",
                        "    material.roughness = 0.3;",
                        "  }",
                        "}",
                })));

        tileset.style = classificationStyle;
        tileset.colorBlendMode = Cesium3DTileColorBlendMode.MIX();

        DivElement nameOverlay = RootPanel.get().getElement().getOwnerDocument().createDivElement();
        nameOverlay.addClassName("backdrop");
        nameOverlay.getStyle().setDisplay(Style.Display.NONE);
        nameOverlay.getStyle().setPosition(Style.Position.ABSOLUTE);
        nameOverlay.getStyle().setBottom(0., Style.Unit.PX);
        nameOverlay.getStyle().setLeft(0., Style.Unit.PX);
//        nameOverlay.style["pointer-events"] = "none";
        nameOverlay.getStyle().setPadding(4.0, Style.Unit.PX);
        nameOverlay.getStyle().setBackgroundColor("black");
        nameOverlay.getStyle().setWhiteSpace(Style.WhiteSpace.PRE_LINE);
        nameOverlay.getStyle().setFontSize(12., Style.Unit.PX);
        csVPanel.getViewer().container().appendChild(nameOverlay);

        this.enablePicking = true;

        csVPanel.getViewer().screenSpaceEventHandler().setInputAction(event -> {
            MouseMoveEvent movement = (MouseMoveEvent) event;
            if (enablePicking) {
                PickedObject pickedObject = scene.pick(movement.endPosition);
                if (pickedObject instanceof Cesium3DTileFeature) {
                    nameOverlay.getStyle().setDisplay(Style.Display.BLOCK);
                    nameOverlay.getStyle().setBottom(csVPanel.getViewer().canvas().getClientHeight() - movement.endPosition.y, Style.Unit.PX);
                    nameOverlay.getStyle().setLeft(movement.endPosition.x, Style.Unit.PX);
                    String message = "Component: " + ((Cesium3DTileFeature) pickedObject).getProperty("component")
                            + "\nFeature ID: " + ((Cesium3DTileFeature) pickedObject).getProperty("_batchId");
                    nameOverlay.setInnerText(message);
                } else {
                    nameOverlay.getStyle().setDisplay(Style.Display.NONE);
                }
            } else {
                nameOverlay.getStyle().setDisplay(Style.Display.NONE);
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());

        csVPanel.getViewer().screenSpaceEventHandler().setInputAction(event -> {
            MouseClickEvent movement = (MouseClickEvent) event;
            if (enablePicking) {
                PickedObject pickedObject = scene.pick(movement.position);
                Object batchId = JsObject.undefined();
                if (pickedObject != null) {
                    batchId = JsObject.getObject(pickedObject, "_batchId");
                }
                Cesium.log(batchId);
                if (Cesium.defined(pickedObject) && Cesium.defined(batchId)) {
                    selectFeatureShader.setUniform("u_selectedFeature", (Number) batchId);
                } else {
                    selectFeatureShader.setUniform("u_selectedFeature", NOTHING_SELECTED);
                }
            }
        }, ScreenSpaceEventType.LEFT_CLICK());

        CheckBox enablePickingCBox = new CheckBox("Enable picking");
        enablePickingCBox.getElement().getStyle().setColor("white");
        enablePickingCBox.setWidth("100px");
        enablePickingCBox.setValue(this.enablePicking);
        enablePickingCBox.addValueChangeHandler(event -> enablePicking = event.getValue());

        ListBox listBox = new ListBox();
        listBox.addItem("Photogrammetry");
        listBox.addItem("Show Classification");
        listBox.addItem("Translucent Windows");
        listBox.addItem("Stylized PBR Materials");
        listBox.addItem("Golden Touch");
        listBox.addChangeHandler(event -> {
            String value = ((ListBox) event.getSource()).getSelectedItemText();
            switch (value) {
                case "Photogrammetry": defaults(); break;
                case "Show Classification": showClassification(); break;
                case "Translucent Windows": translucentWindows(); break;
                case "Stylized PBR Materials": pbrMaterials(); break;
                case "Golden Touch": goldenTouch(); break;
                default: break;
            }
        });

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(enablePickingCBox);
        hPanel.add(listBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML(
                "<p>Load a photogrammetry dataset with feature ID textures from EXT_mesh_features.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);

        defaults();
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DNextPhotogrammetryClassification.txt";
        return sourceCodeURLs;
    }

    private void defaults() {
        tileset.style = (Cesium3DTileStyle) JsObject.undefined();
        tileset.customShader = unlitShader;
        tileset.colorBlendMode = Cesium3DTileColorBlendMode.HIGHLIGHT();
        tileset.colorBlendAmount = 0.5;
    }

    private void showClassification() {
        defaults();
        tileset.style = classificationStyle;
        tileset.colorBlendMode = Cesium3DTileColorBlendMode.MIX();
    }

    private void translucentWindows() {
        defaults();
        tileset.customShader = translucentWindowsShader;
    }

    private void pbrMaterials() {
        defaults();
        tileset.customShader = materialShader;
    }

    private void goldenTouch() {
        defaults();
        tileset.customShader = selectFeatureShader;
    }
}
