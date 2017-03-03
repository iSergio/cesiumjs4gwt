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

package org.cesiumjs.cs.scene.apperances.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Material;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PolylineMaterialAppearanceOptions {
    /**
     * When true, the geometry is expected to appear translucent so PolylineMaterialAppearance#renderState has alpha blending enabled.
     * Default: true
     */
    @JsProperty
    public boolean translucent;
    /**
     * The material used to determine the fragment color.
     * Default: {@link org.cesiumjs.cs.scene.Material#ColorType()}
     */
    @JsProperty
    public Material material;
    /**
     * Optional GLSL vertex shader source to override the default vertex shader.
     */
    @JsProperty
    public String vertexShaderSource;
    /**
     * Optional GLSL fragment shader source to override the default fragment shader.
     */
    @JsProperty
    public String fragmentShaderSource;
    /**
     * Optional render state to override the default render state.
     */
    @JsProperty
    public Object renderState;

    /**
     * Options for {@link org.cesiumjs.cs.scene.apperances.PolylineMaterialAppearance}
     */
    @JsConstructor
    public PolylineMaterialAppearanceOptions() {}
}
