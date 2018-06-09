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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A model's material with modifiable parameters. A glTF material contains parameters defined by the material's
 * technique with values defined by the technique and potentially overridden by the material.
 * This class allows changing these values at runtime.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ModelMaterial")
public class ModelMaterial {
    /**
     * The name of the glTF JSON property for this material. This is guaranteed to be unique among all materials.
     * It may not match the material's name property {@link ModelMaterial#name},
     * which is assigned by the artist when the asset is created.
     */
    @JsProperty(name = "id")
    public native String id();

    /**
     * The value of the name property of this material. This is the name assigned by the artist when the asset is created.
     * This can be different than the name of the material property {@link ModelMaterial#id}, which is internal to glTF.
     */
    @JsProperty(name = "name")
    public native String name();

    /**
     * Use {@link Model#getMaterial} to create an instance.
     */
    @JsConstructor
    public ModelMaterial() {}

    /**
     * Returns the value of the parameter with the given name. The type of the returned object depends on the glTF
     * type of the parameter. It will be a floating-point number, Cartesian, or matrix.
     * @param name The name of the parameter.
     * @return The value of the parameter or undefined if the parameter does not exist.
     */
    @JsMethod
    public native Object getValue(String name);

    /**
     * Assigns a value to a material parameter. The type for value depends on the glTF type of the parameter.
     * It will be a floating-point number, Cartesian, or matrix.
     * @param name The name of the parameter.
     */
    @JsMethod
    public native void setValue(String name);

    /**
     * Assigns a value to a material parameter. The type for value depends on the glTF type of the parameter.
     * It will be a floating-point number, Cartesian, or matrix.
     * @param name The name of the parameter.
     * @param value The value to assign to the parameter.
     */
    @JsMethod
    public native void setValue(String name, Object value);
}
