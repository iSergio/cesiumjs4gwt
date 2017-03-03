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

package org.cesiumjs.cs.datasources.graphics;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.datasources.graphics.options.WallGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "WallGraphics")
public class WallGraphics {
    /**
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * A Property specifying the array of Cartesian3 positions which define the top of the wall.
     */
    @JsProperty
    public Property positions;
    /**
     * A Property specifying an array of heights to be used for the top of the wall instead of the height of each position.
     */
    @JsProperty
    public Property maximumHeights;
    /**
     * A Property specifying an array of heights to be used for the bottom of the wall instead of the globe surface.
     */
    @JsProperty
    public Property minimumHeights;
    /**
     * A boolean Property specifying the visibility of the wall.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A boolean Property specifying whether the wall is filled with the provided material.
     * Default: true
     */
    @JsProperty
    public Property fill;
    /**
     * A Property specifying the material used to fill the wall.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}
     */
    @JsProperty
    public MaterialProperty material;
    /**
     * A boolean Property specifying whether the wall is outlined.
     * Default: false
     */
    @JsProperty
    public Property outline;
    /**
     * A Property specifying the Color of the outline.
     * Default: {@link Color#BLACK()}
     */
    @JsProperty
    public Property outlineColor;
    /**
     * A numeric Property specifying the width of the outline.
     * Default: 1.0
     */
    @JsProperty
    public Property outlineWidth;
    /**
     * A numeric Property specifying the angular distance between each latitude and longitude point.
     * Default: {@link Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public Property granularity;
    /**
     * An enum Property specifying whether the wall casts or receives shadows from each light source.
     * Default: {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public Property shadows;
    /**
     * A Property specifying at what distance from the camera that this wall will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;

    /**
     * Describes a two dimensional wall defined as a line strip and optional maximum and minimum heights.
     * The wall conforms to the curvature of the globe and can be placed along the surface or at altitude.
     */
    @JsConstructor
    public WallGraphics() {}

    /**
     * Describes a two dimensional wall defined as a line strip and optional maximum and minimum heights.
     * The wall conforms to the curvature of the globe and can be placed along the surface or at altitude.
     * @param options Options
     */
    @JsConstructor
    public WallGraphics(WallGraphicsOptions options) {}

    /**
     * Duplicates this instance.
     *
     * @return The modified result parameter or a new instance if one was not provided.
     */
    @JsMethod
    public native WallGraphics clone();

    /**
     * Duplicates this instance.
     *
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    @JsMethod
    public native WallGraphics clone(@JsOptional WallGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     *
     * @param source The object to be merged into this object.
     */
    @JsMethod
    public native void merge(WallGraphics source);
}
