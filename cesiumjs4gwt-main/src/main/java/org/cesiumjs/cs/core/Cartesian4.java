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
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @see Cartesian2
 * @see Cartesian3
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cartesian4")
public class Cartesian4 implements Packable {
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
     * The W component
     * Default Value: 0.0
     */
    @JsProperty
    public double w;
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public static int packedLength;
    /**
     * An immutable Cartesian4 instance initialized to (1.0, 0.0, 0.0, 0.0).
     */
    @JsProperty(name = "UNIT_X")
    public static native Cartesian4 UNIT_X();
    /**
     * An immutable Cartesian4 instance initialized to (0.0, 1.0, 0.0, 0.0).
     */
    @JsProperty(name = "UNIT_Y")
    public static native Cartesian4 UNIT_Y();
    /**
     * An immutable Cartesian4 instance initialized to (0.0, 0.0, 1.0, 0.0).
     */
    @JsProperty(name = "UNIT_Z")
    public static native Cartesian4 UNIT_Z();
    /**
     * An immutable Cartesian4 instance initialized to (0.0, 0.0, 0.0, 1.0).
     */
    @JsProperty(name = "UNIT_W")
    public static native Cartesian4 UNIT_W();
    /**
     * An immutable Cartesian4 instance initialized to (0.0, 0.0, 0.0, 0.0).
     */
    @JsProperty(name = "ZERO")
    public static native Cartesian4 ZERO();

    /**
     * A 3D Cartesian point.
     * @see Cartesian2
     * @see Cartesian3
     */
    @JsConstructor
    public Cartesian4() {}

    /**
     * A 3D Cartesian point.
     * @param x The X component. Default Value: 0.0
     * @param y The Y component. Default Value: 0.0
     * @param z The Z component. Default Value: 0.0
     * @param w The W component. Default Value: 0.0
     * @see Cartesian2
     * @see Cartesian3
     */
    @JsConstructor
    public Cartesian4(double x, double y, double z, double w) {}

    /**
     * Duplicates this Cartesian4 instance.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public native Cartesian4 clone(Cartesian4 result);

    /**
     * Duplicates this Cartesian4 instance.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public native Cartesian4 clone();

    /**
     * Compares this Cartesian against the provided Cartesian componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side Cartesian. Optional.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native Cartesian4 equals(Cartesian4 right);

    /**
     * Compares this Cartesian against the provided Cartesian componentwise and returns true if they pass an absolute or
     * relative tolerance test, false otherwise.
     * @param right The right hand side Cartesian. Optional.
     * @param relativeEpsilon The relative epsilon tolerance to use for equality testing.
     * @param absoluteEpsilon The absolute epsilon tolerance to use for equality testing. Optional.
     * @return true if they are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(Cartesian4 right, double relativeEpsilon, double absoluteEpsilon);

    /**
     * Creates a string representing this Cartesian in the format '(x, y, z, w)'.
     * @return A string representing the provided Cartesian in the format '(x, y, z, w)'.
     */
    @Override
    @JsMethod
    public native String toString();

    /**
     * Computes the absolute value of the provided Cartesian.
     * @param cartesian The Cartesian whose absolute value is to be computed.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 abs(Cartesian4 cartesian, Cartesian4 result);

    /**
     * Computes the componentwise sum of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 add(Cartesian4 left, Cartesian4 right, Cartesian4 result);

    /**
     * Duplicates a Cartesian4 instance.
     * @param cartesian The Cartesian to duplicate.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     * (Returns undefined if cartesian is undefined)
     */
    @JsMethod
    public static native Cartesian4 clone(Cartesian4 cartesian, Cartesian4 result);

    /**
     * Computes the distance between two points.
     * <pre>
     *     Example:
     *     {@code
     *     // Returns 1.0
     *     double d = Cartesian4.distance(new Cartesian4(1.0, 0.0, 0.0, 0.0), new Cartesian4(2.0, 0.0, 0.0, 0.0));
     *     }
     * </pre>
     * @param left The first point to compute the distance from.
     * @param right The second point to compute the distance to.
     * @return The distance between two points.
     */
    @JsMethod
    public static native double distance(Cartesian4 left, Cartesian4 right);

