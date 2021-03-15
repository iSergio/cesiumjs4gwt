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

package org.cleanlogic.cesiumjs4gwt.showcase.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.datasources.CzmlDataSource;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.PositionProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

/**
 * @author Serge Silaev aka iSergio
 */
public class Clampto3DTiles extends AbstractExample {
    private ViewerPanel csVPanel;

    private Scene scene;
    private Clock clock;

    private Entity entity;
    private PositionProperty positionProperty;

    @Inject
    public Clampto3DTiles(ShowcaseExampleStore store) {
        super("Clamp to 3D Tiles", "Clamp a model to a 3D Tileset using the clampToHeight function.",
                new String[]{"Clamp", "Point", "Label", "3DTiles"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.terrainProvider = Cesium.createWorldTerrain();
        csVPanel = new ViewerPanel(viewerOptions);

        scene = csVPanel.getViewer().scene();
        clock = csVPanel.getViewer().clock();

        Promise<CzmlDataSource, Void> dataSourcePromise = CzmlDataSource
                .load(GWT.getModuleBaseURL() + "SampleData/ClampToGround.czml");
        csVPanel.getViewer().dataSources().add(dataSourcePromise).then(new Fulfill<CzmlDataSource>() {
            @Override
            public void onFulfilled(CzmlDataSource dataSource) {
                entity = dataSource.entities.getById("CesiumMilkTruck");
                positionProperty = entity.position;
            }
        });

        Cesium3DTileset tileset = (Cesium3DTileset) scene.primitives()
                .add(Cesium3DTileset.create(IonResource.fromAssetId(6074)));

        ViewOptions viewOptions = new ViewOptions();
        viewOptions.destinationPos = new Cartesian3(1216403.8845586285, -4736357.493351395, 4081299.715698949);
        viewOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(4.2892217081808806, -0.4799070147502502,
                6.279789177843313);
        viewOptions.endTransform = Matrix4.IDENTITY();
        csVPanel.getViewer().camera.setView(viewOptions);

        if (scene.clampToHeightSupported()) {
            tileset.initialTilesLoaded.addEventListener(new Event.Listener() {
                @Override
                public void function(Object... o) {
                    clock.shouldAnimate = true;
                    final JsObject[] objectsToExclude = new JsObject[]{(JsObject) (Object) entity};
                    scene.postRender().addEventListener(new Event.Listener() {
                        @Override
                        public void function(Object... o) {
                            Cartesian3 position = positionProperty.getValue(clock.currentTime);
                            entity.position = new ConstantPositionProperty(scene.clampToHeight(position, objectsToExclude));
                        }
                    });
                }
            });
        }

        contentPanel.add(new HTML("<p>Clamp a model to a 3D Tileset using the clampToHeight function.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Clampto3DTiles.txt";
        return sourceCodeURLs;
    }
}
