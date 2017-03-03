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
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.collections.BillboardCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.geometry.BoxGeometry;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.core.geometry.RectangleGeometry;
import org.cesiumjs.cs.core.geometry.options.BoxGeometryOptions;
import org.cesiumjs.cs.core.geometry.options.RectangleGeometryOptions;
import org.cesiumjs.cs.core.options.GeometryInstanceOptions;
import org.cesiumjs.cs.core.providers.CesiumTerrainProvider;
import org.cesiumjs.cs.core.providers.options.CesiumTerrainProviderOptions;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Primitive;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.apperances.PerInstanceColorAppearance;
import org.cesiumjs.cs.scene.apperances.options.PerInstanceColorAppearanceOptions;
import org.cesiumjs.cs.scene.options.BillboardOptions;
import org.cesiumjs.cs.scene.options.PrimitiveOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.viewerCesiumInspectorMixin;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class CesiumInspector extends AbstractExample {
    @Inject
    public CesiumInspector(ShowcaseExampleStore store) {
        super("Cesium Inspector", "Use the cesium inspector as a debugging tool for different primitives.", new String[]{"Showcase", "Cesium", "3d", "Viewer", "Debug", "Primitives"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerPanel csVPanel = new ViewerPanel();
        Scene scene = csVPanel.getViewer().scene();
        Globe globe = csVPanel.getViewer().scene().globe;
        globe.depthTestAgainstTerrain = true;

        CesiumTerrainProviderOptions cesiumTerrainProviderOptions = new CesiumTerrainProviderOptions();
        cesiumTerrainProviderOptions.url = "https://assets.agi.com/stk-terrain/world";
        cesiumTerrainProviderOptions.requestVertexNormals = true;
        cesiumTerrainProviderOptions.requestWaterMask = true;
        csVPanel.getViewer().terrainProvider = new CesiumTerrainProvider(cesiumTerrainProviderOptions);

        //Add Cesium Inspector
        csVPanel.getViewer().extend(viewerCesiumInspectorMixin.instance());

        //Add Primitives
        PrimitiveOptions primitiveOptions = new PrimitiveOptions();
        primitiveOptions.asynchronous = false;
        GeometryInstanceOptions geometryInstanceOptions = new GeometryInstanceOptions();

        BoxGeometryOptions boxGeometryOptions = new BoxGeometryOptions();
        boxGeometryOptions.vertexFormat = PerInstanceColorAppearance.VERTEX_FORMAT();
        boxGeometryOptions.dimensions = new Cartesian3(400000.0, 300000.0, 500000.0);
        geometryInstanceOptions.geometry = BoxGeometry.createGeometry(BoxGeometry.fromDimensions(boxGeometryOptions));

        geometryInstanceOptions.modelMatrix = Matrix4.multiplyByTranslation(Transforms.eastNorthUpToFixedFrame(Cartesian3.fromDegrees(-105.0, 45.0)), new Cartesian3(0.0, 0.0, 250000), new Matrix4());
        geometryInstanceOptions.attributes = JsObject.createObject().cast();
        JsObject.$(geometryInstanceOptions.attributes, "color", ColorGeometryInstanceAttribute.fromColor(Color.RED().withAlpha(0.5f)));

        primitiveOptions.geometryInstances = new GeometryInstance[] {new GeometryInstance(geometryInstanceOptions)};
        PerInstanceColorAppearanceOptions perInstanceColorAppearanceOptions = new PerInstanceColorAppearanceOptions();
        perInstanceColorAppearanceOptions.closed = true;
        primitiveOptions.appearance = new PerInstanceColorAppearance(perInstanceColorAppearanceOptions);
        scene.primitives().add(new Primitive(primitiveOptions));

        primitiveOptions = new PrimitiveOptions();
        primitiveOptions.asynchronous = false;
        geometryInstanceOptions = new GeometryInstanceOptions();

        RectangleGeometryOptions rectangleGeometryOptions = new RectangleGeometryOptions();
        rectangleGeometryOptions.rectangle = Rectangle.fromDegrees(-100.0, 30.0, -93.0, 37.0);
        rectangleGeometryOptions.height = 100000;
        rectangleGeometryOptions.vertexFormat = PerInstanceColorAppearance.VERTEX_FORMAT();
        geometryInstanceOptions.geometry = RectangleGeometry.createGeometry(new RectangleGeometry(rectangleGeometryOptions));

        geometryInstanceOptions.attributes = JsObject.createObject().cast();
        JsObject.$(geometryInstanceOptions.attributes, "color", ColorGeometryInstanceAttribute.fromColor(Color.BLUE()));

        primitiveOptions.geometryInstances = new GeometryInstance[] {new GeometryInstance(geometryInstanceOptions)};
        primitiveOptions.appearance = new PerInstanceColorAppearance();
        scene.primitives().add(new Primitive(primitiveOptions));

        BillboardCollection billboards = (BillboardCollection) scene.primitives().add(new BillboardCollection());
        BillboardOptions billboardOptions = new BillboardOptions();
        billboardOptions.position = Cartesian3.fromDegrees(-75.59777, 40.03883, 150000);
        billboardOptions.image = GWT.getModuleBaseURL() + "images/Cesium_Logo_overlay.png";
        billboards.add(billboardOptions);

        contentPanel.add(new HTML("<p>Use the cesium inspector as a debugging tool for different primitives</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CesiumInspector.txt";
        return sourceCodeURLs;
    }
}
