/*
 * Copyright 2021 iserge, Gis4Fun.
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

package org.cesiumjs.cs.scene.enums;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * An enum describing the x, y, and z axes and helper conversion functions.
 */
@JsType(isNative = true, namespace = "Cesium", name = "Axis")
public class Axis {
    /**
     * Denotes the x-axis.
     */
    @JsProperty(name = "X")
    public native Number X();
    /**
     * Denotes the y-axis.
     */
    @JsProperty(name = "Y")
    public native Number Y();
    /**
     * Denotes the z-axis.
     */
    @JsProperty(name = "Z")
    public native Number Z();
}
