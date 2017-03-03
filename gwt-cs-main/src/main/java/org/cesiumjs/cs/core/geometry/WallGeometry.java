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

package org.cesiumjs.cs.core.geometry;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.geometry.options.WallGeometryOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "WallGeometry")
public class WallGeometry {
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public static double packedLength;
    
    /**
     * A description of a wall, which is similar to a KML line string. A wall is defined by a series of points,
     * which extrude down to the ground. Optionally, they can extrude downwards to a specified height.
     * @param options {@link WallGeometryOptions}
     */
    @JsConstructor
    public WallGeometry(WallGeometryOptions options) {}

    /**
     * Computes the geometric representation of a wall, including its vertices, indices, and a bounding sphere.
     * @param wallGeometry A description of the wall.
     * @return The computed vertices and indices.
     */
    @JsMethod
    public static native Geometry createGeometry(WallGeometry wallGeometry);

    /**
     * A description of a wall, which is similar to a KML line string. A wall is defined by a series of points,
     * which extrude down to the ground. Optionally, they can extrude downwards to a specified height.
     * @param options {@link WallGeometryOptions}
     * @return wall geometry
     * @see WallGeometry#createGeometry
     */
    @JsMethod
    public static native WallGeometry fromConstantHeights(WallGeometryOptions options);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(WallGeometry value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(WallGeometry value, double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new WallGeometry instance if one was not provided.
     */
    @JsMethod
    public static native WallGeometry unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @return The modified result parameter or a new WallGeometry instance if one was not provided.
     */
    @JsMethod
    public static native WallGeometry unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new WallGeometry instance if one was not provided.
     */
    @JsMethod
    public static native WallGeometry unpack(double[] array, int startingIndex, WallGeometry result);
}
