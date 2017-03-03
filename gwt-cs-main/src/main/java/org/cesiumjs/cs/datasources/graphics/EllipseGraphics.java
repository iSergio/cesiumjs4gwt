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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOptional;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.datasources.graphics.options.EllipseGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "EllipseGraphics")
public class EllipseGraphics {
    /**
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "readonlydefinitionChanged")
    public native Event readonlydefinitionChanged();
    /**
     * The numeric Property specifying the semi-major axis.
     */
    @JsProperty
    public Property semiMajorAxis;
    /**
     * The numeric Property specifying the semi-minor axis.
     */
    @JsProperty
    public Property semiMinorAxis;
    /**
     * A numeric Property specifying the altitude of the ellipse relative to the ellipsoid surface.
     * Default: 0
     */
    @JsProperty
    public Property height;
    /**
     * A numeric Property specifying the altitude of the ellipse's extruded face relative to the ellipsoid surface.
     */
    @JsProperty
    public Property extrudedHeight;
    /**
     * A boolean Property specifying the visibility of the ellipse.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A boolean Property specifying whether the ellipse is filled with the provided material.
     * Default: true
     */
    @JsProperty
    public Property fill;
    /**
     * A Property specifying the material used to fill the ellipse.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public MaterialProperty materia;
    /**
     * A boolean Property specifying whether the ellipse is outlined.
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
     * A numeric Property specifying the number of vertical lines to draw along the perimeter for the outline.
     * Default: 16
     */
    @JsProperty
    public Property numberOfVerticalLines;
    /**
     * A numeric property specifying the rotation of the ellipse counter-clockwise from north.
     * Default: 0.0
     */
    @JsProperty
    public Property rotation;
    /**
     * A numeric property specifying the rotation of the ellipse texture counter-clockwise from north.
     * Default: 0.0
     */
    @JsProperty
    public Property stRotation;
    /**
     * A numeric Property specifying the angular distance between points on the ellipse.
     * Default: {@link Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public Property granularity;
    /**
     * An enum Property specifying whether the ellipse casts or receives shadows from each light source.
     * Default: {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public Property shadows;
    /**
     * A Property specifying at what distance from the camera that this ellipse will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;

    @JsConstructor
    public EllipseGraphics() {}

    @JsConstructor
    public EllipseGraphics(EllipseGraphicsOptions options) {}

    /**
     * Duplicates this instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    public native EllipseGraphics clone(@JsOptional EllipseGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    public native void merge(EllipseGraphics source);
}
