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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.DefaultProxy;
import org.cesiumjs.cs.core.Request;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.js.JsObject;

/**
 * Options for {@link org.cesiumjs.cs.core.Resource}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ResourceOptions {
    /**
     * The url of the resource.
     */
    @JsProperty
    public String url;
    /**
     * An object containing query parameters that will be sent when retrieving the
     * resource.
     */
    @JsProperty
    public JsObject queryParameters;
    /**
     * Key/Value pairs that are used to replace template values (eg. {x}).
     */
    @JsProperty
    public JsObject templateValues;
    /**
     * Additional HTTP headers that will be sent.
     */
    @JsProperty
    public JsObject headers;
    /**
     * A proxy to be used when loading the resource.
     */
    @JsProperty
    public DefaultProxy proxy;
    /**
     * The Function to call when a request for this resource fails. If it returns
     * true, the request will be retried.
     */
    @JsProperty
    public Resource.RetryCallback retryCallback;
    /**
     * The number of times the retryCallback should be called before giving up.
     * Default: 0
     */
    @JsProperty
    public int retryAttempts;
    /**
     * A Request object that will be used. Intended for internal use only.
     */
    @JsProperty
    public Request request;

    /**
     * Because {@link ResourceOptions#url} is required, we can't set public access
     * to {@link ResourceOptions}.
     */
    @JsConstructor
    ResourceOptions() {
    }

    /**
     * Create new instance of {@link ResourceOptions}.
     *
     * @param url The url of the resource.
     * @return new {@link ResourceOptions} instance.
     */
    @JsOverlay
    public static ResourceOptions create(String url) {
        ResourceOptions options = new ResourceOptions();
        options.url = url;
        return options;
    }
}
