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

package org.cesiumjs.cs.datasources.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.*;
import org.cesiumjs.cs.datasources.properties.PositionProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.js.JsObject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class EntityOptions {
    /**
     * A unique identifier for this object. If none is provided, a GUID is generated.
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
    public PositionProperty position;
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
     * A path to associate with this entity.
     */
    @JsProperty
    public PathGraphics path;
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
    public EntityOptions() {}
}
