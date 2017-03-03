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
import jsinterop.annotations.JsType;

/**
 * A set of curvilinear 3-dimensional coordinates.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Spherical")
public class Spherical {
    /**
     * A set of curvilinear 3-dimensional coordinates.
     */
    @JsConstructor
    public Spherical() {}

    /**
     * A set of curvilinear 3-dimensional coordinates.
     * @param clock The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis. Default: 0.0.
     * @param cone The angular coordinate measured from the positive z-axis and toward the negative z-axis. Optional. Defaule: 0.0.
     * @param magnitude The linear coordinate measured from the origin. Optional. Default: 1.0.
     */
    @JsConstructor
    public Spherical(double clock, double cone, double magnitude) {}

    /**
     * Creates a duplicate of a Spherical.
     * @param spherical The spherical to clone.
     * @param result The object to store the result into, if undefined a new instance will be created. Optional.
     * @return The modified result parameter or a new instance if result was undefined. (Returns undefined if spherical is undefined)
     */
    public static native Spherical clone(Spherical spherical, Spherical result);

    /**
     * Returns true if the first spherical is equal to the second spherical, false otherwise.
     * @param left The first Spherical to be compared.
     * @param right The second Spherical to be compared.
     * @return true if the first spherical is equal to the second spherical, false otherwise.
     */
    public static native boolean equals(Spherical left, Spherical right);

    /**
     * Returns true if the first spherical is within the provided epsilon of the second spherical, false otherwise.
     * @param left The first Spherical to be compared.
     * @param right The second Spherical to be compared.
     * @return true if the first spherical is within the provided epsilon of the second spherical, false otherwise.
     */
    public static native boolean equalsEpsilon(Spherical left, Spherical right);

    /**
     * Returns true if the first spherical is within the provided epsilon of the second spherical, false otherwise.
     * @param left The first Spherical to be compared.
     * @param right The second Spherical to be compared.
     * @param epsilon The epsilon to compare against. Optional. Default: 0.0.
     * @return true if the first spherical is within the provided epsilon of the second spherical, false otherwise.
     */
    public static native boolean equalsEpsilon(Spherical left, Spherical right, double epsilon);

    /**
     * Converts the provided Cartesian3 into Spherical coordinates.
     * @param cartesian3 The Cartesian3 to be converted to Spherical.
     * @return The modified result parameter, or a new instance if one was not provided.
     */
    public static native Spherical fromCartesian3(Cartesian3 cartesian3);

    /**
     * Converts the provided Cartesian3 into Spherical coordinates.
     * @param cartesian3 The Cartesian3 to be converted to Spherical.
     * @param spherical The object in which the result will be stored, if undefined a new instance will be created. Optional.
     * @return The modified result parameter, or a new instance if one was not provided.
     */
    public static native Spherical fromCartesian3(Cartesian3 cartesian3, Spherical spherical);

    /**
     * Computes the normalized version of the provided spherical.
     * @param spherical The spherical to be normalized.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    public static native Spherical normalize(Spherical spherical);

    /**
     * Computes the normalized version of the provided spherical.
     * @param spherical The spherical to be normalized.
     * @param result The object to store the result into, if undefined a new instance will be created. Optional.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    public static native Spherical normalize(Spherical spherical, Spherical result);

    /**
     * Creates a duplicate of this Spherical.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    public native Spherical clone();

    /**
     * Creates a duplicate of this Spherical.
     * @param result The object to store the result into, if undefined a new instance will be created. Optional.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    public native Spherical clone(Spherical result);

    /**
     * Returns true if this spherical is equal to the provided spherical, false otherwise.
     * @param other The Spherical to be compared.
     * @return true if this spherical is equal to the provided spherical, false otherwise.
     */
    public native boolean equals(Spherical other);

    /**
     * Returns true if this spherical is within the provided epsilon of the provided spherical, false otherwise.
     * @param other The Spherical to be compared.
     * @param epsilon The epsilon to compare against.
     * @return true if this spherical is within the provided epsilon of the provided spherical, false otherwise.
     */
    public native boolean equalsEpsilon(Spherical other, double epsilon);

    /**
     * Returns a string representing this instance in the format (clock, cone, magnitude).
     * @return A string representing this instance.
     */
    public native String toString();
}
