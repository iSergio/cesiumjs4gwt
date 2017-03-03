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
import org.cesiumjs.cs.scene.TileDiscardPolicy;
import org.cesiumjs.cs.scene.providers.BingMapsStyle;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class BingMapsImageryProviderOptions {
    /**
     * The url of the Bing Maps server hosting the imagery.
     */
    @JsProperty
    public String url;
    /**
     * The Bing Maps key for your application, which can be created at https://www.bingmapsportal.com/.
     * If this parameter is not provided, BingMapsApi.defaultKey is used. If BingMapsApi.defaultKey is undefined as well,
     * a message is written to the console reminding you that you must create and supply a Bing Maps key as soon as possible.
     * Please do not deploy an application that uses Bing Maps imagery without creating a separate key for your application.
     */
    @JsProperty
    public String key;
    /**
     * The protocol to use when loading tiles, e.g. 'http:' or 'https:'. By default, tiles are loaded using the same protocol as the page.
     */
    @JsProperty
    public String tileProtocol;
    /**
     * The type of Bing Maps imagery to load.
     * Default: {@link BingMapsStyle#AERIAL()}
     */
    @JsProperty
    public String mapStyle;
    /**
     * The culture to use when requesting Bing Maps imagery.
     * Not all cultures are supported. See http://msdn.microsoft.com/en-us/library/hh441729.aspx for information on the supported cultures.
     */
    @JsProperty
    public String culture;
    /**
     * The ellipsoid. If not specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The policy that determines if a tile is invalid and should be discarded. If this value is not specified,
     * a default DiscardMissingTileImagePolicy is used which requests tile 0,0 at the maximum tile level and checks pixels
     * (0,0), (120,140), (130,160), (200,50), and (200,200). If all of these pixels are transparent,
     * the discard check is disabled and no tiles are discarded. If any of them have a non-transparent color,
     * any tile that has the same values in these pixel locations is discarded. The end result of these defaults
     * should be correct tile discarding for a standard Bing Maps server. To ensure that no tiles are discarded,
     * construct and pass a NeverTileDiscardPolicy for this parameter.
     */
    @JsProperty
    public TileDiscardPolicy tileDiscardPolicy;
    //TODO: Proxy
//    /**
//     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
//     */
//    @JsProperty
//    public Proxy proxy;

    /**
     * Options for {@link org.cesiumjs.cs.scene.providers.BingMapsImageryProvider}
     */
    @JsConstructor
    public BingMapsImageryProviderOptions() {}
}
