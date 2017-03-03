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
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.TilingScheme;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ArcGisImageServerTerrainProviderOptions {
    /**
     * The URL of the ArcGIS ImageServer service.
     */
    @JsProperty
    public String url;
    /**
     * The authorization token to use to connect to the service.
     */
    @JsProperty
    public String token;
    /**
     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
     */
    @JsProperty
    public Object proxy;
    /**
     * The tiling scheme specifying how the terrain is broken into tiles.
     * If this parameter is not provided, a {@link org.cesiumjs.cs.core.GeographicTilingScheme} is used.
     */
    @JsProperty
    public TilingScheme tilingScheme;
    /**
     * The ellipsoid. If the tilingScheme is specified, this parameter is ignored and the
     * tiling scheme's ellipsoid is used instead. If neither parameter is specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The credit, which will is displayed on the canvas.
     */
    @JsProperty
    public Credit credit;

    @JsConstructor
    public ArcGisImageServerTerrainProviderOptions() {}
}
