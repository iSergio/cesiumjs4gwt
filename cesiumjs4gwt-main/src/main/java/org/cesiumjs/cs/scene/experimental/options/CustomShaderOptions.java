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

package org.cesiumjs.cs.scene.experimental.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CustomShaderOptions {
    /**
     * The custom shader mode, which determines how the custom shader code is inserted into the fragment shader.
     * Default: {@link org.cesiumjs.cs.scene.experimental.enums.CustomShaderMode#MODIFY_MATERIAL()}
     */
    @JsProperty
    public String mode;
    /**
     * The lighting model (e.g. PBR or unlit). If present, this overrides the default lighting for the model.
     */
    @JsProperty
    public Number lightingModel;
    /**
     * If set, the model will be rendered as translucent. This overrides the default settings for the model.
     * Default: false
     */
    @JsProperty
    public boolean isTranslucent;
//    uniforms	Object.<String, UniformSpecifier>		optional A dictionary for user-defined uniforms. The key is the uniform name that will appear in the GLSL code. The value is an object that describes the uniform type and initial value
//    varyings	Object.<String, VaryingType>		optional A dictionary for declaring additional GLSL varyings used in the shader. The key is the varying name that will appear in the GLSL code. The value is the data type of the varying. For each varying, the declaration will be added to the top of the shader automatically. The caller is responsible for assigning a value in the vertex shader and using the value in the fragment shader.
    /**
     * The custom vertex shader as a string of GLSL code. It must include a GLSL function called vertexMain. See the
     * example for the expected signature. If not specified, the custom vertex shader step will be skipped in
     * the computed vertex shader.
     */
    @JsProperty
    public String vertexShaderText;
    /**
     * The custom fragment shader as a string of GLSL code. It must include a GLSL function called fragmentMain. See the
     * example for the expected signature. If not specified, the custom fragment shader step will be skipped in the
     * computed fragment shader.
     */
    @JsProperty
    public String fragmentShaderText;

    @JsConstructor
    public CustomShaderOptions() {}
}
