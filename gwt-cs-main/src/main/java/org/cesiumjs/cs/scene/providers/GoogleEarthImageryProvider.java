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
import org.cesiumjs.cs.scene.providers.options.GoogleEarthImageryProviderOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 * @deprecated will be removed in Cesium 1.37, use GoogleEarthEnterpriseMapsProvider instead.
 */
@Deprecated
@JsType(isNative = true, namespace = "Cesium", name = "GoogleEarthImageryProvider")
public class GoogleEarthImageryProvider implements ImageryProvider {
    /**
     * Gets the imagery channel (id) currently being used.
     */
    @JsProperty(name = "channel")
    public native int channel();
    /**
     * Gets the credit to display when this imagery provider is active. Typically this is used to credit the source of the imagery.
     * This function should not be called before GoogleEarthImageryProvider#ready returns true.
     */
    @JsProperty(name = "credit")
    public native Credit credit();
    /**
     * The default ImageryLayer#gamma to use for imagery layers created for this provider.
     * By default, this is set to 1.9. Changing this value after creating an ImageryLayer for this provider
     * will have no effect. Instead, set the layer's ImageryLayer#gamma property.
     * Default: 1.9
     */
    @JsProperty
    public double defaultGamma;
    /**
     * Gets an event that is raised when the imagery provider encounters an asynchronous error.
     * By subscribing to the event, you will be notified of the error and can potentially recover from it.
     * Event listeners are passed an instance of TileProviderError.
     */
    @JsProperty(name = "errorEvent")
    public native Event errorEvent();
    /**
     * Gets a value indicating whether or not the images provided by this imagery provider include an alpha channel.
     * If this property is false, an alpha channel, if present, will be ignored. If this property is true, any images
     * without an alpha channel will be treated as if their alpha is 1.0 everywhere. When this property is false,
     * memory usage and texture upload time are reduced.
     */
    @JsProperty(name = "hasAlphaChannel")
    public native boolean hasAlphaChannel();
    /**
     * Gets the maximum level-of-detail that can be requested. This function should not be called before
     * GoogleEarthImageryProvider#ready returns true.
     */
    @JsProperty(name = "maximumLevel")
    public native int maximumLevel();
    /**
     * Gets the minimum level-of-detail that can be requested.
     * This function should not be called before GoogleEarthImageryProvider#ready returns true.
     */
    @JsProperty(name = "minimumLevel")
    public native int minimumLevel();
    /**
     * Gets the url path of the data on the Google Earth server.
     */
    @JsProperty(name = "path")
    public native String path();
    //TODO: Proxy
//    /**
//     * Gets the proxy used by this provider.
//     */
//    @JsProperty(name = "proxy")
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
     * Gets the rectangle, in radians, of the imagery provided by this instance.
     * This function should not be called before GoogleEarthImageryProvider#ready returns true.
     */
    @JsProperty(name = "rectangle")
    public native Rectangle rectangle();
    /**
     * Gets the type of data that is being requested from the provider. This function should not be called before
     * GoogleEarthImageryProvider#ready returns true.
     */
    @JsProperty(name = "requestType")
    public native String requestType();
    /**
     * Gets the tile discard policy. If not undefined, the discard policy is responsible for filtering out "missing"
     * tiles via its shouldDiscardImage function. If this function returns undefined, no tiles are filtered.
     * This function should not be called before GoogleEarthImageryProvider#ready returns true.
     */
    @JsProperty(name = "tileDiscardPolicy")
    public native TileDiscardPolicy tileDiscardPolicy();
    /**
     * Gets the height of each tile, in pixels. This function should not be called before GoogleEarthImageryProvider#ready returns true.
     */
    @JsProperty(name = "tileHeight")
    public native int tileHeight();
    /**
     * Gets the width of each tile, in pixels. This function should not be called before GoogleEarthImageryProvider#ready returns true.
     */
    @JsProperty(name = "tileWidth")
    public native int tileWidth();
    /**
     * Gets the tiling scheme used by this provider. This function should not be called before GoogleEarthImageryProvider#ready returns true.
     */
    @JsProperty(name = "tilingScheme")
    public native TilingScheme tilingScheme();
    /**
     * Gets the URL of the Google Earth MapServer.
     */
    @JsProperty(name = "url")
    public native String url();
    /**
     * Gets the version of the data used by this provider. This function should not be called before GoogleEarthImageryProvider#ready returns true.
     */
    @JsProperty(name = "version")
    public native double version();

    /**
     * Provides tiled imagery using the Google Earth Imagery API. Notes: This imagery provider does not work with the
     * public Google Earth servers. It works with the Google Earth Enterprise Server.
     * By default the Google Earth Enterprise server does not set
     * the <a href="http://www.w3.org/TR/cors/">Cross-Origin Resource Sharing</a> headers.
     * You can either use a proxy server which adds these headers, or in the /opt/google/gehttpd/conf/gehttpd.conf and
     * add the 'Header set Access-Control-Allow-Origin "*"' option to the '<Directory />'
     * and '<Directory "/opt/google/gehttpd/htdocs">' directives.
     * <pre>
     *     {@code
     *     GoogleEarthImageryProviderOptions options = new GoogleEarthImageryProviderOptions();
     *     options.channel = 1008;
     *     options.utl = "https://earth.localdomain";
     *     ImageryProvider google = new GoogleEarthImageryProvider(options);
     *     }
     * </pre>
     * @param options Options
     */
    @JsConstructor
    public GoogleEarthImageryProvider(GoogleEarthImageryProviderOptions options) {}

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
     * Picking features is not currently supported by this imagery provider, so this function simply returns undefined.
     * @param x The tile X coordinate.
     * @param y The tile Y coordinate.
     * @param level The tile level.
     * @param longitude The longitude at which to pick features.
     * @param latitude The latitude at which to pick features.
     * @return A promise for the picked features that will resolve when the asynchronous picking completes.
     * The resolved value is an array of ImageryLayerFeatureInfo instances. The array may be empty if no features are
     * found at the given location. It may also be undefined if picking is not supported.
     */
    @JsMethod
    public native Promise<ImageryLayerFeatureInfo[], Void> pickFeatures(int x, int y, int level, double longitude, double latitude);

    /**
     * Requests the image for a given tile. This function should not be called before GoogleEarthImageryProvider#ready returns true.
     * @param x The tile X coordinate.
     * @param y The tile Y coordinate.
     * @param level The tile level.
     * @return A promise for the image that will resolve when the image is available, or undefined if there are
     * too many active requests to the server, and the request should be retried later. The resolved image may
     * be either an Image or a Canvas DOM object.
     */
    @JsMethod
    public native Promise<JsImage, Void> requestImage(int x, int y, int level);
}