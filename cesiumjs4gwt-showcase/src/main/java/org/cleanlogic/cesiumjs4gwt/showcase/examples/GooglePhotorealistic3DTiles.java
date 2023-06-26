/*
 * Copyright 2023 iSergio, Gis4Fun.
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
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

public class GooglePhotorealistic3DTiles extends AbstractExample {
    @Inject
    public GooglePhotorealistic3DTiles(ShowcaseExampleStore store) {
        super("Google Photorealistic 3D Tiles",
                "Google Photorealistic 3D Tiles integration",
                new String[]{"Showcase", "Cesium", "3d", "Viewer", "Google"}, store, "1.106");
    }

    @Override
    public void buildPanel() {
        ViewerOptions viewerOptions = new ViewerOptions();
        viewerOptions.timeline = false;
        viewerOptions.animation = false;
        viewerOptions.sceneModePicker = false;
        viewerOptions.baseLayerPicker = false;
        ViewerPanel csVPanel = new ViewerPanel(viewerOptions);

        // The globe does not need to be displayed,
        // since the Photorealistic 3D Tiles include terrain
        csVPanel.getViewer().scene().globe.show = false;

        Promise<Cesium3DTileset, Void> promise = Cesium.createGooglePhotorealistic3DTileset();
        promise.then(value -> csVPanel.getViewer().scene().primitives().add(value));

        // Point the camera at the Googleplex
        ViewOptions viewOptions = new ViewOptions();
        viewOptions.destinationPos = new Cartesian3(-2693797.551060477,
                -4297135.517094725,
                3854700.7470414364);
        viewOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(
                4.6550106925119925,
                -0.2863894863138836,
                1.3561760425773173e-7);
        csVPanel.getViewer().scene().camera().setView(viewOptions);

        contentPanel.add(new HTML(
                "<p>Google Photorealistic 3D Tiles integration.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "GooglePhotorealistic3DTiles.txt";
        return sourceCodeURLs;
    }
}
