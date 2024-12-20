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
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Packable;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.geometry.options.PolygonGeometryOptions;

/**
 * @author Serge Silaev aka iSergio
 */
// TODO: Examples
@JsType(isNative = true, namespace = "Cesium", name = "PolygonGeometry")
public class PolygonGeometry extends Geometry implements Packable {
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public int packedLength;

    @JsConstructor
    public PolygonGeometry(PolygonGeometryOptions options) {
    }

    /**
     * Computes a rectangle which encloses the polygon defined by the list of positions, including cases over the international date line and the poles.
     * @param positions A linear ring defining the outer boundary of the polygon.
     * @return The result rectangle
     */
    @JsMethod
    public static native Rectangle computeRectangleFromPositions(Cartesian3[] positions);

    /**
     * Computes a rectangle which encloses the polygon defined by the list of positions, including cases over the international date line and the poles.
     * @param positions A linear ring defining the outer boundary of the polygon.
     * @param ellipsoid The ellipsoid to be used as a reference.
     * @return The result rectangle
     */
    @JsMethod
    public static native Rectangle computeRectangleFromPositions(Cartesian3[] positions, Ellipsoid ellipsoid);

    /**
     * Computes a rectangle which encloses the polygon defined by the list of positions, including cases over the international date line and the poles.
     * @param positions A linear ring defining the outer boundary of the polygon.
     * @param ellipsoid The ellipsoid to be used as a reference.
     * @param arcType The type of line the polygon edges must follow. Valid options are ArcType.GEODESIC and ArcType.RHUMB.
     * @return The result rectangle
     */
    @JsMethod
    public static native Rectangle computeRectangleFromPositions(Cartesian3[] positions, Ellipsoid ellipsoid, Number arcType);

    /**
     * Computes a rectangle which encloses the polygon defined by the list of positions, including cases over the international date line and the poles.
     * @param positions A linear ring defining the outer boundary of the polygon.
     * @param ellipsoid The ellipsoid to be used as a reference.
     * @param arcType The type of line the polygon edges must follow. Valid options are ArcType.GEODESIC and ArcType.RHUMB.
     * @param result An object in which to store the result.
     * @return The result rectangle
     */
    @JsMethod
    public static native Rectangle computeRectangleFromPositions(Cartesian3[] positions, Ellipsoid ellipsoid, Number arcType, Rectangle result);

    /**
     * Computes the geometric representation of a polygon, including its vertices,
     * indices, and a bounding sphere.
     *
     * @param polygonGeometry A description of the polygon.
     * @return The computed vertices and indices.
     */
    @JsMethod
    public static native Geometry createGeometry(PolygonGeometry polygonGeometry);

    /**
     * A description of a polygon from an array of positions. Polygon geometry can
     * be rendered with both Primitive and GroundPrimitive.
     *
     * @param options {@link PolygonGeometryOptions}
     * @return polygon geometry
     */
    @JsMethod
    public static native PolygonGeometry fromPositions(PolygonGeometryOptions options);

    /**
     * Stores the provided instance into the provided array.
     *
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(PolygonGeometry value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     *
     * @param value         The value to pack.
     * @param array         The array to pack into.
     * @param startingIndex The index into the array at which to start packing the
     *                      elements.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(PolygonGeometry value, double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     *
     * @param array The packed array.
     * @return polygon geometry
     */
    @JsMethod
    public static native PolygonGeometry unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     *
     * @param array         The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @return polygon geometry
     */
    @JsMethod
    public static native PolygonGeometry unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     *
     * @param array         The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @param result        The object into which to store the result.
     * @return polygon geometry
     */
    @JsMethod
    public static native PolygonGeometry unpack(double[] array, int startingIndex, PolygonGeometry result);
}
