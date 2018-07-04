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

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class BingMapsGeocoderServiceOptions {
    /**
     * A key to use with the Bing Maps geocoding service
     */
    @JsProperty
    public String key;

    /**
     * Options for {@link org.cesiumjs.cs.core.BingMapsGeocoderService}
     */
    @JsConstructor
    private BingMapsGeocoderServiceOptions() {}

    /**
     * Fast create {@link BingMapsGeocoderServiceOptions} instance by mandatory parameter - key
     * @param key A key to use with the Bing Maps geocoding service
     * @return {@link BingMapsGeocoderServiceOptions} instance.
     */
    @JsOverlay
    public static BingMapsGeocoderServiceOptions create(String key) {
        BingMapsGeocoderServiceOptions options = new BingMapsGeocoderServiceOptions();
        options.key = key;
        return options;
    }
}
