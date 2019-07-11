/*
 * Copyright 2019 iserge.
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

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.promise.Promise;

/**
 * Options for {@link org.cesiumjs.cs.core.providers.ArcGISTiledElevationTerrainProvider}.
 * s
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ArcGISTiledElevationTerrainProviderOptions {
    /**
     * The URL of the ArcGIS ImageServer service.
     */
    @JsProperty
    public Resource url;

    /**
     * The URL of the ArcGIS ImageServer service.
     */
    @JsProperty(name = "url")
    public String urlStr;
    /**
     * The URL of the ArcGIS ImageServer service.
     */
    @JsProperty(name = "url")
    public Promise<Resource, Void> urlPromise;
    /**
     * The URL of the ArcGIS ImageServer service.
     */
    @JsProperty(name = "url")
    public Promise<String, Void> urlPromiseSrt;
    /**
     * The authorization token to use to connect to the service.
     */
    @JsProperty
    public String token;
    /**
     * The ellipsoid. If the tilingScheme is specified, this parameter is ignored and the tiling scheme's ellipsoid is used instead.
     * If neither parameter is specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;

    private ArcGISTiledElevationTerrainProviderOptions() {}

    @JsOverlay
    public static ArcGISTiledElevationTerrainProviderOptions create(Resource url) {
        ArcGISTiledElevationTerrainProviderOptions options = new ArcGISTiledElevationTerrainProviderOptions();
        options.url = url;
        return options;
    }

    @JsOverlay
    public static ArcGISTiledElevationTerrainProviderOptions create(String url) {
        ArcGISTiledElevationTerrainProviderOptions options = new ArcGISTiledElevationTerrainProviderOptions();
        options.urlStr = url;
        return options;
    }

    @JsOverlay
    public static ArcGISTiledElevationTerrainProviderOptions create(Promise<Resource, Void> promise) {
        ArcGISTiledElevationTerrainProviderOptions options = new ArcGISTiledElevationTerrainProviderOptions();
        options.urlPromise = promise;
        return options;
    }
}
