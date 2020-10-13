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

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PushButton;

import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.datasources.graphics.EllipsoidGraphics;
import org.cesiumjs.cs.datasources.graphics.PolylineGraphics;
import org.cesiumjs.cs.datasources.graphics.options.EllipsoidGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.PolylineGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.datasources.properties.PolylineOutlineMaterialProperty;
import org.cesiumjs.cs.datasources.properties.options.PolylineOutlineMaterialPropertyOptions;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.options.Cesium3DTilesetOptions;
import org.cesiumjs.cs.scene.options.ViewOptions;
import org.cesiumjs.cs.widgets.Viewer;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

/**
 * @author Serge Silaev aka iSergio
 */
public class SampleHeightFrom3DTiles extends AbstractExample {
  private Viewer viewer;
  private Scene scene;

  @Inject
  public SampleHeightFrom3DTiles(ShowcaseExampleStore store) {
    super("Sample Height from 3D Tiles", "Sample the most detailed heights of a 3D Tileset.",
        new String[] { "Showcase", "3D", "Tiles", "Height", "Tileset" }, store);
  }

  @Override
  public void buildPanel() {
    ViewerOptions viewerOptions = new ViewerOptions();
    viewerOptions.terrainProvider = Cesium.createWorldTerrain();
    ViewerPanel csVPanel = new ViewerPanel(viewerOptions);
    viewer = csVPanel.getViewer();

    scene = viewer.scene();

    scene.primitives().add(new Cesium3DTileset(Cesium3DTilesetOptions.create(IonResource.fromAssetId(6074))));

    ViewOptions cameraViewOptions = new ViewOptions();
    cameraViewOptions.destinationPos = new Cartesian3(1216411.0748779264, -4736313.10747583, 4081359.5125561724);
    cameraViewOptions.orientation = new org.cesiumjs.cs.core.HeadingPitchRoll(4.239925103568368, -0.4911293834802475,
        6.279849292088564);
    cameraViewOptions.endTransform = Matrix4.IDENTITY();
    scene.camera().setView(cameraViewOptions);

    PushButton sampleHeightsBtn = new PushButton("Sample heights");
    sampleHeightsBtn.setText("Sample heights");
    sampleHeightsBtn.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent clickEvent) {
        sampleHeights();
      }
    });

    AbsolutePanel aPanel = new AbsolutePanel();
    aPanel.add(csVPanel);
    aPanel.add(sampleHeightsBtn, 20, 20);

    contentPanel.add(new HTML("<p>Sample the most detailed heights of a 3D Tileset.</p>"));
    contentPanel.add(aPanel);

    initWidget(contentPanel);
  }

  private void sampleHeights() {
    if (!scene.clampToHeightSupported()) {
      Cesium.log("This browser does not support clampToHeightMostDetailed.");
    }

    viewer.entities().removeAll();

    Cartesian3 cartesian1 = new Cartesian3(1216390.063324395, -4736314.814479433, 4081341.9787972216);
    Cartesian3 cartesian2 = new Cartesian3(1216329.5413318684, -4736272.029009798, 4081407.9342479417);

    final int count = 30;
    Cartesian3[] cartesians = new Cartesian3[count];
    for (int i = 0; i < count; ++i) {
      double offset = (double) i / (double) (count - 1);
      cartesians[i] = Cartesian3.lerp(cartesian1, cartesian2, offset, new Cartesian3());
    }

    scene.clampToHeightMostDetailed(cartesians).then(new Fulfill<Cartesian3[]>() {
      @Override
      public void onFulfilled(Cartesian3[] clampedCartesians) {
        for (int i = 0; i < count; ++i) {
          EllipsoidGraphicsOptions ellipsoidGraphicsOptions = new EllipsoidGraphicsOptions();
          ellipsoidGraphicsOptions.radii = new ConstantProperty<>(new Cartesian3(0.2, 0.2, 0.2));
          ellipsoidGraphicsOptions.material = new ColorMaterialProperty(Color.RED());

          EntityOptions entityOptions = new EntityOptions();
          entityOptions.position = new ConstantPositionProperty(clampedCartesians[i]);
          entityOptions.ellipsoid = new EllipsoidGraphics(ellipsoidGraphicsOptions);

          viewer.entities().add(entityOptions);
        }

        PolylineOutlineMaterialPropertyOptions polylineOutlineMaterialPropertyOptions = new PolylineOutlineMaterialPropertyOptions();
        polylineOutlineMaterialPropertyOptions.color = new ConstantProperty<>(Color.YELLOW());

        PolylineGraphicsOptions polylineGraphicsOptions = new PolylineGraphicsOptions();
        polylineGraphicsOptions.positions = new ConstantProperty<>(clampedCartesians);
        polylineGraphicsOptions.followSurface = new ConstantProperty<>(false);
        polylineGraphicsOptions.width = new ConstantProperty<>(2.0);
        polylineGraphicsOptions.material = new PolylineOutlineMaterialProperty(polylineOutlineMaterialPropertyOptions);
        polylineGraphicsOptions.depthFailMaterial = new ColorMaterialProperty(Color.YELLOW());

        EntityOptions entityOptions = new EntityOptions();
        entityOptions.polyline = new PolylineGraphics(polylineGraphicsOptions);

        viewer.entities().add(entityOptions);
      }
    });
  }

  @Override
  public String[] getSourceCodeURLs() {
    String[] sourceCodeURLs = new String[1];
    sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "SampleHeightFrom3DTiles.txt";
    return sourceCodeURLs;
  }
}