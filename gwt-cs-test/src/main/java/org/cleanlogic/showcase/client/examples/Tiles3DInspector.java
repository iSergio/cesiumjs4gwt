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
import org.cesiumjs.cs.core.BoundingSphere;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.viewerCesium3DTilesInspectorMixin;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Tiles3DInspector extends AbstractExample {

    @Inject
    public Tiles3DInspector(ShowcaseExampleStore store) {
        super("3D Tiles Inspector", "Use the 3D Tiles inspector as a debugging tool for different tilesets.", new String[]{"Showcase", "Cesium", "3D Tiles"}, store);
    }

    @Override
    public void buildPanel() {
        final ViewerPanel csVPanel = new ViewerPanel();

        csVPanel.getViewer().extend(viewerCesium3DTilesInspectorMixin.instance());

        Cesium3DTileset tileset = csVPanel.getViewer().scene().primitives().add(Cesium3DTileset.create("https://beta.cesium.com/api/assets/1461?access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJkYWJmM2MzNS02OWM5LTQ3OWItYjEyYS0xZmNlODM5ZDNkMTYiLCJpZCI6NDQsImFzc2V0cyI6WzE0NjFdLCJpYXQiOjE0OTkyNjQ3NDN9.vuR75SqPDKcggvUrG_vpx0Av02jdiAxnnB1fNf-9f7s"));
        csVPanel.getViewer().cesium3DTilesInspector.viewModel.tileset = tileset;

        tileset.readyPromise().then(new Fulfill<Cesium3DTileset>() {
            @Override
            public void onFulfilled(Cesium3DTileset value) {
                BoundingSphere boundingSphere = value.boundingSphere();
                csVPanel.getViewer().camera.viewBoundingSphere(boundingSphere, new org.cesiumjs.cs.core.HeadingPitchRange(0.0, -0.5, boundingSphere.radius / 4.0));
                csVPanel.getViewer().camera.lookAtTransform(Matrix4.IDENTITY());
            }
        });

        contentPanel.add(new HTML("<p>Use the 3D Tiles inspector as a debugging tool for different tilesets.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DInspector.txt";
        return sourceCodeURLs;
    }
}