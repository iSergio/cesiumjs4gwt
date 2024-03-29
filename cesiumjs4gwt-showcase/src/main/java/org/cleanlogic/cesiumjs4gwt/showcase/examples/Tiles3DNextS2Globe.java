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
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Cesium3DTileFeature;
import org.cesiumjs.cs.scene.Cesium3DTileStyle;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.CustomShader;
import org.cesiumjs.cs.scene.enums.UniformType;
import org.cesiumjs.cs.scene.options.CustomShaderOptions;
import org.cesiumjs.cs.scene.options.CameraFlyToOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class Tiles3DNextS2Globe extends AbstractExample {
    private Viewer viewer;
    private boolean enablePicking = true;
    @Inject
    public Tiles3DNextS2Globe(ShowcaseExampleStore store) {
        super("3D Tiles Next S2 Globe",
                "Load a global scale 3D Tiles Next tileset that uses 3DTILES_bounding_volume_S2",
                new String[]{"Showcase", "Cesium", "3d", "Viewer"}, store, "1.88");
    }

    @Override
    public void buildPanel() {
        ViewerOptions options = new ViewerOptions();
        options.enableGlobe = false;
        ViewerPanel csVPanel = new ViewerPanel(options);
        viewer = csVPanel.getViewer();

        Scene scene = csVPanel.getViewer().scene();

        viewer.camera.flyTo(new CameraFlyToOptions()
                .setDuration(0)
                .setDestination(new Cartesian3(762079.3157173397, -28363749.882652905, 19814354.842565004))
                .setOrientation(new Cartesian3(-0.022007098944236157, 0.819079900508189, -0.5732571885110),
                        new Cartesian3(-0.015396759850986286, 0.5730503851893346, 0.8193754913471885))
                .setEasingFunction(EasingFunction.QUADRATIC_IN_OUT()));

        // MAXAR OWT WFF 1.2 Base Globe
        Cesium3DTileset tileset = (Cesium3DTileset) scene.primitives().add(
                Cesium3DTileset.create(IonResource.fromAssetId(691510)));
        tileset.maximumScreenSpaceError =  4;

        // --- Style ---

        JsObject jsStyle = JsObject.create();
        jsStyle.setProperty("defines", JsObject.create());
        jsStyle.getJsObject("defines").setProperty("LandCoverColor", "rgb(${color}[0], ${color}[1], ${color}[2])");
        jsStyle.setProperty("color", "${LandCoverColor} === vec4(1.0) ? rgb(254, 254, 254) : ${LandCoverColor}");
        Cesium3DTileStyle style = new Cesium3DTileStyle(jsStyle);

        // --- Custom Shader ---

        CustomShader customShader = new CustomShader(new CustomShaderOptions()
                .addUniform("u_time", UniformType.FLOAT(), 0)
                .setFragmentShaderText("void fragmentMain(FragmentInput fsInput, inout czm_modelMaterial material)\n" +
                        "            {\n" +
                        "              int featureId = fsInput.featureIds.featureId_0;\n" +
                        "              // Use cartesian coordinates but scale to be roughly [-1, 1]\n" +
                        "              vec3 positionWC = fsInput.attributes.positionWC / 6.3e6;\n" +
                        "              if (featureId == 60)\n" +
                        "              {\n" +
                        "                // Something like FM synthesis to make irregularly spaced waves\n" +
                        "                float wave = sin(14.0 * positionWC.z - u_time);\n" +
                        "                wave = 0.5 + 0.5 * sin(10.0 * wave * positionWC.z - u_time);\n" +
                        "                // mix in an over-saturated version of the diffuse to make shimmering bands of color\n" +
                        "                material.diffuse = mix(material.diffuse, material.diffuse * 3.0, wave);\n" +
                        "              }\n" +
                        "            }"));

        final double startTime = performanceNow();
        scene.postUpdate().addEventListener((Event.Listener) o -> customShaderUpdate(customShader, startTime));

        // --- Picking ---

        ScreenSpaceEventHandler handler = new ScreenSpaceEventHandler(scene.canvas());

        DivElement metadataOverlay = RootPanel.get().getElement().getOwnerDocument().createDivElement();
        metadataOverlay.addClassName("backdrop");
        metadataOverlay.getStyle().setDisplay(Style.Display.NONE);
        metadataOverlay.getStyle().setPosition(Style.Position.ABSOLUTE);
        metadataOverlay.getStyle().setBottom(0., Style.Unit.PX);
        metadataOverlay.getStyle().setLeft(0., Style.Unit.PX);
//        metadataOverlay.style["pointer-events"] = "none";
        metadataOverlay.getStyle().setPadding(4.0, Style.Unit.PX);
        metadataOverlay.getStyle().setBackgroundColor("#303030");
        metadataOverlay.getStyle().setWhiteSpace(Style.WhiteSpace.PRE_LINE);
        metadataOverlay.getStyle().setFontSize(16., Style.Unit.PX);
        csVPanel.getViewer().container().appendChild(metadataOverlay);

        handler.setInputAction(event -> {
            MouseMoveEvent movement = (MouseMoveEvent) event;
            if (enablePicking) {
                PickedObject feature = scene.pick(movement.endPosition);
                if (feature instanceof Cesium3DTileFeature) {
                    metadataOverlay.getStyle().setDisplay(Style.Display.BLOCK);
                    metadataOverlay.getStyle().setBottom(viewer.canvas().getClientHeight() - movement.endPosition.y, Style.Unit.PX);
                    metadataOverlay.getStyle().setLeft(movement.endPosition.x, Style.Unit.PX);

                    StringBuilder tableHtmlScratch = new StringBuilder("<table><thead><tr><th><tt>Property</tt></th><th><tt>Value</tt></th></tr></thead><tbody>");

                    String[] propertyIds = ((Cesium3DTileFeature) feature).getPropertyIds();
                    for (String propertyId : propertyIds) {
                        JsObject propertyValue = ((Cesium3DTileFeature) feature).getProperty(propertyId);
                        tableHtmlScratch.append("<tr><td><tt>").append(propertyId).append("</tt></td><td><tt>").append(propertyValue).append("</tt></td></tr>");
                    }
                    tableHtmlScratch.append("</tbody></table>");
                    metadataOverlay.setInnerHTML(tableHtmlScratch.toString());
                } else {
                    metadataOverlay.getStyle().setDisplay(Style.Display.NONE);
                }
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());

        ListBox listBox = new ListBox();
        listBox.addItem("Globe View");
        listBox.addItem("Show S2 Bounding Volumes");
        listBox.addItem("Apply Style");
        listBox.addItem("Apply Custom Shader");
        listBox.addChangeHandler(event -> {
            String value = ((ListBox) event.getSource()).getSelectedItemText();
            switch (value) {
                case "Globe View": {
                    tileset.customShader = null;
                    tileset.debugShowBoundingVolume = false;
                    tileset.style = null;
                    break;
                }
                case "Show S2 Bounding Volumes": {
                    tileset.customShader = null;
                    tileset.debugShowBoundingVolume = true;
                    tileset.style = null;
                    break;
                }
                case "Apply Style": {
                    tileset.customShader = null;
                    tileset.debugShowBoundingVolume = false;
                    tileset.style = style;
                    break;
                }
                case "Apply Custom Shader": {
                    tileset.customShader = customShader;
                    tileset.debugShowBoundingVolume = false;
                    tileset.style = null;
                    break;
                }
                default: break;
            }
        });

        CheckBox enablePickingCBox = new CheckBox("Enable picking");
        enablePickingCBox.getElement().getStyle().setColor("white");
        enablePickingCBox.setWidth("100px");
        enablePickingCBox.setValue(this.enablePicking);
        enablePickingCBox.addValueChangeHandler(event -> {
            metadataOverlay.getStyle().setDisplay(Style.Display.NONE);
            enablePicking = event.getValue();
        });

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(listBox);
        hPanel.add(enablePickingCBox);

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(hPanel, 20, 20);

        contentPanel.add(new HTML(
                "<p>Load a global scale 3D Tiles Next tileset that uses 3DTILES_bounding_volume_S2..</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DNextS2Globe.txt";
        return sourceCodeURLs;
    }

    private native double performanceNow() /*-{
        return performance.now();
    }-*/;

    private void customShaderUpdate(CustomShader customShader, double startTime) {
        double elapsedTimeSeconds = (performanceNow() - startTime) / 1000.;
        customShader.setUniform("u_time", elapsedTimeSeconds);
    }
}
