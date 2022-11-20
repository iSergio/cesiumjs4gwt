/*
 * Copyright 2022 iSergio, Gis4Fun.
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
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.core.providers.ArcGISTiledElevationTerrainProvider;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.options.Cesium3DTilesetOptions;
import org.cesiumjs.cs.scene.providers.I3SDataProvider;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class I3SDataProviderOptions {
    /**
     * The url of the I3S dataset.
     */
    @JsProperty
    public Resource url;
    /**
     * The url of the I3S dataset.
     */
    @JsProperty(name = "url")
    public String urlStr;
    /**
     * The name of the I3S dataset.
     */
    @JsProperty
    public String name;
    /**
     * Determines if the dataset will be shown.
     */
    @JsProperty
    public boolean show;
    /**
     * Tiled elevation provider describing an Earth Gravitational Model. If defined, geometry will be shifted based
     * on the offsets given by this provider. Required to position I3S data sets with gravity-related height at the
     * correct location.
     */
    @JsProperty
    public ArcGISTiledElevationTerrainProvider geoidTiledTerrainProvider;
    /**
     * Debug option. When true, log a message whenever an I3S tile is fetched.
     * Default: false
     */
    @JsProperty
    public boolean traceFetches;
    /**
     * Object containing options to pass to an internally created Cesium3DTileset. See Cesium3DTileset for list
     * of valid properties. All options can be used with the exception of url and show which are overridden by values
     * from I3SDataProvider.
     */
    @JsProperty
    public Cesium3DTilesetOptions cesium3dTilesetOptions;

    @JsConstructor
    public I3SDataProviderOptions() {
        //
    }

    @JsOverlay
    public static I3SDataProviderOptions create(Resource url) {
        I3SDataProviderOptions options = new I3SDataProviderOptions();
        options.url = url;
        return options;
    }

    @JsOverlay
    public static I3SDataProviderOptions create(String url) {
        I3SDataProviderOptions options = new I3SDataProviderOptions();
        options.urlStr = url;
        return options;
    }

    @JsOverlay
    public final I3SDataProviderOptions setTraceFetches(boolean traceFetches) {
        this.traceFetches = traceFetches;
        return this;
    }

    @JsOverlay
    public final I3SDataProviderOptions setGeoidTiledTerrainProvider(ArcGISTiledElevationTerrainProvider geoidTiledTerrainProvider) {
        this.geoidTiledTerrainProvider = geoidTiledTerrainProvider;
        return this;
    }

    @JsOverlay
    public final I3SDataProviderOptions setCesium3dTilesetOptions(Cesium3DTilesetOptions cesium3dTilesetOptions) {
        this.cesium3dTilesetOptions = cesium3dTilesetOptions;
        return this;
    }
}
