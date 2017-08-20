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
@JsType(isNative = true, namespace = "Cesium", name = "Quaternion")
public class Quaternion {
    /**
     * An immutable Quaternion instance initialized to (0.0, 0.0, 0.0, 1.0).
     */
    @JsProperty(name = "IDENTITY")
    public static native Quaternion IDENTITY();
    /**
     * The number of elements used to store the object into an array in its interpolatable form.
     */
    @JsProperty
    public static int packedInterpolationLength;
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public static int packedLength;
    /**
     * An immutable Quaternion instance initialized to (0.0, 0.0, 0.0, 0.0).
     */
    @JsProperty(name = "ZERO")
    public static native Quaternion ZERO();
    /**
     * The W component.
     * Default: 0.0
     */
    @JsProperty
    public double w;
    /**
     * The X component.
     * Default: 0.0
     */
    @JsProperty
    public double x;
    /**
     * The Y component.
     * Default: 0.0
     */
    @JsProperty
    public double y;
    /**
     * The Z component.
     * Default: 0.0
     */
    @JsProperty
    public double z;

    /**
     * A set of 4-dimensional coordinates used to represent rotation in 3-dimensional space.
     */
    @JsConstructor
    public Quaternion() {}

    /**
     * A set of 4-dimensional coordinates used to represent rotation in 3-dimensional space.
     * @param x The X component.
     * @param y The Y component.
     * @param z The Z component.
     * @param w The W component.
     */
    @JsConstructor
    public Quaternion(double x, double y, double z, double w) {}

    /**
     * Computes the componentwise sum of two quaternions.
     * @param left The first quaternion.
     * @param right The second quaternion.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Quaternion add(Quaternion left, Quaternion right, Quaternion result);

    /**
     * Duplicates a Quaternion instance.
     * @param quaternion The quaternion to duplicate.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     * (Returns undefined if quaternion is undefined)
     */
    @JsMethod
    public static native Quaternion clone(Quaternion quaternion);

    /**
     * Duplicates a Quaternion instance.
     * @param quaternion The quaternion to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     * (Returns undefined if quaternion is undefined)
     */
    @JsMethod
    public static native Quaternion clone(Quaternion quaternion, Quaternion result);

    /**
     * Computes the angle of rotation of the provided quaternion.
     * @param quaternion The quaternion to use.
     * @return The angle of rotation.
     */
    @JsMethod
    public static native double computeAngle(Quaternion quaternion);

    /**
     * Computes the axis of rotation of the provided quaternion.
     * @param quaternion The quaternion to use.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 computeAxis(Quaternion quaternion, Cartesian3 result);

    /**
     * Computes an inner quadrangle point.
     * This will compute quaternions that ensure a squad curve is C1.
     * @param q0 The first quaternion.
     * @param q1 The second quaternion.
     * @param q2 The third quaternion.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     * @see #squad(Quaternion, Quaternion, Quaternion, Quaternion, float, Quaternion)
     */
    @JsMethod
    public static native Quaternion computeInnerQuadrangle(Quaternion q0, Quaternion q1, Quaternion q2, Quaternion result);

    /**
     * Computes the conjugate of the provided quaternion.
     * @param quaternion The quaternion to conjugate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Quaternion conjugate(Quaternion quaternion, Quaternion result);

    /**
     * Converts a packed array into a form suitable for interpolation.
     * @param packedArray The packed array.
     */
    public static native void convertPackedArrayForInterpolation(double[] packedArray);

    /**
     * Converts a packed array into a form suitable for interpolation.
     * @param packedArray The packed array.
     * @param startingIndex The index of the first element to be converted. Default: 0
     * @param lastIndex The index of the last element to be converted. Default: packedArray.length
     * @param result The object into which to store the result.
     */
    public static native void convertPackedArrayForInterpolation(double[] packedArray, int startingIndex, int lastIndex, double[] result);

    /**
     * Divides the provided quaternion componentwise by the provided scalar.
     * @param quaternion The quaternion to be divided.
     * @param scalar The scalar to divide by.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Quaternion divideByScalar(Quaternion quaternion, double scalar, Quaternion result);

    /**
     * Computes the dot (scalar) product of two quaternions.
     * @param left The first quaternion.
     * @param right The second quaternion.
     * @return The dot product.
     */
    @JsMethod
    public static native double dot(Quaternion left, Quaternion right);

