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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Request;
import org.cesiumjs.cs.core.enums.RequestType;

/**
 * Options for {@link org.cesiumjs.cs.core.Request}
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class RequestOptions {
    /**
     * The url to request.
     */
    @JsProperty
    public boolean url;
    /**
     * The function that makes the actual data request.
     */
    @JsProperty
    public Request.RequestCallback requestFunction;
    /**
     * The function that is called when the request is cancelled.
     */
    @JsProperty
    public Request.CancelCallback cancelFunction;
    /**
     * The function that is called to update the request's priority, which occurs once per frame.
     */
    @JsProperty
    public Request.PriorityCallback priorityFunction;
    /**
     * The initial priority of the request.
     * Default: 0.0
     */
    @JsProperty
    public double priority;
    /**
     * Whether to throttle and prioritize the request. If false, the request will be sent immediately.
     * If true, the request will be throttled and sent based on priority.
     * Default: false
     */
    @JsProperty
    public boolean throttle;
    /**
     * Whether to throttle the request by server.
     * Default: false
     */
    @JsProperty
    public boolean throttleByServer;
    /**
     * The type of request.
     * @see org.cesiumjs.cs.core.enums.RequestType
     * Default: {@link org.cesiumjs.cs.core.enums.RequestType#OTHER()}
     */
    @JsProperty
    public Number type;

    @JsConstructor
    public RequestOptions() {}
}
