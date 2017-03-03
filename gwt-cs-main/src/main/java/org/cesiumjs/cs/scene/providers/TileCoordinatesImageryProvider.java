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

package org.cesiumjs.cs.scene.providers;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.TilingScheme;
import org.cesiumjs.cs.js.JsImage;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.ImageryLayerFeatureInfo;
import org.cesiumjs.cs.scene.TileDiscardPolicy;
import org.cesiumjs.cs.scene.providers.options.TileCoordinatesImageryProviderOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TileCoordinatesImageryProvider")
public class TileCoordinatesImageryProvider implements ImageryProvider {
    /**
     * Gets the credit to display when this imagery provider is active. Typically this is used to credit the source of the imagery.
     * This function should not be called before TileCoordinatesImageryProvider#ready returns true.
     */
    @JsProperty(name = "credit")
    public native Credit credit();
    /**
     * Gets an event that is raised when the imagery provider encounters an asynchronous error.
     * By subscribing to the event, you will be notified of the error and can potentially recover from it. Event listeners are passed an instance of TileProviderError.
     */
    @JsProperty(name = "errorEvent")
    public native Event errorEvent();
    /**
     * Gets a value indicating whether or not the images provided by this imagery provider include an alpha channel.
     * If this property is false, an alpha channel, if present, will be ignored.
     * If this property is true, any images without an alpha channel will be treated as if their alpha is 1.0 everywhere.
     * When this property is false, memory usage and texture upload time are reduced.
     * Default: true
     */
    @JsProperty(name = "hasAlphaChannel")
    public native boolean hasAlphaChannel();
    /**
     * Gets the maximum level-of-detail that can be requested. This function should not be called before
     * TileCoordinatesImageryProvider#ready returns true.
     */
    @JsProperty(name = "maximumLevel")
    public native int maximumLevel();
    /**
     * Gets the minimum level-of-detail that can be requested. This function should not be called before TileCoordinatesImageryProvider#ready
     * returns true.
     */
    @JsProperty(name = "minimumLevel")
    public native int minimumLevel();
    /**
     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
     */
    //TODO: Proxy
//    @JsProperty
//    public native Proxy proxy();
    /**
     * Gets a value indicating whether or not the provider is ready for use.
     */
    @JsProperty(name = "ready")
    public native boolean ready();
    /**
     * Gets a promise that resolves to true when the provider is ready for use.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<Boolean, Void> readyPromise();
    /**
     * The rectangle of the layer. This parameter is ignored when accessing a tiled layer.
     * Default: {@link Rectangle#MAX_VALUE()}
     */
    @JsProperty(name = "rectangle")
    public native Rectangle rectangle();
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
    @JsProperty(name = "tileDiscardPolicy")
    public native TileDiscardPolicy tileDiscardPolicy();
    /**
     * The width of each tile in pixels. This parameter is ignored when accessing a tiled server.
     * Default: 256
     */
    @JsProperty(name = "tileWidth")
    public native int tileWidth();
    /**
     * The height of each tile in pixels. This parameter is ignored when accessing a tiled server.
     * Default: 256
     */
    @JsProperty(name = "tileHeight")
    public native int tileHeight();
    /**
     * The tiling scheme to use to divide the world into tiles. This parameter is ignored when accessing a tiled server.
     * Default: new {@link org.cesiumjs.cs.core.GeographicTilingScheme}
     */
    @JsProperty(name = "tilingScheme")
    public native TilingScheme tilingScheme();
    
    /**
     * An ImageryProvider that draws a box around every rendered tile in the tiling scheme, and draws a label inside it
     * indicating the X, Y, Level coordinates of the tile. This is mostly useful for debugging terrain and imagery rendering problems.
     */
    @JsConstructor
    public TileCoordinatesImageryProvider() {}

    /**
     * An ImageryProvider that draws a box around every rendered tile in the tiling scheme, and draws a label inside it
     * indicating the X, Y, Level coordinates of the tile. This is mostly useful for debugging terrain and imagery rendering problems.
     * @param options Options
     */
    @JsConstructor
    public TileCoordinatesImageryProvider(TileCoordinatesImageryProviderOptions options) {}

    /**
     * Gets the credits to be displayed when a given tile is displayed.
     * @param x The tile X coordinate.
     * @param y The tile Y coordinate.
     * @param level The tile level;
     * @return The credits to be displayed when the tile is displayed.
     */
    @JsMethod
    public native Credit[] getTileCredits(int x, int y, int level);

    /**
     *
     * @param x The tile X coordinate.
     * @param y The tile Y coordinate.
     * @param level The tile level.
     * @param longitude The longitude at which to pick features.
     * @param latitude The latitude at which to pick features.
     * @return A promise for the picked features that will resolve when the asynchronous picking completes.
     * The resolved value is an array of ImageryLayerFeatureInfo instances.
     * The array may be empty if no features are found at the given location.
     */
    @JsMethod
    public native Promise<ImageryLayerFeatureInfo[], Void> pickFeatures(int x, int y, int level, double longitude, double latitude);

    /**
     * Requests the image for a given tile. This function should not be called before TileCoordinatesImageryProvider#ready returns true.
     * @param x The tile X coordinate.
     * @param y The tile Y coordinate.
     * @param level The tile level.
     * @return A promise for the image that will resolve when the image is available, or undefined if there are too many active requests to the server, and the request should be retried later. The resolved image may be either an Image or a Canvas DOM object.
     */
    @JsMethod
    public native Promise<JsImage, Void> requestImage(int x, int y, int level);
}
