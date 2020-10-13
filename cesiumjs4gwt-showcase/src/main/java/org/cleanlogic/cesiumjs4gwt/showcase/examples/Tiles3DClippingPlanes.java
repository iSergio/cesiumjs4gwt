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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.collections.ClippingPlaneCollection;
import org.cesiumjs.cs.collections.options.ClippingPlaneCollectionOptions;
import org.cesiumjs.cs.core.BoundingSphere;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.HeadingPitchRange;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.PickedObject;
import org.cesiumjs.cs.core.Plane;
import org.cesiumjs.cs.core.Quaternion;
import org.cesiumjs.cs.core.ScreenSpaceEventHandler;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.core.events.MouseDownEvent;
import org.cesiumjs.cs.core.events.MouseMoveEvent;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.PlaneGraphics;
import org.cesiumjs.cs.datasources.graphics.options.ModelGraphicsOptions;
import org.cesiumjs.cs.datasources.graphics.options.PlaneGraphicsOptions;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.CallbackProperty;
import org.cesiumjs.cs.datasources.properties.ColorMaterialProperty;
import org.cesiumjs.cs.datasources.properties.ConstantPositionProperty;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.ClippingPlane;
import org.cesiumjs.cs.scene.options.Cesium3DTilesetOptions;
import org.cesiumjs.cs.widgets.ViewerPanel;
import org.cesiumjs.cs.widgets.options.ViewerOptions;
import org.cleanlogic.cesiumjs4gwt.showcase.basic.AbstractExample;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;

/**
 * @author Serge Silaev aka iSergio
 */
public class Tiles3DClippingPlanes extends AbstractExample {
  private ViewerPanel csVPanel;
  private CheckBox boundingVolumeCBox;
  private CheckBox edgeStylingCBox;
  private double targetY = 0.0;
  private Plane scratchPlane = new Plane(Cartesian3.UNIT_X(), 0.0);
  private List<Entity> planeEntities = new ArrayList<>();
  private PlaneGraphics selectedPlane;
  private Cesium3DTileset tileset;
  private ClippingPlaneCollection modelEntityClippingPlanes;

  private Promise<IonResource, Void> bimUrl = IonResource.fromAssetId(3837);
  private Promise<IonResource, Void> pointCloudUrl = IonResource.fromAssetId(3838);
  private Promise<IonResource, Void> instancedUrl = IonResource.fromAssetId(3876);
  private String modelUrl = GWT.getModuleBaseURL() + "SampleData/models/CesiumAir/Cesium_Air.glb";

  @Inject
  public Tiles3DClippingPlanes(ShowcaseExampleStore store) {
    super("3D Tiles Clipping Planes",
        "User-defined clipping planes applied to a batched 3D Tileset, point cloud, and model.",
        new String[] { "Showcase", "3D Tiles", "Clipping" }, store);
  }

