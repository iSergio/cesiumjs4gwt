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

package org.cesiumjs.cs.scene.experimental.enums;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * An enum of the basic GLSL uniform types. These can be used with
 * {@link org.cesiumjs.cs.scene.experimental.CustomShader} to declare user-defined uniforms.
 */
@JsType(isNative = true, namespace = "Cesium", name = "UniformType")
public class UniformType {
    /**
     * A single floating point value.
     */
    @JsProperty(name = "FLOAT")
    public static native String FLOAT();
    /**
     * A vector of 2 floating point values.
     */
    @JsProperty(name = "VEC2")
    public static native String VEC2();
    /**
     * A vector of 3 floating point values.
     */
    @JsProperty(name = "VEC3")
    public static native String VEC3();
    /**
     * A vector of 4 floating point values.
     */
    @JsProperty(name = "VEC4")
    public static native String VEC4();
    /**
     * A single integer value
     */
    @JsProperty(name = "INT")
    public static native String INT();
    /**
     * A vector of 2 integer values.
     */
    @JsProperty(name = "INT_VEC2")
    public static native String INT_VEC2();
    /**
     * A vector of 3 integer values.
     */
    @JsProperty(name = "INT_VEC3")
    public static native String INT_VEC3();
    /**
     * A vector of 4 integer values.
     */
    @JsProperty(name = "INT_VEC4")
    public static native String INT_VEC4();
    /**
     * A single boolean value.
     */
    @JsProperty(name = "BOOL")
    public static native String BOOL();
    /**
     * A vector of 2 boolean values.
     */
    @JsProperty(name = "BOOL_VEC2")
    public static native String BOOL_VEC2();
    /**
     * A vector of 3 boolean values.
     */
    @JsProperty(name = "BOOL_VEC3")
    public static native String BOOL_VEC3();
    /**
     * A vector of 4 boolean values.
     */
    @JsProperty(name = "BOOL_VEC4")
    public static native String BOOL_VEC4();
    /**
     * A 2x2 matrix of floating point values.
     */
    @JsProperty(name = "MAT2")
    public static native String MAT2();
    /**
     * A 3x3 matrix of floating point values.
     */
    @JsProperty(name = "MAT3")
    public static native String MAT3();
    /**
     * A 3x3 matrix of floating point values.
     */
    @JsProperty(name = "MAT4")
    public static native String MAT4();
    /**
     * A 2D sampled texture.
     */
    @JsProperty(name = "SAMPLER_2D")
    public static native String SAMPLER_2D();

    @JsProperty(name = "SAMPLER_CUBE")
    public static native String SAMPLER_CUBE();
}
