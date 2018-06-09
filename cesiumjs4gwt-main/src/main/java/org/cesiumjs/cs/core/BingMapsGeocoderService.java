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
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.options.BingMapsGeocoderServiceOptions;
import org.cesiumjs.cs.promise.Promise;

/**
 * Provides geocoding through Bing Maps.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "BingMapsGeocoderService")
public class BingMapsGeocoderService implements GeocoderService {
    @JsConstructor
    private BingMapsGeocoderService() {}

    /**
     * Provides geocoding through Bing Maps.
     * @param options {@link BingMapsGeocoderServiceOptions} object.
     */
    @JsConstructor
    public BingMapsGeocoderService(BingMapsGeocoderServiceOptions options) {}

    /**
     * Provides geocoding through Bing Maps.
     * @param key A key to use with the Bing Maps geocoding service
     */
    @JsOverlay
    public static BingMapsGeocoderService create(String key) {
        return new BingMapsGeocoderService(BingMapsGeocoderServiceOptions.create(key));
    }

    /**
     * Process query request to service
     * @param query The query to be sent to the geocoder service
     * @return promise
     */
    @JsMethod
    public native Promise<GeocoderResult, String> geocode(String query);
}
