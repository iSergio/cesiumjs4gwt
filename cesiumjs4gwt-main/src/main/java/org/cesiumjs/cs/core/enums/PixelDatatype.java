/*
 * Copyright 2018 iserge.
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

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PixelDatatype")
public class PixelDatatype {
    @JsProperty(name = "UNSIGNED_BYTE")
    public static native Number UNSIGNED_BYTE();

    @JsProperty(name = "UNSIGNED_SHORT")
    public static native Number UNSIGNED_SHORT();

    @JsProperty(name = "UNSIGNED_INT")
    public static native Number UNSIGNED_INT();

    @JsProperty(name = "FLOAT")
    public static native Number FLOAT();

    @JsProperty(name = "HALF_FLOAT")
    public static native Number HALF_FLOAT();

    @JsProperty(name = "UNSIGNED_INT_24_8")
    public static native Number UNSIGNED_INT_24_8();

    @JsProperty(name = "UNSIGNED_SHORT_4_4_4_4")
    public static native Number UNSIGNED_SHORT_4_4_4_4();

    @JsProperty(name = "UNSIGNED_SHORT_5_5_5_1")
    public static native Number UNSIGNED_SHORT_5_5_5_1();

    @JsProperty(name = "UNSIGNED_SHORT_5_6_5")
    public static native Number UNSIGNED_SHORT_5_6_5();
}
