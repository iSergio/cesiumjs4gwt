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
import org.cesiumjs.cs.core.VertexFormat;
import org.cesiumjs.cs.scene.apperances.options.PerInstanceColorAppearanceOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PerInstanceColorAppearance")
public class PerInstanceColorAppearance extends Appearance {
    /**
     * The VertexFormat that all PerInstanceColorAppearance instances are compatible with when PerInstanceColorAppearance#flat
     * is false. This requires only a position attribute.
     */
    @JsProperty(name = "FLAT_VERTEX_FORMAT")
    public static native VertexFormat FLAT_VERTEX_FORMAT();
    /**
     * The VertexFormat that all PerInstanceColorAppearance instances are compatible with. This requires only position and st attributes.
     */
    @JsProperty(name = "VERTEX_FORMAT")
    public static native VertexFormat VERTEX_FORMAT();
    /**
     * When true, the fragment shader flips the surface normal as needed to ensure that the normal faces the viewer to
     * avoid dark spots. This is useful when both sides of a geometry should be shaded like WallGeometry.
     * Default: true
     */
    @JsProperty(name = "faceForward")
    public native boolean faceForward();
    /**
     * When true, flat shading is used in the fragment shader, which means lighting is not taking into account.
     * Default: false
     */
    @JsProperty(name = "flat")
    public native boolean flat();
//    /**
//     * The GLSL source code for the fragment shader.
//     */
//    @JsProperty(name = "fragmentShaderSource")
//    public native String fragmentShaderSource();
//    /**
//     * This property is part of the Appearance interface, but is not used by PerInstanceColorAppearance since a fully
//     * custom fragment shader is used.
//     * Default: undefined
//     */
//    @JsProperty
//    public Material material;
//    /**
//     * The WebGL fixed-function state to use when rendering the geometry.
//     * The render state can be explicitly defined when constructing a PerInstanceColorAppearance instance, or it is
//     * set implicitly via PerInstanceColorAppearance#translucent and PerInstanceColorAppearance#closed.
//     */
//    @JsProperty(name = "renderState")
//    public native Object renderState();
//    /**
//     * When true, the geometry is expected to appear translucent so PerInstanceColorAppearance#renderState has alpha blending enabled.
//     * Default: true
//     */
//    @JsProperty
//    public boolean translucent;
    /**
     * The VertexFormat that this appearance instance is compatible with. A geometry can have more vertex attributes
     * and still be compatible - at a potential performance cost - but it can't have less.
     */
    @JsProperty(name = "vertexFormat")
    public native Integer vertexFormat();
//    /**
//     * The GLSL source code for the vertex shader.
//     */
//    @JsProperty(name = "vertexShaderSource")
//    public native String vertexShaderSource();

    @JsConstructor
    public PerInstanceColorAppearance() {}

    @JsConstructor
    public PerInstanceColorAppearance(PerInstanceColorAppearanceOptions options) {}

//    /**
//     * Procedurally creates the full GLSL fragment shader source. For PerInstanceColorAppearance, this is derived from
//     * PerInstanceColorAppearance#fragmentShaderSource, PerInstanceColorAppearance#flat, and PerInstanceColorAppearance#faceForward.
//     * @return The full GLSL fragment shader source.
//     */
//    @Override
//    @JsMethod
//    public native String getFragmentShaderSource();
//
//    /**
//     * Creates a render state. This is not the final render state instance; instead, it can contain a subset of render
//     * state properties identical to the render state created in the context.
//     * @return The render state.
//     */
//    @Override
//    @JsMethod
//    public native Object getRenderState();
//
//    /**
//     * Determines if the geometry is translucent based on PerInstanceColorAppearance#translucent.
//     * @return true if the appearance is translucent.
//     */
//    @Override
//    @JsMethod
//    public native boolean isTranslucent();
}
