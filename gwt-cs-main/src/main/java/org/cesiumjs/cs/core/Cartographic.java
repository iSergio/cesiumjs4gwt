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
 * A position defined by longitude, latitude, and height.
 * @see Ellipsoid
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cartographic")
public class Cartographic {
    /**
     * An immutable Cartographic instance initialized to (0.0, 0.0, 0.0).
     */
    @JsProperty(name = "ZERO")
    public static native Cartographic ZERO();
    /**
     * The height, in meters, above the ellipsoid.
     * Default Value:  0.0
     */
    @JsProperty
    public double height;
    /**
     * The latitude, in radians.
     * Default Value:  0.0
     */
    @JsProperty
    public double latitude;
    /**
     * The longitude, in radians.
     * Default Value:  0.0
     */
    @JsProperty
    public double longitude;

    /**
     * A position defined by longitude, latitude, and height.
     * @see Ellipsoid
     */
    @JsConstructor
    public Cartographic() {}

    /**
     * A position defined by longitude, latitude, and height.
     * @param longitude The longitude, in radians.
     * @param latitude The latitude, in radians.
     * @see Ellipsoid
     */
    @JsConstructor
    public Cartographic(double longitude, double latitude) {}

    /**
     * A position defined by longitude, latitude, and height.
     * @param longitude The longitude, in radians.
     * @param latitude The latitude, in radians.
     * @param height The height, in meters, above the ellipsoid.
     * @see Ellipsoid
     */
    @JsConstructor
    public Cartographic(double longitude, double latitude, double height) {}

    /**
     * Duplicates a Cartographic instance.
     * @param cartographic The cartographic to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Cartographic instance if one was not provided.
     * (Returns undefined if cartographic is undefined)
     */
    @JsMethod
    public static native Cartographic clone(Cartographic cartographic, Cartographic result);

    /**
     * Compares the provided cartographics componentwise and returns true if they are equal, false otherwise.
     * @param left The first cartographic. Optional.
     * @param right The second cartographic. Optional.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(Cartographic left, Cartographic right);

    /**
     * Compares the provided cartographics componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param left The first cartographic. Optional.
     * @param right The second cartographic. Optional.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public static native boolean equalsEpsilon(Cartographic left, Cartographic right, double epsilon);

    /**
     * Creates a new Cartographic instance from a Cartesian position. The values in the resulting object will be in radians.
     * @param cartesian The Cartesian position to convert to cartographic representation.
     * @return The modified result parameter, new Cartographic instance if none was provided, or undefined if the cartesian is at the center of the ellipsoid.
     */
    @JsMethod
    public static native Cartographic fromCartesian(Cartesian3 cartesian);

    /**
     * Creates a new Cartographic instance from a Cartesian position. The values in the resulting object will be in radians.
     * @param cartesian The Cartesian position to convert to cartographic representation.
     * @param ellipsoid The ellipsoid on which the position lies. Optional. Default {@link Ellipsoid#WGS84}.
     * @return The modified result parameter, new Cartographic instance if none was provided, or undefined if the cartesian is at the center of the ellipsoid.
     */
    @JsMethod
    public static native Cartographic fromCartesian(Cartesian3 cartesian, Ellipsoid ellipsoid);

    /**
     * Creates a new Cartographic instance from a Cartesian position. The values in the resulting object will be in radians.
     * @param cartesian The Cartesian position to convert to cartographic representation.
     * @param ellipsoid The ellipsoid on which the position lies. Optional. Default {@link Ellipsoid#WGS84}.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter, new Cartographic instance if none was provided, or undefined if the cartesian is at the center of the ellipsoid.
     */
    @JsMethod
    public static native Cartographic fromCartesian(Cartesian3 cartesian, Ellipsoid ellipsoid, Cartographic result);

    /**
     * Creates a new Cartographic instance from longitude and latitude specified in degrees. The values in the resulting object will be in radians.
     * @param longitude The longitude, in degrees.
     * @param latitude The latitude, in degrees.
     * @return The modified result parameter or a new Cartographic instance if one was not provided.
     */
    @JsMethod
    public static native Cartographic fromDegrees(double longitude, double latitude);

    /**
     * Creates a new Cartographic instance from longitude and latitude specified in degrees. The values in the resulting object will be in radians.
     * @param longitude The longitude, in degrees.
     * @param latitude The latitude, in degrees.
     * @param height The height, in meters, above the ellipsoid. Optional. Default: 0.0.
     * @return The modified result parameter or a new Cartographic instance if one was not provided.
     */
    @JsMethod
    public static native Cartographic fromDegrees(double longitude, double latitude, double height);

    /**
     * Creates a new Cartographic instance from longitude and latitude specified in degrees. The values in the resulting object will be in radians.
     * @param longitude The longitude, in degrees.
     * @param latitude The latitude, in degrees.
     * @param height The height, in meters, above the ellipsoid. Optional. Default: 0.0.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartographic instance if one was not provided.
     */
    @JsMethod
    public static native Cartographic fromDegrees(double longitude, double latitude, double height, Cartographic result);

    /**
     * Creates a new Cartographic instance from longitude and latitude specified in radians.
     * @param longitude The longitude, in radians.
     * @param latitude The latitude, in radians.
     * @return The modified result parameter or a new Cartographic instance if one was not provided.
     */
    @JsMethod
    public static native Cartographic fromRadians(double longitude, double latitude);

    /**
     * Creates a new Cartographic instance from longitude and latitude specified in radians.
     * @param longitude The longitude, in radians.
     * @param latitude The latitude, in radians.
     * @param height The height, in meters, above the ellipsoid. Optional. Default: 0.0.
     * @return The modified result parameter or a new Cartographic instance if one was not provided.
     */
    @JsMethod
    public static native Cartographic fromRadians(double longitude, double latitude, double height);

    /**
     * Creates a new Cartographic instance from longitude and latitude specified in radians.
     * @param longitude The longitude, in radians.
     * @param latitude The latitude, in radians.
     * @param height The height, in meters, above the ellipsoid. Optional. Default: 0.0.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartographic instance if one was not provided.
     */
    @JsMethod
    public static native Cartographic fromRadians(double longitude, double latitude, double height, Cartographic result);

    /**
     * Duplicates this instance.
     * @return The modified result parameter or a new Cartographic instance if one was not provided.
     */
    @JsMethod
    public native Cartographic clone();

    /**
     * Duplicates this instance.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartographic instance if one was not provided.
     */
    @JsMethod
    public native Cartographic clone(Cartographic result);

    /**
     * Compares the provided against this cartographic componentwise and returns true if they are equal, false otherwise.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals();

    /**
     * Compares the provided against this cartographic componentwise and returns true if they are equal, false otherwise.
     * @param right The second cartographic. Optional.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(Cartographic right);

    /**
     * Compares the provided against this cartographic componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param right The second cartographic.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(Cartographic right, double epsilon);

    /**
     * Creates a string representing this cartographic in the format '(longitude, latitude, height)'.
     * @return A string representing the provided cartographic in the format '(longitude, latitude, height)'.
     */
    @JsMethod
    public native String toString();
}
