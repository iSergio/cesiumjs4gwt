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

package org.cesiumjs.cs.scene.experimental;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.scene.experimental.options.CustomShaderOptions;

/**
 * A user defined GLSL shader used with {@link ModelExperimental} as well as {@link org.cesiumjs.cs.scene.Cesium3DTileset}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "CustomShader")
public class CustomShader {
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
