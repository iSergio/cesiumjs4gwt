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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.datasources.graphics.options.PolylineGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PolylineGraphics")
public class PolylineGraphics {
    /**
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * A Property specifying the array of Cartesian3 positions that define the line strip.
     */
    @JsProperty
    public Property positions;
    /**
     * A boolean Property specifying whether the line segments should be great arcs or linearly connected.
     * Default: true
     */
    @JsProperty
    public Property followSurface;
    /**
     * A numeric Property specifying the width in pixels.
     * Default: 1.0
     */
    @JsProperty
    public Property width;
    /**
     * A boolean Property specifying the visibility of the polyline.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A Property specifying the material used to draw the polyline.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}
     */
    @JsProperty
    public Property material;
    /**
     * Gets or sets the Property specifying the material used to draw the polyline when it fails the depth test.
     * Default: undefined.
     */
    @JsProperty
    private Property depthFailMaterial;
    /**
     * A numeric Property specifying the angular distance between each latitude and longitude if followSurface is true.
     * Default: {@link Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public Property granularity;
    /**
     * An enum Property specifying whether the polyline casts or receives shadows from each light source.
     * Default: {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public Property shadows;
    /**
     * A Property specifying at what distance from the camera that this polyline will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;

    /**
     * Describes a polyline defined as a line strip.
     * The first two positions define a line segment, and each additional position defines a line segment from
     * the previous position. The segments can be linear connected points or great arcs.
     */
    @JsConstructor
    public PolylineGraphics() {}

    /**
     * Describes a polyline defined as a line strip.
     * The first two positions define a line segment, and each additional position defines a line segment from
     * the previous position. The segments can be linear connected points or great arcs.
     * @param options Options
     */
    @JsConstructor
    public PolylineGraphics(PolylineGraphicsOptions options) {}

    /**
     * Duplicates this instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    public native PolylineGraphics clone(PolylineGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    public native void merge(PolylineGraphics source);
}
