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
import org.cesiumjs.cs.js.JsArray;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Cesium3DTileFeature;
import org.cesiumjs.cs.scene.Cesium3DTileStyle;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.Cesium3DTileColorBlendMode;
import org.cesiumjs.cs.scene.CustomShader;
import org.cesiumjs.cs.scene.enums.LightingModel;
import org.cesiumjs.cs.scene.enums.UniformType;
import org.cesiumjs.cs.scene.options.CustomShaderOptions;
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
    private Cesium3DTileStyle translucentWindowsStyle;
    private CustomShader materialShader;
    private CustomShader selectFeatureShader;
    private CustomShader multipleFeatureIdsShader;
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

        tileset = Cesium3DTileset.create(IonResource.fromAssetId(775877));

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

        JsObject color = JsObject.create();
        JsArray<JsArray<String>> conditions = new JsArray<>();
        JsArray<String> condition = new JsArray<>();
        condition.push("${component} === 'Windows'", "color('gray', 0.7)");
        conditions.push(condition);
        color.setProperty("conditions", conditions);
        translucentWindowsStyle = new Cesium3DTileStyle(JsObject.create().setProperty("color", color));

        // Shaders ============================================================================

        // Dummy shader that sets the UNLIT lighting mode. For use with the classification style
        String emptyFragmentShader = "void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material) {}";
        unlitShader = new CustomShader(new CustomShaderOptions()
                .setLightingModel(LightingModel.UNLIT()).setFragmentShaderText(emptyFragmentShader));

        materialShader = new CustomShader(new CustomShaderOptions()
                .setLightingModel(LightingModel.PBR())
                .setFragmentShaderText("const int WINDOW = 0;\n" +
                        "            const int FRAME = 1;\n" +
                        "            const int WALL = 2;\n" +
                        "            const int ROOF = 3;\n" +
                        "            const int SKYLIGHT = 4;\n" +
                        "            const int AIR_CONDITIONER_WHITE = 5;\n" +
                        "            const int AIR_CONDITIONER_BLACK = 6;\n" +
                        "            const int AIR_CONDITIONER_TALL = 7;\n" +
                        "            const int CLOCK = 8;\n" +
                        "            const int PILLARS = 9;\n" +
                        "            const int STREET_LIGHT = 10;\n" +
                        "            const int TRAFFIC_LIGHT = 11;\n" +
                        "            \n" +
                        "            void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material) {\n" +
                        "              int featureId = fsInput.featureIds.featureId_0;\n" +
                        "            \n" +
                        "              if (featureId == CLOCK) {\n" +
                        "                // Shiny brass\n" +
                        "                material.specular = vec3(0.98, 0.90, 0.59);\n" +
                        "                material.roughness = 0.1;\n" +
                        "              } else if (\n" +
                        "                featureId == STREET_LIGHT ||\n" +
                        "                featureId == AIR_CONDITIONER_BLACK ||\n" +
                        "                featureId == AIR_CONDITIONER_WHITE ||\n" +
                        "                featureId == AIR_CONDITIONER_TALL ||\n" +
                        "                featureId == ROOF\n" +
                        "              ) {\n" +
                        "                // dull aluminum\n" +
                        "                material.specular = vec3(0.91, 0.92, 0.92);\n" +
                        "                material.roughness = 0.5;\n" +
                        "              } else if (featureId == WINDOW || featureId == SKYLIGHT) {\n" +
                        "                // make translucent, but also set an orange emissive color so it looks like\n" +
                        "                // it's lit from inside\n" +
                        "                material.emissive = vec3(1.0, 0.3, 0.0);\n" +
                        "                material.alpha = 0.5;\n" +
                        "              } else if (featureId == WALL || featureId == FRAME || featureId == PILLARS) {\n" +
                        "                // paint the walls and pillars white to contrast the brass clock\n" +
                        "                material.diffuse = mix(material.diffuse, vec3(1.0), 0.8);\n" +
                        "                material.roughness = 0.9;\n" +
                        "              } else {\n" +
                        "                // brighten everything else\n" +
                        "                material.diffuse += 0.05;\n" +
                        "                material.roughness = 0.9;\n" +
                        "              }\n" +
                        "            }"));

        Number NOTHING_SELECTED = 12;
        selectFeatureShader = new CustomShader(new CustomShaderOptions()
                .setLightingModel(LightingModel.PBR())
                .addUniform("u_selectedFeature", UniformType.INT(), NOTHING_SELECTED)
                .setFragmentShaderText("const int NOTHING_SELECTED = 12;\n" +
                        "            void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material) {\n" +
                        "              int featureId = fsInput.featureIds.featureId_0;\n" +
                        "            \n" +
                        "              if (u_selectedFeature < NOTHING_SELECTED && featureId == u_selectedFeature) {\n" +
                        "                material.specular = vec3(1.00, 0.85, 0.57);\n" +
                        "                material.roughness = 0.1;\n" +
                        "              }\n" +
                        "            }"));

        multipleFeatureIdsShader = new CustomShader(new CustomShaderOptions()
                .setLightingModel(LightingModel.UNLIT())
                .addUniform("u_selectedFeature", UniformType.FLOAT(), NOTHING_SELECTED)
                .setFragmentShaderText("const int IDS0_WINDOW = 0;\n" +
                        "            const int IDS1_FACADE = 2;\n" +
                        "            const int IDS1_ROOF = 3;\n" +
                        "            const vec3 PURPLE = vec3(0.5, 0.0, 1.0);\n" +
                        "            const vec3 YELLOW = vec3(1.0, 1.0, 0.0);\n" +
                        "            const vec3 NO_TINT = vec3(1.0);\n" +
                        "            \n" +
                        "            void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material) {\n" +
                        "              int featureId0 = fsInput.featureIds.featureId_0; // fine features\n" +
                        "              int featureId1 = fsInput.featureIds.featureId_1; // coarse features\n" +
                        "            \n" +
                        "              // use both feature ID sets to determine where the features are\n" +
                        "              float isWindow = float(featureId0 == IDS0_WINDOW);\n" +
                        "              float isFacade = float(featureId1 == IDS1_FACADE);\n" +
                        "              float isRoof = float(featureId1 == IDS1_ROOF);\n" +
                        "            \n" +
                        "              // Tint the roof windows yellow and facade windows purple\n" +
                        "              vec3 tint = NO_TINT;\n" +
                        "              tint = mix(tint, YELLOW, isWindow * isRoof);\n" +
                        "              tint = mix(tint, PURPLE, isWindow * isFacade);\n" +
                        "              material.diffuse *= tint;\n" +
                        "            }"));
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
        listBox.addItem("Show Alternative Classification");
        listBox.addItem("Translucent Windows");
        listBox.addItem("Stylized PBR Materials");
        listBox.addItem("Golden Touch");
        listBox.addItem("Multiple Feature ID Sets");
        listBox.addChangeHandler(event -> {
            String value = ((ListBox) event.getSource()).getSelectedItemText();
            switch (value) {
                case "Photogrammetry": defaults(); break;
                case "Show Classification": showClassification(); break;
                case "Show Alternative Classification": showAlternativeClassification(); break;
                case "Translucent Windows": translucentWindows(); break;
                case "Stylized PBR Materials": pbrMaterials(); break;
                case "Golden Touch": goldenTouch(); break;
                case "Multiple Feature ID Sets": multipleFeatureIds(); break;
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
        tileset.featureIdLabel = 0;
    }

    private void showClassification() {
        defaults();
        tileset.style = classificationStyle;
        tileset.colorBlendMode = Cesium3DTileColorBlendMode.MIX();
    }

    private void showAlternativeClassification() {
        showClassification();
        // This dataset has a second feature ID texture.
        tileset.featureIdLabel = 1;
    }

    private void translucentWindows() {
        defaults();
        tileset.style = translucentWindowsStyle;
    }

    private void pbrMaterials() {
        defaults();
        tileset.customShader = materialShader;
    }

    private void goldenTouch() {
        defaults();
        tileset.customShader = selectFeatureShader;
    }

    private void multipleFeatureIds() {
        defaults();
        tileset.customShader = multipleFeatureIdsShader;
    }
}
