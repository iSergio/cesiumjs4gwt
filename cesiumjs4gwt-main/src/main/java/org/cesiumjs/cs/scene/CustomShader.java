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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.enums.CustomShaderTranslucencyMode;
import org.cesiumjs.cs.scene.options.CustomShaderOptions;

/**
 * A user defined GLSL shader used with {@link Model} as well as {@link org.cesiumjs.cs.scene.Cesium3DTileset}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "CustomShader")
public class CustomShader {
    /**
     * The user-defined GLSL code for the fragment shader
     */
    @JsProperty(name = "fragmentShaderText")
    public native String fragmentShaderText();
    /**
     * The lighting model to use when using the custom shader. This is used by CustomShaderPipelineStage
     */
    @JsProperty(name = "lightingModel")
    public native Number lightingModel();
    /**
     * A value determining how the custom shader interacts with the overall fragment shader. This is used by CustomShaderPipelineStage
     */
    @JsProperty(name = "mode")
    public native Number mode();
    /**
     * The translucency mode, which determines how the custom shader will be applied. If the value is
     * {@link CustomShaderTranslucencyMode#OPAQUE} or {@link CustomShaderTranslucencyMode#TRANSLUCENT}, the custom shader will
     * override settings from the model's material. If the value is {@link CustomShaderTranslucencyMode#INHERIT},
     * the custom shader will render as either opaque or translucent depending on the primitive's material settings.
     * Default: {@link CustomShaderTranslucencyMode#INHERIT()}
     */
    @JsProperty(name = "translucencyMode")
    public native Number translucencyMode();
    /**
     * Additional uniforms as declared by the user.
     */
    @JsProperty(name = "uniforms")
    public native JsObject uniforms();
    /**
     * Additional varyings as declared by the user. This is used by CustomShaderPipelineStage
     */
    @JsProperty(name = "varyings")
    public native JsObject varyings();
    /**
     * The user-defined GLSL code for the vertex shader
     */
    @JsProperty(name = "vertexShaderText")
    public native String vertexShaderText();

    @JsConstructor
    public CustomShader(CustomShaderOptions options) {}

    @JsConstructor
    public CustomShader() {}

    /**
     * Update the value of a uniform declared in the shader
     * @param uniformName The GLSL name of the uniform. This must match one of the uniforms declared in the constructor
     * @param value The new value of the uniform.
     */
    @JsMethod
    public native void setUniform(String uniformName, boolean value);

    /**
     * Update the value of a uniform declared in the shader
     * @param uniformName The GLSL name of the uniform. This must match one of the uniforms declared in the constructor
     * @param value The new value of the uniform.
     */
    @JsMethod
    public native void setUniform(String uniformName, Number value);

    /**
     * Update the value of a uniform declared in the shader
     * @param uniformName The GLSL name of the uniform. This must match one of the uniforms declared in the constructor
     * @param value The new value of the uniform.
     */
    @JsMethod
    public native void setUniform(String uniformName, Cartesian2 value);

    /**
     * Update the value of a uniform declared in the shader
     * @param uniformName The GLSL name of the uniform. This must match one of the uniforms declared in the constructor
     * @param value The new value of the uniform.
     */
    @JsMethod
    public native void setUniform(String uniformName, Cartesian3 value);

    /**
     * Update the value of a uniform declared in the shader
     * @param uniformName The GLSL name of the uniform. This must match one of the uniforms declared in the constructor
     * @param value The new value of the uniform.
     */
    @JsMethod
    public native void setUniform(String uniformName, Cartesian4 value);

    /**
     * Update the value of a uniform declared in the shader
     * @param uniformName The GLSL name of the uniform. This must match one of the uniforms declared in the constructor
     * @param value The new value of the uniform.
     */
    @JsMethod
    public native void setUniform(String uniformName, Matrix2 value);

    /**
     * Update the value of a uniform declared in the shader
     * @param uniformName The GLSL name of the uniform. This must match one of the uniforms declared in the constructor
     * @param value The new value of the uniform.
     */
    @JsMethod
    public native void setUniform(String uniformName, Matrix3 value);

    /**
     * Update the value of a uniform declared in the shader
     * @param uniformName The GLSL name of the uniform. This must match one of the uniforms declared in the constructor
     * @param value The new value of the uniform.
     */
    @JsMethod
    public native void setUniform(String uniformName, Matrix4 value);

    /**
     * Update the value of a uniform declared in the shader
     * @param uniformName The GLSL name of the uniform. This must match one of the uniforms declared in the constructor
     * @param value The new value of the uniform.
     */
    @JsMethod
    public native void setUniform(String uniformName, String value);

    /**
     * Update the value of a uniform declared in the shader
     * @param uniformName The GLSL name of the uniform. This must match one of the uniforms declared in the constructor
     * @param value The new value of the uniform.
     */
    @JsMethod
    public native void setUniform(String uniformName, Resource value);
}
