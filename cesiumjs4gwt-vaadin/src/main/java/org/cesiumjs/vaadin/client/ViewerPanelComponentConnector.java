package org.cesiumjs.vaadin.client;

import com.google.gwt.core.client.GWT;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.cesiumjs.vaadin.ViewerPanelComponent;

@Connect(ViewerPanelComponent.class)
public class ViewerPanelComponentConnector extends AbstractComponentConnector {
    @Override
    public ViewerPanelWidget getWidget() {
        return (ViewerPanelWidget) super.getWidget();
    }

    @Override
    protected ViewerPanelWidget createWidget() {
        return GWT.create(ViewerPanelWidget.class);
    }

    @Override
    public ViewerPanelComponentState getState() {
        return (ViewerPanelComponentState) super.getState();
    }
}
