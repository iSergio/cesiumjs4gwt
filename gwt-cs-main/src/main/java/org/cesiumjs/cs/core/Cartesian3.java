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

import com.google.gwt.core.client.JsArrayNumber;
import jsinterop.annotations.*;

/**
 * @see Cartesian2
 * @see Cartesian4
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cartesian3")
public class Cartesian3 implements Packable {
    /**
     * The X component.
     * Default Value:  0.0
     */
    @JsProperty
    public double x;
    /**
     * The Y component.
     * Default Value:  0.0
     */
    @JsProperty
    public double y;
    /**
     * The Z component.
     * Default Value: 0.0
     */
    @JsProperty
    public double z;
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public static int packedLength;
    /**
     * An immutable Cartesian3 instance initialized to (1.0, 0.0, 0.0).
     */
    @JsProperty(name = "UNIT_X")
    public static native Cartesian3 UNIT_X();
    /**
     * An immutable Cartesian3 instance initialized to (0.0, 1.0, 0.0).
     */
    @JsProperty(name = "UNIT_Y")
    public static native Cartesian3 UNIT_Y();
    /**
     * An immutable Cartesian3 instance initialized to (0.0, 0.0, 1.0).
     */
    @JsProperty(name = "UNIT_Z")
    public static native Cartesian3 UNIT_Z();
    /**
     * An immutable Cartesian3 instance initialized to (0.0, 0.0, 0.0).
     */
    @JsProperty(name = "ZERO")
    public static native Cartesian3 ZERO();

    /**
     * A 3D Cartesian point.
     * @see Cartesian2
     * @see Cartesian4
     */
    @JsConstructor
    public Cartesian3() {}

    /**
     * A 3D Cartesian point.
     * @param x The X component. Default Value: 0.0
     * @param y The Y component. Default Value: 0.0
     * @param z The Z component. Default value: 0.0
     * @see Cartesian2
     * @see Cartesian4
     */
    @JsConstructor
    public Cartesian3(double x, double y, double z) {}

    /**
     * Duplicates this Cartesian3 instance.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public native Cartesian3 clone(Cartesian3 result);

    /**
     * Duplicates this Cartesian3 instance.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public native Cartesian3 clone();

    /**
     * Compares this Cartesian against the provided Cartesian componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side Cartesian. Optional.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native Cartesian3 equals(Cartesian3 right);

    /**
     * Compares this Cartesian against the provided Cartesian componentwise and returns true if they pass an absolute or
     * relative tolerance test, false otherwise.
     * @param right The right hand side Cartesian. Optional.
     * @param relativeEpsilon The relative epsilon tolerance to use for equality testing.
     * @param absoluteEpsilon The absolute epsilon tolerance to use for equality testing. Optional.
     * @return true if they are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(Cartesian3 right, double relativeEpsilon, double absoluteEpsilon);

    /**
     * Creates a string representing this Cartesian in the format '(x, y, z)'.
     * @return A string representing the provided Cartesian in the format '(x, y, z)'.
     */
    @JsMethod
    public native String toString();

    /**
     * Computes the absolute value of the provided Cartesian.
     * @param cartesian The Cartesian whose absolute value is to be computed.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 abs(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Computes the componentwise sum of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 add(Cartesian3 left, Cartesian3 right, Cartesian3 result);

    /**
     * Returns the angle, in radians, between the provided Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @return The angle between the Cartesians.
     */
    @JsMethod
    public static native double angleBetween(Cartesian3 left, Cartesian3 right);

    /**
     * Duplicates a Cartesian3 instance.
     * @param cartesian The Cartesian to duplicate.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     * (Returns undefined if cartesian is undefined)
     */
    @JsMethod
    public static native Cartesian3 clone(Cartesian3 cartesian, @JsOptional Cartesian3 result);

    /**
     * Computes the cross (outer) product of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The cross product.
     */
    @JsMethod
    public static native Cartesian3 cross(Cartesian3 left, Cartesian3 right, Cartesian3 result);

    /**
     * Computes the distance between two points.
     * <pre>
     *     Example:
     *     {@code
     *     // Returns 1.0
     *     double d = Cartesian3.distance(new Cartesian3(1.0, 0.0, 0.0), new Cartesian3(2.0, 0.0, 0.0));
     *     }
     * </pre>
     * @param left The first point to compute the distance from.
     * @param right The second point to compute the distance to.
     * @return The distance between two points.
     */
    @JsMethod
    public static native double distance(Cartesian3 left, Cartesian3 right);

    /**
     * Computes the squared distance between two points. Comparing squared distances using this function is more efficient
     * than comparing distances using Cartesian3#distance.
     * <pre>
     *     Example:
     *     {@code
     *     // Returns 4.0, not 2.0
     *     double d = Cartesian3.distanceSquared(new Cartesian3(1.0, 0.0, 0.0), new Cartesian3(3.0, 0.0, 0.0));
     *     }
     * </pre>
     * @param left The first point to compute the distance from.
     * @param right The second point to compute the distance to.
     * @return The distance between two points.
     */
    @JsMethod
    public static native double distanceSquared(Cartesian3 left, Cartesian3 right);

    /**
     * Divides the provided Cartesian componentwise by the provided scalar.
     * @param cartesian The Cartesian to be divided.
     * @param scalar The scalar to divide by.
     * @param result The object onto which to store the result.
     * @return  The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 divideByScalar(Cartesian3 cartesian, double scalar, Cartesian3 result);

    /**
     * Computes the componentwise quotient of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 divideComponents(Cartesian3 left, Cartesian3 right, Cartesian3 result);

    /**
     * Computes the dot (scalar) product of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @return The dot product.
     */
    @JsMethod
    public static native double dot(Cartesian3 left, Cartesian3 right);

    /**
     * Compares the provided Cartesians componentwise and returns true if they are equal, false otherwise.
     * @param left The first Cartesian. Optional.
     * @param right The second Cartesian. Optional.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(Cartesian3 left, Cartesian3 right);

    /**
     * Compares the provided Cartesians componentwise and returns true if they pass an absolute or relative tolerance test, false otherwise.
     * @param left The first Cartesian. Optional.
     * @param right The second Cartesian. Optional.
     * @param relativeEpsilon The relative epsilon tolerance to use for equality testing.
     * @param absoluteEpsilon The absolute epsilon tolerance to use for equality testing. Optional.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public static native boolean equalsEpsilon(Cartesian3 left, Cartesian3 right, double relativeEpsilon, double absoluteEpsilon);

    /**
     * Creates a Cartesian3 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     JsArrayNumber jsArrayNumber = JsArray.createArray().cast();
     *     jsArrayNumber.push(1);
     *     jsArrayNumber.push(2);
     *     Cartesian3 c = Cartesian3.fromArray(jsArrayNumber, 0, null);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian3 fromArray(JsArrayNumber array, Cartesian3 result);

    /**
     * Creates a Cartesian3 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     double[] array = {1, 2, 3};
     *     Cartesian3 c = Cartesian3.fromArray(array, 0, null);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian3 fromArray(double[] array, Cartesian3 result);

    /**
     * Creates a Cartesian3 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     JsArrayNumber jsArrayNumber = JsArray.createArray().cast();
     *     jsArrayNumber.push(1);
     *     jsArrayNumber.push(2);
     *     jsArrayNumber.push(3);
     *     jsArrayNumber.push(4);
     *     Cartesian3 c = Cartesian3.fromArray(jsArrayNumber, 2, null);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param startingIndex The offset into the array of the first element, which corresponds to the x component. Optional.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian3 fromArray(JsArrayNumber array, int startingIndex, Cartesian3 result);

    /**
     * Creates a Cartesian3 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     double[] array = {1, 2, 3, 4, 5, 6};
     *     Cartesian3 c = Cartesian3.fromArray(array, 2, null);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param startingIndex The offset into the array of the first element, which corresponds to the x component. Optional.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian3 fromArray(double[] array, int startingIndex, Cartesian3 result);

    /**
     * Creates a Cartesian3 instance from an existing Cartesian4. This simply takes the x and y properties of the Cartesian4 and drops z and w.
     * @param cartesian The Cartesian4 instance to create a Cartesian3 instance from.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian3 fromCartesian4(Cartesian4 cartesian, Cartesian3 result);

    /**
     * Returns a Cartesian3 position from longitude and latitude values given in degrees.
     * <pre>
     *     Example:
     *     {@code Cartesian3 position = Cartesian3.fromDegrees(-115.0, 37.0);}
     * </pre>
     * @param longitude The longitude, in degrees
     * @param latitude The latitude, in degrees
     * @return The position
     */
    @JsMethod
    public static native Cartesian3 fromDegrees(double longitude, double latitude);

    /**
     * Returns a Cartesian3 position from longitude and latitude values given in degrees.
     * <pre>
     *     Example:
     *     {@code Cartesian3 position = Cartesian3.fromDegrees(-115.0, 37.0);}
     * </pre>
     * @param longitude The longitude, in degrees
     * @param latitude The latitude, in degrees
     * @param height The height, in meters, above the ellipsoid. Optional. Default: 0.0.
     * @return The position
     */
    @JsMethod
    public static native Cartesian3 fromDegrees(double longitude, double latitude, double height);

    /**
     * Returns a Cartesian3 position from longitude and latitude values given in degrees.
     * <pre>
     *     Example:
     *     {@code Cartesian3 position = Cartesian3.fromDegrees(-115.0, 37.0);}
     * </pre>
     * @param longitude The longitude, in degrees
     * @param latitude The latitude, in degrees
     * @param height The height, in meters, above the ellipsoid. Optional. Default: 0.0.
     * @param ellipsoid The ellipsoid on which the position lies. Optional. Default: Ellipsoid.WGS84.
     * @param result The object onto which to store the result. Optional.
     * @return The position
     */
    @JsMethod
    public static native Cartesian3 fromDegrees(double longitude, double latitude, double height, Ellipsoid ellipsoid, Cartesian3 result);

    /**
     * Returns an array of Cartesian3 positions given an array of longitude and latitude values given in degrees.
     * <pre>
     *     Example:
     *     {@code
     *     double[] coordinates = {-115.0, 37.0, -107.0, 33.0};
     *     Cartesian3 positions = Cartesian3.fromDegreesArray(coordinates);}
     * </pre>
     * @param coordinates A list of longitude and latitude values. Values alternate [longitude, latitude, longitude, latitude...].
     * @return The array of positions.
     */
    @JsMethod
    public static native Cartesian3[] fromDegreesArray(double[] coordinates);

    /**
     * Returns an array of Cartesian3 positions given an array of longitude and latitude values given in degrees.
     * <pre>
     *     Example:
     *     {@code
     *     double[] coordinates = {-115.0, 37.0, -107.0, 33.0};
     *     Cartesian3 positions = Cartesian3.fromDegreesArray(coordinates);}
     * </pre>
     * @param coordinates A list of longitude and latitude values. Values alternate [longitude, latitude, longitude, latitude...].
     * @param ellipsoid The ellipsoid on which the coordinates line. Optional.
     * @param result An array of Cartesian3 objects to store the result. Optional.
     * @return The array of positions.
     */
    @JsMethod
    public static native Cartesian3[] fromDegreesArray(double[] coordinates, Ellipsoid ellipsoid, Cartesian3[] result);

    /**
     * Returns an array of Cartesian3 positions given an array of longitude, latitude and height values where longitude and latitude are given in degrees.
     * <pre>
     *     Example:
     *     {@code
     *     double[] coordinates = {-115.0, 37.0, 100000.0, -107.0, 33.0, 150000.0};
     *     Cartesian3 positions = Cartesian3.fromDegreesArrayHeights(coordinates);
     *     }
     * </pre>
     * @param coordinates A list of longitude, latitude and height values. Values alternate [longitude, latitude, height, longitude, latitude, height...].
     * @return The array of positions.
     */
    @JsMethod
    public static native Cartesian3[] fromDegreesArrayHeights(double[] coordinates);

    /**
     * Returns an array of Cartesian3 positions given an array of longitude, latitude and height values where longitude and latitude are given in degrees.
     * <pre>
     *     Example:
     *     {@code
     *     double[] coordinates = {-115.0, 37.0, 100000.0, -107.0, 33.0, 150000.0};
     *     Cartesian3 positions = Cartesian3.fromDegreesArrayHeights(coordinates);
     *     }
     * </pre>
     * @param coordinates A list of longitude, latitude and height values. Values alternate [longitude, latitude, height, longitude, latitude, height...].
     * @param ellipsoid The ellipsoid on which the position lies. Optional. Default: Ellipsoid.WGS84.
     * @param result An array of Cartesian3 objects to store the result. Optional;
     * @return The array of positions.
     */
    @JsMethod
    public static native Cartesian3[] fromDegreesArrayHeights(double[] coordinates, Ellipsoid ellipsoid, Cartesian3[] result);

    /**
     * Creates a Cartesian3 instance from x and y coordinates.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param z The z coordinate.
     * @param result Cartesian3	optional The object onto which to store the result.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian3 fromElements(double x, double y, double z, Cartesian3 result);

    /**
     * Returns a Cartesian3 position from longitude and latitude values given in radians.
     * <pre>
     *     {@code
     *     Cartesian3 position = Cartesian3.fromRadians(-2.007, 0.645);
     *     }
     * </pre>
     * @param longitude The longitude, in radians.
     * @param latitude The latitude, in radians.
     * @return The position.
     */
    @JsMethod
    public static native Cartesian3 fromRadians(double longitude, double latitude);

    /**
     * Returns a Cartesian3 position from longitude and latitude values given in radians.
     * <pre>
     *     {@code
     *     Cartesian3 position = Cartesian3.fromRadians(-2.007, 0.645);
     *     }
     * </pre>
     * @param longitude The longitude, in radians.
     * @param latitude The latitude, in radians.
     * @param height The height, in meters, above the ellipsoid.
     * @return The position.
     */
    @JsMethod
    public static native Cartesian3 fromRadians(double longitude, double latitude, double height);

    /**
     * Returns a Cartesian3 position from longitude and latitude values given in radians.
     * <pre>
     *     {@code
     *     Cartesian3 position = Cartesian3.fromRadians(-2.007, 0.645);
     *     }
     * </pre>
     * @param longitude The longitude, in radians
     * @param latitude The latitude, in radians
     * @param height The height, in meters, above the ellipsoid. Optional.
     * @param ellipsoid The ellipsoid on which the position lines. Optional. Default: Ellipsoid.WGS84.
     * @param result The object onto which to store the result. Optional.
     * @return The position.
     */
    @JsMethod
    public static native Cartesian3 fromRadians(double longitude, double latitude, double height, Ellipsoid ellipsoid, Cartesian3 result);

    /**
     * Returns an array of Cartesian3 positions given an array of longitude and latitude values given in radians.
     * <pre>
     *     {@code
     *     double coordinates[] = {-2.007, 0.645, -1.867, .575};
     *     Cartesian3[] positions = Cartesian3.fromRadiansArray(coordinates);
     *     }
     * </pre>
     * @param coordinates A list of longitude and latitude values. Values alternate [longitude, latitude, longitude, latitude...].
     * @return The array of positions.
     */
    @JsMethod
    public static native Cartesian3[] fromRadiansArray(double[] coordinates);

    /**
     * Returns an array of Cartesian3 positions given an array of longitude and latitude values given in radians.
     * <pre>
     *     {@code
     *     double coordinates[] = {-2.007, 0.645, -1.867, .575};
     *     Cartesian3[] positions = Cartesian3.fromRadiansArray(coordinates);
     *     }
     * </pre>
     * @param coordinates A list of longitude and latitude values. Values alternate [longitude, latitude, longitude, latitude...].
     * @param ellipsoid The ellipsoid on which the position lines. Optional. Default: Ellipsoid.WGS84.
     * @param result The object onto which to store the result. Optional.
     * @return The array of positions.
     */
    @JsMethod
    public static native Cartesian3[] fromRadiansArray(double[] coordinates, Ellipsoid ellipsoid, Cartesian3[] result);

    /**
     * Returns an array of Cartesian3 positions given an array of longitude, latitude and height values where longitude and latitude are given in radians.
     * <pre>
     *     {@code
     *     double[] coordinates = {-2.007, 0.645, 100000.0, -1.867, .575, 150000.0};
     *     Cartesian3[] positions = Cartesian3.fromRadiansArrayHeights(coordinates);
     *     }
     * </pre>
     * @param coordinates A list of longitude, latitude and height values. Values alternate [longitude, latitude, height, longitude, latitude, height...].
     * @return The array of positions.
     */
    @JsMethod
    public static native Cartesian3[] fromRadiansArrayHeights(double[] coordinates);

    /**
     * Returns an array of Cartesian3 positions given an array of longitude, latitude and height values where longitude and latitude are given in radians.
     * @param coordinates A list of longitude, latitude and height values. Values alternate [longitude, latitude, height, longitude, latitude, height...].
     * @param ellipsoid The ellipsoid on which the position lines. Optional. Default: Ellipsoid.WGS84.
     * @param result An array of Cartesian3 objects to store the result. Optional.
     * @return The array of positions.
     */
    @JsMethod
    public static native Cartesian3[] fromRadiansArrayHeights(double[] coordinates, Ellipsoid ellipsoid, Cartesian3[] result);

    /**
     * Converts the provided Spherical into Cartesian3 coordinates.
     * @param spherical The Spherical to be converted to Cartesian3.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian3 fromSpherical(Spherical spherical, Cartesian3 result);

    /**
     * Computes the linear interpolation or extrapolation at t using the provided cartesians.
     * @param start The value corresponding to t at 0.0.
     * @param end The value corresponding to t at 1.0.
     * @param t The point along t at which to interpolate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 lerp(Cartesian3 start, Cartesian3 end, double t, Cartesian3 result);

    /**
     * Computes the Cartesian's magnitude (length).
     * @param cartesian The Cartesian instance whose magnitude is to be computed.
     * @return The magnitude.
     */
    @JsMethod
    public static native double magnitude(Cartesian3 cartesian);

    /**
     * Computes the provided Cartesian's squared magnitude.
     * @param cartesian The Cartesian instance whose squared magnitude is to be computed.
     * @return The squared magnitude.
     */
    @JsMethod
    public static native double magnitudeSquared(Cartesian3 cartesian);

    /**
     * Compares two Cartesians and computes a Cartesian which contains the maximum components of the supplied Cartesians.
     * @param first A cartesian to compare.
     * @param second A cartesian to compare.
     * @param result The object into which to store the result.
     * @return A cartesian with the maximum components.
     */
    @JsMethod
    public static native Cartesian3 maximumByComponent(Cartesian3 first, Cartesian3 second, Cartesian3 result);

    /**
     * Computes the value of the maximum component for the supplied Cartesian.
     * @param cartesian The cartesian to use.
     * @return The value of the maximum component.
     */
    @JsMethod
    public static native double maximumComponent(Cartesian3 cartesian);

    /**
     * Compares two Cartesians and computes a Cartesian which contains the minimum components of the supplied Cartesians.
     * @param first A cartesian to compare.
     * @param second A cartesian to compare.
     * @param result The object into which to store the result.
     * @return A cartesian with the minimum components.
     */
    @JsMethod
    public static native Cartesian3 minimumByComponent(Cartesian3 first, Cartesian3 second, Cartesian3 result);

    /**
     * Computes the value of the minimum component for the supplied Cartesian.
     * @param cartesian The cartesian to use.
     * @return The value of the minimum component.
     */
    @JsMethod
    public static native double minimumComponent(Cartesian3 cartesian);

    /**
     * Returns the axis that is most orthogonal to the provided Cartesian.
     * @param cartesian The Cartesian on which to find the most orthogonal axis.
     * @param result The object onto which to store the result.
     * @return The most orthogonal axis.
     */
    @JsMethod
    public static native Cartesian3 mostOrthogonalAxis(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Multiplies the provided Cartesian componentwise by the provided scalar.
     * @param cartesian The Cartesian to be scaled.
     * @param scalar The scalar to multiply with.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 multiplyByScalar(Cartesian3 cartesian, double scalar, Cartesian3 result);

    /**
     * Computes the componentwise product of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 multiplyComponents(Cartesian3 left, Cartesian3 right, Cartesian3 result);

    /**
     * Negates the provided Cartesian.
     * @param cartesian The Cartesian to be negated.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 negate(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Computes the normalized form of the supplied Cartesian.
     * @param cartesian The Cartesian to be normalized.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 normalize(Cartesian3 cartesian, Cartesian3 result);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements. Optional.
     * @return The array that was packed into
     */
    @JsMethod
    public static native JsArrayNumber pack(Cartesian3 value, JsArrayNumber array, int startingIndex);

    /**
     * Flattens an array of Cartesian3s into and array of components.
     * @param array The array of cartesians to pack.
     * @param result The array onto which to store the result.
     * @return The packed array.
     */
    @JsMethod
    public static native JsArrayNumber packArray(Cartesian3[] array, JsArrayNumber result);

    /**
     * Computes the componentwise difference of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 subtract(Cartesian3 left, Cartesian3 right, Cartesian3 result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian3 unpack(JsArrayNumber array);
    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Optional. Default 0.
     * @param result The object into which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian3 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian3 unpack(JsArrayNumber array, int startingIndex, Cartesian3 result);

    /**
     * Unpacks an array of cartesian components into and array of Cartesian3s.
     * @param array The array of components to unpack.
     * @param result The array onto which to store the result.
     * @return The unpacked array.
     */
    @JsMethod
    public static native Cartesian3[] unpackArray(JsArrayNumber array, Cartesian3[] result);
}
