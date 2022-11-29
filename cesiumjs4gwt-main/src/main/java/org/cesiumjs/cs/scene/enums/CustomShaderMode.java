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

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.CustomShader;

/**
 * An enum describing how the {@link CustomShader} will be added to the fragment shader.
 * This determines how the shader interacts with the material.
 */
@JsType(isNative = true, namespace = "Cesium", name = "CustomShaderMode")
public class CustomShaderMode {
    /**
     * The custom shader will be used to modify the results of the material stage before lighting is applied.
     */
    @JsProperty(name = "MODIFY_MATERIAL")
    public static native String MODIFY_MATERIAL();
    /**
     * The custom shader will be used instead of the material stage. This is a hint to optimize out the material processing code.
     */
    @JsProperty(name = "REPLACE_MATERIAL")
    public static native String REPLACE_MATERIAL();
}