    /**
     * Computes the squared distance between two points. Comparing squared distances using this function is more efficient
     * than comparing distances using Cartesian4#distance.
     * <pre>
     *     Example:
     *     {@code
     *     // Returns 4.0, not 2.0
     *     double d = Cartesian4.distanceSquared(new Cartesian4(1.0, 0.0, 0.0, 0.0), new Cartesian4(3.0, 0.0, 0.0, 0.0));
     *     }
     * </pre>
     * @param left The first point to compute the distance from.
     * @param right The second point to compute the distance to.
     * @return The distance between two points.
     */
    @JsMethod
    public static native double distanceSquared(Cartesian4 left, Cartesian4 right);

    /**
     * Divides the provided Cartesian componentwise by the provided scalar.
     * @param cartesian The Cartesian to be divided.
     * @param scalar The scalar to divide by.
     * @param result The object onto which to store the result.
     * @return  The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 divideByScalar(Cartesian4 cartesian, double scalar, Cartesian4 result);

    /**
     * Computes the componentwise quotient of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 divideComponents(Cartesian4 left, Cartesian4 right, Cartesian4 result);

    /**
     * Computes the dot (scalar) product of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @return The dot product.
     */
    @JsMethod
    public static native double dot(Cartesian4 left, Cartesian4 right);

    /**
     * Compares the provided Cartesians componentwise and returns true if they are equal, false otherwise.
     * @param left The first Cartesian. Optional.
     * @param right The second Cartesian. Optional.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(Cartesian4 left, Cartesian4 right);

    /**
     * Compares the provided Cartesians componentwise and returns true if they pass an absolute or relative tolerance test, false otherwise.
     * @param left The first Cartesian. Optional.
     * @param right The second Cartesian. Optional.
     * @param relativeEpsilon The relative epsilon tolerance to use for equality testing.
     * @param absoluteEpsilon The absolute epsilon tolerance to use for equality testing. Optional.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public static native boolean equalsEpsilon(Cartesian4 left, Cartesian4 right, double relativeEpsilon, double absoluteEpsilon);

    /**
     * Creates a Cartesian4 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     // Create a Cartesian4 with (1.0, 2.0, 3.0, 4.0)
     *     double[] v = {1.0, 2.0, 3.0, 4.0};
     *     Cartesian4 p = Cartesian4.fromArray(v);
     *     // Create a Cartesian4 with (1.0, 2.0, 3.0, 4.0) using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 2.0, 3.0, 4.0};
     *     Cartesian4 p2 = Cartesian4.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian4 fromArray(double[] array, Cartesian4 result);

    /**
     * Creates a Cartesian4 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     // Create a Cartesian4 with (1.0, 2.0, 3.0, 4.0)
     *     double[] v = {1.0, 2.0, 3.0, 4.0};
     *     Cartesian4 p = Cartesian4.fromArray(v);
     *     // Create a Cartesian4 with (1.0, 2.0, 3.0, 4.0) using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 2.0, 3.0, 4.0};
     *     Cartesian4 p2 = Cartesian4.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian4 fromArray(double[] array);

    /**
     * Creates a Cartesian4 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     // Create a Cartesian4 with (1.0, 2.0, 3.0, 4.0)
     *     double[] v = {1.0, 2.0, 3.0, 4.0};
     *     Cartesian4 p = Cartesian4.fromArray(v);
     *     // Create a Cartesian4 with (1.0, 2.0, 3.0, 4.0) using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 2.0, 3.0, 4.0};
     *     Cartesian4 p2 = Cartesian4.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param startingIndex The offset into the array of the first element, which corresponds to the x component. Optional.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian4 fromArray(double[] array, int startingIndex, Cartesian4 result);

    /**
     * Creates a Cartesian4 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     // Create a Cartesian4 with (1.0, 2.0, 3.0, 4.0)
     *     double[] v = {1.0, 2.0, 3.0, 4.0};
     *     Cartesian4 p = Cartesian4.fromArray(v);
     *     // Create a Cartesian4 with (1.0, 2.0, 3.0, 4.0) using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 2.0, 3.0, 4.0};
     *     Cartesian4 p2 = Cartesian4.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param startingIndex The offset into the array of the first element, which corresponds to the x component. Optional.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian4 fromArray(double[] array, int startingIndex);

    /**
     * Creates a Cartesian4 instance from a Color. red, green, blue, and alpha map to x, y, z, and w, respectively.
     * @param color The source color.
     * @param result The object onto which to store the result. Otional.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian4 fromColor(Color color, Cartesian4 result);

    /**
     * Creates a Cartesian4 instance from a Color. red, green, blue, and alpha map to x, y, z, and w, respectively.
     * @param color The source color.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian4 fromColor(Color color);

    /**
     * Creates a Cartesian4 instance from x and y coordinates.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param z The z coordinate.
     * @param w The w coordinate.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian4 fromElements(double x, double y, double z, double w);

    /**
     * Creates a Cartesian4 instance from x and y coordinates.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param z The z coordinate.
     * @param w The w coordinate.
     * @param result Cartesian4	optional The object onto which to store the result.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian4 fromElements(double x, double y, double z, double w, Cartesian4 result);

    /**
     * Computes the linear interpolation or extrapolation at t using the provided cartesians.
     * @param start The value corresponding to t at 0.0.
     * @param end The value corresponding to t at 1.0.
     * @param t The point along t at which to interpolate.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 lerp(Cartesian4 start, Cartesian4 end, double t);

    /**
     * Computes the linear interpolation or extrapolation at t using the provided cartesians.
     * @param start The value corresponding to t at 0.0.
     * @param end The value corresponding to t at 1.0.
     * @param t The point along t at which to interpolate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 lerp(Cartesian4 start, Cartesian4 end, double t, Cartesian4 result);

    /**
     * Computes the Cartesian's magnitude (length).
     * @param cartesian The Cartesian instance whose magnitude is to be computed.
     * @return The magnitude.
     */
    @JsMethod
    public static native double magnitude(Cartesian4 cartesian);

