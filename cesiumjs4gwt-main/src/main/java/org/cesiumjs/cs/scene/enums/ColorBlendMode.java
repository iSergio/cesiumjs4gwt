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

package org.cesiumjs.cs.scene.enums;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ColorBlendMode")
public class ColorBlendMode {
    /**
     * Multiplies the source color by the target color
     */
    @JsProperty(name = "HIGHLIGHT")
    public static native Number HIGHLIGHT();
    /**
     * Replaces the source color with the target color
     */
    @JsProperty(name = "REPLACE")
    public static native Number REPLACE();
    /**
     * Blends the source color and target color together
     */
    @JsProperty(name = "MIX")
    public static native Number MIX();

    /**
     * Defines different modes for blending between a target color and a primitive's source color.
     */
    private ColorBlendMode() {}
}
