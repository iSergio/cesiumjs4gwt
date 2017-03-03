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
 * @see Cartesian3
 * @see Cartesian4
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cartesian2")
public class Cartesian2 implements Packable {
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
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public static int packedLength;
    /**
     * An immutable Cartesian2 instance initialized to (1.0, 0.0).
     */
    @JsProperty(name = "UNIT_X")
    public static native Cartesian2 UNIT_X();
    /**
     * An immutable Cartesian2 instance initialized to (0.0, 1.0).
     */
    @JsProperty(name = "UNIT_Y")
    public static native Cartesian2 UNIT_Y();
    /**
     * An immutable Cartesian2 instance initialized to (0.0, 0.0).
     */
    @JsProperty(name = "ZERO")
    public static native Cartesian2 ZERO();

    /**
     * A 2D Cartesian point.
     * @see Cartesian3
     * @see Cartesian4
     */
    @JsConstructor
    public Cartesian2() {}

    /**
     * A 2D Cartesian point.
     * @param x The X component. Default Value:  0.0
     * @param y The Y component. Default Value:  0.0
     * @see Cartesian3
     * @see Cartesian4
     */
    @JsConstructor
    public Cartesian2(double x, double y) {}

    /**
     * Duplicates this Cartesian2 instance.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public native Cartesian2 clone(Cartesian2 result);

    /**
     * Duplicates this Cartesian2 instance.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public native Cartesian2 clone();

    /**
     * Compares this Cartesian against the provided Cartesian componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side Cartesian. Optional.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native Cartesian2 equals(Cartesian2 right);

    /**
     * Compares this Cartesian against the provided Cartesian componentwise and returns true if they pass an absolute or
     * relative tolerance test, false otherwise.
     * @param right The right hand side Cartesian. Optional.
     * @param relativeEpsilon The relative epsilon tolerance to use for equality testing.
     * @param absoluteEpsilon The absolute epsilon tolerance to use for equality testing. Optional.
     * @return true if they are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(Cartesian2 right, double relativeEpsilon, double absoluteEpsilon);

    /**
     * Creates a string representing this Cartesian in the format '(x, y)'.
     * @return A string representing the provided Cartesian in the format '(x, y)'.
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
    public static native Cartesian2 abs(Cartesian2 cartesian, Cartesian2 result);

    /**
     * Computes the componentwise sum of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 add(Cartesian2 left, Cartesian2 right, Cartesian2 result);

    /**
     * Returns the angle, in radians, between the provided Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @return The angle between the Cartesians.
     */
    @JsMethod
    public static native double angleBetween(Cartesian2 left, Cartesian2 right);

    /**
     * Duplicates a Cartesian2 instance.
     * @param cartesian The Cartesian to duplicate.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     * (Returns undefined if cartesian is undefined)
     */
    @JsMethod
    public static native Cartesian2 clone(Cartesian2 cartesian, Cartesian2 result);

    /**
     * Computes the distance between two points.
     * <pre>
     *     Example:
     *     {@code
     *     // Returns 1.0
     *     double d = Cartesian2.distance(new Cartesian2(1.0, 0.0), new Cartesian2(2.0, 0.0));
     *     }
     * </pre>
     * @param left The first point to compute the distance from.
     * @param right The second point to compute the distance to.
     * @return The distance between two points.
     */
    @JsMethod
    public static native double distance(Cartesian2 left, Cartesian2 right);

    /**
     * Computes the squared distance between two points. Comparing squared distances using this function is more efficient
     * than comparing distances using Cartesian2#distance.
     * <pre>
     *     Example:
     *     {@code
     *     // Returns 4.0, not 2.0
     *     double d = Cartesian2.distanceSquared(new Cartesian2(1.0, 0.0), new Cartesian2(3.0, 0.0));
     *     }
     * </pre>
     * @param left The first point to compute the distance from.
     * @param right The second point to compute the distance to.
     * @return The distance between two points.
     */
    @JsMethod
    public static native double distanceSquared(Cartesian2 left, Cartesian2 right);

