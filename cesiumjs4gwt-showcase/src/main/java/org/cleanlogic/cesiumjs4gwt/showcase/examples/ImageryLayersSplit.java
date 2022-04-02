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

package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.collections.ImageryLayerCollection;
import org.cesiumjs.cs.core.ScreenSpaceEventHandler;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.scene.ImageryLayer;
import org.cesiumjs.cs.scene.enums.SplitDirection;
import org.cesiumjs.cs.scene.providers.ArcGisMapServerImageryProvider;
import org.cesiumjs.cs.scene.providers.IonImageryProvider;
import org.cesiumjs.cs.scene.providers.options.IonImageryProviderOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class ImageryLayersSplit extends AbstractExample {
    private ViewerPanel csVPanel;
    private Viewer viewer;
    private Element slider;
    private boolean moveActive = false;
    @Inject
    public ImageryLayersSplit(ShowcaseExampleStore store) {
        super("Imagery Layers Split", "Use the split property to only show layers on one side of a slider.",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "Slider", "Split"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.imageryProvider = ArcGisMapServerImageryProvider
                .create("https://services.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer");
        viewerOptions.baseLayerPicker = false;
        viewerOptions.infoBox = false;
        csVPanel = new ViewerPanel(viewerOptions);
        viewer = csVPanel.getViewer();

        ImageryLayerCollection layers = csVPanel.getViewer().imageryLayers();
        ImageryLayer earthAtNight = layers.addImageryProvider(new IonImageryProvider(IonImageryProviderOptions.create(3812)));
        earthAtNight.splitDirection = SplitDirection.LEFT(); // Only show to the left of the slider.

        slider = csVPanel.getElement().getOwnerDocument().createDivElement();
        slider.setId("slider");
        slider.getStyle().setPosition(Style.Position.ABSOLUTE);
        slider.getStyle().setBackgroundColor("#d3d3d3");
        slider.getStyle().setZIndex(9999);
        slider.getStyle().setCursor(Style.Cursor.COL_RESIZE);
        csVPanel.getViewer().container().appendChild(slider);

        contentPanel.add(csVPanel);
        contentPanel.add(new HTML("<p>Use the split property to only show layers on one side of a slider.</p>"));

        initWidget(contentPanel);

        ScreenSpaceEventHandler handler = new ScreenSpaceEventHandler(slider);
        handler.setInputAction(event -> moveActive = true, ScreenSpaceEventType.LEFT_DOWN());
        handler.setInputAction(event -> moveActive = true, ScreenSpaceEventType.PINCH_START());
        handler.setInputAction(this::move, ScreenSpaceEventType.MOUSE_MOVE());
        handler.setInputAction(this::move, ScreenSpaceEventType.PINCH_MOVE());
        handler.setInputAction(event -> moveActive = false, ScreenSpaceEventType.LEFT_UP());
        handler.setInputAction(event -> moveActive = false, ScreenSpaceEventType.PINCH_END());

        this.addAttachHandler(this::resizeSlider);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ImageryLayersSplit.txt";
        return sourceCodeURLs;
    }

    private void resizeSlider(AttachEvent event) {
        slider.getStyle().setTop(csVPanel.getElement().getAbsoluteTop(), Style.Unit.PX);
        slider.getStyle().setLeft(50, Style.Unit.PCT);
        slider.getStyle().setWidth(5, Style.Unit.PX);
        slider.getStyle().setHeight(csVPanel.getElement().getClientHeight(), Style.Unit.PX);
        viewer.scene().splitPosition = (double) (slider.getOffsetLeft() - slider.getParentElement().getAbsoluteLeft())
                / slider.getParentElement().getOffsetWidth();
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
