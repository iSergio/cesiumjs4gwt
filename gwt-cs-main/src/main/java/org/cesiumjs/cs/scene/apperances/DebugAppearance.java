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

package org.cesiumjs.cs.scene.apperances;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.apperances.options.DebugAppearanceOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "DebugAppearance")
public class DebugAppearance extends Appearance {
    /**
     * The name of the attribute being visualized.
     */
    @JsProperty(name = "attributeName")
    public native String attributeName();
    /**
     * The GLSL datatype of the attribute being visualized.
     */
    @JsProperty(name = "glslDatatype")
    public native String glslDatatype();

    /**
     * Visualizes a vertex attribute by displaying it as a color for debugging.
     * Components for well-known unit-length vectors, i.e., normal, binormal, and tangent, are scaled and biased from [-1.0, 1.0] to (-1.0, 1.0).
     */
    @JsConstructor
    public DebugAppearance() {}

    /**
     * Visualizes a vertex attribute by displaying it as a color for debugging.
     * Components for well-known unit-length vectors, i.e., normal, binormal, and tangent, are scaled and biased from [-1.0, 1.0] to (-1.0, 1.0).
     * @param options {@link DebugAppearanceOptions}
     */
    @JsConstructor
    public DebugAppearance(DebugAppearanceOptions options) {}
}
