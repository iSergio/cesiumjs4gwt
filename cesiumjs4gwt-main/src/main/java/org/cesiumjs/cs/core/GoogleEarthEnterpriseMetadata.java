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

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.options.GoogleEarthEnterpriseMetadataOptions;
import org.cesiumjs.cs.js.JsObject;

/**
 * Provides metadata using the Google Earth Enterprise REST API.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "GoogleEarthEnterpriseMetadata")
public class GoogleEarthEnterpriseMetadata {
    /**
     * The url of the Google Earth Enterprise server hosting the imagery
     */
    @JsProperty
    public String url;

    @JsConstructor
    private GoogleEarthEnterpriseMetadata(GoogleEarthEnterpriseMetadataOptions options) {}

    @JsOverlay
    public static GoogleEarthEnterpriseMetadata create(String url) {
        GoogleEarthEnterpriseMetadataOptions options = GoogleEarthEnterpriseMetadataOptions.create(url);
        return new GoogleEarthEnterpriseMetadata(options);
    }

    @JsOverlay
    public static GoogleEarthEnterpriseMetadata create(String url, Object proxy) {
        GoogleEarthEnterpriseMetadataOptions options = GoogleEarthEnterpriseMetadataOptions.create(url, proxy);
        return new GoogleEarthEnterpriseMetadata(options);
    }

    /**
     * Converts a tile's quadkey used to request an image from a Google Earth Enterprise server
     * into the (x, y, level) position.
     * @param quadkey The tile's quad key
     * @return Object with x, y and level.
     */
    @JsMethod
    public static native JsObject quadKeyToTileXY(String quadkey);

    /**
     * Converts a tiles (x, y, level) position into a quadkey used to request an image from a Google Earth Enterprise server.
     * @param x The tile's x coordinate.
     * @param y The tile's y coordinate.
     * @param level The tile's zoom level.
     * @return quad key of tile
     */
    @JsMethod
    public static native String tileXYToQuadKey(int x, int y, int level);
}
