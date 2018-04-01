package org.cleanlogic.showcase.client.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.PointGraphics;
import org.cesiumjs.cs.datasources.graphics.options.PointGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * Custom behavior for the HomeButton widget.
 */
public class CustomHomeButton extends AbstractExample {

    @Inject
    public CustomHomeButton(ShowcaseExampleStore store) {
        super("Custom HomeButton Behavior", "Listen to HomeButton Command and customize tooltip", new String[]{"Showcase", "Cesium", "3d", "HomeButton", "HomeButtonViewModel"}, store);
    }

    @Override
    public void buildPanel() {

        final PointGraphicsOptions pointOptions = new PointGraphicsOptions();
        pointOptions.pixelSize = new ConstantProperty<>(5);

        final EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(Cartesian3.fromDegrees(-73.986555, 40.735396, 0));
        entityOptions.point = new PointGraphics(pointOptions);

        final Entity entity = new Entity(entityOptions);

        final ViewerOptions viewerOptions = new ViewerOptions();
        final ViewerPanel viewer = new ViewerPanel(viewerOptions);
        viewer.getViewer().homeButton().viewModel.tooltip = "Fly to New York";
        viewer.getViewer().entities().add(entity);
        viewer.getViewer().homeButton().viewModel.command.beforeExecute.addEventListener(
                new Event.Listener() {
                    @Override
                    public void function(Object... o) {
                        viewer.getViewer().flyTo(entity);
                    }
                }
        );

        contentPanel.add(new HTML("<div>Click the home button to fly to New York.</div>"));
        contentPanel.add(viewer);
        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        return new String[]{GWT.getModuleBaseURL() + "examples/" + "CustomHomeButton.txt"};
    }
}
