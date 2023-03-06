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
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * An enum of metadata component types.
 */
@JsType(isNative = true, namespace = "Cesium", name = "MetadataComponentType")
public class MetadataComponentType {
    /**
     * An 8-bit signed integer
     */
    @JsProperty(name = "INT8")
    public static native String INT8();
    /**
     * An 8-bit unsigned integer
     */
    @JsProperty(name = "UINT8")
    public static native String UINT8();
    /**
     * A 16-bit signed integer
     */
    @JsProperty(name = "INT16")
    public static native String INT16();
    /**
     * A 16-bit unsigned integer
     */
    @JsProperty(name = "UINT16")
    public static native String UINT16();
    /**
     * A 32-bit signed integer
     */
    @JsProperty(name = "INT32")
    public static native String INT32();
    /**
     * A 32-bit unsigned integer
     */
    @JsProperty(name = "UINT32")
    public static native String UINT32();
    /**
     * A 64-bit signed integer. This type requires BigInt support.
     */
    @JsProperty(name = "INT64")
    public static native String INT64();
    /**
     * A 64-bit signed integer. This type requires BigInt support
     */
    @JsProperty(name = "UINT64")
    public static native String UINT64();
    /**
     * A 32-bit (single precision) floating point number
     */
    @JsProperty(name = "FLOAT32")
    public static native String FLOAT32();
    /**
     * A 64-bit (double precision) floating point number
     */
    @JsProperty(name = "FLOAT64")
    public static native String FLOAT64();

    @JsConstructor
    private MetadataComponentType() {}
}