  @Override
  public void buildPanel() {
    ViewerOptions viewerOptions = new ViewerOptions();
    viewerOptions.skyAtmosphere = null;
    viewerOptions.infoBox = false;
    viewerOptions.selectionIndicator = false;
    csVPanel = new ViewerPanel(viewerOptions);

    ScreenSpaceEventHandler downHandler = new ScreenSpaceEventHandler(csVPanel.getViewer().canvas());
    downHandler.setInputAction(new ScreenSpaceEventHandler.Listener() {
      @Override
      public void function(Object event) {
        MouseDownEvent mouseDownEvent = (MouseDownEvent) event;
        PickedObject pickedObject = csVPanel.getViewer().scene().pick(mouseDownEvent.position);
        if (!Cesium.defined(pickedObject)) {
          return;
        }
        if (!(pickedObject.id instanceof Entity)) {
          return;
        }
        if (Cesium.defined(pickedObject) && Cesium.defined(pickedObject.id)
            && Cesium.defined(((Entity) pickedObject.id).plane)) {
          selectedPlane = ((Entity) pickedObject.id).plane;
          selectedPlane.material = new ColorMaterialProperty(Color.WHITE().withAlpha(0.05f));
          selectedPlane.outlineColor = new ConstantProperty<>(Color.WHITE());
          csVPanel.getViewer().scene().screenSpaceCameraController().enableInputs = false;
        }
      }
    }, ScreenSpaceEventType.LEFT_DOWN());

    ScreenSpaceEventHandler upHandler = new ScreenSpaceEventHandler(csVPanel.getViewer().canvas());
    upHandler.setInputAction(new ScreenSpaceEventHandler.Listener() {
      @Override
      public void function(Object event) {
        if (Cesium.defined(selectedPlane)) {
          selectedPlane.material = new ColorMaterialProperty(Color.WHITE().withAlpha(0.1f));
          selectedPlane.outlineColor = new ConstantProperty<>(Color.WHITE());
          selectedPlane = (PlaneGraphics) JsObject.undefined();
        }
        csVPanel.getViewer().scene().screenSpaceCameraController().enableInputs = true;
      }
    }, ScreenSpaceEventType.LEFT_UP());

    ScreenSpaceEventHandler moveHandler = new ScreenSpaceEventHandler(csVPanel.getViewer().scene().canvas());
    moveHandler.setInputAction(new ScreenSpaceEventHandler.Listener() {
      @Override
      public void function(Object event) {
        if (Cesium.defined(selectedPlane)) {
          MouseMoveEvent mouseMoveEvent = (MouseMoveEvent) event;
          double deltaY = mouseMoveEvent.startPosition.y - mouseMoveEvent.endPosition.y;
          targetY += deltaY;
        }
      }
    }, ScreenSpaceEventType.MOUSE_MOVE());

    ListBox clipObjectLBox = new ListBox();
    clipObjectLBox.addItem("BIM");
    clipObjectLBox.addItem("Point Cloud");
    clipObjectLBox.addItem("Instanced");
    clipObjectLBox.addItem("Model");
    clipObjectLBox.addChangeHandler(new ChangeHandler() {
      @Override
      public void onChange(ChangeEvent event) {
        reset();
        ListBox source = (ListBox) event.getSource();
        switch (source.getSelectedIndex()) {
          case 0:
            loadTileset(bimUrl);
            break;
          case 1:
            loadTileset(pointCloudUrl);
            tileset.readyPromise().then(new Fulfill<Cesium3DTileset>() {
              @Override
              public void onFulfilled(Cesium3DTileset value) {
                tileset.clippingPlanes.modelMatrix = Transforms
                    .eastNorthUpToFixedFrame(tileset.boundingSphere().center);
              }
            });
            break;
          case 2:
            loadTileset(instancedUrl);
            tileset.readyPromise().then(new Fulfill<Cesium3DTileset>() {
              @Override
              public void onFulfilled(Cesium3DTileset value) {
                tileset.clippingPlanes.modelMatrix = Transforms
                    .eastNorthUpToFixedFrame(tileset.boundingSphere().center);
              }
            });
            break;
          case 3:
            loadModel(modelUrl);
            break;
          default:
            break;
        }
      }
    });

    boundingVolumeCBox = new CheckBox("Show bounding volume");
    boundingVolumeCBox.setValue(false);
    boundingVolumeCBox.getElement().getStyle().setColor("white");
    boundingVolumeCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
      @Override
      public void onValueChange(ValueChangeEvent<Boolean> event) {
        if (Cesium.defined(tileset)) {
          tileset.debugShowBoundingVolume = event.getValue();
        }
      }
    });

    edgeStylingCBox = new CheckBox("Enable edge styling");
    edgeStylingCBox.setValue(true);
    edgeStylingCBox.getElement().getStyle().setColor("white");
    edgeStylingCBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
      @Override
      public void onValueChange(ValueChangeEvent<Boolean> event) {
        double edgeWidth = event.getValue() ? 1.0 : 0.0;

        if (Cesium.defined(tileset)) {
          tileset.clippingPlanes.edgeWidth = edgeWidth;
        }

        if (Cesium.defined(modelEntityClippingPlanes)) {
          modelEntityClippingPlanes.edgeWidth = edgeWidth;
        }
      }
    });

    AbsolutePanel aPanel = new AbsolutePanel();
    aPanel.add(csVPanel);
    aPanel.add(clipObjectLBox, 20, 20);
    aPanel.add(boundingVolumeCBox, 20, 50);
    aPanel.add(edgeStylingCBox, 20, 70);

    contentPanel
        .add(new HTML("<p>User-defined clipping planes applied to a batched 3D Tileset, point cloud, and model.</p>"));
    contentPanel.add(aPanel);

    initWidget(contentPanel);

    loadTileset(bimUrl);
  }

  @Override
  public String[] getSourceCodeURLs() {
    String[] sourceCodeURLs = new String[1];
    sourceCodeURLs[0] = GWT.getModuleBaseURL() + "examples/" + "Tiles3DClippingPlanes.txt";
    return sourceCodeURLs;
  }

  private void loadTileset(Promise<IonResource, Void> resource) {
    final ClippingPlane[] clippingPlanes = new ClippingPlane[] {
        new ClippingPlane(new Cartesian3(0.0, 0.0, -1.0), -100.0) };
    ClippingPlaneCollectionOptions clippingPlaneCollectionOptions = new ClippingPlaneCollectionOptions();
    clippingPlaneCollectionOptions.planes = clippingPlanes;
    clippingPlaneCollectionOptions.edgeWidth = edgeStylingCBox.getValue() ? 1.0 : 0.0;

    Cesium3DTilesetOptions tilesetOptions = Cesium3DTilesetOptions.create(resource);
    tilesetOptions.clippingPlanes = new ClippingPlaneCollection(clippingPlaneCollectionOptions);

    tileset = (Cesium3DTileset) csVPanel.getViewer().scene().primitives().add(new Cesium3DTileset(tilesetOptions));
    tileset.debugShowBoundingVolume = boundingVolumeCBox.getValue();
    tileset.readyPromise().then(new Fulfill<Cesium3DTileset>() {
      @Override
      public void onFulfilled(Cesium3DTileset value) {
        BoundingSphere boundingSphere = tileset.boundingSphere();
        double radius = boundingSphere.radius;

        csVPanel.getViewer().zoomTo(tileset, new HeadingPitchRange(0.5, -0.2, radius * 4.0));

        for (final ClippingPlane plane : clippingPlanes) {
          PlaneGraphicsOptions planeGraphicsOptions = new PlaneGraphicsOptions();
          planeGraphicsOptions.dimensions = new ConstantProperty<>(new Cartesian2(radius * 2.5, radius * 2.5));
          planeGraphicsOptions.material = new ColorMaterialProperty(Color.WHITE().withAlpha(0.1f));
          planeGraphicsOptions.plane = new CallbackProperty(new CallbackProperty.Callback() {
            @Override
            public Object function(JulianDate time, Object result) {
              plane.distance = targetY;
              return ClippingPlane.transform(plane, tileset.modelMatrix, scratchPlane);
            }
          }, false);
          planeGraphicsOptions.outline = new ConstantProperty<>(true);
          planeGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());

          EntityOptions entityOptions = new EntityOptions();
          entityOptions.position = new ConstantPositionProperty(boundingSphere.center);
          entityOptions.plane = new PlaneGraphics(planeGraphicsOptions);
          planeEntities.add(csVPanel.getViewer().entities().add(entityOptions));
        }
      }
    });
  }

  private void loadModel(String url) {
    ClippingPlane[] clippingPlanes = new ClippingPlane[] { new ClippingPlane(new Cartesian3(0.0, 0.0, -1.0), -100.0) };

    ClippingPlaneCollectionOptions clippingPlaneCollectionOptions = new ClippingPlaneCollectionOptions();
    clippingPlaneCollectionOptions.planes = clippingPlanes;
    clippingPlaneCollectionOptions.edgeWidth = edgeStylingCBox.getValue() ? 1.0 : 0.0;

    modelEntityClippingPlanes = new ClippingPlaneCollection(clippingPlaneCollectionOptions);

    Cartesian3 position = Cartesian3.fromDegrees(-123.0744619, 44.0503706, 100.0);
    double heading = Math.toRadians(135.0);
    double pitch = 0.0;
    double roll = 0.0;
    HeadingPitchRoll hpr = new HeadingPitchRoll(heading, pitch, roll);
    Quaternion orientation = Transforms.headingPitchRollQuaternion(position, hpr);
    ModelGraphicsOptions modelGraphicsOptions = new ModelGraphicsOptions();
    modelGraphicsOptions.uri = new ConstantProperty<>(url);
    modelGraphicsOptions.scale = new ConstantProperty<>(8.0);
    modelGraphicsOptions.minimumPixelSize = new ConstantProperty<>(100.0);
    modelGraphicsOptions.clippingPlanes = new CallbackProperty(new CallbackProperty.Callback() {
      @Override
      public Object function(JulianDate time, Object result) {
        return modelEntityClippingPlanes;
      }
    }, false);

    EntityOptions entityOptions = new EntityOptions();
    entityOptions.name = url;
    entityOptions.position = new ConstantPositionProperty(position);
    entityOptions.orientation = new ConstantProperty<>(orientation);
    entityOptions.model = new ModelGraphics(modelGraphicsOptions);
    csVPanel.getViewer().trackedEntity = csVPanel.getViewer().entities().add(entityOptions);

    for (final ClippingPlane clippingPlane : clippingPlanes) {
      PlaneGraphicsOptions planeGraphicsOptions = new PlaneGraphicsOptions();
      planeGraphicsOptions.dimensions = new ConstantProperty<>(new Cartesian2(300.0, 300.0));
      planeGraphicsOptions.material = new ColorMaterialProperty(Color.WHITE().withAlpha(0.1f));
      planeGraphicsOptions.plane = new CallbackProperty(new CallbackProperty.Callback() {
        @Override
        public Object function(JulianDate time, Object result) {
          clippingPlane.distance = targetY;
          return ClippingPlane.transform(clippingPlane, Matrix4.IDENTITY(), scratchPlane);
        }
      }, false);
      planeGraphicsOptions.outline = new ConstantProperty<>(true);
      planeGraphicsOptions.outlineColor = new ConstantProperty<>(Color.WHITE());

      EntityOptions planeEntityOptions = new EntityOptions();
      planeEntityOptions.position = new ConstantPositionProperty(position);
      planeEntityOptions.plane = new PlaneGraphics(planeGraphicsOptions);

      planeEntities.add(csVPanel.getViewer().entities().add(planeEntityOptions));
    }
  }

  private void reset() {
    csVPanel.getViewer().entities().removeAll();
    csVPanel.getViewer().scene().primitives().remove(tileset);
    planeEntities.clear();
    targetY = 0.0;
    tileset = (Cesium3DTileset) JsObject.undefined();
  }
}
