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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Rectangle;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TilingSchemeOptions {
    /**
     * The ellipsoid whose surface is being tiled. Defaults to the WGS84 ellipsoid.
     * Default: {@link Ellipsoid#WGS84}
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The rectangle, in radians, covered by the tiling scheme.
     * Default: Rectangle.MAX_VALUE
     */
    @JsProperty
    public Rectangle rectangle;
    /**
     * The number of tiles in the X direction at level zero of the tile tree.
     * Default: 2
     */
    @JsProperty
    public int numberOfLevelZeroTilesX;
    /**
     * The number of tiles in the Y direction at level zero of the tile tree.
     */
    @JsProperty
    public int numberOfLevelZeroTilesY;
}
