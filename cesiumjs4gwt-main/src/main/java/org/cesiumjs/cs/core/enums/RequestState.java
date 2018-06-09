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
 * State of the request.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "RequestState")
public class RequestState {
    /**
     * Actual http request has been sent.
     */
    @JsProperty(name = "ACTIVE")
    public static native Number ACTIVE();
    /**
     * Request was cancelled, either explicitly or automatically because of low priority.
     */
    @JsProperty(name = "CANCELLED")
    public static native Number CANCELLED();
    /**
     * Request failed.
     */
    @JsProperty(name = "FAILED")
    public static native Number FAILED();
    /**
     * Issued but not yet active. Will become active when open slots are available.
     */
    @JsProperty(name = "ISSUED")
    public static native Number ISSUED();
    /**
     * Request completed successfully.
     */
    @JsProperty(name = "RECEIVED")
    public static native Number RECEIVED();
    /**
     * Initial unissued state.
     */
    @JsProperty(name = "UNISSUED")
    public static native Number UNISSUED();

    @JsConstructor
    private RequestState() {}
}
