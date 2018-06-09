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
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerCesiumNavigationMixinOptions;
import org.cesiumjs.cs.widgets.viewerCesiumNavigationMixin;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

import javax.inject.Inject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class CesiumNavigation extends AbstractExample {
    @Inject
    public CesiumNavigation(ShowcaseExampleStore store) {
        super("Cesium Navigation", "Use CesiumNavigation plugin with GWT wrapper.", new String[]{"Showcase", "Cesium", "3d", "Viewer", "Navigation"}, store);
    }

    @Override
    public void buildPanel() {
        ViewerCesiumNavigationMixinOptions options = new ViewerCesiumNavigationMixinOptions();
        options.defaultResetView = Rectangle.fromDegrees(71, 3, 90, 14);
        options.enableCompass = true;
        options.enableZoomControls = true;
        options.enableDistanceLegend = true;
        options.enableCompassOuterRing = true;

        ViewerPanel csVPanel = new ViewerPanel();
        csVPanel.getViewer().extend(viewerCesiumNavigationMixin.instance(), options);

        contentPanel.add(new HTML("<p>Use CesiumNavigation plugin with GWT wrapper.</p>"));
        contentPanel.add(csVPanel);

        initWidget(contentPanel);
    }

    @Override
    public String[] getSourceCodeURLs() {
        String[] sourceCodeURLs = new String[1];
        sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "CesiumNavigation.txt";
        return sourceCodeURLs;
    }
}
