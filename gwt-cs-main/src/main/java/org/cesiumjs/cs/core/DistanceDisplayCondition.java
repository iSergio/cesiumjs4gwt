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
@JsType(isNative = true, namespace = "Cesium", name = "DistanceDisplayCondition")
public class DistanceDisplayCondition {
    /**
     * The largest distance in the interval where the object is visible.
     * Default: Double#MAX_VALUE
     */
    @JsProperty
    public double far;
    /**
     * The smallest distance in the interval where the object is visible.
     * Default:  0.0
     */
    @JsProperty
    public double near;

    @JsConstructor
    public DistanceDisplayCondition() {}

    /**
     * Determines visibility based on the distance to the camera.
     * @param near The smallest distance in the interval where the object is visible. Default: 0.0.
     * @param far The largest distance in the interval where the object is visible. Default: {@link Double#MAX_VALUE}
     */
    @JsConstructor
    public DistanceDisplayCondition(double near, double far) {}

    /**
     * Duplicates a distance display condition instance.
     * @param value The distance display condition to duplicate.
     * @param result The result onto which to store the result.
     * @return The duplicated instance.
     */
    @JsMethod
    public static native DistanceDisplayCondition clone(DistanceDisplayCondition value, DistanceDisplayCondition result);

    /**
     * Determines if two distance display conditions are equal.
     * @param left A distance display condition.
     * @param right Another distance display condition.
     * @return Whether the two distance display conditions are equal.
     */
    @JsMethod
    public static native boolean equals(DistanceDisplayCondition left, DistanceDisplayCondition right);

    /**
     * Duplicates this instance.
     * @return The duplicated instance.
     */
    @JsMethod
    public native DistanceDisplayCondition clone();

    /**
     * Duplicates this instance.
     * @param result The result onto which to store the result.
     * @return The duplicated instance.
     */
    @JsMethod
    public native DistanceDisplayCondition clone(DistanceDisplayCondition result);

    /**
     * Determines if this distance display condition is equal to another.
     * @param other Another distance display condition.
     * @return Whether this distance display condition is equal to the other.
     */
    @JsMethod
    public native boolean equals(DistanceDisplayCondition other);
}
