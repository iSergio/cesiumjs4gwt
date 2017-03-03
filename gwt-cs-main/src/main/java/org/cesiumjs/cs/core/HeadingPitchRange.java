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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "HeadingPitchRange")
public class HeadingPitchRange {
    /**
     * Heading is the rotation from the local north direction where a positive angle is increasing eastward.
     */
    @JsProperty
    public double heading;
    /**
     * Pitch is the rotation from the local xy-plane. Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     */
    @JsProperty
    public double pitch;
    /**
     * Range is the distance from the center of the local frame.
     */
    @JsProperty
    public double range;

    /**
     * Defines a heading angle, pitch angle, and range in a local frame. Heading is the rotation from the local north
     * direction where a positive angle is increasing eastward. Pitch is the rotation from the local xy-plane.
     * Positive pitch angles are above the plane. Negative pitch angles are below the plane. Range is the distance from the center of the frame.
     */
    @JsConstructor
    public HeadingPitchRange() {}

    /**
     * Defines a heading angle, pitch angle, and range in a local frame. Heading is the rotation from the local north
     * direction where a positive angle is increasing eastward. Pitch is the rotation from the local xy-plane.
     * Positive pitch angles are above the plane. Negative pitch angles are below the plane. Range is the distance from the center of the frame.
     * @param heading The heading angle in radians. Default: 0.0
     * @param pitch The pitch angle in radians. Default: 0.0
     * @param range The distance from the center in meters. Default: 0.0
     */
    @JsConstructor
    public HeadingPitchRange(double heading, double pitch, double range) {}

    /**
     * Duplicates a HeadingPitchRange instance.
     * @param hpr The HeadingPitchRange to duplicate.
     * @return The modified result parameter or a new HeadingPitchRange instance if one was not provided.
     * (Returns undefined if hpr is undefined)
     */
    public static native HeadingPitchRange clone(HeadingPitchRange hpr);

    /**
     * Duplicates a HeadingPitchRange instance.
     * @param hpr The HeadingPitchRange to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new HeadingPitchRange instance if one was not provided.
     * (Returns undefined if hpr is undefined)
     */
    public static native HeadingPitchRange clone(HeadingPitchRange hpr, HeadingPitchRange result);
}
