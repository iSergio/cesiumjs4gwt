package org.cesiumjs.vaadin;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Widgetset("org.cesiumjs.vaadin.ViewerPanelComponent")
@JavaScript({"app://VAADIN/widgetsets/org.cesiumjs.vaadin.ViewerPanelComponent/cs/Cesium/Cesium.js"})
public class CesiumPanelUI extends UI {
    @Override
    public void init(VaadinRequest request) {
        ViewerPanelComponent cesiumViewer = new ViewerPanelComponent();
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.addComponent(new Label("Hello, world!"));
        layout.addComponent(cesiumViewer);
    }
}