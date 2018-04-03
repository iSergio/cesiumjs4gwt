/*
 * Copyright 2018 iserge.
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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.collections.ClippingPlaneCollection;
import org.cesiumjs.cs.collections.options.ClippingPlaneCollectionOptions;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.providers.CesiumTerrainProvider;
import org.cesiumjs.cs.core.providers.options.CesiumTerrainProviderOptions;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.BoxGraphics;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.options.BoxGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.scene.ClippingPlane;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class TerrainClippingPlanes extends AbstractExample {
    @Inject
    public TerrainClippingPlanes(ShowcaseExampleStore store) {
        super("Terrain Clipping Planes", "User-defined clipping planes applied to terrain.", new String[]{"Showcase", "3D Tiles"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.skyAtmosphere = null;
        final ViewerPanel csVPanel = new ViewerPanel(viewerOptions);

        CesiumTerrainProviderOptions terrainProviderOptions = new CesiumTerrainProviderOptions();
        terrainProviderOptions.url = "https://assets.agi.com/stk-terrain/v1/tilesets/world/tiles";
        terrainProviderOptions.requestWaterMask = true;
        terrainProviderOptions.requestVertexNormals = true;
        csVPanel.getViewer().terrainProvider = new CesiumTerrainProvider(terrainProviderOptions);

        Cartesian3 position = Cartesian3.fromRadians(-2.0862979473351286, 0.6586620013036164, 1400.0);

        BoxGraphicsOptions boxGraphicsOptions = new BoxGraphicsOptions();
        boxGraphicsOptions.dimensions = new ConstantProperty<>(new Cartesian3(1400.0, 1400.0, 2800.0));
        boxGraphicsOptions.material = new ColorMaterialProperty(Color.WHITE().withAlpha(0.3f));
        boxGraphicsOptions.outline = new ConstantProperty<>(true);
        boxGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(position);
        entityOptions.box = new BoxGraphics(boxGraphicsOptions);
        Entity entity = csVPanel.getViewer().entities().add(entityOptions);

        ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
        modelGraphicsOptions.uri = new ConstantProperty<>(GWT.getModuleBaseURL() + "SampleData/models/CesiumMan/Cesium_Man.glb");
        modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(128);
        modelGraphicsOptions.maximumScale = new ConstantProperty<>(800);

        entityOptions = new EntityOptions();
        entityOptions.position = new ConstantPositionProperty(position);
        entityOptions.model = new ModelGraphics(modelGraphicsOptions);
        csVPanel.getViewer().entities().add(entityOptions);

        ClippingPlaneCollectionOptions clippingPlaneCollectionOptions = new ClippingPlaneCollectionOptions();
        clippingPlaneCollectionOptions.modelMatrix = entity.computeModelMatrix(JulianDate.now());
        clippingPlaneCollectionOptions.planes = new ClippingPlane[] {
                new ClippingPlane(new Cartesian3(1.0,  0.0, 0.0), -700.0),
                new ClippingPlane(new Cartesian3(-1.0,  0.0, 0.0), -700.0),
                new ClippingPlane(new Cartesian3(0.0,  1.0, 0.0), -700.0),
                new ClippingPlane(new Cartesian3(0.0, -1.0, 0.0), -700.0)
        };
        clippingPlaneCollectionOptions.edgeWidth = 1.0;
        clippingPlaneCollectionOptions.edgeColor = Color.WHITE();

        final Globe globe = csVPanel.getViewer().scene().globe;
        globe.depthTestAgainstTerrain = true;
        globe.clippingPlanes = new ClippingPlaneCollection(clippingPlaneCollectionOptions);

        csVPanel.getViewer().trackedEntity = entity;

        CheckBox globeClippingCBox = new CheckBox("Globe clipping planes enabled");
        globeClippingCBox.setValue(true);
        globeClippingCBox.getElement().getStyle().setColor("white");
        globeClippingCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                globe.clippingPlanes.enabled = event.getValue();
            }
        });

        AbsolutePanel aPanel = new AbsolutePanel();
        aPanel.add(csVPanel);
        aPanel.add(globeClippingCBox, 20, 20);

        contentPanel.add(new HTML("<p>User-defined clipping planes applied to terrain.</p>"));
        contentPanel.add(aPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "TerrainClippingPlanes.txt";
        return sourceCodeURLs;
    }
}
