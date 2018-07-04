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

package org.cesiumjs.cs.datasources.graphics.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.datasources.properties.ConstantProperty;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class RectangleGraphicsOptions {
    /**
     * The Property specifying the Rectangle.
     */
    @JsProperty
    public Property coordinates;
    /**
     * A numeric Property specifying the altitude of the rectangle relative to the ellipsoid surface.
     * Default: 0
     */
    @JsProperty
    public Property height;
    /**
     * A Property specifying what the height is relative to.
     */
    @JsProperty
    public Property heightReference;
    /**
     * A numeric Property specifying the altitude of the rectangle's extruded face relative to the ellipsoid surface.
     */
    @JsProperty
    public Property extrudedHeight;
    /**
     * A Property specifying what the extrudedHeight is relative to.
     */
    @JsProperty
    public Property extrudedHeightReference;
    /**
     * A boolean Property specifying whether the rectangle has a top cover when extruded
     * Default: true
     */
    @JsProperty
    public Property closeTop;
    /**
     * A boolean Property specifying whether the rectangle has a bottom cover when extruded.
     * Default: true
     */
    @JsProperty
    public Property closeBottom;
    /**
     * A boolean Property specifying the visibility of the rectangle.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A boolean Property specifying whether the rectangle is filled with the provided material.
     * Default: true
     */
    @JsProperty
    public Property fill;
    /**
     * A Property specifying the material used to fill the rectangle.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}
     */
    @JsProperty
    public MaterialProperty material;
    /**
     * A boolean Property specifying whether the rectangle is outlined.
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
     * A numeric property specifying the rotation of the rectangle clockwise from north.
     * Default: 0.0
     */
    @JsProperty
    public Property rotation;
    /**
     * A numeric property specifying the rotation of the rectangle texture counter-clockwise from north.
     * Default: 0.0
     */
    @JsProperty
    public Property stRotation;
    /**
     * A numeric Property specifying the angular distance between points on the rectangle.
     * Default: {@link Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public Property granularity;
    /**
     * An enum Property specifying whether the rectangle casts or receives shadows from each light source.
     * Default: {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public Property shadows;
    /**
     * A Property specifying at what distance from the camera that this rectangle will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;
    /**
     * A Property specifying the zIndex used for ordering ground geometry. Only has an effect if the rectangle is
     * constant and neither height or extrudedHeight are specified.
     * Default: 0
     */
    @JsProperty
    public ConstantProperty<Integer> zIndex;

    @JsConstructor
    public RectangleGraphicsOptions() {}
}
