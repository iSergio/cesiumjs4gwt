/*
 * Copyright 2019 iserge.
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

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

import org.cesiumjs.cs.core.providers.ArcGISTiledElevationTerrainProvider;
import org.cesiumjs.cs.core.providers.options.ArcGISTiledElevationTerrainProviderOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

/**
 * @author Serge Silaev aka iSergio
 */
public class ArcGISTiledElevationTerrain extends AbstractExample {

  @Inject
  public ArcGISTiledElevationTerrain(ShowcaseExampleStore store) {
    super("ArcGIS Tiled Elevation Terrain", "Add terrain from an ArcGIS Server.", new String[] { "Terrain", "ArcGIS" },
        store);
  }

  @Override
  public void buildPanel() {
    ViewerOptions options = new ViewerOptions();
    options.terrainProvider = new ArcGISTiledElevationTerrainProvider(ArcGISTiledElevationTerrainProviderOptions
        .create("https://elevation3d.arcgis.com/arcgis/rest/services/WorldElevation3D/Terrain3D/ImageServer"));
    ViewerPanel csVPanel = new ViewerPanel(options);

    contentPanel.add(new HTML("<p>Add terrain from an ArcGIS Server.</p>"));
    contentPanel.add(csVPanel);

    initWidget(contentPanel);
  }

  @Override
  public String[] getSourceCodeURLs() {
    String[] sourceCodeURLs = new String[1];
    sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "ArcGISTiledElevationTerrain.txt";
    return sourceCodeURLs;
  }
}
