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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Ellipsoid")
public class Ellipsoid {
    /**
     * An Ellipsoid instance initialized to a sphere with the lunar radius.
     */
    @JsProperty(name = "MOON")
    public static native Ellipsoid MOON();
    /**
     * An Ellipsoid instance initialized to radii of (1.0, 1.0, 1.0).
     */
    @JsProperty(name = "UNIT_SPHERE")
    public static native Ellipsoid UNIT_SPHERE();
    /**
     * An Ellipsoid instance initialized to the WGS84 standard.
     */
    @JsProperty(name = "WGS84")
    public static native Ellipsoid WGS84();
    /**
     * The number of elements used to pack the object into an array.
     */
    public static int packedLength;
    /**
     * Gets the maximum radius of the ellipsoid.
     */
    @JsProperty(name = "maximumRadius")
    public native double maximumRadius();
    /**
     * Gets the minimum radius of the ellipsoid.
     */
    @JsProperty(name = "minimumRadius")
    public native double minimumRadius();
    /**
     * Gets one over the radii of the ellipsoid.
     */
    @JsProperty(name = "oneOverRadii")
    public native Cartesian3 oneOverRadii();
    /**
     * Gets one over the squared radii of the ellipsoid.
     */
    @JsProperty(name = "oneOverRadiiSquared")
    public native Cartesian3 oneOverRadiiSquared();
    /**
     * Gets the radii of the ellipsoid.
     */
    @JsProperty(name = "radii")
    public native Cartesian3 radii();
    /**
     * Gets the squared radii of the ellipsoid.
     */
    @JsProperty(name = "radiiSquared")
    public native Cartesian3 radiiSquared();
    /**
     * Gets the radii of the ellipsoid raise to the fourth power.
     */
    @JsProperty(name = "radiiToTheFourth")
    public native Cartesian3 radiiToTheFourth();

    /**
     * Duplicates an Ellipsoid instance.
     * @param ellipsoid The ellipsoid to duplicate.
     * @return The cloned Ellipsoid. (Returns undefined if ellipsoid is undefined)
     */
    @JsMethod
    public static native Ellipsoid clone(Ellipsoid ellipsoid);

    /**
     * Duplicates an Ellipsoid instance.
     * @param ellipsoid The ellipsoid to duplicate.
     * @param result The object onto which to store the result, or undefined if a new instance should be created. Optional.
     * @return The cloned Ellipsoid. (Returns undefined if ellipsoid is undefined)
     */
    @JsMethod
    public static native Ellipsoid clone(Ellipsoid ellipsoid, Ellipsoid result);

    /**
     * Computes an Ellipsoid from a Cartesian specifying the radii in x, y, and z directions.
     * @param radii The ellipsoid's radius in the x, y, and z directions. Optional. Default: Cartesian3.ZERO.
     * @return A new Ellipsoid instance.
     * @see #WGS84
     * @see #UNIT_SPHERE
     */
    @JsMethod
    public static native Ellipsoid fromCartesian3(Cartesian3 radii);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Ellipsoid value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements. Optional. Default: 0.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Ellipsoid value, double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new Ellipsoid instance if one was not provided.
     */
    @JsMethod
    public static native Ellipsoid unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Optional.
     * @param result The object into which to store the result. Optional.
     * @return The modified result parameter or a new Ellipsoid instance if one was not provided.
     */
    @JsMethod
    public static native Ellipsoid unpack(double[] array, int startingIndex, Ellipsoid result);

    /**
     * Converts the provided array of cartesians to an array of cartographics.
     * @param cartesians An array of Cartesian positions.
     * @return The modified result parameter or a new Array instance if none was provided.
     */
    @JsMethod
    public native Cartographic[] cartesianArrayToCartographicArray(Cartesian3[] cartesians);

    /**
     * Converts the provided array of cartesians to an array of cartographics.
     * <pre>
     *     Example:
     *     {@code
     *     //Create an array of Cartesians and determine their Cartographic representation on a WGS84 ellipsoid.
     *     Cartesian3[] positions = {new Cartesian3(17832.12, 83234.52, 952313.73),
     *                               new Cartesian3(17832.13, 83234.53, 952313.73),
     *                               new Cartesian3(17832.14, 83234.54, 952313.73)};
     *     Cartographic[] cartographicPositions = Ellipsoid.WGS84.cartesianArrayToCartographicArray(positions);
     *     }
     * </pre>
     * @param cartesians An array of Cartesian positions.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Array instance if none was provided.
     */
    @JsMethod
    public native Cartographic[] cartesianArrayToCartographicArray(Cartesian3[] cartesians, Cartographic[] result);

    /**
     * Converts the provided cartesian to cartographic representation. The cartesian is undefined at the center of the ellipsoid.
     * <pre>
     *     <{@code
     *         //Create a Cartesian and determine it's Cartographic representation on a WGS84 ellipsoid.
     *         Cartesian3 position = new Cartesian3(17832.12, 83234.52, 952313.73);
     *         Cartographic cartographicPosition = Ellipsoid.WGS84.cartesianToCartographic(position);
     *     }
     * </pre>
     * @param cartesian The Cartesian position to convert to cartographic representation.
     * @return The modified result parameter, new Cartographic instance if none was provided, or undefined if the cartesian is at the center of the ellipsoid.
     */
    @JsMethod
    public native Cartographic cartesianToCartographic(Cartesian3 cartesian);

