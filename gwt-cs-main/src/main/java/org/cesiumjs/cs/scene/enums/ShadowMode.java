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

package org.cesiumjs.cs.scene.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ShadowMode")
public class ShadowMode {
    /**
     * The object casts shadows only.
     */
    @JsProperty(name = "CAST_ONLY")
    public static native Number CAST_ONLY();
    /**
     * The object receives shadows only.
     */
    @JsProperty(name = "RECEIVE_ONLY")
    public static native Number RECEIVE_ONLY();
    /**
     * The object casts and receives shadows.
     */
    @JsProperty(name = "ENABLED")
    public static native Number ENABLED();
    /**
     * The object does not cast or receive shadows.
     */
    @JsProperty(name = "DISABLED")
    public static native Number DISABLED();

    /**
     * Describes how the map will operate in 2D.
     */
    @JsConstructor
    private ShadowMode() {}
}
