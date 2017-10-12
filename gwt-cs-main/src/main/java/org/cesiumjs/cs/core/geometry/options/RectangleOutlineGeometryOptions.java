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

package org.cesiumjs.cs.core.geometry.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Rectangle;

/**
 * Options for {@link org.cesiumjs.cs.core.geometry.RectangleOutlineGeometry}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class RectangleOutlineGeometryOptions {
    /**
     * A cartographic rectangle with north, south, east and west properties in radians.
     */
    @JsProperty
    public Rectangle rectangle;
    /**
     * The ellipsoid on which the rectangle lies.
     * Default: {@link Ellipsoid#WGS84()}
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
     * Default: {@link org.cesiumjs.cs.core.Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public double granularity;
    /**
     * The distance in meters between the rectangle and the ellipsoid surface.
     * Default: 0.0
     */
    @JsProperty
    public double height;
    /**
     * The rotation of the rectangle, in radians. A positive rotation is counter-clockwise.
     * Default: 0.0
     */
    @JsProperty
    public double rotation;
    /**
     * The distance in meters between the rectangle's extruded face and the ellipsoid surface.
     */
    @JsProperty
    public double extrudedHeight;

    /**
     * Options for {@link org.cesiumjs.cs.core.geometry.RectangleOutlineGeometry}
     */
    @JsConstructor
    public RectangleOutlineGeometryOptions() {}
}