    /**
     * Computes the provided Cartesian's squared magnitude.
     * @param cartesian The Cartesian instance whose squared magnitude is to be computed.
     * @return The squared magnitude.
     */
    @JsMethod
    public static native double magnitudeSquared(Cartesian4 cartesian);

    /**
     * Compares two Cartesians and computes a Cartesian which contains the maximum components of the supplied Cartesians.
     * @param first A cartesian to compare.
     * @param second A cartesian to compare.
     * @return A cartesian with the maximum components.
     */
    @JsMethod
    public static native Cartesian4 maximumByComponent(Cartesian4 first, Cartesian4 second);

    /**
     * Compares two Cartesians and computes a Cartesian which contains the maximum components of the supplied Cartesians.
     * @param first A cartesian to compare.
     * @param second A cartesian to compare.
     * @param result The object into which to store the result.
     * @return A cartesian with the maximum components.
     */
    @JsMethod
    public static native Cartesian4 maximumByComponent(Cartesian4 first, Cartesian4 second, Cartesian4 result);

    /**
     * Computes the value of the maximum component for the supplied Cartesian.
     * @param cartesian The cartesian to use.
     * @return The value of the maximum component.
     */
    @JsMethod
    public static native double maximumComponent(Cartesian4 cartesian);

    /**
     * Compares two Cartesians and computes a Cartesian which contains the minimum components of the supplied Cartesians.
     * @param first A cartesian to compare.
     * @param second A cartesian to compare.
     * @return A cartesian with the minimum components.
     */
    @JsMethod
    public static native Cartesian4 minimumByComponent(Cartesian4 first, Cartesian4 second);

    /**
     * Compares two Cartesians and computes a Cartesian which contains the minimum components of the supplied Cartesians.
     * @param first A cartesian to compare.
     * @param second A cartesian to compare.
     * @param result The object into which to store the result.
     * @return A cartesian with the minimum components.
     */
    @JsMethod
    public static native Cartesian4 minimumByComponent(Cartesian4 first, Cartesian4 second, Cartesian4 result);