    /**
     * Compares the provided quaternions componentwise and returns true if they are equal, false otherwise.
     * @param left The first quaternion.
     * @param right The second quaternion.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(Quaternion left, Quaternion right);

    /**
     * Compares the provided quaternions componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param left The first quaternion.
     * @param right The second quaternion.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public static native boolean equalsEpsilon(Quaternion left, Quaternion right, double epsilon);

    /**
     * The exponential quaternion function.
     * @param cartesian The cartesian.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Quaternion exp(Cartesian3 cartesian, Quaternion result);

    /**
     * Computes the spherical linear interpolation or extrapolation at t using the provided quaternions.
     * This implementation is faster than Quaternion#slerp, but is only accurate up to 10-6.
     * @param start The value corresponding to t at 0.0.
     * @param end The value corresponding to t at 1.0.
     * @param t The point along t at which to interpolate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     * @see #slerp(Quaternion, Quaternion, float, Quaternion)
     */
    @JsMethod
    public static native Quaternion fastSlerp(Quaternion start, Quaternion end, double t, Quaternion result);

    /**
     *
     * @param q0 The first quaternion.
     * @param q1 The second quaternion.
     * @param s0 The first inner quadrangle.
     * @param s1 The second inner quadrangle.
     * @param t The time in [0,1] used to interpolate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if none was provided.
     * @see #squad(Quaternion, Quaternion, Quaternion, Quaternion, float, Quaternion)
     */
    @JsMethod
    public static native Quaternion fastSquad(Quaternion q0, Quaternion q1, Quaternion s0, Quaternion s1, float t, Quaternion result);

    /**
     * Computes a quaternion representing a rotation around an axis.
     * @param axis The axis of rotation.
     * @param angle The angle in radians to rotate around the axis.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     */
    @JsMethod
    public static native Quaternion fromAxisAngle(Cartesian3 axis, double angle);

    /**
     * Computes a quaternion representing a rotation around an axis.
     * @param axis The axis of rotation.
     * @param angle The angle in radians to rotate around the axis.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     */
    @JsMethod
    public static native Quaternion fromAxisAngle(Cartesian3 axis, double angle, Quaternion result);

    /**
     * Computes a rotation from the given heading, pitch and roll angles. Heading is the rotation about the negative z axis.
     * Pitch is the rotation about the negative y axis. Roll is the rotation about the positive x axis.
     * @param hpr heading pitch roll object.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Quaternion instance if none was provided.
     */
    @JsMethod
    public static native Quaternion fromHeadingPitchRoll(HeadingPitchRoll hpr, Quaternion result);

    /**
     * Computes a Quaternion from the provided Matrix3 instance.
     * @param matrix The rotation matrix.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     * @see Matrix3#fromQuaternion(org.cesiumjs.cs.core.Quaternion)
     * @see Matrix3#fromQuaternion(org.cesiumjs.cs.core.Quaternion, org.cesiumjs.cs.core.Matrix3)
     */
    @JsMethod
    public static native Quaternion fromRotationMatrix(Matrix3 matrix);

    /**
     * Computes a Quaternion from the provided Matrix3 instance.
     * @param matrix The rotation matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     * @see Matrix3#fromQuaternion(org.cesiumjs.cs.core.Quaternion)
     * @see Matrix3#fromQuaternion(org.cesiumjs.cs.core.Quaternion, org.cesiumjs.cs.core.Matrix3)
     */
    @JsMethod
    public static native Quaternion fromRotationMatrix(Matrix3 matrix, Quaternion result);

    /**
     * Computes the inverse of the provided quaternion.
     * @param quaternion The quaternion to normalize.
     * @param result The object onto which to store the result.
     * @return  The modified result parameter.
     */
    @JsMethod
    public static native Quaternion inverse(Quaternion quaternion, Quaternion result);

    /**
     * Computes the linear interpolation or extrapolation at t using the provided quaternions.
     * @param start The value corresponding to t at 0.0.
     * @param end The value corresponding to t at 1.0.
     * @param t The point along t at which to interpolate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Quaternion lerp(Quaternion start, Quaternion end, double t, Quaternion result);

    /**
     * The logarithmic quaternion function.
     * @param quaternion The unit quaternion.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 log(Quaternion quaternion, Cartesian3 result);

    /**
     * Computes magnitude for the provided quaternion.
     * @param quaternion Quaternion	The quaternion to conjugate.
     * @return The magnitude.
     */
    @JsMethod
    public static native double magnitude(Quaternion quaternion);

    /**
     * Computes magnitude squared for the provided quaternion.
     * @param quaternion The quaternion to conjugate.
     * @return The magnitude squared.
     */
    @JsMethod
    public static native double magnitudeSquared(Quaternion quaternion);

