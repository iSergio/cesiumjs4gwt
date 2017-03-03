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
import org.cesiumjs.cs.core.VertexFormat;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WallGeometryOptions {
    /**
     * An array of Cartesian objects, which are the points of the wall.
     */
    @JsProperty
    public Cartesian3[] positions;
    /**
     * The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
     * Default: {@link Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public double granularity;
    /**
     * An array parallel to positions that give the maximum height of the wall at positions. If undefined, the height of each position in used.
     */
    @JsProperty
    public double[] maximumHeights;
    /**
     * An array parallel to positions that give the minimum height of the wall at positions. If undefined, the height at each position is 0.0.
     */
    @JsProperty
    public double[] minimumHeights;
    /**
     * The ellipsoid for coordinate manipulation
     * Default: {@link org.cesiumjs.cs.core.Ellipsoid#WGS84()}
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The vertex attributes to be computed.
     * Default: {@link VertexFormat#DEFAULT()}
     */
    @JsProperty
    public VertexFormat vertexFormat;

    /**
     * Options for {@link org.cesiumjs.cs.core.geometry.WallGeometry}
     */
    @JsConstructor
    public WallGeometryOptions() {}
}
