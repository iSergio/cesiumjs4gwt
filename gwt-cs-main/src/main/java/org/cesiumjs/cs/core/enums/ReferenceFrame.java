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

package org.cesiumjs.cs.core.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ReferenceFrame")
public class ReferenceFrame {
    /**
     * The fixed frame.
     */
    @JsProperty(name = "FIXED")
    public static native Number FIXED();
    /**
     * The inertial frame.
     */
    @JsProperty(name = "INTERNAL")
    public static native Number INERTIAL();

    /**
     * Constants for identifying well-known reference frames.
     */
    @JsConstructor
    private ReferenceFrame() {}
}
