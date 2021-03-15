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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.options.OpenCageGeocoderServiceOptions;
import org.cesiumjs.cs.promise.Promise;

/**
 * Provides geocoding via a <a href="https://opencagedata.com">OpenCage</a>
 * server.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "OpenCageGeocoderService")
public class OpenCageGeocoderService implements GeocoderService {

    /**
     * @param resource The endpoint to the OpenCage server.
     * @param apiKey   The OpenCage API Key.
     */
    @JsConstructor
    public OpenCageGeocoderService(String resource, String apiKey) {
    }

    /**
     * @param resource The endpoint to the OpenCage server.
     * @param apiKey   The OpenCage API Key.
     */
    @JsConstructor
    public OpenCageGeocoderService(String resource, String apiKey, OpenCageGeocoderServiceOptions options) {
    }

    /**
     * @param resource The endpoint to the OpenCage server.
     * @param apiKey   The OpenCage API Key.
     */
    @JsConstructor
    public OpenCageGeocoderService(Resource resource, String apiKey) {
    }

    /**
     * @param resource The endpoint to the OpenCage server.
     * @param apiKey   The OpenCage API Key.
     */
    @JsConstructor
    public OpenCageGeocoderService(Resource resource, String apiKey, OpenCageGeocoderServiceOptions options) {
    }

    /**
     * Process query request to service
     *
     * @param query The query to be sent to the geocoder service
     * @return promise
     */
    @JsMethod
    public native Promise<GeocoderResult[], String> geocode(String query);
}
