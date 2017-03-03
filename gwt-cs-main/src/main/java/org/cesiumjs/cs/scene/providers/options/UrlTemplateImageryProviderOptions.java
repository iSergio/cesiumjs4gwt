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
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.TilingScheme;
import org.cesiumjs.cs.scene.GetFeatureInfoFormat;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class UrlTemplateImageryProviderOptions {
    /**
     * The URL template to use to request tiles. It has the following keywords:
     * {z}: The level of the tile in the tiling scheme. Level zero is the root of the quadtree pyramid.
     * {x}: The tile X coordinate in the tiling scheme, where 0 is the Westernmost tile.
     * {y}: The tile Y coordinate in the tiling scheme, where 0 is the Northernmost tile.
     * {s}: One of the available subdomains, used to overcome browser limits on the number of simultaneous requests per host.
     * {reverseX}: The tile X coordinate in the tiling scheme, where 0 is the Easternmost tile.
     * {reverseY}: The tile Y coordinate in the tiling scheme, where 0 is the Southernmost tile.
     * {reverseZ}: The level of the tile in the tiling scheme, where level zero is the maximum level of the quadtree pyramid. In order to use reverseZ, maximumLevel must be defined.
     * {westDegrees}: The Western edge of the tile in geodetic degrees.
     * {southDegrees}: The Southern edge of the tile in geodetic degrees.
     * {eastDegrees}: The Eastern edge of the tile in geodetic degrees.
     * {northDegrees}: The Northern edge of the tile in geodetic degrees.
     * {westProjected}: The Western edge of the tile in projected coordinates of the tiling scheme.
     * {southProjected}: The Southern edge of the tile in projected coordinates of the tiling scheme.
     * {eastProjected}: The Eastern edge of the tile in projected coordinates of the tiling scheme.
     * {northProjected}: The Northern edge of the tile in projected coordinates of the tiling scheme.
     * {width}: The width of each tile in pixels.
     * {height}: The height of each tile in pixels.
     */
    @JsProperty
    public String url;
    /**
     * The URL template to use to pick features. If this property is not specified,
     * UrlTemplateImageryProvider#pickFeatures will immediately returned undefined, indicating no features picked.
     * The URL template supports all of the keywords supported by the url parameter, plus the following:
     * {i}: The pixel column (horizontal coordinate) of the picked position, where the Westernmost pixel is 0.
     * {j}: The pixel row (vertical coordinate) of the picked position, where the Northernmost pixel is 0.
     * {reverseI}: The pixel column (horizontal coordinate) of the picked position, where the Easternmost pixel is 0.
     * {reverseJ}: The pixel row (vertical coordinate) of the picked position, where the Southernmost pixel is 0.
     * {longitudeDegrees}: The longitude of the picked position in degrees.
     * {latitudeDegrees}: The latitude of the picked position in degrees.
     * {longitudeProjected}: The longitude of the picked position in the projected coordinates of the tiling scheme.
     * {latitudeProjected}: The latitude of the picked position in the projected coordinates of the tiling scheme.
     * {format}: The format in which to get feature information, as specified in the GetFeatureInfoFormat.
     */
    @JsProperty
    public String pickFeaturesUrl;
    /**
     * Gets the URL scheme zero padding for each tile coordinate. The format is '000' where each coordinate will be padded
     * on the left with zeros to match the width of the passed string of zeros. e.g.
     * Setting: urlSchemeZeroPadding : { '{x}' : '0000'} will cause an 'x' value of 12 to return the string '0012' for {x}
     * in the generated URL. It the passed object has the following keywords:
     * {z}: The zero padding for the level of the tile in the tiling scheme.
     * {x}: The zero padding for the tile X coordinate in the tiling scheme.
     * {y}: The zero padding for the the tile Y coordinate in the tiling scheme.
     * {reverseX}: The zero padding for the tile reverseX coordinate in the tiling scheme.
     * {reverseY}: The zero padding for the tile reverseY coordinate in the tiling scheme.
     * {reverseZ}: The zero padding for the reverseZ coordinate of the tile in the tiling scheme.
     */
    @JsProperty
    public String urlSchemeZeroPadding;
    /**
     * The subdomains to use for the {s} placeholder in the URL template. If this parameter is a single string,
     * each character in the string is a subdomain. If it is an array, each element in the array is a subdomain.
     * Default: 'abc'
     */
    @JsProperty
    public String[] subdomains;
    //TODO: Proxy
//    /**
//     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL.
//     */
//    @JsProperty
//    public Proxy proxy;
    /**
     * A credit for the data source, which is displayed on the canvas.
     */
    @JsProperty
    public Credit credit;
    /**
     * The minimum level-of-detail supported by the imagery provider. Take care when specifying this that the number
     * of tiles at the minimum level is small, such as four or less. A larger number is likely to result in rendering problems.
     */
    @JsProperty
    public int minimumLevel;
    /**
     * The maximum level-of-detail supported by the imagery provider, or undefined if there is no limit.
     */
    @JsProperty
    public int maximumLevel;
    /**
     * The rectangle, in radians, covered by the image.
     * Default: {@link Rectangle#MAX_VALUE()}
     */
    @JsProperty
    public Rectangle rectangle;
    /**
     * The tiling scheme specifying how the ellipsoidal surface is broken into tiles. If this parameter is not provided,
     * a WebMercatorTilingScheme is used.
     * Default: {@link org.cesiumjs.cs.core.WebMercatorTilingScheme}
     */
    @JsProperty
    public TilingScheme tilingScheme;
    /**
     * The ellipsoid. If the tilingScheme is specified, this parameter is ignored and the tiling scheme's
     * ellipsoid is used instead. If neither parameter is specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * Pixel width of image tiles.
     * Default: 256
     */
    @JsProperty
    public int tileWidth;
    /**
     * Pixel height of image tiles.
     * Default: 256
     */
    @JsProperty
    public int tileHeight;
    /**
     * true if the images provided by this imagery provider include an alpha channel; otherwise, false.
     * If this property is false, an alpha channel, if present, will be ignored. If this property is true, any images
     * without an alpha channel will be treated as if their alpha is 1.0 everywhere. When this property is false,
     * memory usage and texture upload time are potentially reduced.
     */
    @JsProperty
    public boolean hasAlphaChannel;
    /**
     * The formats in which to get feature information at a specific location when UrlTemplateImageryProvider#pickFeatures is invoked.
     * If this parameter is not specified, feature picking is disabled.
     */
    @JsProperty
    public GetFeatureInfoFormat[] getFeatureInfoFormats;
    /**
     * If true, UrlTemplateImageryProvider#pickFeatures will request the options.pickFeaturesUrl and attempt to interpret
     * the features included in the response. If false, UrlTemplateImageryProvider#pickFeatures will immediately
     * return undefined (indicating no pickable features) without communicating with the server.
     * Set this property to false if you know your data source does not support picking features or if you don't
     * want this provider's features to be pickable. Note that this can be dynamically overridden by modifying the
     * UriTemplateImageryProvider#enablePickFeatures property.
     */
    @JsProperty
    public boolean enablePickFeatures;

    /**
     * Options for {@link org.cesiumjs.cs.scene.providers.UrlTemplateImageryProvider}
     */
    @JsConstructor
    public UrlTemplateImageryProviderOptions() {}
}
