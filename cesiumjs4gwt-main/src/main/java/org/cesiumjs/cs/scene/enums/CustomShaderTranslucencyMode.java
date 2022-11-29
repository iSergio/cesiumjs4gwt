/*
 * Copyright 2022 iSergio, Gis4Fun.
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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * An enum for controling how {@link org.cesiumjs.cs.scene.CustomShader} handles translucency compared with the original primitive.
 */
@JsType(isNative = true, namespace = "Cesium", name = "CustomShaderTranslucencyMode")
public class CustomShaderTranslucencyMode {
    /**
     * Inherit translucency settings from the primitive's material. If the primitive used a translucent material,
     * the custom shader will also be considered translucent. If the primitive used an opaque material,
     * the custom shader will be considered opaque.
     */
    @JsProperty(name = "INHERIT")
    public static native Number INHERIT();
    /**
     * Force the primitive to render the primitive as opaque, ignoring any material settings.
     */
    @JsProperty(name = "OPAQUE")
    public static native Number OPAQUE();
    /**
     * Force the primitive to render the primitive as translucent, ignoring any material settings.
     */
    @JsProperty(name = "TRANSLUCENT")
    public static native Number TRANSLUCENT();
}
