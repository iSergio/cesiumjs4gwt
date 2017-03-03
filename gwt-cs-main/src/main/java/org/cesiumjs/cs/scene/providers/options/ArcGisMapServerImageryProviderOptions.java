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
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.TilingScheme;
import org.cesiumjs.cs.scene.TileDiscardPolicy;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ArcGisMapServerImageryProviderOptions {
    /**
     * The URL of the ArcGIS MapServer service.
     */
    @JsProperty
    public String url;
    /**
     * The ArcGIS token used to authenticate with the ArcGIS MapServer service.
     */
    @JsProperty
    public String token;
    /**
     * The policy that determines if a tile is invalid and should be discarded. If this value is not specified,
     * a default DiscardMissingTileImagePolicy is used for tiled map servers, and a NeverTileDiscardPolicy is used
     * for non-tiled map servers. In the former case, we request tile 0,0 at the maximum tile level and check pixels
     * (0,0), (200,20), (20,200), (80,110), and (160, 130). If all of these pixels are transparent, the discard check
     * is disabled and no tiles are discarded. If any of them have a non-transparent color, any tile that has the same
     * values in these pixel locations is discarded. The end result of these defaults should be correct tile discarding
     * for a standard ArcGIS Server. To ensure that no tiles are discarded, construct and pass a NeverTileDiscardPolicy
     * for this parameter.
     */
    @JsProperty
    public TileDiscardPolicy tileDiscardPolicy;
    /**
     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
     */
    //TODO: Proxy
//    @JsProperty
//    public Proxy proxy;
    /**
     * If true, the server's pre-cached tiles are used if they are available. If false, any pre-cached tiles are ignored and the 'export' service is used.
     * Default: true
     */
    @JsProperty
    public boolean usePreCachedTilesIfAvailable;
    /**
     * A comma-separated list of the layers to show, or undefined if all layers should be shown.
     */
    @JsProperty
    public String layers;
    /**
     * If true, ArcGisMapServerImageryProvider#pickFeatures will invoke the Identify service on the MapServer and return
     * the features included in the response. If false, ArcGisMapServerImageryProvider#pickFeatures will immediately
     * return undefined (indicating no pickable features) without communicating with the server.
     * Set this property to false if you don't want this provider's features to be pickable.
     * Can be overridden by setting the ArcGisMapServerImageryProvider#enablePickFeatures property on the object.
     * Default: true
     */
    @JsProperty
    public boolean enablePickFeatures;
    /**
     * The rectangle of the layer. This parameter is ignored when accessing a tiled layer.
     * Default: {@link Rectangle#MAX_VALUE()}
     */
    @JsProperty
    public Rectangle rectangle;
    /**
     * The tiling scheme to use to divide the world into tiles. This parameter is ignored when accessing a tiled server.
     * Default: new {@link org.cesiumjs.cs.core.GeographicTilingScheme}
     */
    @JsProperty
    public TilingScheme tilingScheme;

    /**
     * The ellipsoid. If the tilingScheme is specified and used, this parameter is ignored and the tiling scheme's
     * ellipsoid is used instead. If neither parameter is specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The width of each tile in pixels. This parameter is ignored when accessing a tiled server.
     * Default: 256
     */
    @JsProperty
    public int tileWidth;
    /**
     * The height of each tile in pixels. This parameter is ignored when accessing a tiled server.
     * Default: 256
     */
    @JsProperty
    public int tileHeight;
    /**
     * The maximum tile level to request, or undefined if there is no maximum. This parameter is ignored when accessing a tiled server.
     */
    @JsProperty
    public int maximumLevel;

    /**
     * Options for {@link org.cesiumjs.cs.scene.providers.ArcGisMapServerImageryProvider}
     */
    @JsConstructor
    public ArcGisMapServerImageryProviderOptions() {}
}
