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

package org.cesiumjs.cs.core.providers;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.GoogleEarthEnterpriseMetadata;
import org.cesiumjs.cs.core.Request;
import org.cesiumjs.cs.core.TerrainData;
import org.cesiumjs.cs.core.providers.options.GoogleEarthEnterpriseTerrainProviderOptions;
import org.cesiumjs.cs.promise.Promise;

/**
 * Provides tiled terrain using the Google Earth Enterprise REST API.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "GoogleEarthEnterpriseTerrainProvider")
public class GoogleEarthEnterpriseTerrainProvider implements TerrainProvider {
    @JsConstructor
    public GoogleEarthEnterpriseTerrainProvider(GoogleEarthEnterpriseTerrainProviderOptions options) {}

    @JsOverlay
    public static GoogleEarthEnterpriseTerrainProvider create(String url) {
        GoogleEarthEnterpriseTerrainProviderOptions options = GoogleEarthEnterpriseTerrainProviderOptions.create(url);
        return new GoogleEarthEnterpriseTerrainProvider(options);
    }

    @JsOverlay
    public static GoogleEarthEnterpriseTerrainProvider create(GoogleEarthEnterpriseMetadata metadata) {
        GoogleEarthEnterpriseTerrainProviderOptions options = GoogleEarthEnterpriseTerrainProviderOptions.create(metadata);
        return new GoogleEarthEnterpriseTerrainProvider(options);
    }

    /**
     * Gets the maximum geometric error allowed in a tile at a given level.
     * @param level The tile level for which to get the maximum geometric error.
     * @return The maximum geometric error.
     */
    @Override
    @JsMethod
    public native double getLevelMaximumGeometricError(int level);

    /**
     * Determines whether data for a tile is available to be loaded.
     * @param x The X coordinate of the tile for which to request geometry.
     * @param y The Y coordinate of the tile for which to request geometry.
     * @param level The level of the tile for which to request geometry.
     * @return Undefined if not supported, otherwise true or false.
     */
    public native boolean getTileDataAvailable(int x, int y, int level);

    /**
     * Requests the geometry for a given tile. This function should not be called before
     * GoogleEarthEnterpriseProvider#ready returns true. The result must include terrain
     * data and may optionally include a water mask and an indication of which child tiles are available.
     * @param x The X coordinate of the tile for which to request geometry.
     * @param y The Y coordinate of the tile for which to request geometry.
     * @param level The level of the tile for which to request geometry.
     * @param throttleRequests True if the number of simultaneous requests should be limited, or false if the request
     *                         should be initiated regardless of the number of requests already in progress. Default: true
     * @return A promise for the requested geometry. If this method returns undefined instead of a promise,
     * it is an indication that too many requests are already pending and the request will be retried later.
     * @deprecated The throttleRequests parameter will be removed in 1.37. Instead set the request's throttle property to true to throttle requests.
     */
    @Override
    @JsMethod
    @Deprecated
    public native Promise<TerrainData, Void> requestTileGeometry(int x, int y, int level, boolean throttleRequests);

    /**
     * Requests the geometry for a given tile. This function should not be called before
     * GoogleEarthEnterpriseProvider#ready returns true. The result must include terrain
     * data and may optionally include a water mask and an indication of which child tiles are available.
     * @param x The X coordinate of the tile for which to request geometry.
     * @param y The Y coordinate of the tile for which to request geometry.
     * @param level The level of the tile for which to request geometry.
     * @param request The request object. Intended for internal use only.
     * @return A promise for the requested geometry. If this method returns undefined instead of a promise,
     * it is an indication that too many requests are already pending and the request will be retried later.
     */
    @Override
    @JsMethod
    public native Promise<TerrainData, Void> requestTileGeometry(int x, int y, int level, Request request);
}
