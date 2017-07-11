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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.enums.RequestType;
import org.cesiumjs.cs.core.options.RequestOptions;

/**
 * Stores information for making a request. In general this does not need to be constructed directly.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Request")
public class Request {
    /**
     * The function that is called when the request is cancelled.
     */
    @JsProperty
    public CancelCallback cancelFunction;
    /**
     * Priority is a unit-less value where lower values represent higher priority. For world-based objects,
     * this is usually the distance from the camera. A request that does not have a priority function defaults
     * to a priority of 0. If priorityFunction is defined, this value is updated every frame with the result of that call.
     * Default: 0.0
      */
    @JsProperty
    public double priority;
    /**
     * The function that is called to update the request's priority, which occurs once per frame.
     */
    @JsProperty
    public PriorityCallback priorityFunction;
    /**
     * The function that makes the actual data request.
     */
    @JsProperty
    public RequestCallback requestFunction;
    /**
     * The current state of the request.
     * @see org.cesiumjs.cs.core.enums.RequestState
     */
    @JsProperty
    public Number readonlystate;
    /**
     * Whether to throttle and prioritize the request. If false, the request will be sent immediately.
     * If true, the request will be throttled and sent based on priority.
     * Default: false
     */
    @JsProperty(name = "throttle")
    public native boolean throttle();
    /**
     * Whether to throttle the request by server. Browsers typically support about 6-8 parallel connections for HTTP/1
     * servers, and an unlimited amount of connections for HTTP/2 servers. Setting this value to true is preferable
     * for requests going through HTTP/1 servers.
     * Default: false
     */
    @JsProperty(name = "throttleByServer")
    public native boolean throttleByServer();
    /**
     * Type of request.
     * @see org.cesiumjs.cs.core.enums.RequestType
     * Default: {@link RequestType#OTHER()}
     */
    @JsProperty(name = "type")
    public native Number type();
    /**
     * The URL to request.
     */
    @JsProperty
    public String url;
    /**
     * Stores information for making a request. In general this does not need to be constructed directly.
     */
    @JsConstructor
    public Request() {}

    /**
     * Stores information for making a request. In general this does not need to be constructed directly.
     * @param options {@link RequestOptions}
     */
    @JsConstructor
    public Request(RequestOptions options) {}

    @JsFunction
    public interface RequestCallback {
        void function();
    }

    @JsFunction
    public interface CancelCallback {
        void function();
    }

    @JsFunction
    public interface PriorityCallback {
        void function();
    }
}
