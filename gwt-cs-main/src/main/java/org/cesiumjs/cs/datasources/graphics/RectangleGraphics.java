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
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.datasources.graphics.options.RectangleGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "RectangleGraphics")
public class RectangleGraphics {
    /**
     * Gets or sets the boolean Property specifying whether the rectangle has a bottom cover when extruded.
     * Default: true
     */
    @JsProperty
    public Property closeBottom;
    /**
     * Gets or sets the boolean Property specifying whether the rectangle has a top cover when extruded.
     * Default: true
     */
    @JsProperty
    public Property closeTop;
    /**
     * Gets or sets the Property specifying the Rectangle.
     */
    @JsProperty
    public Property coordinates;

    /**
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();

    /**
     * Gets or sets the DistanceDisplayCondition Property specifying at what distance from the camera that this rectangle will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;
    /**
     * Gets or sets the numeric Property specifying the altitude of the rectangle extrusion.
     * Setting this property creates volume starting at height and ending at this altitude.
     */
    @JsProperty
    public Property extrudedHeight;
    /**
     * Gets or sets the boolean Property specifying whether the rectangle is filled with the provided material.
     * Default: true
     */
    @JsProperty
    public Property fill;

    /**
     * Gets or sets the numeric Property specifying the angular distance between points on the rectangle.
     * Default: {@link Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public Property granularity;
    /**
     * Gets or sets the numeric Property specifying the altitude of the rectangle.
     * Default: 0.0
     */
    @JsProperty
    public Property height;
    /**
     * Gets or sets the Property specifying the material used to fill the rectangle.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}
     */
    @JsProperty
    public MaterialProperty material;
    /**
     * Gets or sets the Property specifying whether the rectangle is outlined.
     * Default: false
     */
    @JsProperty
    public Property outline;
    /**
     * Gets or sets the Property specifying the Color of the outline.
     * Default: Color.BLACK
     */
    @JsProperty
    public Property outlineColor;
    /**
     * Gets or sets the numeric Property specifying the width of the outline.
     * Default: 1.0
     */
    @JsProperty
    public Property outlineWidth;
    /**
     * Gets or sets the numeric property specifying the rotation of the rectangle clockwise from north.
     * Default: 0
     */
    @JsProperty
    public Property rotation;
    /**
     * Get or sets the enum Property specifying whether the rectangle casts or receives shadows from each light source.
     * Default: {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public int shadows;
    /**
     * Gets or sets the boolean Property specifying the visibility of the rectangle.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * Gets or sets the numeric property specifying the rotation of the rectangle texture counter-clockwise from north.
     * Default: 0
     */
    @JsProperty
    public Property stRotation;

    /**
     * Describes graphics for a {@link org.cesiumjs.cs.core.Rectangle}. The rectangle conforms to the curvature of the globe and can be
     * placed on the surface or at altitude and can optionally be extruded into a volume.
     */
    @JsConstructor
    public RectangleGraphics() {
    }

    /**
     * Describes graphics for a {@link org.cesiumjs.cs.core.Rectangle}. The rectangle conforms to the curvature of the globe and can be
     * placed on the surface or at altitude and can optionally be extruded into a volume.
     *
     * @param options Options
     */
    @JsConstructor
    public RectangleGraphics(RectangleGraphicsOptions options) {
    }

    /**
     * Duplicates this instance.
     *
     * @return The modified result parameter or a new instance if one was not provided.
     */
    @JsMethod
    public native RectangleGraphics clone();

    /**
     * Duplicates this instance.
     *
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    @JsMethod
    public native RectangleGraphics clone(@JsOptional RectangleGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     *
     * @param source The object to be merged into this object.
     */
    @JsMethod
    public native void merge(RectangleGraphics source);
}