/*
 * Copyright 2023 iSergio, Gis4Fun.
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

package org.cesiumjs.cs.core.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * An enum of metadata types. These metadata types are containers containing one or more components
 * of type {@link MetadataComponentType}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "MetadataType")
public class MetadataType {
    /**
     * A single component
     */
    @JsProperty(name = "SCALAR")
    public static native String SCALAR();
    /**
     * A vector with two components
     */
    @JsProperty(name = "VEC2")
    public static native String VEC2();
    /**
     * A vector with three components
     */
    @JsProperty(name = "VEC3")
    public static native String VEC3();
    /**
     * A vector with four components
     */
    @JsProperty(name = "VEC4")
    public static native String VEC4();
    /**
     * A 2x2 matrix, stored in column-major format.
     */
    @JsProperty(name = "MAT2")
    public static native String MAT2();
    /**
     * A 3x3 matrix, stored in column-major format.
     */
    @JsProperty(name = "MAT3")
    public static native String MAT3();
    /**
     * A 4x4 matrix, stored in column-major format.
     */
    @JsProperty(name = "MAT4")
    public static native String MAT4();
    /**
     * A boolean (true/false) value
     */
    @JsProperty(name = "BOOLEAN")
    public static native String BOOLEAN();
    /**
     * A UTF-8 encoded string value
     */
    @JsProperty(name = "STRING")
    public static native String STRING();
    /**
     * An enumerated value. This type is used in conjunction with a MetadataEnum to describe the valid values.
     */
    @JsProperty(name = "ENUM")
    public static native String ENUM();

    @JsConstructor
    private MetadataType() {}
}
