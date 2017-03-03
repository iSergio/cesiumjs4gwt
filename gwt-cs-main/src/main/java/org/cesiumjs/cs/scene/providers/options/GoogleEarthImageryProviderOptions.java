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

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GoogleEarthImageryProviderOptions {
    /**
     * The url of the Google Earth server hosting the imagery.
     */
    @JsProperty
    public String url;
    /**
     * The channel (id) to be used when requesting data from the server. The channel number can be found by
     * looking at the json file located at: earth.localdomain/default_map/query?request=Json&vars=geeServerDefs
     * The /default_map path may differ depending on your Google Earth Enterprise server configuration.
     * Look for the "id" that is associated with a "ImageryMaps" requestType. There may be more than one id available.
     * Example: { layers: [ { id: 1002, requestType: "ImageryMaps" }, { id: 1007, requestType: "VectorMapsRaster" } ] }
     */
    @JsProperty
    public int channel;
    /**
     * The path of the Google Earth server hosting the imagery.
     * Default: "/default_map"
     */
    @JsProperty
    public String path;
    /**
     * The maximum level-of-detail supported by the Google Earth Enterprise server, or undefined if there is no limit.
     */
    @JsProperty
    public int maximumLevel;
    /**
     * The policy that determines if a tile is invalid and should be discarded. To ensure that no tiles are discarded, construct and pass a NeverTileDiscardPolicy for this parameter.
     */
    @JsProperty
    public TileDiscardPolicy tileDiscardPolicy;
    /**
     * The ellipsoid. If not specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    //TODO: Proxy
//    /**
//     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
//     */
//    @JsProperty
//    public Proxy proxy;

    /**
     * Options for {@link org.cesiumjs.cs.scene.providers.GoogleEarthImageryProvider}
     */
    @JsConstructor
    public GoogleEarthImageryProviderOptions() {}
}
