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

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;

import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Cartographic;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.LabelGraphics;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.PointGraphics;
import org.cesiumjs.cs.datasources.graphics.options.LabelGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.PointGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.CallbackProperty;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

/**
 * @author Serge Silaev aka iSergio
 */
public class Clampto3DModel extends AbstractExample {
  private ViewerPanel csVPanel;

  private double longitude = -2.1480545852753163;
  private double latitude = 0.7688240036937101;
  private double range = 0.000002;
  private double duration = 4.0;
  private Cartographic cartographic = new Cartographic();
  private JsObject[] objectsToExclude;
  private Entity point;

  @Inject
  public Clampto3DModel(ShowcaseExampleStore store) {
    super("Clamp to 3D Model", "Clamp a point and label to a model using the sampleHeight function.",
        new String[] { "Clamp", "Point", "Label", "3DModel" }, store);
  }

  @Override
  public void buildPanel() {
    ViewerOptions viewerOptions = new ViewerOptions();
    viewerOptions.infoBox = false;
    viewerOptions.selectionIndicator = false;
    viewerOptions.shadows = true;
    viewerOptions.shouldAnimate = true;
    csVPanel = new ViewerPanel(viewerOptions);

    csVPanel.getViewer().scene().globe.depthTestAgainstTerrain = true;

    if (!csVPanel.getViewer().scene().sampleHeightSupported()) {
      Cesium.log("This browser does not support sampleHeight.");
    }

    ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
    modelGraphicsOptions.uri = new ConstantProperty<>(
        GWT.getModuleBaseURL() + "SampleData/models/GroundVehicle/GroundVehicle.glb");

    EntityOptions entityOptions = new EntityOptions();
    entityOptions.position = new ConstantPositionProperty(Cartesian3.fromRadians(longitude, latitude));
    entityOptions.model = new ModelGraphics(modelGraphicsOptions);

    Entity entity = csVPanel.getViewer().entities().add(entityOptions);

    PointGraphicsOptions pointGraphicsOptions = new PointGraphicsOptions();
    pointGraphicsOptions.pixelSize = new ConstantProperty<>(10);
    pointGraphicsOptions.color = new ConstantProperty<>(Color.YELLOW());
    pointGraphicsOptions.disableDepthTestDistance = new ConstantProperty<>(Double.POSITIVE_INFINITY);

    LabelGraphicsOptions labelGraphicsOptions = new LabelGraphicsOptions();
    labelGraphicsOptions.show = new ConstantProperty<>(false);
    labelGraphicsOptions.showBackground = new ConstantProperty<>(true);
    labelGraphicsOptions.font = new ConstantProperty<>("14px monospace");
    labelGraphicsOptions.horizontalOrigin = new ConstantProperty<>(HorizontalOrigin.LEFT());
    labelGraphicsOptions.verticalOrigin = new ConstantProperty<>(VerticalOrigin.BOTTOM());
    labelGraphicsOptions.pixelOffset = new ConstantProperty<>(new Cartesian2(5, 5));
    labelGraphicsOptions.disableDepthTestDistance = new ConstantProperty<>(Double.POSITIVE_INFINITY);

    entityOptions = new EntityOptions();
    entityOptions.positionCallback = new CallbackProperty<>(new CallbackProperty.Callback<Cartesian3>() {
      @Override
      public Cartesian3 function(JulianDate time, Cartesian3 result) {
        return updatePosition(time, result);
      }
    }, false);
    entityOptions.point = new PointGraphics(pointGraphicsOptions);
    entityOptions.label = new LabelGraphics(labelGraphicsOptions);

    point = new Entity(entityOptions);
    csVPanel.getViewer().entities().add(point);

    objectsToExclude = new JsObject[] { (JsObject) (Object) point };

    csVPanel.getViewer().trackedEntity = entity;

    contentPanel.add(new HTML("<p>Clamp a point and label to a model using the sampleHeight function.</p>"));
    contentPanel.add(csVPanel);

    initWidget(contentPanel);
  }

  Cartesian3 updatePosition(JulianDate time, Cartesian3 result) {
    double offset = (time.secondsOfDay % duration) / duration;
    cartographic.longitude = longitude - range + offset * range * 2.0;
    cartographic.latitude = latitude;

    double height = 0.0;

    if (csVPanel.getViewer().scene().sampleHeightSupported()) {
      height = csVPanel.getViewer().scene().sampleHeight(cartographic, objectsToExclude);
    }

    if (Cesium.defined(height)) {
      cartographic.height = height;
      point.label.text = new ConstantProperty<>(NumberFormat.getFormat("#.##").format(Math.abs(height)) + " m");
      point.label.show = new ConstantProperty<>(true);
    } else {
      cartographic.height = 0.0;
      point.label.show = new ConstantProperty<>(false);
    }

    return Cartographic.toCartesian(cartographic, Ellipsoid.WGS84(), result);
  }

  @Override
  public String[] getSourceCodeURLs() {
    String[] sourceCodeURLs = new String[1];
    sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Clampto3DModel.txt";
    return sourceCodeURLs;
  }
}