    /**
     * Computes the product of two quaternions.
     * @param left The first quaternion.
     * @param right The second quaternion.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Quaternion multiply(Quaternion left, Quaternion right, Quaternion result);

    /**
     * Multiplies the provided quaternion componentwise by the provided scalar.
     * @param quaternion The quaternion to be scaled.
     * @param scalar The scalar to multiply with.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Quaternion multiplyByScalar(Quaternion quaternion, double scalar, Quaternion result);

    /**
     * Negates the provided quaternion.
     * @param quaternion The quaternion to be negated.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Quaternion negate(Quaternion quaternion, Quaternion result);

    /**
     * Computes the normalized form of the provided quaternion.
     * @param quaternion The quaternion to normalize.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Quaternion normalize(Quaternion quaternion, Quaternion result);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    public static native double[]  pack(Quaternion value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements. Default: 0
     * @return The array that was packed into
     */
    public static native double[]  pack(Quaternion value, double[] array, int startingIndex);

    /**
     * Computes the spherical linear interpolation or extrapolation at t using the provided quaternions.
     * @param start The value corresponding to t at 0.0.
     * @param end The value corresponding to t at 1.0.
     * @param t The point along t at which to interpolate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     * @see #fastSlerp(org.cesiumjs.cs.core.Quaternion, org.cesiumjs.cs.core.Quaternion, double, org.cesiumjs.cs.core.Quaternion)
     */
    @JsMethod
    public static native Quaternion slerp(Quaternion start, Quaternion end, float t, Quaternion result);

    /**
     * Computes the spherical quadrangle interpolation between quaternions.
     * @param q0 The first quaternion.
     * @param q1 The second quaternion.
     * @param s0 The first inner quadrangle.
     * @param s1 The second inner quadrangle.
     * @param t The time in [0,1] used to interpolate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     * @see Quaternion#computeInnerQuadrangle(org.cesiumjs.cs.core.Quaternion, org.cesiumjs.cs.core.Quaternion, org.cesiumjs.cs.core.Quaternion, org.cesiumjs.cs.core.Quaternion)
     */
    @JsMethod
    public static native Quaternion squad(Quaternion q0, Quaternion q1, Quaternion s0, Quaternion s1, float t, Quaternion result);

    /**
     * Computes the componentwise difference of two quaternions.
     * @param left The first quaternion.
     * @param right The second quaternion.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Quaternion subtract(Quaternion left, Quaternion right, Quaternion result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     */
    public static native Quaternion unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Default: 0
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     */
    public static native Quaternion unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Default: 0
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     */
    public static native Quaternion unpack(double[] array, int startingIndex, Quaternion result);

    /**
     * Retrieves an instance from a packed array converted with convertPackedArrayForInterpolation.
     * @param array The array previously packed for interpolation.
     * @param sourceArray The original packed array.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     */
    public static native Quaternion unpackInterpolationResult(double[] array, double[] sourceArray);

    /**
     * Retrieves an instance from a packed array converted with convertPackedArrayForInterpolation.
     * @param array The array previously packed for interpolation.
     * @param sourceArray The original packed array.
     * @param startingIndex The startingIndex used to convert the array. Default: 0
     * @param lastIndex The lastIndex used to convert the array. Default: packedArray.length
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     */
    public static native Quaternion unpackInterpolationResult(double[] array, double[] sourceArray, int startingIndex, int lastIndex);

    /**
     * Retrieves an instance from a packed array converted with convertPackedArrayForInterpolation.
     * @param array The array previously packed for interpolation.
     * @param sourceArray The original packed array.
     * @param startingIndex The startingIndex used to convert the array. Default: 0
     * @param lastIndex The lastIndex used to convert the array. Default: packedArray.length
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     */
    public static native Quaternion unpackInterpolationResult(double[] array, double[] sourceArray, int startingIndex, int lastIndex, Quaternion result);

    /**
     * Duplicates this Quaternion instance.
     * @return The modified result parameter or a new Quaternion instance if one was not provided.
     */
    @JsMethod
    public native Quaternion clone();

    /**
     * Compares this and the provided quaternion componentwise and returns true if they are equal, false otherwise.
     * @param right
     * @return The right hand side quaternion.
     */
    @JsMethod
    public native boolean equals(Quaternion right);

    /**
     * Compares this and the provided quaternion componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param right The right hand side quaternion.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(Quaternion right, double epsilon);

    /**
     * Returns a string representing this quaternion in the format (x, y, z, w).
     * @return A string representing this Quaternion.
     */
    @JsMethod
    public native String toString();
}
