package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.geometry.PolylineArrowMaterialProperty;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.PolylineGraphics;
import org.cesiumjs.cs.datasources.graphics.options.PolylineGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * Showcase example that demonstrates how to draw a polyline arrow.
 */
public class PolylineArrow extends AbstractExample {

    @Inject
    public PolylineArrow(ShowcaseExampleStore store) {
        super("Polyline Arrow", "Draw a polyline arrow.",
                new String[]{"Showcase", "Cesium", "3d", "polyline", "PolylineArrowMaterialProperty"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();
        PolylineGraphicsOptions polylineGraphicsOptions;
        EntityOptions entityOptions;

        polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.width = new ConstantProperty<>(15.0);
        polylineGraphicsOptions.material = new PolylineArrowMaterialProperty(new ConstantProperty<>(Color.RED()));
        polylineGraphicsOptions.positions = new ConstantProperty<>(
                Cartesian3.fromDegreesArrayHeights(new double[]{-75, 38, 250000, -125, 38, 250000}));
        entityOptions = new EntityOptions();
        entityOptions.name = "Red arrow";
        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);
        Entity redLine = csVPanel.getViewer().entities().add(entityOptions);

        csVPanel.getViewer().zoomTo(csVPanel.getViewer().entities());

        contentPanel.add(new HTML("<p>Draw a polyline arrow.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "PolylineArrow.txt";
        return sourceCodeURLs;
    }
}