    /**
     * Converts the provided cartesian to cartographic representation. The cartesian is undefined at the center of the ellipsoid.
     * <pre>
     *     <{@code
     *         //Create a Cartesian and determine it's Cartographic representation on a WGS84 ellipsoid.
     *         Cartesian3 position = new Cartesian3(17832.12, 83234.52, 952313.73);
     *         Cartographic cartographicPosition = Ellipsoid.WGS84.cartesianToCartographic(position);
     *     }
     * </pre>
     * @param cartesian The Cartesian position to convert to cartographic representation.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter, new Cartographic instance if none was provided, or undefined if the cartesian is at the center of the ellipsoid.
     */
    @JsMethod
    public native Cartographic cartesianToCartographic(Cartesian3 cartesian, Cartographic result);

    /**
     * Converts the provided array of cartographics to an array of Cartesians.
     * <pre>
     *     {@code
     *         Cartographic[] positions = {new Cartographic(Math.toRadians(21), Math.toRadians(78), 0),
     *                                     new Cartographic(Math.toRadians(21.321), Math.toRadians(78.123), 100),
     *                                     new Cartographic(Math.toRadians(21.645), Math.toRadians(78.456), 250)};
     *         Cartesian3[] cartesianPositions = Ellipsoid.WGS84.cartographicArrayToCartesianArray(positions);
     *     }
     * </pre>
     * @param cartographics An array of cartographic positions.
     * @return The modified result parameter or a new Array instance if none was provided.
     */
    @JsMethod
    public native Cartesian3[] cartographicArrayToCartesianArray(Cartographic[] cartographics);

    /**
     * Converts the provided array of cartographics to an array of Cartesians.
     * <pre>
     *     {@code
     *         Cartographic[] positions = {new Cartographic(Math.toRadians(21), Math.toRadians(78), 0),
     *                                     new Cartographic(Math.toRadians(21.321), Math.toRadians(78.123), 100),
     *                                     new Cartographic(Math.toRadians(21.645), Math.toRadians(78.456), 250)};
     *         Cartesian3[] cartesianPositions = Ellipsoid.WGS84.cartographicArrayToCartesianArray(positions);
     *     }
     * </pre>
     * @param cartographics An array of cartographic positions.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Array instance if none was provided.
     */
    @JsMethod
    public native Cartesian3[] cartographicArrayToCartesianArray(Cartographic[] cartographics, Cartesian3[] result);

    /**
     * Converts the provided cartographic to Cartesian representation.
     * <pre>
     *     {@code
     *         //Create a Cartographic and determine it's Cartesian representation on a WGS84 ellipsoid.
     *         Cartographic position = new.Cartographic(Math.toRadians(21), Math.toRadians(78), 5000);
     *         Cartesian3 cartesianPosition = Ellipsoid.WGS84.cartographicToCartesian(position);
     *     }
     * </pre>
     * @param cartographic The cartographic position.
     * @return The modified result parameter or a new Cartesian3 instance if none was provided.
     */
    @JsMethod
    public native Cartesian3 cartographicToCartesian(Cartographic cartographic);

    /**
     * Converts the provided cartographic to Cartesian representation.
     * <pre>
     *     {@code
     *         //Create a Cartographic and determine it's Cartesian representation on a WGS84 ellipsoid.
     *         Cartographic position = new.Cartographic(Math.toRadians(21), Math.toRadians(78), 5000);
     *         Cartesian3 cartesianPosition = Ellipsoid.WGS84.cartographicToCartesian(position);
     *     }
     * </pre>
     * @param cartographic The cartographic position.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if none was provided.
     */
    @JsMethod
    public native Cartesian3 cartographicToCartesian(Cartographic cartographic, Cartesian3 result);

//    /**
//     * Duplicates an Ellipsoid instance.
//     * @param result The object onto which to store the result, or undefined if a new instance should be created. Optional.
//     * @return The cloned Ellipsoid.
//     */
//    public native Ellipsoid clone(Ellipsoid result);

    /**
     * Compares this Ellipsoid against the provided Ellipsoid componentwise and returns true if they are equal, false otherwise.
     * @param right The other Ellipsoid. Optional.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(Ellipsoid right);

    /**
     * Computes the unit vector directed from the center of this ellipsoid toward the provided Cartesian position.
     * @param cartesian The Cartesian for which to to determine the geocentric normal.
     * @return The modified result parameter or a new Cartesian3 instance if none was provided.
     */
    @JsMethod
    public native Cartesian3 geocentricSurfaceNormal(Cartesian3 cartesian);

