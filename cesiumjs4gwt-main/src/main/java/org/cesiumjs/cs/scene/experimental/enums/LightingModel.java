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

package org.cesiumjs.cs.scene.experimental.enums;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The lighting model to use for lighting a ModelExperimental.
 */
@JsType(isNative = true, namespace = "Cesium", name = "LightingModel")
public class LightingModel {
    /**
     * Use unlit shading, i.e. skip lighting calculations. The model's diffuse color (assumed to be linear RGB, not sRGB)
     * is used directly when computing gl_FragColor. The alpha mode is still applied.
     */
    @JsProperty(name = "UNLIT")
    public static native Number UNLIT();
    /**
     * Use physically-based rendering lighting calculations. This includes both PBR metallic roughness and PBR specular
     * glossiness. Image-based lighting is also applied when possible.
     */
    @JsProperty(name = "PBR")
    public static native Number PBR();
}
