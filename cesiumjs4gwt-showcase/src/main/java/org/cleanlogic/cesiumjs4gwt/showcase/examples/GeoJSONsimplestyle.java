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

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;

import org.cesiumjs.cs.datasources.GeoJsonDataSource;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.enums.SceneMode;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

/**
 * @author Serge Silaev aka iSergio
 */
public class GeoJSONsimplestyle extends AbstractExample {
  private ViewerPanel csVPanel;

  @Inject
  public GeoJSONsimplestyle(ShowcaseExampleStore store) {
    super("GeoJSON simplestyle", "Load GeoJSON with simplestyle information",
        new String[] { "Showcase", "Cesium", "3d", "Viewer" }, store);
  }

  @Override
  public void buildPanel() {
    ViewerOptions viewerOptions = new ViewerOptions();
    viewerOptions.sceneMode = SceneMode.SCENE2D();
    viewerOptions.timeline = false;
    viewerOptions.animation = false;
    csVPanel = new ViewerPanel(viewerOptions);

    Promise<GeoJsonDataSource, String> dataSource = GeoJsonDataSource
        .load(GWT.getModuleBaseURL() + "SampleData/simplestyles.geojson");
    csVPanel.getViewer().dataSources().add(dataSource);
    dataSource.then(new Fulfill<GeoJsonDataSource>() {
      @Override
      public void onFulfilled(GeoJsonDataSource value) {
        csVPanel.getViewer().zoomTo(value);
      }
    });

    contentPanel.add(new HTML("<p>Load GeoJSON with simplestyle information.</p>"));
    contentPanel.add(csVPanel);

    initWidget(contentPanel);
  }

  @Override
  public String[] getSourceCodeURLs() {
    String[] sourceCodeURLs = new String[1];
    sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "GeoJSONsimplestyle.txt";
    return sourceCodeURLs;
  }
}