    /**
     * Computes the unit vector directed from the center of this ellipsoid toward the provided Cartesian position.
     * @param cartesian The Cartesian for which to to determine the geocentric normal.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if none was provided.
     */
    @JsMethod
    public native Cartesian3 geocentricSurfaceNormal(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Computes the normal of the plane tangent to the surface of the ellipsoid at the provided position.
     * @param cartesian The Cartesian position for which to to determine the surface normal.
     * @return The modified result parameter or a new Cartesian3 instance if none was provided.
     */
    @JsMethod
    public native Cartesian3 geodeticSurfaceNormal(Cartesian3 cartesian);

    /**
     * Computes the normal of the plane tangent to the surface of the ellipsoid at the provided position.
     * @param cartesian The Cartesian position for which to to determine the surface normal.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if none was provided.
     */
    @JsMethod
    public native Cartesian3 geodeticSurfaceNormal(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Computes the normal of the plane tangent to the surface of the ellipsoid at the provided position.
     * @param cartographic The cartographic position for which to to determine the geodetic normal.
     * @return The modified result parameter or a new Cartesian3 instance if none was provided.
     */
    @JsMethod
    public native Cartesian3 geodeticSurfaceNormalCartographic(Cartographic cartographic);

    /**
     * Computes the normal of the plane tangent to the surface of the ellipsoid at the provided position.
     * @param cartographic The cartographic position for which to to determine the geodetic normal.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if none was provided.
     */
    @JsMethod
    public native Cartesian3 geodeticSurfaceNormalCartographic(Cartographic cartographic, Cartesian3 result);

    /**
     * Scales the provided Cartesian position along the geocentric surface normal so that it is on the surface of this ellipsoid.
     * @param cartesian The Cartesian position to scale.
     * @return The modified result parameter or a new Cartesian3 instance if none was provided.
     */
    @JsMethod
    public native Cartesian3 scaleToGeocentricSurface(Cartesian3 cartesian);

    /**
     * Scales the provided Cartesian position along the geocentric surface normal so that it is on the surface of this ellipsoid.
     * @param cartesian The Cartesian position to scale.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if none was provided.
     */
    @JsMethod
    public native Cartesian3 scaleToGeocentricSurface(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Scales the provided Cartesian position along the geodetic surface normal so that it is on the surface of this ellipsoid.
     * If the position is at the center of the ellipsoid, this function returns undefined.
     * @param cartesian The Cartesian position to scale.
     * @return The modified result parameter, a new Cartesian3 instance if none was provided, or undefined if the position is at the center.
     */
    @JsMethod
    public native Cartesian3 scaleToGeodeticSurface(Cartesian3 cartesian);

    /**
     * Scales the provided Cartesian position along the geodetic surface normal so that it is on the surface of this ellipsoid.
     * If the position is at the center of the ellipsoid, this function returns undefined.
     * @param cartesian The Cartesian position to scale.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter, a new Cartesian3 instance if none was provided, or undefined if the position is at the center.
     */
    @JsMethod
    public native Cartesian3 scaleToGeodeticSurface(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Creates a string representing this Ellipsoid in the format '(radii.x, radii.y, radii.z)'.
     * @return A string representing this ellipsoid in the format '(radii.x, radii.y, radii.z)'.
     */
    @JsMethod
    public native String toString();

    /**
     * Transforms a Cartesian X, Y, Z position from the ellipsoid-scaled space by multiplying its components by the result of Ellipsoid#radii.
     * @param position The position to transform.
     * @return The position expressed in the unscaled space. The returned instance is the one passed as the result parameter
     * if it is not undefined, or a new instance of it is.
     */
    @JsMethod
    public native Cartesian3 transformPositionFromScaledSpace(Cartesian3 position);

    /**
     * Transforms a Cartesian X, Y, Z position from the ellipsoid-scaled space by multiplying its components by the result of Ellipsoid#radii.
     * @param position The position to transform.
     * @param result The position to which to copy the result, or undefined to create and return a new instance.
     * @return The position expressed in the unscaled space. The returned instance is the one passed as the result parameter
     * if it is not undefined, or a new instance of it is.
     */
    @JsMethod
    public native Cartesian3 transformPositionFromScaledSpace(Cartesian3 position, Cartesian3 result);

    /**
     * Transforms a Cartesian X, Y, Z position to the ellipsoid-scaled space by multiplying its components by the result of Ellipsoid#oneOverRadii.
     * @param position The position to transform.
     * @return The position expressed in the scaled space. The returned instance is the one passed as the result parameter
     * if it is not undefined, or a new instance of it is.
     */
    @JsMethod
    public native Cartesian3 transformPositionToScaledSpace(Cartesian3 position);

    /**
     * Transforms a Cartesian X, Y, Z position to the ellipsoid-scaled space by multiplying its components by the result of Ellipsoid#oneOverRadii.
     * @param position The position to transform.
     * @param result The position to which to copy the result, or undefined to create and return a new instance. Optional.
     * @return The position expressed in the scaled space. The returned instance is the one passed as the result parameter
     * if it is not undefined, or a new instance of it is.
     * @see #oneOverRadii
     */
    @JsMethod
    public native Cartesian3 transformPositionToScaledSpace(Cartesian3 position, Cartesian3 result);
}
