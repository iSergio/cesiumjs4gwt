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
public class Tiles3DPointCloud extends AbstractExample {

    @Inject
    public Tiles3DPointCloud(ShowcaseExampleStore store) {
        super("3D Tiles Point Cloud", "Example styles for a point cloud tileset.", new String[]{"Showcase", "3D Tiles"},
                store);
    }

    @Override
    public void buildPanel() {
        final ViewerPanel csVPanel = new ViewerPanel();

        Cesium3DTileset tileset = (Cesium3DTileset) csVPanel.getViewer().scene().primitives().add(Cesium3DTileset.create(IonResource.fromAssetId(16421)));

        tileset.readyPromise().then(value -> {
                BoundingSphere boundingSphere = value.boundingSphere();
                csVPanel.getViewer().camera.viewBoundingSphere(boundingSphere,
                        new org.cesiumjs.cs.core.HeadingPitchRange(0.0, -0.5, boundingSphere.radius));
                csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
        });

        contentPanel.add(new HTML("<p>Example styles for a point cloud tileset.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DPointCloud.txt";
        return sourceCodeURLs;
    }
}