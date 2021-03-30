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
import org.cesiumjs.cs.js.JsObject;

/**
 * Options for {@link org.cesiumjs.cs.core.Resource#head} method.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ResourceHttpOptions {
    /**
     * The type of response. This controls the type of item returned.
     */
    @JsProperty
    public String responseType;
    /**
     * Additional HTTP headers to send with the request, if any.
     */
    @JsProperty
    public JsObject headers;
    /**
     * Overrides the MIME type returned by the server.
     */
    @JsProperty
    public String overrideMimeType;

    @JsConstructor
    public ResourceHttpOptions() {
    }

    /**
     * Create instance of {@link ResourceHttpOptions} object.
     *
     * @param responseType The type of response. This controls the type of item
     *                     returned.
     * @return instance of {@link ResourceHttpOptions} object.
     */
    @JsOverlay
    public static ResourceHttpOptions create(String responseType) {
        return create(responseType, null, "");
    }

    /**
     * Create instance of {@link ResourceHttpOptions} object.
     *
     * @param responseType The type of response. This controls the type of item
     *                     returned.
     * @param headers      Additional HTTP headers to send with the request, if any.
     * @return instance of {@link ResourceHttpOptions} object.
     */
    @JsOverlay
    public static ResourceHttpOptions create(String responseType, JsObject headers) {
        return create(responseType, headers, "");
    }

    /**
     * Create instance of {@link ResourceHttpOptions} object.
     *
     * @param responseType     The type of response. This controls the type of item
     *                         returned.
     * @param headers          Additional HTTP headers to send with the request, if
     *                         any.
     * @param overrideMimeType Overrides the MIME type returned by the server.
     * @return instance of {@link ResourceHttpOptions} object.
     */
    @JsOverlay
    public static ResourceHttpOptions create(String responseType, JsObject headers, String overrideMimeType) {
        ResourceHttpOptions options = new ResourceHttpOptions();
        options.responseType = responseType;
        options.headers = headers;
        options.overrideMimeType = overrideMimeType;
        return options;
    }
}
