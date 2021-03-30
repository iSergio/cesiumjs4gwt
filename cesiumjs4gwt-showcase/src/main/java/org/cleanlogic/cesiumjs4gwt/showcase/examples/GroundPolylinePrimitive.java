package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.core.geometry.GroundPolylineGeometry;
import org.cesiumjs.cs.core.geometry.options.GroundPolylineGeometryOptions;
import org.cesiumjs.cs.core.options.GeometryInstanceOptions;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Material;
import org.cesiumjs.cs.scene.apperances.PolylineColorAppearance;
import org.cesiumjs.cs.scene.apperances.PolylineMaterialAppearance;
import org.cesiumjs.cs.scene.apperances.options.PolylineMaterialAppearanceOptions;
import org.cesiumjs.cs.scene.options.GroundPolylinePrimitiveOptions;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class GroundPolylinePrimitive extends AbstractExample {

    @Inject
    public GroundPolylinePrimitive(ShowcaseExampleStore store) {
        super("GroundPolylinePrimitive", "Show how use GroundPolylinePrimitive's",
                new String[]{"ground", "polyline", "primitive"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();

        contentPanel.add(new HTML("<p>Show how use GroundPolylinePrimitive's.</p>"));
        contentPanel.add(csVPanel);

        Cartesian3[] positions = Cartesian3.fromDegreesArray(
                new double[]{-112.1340164450331, 36.05494287836128, -112.08821010582645, 36.097804071380715});
        GroundPolylineGeometryOptions groundPolylineGeometryOptions = GroundPolylineGeometryOptions.create(positions);
        groundPolylineGeometryOptions.width = 4;

        GeometryInstanceOptions geometryInstanceOptions = new GeometryInstanceOptions();
        geometryInstanceOptions.geometry = new GroundPolylineGeometry(groundPolylineGeometryOptions);
        geometryInstanceOptions.id = "object returned when this instance is picked and to get/set per-instance attributes";

        PolylineMaterialAppearanceOptions appearanceOptions = new PolylineMaterialAppearanceOptions();
        appearanceOptions.material = Material.fromType("Color");

        GroundPolylinePrimitiveOptions primitiveOptions = new GroundPolylinePrimitiveOptions();
        primitiveOptions.geometryInstances = new GeometryInstance[]{new GeometryInstance(geometryInstanceOptions)};
        primitiveOptions.appearance = new PolylineMaterialAppearance(appearanceOptions);

        org.cesiumjs.cs.scene.GroundPolylinePrimitive groundPolylinePrimitive = new org.cesiumjs.cs.scene.GroundPolylinePrimitive(
                primitiveOptions);

        csVPanel.getViewer().scene().groundPrimitives().add(groundPolylinePrimitive);

        positions = Cartesian3.fromDegreesArray(new double[]{-112.1340164450331, 36.05494287836128, -112.08821010582645,
                36.097804071380715, -112.13296079730024, 36.168769146801104});
        groundPolylineGeometryOptions = GroundPolylineGeometryOptions.create(positions);
        groundPolylineGeometryOptions.width = 4;
        groundPolylineGeometryOptions.loop = true;

        JsObject attributes = JsObject.create();
        attributes.setProperty("color",
                ColorGeometryInstanceAttribute.fromColor(Color.fromCssColorString("green", new Color()).withAlpha(0.7f)));
        attributes.setProperty("distanceDisplayCondition",
                new DistanceDisplayConditionGeometryInstanceAttribute(1000, 30000));

        geometryInstanceOptions = new GeometryInstanceOptions();
        geometryInstanceOptions.geometry = new GroundPolylineGeometry(groundPolylineGeometryOptions);
        geometryInstanceOptions.attributes = attributes;
        geometryInstanceOptions.id = "object returned when this instance is picked and to get/set per-instance attributes";

        primitiveOptions = new GroundPolylinePrimitiveOptions();
        primitiveOptions.geometryInstances = new GeometryInstance[]{new GeometryInstance(geometryInstanceOptions)};
        primitiveOptions.appearance = new PolylineColorAppearance();

        groundPolylinePrimitive = new org.cesiumjs.cs.scene.GroundPolylinePrimitive(primitiveOptions);
        csVPanel.getViewer().scene().groundPrimitives().add(groundPolylinePrimitive);

        ViewOptions viewOptions = new ViewOptions();
        viewOptions.destinationPos = Cartesian3.fromDegrees(-112.08821010582645, 36.097804071380715, 1000.0);
        viewOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(-Math.PI_OVER_TWO(), -Math.PI_OVER_FOUR(), 0.0);
        csVPanel.getViewer().camera.setView(viewOptions);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "GroundPolylinePrimitive.txt";
        return sourceCodeURLs;
    }
}