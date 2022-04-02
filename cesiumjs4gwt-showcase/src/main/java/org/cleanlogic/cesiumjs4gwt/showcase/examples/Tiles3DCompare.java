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
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.core.ScreenSpaceEventHandler;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.enums.SplitDirection;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class Tiles3DCompare  extends AbstractExample {
    private Viewer viewer;
    private DivElement slider;
    private boolean moveActive = false;

    @Inject
    public Tiles3DCompare(ShowcaseExampleStore store) {
        super("3D Tiles Compare",
                "Compare 3D Tiles tilesets by showing different ones on different sides of the screen",
                new String[]{"Showcase", "Cesium", "3d", "3D Tiles", "Split", "Compare"}, store, "1.92");
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        viewer = csVPanel.getViewer();

        Cesium3DTileset left = (Cesium3DTileset) viewer.scene()
                .primitives().add(Cesium3DTileset.create(IonResource.fromAssetId(69380)));
        left.splitDirection = SplitDirection.LEFT();

        Cesium3DTileset right = (Cesium3DTileset) viewer.scene().primitives().add(Cesium.createOsmBuildings());
        right.splitDirection = SplitDirection.RIGHT();

        viewer.zoomTo(left);

        slider = csVPanel.getElement().getOwnerDocument().createDivElement();
        slider.setId("slider");
        slider.getStyle().setPosition(Style.Position.ABSOLUTE);
        slider.getStyle().setBackgroundColor("#d3d3d3");
        slider.getStyle().setZIndex(9999);
        slider.getStyle().setCursor(Style.Cursor.COL_RESIZE);
        csVPanel.getViewer().container().appendChild(slider);

        contentPanel.add(new HTML(
                "<p>Compare 3D Tiles tilesets by showing different ones on different sides of the screen.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);

        ScreenSpaceEventHandler handler = new ScreenSpaceEventHandler(slider);
        handler.setInputAction(event -> moveActive = true, ScreenSpaceEventType.LEFT_DOWN());
        handler.setInputAction(event -> moveActive = true, ScreenSpaceEventType.PINCH_START());
        handler.setInputAction(this::move, ScreenSpaceEventType.MOUSE_MOVE());
        handler.setInputAction(this::move, ScreenSpaceEventType.PINCH_MOVE());
        handler.setInputAction(event -> moveActive = false, ScreenSpaceEventType.LEFT_UP());
        handler.setInputAction(event -> moveActive = false, ScreenSpaceEventType.PINCH_END());

        this.addAttachHandler(hdr -> {
            slider.getStyle().setTop(csVPanel.getElement().getAbsoluteTop(), Style.Unit.PX);
            slider.getStyle().setLeft(50, Style.Unit.PCT);
            slider.getStyle().setWidth(5, Style.Unit.PX);
            slider.getStyle().setHeight(csVPanel.getElement().getClientHeight(), Style.Unit.PX);
            viewer.scene().splitPosition = (double) slider.getOffsetLeft() / slider.getParentElement().getOffsetWidth();
        });
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DCompare.txt";
        return sourceCodeURLs;
    }

    private void move(Object event) {
        if (!moveActive) {
            return;
        }
        MouseMoveEvent movement = (MouseMoveEvent) event;

        double relativeOffset = movement.endPosition.x;
        double splitPosition = (slider.getOffsetLeft() + relativeOffset
                - slider.getParentElement().getAbsoluteLeft()) / slider.getParentElement().getOffsetWidth();
        slider.getStyle().setLeft(100.0 * splitPosition, Style.Unit.PCT);
        viewer.scene().splitPosition = splitPosition;
    }
}