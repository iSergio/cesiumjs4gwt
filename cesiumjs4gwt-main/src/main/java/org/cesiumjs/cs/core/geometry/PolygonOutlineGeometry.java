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
import org.cesiumjs.cs.core.geometry.options.PolygonOutlineGeometryOptions;

/**
 * A description of the outline of a polygon on the ellipsoid. The polygon is defined by a polygon hierarchy.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PolygonOutlineGeometry")
public class PolygonOutlineGeometry extends Geometry implements Packable {
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public int packedLength;

    @JsConstructor
    public PolygonOutlineGeometry(PolygonOutlineGeometryOptions options) {}

    /**
     * Computes the geometric representation of a polygon outline, including its vertices, indices, and a bounding sphere.
     * @param polygonGeometry A description of the polygon outline.
     * @return The computed vertices and indices.
     */
    @JsMethod
    public static native Geometry createGeometry(PolygonOutlineGeometry polygonGeometry);

    /**
     * A description of a polygon outline from an array of positions.
     * @param options {@link PolygonOutlineGeometryOptions}.
     * @return {@link PolygonOutlineGeometry}
     */
    @JsMethod
    public static native PolygonOutlineGeometry fromPositions(PolygonOutlineGeometryOptions options);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(PolygonOutlineGeometry value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(PolygonOutlineGeometry value, double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return polygon geometry
     */
    @JsMethod
    public static native PolygonOutlineGeometry unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @return polygon geometry
     */
    @JsMethod
    public static native PolygonOutlineGeometry unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @param result The object into which to store the result.
     * @return polygon geometry
     */
    @JsMethod
    public static native PolygonOutlineGeometry unpack(double[] array, int startingIndex, PolygonOutlineGeometry result);
}
