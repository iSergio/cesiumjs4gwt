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
 * Options for {@link org.cesiumjs.cs.core.Resource#post(ResourcePostOptions)}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ResourcePostOptions extends ResourceOptions {
    /**
     * Data that is posted with the resource.
     */
    @JsProperty
    public JsObject data;
    /**
     * The type of response. This controls the type of item returned.
     */
    @JsProperty
    public String responseType;
    /**
     * Overrides the MIME type returned by the server.
     */
    @JsProperty
    public String overrideMimeType;

    @JsConstructor
    ResourcePostOptions() {}

    @JsOverlay
    public static ResourcePostOptions create(String url, JsObject data) {
        ResourcePostOptions options = new ResourcePostOptions();
        options.url = url;
        options.data = data;
        return options;
    }
}
