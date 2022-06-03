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

package org.cesiumjs.cs.datasources.graphics;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.datasources.graphics.options.PolygonGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.ClassificationType;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PolygonGraphics")
public class PolygonGraphics {
    /**
     * Gets or sets the ClassificationType Property specifying whether this polygon
     * will classify terrain, 3D Tiles, or both when on the ground. Default:
     * {@link ClassificationType#TERRAIN()}.
     */
    @JsProperty
    public Number classificationType;
    /**
     * A Property specifying the PolygonHierarchy.
     */
    @JsProperty
    public Property hierarchy;
    /**
     * A numeric Property specifying the altitude of the polygon relative to the
     * ellipsoid surface. Default: 0
     */
    @JsProperty
    public Property height;
    /**
     * Gets or sets the Property specifying the HeightReference. Default:
     * {@link HeightReference#NONE()}
     */
    @JsProperty
    public Property heightReference;
    /**
     * A numeric Property specifying the altitude of the polygon's extruded face
     * relative to the ellipsoid surface.
     */
    @JsProperty
    public Property extrudedHeight;
    /**
     * Gets or sets the Property specifying the extruded HeightReference. Default:
     * {@link HeightReference#NONE()}
     */
    @JsProperty
    public Property extrudedHeightReference;
    /**
     * A boolean Property specifying the visibility of the polygon. Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A boolean Property specifying whether the polygon is filled with the provided
     * material. Default: true
     */
    @JsProperty
    public Property fill;
    /**
     * A Property specifying the material used to fill the polygon. Default:
     * {@link Color#WHITE()}
     */
    @JsProperty
    public MaterialProperty material;
    /**
     * A boolean Property specifying whether the polygon is outlined. Default: false
     */
    @JsProperty
    public Property outline;
    /**
     * A Property specifying the Color of the outline. Default:
     * {@link Color#BLACK()}
     */
    @JsProperty
    public Property outlineColor;
    /**
     * A numeric Property specifying the width of the outline. Default: 1.0
     */
    @JsProperty
    public Property outlineWidth;
    /**
     * A numeric property specifying the rotation of the polygon texture
     * counter-clockwise from north. Default: 0.0
     */
    @JsProperty
    public Property stRotation;
    /**
     * A Property specifying texture coordinates as a {@link org.cesiumjs.cs.core.PolygonHierarchy}
     * of {@link org.cesiumjs.cs.core.Cartesian2} points. Has no effect for ground primitives.
     */
    @JsProperty
    public Property textureCoordinates;
    /**
     * A numeric Property specifying the angular distance between each latitude and
     * longitude point. Default: {@link Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public Property granularity;
    /**
     * A boolean specifying whether or not the the height of each position is used.
     * Default: false
     */
    @JsProperty
    public Property perPositionHeight;
    /**
     * When false, leaves off the top of an extruded polygon open. Default: true
     */
    @JsProperty
    public boolean closeTop;
    /**
     * An enum Property specifying whether the polygon casts or receives shadows
     * from each light source. Default: {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public Property shadows;
    /**
     * A Property specifying at what distance from the camera that this polygon will
     * be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;
    /**
     * A property specifying the zIndex used for ordering ground geometry. Only has
     * an effect if the polygon is constant and neither height or extrudedHeight are
     * specified. Default: 0
     */
    @JsProperty
    public ConstantProperty<Integer> zIndex;
    /**
     * When false, leaves off the bottom of an extruded polygon open. Default: true
     */
    boolean closeBottom;

    /**
     * Describes a polygon defined by an hierarchy of linear rings which make up the
     * outer shape and any nested holes. The polygon conforms to the curvature of
     * the globe and can be placed on the surface or at altitude and can optionally
     * be extruded into a volume.
     *
     * @param options Options
     */
    @JsConstructor
    public PolygonGraphics(PolygonGraphicsOptions options) {
    }

    /**
     * Gets the event that is raised whenever a property or sub-property is changed
     * or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();

    /**
     * Duplicates this instance.
     *
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not
     * provided.
     */
    @JsMethod
    public native PolygonGraphics clone(@JsOptional PolygonGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same
     * property on the provided source object.
     *
     * @param source The object to be merged into this object.
     */
    @JsMethod
    public native void merge(PolygonGraphics source);
}
