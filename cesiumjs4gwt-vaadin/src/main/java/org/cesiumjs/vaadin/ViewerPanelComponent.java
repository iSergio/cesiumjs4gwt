package org.cesiumjs.vaadin;

import com.vaadin.ui.AbstractComponent;
import org.cesiumjs.vaadin.client.ViewerPanelComponentState;

public class ViewerPanelComponent extends AbstractComponent {

    @Override
    public ViewerPanelComponentState getState() {
        return (ViewerPanelComponentState) super.getState();
    }
}
