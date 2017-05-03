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

/**
 * Options for {@link org.cesiumjs.cs.core.GoogleEarthEnterpriseMetadata}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GoogleEarthEnterpriseMetadataOptions {
    /**
     * The url of the Google Earth Enterprise server hosting the imagery.
     */
    @JsProperty
    public String url;
    /**
     * A proxy to use for requests. This object is expected to have a getURL
     * function which returns the proxied URL, if needed.
     */
    @JsProperty
    public Object proxy;

    @JsConstructor
    private GoogleEarthEnterpriseMetadataOptions() {}

    @JsOverlay
    public static GoogleEarthEnterpriseMetadataOptions create(String url) {
        GoogleEarthEnterpriseMetadataOptions options = new GoogleEarthEnterpriseMetadataOptions();
        options.url = url;
        return options;
    }

    @JsOverlay
    public static GoogleEarthEnterpriseMetadataOptions create(String url, Object proxy) {
        GoogleEarthEnterpriseMetadataOptions options = new GoogleEarthEnterpriseMetadataOptions();
        options.url = url;
        options.proxy = proxy;
        return options;
    }
}
