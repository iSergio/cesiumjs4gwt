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
@JsType(isNative = true, namespace = "Cesium", name = "HeadingPitchRoll")
public class HeadingPitchRoll {
    @JsProperty
    public double heading;
    @JsProperty
    public double pitch;
    @JsProperty
    public double roll;
    /**
     * A rotation expressed as a heading, pitch, and roll. Heading is the rotation about the negative z axis.
     * Pitch is the rotation about the negative y axis. Roll is the rotation about the positive x axis.
     */
    @JsConstructor
    public HeadingPitchRoll() {}

    /**
     * A rotation expressed as a heading, pitch, and roll. Heading is the rotation about the negative z axis.
     * Pitch is the rotation about the negative y axis. Roll is the rotation about the positive x axis.
     * @param heading The heading component in radians. Default: 0.0
     * @param pitch The pitch component in radians. Default: 0.0
     */
    @JsConstructor
    public HeadingPitchRoll(double heading, double pitch) {}

    /**
     * A rotation expressed as a heading, pitch, and roll. Heading is the rotation about the negative z axis.
     * Pitch is the rotation about the negative y axis. Roll is the rotation about the positive x axis.
     * @param heading The heading component in radians. Default: 0.0
     * @param pitch The pitch component in radians. Default: 0.0
     * @param roll The roll component in radians. Default: 0.0
     */
    @JsConstructor
    public HeadingPitchRoll(double heading, double pitch, double roll) {}

    /**
     * Duplicates a HeadingPitchRoll instance.
     * @param headingPitchRoll The HeadingPitchRoll to duplicate.
     * @return The modified result parameter or a new HeadingPitchRoll instance if one was not provided.
     * (Returns undefined if headingPitchRoll is undefined)
     */
    @JsMethod
    public static native HeadingPitchRoll clone(HeadingPitchRoll headingPitchRoll);

    /**
     * Duplicates a HeadingPitchRoll instance.
     * @param headingPitchRoll The HeadingPitchRoll to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new HeadingPitchRoll instance if one was not provided.
     * (Returns undefined if headingPitchRoll is undefined)
     */
    @JsMethod
    public static native HeadingPitchRoll clone(HeadingPitchRoll headingPitchRoll, HeadingPitchRoll result);

    /**
     * Compares the provided HeadingPitchRolls componentwise and returns true if they are equal, false otherwise.
     * @param left The first HeadingPitchRoll.
     * @param right The second HeadingPitchRoll.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(HeadingPitchRoll left, HeadingPitchRoll right);

    /**
     * Compares the provided HeadingPitchRolls componentwise and returns true if they pass an absolute or relative tolerance test, false otherwise.
     * @param left The first HeadingPitchRoll.
     * @param right The second HeadingPitchRoll.
     * @param relativeEpsilon The relative epsilon tolerance to use for equality testing.
     * @param absoluteEpsilon The absolute epsilon tolerance to use for equality testing.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public static native boolean equalsEpsilon(HeadingPitchRoll left, HeadingPitchRoll right, double relativeEpsilon, double absoluteEpsilon);

    /**
     * Returns a new HeadingPitchRoll instance from angles given in degrees.
     * @param heading the heading in degrees
     * @param pitch the pitch in degrees
     * @param roll the heading in degrees
     * @return A new HeadingPitchRoll instance
     */
    @JsMethod
    public static native HeadingPitchRoll fromDegrees(double heading, double pitch, double roll);

    /**
     * Returns a new HeadingPitchRoll instance from angles given in degrees.
     * @param heading the heading in degrees
     * @param pitch the pitch in degrees
     * @param roll the heading in degrees
     * @param result The object in which to store the result. If not provided, a new instance is created and returned.
     * @return A new HeadingPitchRoll instance
     */
    @JsMethod
    public static native HeadingPitchRoll fromDegrees(double heading, double pitch, double roll, HeadingPitchRoll result);

    /**
     * Computes the heading, pitch and roll from a quaternion (see http://en.wikipedia.org/wiki/Conversion_between_quaternions_and_Euler_angles )
     * @param quaternion The quaternion from which to retrieve heading, pitch, and roll, all expressed in radians.
     * @return The modified result parameter or a new HeadingPitchRoll instance if one was not provided.
     */
    @JsMethod
    public static native HeadingPitchRoll fromQuaternion(Quaternion quaternion);

    /**
     * Computes the heading, pitch and roll from a quaternion (see http://en.wikipedia.org/wiki/Conversion_between_quaternions_and_Euler_angles )
     * @param quaternion The quaternion from which to retrieve heading, pitch, and roll, all expressed in radians.
     * @param result The object in which to store the result. If not provided, a new instance is created and returned.
     * @return The modified result parameter or a new HeadingPitchRoll instance if one was not provided.
     */
    @JsMethod
    public static native HeadingPitchRoll fromQuaternion(Quaternion quaternion, Quaternion result);

    /**
     * The object onto which to store the result.
     * @return The modified result parameter or a new HeadingPitchRoll instance if one was not provided.
     */
    @JsMethod
    public native HeadingPitchRoll clone();

    /**
     * Compares this HeadingPitchRoll against the provided HeadingPitchRoll componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side HeadingPitchRoll.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(HeadingPitchRoll right);

    /**
     * Compares this HeadingPitchRoll against the provided HeadingPitchRoll componentwise and returns true if
     * they pass an absolute or relative tolerance test, false otherwise.
     * @param right The right hand side HeadingPitchRoll.
     * @param relativeEpsilon The relative epsilon tolerance to use for equality testing.
     * @param absoluteEpsilon The absolute epsilon tolerance to use for equality testing.
     * @return true if they are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(HeadingPitchRoll right, double relativeEpsilon, double absoluteEpsilon);

    /**
     * Creates a string representing this HeadingPitchRoll in the format '(heading, pitch, roll)' in radians.
     * @return A string representing the provided HeadingPitchRoll in the format '(heading, pitch, roll)'.
     */
    @Override
    @JsMethod
    public native String toString();
}
