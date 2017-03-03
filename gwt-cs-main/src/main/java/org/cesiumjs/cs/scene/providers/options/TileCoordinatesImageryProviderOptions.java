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
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.TilingScheme;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TileCoordinatesImageryProviderOptions {
    /**
     * The tiling scheme for which to draw tiles.
     * Default: new GeographicTilingScheme()
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
     * The color to draw the tile box and label.
     * Default: {@link org.cesiumjs.cs.core.Color#YELLOW()}
     */
    @JsProperty
    public Color color;
    /**
     * The width of the tile for level-of-detail selection purposes.
     * Default: 256
     */
    @JsProperty
    public int tileWidth;
    /**
     * The height of the tile for level-of-detail selection purposes.
     * Default: 256
     */
    @JsProperty
    public int tileHeight;

    /**
     * Options for {@link org.cesiumjs.cs.scene.providers.TileCoordinatesImageryProvider}
     */
    @JsConstructor
    public TileCoordinatesImageryProviderOptions() {}
}
