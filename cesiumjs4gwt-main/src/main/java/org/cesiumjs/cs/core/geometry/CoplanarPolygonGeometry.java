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

package org.cesiumjs.cs.core.geometry;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Packable;
import org.cesiumjs.cs.core.geometry.options.CoplanarPolygonGeometryFromPositionsOptions;
import org.cesiumjs.cs.core.geometry.options.CoplanarPolygonGeometryOptions;

/**
 * A description of a polygon composed of arbitrary coplanar positions.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CoplanarPolygonGeometry")
public class CoplanarPolygonGeometry extends Geometry implements Packable {
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public int packedLength;

    @JsConstructor
    public CoplanarPolygonGeometry(CoplanarPolygonGeometryOptions options) {}

    /**
     * Computes the geometric representation of an arbitrary coplanar polygon, including its vertices, indices, and a bounding sphere.
     * @param polygonGeometry A description of the polygon.
     * @return The computed vertices and indices.
     */
    @JsMethod
    public static native Geometry createGeometry(CoplanarPolygonGeometry polygonGeometry);

    /**
     * A description of a coplanar polygon from an array of positions.
     * @param options {@link CoplanarPolygonGeometryFromPositionsOptions} object
     * @return geometry
     */
    @JsMethod
    public static native CoplanarPolygonGeometry fromPositions(CoplanarPolygonGeometryFromPositionsOptions options);
}
