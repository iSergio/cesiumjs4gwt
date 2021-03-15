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
import org.cesiumjs.cs.core.enums.GeocodeType;
import org.cesiumjs.cs.promise.Promise;

/**
 * Provides geocoding via a <a href="https://pelias.io/">Pelias</a> server.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PeliasGeocoderService")
public class PeliasGeocoderService implements GeocoderService {
    /**
     * Provides geocoding via a <a href="https://pelias.io/">Pelias</a> server.
     *
     * @param url The endpoint to the Pelias server.
     */
    @JsConstructor
    public PeliasGeocoderService(Resource url) {
    }

    /**
     * Provides geocoding via a <a href="https://pelias.io/">Pelias</a> server.
     *
     * @param url The endpoint to the Pelias server.
     */
    @JsConstructor
    public PeliasGeocoderService(String url) {
    }

    /**
     * Process query request to service
     *
     * @param query The query to be sent to the geocoder service
     * @return query result
     */
    @JsMethod
    public native Promise<GeocoderResult[], Void> geocode(String query);

    /**
     * Process query request to service
     *
     * @param query The query to be sent to the geocoder service
     * @param type  The type of geocode to perform.
     * @return query result
     */
    @JsMethod
    public native Promise<GeocoderResult[], Void> geocode(String query, GeocodeType type);
}
