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

package org.cesiumjs.cs.core.providers.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.providers.GeoserverTerrainProviderFormatArray;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeoserverTerrainProviderOptions {
    /**
     *  the name of the layer.
     */
    @JsProperty
    public String layerName;
    /**
     * The URL of the server providing wms.
     */
    @JsProperty
    public String url;
    /**
     * the xml after requesting "getCapabilities" from web map server.
     */
    @JsProperty
    public String xml;
    /**
     *  the type of service requested (WMS,TMS,WMTS). WMS is default from web map server.
     */
    @JsProperty
    public String service;
    /**
     * width  of a tile in pixels
     */
    @JsProperty
    public Integer heightMapWidth;
    /**
     * height of a tile in pixels
     */
    @JsProperty
    public Integer heightMapHeight;
    /**
     * offset of the tiles (in meters)
     */
    @JsProperty
    public double offset;
    /**
     * highest altitude in the tiles (in meters)
     */
    @JsProperty
    public double highest;
    /**
     * lowest altitude in the tiles (in meters)
     */
    @JsProperty
    public double lowest;
    /**
     * name of the Style used for images.
     */
    @JsProperty
    public String styleName;
    /**
     * indicates if the requested images are styled with SLD
     */
    @JsProperty
    public boolean hasStyledImage;
    /**
     * indicates if a water mask will be displayed (experimental)
     */
    @JsProperty
    public boolean waterMask;
    /**
     * maximum level to request
     */
    @JsProperty
    public Integer maxLevel;
    /**
     * Custom format array
     */
    @JsProperty
    public GeoserverTerrainProviderFormatArray formatArray;

    @JsConstructor
    public GeoserverTerrainProviderOptions() {}
}
