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
import com.google.gwt.user.client.ui.HTML;
import org.cesiumjs.cs.core.BoundingSphere;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio
 */
public class Tiles3DBIM extends AbstractExample {
    ViewerPanel csVPanel;

    @Inject
    public Tiles3DBIM(ShowcaseExampleStore store) {
        super("3D Tiles BIM", "A sample BIM dataset rendered with 3D Tiles.", new String[]{"Showcase", "3D Tiles"},
                store);
    }

    @Override
    public void buildPanel() {
        csVPanel = new ViewerPanel();

        Cesium3DTileset tileset = (Cesium3DTileset) csVPanel.getViewer().scene().primitives()
                .add(Cesium3DTileset.create(IonResource.fromAssetId(8564)));

        tileset.readyPromise().then(this::zoomToTileset);

        contentPanel.add(new HTML("<p>A sample BIM dataset rendered with 3D Tiles.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    private void zoomToTileset(Cesium3DTileset tileset) {
        BoundingSphere boundingSphere = tileset.boundingSphere();
        csVPanel.getViewer().camera.viewBoundingSphere(boundingSphere,
                new org.cesiumjs.cs.core.HeadingPitchRange(0.5, -0.2, boundingSphere.radius * 4.0));
        csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DBIM.txt";
        return sourceCodeURLs;
    }
}