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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Material;
import org.cesiumjs.cs.scene.apperances.options.AppearanceOptions;

/**
 * An appearance defines the full GLSL vertex and fragment shaders and the render state used to draw a Primitive.
 * All appearances implement this base Appearance interface.
 * @see MaterialAppearance
 * @see EllipsoidSurfaceAppearance
 * @see PerInstanceColorAppearance
 * @see DebugAppearance
 * @see PolylineColorAppearance
 * @see PolylineMaterialAppearance
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Appearance")
public class Appearance {
    /**
     * When true, the geometry is expected to be closed.
     * Default: false
     */
    @JsProperty(name = "closed")
    public native boolean closed();
    /**
     * The GLSL source code for the fragment shader. The full fragment shader source is built procedurally taking into
     * account the {@link #material}. Use {@link Appearance#getFragmentShaderSource()} to get the full source.
     */
    @JsProperty(name = "fragmentShaderSource")
    public native String fragmentShaderSource();
    /**
     * The material used to determine the fragment color. Unlike other Appearance properties, this is not read-only,
     * so an appearance's material can change on the fly.
     */
    @JsProperty
    public Material material;
    /**
     * The WebGL fixed-function state to use when rendering the geometry.
     */
    @JsProperty(name = "renderState")
    public native Object renderState();
    /**
     * When true, the geometry is expected to appear translucent.
     * Default: true
     */
    @JsProperty
    public boolean translucent;
    /**
     * The GLSL source code for the vertex shader.
     */
    @JsProperty(name = "vertexShaderSource")
    public native String vertexShaderSource();

    /**
     * An appearance defines the full GLSL vertex and fragment shaders and the render state used to draw a Primitive.
     * All appearances implement this base Appearance interface.
     * @see MaterialAppearance
     * @see EllipsoidSurfaceAppearance
     * @see PerInstanceColorAppearance
     * @see DebugAppearance
     * @see PolylineColorAppearance
     * @see PolylineMaterialAppearance
     */
    @JsConstructor
    public Appearance() {}

    /**
     * An appearance defines the full GLSL vertex and fragment shaders and the render state used to draw a Primitive.
     * All appearances implement this base Appearance interface.
     * @see MaterialAppearance
     * @see EllipsoidSurfaceAppearance
     * @see PerInstanceColorAppearance
     * @see DebugAppearance
     * @see PolylineColorAppearance
     * @see PolylineMaterialAppearance
     * @param options {@link AppearanceOptions}
     */
    @JsConstructor
    public Appearance(AppearanceOptions options) {}

    /**
     * Procedurally creates the full GLSL fragment shader source for this appearance taking into account
     * {@link Appearance#fragmentShaderSource()} and {@link Appearance#material}.
     * @return The full GLSL fragment shader source.
     */
    @JsMethod
    public native String getFragmentShaderSource();

    /**
     * Creates a render state. This is not the final render state instance; instead, it can contain a subset of
     * render state properties identical to the render state created in the context.
     * @return The render state.
     */
    @JsMethod
    public native Object getRenderState();

    /**
     * Determines if the geometry is translucent based on Appearance#translucent and Material#isTranslucent.
     * @return true if the appearance is translucent.
     */
    @JsMethod
    public native boolean isTranslucent();
}
