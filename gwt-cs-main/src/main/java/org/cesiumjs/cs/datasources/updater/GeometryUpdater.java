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

package org.cesiumjs.cs.datasources.updater;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.PrimitiveCollection;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.apperances.Appearance;

/**
 * Defines the interface for a geometry updater. A GeometryUpdater maps geometry
 * defined as part of a {@link Entity} into {@link org.cesiumjs.cs.core.geometry.Geometry} instances.
 * These instances are then visualized by GeometryVisualizer. This type defines an interface and cannot
 * be instantiated directly.
 *
 * @see EllipseGeometryUpdater
 * @see EllipsoidGeometryUpdater
 * @see PolygonGeometryUpdater
 * @see PolylineGeometryUpdater
 * @see RectangleGeometryUpdater
 * @see WallGeometryUpdater
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "GeometryUpdater")
public abstract class GeometryUpdater {
    /**
     * Gets the type of Appearance to use for material-based geometry.
     */
    @JsProperty
    public static Appearance materialAppearanceType;
    /**
     * Gets the type of Appearance to use for simple color-based geometry.
     */
    @JsProperty
    public static Appearance perInstanceColorAppearanceType;
    /**
     * Gets or sets the DistanceDisplayCondition Property specifying at what distance from the camera that this geometry will be displayed.
     */
    @JsProperty(name = "distanceDisplayConditionProperty")
    public native Property distanceDisplayConditionProperty();
    /**
     * Gets the entity associated with this geometry.
     */
    @JsProperty(name = "entity")
    public native Entity entity();
    /**
     * Gets a value indicating if the geometry has a fill component.
     */
    @JsProperty(name = "fillEnabled")
    public native boolean fillEnabled();
    /**
     * Gets the material property used to fill the geometry.
     */
    @JsProperty(name = "fillMaterialProperty")
    public native MaterialProperty fillMaterialProperty();
    /**
     * Gets an event that is raised whenever the public properties of this updater change.
     */
    @JsProperty(name = "geometryChanged")
    public native boolean geometryChanged();
    /**
     * Gets a value indicating if fill visibility varies with simulation time.
     */
    @JsProperty(name = "hasConstantFill")
    public native boolean hasConstantFill();
    /**
     * Gets a value indicating if the geometry has an outline component.
     */
    @JsProperty(name = "hasConstantOutline")
    public native boolean hasConstantOutline();
    /**
     * Gets a value indicating if the geometry is closed. This property is only valid for static geometry.
     */
    @JsProperty(name = "isClosed")
    public native boolean isClosed();
    /**
     * Gets a value indicating if the geometry is time-varying. If true, all visualization is delegated to the
     * DynamicGeometryUpdater returned by GeometryUpdater#createDynamicUpdater.
     */
    @JsProperty(name = "isDynamic")
    public native boolean isDynamic();
    /**
     * Gets the Color property for the geometry outline.
     */
    @JsProperty(name = "outlineColorProperty")
    public native Property outlineColorProperty();
    /**
     * Gets a value indicating if the geometry has an outline component.
     */
    @JsProperty(name = "outlineEnabled")
    public native boolean outlineEnabled();
    /**
     * Gets the constant with of the geometry outline, in pixels. This value is only valid if isDynamic is false.
     */
    @JsProperty(name = "outlineWidth")
    public native double outlineWidth();

    @JsConstructor
    private GeometryUpdater() {}

    @JsConstructor
    public GeometryUpdater(Entity entity, Scene scene) {}

    /**
     * Creates the dynamic updater to be used when {@link GeometryUpdater#isDynamic} is true.
     * @param primitives The primitive collection to use.
     * @return The dynamic updater used to update the geometry each frame.
     */
    @JsMethod
    public native DynamicGeometryUpdater createDynamicUpdater(PrimitiveCollection primitives);

    /**
     * Creates the geometry instance which represents the fill of the geometry.
     * @param time The time to use when retrieving initial attribute values.
     * @return The geometry instance representing the filled portion of the geometry.
     */
    @JsMethod
    public native GeometryInstance createFillGeometryInstance(JulianDate time);

    /**
     * Creates the geometry instance which represents the outline of the geometry.
     * @param time The time to use when retrieving initial attribute values.
     * @return The geometry instance representing the outline portion of the geometry.
     */
    @JsMethod
    public native GeometryInstance createOutlineGeometryInstance(JulianDate time);

    /**
     * Destroys and resources used by the object. Once an object is destroyed, it should not be used.
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     * @return True if this object was destroyed; otherwise, false.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Checks if the geometry is filled at the provided time.
     * @param time The time for which to retrieve visibility.
     * @return true if geometry is filled at the provided time, false otherwise.
     */
    @JsMethod
    public native boolean isFilled(JulianDate time);

    /**
     * Checks if the geometry is outlined at the provided time.
     * @param time The time for which to retrieve visibility.
     * @return true if geometry is outlined at the provided time, false otherwise.
     */
    @JsMethod
    public native boolean isOutlineVisible(JulianDate time);
}
