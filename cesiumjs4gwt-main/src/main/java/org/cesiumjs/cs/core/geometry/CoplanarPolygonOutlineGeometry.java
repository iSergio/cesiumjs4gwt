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
import org.cesiumjs.cs.core.geometry.options.CoplanarPolygonOutlineGeometryFromPositionsOptions;
import org.cesiumjs.cs.core.geometry.options.CoplanarPolygonOutlineGeometryOptions;

/**
 * A description of the outline of a polygon composed of arbitrary coplanar
 * positions.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "CoplanarPolygonOutlineGeometry")
public class CoplanarPolygonOutlineGeometry extends Geometry implements Packable {
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public int packedLength;

    @JsConstructor
    private CoplanarPolygonOutlineGeometry() {
    }

    @JsConstructor
    public CoplanarPolygonOutlineGeometry(CoplanarPolygonOutlineGeometryOptions options) {
    }

    /**
     * Computes the geometric representation of an arbitrary coplanar polygon,
     * including its vertices, indices, and a bounding sphere.
     *
     * @param polygonGeometry A description of the polygon.
     * @return The computed vertices and indices.
     */
    @JsMethod
    public static native Geometry createGeometry(CoplanarPolygonOutlineGeometry polygonGeometry);

    /**
     * A description of a coplanar polygon outline from an array of positions.
     *
     * @param options {@link CoplanarPolygonOutlineGeometryFromPositionsOptions}
     *                object.
     * @return coplanar polygon outline from an array of positions.
     */
    @JsMethod
    public static native CoplanarPolygonOutlineGeometry fromPositions(
            CoplanarPolygonOutlineGeometryFromPositionsOptions options);
}
