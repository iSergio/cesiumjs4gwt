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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Defines how per-feature colors set from the Cesium API or declarative styling blend with the source colors from
 * the original feature, e.g. glTF material or per-point color in the tile.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cesium3DTileColorBlendMode")
public class Cesium3DTileColorBlendMode {
    /**
     * Multiplies the source color by the feature color.
     */
    @JsProperty(name = "HIGHLIGHT")
    public static native Number HIGHLIGHT();
    /**
     * Blends the source color and feature color together.
     */
    @JsProperty(name = "MIX")
    public static native Number MIX();
    /**
     * Replaces the source color with the feature color.
     */
    @JsProperty(name = "REPLACE")
    public static native Number REPLACE();

    @JsConstructor
    private Cesium3DTileColorBlendMode() {}
}