    /**
     * Computes the value of the minimum component for the supplied Cartesian.
     * @param cartesian The cartesian to use.
     * @return The value of the minimum component.
     */
    @JsMethod
    public static native double minimumComponent(Cartesian4 cartesian);

    /**
     * Returns the axis that is most orthogonal to the provided Cartesian.
     * @param cartesian The Cartesian on which to find the most orthogonal axis.
     * @return The most orthogonal axis.
     */
    @JsMethod
    public static native Cartesian4 mostOrthogonalAxis(Cartesian4 cartesian);

    /**
     * Returns the axis that is most orthogonal to the provided Cartesian.
     * @param cartesian The Cartesian on which to find the most orthogonal axis.
     * @param result The object onto which to store the result.
     * @return The most orthogonal axis.
     */
    @JsMethod
    public static native Cartesian4 mostOrthogonalAxis(Cartesian4 cartesian, Cartesian4 result);

    /**
     * Multiplies the provided Cartesian componentwise by the provided scalar.
     * @param cartesian The Cartesian to be scaled.
     * @param scalar The scalar to multiply with.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 multiplyByScalar(Cartesian4 cartesian, double scalar);

    /**
     * Multiplies the provided Cartesian componentwise by the provided scalar.
     * @param cartesian The Cartesian to be scaled.
     * @param scalar The scalar to multiply with.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 multiplyByScalar(Cartesian4 cartesian, double scalar, Cartesian4 result);

    /**
     * Computes the componentwise product of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 multiplyComponents(Cartesian4 left, Cartesian4 right);

    /**
     * Computes the componentwise product of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 multiplyComponents(Cartesian4 left, Cartesian4 right, Cartesian4 result);

    /**
     * Negates the provided Cartesian.
     * @param cartesian The Cartesian to be negated.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 negate(Cartesian4 cartesian);

    /**
     * Negates the provided Cartesian.
     * @param cartesian The Cartesian to be negated.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 negate(Cartesian4 cartesian, Cartesian4 result);

    /**
     * Computes the normalized form of the supplied Cartesian.
     * @param cartesian The Cartesian to be normalized.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 normalize(Cartesian4 cartesian);

    /**
     * Computes the normalized form of the supplied Cartesian.
     * @param cartesian The Cartesian to be normalized.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 normalize(Cartesian4 cartesian, Cartesian4 result);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Cartesian4 value);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements. Optional.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Cartesian4 value, double[] array, int startingIndex);

    /**
     * Flattens an array of Cartesian4s into and array of components.
     * @param array The array of cartesians to pack.
     * @return The packed array.
     */
    @JsMethod
    public static native double[] packArray(Cartesian4[] array);

    /**
     * Flattens an array of Cartesian4s into and array of components.
     * @param array The array of cartesians to pack.
     * @param result The array onto which to store the result.
     * @return The packed array.
     */
    @JsMethod
    public static native double[] packArray(Cartesian4[] array, double[] result);

    /**
     * Computes the componentwise difference of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 subtract(Cartesian4 left, Cartesian4 right);

    /**
     * Computes the componentwise difference of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 subtract(Cartesian4 left, Cartesian4 right, Cartesian4 result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian4 unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Optional. Default 0.
     * @param result The object into which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian4 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian4 unpack(double[] array, int startingIndex, Cartesian4 result);

    /**
     * Unpacks an array of cartesian components into and array of Cartesian4s.
     * @param array The array of components to unpack.
     * @return The unpacked array.
     */
    @JsMethod
    public static native Cartesian4[] unpackArray(JsArrayNumber array);

    /**
     * Unpacks an array of cartesian components into and array of Cartesian4s.
     * @param array The array of components to unpack.
     * @param result The array onto which to store the result.
     * @return The unpacked array.
     */
    @JsMethod
    public static native Cartesian4[] unpackArray(JsArrayNumber array, Cartesian4[] result);
}
