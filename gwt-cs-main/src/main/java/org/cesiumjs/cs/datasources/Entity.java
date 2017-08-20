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

package org.cesiumjs.cs.datasources;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.EntityCollection;
import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.datasources.graphics.*;
import org.cesiumjs.cs.datasources.options.EntityOptions;
import org.cesiumjs.cs.datasources.properties.PositionProperty;
import org.cesiumjs.cs.datasources.properties.Property;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Entity")
public class Entity {
    /**
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * Gets or sets the entity collection that this entity belongs to.
     */
    @JsProperty
    public EntityCollection entityCollection;
    /**
     * Gets whether this entity is being displayed, taking into account the visibility of any ancestor entities.
     */
    @JsProperty
    public boolean isShowing;
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
     * Gets the names of all properties registered on this instance.
     */
    @JsProperty
    public String[] propertyNames;
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
//    /**
//     *
//     */
//    @JsProperty
//    public JsObject properties;

    /**
     * Entity instances aggregate multiple forms of visualization into a single high-level object.
     * They can be created manually and added to Viewer#entities or be produced by data sources, such as CzmlDataSource and GeoJsonDataSource.
     */
    @JsConstructor
    public Entity() {}

    /**
     * Entity instances aggregate multiple forms of visualization into a single high-level object.
     * They can be created manually and added to Viewer#entities or be produced by data sources, such as CzmlDataSource and GeoJsonDataSource.
     * @param options {@link EntityOptions}
     */
    @JsConstructor
    public Entity(EntityOptions options) {}

    /**
     * Adds a property to this object. Once a property is added, it can be observed with {@link #definitionChanged()} and
     * composited with {@link CompositeEntityCollection}
     * @param propertyName The name of the property to add.
     */
    @JsMethod
    public native void addProperty(String propertyName);

    /**
     * Computes the model matrix for the entity's transform at specified time. Returns undefined if orientation or position are undefined.
     * @param time The time to retrieve model matrix for.
     * @return The modified result parameter or a new Matrix4 instance if one was not provided. Result is undefined
     * if position or orientation are undefined.
     */
    @JsMethod
    public native Matrix4 computeModelMatrix(JulianDate time);

    /**
     * Computes the model matrix for the entity's transform at specified time. Returns undefined if orientation or position are undefined.
     * @param time The time to retrieve model matrix for.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix4 instance if one was not provided. Result is undefined
     * if position or orientation are undefined.
     */
    @JsMethod
    public native Matrix4 computeModelMatrix(JulianDate time, Matrix4 result);

    /**
     * Given a time, returns true if this object should have data during that time.
     * @param time The time to check availability for.
     * @return true if the object should have data during the provided time, false otherwise.
     */
    @JsMethod
    public native boolean isAvailable(JulianDate time);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    @JsMethod
    public native void merge(Entity source);

    /**
     * Removed a property previously added with addProperty.
     * @param propertyName The name of the property to remove.
     */
    @JsMethod
    public native void removeProperty(String propertyName);
}
