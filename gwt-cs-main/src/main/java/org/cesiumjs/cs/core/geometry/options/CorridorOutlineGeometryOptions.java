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
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Math;
import org.cesiumjs.cs.core.enums.CornerType;

/**
 * Options for {@link org.cesiumjs.cs.core.geometry.CorridorOutlineGeometry}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CorridorOutlineGeometryOptions {
    /**
     * An array of positions that define the center of the corridor.
     */
    @JsProperty
    public Cartesian3[] positions;
    /**
     * The distance between the edges of the corridor in meters.
     */
    @JsProperty
    public double width;
    /**
     * The ellipsoid to be used as a reference.
     * Default: {@link org.cesiumjs.cs.core.Ellipsoid#WGS84()}
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
     * Default: {@link Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public double granularity;
    /**
     * The distance in meters between the ellipsoid surface and the positions.
     * Default: 0
     */
    @JsProperty
    public double height;
    /**
     * The distance in meters between the ellipsoid surface and the extruded face.
     */
    @JsProperty
    public double extrudedHeight;
    /**
     * Determines the style of the corners.
     * Default: {@link CornerType#ROUNDED()}
     */
    @JsProperty
    public Number cornerType;

    @JsConstructor
    public CorridorOutlineGeometryOptions() {}
}
