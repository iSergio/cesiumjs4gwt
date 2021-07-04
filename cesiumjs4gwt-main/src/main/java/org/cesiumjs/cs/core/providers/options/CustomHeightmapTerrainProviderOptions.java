/*
 * Copyright 2021 iserge.
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

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.TilingScheme;
import org.cesiumjs.cs.core.providers.CustomHeightmapTerrainProvider;

/**
 * Options for {@link CustomHeightmapTerrainProvider}.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CustomHeightmapTerrainProviderOptions {
    /**
     * The callback function for requesting tile geometry.
     */
    @JsProperty
    public CustomHeightmapTerrainProvider.GeometryCallback callback;
    /**
     *
     */
    @JsProperty
    public int width;
    /**
     * The number of rows per heightmap tile.
     */
    @JsProperty
    public int height;
    /**
     * The tiling scheme specifying how the ellipsoidal surface is broken into tiles. If this parameter is not provided,
     * a GeographicTilingScheme is used.
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
     * A credit for the data source, which is displayed on the canvas.
     */
    @JsProperty
    public Credit credit;

    @JsConstructor
    private CustomHeightmapTerrainProviderOptions() {}

    @JsOverlay
    public static CustomHeightmapTerrainProviderOptions create(CustomHeightmapTerrainProvider.GeometryCallback callback, int width, int height) {
        CustomHeightmapTerrainProviderOptions options = new CustomHeightmapTerrainProviderOptions();
        options.callback = callback;
        options.width = width;
        options.height = height;
        return options;
    }
}
