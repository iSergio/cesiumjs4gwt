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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "NearFarScalar")
public class NearFarScalar {
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty(name = "packedLength")
    public static native int packedLength();
    /**
     * The upper bound of the camera range.
     * Default: 1.0
     */
    @JsProperty
    public Number far;
    /**
     * The value at the upper bound of the camera range.
     * Default: 0.0
     */
    @JsProperty
    public Number farValue;
    /**
     * The lower bound of the camera range.
     * Default: 0.0
     */
    @JsProperty
    public Number near;
    /**
     * The value at the lower bound of the camera range.
     * Default: 0.0
     */
    @JsProperty
    public Number nearValue;

    /**
     * Represents a scalar value's lower and upper bound at a near distance and far distance in eye space.
     * @see Packable
     */
    @JsConstructor
    public NearFarScalar() {}

    /**
     * Represents a scalar value's lower and upper bound at a near distance and far distance in eye space.
     * @param near The lower bound of the camera range. Default: 0.0.
     * @param nearValue The value at the lower bound of the camera range. Default: 0.0.
     * @param far The upper bound of the camera range. Default: 1.0.
     * @param farValue The value at the upper bound of the camera range. Default: 0.0.
     * @see Packable
     */
    @JsConstructor
    public NearFarScalar(Number near, Number nearValue, Number far, Number farValue) {}

    /**
     * Duplicates a NearFarScalar instance.
     * @param nearFarScalar The NearFarScalar to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new NearFarScalar instance if one was not provided. (Returns undefined if nearFarScalar is undefined)
     */
    @JsMethod
    public static native NearFarScalar clone(NearFarScalar nearFarScalar, NearFarScalar result);

    /**
     * Compares the provided NearFarScalar and returns true if they are equal, false otherwise.
     * @param left The first NearFarScalar.
     * @param right The second NearFarScalar.
     * @return true if left and right are equal; otherwise false.
     */
    @JsMethod
    public static native boolean equals(NearFarScalar left, NearFarScalar right);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    @JsMethod
    public native Number[] pack(NearFarScalar value, Number[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements. Default: 0.
     * @return The array that was packed into
     */
    @JsMethod
    public native Number[] pack(NearFarScalar value, Number[] array, Integer startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new NearFarScalar instance if one was not provided.
     */
    @JsMethod
    public static native NearFarScalar unpack(Number[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Default: 0.
     * @return The modified result parameter or a new NearFarScalar instance if one was not provided.
     */
    @JsMethod
    public static native NearFarScalar unpack(Number[] array, Integer startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Default: 0.
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new NearFarScalar instance if one was not provided.
     */
    @JsMethod
    public static native NearFarScalar unpack(Number[] array, Integer startingIndex, NearFarScalar result);

    /**
     * Duplicates this instance.
     * @return The modified result parameter or a new NearFarScalar instance if one was not provided.
     */
    @JsMethod
    public native NearFarScalar clone();

    /**
     * Duplicates this instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new NearFarScalar instance if one was not provided.
     */
    @JsMethod
    public native NearFarScalar clone(NearFarScalar result);

    /**
     * Compares this instance to the provided NearFarScalar and returns true if they are equal, false otherwise.
     * @param right The right hand side NearFarScalar.
     * @return true if left and right are equal; otherwise false.
     */
    @JsMethod
    public native boolean equals(NearFarScalar right);
}