    /**
     * Divides the provided Cartesian componentwise by the provided scalar.
     * @param cartesian The Cartesian to be divided.
     * @param scalar The scalar to divide by.
     * @param result The object onto which to store the result.
     * @return  The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 divideByScalar(Cartesian2 cartesian, double scalar, Cartesian2 result);

    /**
     * Computes the componentwise quotient of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 divideComponents(Cartesian2 left, Cartesian2 right, Cartesian2 result);

    /**
     * Computes the dot (scalar) product of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @return The dot product.
     */
    @JsMethod
    public static native double dot(Cartesian2 left, Cartesian2 right);

    /**
     * Compares the provided Cartesians componentwise and returns true if they are equal, false otherwise.
     * @param left The first Cartesian. Optional.
     * @param right The second Cartesian. Optional.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(Cartesian2 left, Cartesian2 right);

    /**
     * Compares the provided Cartesians componentwise and returns true if they pass an absolute or relative tolerance test, false otherwise.
     * @param left The first Cartesian. Optional.
     * @param right The second Cartesian. Optional.
     * @param relativeEpsilon The relative epsilon tolerance to use for equality testing.
     * @param absoluteEpsilon The absolute epsilon tolerance to use for equality testing. Optional.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public static native boolean equalsEpsilon(Cartesian2 left, Cartesian2 right, double relativeEpsilon, double absoluteEpsilon);

    /**
     * Creates a Cartesian2 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     JsArrayNumber jsArrayNumber = JsArray.createArray().cast();
     *     jsArrayNumber.push(1);
     *     jsArrayNumber.push(2);
     *     Cartesian2 c = Cartesian2.fromArray(jsArrayNumber, 0, null);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian2 fromArray(JsArrayNumber array, Cartesian2 result);

    /**
     * Creates a Cartesian2 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     double[] array = {1, 2};
     *     Cartesian2 c = Cartesian2.fromArray(array, 0, null);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian2 fromArray(double[] array, Cartesian2 result);

    /**
     * Creates a Cartesian2 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     JsArrayNumber jsArrayNumber = JsArray.createArray().cast();
     *     jsArrayNumber.push(1);
     *     jsArrayNumber.push(2);
     *     jsArrayNumber.push(3);
     *     jsArrayNumber.push(4);
     *     Cartesian2 c = Cartesian2.fromArray(jsArrayNumber, 2, null);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param startingIndex The offset into the array of the first element, which corresponds to the x component. Optional.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian2 fromArray(JsArrayNumber array, int startingIndex, Cartesian2 result);

    /**
     * Creates a Cartesian2 from two consecutive elements in an array.
     * <pre>
     *     Example:
     *     {@code
     *     double[] array = {1, 2, 3, 4};
     *     Cartesian2 c = Cartesian2.fromArray(array, 2, null);
     *     }
     * </pre>
     * @param array The array whose two consecutive elements correspond to the x and y components, respectively.
     * @param startingIndex The offset into the array of the first element, which corresponds to the x component. Optional.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian2 fromArray(double[] array, int startingIndex, Cartesian2 result);

    /**
     * Creates a Cartesian2 instance from an existing Cartesian3. This simply takes the x and y properties of the Cartesian3 and drops z.
     * @param cartesian The Cartesian3 instance to create a Cartesian2 instance from.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian2 fromCartesian3(Cartesian3 cartesian, Cartesian2 result);

    /**
     * Creates a Cartesian2 instance from an existing Cartesian4. This simply takes the x and y properties of the Cartesian4 and drops z and w.
     * @param cartesian The Cartesian4 instance to create a Cartesian2 instance from.
     * @param result The object onto which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian2 fromCartesian4(Cartesian4 cartesian, Cartesian2 result);

    /**
     * Creates a Cartesian2 instance from x and y coordinates.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param result Cartesian2	optional The object onto which to store the result.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian2 fromElements(double x, double y, Cartesian2 result);

    /**
     * Computes the linear interpolation or extrapolation at t using the provided cartesians.
     * @param start The value corresponding to t at 0.0.
     * @param end The value corresponding to t at 1.0.
     * @param t The point along t at which to interpolate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 lerp(Cartesian2 start, Cartesian2 end, double t, Cartesian2 result);

    /**
     * Computes the Cartesian's magnitude (length).
     * @param cartesian The Cartesian instance whose magnitude is to be computed.
     * @return The magnitude.
     */
    @JsMethod
    public static native double magnitude(Cartesian2 cartesian);

