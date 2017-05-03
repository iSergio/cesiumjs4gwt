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
import org.cesiumjs.cs.core.DefaultProxy;
import org.cesiumjs.cs.core.GoogleEarthEnterpriseMetadata;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.providers.GoogleEarthEnterpriseTerrainProvider;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.scene.providers.GoogleEarthEnterpriseImageryProvider;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.showcase.client.basic.AbstractExample;
import org.cleanlogic.showcase.client.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class GoogleEarthEnterprise extends AbstractExample {

    @Inject
    public GoogleEarthEnterprise(ShowcaseExampleStore store) {
        super("Google Earth Enterprise", "Add imagery from a Web Map Service (WMS) server.", new String[]{"Showcase", "Cesium", "3d", "GoogleEarthEnterprise", "ImageryProvider"}, store);
    }

    @Override
    public void buildPanel() {
        GoogleEarthEnterpriseMetadata geeMetadata = GoogleEarthEnterpriseMetadata.create("http://www.earthenterprise.org/3d");

        ViewerOptions options = new ViewerOptions();
        options.imageryProvider = GoogleEarthEnterpriseImageryProvider.create(geeMetadata);
        options.terrainProvider = GoogleEarthEnterpriseTerrainProvider.create(geeMetadata);
        options.baseLayerPicker = false;
        ViewerPanel csVPanel = new ViewerPanel(options);

        ViewOptions viewOptions = new ViewOptions();
        viewOptions.destinationRec = Rectangle.fromDegrees(-123.0, 36.0, -121.7, 39.0);
        csVPanel.getViewer().camera.setView(viewOptions);

        contentPanel.add(new HTML("<p>Add imagery from a Web Map Service (WMS) server.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "GoogleEarthEnterprise.txt";
        return sourceCodeURLs;
    }
}
