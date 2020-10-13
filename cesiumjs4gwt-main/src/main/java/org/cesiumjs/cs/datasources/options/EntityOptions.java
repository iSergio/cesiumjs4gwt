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

package org.cesiumjs.cs.datasources.options;

import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.BillboardGraphics;
import org.cesiumjs.cs.datasources.graphics.BoxGraphics;
import org.cesiumjs.cs.datasources.graphics.Cesium3DTilesetGraphics;
import org.cesiumjs.cs.datasources.graphics.CorridorGraphics;
import org.cesiumjs.cs.datasources.graphics.CylinderGraphics;
import org.cesiumjs.cs.datasources.graphics.EllipseGraphics;
import org.cesiumjs.cs.datasources.graphics.EllipsoidGraphics;
import org.cesiumjs.cs.datasources.graphics.LabelGraphics;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.datasources.graphics.PathGraphics;
import org.cesiumjs.cs.datasources.graphics.PlaneGraphics;
import org.cesiumjs.cs.datasources.graphics.PointGraphics;
import org.cesiumjs.cs.datasources.graphics.PolygonGraphics;
import org.cesiumjs.cs.datasources.graphics.PolylineGraphics;
import org.cesiumjs.cs.datasources.graphics.PolylineVolumeGraphics;
import org.cesiumjs.cs.datasources.graphics.RectangleGraphics;
import org.cesiumjs.cs.datasources.graphics.WallGraphics;
import org.cesiumjs.cs.datasources.properties.CallbackProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.js.JsObject;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class EntityOptions {
  /**
   * A unique identifier for this object. If none is provided, a GUID is
   * generated.
   */
  @JsProperty
  public String id;
  /**
   * A human readable name to display to users. It does not have to be unique.
   */
  @JsProperty
  public String name;
  /**
   * The availability, if any, associated with this object.
   */
  @JsProperty
  public TimeIntervalCollection availability;
  /**
   * A boolean value indicating if the entity and its children are displayed.
   */
  @JsProperty
  public boolean show;
  /**
   * A string Property specifying an HTML description for this entity.
   */
  @JsProperty
  public Property description;
  /**
   * A Property specifying the entity position.
   */
  @JsProperty
  public Property position;
  /**
   * Property for {@link CallbackProperty}.
   */
  @JsProperty(name = "position")
  public CallbackProperty<Cartesian3> positionCallback;
  /**
   * A Property specifying the entity orientation.
   */
  @JsProperty
  public Property orientation;
  /**
   * A suggested initial offset for viewing this object.
   */
  @JsProperty
  public Property viewFrom;
  /**
   * A parent entity to associate with this entity.
   */
  @JsProperty
  public Entity parent;
  /**
   * A billboard to associate with this entity.
   */
  @JsProperty
  public BillboardGraphics billboard;
  /**
   * A box to associate with this entity.
   */
  @JsProperty
  public BoxGraphics box;
  /**
   * A corridor to associate with this entity.
   */
  @JsProperty
  public CorridorGraphics corridor;
  /**
   * A cylinder to associate with this entity.
   */
  @JsProperty
  public CylinderGraphics cylinder;
  /**
   * A ellipse to associate with this entity.
   */
  @JsProperty
  public EllipseGraphics ellipse;
  /**
   * A ellipsoid to associate with this entity.
   */
  @JsProperty
  public EllipsoidGraphics ellipsoid;
  /**
   * A options.label to associate with this entity.
   */
  @JsProperty
  public LabelGraphics label;
  /**
   * A model to associate with this entity.
   */
  @JsProperty
  public ModelGraphics model;
  /**
   * A 3D Tiles tileset to associate with this entity.
   */
  @JsProperty
  public Cesium3DTilesetGraphics tileset;
  /**
   * A path to associate with this entity.
   */
  @JsProperty
  public PathGraphics path;
  /**
   * A plane to associate with this entity.
   */
  @JsProperty
  public PlaneGraphics plane;
  /**
   * A point to associate with this entity.
   */
  @JsProperty
  public PointGraphics point;
  /**
   * A polygon to associate with this entity.
   */
  @JsProperty
  public PolygonGraphics polygon;
  /**
   * A polyline to associate with this entity.
   */
  @JsProperty
  public PolylineGraphics polyline;
  /**
   * A polylineVolume to associate with this entity.
   */
  @JsProperty
  public PolylineVolumeGraphics polylineVolume;
  /**
   * A rectangle to associate with this entity.
   */
  @JsProperty
  public RectangleGraphics rectangle;
  /**
   * A wall to associate with this entity.
   */
  @JsProperty
  public WallGraphics wall;
  /**
   *
   */
  @JsProperty
  public JsObject properties;

  @JsConstructor
  public EntityOptions() {
  }
}
