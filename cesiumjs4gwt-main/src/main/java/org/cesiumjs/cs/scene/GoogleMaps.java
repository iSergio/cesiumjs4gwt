/*
 * Copyright 2023 iSergio, Gis4Fun.
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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Resource;

@JsType(isNative = true, namespace = "Cesium", name = "GoogleMaps")
public class GoogleMaps {
    /**
     * Gets or sets the default Google Maps API key.
     */
    @JsProperty
    public static String defaultApiKey;

    /**
     * Gets or sets the default Google Map Tiles API endpoint.
     * Default: https://tile.googleapis.com/v1/
     */
    @JsProperty
    public static String mapTilesApiEndpoint;

    /**
     * Gets or sets the default Google Map Tiles API endpoint.
     * Default: https://tile.googleapis.com/v1/
     */
    @JsProperty(name = "mapTilesApiEndpoint")
    public static Resource mapTilesApiEndpointResource;
}
