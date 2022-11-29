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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.enums.CustomShaderMode;
import org.cesiumjs.cs.scene.enums.CustomShaderTranslucencyMode;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CustomShaderOptions {
    /**
     * The custom shader mode, which determines how the custom shader code is inserted into the fragment shader.
     * Default: {@link CustomShaderMode#MODIFY_MATERIAL()}
     */
    @JsProperty
    public String mode;
    /**
     * The lighting model (e.g. PBR or unlit). If present, this overrides the default lighting for the model.
     */
    @JsProperty
    public Number lightingModel;
    /**
     * The translucency mode, which determines how the custom shader will be applied. If the value
     * is {@link CustomShaderTranslucencyMode#OPAQUE} or {@link CustomShaderTranslucencyMode#TRANSLUCENT}, the custom shader will
     * override settings from the model's material. If the value is {@link CustomShaderTranslucencyMode#INHERIT}, the custom shader will render as either opaque or translucent depending on the primitive's material settings.
     * Default: {@link CustomShaderTranslucencyMode#INHERIT()}
     */
    @JsProperty
    public Number translucencyMode;
    /**
     * A dictionary for user-defined uniforms. The key is the uniform name that will appear in the GLSL code.
     * The value is an object that describes the uniform type and initial value
     */
    @JsProperty
    public JsObject uniforms;
    /**
     * A dictionary for declaring additional GLSL varyings used in the shader. The key is the varying name that will
     * appear in the GLSL code. The value is the data type of the varying. For each varying, the declaration will be
     * added to the top of the shader automatically. The caller is responsible for assigning a value in the vertex
     * shader and using the value in the fragment shader.
     */
    @JsProperty
    public JsObject varyings;
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

    @JsOverlay
    public final CustomShaderOptions setMode(String mode) {
        this.mode = mode;
        return this;
    }

    @JsOverlay
    public final CustomShaderOptions setLightingModel(Number lightingModel) {
        this.lightingModel = lightingModel;
        return this;
    }

    @JsOverlay
    public final CustomShaderOptions setTranslucencyMode(Number translucencyMode) {
        this.translucencyMode = translucencyMode;
        return this;
    }

    @JsOverlay
    public final CustomShaderOptions addUniform(String name, String type, Object value) {
        if (this.uniforms == JsObject.undefined()) {
            this.uniforms = JsObject.create();
        }
        JsObject uniform = JsObject.create();
        uniform.setProperty("type", type);
        uniform.setProperty("value", value);

        JsObject.setProperty(uniforms, name, uniform);

        return this;
    }

    @JsOverlay
    public final CustomShaderOptions addVarying(String name, String type) {
        if (this.varyings == JsObject.undefined()) {
            this.varyings = JsObject.create();
        }
        JsObject.setProperty(this.varyings, name, type);

        return this;
    }

    @JsOverlay
    public final CustomShaderOptions setVertexShaderText(String vertexShaderText) {
        this.vertexShaderText = vertexShaderText;
        return this;
    }

    @JsOverlay
    public final CustomShaderOptions setFragmentShaderText(String fragmentShaderText) {
        this.fragmentShaderText = fragmentShaderText;
        return this;
    }
}
