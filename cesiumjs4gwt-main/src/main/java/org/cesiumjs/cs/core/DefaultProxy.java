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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * A simple proxy that appends the desired resource as the sole query parameter to the given proxy URL.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "DefaultProxy")
public class DefaultProxy {
    /**
     * A simple proxy that appends the desired resource as the sole query parameter to the given proxy URL.
     * @param proxy The proxy URL that will be used to requests all resources.
     */
    @JsConstructor
    public DefaultProxy(String proxy) {}

    /**
     * Get the final URL to use to request a given resource.
     * @param resource The resource to request.
     * @return proxied resource
     */
    @JsMethod
    public native String getURL(String resource);
}
