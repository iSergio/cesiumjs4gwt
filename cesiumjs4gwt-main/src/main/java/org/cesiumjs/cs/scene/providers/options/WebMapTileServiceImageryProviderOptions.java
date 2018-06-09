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

package org.cesiumjs.cs.scene.providers.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.core.*;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WebMapTileServiceImageryProviderOptions {
    /**
     * The base URL for the WMTS GetTile operation (for KVP-encoded requests) or the tile-URL template (for RESTful requests).
     * The tile-URL template should contain the following variables: {style}, {TileMatrixSet}, {TileMatrix}, {TileRow}, {TileCol}. The first two are optional if actual values are hardcoded or not required by the server. The {s} keyword may be used to specify subdomains.
     */
    @JsProperty
    public String url;
    /**
     * The MIME type for images to retrieve from the server.
     * Default: image/jpeg
     */
    @JsProperty
    public String format;
    /**
     * The layer name for WMTS requests.
     */
    @JsProperty
    public String layer;
    /**
     * The style name for WMTS requests.
     */
    @JsProperty
    public String style;
    /**
     * The identifier of the TileMatrixSet to use for WMTS requests.
     */
    @JsProperty
    public String tileMatrixSetID;
    /**
     * A list of identifiers in the TileMatrix to use for WMTS requests, one per TileMatrix level.
     */
    @JsProperty
    public String[] tileMatrixLabels;
    /**
     * A Clock instance that is used when determining the value for the time dimension. Required when options.times is specified.
     */
    @JsProperty
    public Clock clock;
    /**
     * TimeIntervalCollection with its data property being an object containing time dynamic dimension and their values.
     */
    @JsProperty
    public TimeIntervalCollection times;
    /**
     * A object containing static dimensions and their values.
     */
    @JsProperty
    public Object dimensions;
    /**
     * The tile width in pixels.
     * Default: 256
     */
    @JsProperty
    public int tileWidth;
    /**
     * The tile height in pixels.
     * Default: 256
     */
    int tileHeight;
    /**
     * The tiling scheme corresponding to the organization of the tiles in the TileMatrixSet.
     */
    @JsProperty
    public TilingScheme tilingScheme;
    //TODO: Proxy
//    /**
//     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL.
//     */
//    @JsProperty
//    public Proxy proxy;
    /**
     * The rectangle covered by the layer.
     * Default {@link org.cesiumjs.cs.core.Rectangle#MAX_VALUE()}
     */
    @JsProperty
    public Rectangle rectangle;
    /**
     * The minimum level-of-detail supported by the imagery provider.
     * Default: 0
     */
    @JsProperty
    public int minimumLevel;
    /**
     * The maximum level-of-detail supported by the imagery provider, or undefined if there is no limit.
     */
    @JsProperty
    public int maximumLevel;
    /**
     * The ellipsoid. If not specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * A credit for the data source, which is displayed on the canvas.
     */
    @JsProperty
    public Credit credit;
    /**
     * The subdomains to use for the {s} placeholder in the URL template. If this parameter is a single string, each
     * character in the string is a subdomain.
     * If it is an array, each element in the array is a subdomain.
     */
    @JsProperty
    public String[] subdomains;

    /**
     * Options for {@link org.cesiumjs.cs.scene.providers.WebMapTileServiceImageryProvider}
     */
    @JsConstructor
    public WebMapTileServiceImageryProviderOptions() {}
}
