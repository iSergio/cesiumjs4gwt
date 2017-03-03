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
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Math;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SimplePolylineGeometryOptions {
    /**
     * An array of Cartesian3 defining the positions in the polyline as a line strip.
     */
    @JsProperty
    public Cartesian3[] positions;
    /**
     * An Array of Color defining the per vertex or per segment colors.
     */
    @JsProperty
    public Color[] colors;
    /**
     * A boolean that determines whether the colors will be flat across each segment of the line or interpolated across the vertices.
     * Default: false
     */
    @JsProperty
    public boolean colorsPerVertex;
    /**
     * A boolean that determines whether positions will be adjusted to the surface of the ellipsoid via a great arc.
     * Default: true
     */
    @JsProperty
    public boolean followSurface;
    /**
     * The distance, in radians, between each latitude and longitude if options.followSurface=true. Determines the number of positions in the buffer.
     * Default: {@link Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public double granularity;
    /**
     * The ellipsoid to be used as a reference.
     * Default: {@link org.cesiumjs.cs.core.Ellipsoid#WGS84()}
     */
    @JsProperty
    public Ellipsoid ellipsoid;

    /**
     * Options for {@link org.cesiumjs.cs.core.geometry.SimplePolylineGeometry}
     */
    @JsConstructor
    public SimplePolylineGeometryOptions() {}
}
