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
@JsType(isNative = true, namespace = "Cesium", name = "PackableForInterpolation")
public class PackableForInterpolation implements Packable {
    /**
     * The number of elements used to store the object into an array in its interpolatable form.
     */
    @JsProperty
    public static int packedInterpolationLength;

    /**
     * Static interface for Packable types which are interpolated in a different representation than their packed value.
     * These methods and properties are expected to be defined on a constructor function.
     */
    @JsConstructor
    private PackableForInterpolation() {}

    /**
     * Converts a packed array into a form suitable for interpolation.
     * @param packedArray The packed array.
     * @param result The object into which to store the result.
     */
    @JsMethod
    public static native void convertPackedArrayForInterpolation(double[] packedArray, double[] result);

    /**
     * Converts a packed array into a form suitable for interpolation.
     * @param packedArray The packed array.
     * @param startingIndex The index of the first element to be converted.
     * @param result The object into which to store the result.
     */
    @JsMethod
    public static native void convertPackedArrayForInterpolation(double[] packedArray, int startingIndex, double[] result);

    /**
     * Converts a packed array into a form suitable for interpolation.
     * @param packedArray The packed array.
     * @param startingIndex The index of the first element to be converted.
     * @param lastIndex The index of the last element to be converted.
     * @param result The object into which to store the result.
     */
    @JsMethod
    public static native void convertPackedArrayForInterpolation(double[] packedArray, int startingIndex, int lastIndex, double[] result);

    /**
     * Retrieves an instance from a packed array converted with PackableForInterpolation.convertPackedArrayForInterpolation.
     * @param array The array previously packed for interpolation.
     * @param sourceArray The original packed array.
     * @return The modified result parameter or a new Object instance if one was not provided.
     */
    @JsMethod
    public static native Object unpackInterpolationResult(double[] array, double[] sourceArray);

    /**
     * Retrieves an instance from a packed array converted with PackableForInterpolation.convertPackedArrayForInterpolation.
     * @param array The array previously packed for interpolation.
     * @param sourceArray The original packed array.
     * @param startingIndex The startingIndex used to convert the array.
     * @return The modified result parameter or a new Object instance if one was not provided.
     */
    @JsMethod
    public static native Object unpackInterpolationResult(double[] array, double[] sourceArray, int startingIndex);

    /**
     * Retrieves an instance from a packed array converted with PackableForInterpolation.convertPackedArrayForInterpolation.
     * @param array The array previously packed for interpolation.
     * @param sourceArray The original packed array.
     * @param startingIndex The startingIndex used to convert the array.
     * @param lastIndex The lastIndex used to convert the array.
     * @return The modified result parameter or a new Object instance if one was not provided.
     */
    @JsMethod
    public static native Object unpackInterpolationResult(double[] array, double[] sourceArray, int startingIndex, int lastIndex);

    /**
     * Retrieves an instance from a packed array converted with PackableForInterpolation.convertPackedArrayForInterpolation.
     * @param array The array previously packed for interpolation.
     * @param sourceArray The original packed array.
     * @param startingIndex The startingIndex used to convert the array.
     * @param lastIndex The lastIndex used to convert the array.
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new Object instance if one was not provided.
     */
    @JsMethod
    public static native Object unpackInterpolationResult(double[] array, double[] sourceArray, int startingIndex, int lastIndex, Object result);
}
