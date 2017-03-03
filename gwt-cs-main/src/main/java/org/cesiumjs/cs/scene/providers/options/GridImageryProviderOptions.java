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
public class GridImageryProviderOptions {
    /**
     * The tiling scheme for which to draw tiles.
     * Default: {@link org.cesiumjs.cs.core.GeographicTilingScheme}
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
     * The number of grids cells.
     * Default: 8
     */
    @JsProperty
    public int cells;
    /**
     * The color to draw grid lines.
     * Default: Color(1.0, 1.0, 1.0, 0.4)
     */
    @JsProperty
    public Color color;
    /**
     * The color to draw glow for grid lines.
     * Default: Color(0.0, 1.0, 0.0, 0.05)
     */
    @JsProperty
    public Color glowColor;
    /**
     * The width of lines used for rendering the line glow effect.
     * Default: 6
     */
    @JsProperty
    public int glowWidth;
    /**
     * Background fill color.
     * Default: Color(0.0, 0.5, 0.0, 0.2)
     */
    @JsProperty
    public Color backgroundColor;
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
     * The size of the canvas used for rendering.
     * Default: 256
     */
    @JsProperty
    public int canvasSize;

    /**
     * Options for {@link org.cesiumjs.cs.scene.providers.GridImageryProvider}
     */
    @JsConstructor
    public GridImageryProviderOptions() {}
}
