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
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.apperances.PerInstanceColorAppearance;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PerInstanceColorAppearanceOptions {
    /**
     * When true, flat shading is used in the fragment shader, which means lighting is not taking into account.
     */
    @JsProperty
    public boolean flat;
    /**
     * When true, the fragment shader flips the surface normal as needed to ensure that the normal faces the viewer to
     * avoid dark spots. This is useful when both sides of a geometry should be shaded like WallGeometry.
     */
    @JsProperty
    public boolean faceForward;
    /**
     * When true, the geometry is expected to appear translucent so PerInstanceColorAppearance#renderState has alpha blending enabled.
     */
    @JsProperty
    public boolean translucent;
    /**
     * When true, the geometry is expected to be closed so PerInstanceColorAppearance#renderState has backface culling enabled.
     */
    @JsProperty
    public boolean closed;
    /**
     * GLSL vertex shader source to override the default vertex shader.
     */
    @JsProperty
    public String vertexShaderSource;
    /**
     * GLSL fragment shader source to override the default fragment shader.
     */
    @JsProperty
    public String fragmentShaderSource;
    /**
     * render state to override the default render state.
     */
    @JsProperty
    public JsObject renderState;

    /**
     * Options for {@link PerInstanceColorAppearance}
     */
    @JsConstructor
    public PerInstanceColorAppearanceOptions() {}
}
