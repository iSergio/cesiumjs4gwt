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

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * An enum identifying the type of request. Used for finer grained logging and priority sorting.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "RequestType")
public class RequestType {
    /**
     * Imagery request.
     */
    @JsProperty(name = "IMAGERY")
    public static native Number IMAGERY();
    /**
     * Other request.
      */
    @JsProperty(name = "OTHER")
    public static native Number OTHER();
    /**
     * Terrain request.
      */
    @JsProperty(name = "TERRAIN")
    public static native Number TERRAIN();
    /**
     * 3D Tiles request.
      */
    @JsProperty(name = "TILES3D")
    public static native Number TILES3D();

    private RequestType() {}
}
