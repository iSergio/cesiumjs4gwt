/*
 * Copyright 2017 iserge.
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

package org.cleanlogic.showcase.client.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseClickEvent;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Function;
import org.cesiumjs.cs.scene.Cesium3DTileFeature;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Tiles3DFeaturePicking extends AbstractExample {
    // HTML overlay for showing feature name on mouseover
    private DivElement nameOverlay;
    // Information about the currently selected feature
    private Selected selected = new Selected();
    // Information about the currently highlighted feature
    private Highlighted highlighted = new Highlighted();
    // An entity object which will hold info about the currently selected feature for infobox display
    private Entity selectedEntity = new Entity();

    @Inject
    public Tiles3DFeaturePicking(ShowcaseExampleStore store) {
        super("3D Tiles Feature Picking", "Pick features in a 3D Tiles tileset.", new String[]{"Showcase", "Cesium", "3d", "Viewer"}, store);
    }

    @Override
    public void buildPanel() {
        final ViewerPanel csVPanel = new ViewerPanel();

        nameOverlay = RootPanel.get().getElement().getOwnerDocument().createDivElement();
        csVPanel.getViewer().container().appendChild(nameOverlay);
        nameOverlay.setClassName("backdrop");
        nameOverlay.getStyle().setDisplay(Style.Display.NONE);
        nameOverlay.getStyle().setPosition(Style.Position.ABSOLUTE);
        nameOverlay.getStyle().setBottom(0, Style.Unit.PX);
        nameOverlay.getStyle().setLeft(0, Style.Unit.PX);
//        nameOverlay.style['pointer-events'] = 'none';
        nameOverlay.getStyle().setPadding(4, Style.Unit.PX);
        nameOverlay.getStyle().setBackgroundColor("black");


        Cartesian3 initialPosition = Cartesian3.fromDegrees(-74.01881302800248, 40.69114333714821, 753);
        org.cesiumjs.cs.core.HeadingPitchRoll initialOrientation = org.cesiumjs.cs.core.HeadingPitchRoll.fromDegrees(21.27879878293835, -21.34390550872461, 0.0716951918898415);
        ViewOptions viewOptions = new ViewOptions();
        viewOptions.destinationPos = initialPosition;
        viewOptions.orientation = initialOrientation;
        viewOptions.endTransform = Matrix4.IDENTITY();
        csVPanel.getViewer().scene().camera().setView(viewOptions);

        // Load the NYC buildings tileset
        Cesium3DTileset tileset = csVPanel.getViewer().scene().primitives().add(Cesium3DTileset.create("https://beta.cesium.com/api/assets/1461?access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJkYWJmM2MzNS02OWM5LTQ3OWItYjEyYS0xZmNlODM5ZDNkMTYiLCJpZCI6NDQsImFzc2V0cyI6WzE0NjFdLCJpYXQiOjE0OTkyNjQ3NDN9.vuR75SqPDKcggvUrG_vpx0Av02jdiAxnnB1fNf-9f7s"));

        csVPanel.getViewer().screenSpaceEventHandler().setInputAction(new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                MouseMoveEvent movement = (MouseMoveEvent) event;
                // If a feature was previously highlighted, undo the highlight
                if (Cesium.defined(highlighted.feature)) {
                    highlighted.feature.color = highlighted.originalColor;
                    highlighted.feature = (Cesium3DTileFeature) JsObject.undefined();
                }

                // Pick a new feature
                Cesium3DTileFeature pickedFeature = (Cesium3DTileFeature) csVPanel.getViewer().scene().pick(movement.endPosition);
                if (!Cesium.defined(pickedFeature)) {
                    nameOverlay.getStyle().setDisplay(Style.Display.NONE);
                    return;
                }

                // A feature was picked, so show it's overlay content
                nameOverlay.getStyle().setDisplay(Style.Display.BLOCK);
                nameOverlay.getStyle().setBottom(csVPanel.getViewer().canvas().getClientHeight() - movement.endPosition.y + 26, Style.Unit.PX);
                nameOverlay.getStyle().setLeft(movement.endPosition.x + 26, Style.Unit.PX);
                String name = pickedFeature.getProperty("name").toString();
                if (!Cesium.defined(name)) {
                    name = pickedFeature.getProperty("id").toString();
                }
                nameOverlay.setInnerHTML("<font color=\"white\">" + name + "</font>");

                // Highlight the feature if it's not already selected.
                if (!pickedFeature.equals(selected.feature)) {
                    highlighted.feature = pickedFeature;
                    Color.clone(pickedFeature.color, highlighted.originalColor);
                    pickedFeature.color = Color.YELLOW();
                }
            }
        }, ScreenSpaceEventType.MOUSE_MOVE());

        final Function clickHandler = csVPanel.getViewer().screenSpaceEventHandler().getInputAction(ScreenSpaceEventType.LEFT_CLICK());
        csVPanel.getViewer().screenSpaceEventHandler().setInputAction(new ScreenSpaceEventHandler.Listener() {
            @Override
            public void function(Object event) {
                MouseClickEvent movement = (MouseClickEvent) event;
                // If a feature was previously selected, undo the highlight
                if (Cesium.defined(selected.feature)) {
                    selected.feature.color = selected.originalColor;
                    selected.feature = (Cesium3DTileFeature) JsObject.undefined();
                }

                // Pick a new feature
                Cesium3DTileFeature pickedFeature = (Cesium3DTileFeature) csVPanel.getViewer().scene().pick(movement.position);
                if (!Cesium.defined(pickedFeature)) {
                    GWT.log("undefined");
                    clickHandler.exec();
                    return;
                }

                // Select the feature if it's not already selected
                if (selected.feature == pickedFeature) {
                    return;
                }
                selected.feature = pickedFeature;

                // Save the selected feature's original color
                if (pickedFeature == highlighted.feature) {
                    Color.clone(highlighted.originalColor, selected.originalColor);
                    highlighted.feature = (Cesium3DTileFeature) JsObject.undefined();
                } else {
                    Color.clone(pickedFeature.color, selected.originalColor);
                }

                // Highlight newly selected feature
                pickedFeature.color = Color.LIME();

                // Set feature infobox description
                String featureName = pickedFeature.getProperty("name").toString();
                selectedEntity.name = featureName;
                selectedEntity.description = new ConstantProperty<>("Loading <div class=\"cesium-infoBox-loading\"></div>");
                csVPanel.getViewer().selectedEntity = selectedEntity;
                selectedEntity.description = new ConstantProperty<>("<table class=\"cesium-infoBox-defaultTable\"><tbody>" +
                        "<tr><th>BIN</th><td>" + pickedFeature.getProperty("BIN").toString() + "</td></tr>" +
                        "<tr><th>DOITT ID</th><td>" + pickedFeature.getProperty("DOITT_ID").toString() + "</td></tr>" +
                        "<tr><th>SOURCE ID</th><td>" + pickedFeature.getProperty("SOURCE_ID").toString() + "</td></tr>" +
                        "</tbody></table>");
            }
        }, ScreenSpaceEventType.LEFT_CLICK());

        contentPanel.add(new HTML("<p>Pick features in a 3D Tiles tileset.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DFeaturePicking.txt";
        return sourceCodeURLs;
    }

    private static class Selected {
        Cesium3DTileFeature feature = (Cesium3DTileFeature) JsObject.undefined();
        Color originalColor = new Color();
    }

    private static class Highlighted {
        Cesium3DTileFeature feature = (Cesium3DTileFeature) JsObject.undefined();
        Color originalColor = new Color();
    }
}