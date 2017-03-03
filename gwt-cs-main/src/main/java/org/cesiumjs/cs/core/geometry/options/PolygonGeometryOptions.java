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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.Math;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Object")
public class PolygonGeometryOptions {
    /**
     * An array of positions that defined the corner points of the polygon.
     * Used only in {@link org.cesiumjs.cs.core.geometry.PolygonGeometry#fromPositions(PolygonGeometryOptions)};
     */
    @JsProperty
    public Cartesian3[] positions;
    /**
     * A polygon hierarchy that can include holes.
     */
    @JsProperty
    public PolygonHierarchy polygonHierarchy;
    /**
     * The distance in meters between the polygon and the ellipsoid surface.
     * Default: 0.0
     */
    @JsProperty
    public double height;
    /**
     * The distance in meters between the polygon's extruded face and the ellipsoid surface.
     */
    @JsProperty
    public double extrudedHeight;
    /**
     * The vertex attributes to be computed.
     * Default: VertexFormat#DEFAULT()
     */
    @JsProperty
    public VertexFormat vertexFormat;
    /**
     * The rotation of the texture coordinates, in radians. A positive rotation is counter-clockwise.
     * Default: 0.0
     */
    @JsProperty
    public double stRotation;
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
     * Use the height of options.positions for each position instead of using options.height to determine the height.
     * Default: false
     */
    @JsProperty
    public boolean perPositionHeight;
    /**
     * When false, leaves off the top of an extruded polygon open.
     * Default: true
     */
    @JsProperty
    public boolean closeTop;
    /**
     * When false, leaves off the bottom of an extruded polygon open.
     * Default: true
     */
    @JsProperty
    public boolean closeBottom;

    /**
     * Options for {@link org.cesiumjs.cs.core.geometry.PolygonGeometry}
     */
    @JsConstructor
    public PolygonGeometryOptions() {}
}