    /**
     * Computes the provided Cartesian's squared magnitude.
     * @param cartesian The Cartesian instance whose squared magnitude is to be computed.
     * @return The squared magnitude.
     */
    @JsMethod
    public static native double magnitudeSquared(Cartesian2 cartesian);

    /**
     * Compares two Cartesians and computes a Cartesian which contains the maximum components of the supplied Cartesians.
     * @param first A cartesian to compare.
     * @param second A cartesian to compare.
     * @param result The object into which to store the result.
     * @return A cartesian with the maximum components.
     */
    @JsMethod
    public static native Cartesian2 maximumByComponent(Cartesian2 first, Cartesian2 second, Cartesian2 result);

    /**
     * Computes the value of the maximum component for the supplied Cartesian.
     * @param cartesian The cartesian to use.
     * @return The value of the maximum component.
     */
    @JsMethod
    public static native double maximumComponent(Cartesian2 cartesian);

    /**
     * Compares two Cartesians and computes a Cartesian which contains the minimum components of the supplied Cartesians.
     * @param first A cartesian to compare.
     * @param second A cartesian to compare.
     * @param result The object into which to store the result.
     * @return A cartesian with the minimum components.
     */
    @JsMethod
    public static native Cartesian2 minimumByComponent(Cartesian2 first, Cartesian2 second, Cartesian2 result);

    /**
     * Computes the value of the minimum component for the supplied Cartesian.
     * @param cartesian The cartesian to use.
     * @return The value of the minimum component.
     */
    @JsMethod
    public static native double minimumComponent(Cartesian2 cartesian);

    /**
     * Returns the axis that is most orthogonal to the provided Cartesian.
     * @param cartesian The Cartesian on which to find the most orthogonal axis.
     * @param result The object onto which to store the result.
     * @return The most orthogonal axis.
     */
    @JsMethod
    public static native Cartesian2 mostOrthogonalAxis(Cartesian2 cartesian, Cartesian2 result);

    /**
     * Multiplies the provided Cartesian componentwise by the provided scalar.
     * @param cartesian The Cartesian to be scaled.
     * @param scalar The scalar to multiply with.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 multiplyByScalar(Cartesian2 cartesian, double scalar, Cartesian2 result);

    /**
     * Computes the componentwise product of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 multiplyComponents(Cartesian2 left, Cartesian2 right, Cartesian2 result);

    /**
     * Negates the provided Cartesian.
     * @param cartesian The Cartesian to be negated.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 negate(Cartesian2 cartesian, Cartesian2 result);

    /**
     * Computes the normalized form of the supplied Cartesian.
     * @param cartesian The Cartesian to be normalized.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 normalize(Cartesian2 cartesian, Cartesian2 result);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements. Optional.
     * @return The array that was packed into
     */
    @JsMethod
    public static native JsArrayNumber pack(Cartesian2 value, JsArrayNumber array, int startingIndex);

    /**
     * Flattens an array of Cartesian2s into and array of components.
     * @param array The array of cartesians to pack.
     * @param result The array onto which to store the result.
     * @return The packed array.
     */
    @JsMethod
    public static native JsArrayNumber packArray(Cartesian2[] array, JsArrayNumber result);

    /**
     * Computes the componentwise difference of two Cartesians.
     * @param left The first Cartesian.
     * @param right The second Cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 subtract(Cartesian2 left, Cartesian2 right, Cartesian2 result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian2 unpack(JsArrayNumber array);
    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Optional. Default 0.
     * @param result The object into which to store the result. Optional.
     * @return The modified result parameter or a new Cartesian2 instance if one was not provided.
     */
    @JsMethod
    public static native Cartesian2 unpack(JsArrayNumber array, int startingIndex, Cartesian2 result);

    /**
     * Unpacks an array of cartesian components into and array of Cartesian2s.
     * @param array The array of components to unpack.
     * @param result The array onto which to store the result.
     * @return The unpacked array.
     */
    @JsMethod
    public static native Cartesian2[] unpackArray(JsArrayNumber array, Cartesian2[] result);
}
