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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.TilingScheme;
import org.cesiumjs.cs.scene.GetFeatureInfoFormat;
import org.cesiumjs.cs.scene.GetFeatureInfoParameters;
import org.cesiumjs.cs.scene.WebMapServiceParameters;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WebMapServiceImageryProviderOptions {
    /**
     * The URL of the WMS service. The URL supports the same keywords as the UrlTemplateImageryProvider.
     */
    @JsProperty
    public String url;
    /**
     * The layers to include, separated by commas.
     */
    @JsProperty
    public String layers;
    /**
     * Additional parameters to pass to the WMS server in the GetMap URL.
     */
    @JsProperty
    public WebMapServiceParameters parameters;
    /**
     * Additional parameters to pass to the WMS server in the GetFeatureInfo URL.
     * WebMapServiceImageryProvider.GetFeatureInfoDefaultParameters
     */
    @JsProperty
    public GetFeatureInfoParameters getFeatureInfoParameters;
    /**
     * If true, WebMapServiceImageryProvider#pickFeatures will invoke the GetFeatureInfo operation on the WMS server
     * and return the features included in the response. If false, WebMapServiceImageryProvider#pickFeatures will
     * immediately return undefined (indicating no pickable features) without communicating with the server.
     * Set this property to false if you know your WMS server does not support GetFeatureInfo or if you don't
     * want this provider's features to be pickable. Note that this can be dynamically overridden by modifying the
     * WebMapServiceImageryProvider#enablePickFeatures property.
     * Default: true
     */
    @JsProperty
    public boolean enablePickFeatures;
    /**
     * The formats in which to try WMS GetFeatureInfo requests.
     * WebMapServiceImageryProvider.DefaultGetFeatureInfoFormats
     */
    @JsProperty
    public GetFeatureInfoFormat[] getFeatureInfoFormats;
    /**
     * The rectangle of the layer.
     * Default: {@link org.cesiumjs.cs.core.Rectangle#MAX_VALUE()}
     */
    @JsProperty
    public Rectangle rectangle;
    /**
     * The tiling scheme to use to divide the world into tiles.
     * Default: new {@link org.cesiumjs.cs.core.GeographicTilingScheme}
     */
    @JsProperty
    public TilingScheme tilingScheme;
    /**
     * The ellipsoid. If the tilingScheme is specified, this parameter is ignored and the tiling scheme's ellipsoid is
     * used instead. If neither parameter is specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The width of each tile in pixels.
     * Default: 256
     */
    @JsProperty
    public int tileWidth;
    /**
     * The height of each tile in pixels.
     * Default: 256
     */
    @JsProperty
    public int tileHeight;
    /**
     * The minimum level-of-detail supported by the imagery provider. Take care when specifying this that the number
     * of tiles at the minimum level is small, such as four or less. A larger number is likely to result in rendering problems.
     * Default: 0
     */
    @JsProperty
    public int minimumLevel;
    /**
     * The maximum level-of-detail supported by the imagery provider, or undefined if there is no limit. If not specified, there is no limit.
     */
    @JsProperty
    public int maximumLevel;
    /**
     * A credit for the data source, which is displayed on the canvas.
     */
    @JsProperty
    public Credit credit;
    //TODO: Proxy
//    /**
//     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
//     */
//    @JsProperty
//    public Proxy proxy;
    /**
     * 'abc'
     */
    @JsProperty
    public String[] subdomains;
}
