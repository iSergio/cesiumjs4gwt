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
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Tiles3DPhotogrammetry extends AbstractExample {

    @Inject
    public Tiles3DPhotogrammetry(ShowcaseExampleStore store) {
        super("3D Tiles Photogrammetry", "A sample photgrammetry dataset rendered with 3D Tiles.", new String[]{"Showcase", "Cesium", "3D Tiles"}, store);
    }

    @Override
    public void buildPanel() {
        final ViewerPanel csVPanel = new ViewerPanel();

        Cesium3DTileset tileset = (Cesium3DTileset) csVPanel.getViewer().scene().primitives().add(Cesium3DTileset.create("https://beta.cesium.com/api/assets/1458?access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiIxYmJiNTAxOC1lOTg5LTQzN2EtODg1OC0zMWJjM2IxNGNlYmMiLCJpZCI6NDQsImFzc2V0cyI6WzE0NThdLCJpYXQiOjE0OTkyNjM4MjB9.1WKijRa-ILkmG6utrhDWX6rDgasjD7dZv-G5ZyCmkKg"));

        tileset.readyPromise().then(new Fulfill<Cesium3DTileset>() {
            @Override
            public void onFulfilled(Cesium3DTileset value) {
                BoundingSphere boundingSphere = value.boundingSphere();
                csVPanel.getViewer().camera.viewBoundingSphere(boundingSphere, new org.cesiumjs.cs.core.HeadingPitchRange(0.0, -0.5, boundingSphere.radius));
                csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
            }
        });

        contentPanel.add(new HTML("<p>A sample photgrammetry dataset rendered with 3D Tiles.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DPhotogrammetry.txt";
        return sourceCodeURLs;
    }
}