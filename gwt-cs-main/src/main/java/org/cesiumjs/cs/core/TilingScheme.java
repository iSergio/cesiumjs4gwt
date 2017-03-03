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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.projection.MapProjection;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TilingScheme")
public class TilingScheme {
    /**
     * Gets the ellipsoid that is tiled by the tiling scheme.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * Gets the map projection used by the tiling scheme.
     */
    @JsProperty
    public MapProjection projection;
    /**
     * Gets the rectangle, in radians, covered by this tiling scheme.
     */
    @JsProperty
    public Rectangle rectangle;

    /**
     * A tiling scheme for geometry or imagery on the surface of an ellipsoid. At level-of-detail zero, the coarsest,
     * least-detailed level, the number of tiles is configurable.
     * At level of detail one, each of the level zero tiles has four children, two in each direction. At level of detail
     * two, each of the level one tiles has four children, two in each direction. This continues for as many levels as
     * are present in the geometry or imagery source.
     * @see WebMercatorTilingScheme
     * @see GeographicTilingScheme
     */
    @JsConstructor
    public TilingScheme() {}

    /**
     * Gets the total number of tiles in the X direction at a specified level-of-detail.
     * @param level The level-of-detail.
     * @return The number of tiles in the X direction at the given level.
     */
    @JsMethod
    public native int getNumberOfXTilesAtLevel(int level);

    /**
     * Gets the total number of tiles in the Y direction at a specified level-of-detail.
     * @param level The level-of-detail.
     * @return The number of tiles in the Y direction at the given level.
     */
    @JsMethod
    public native int getNumberOfYTilesAtLevel(int level);

    /**
     * Calculates the tile x, y coordinates of the tile containing a given cartographic position.
     * @param position The position.
     * @param level The tile level-of-detail. Zero is the least detailed.
     * @return The specified 'result', or a new object containing the tile x, y coordinates if 'result' is undefined.
     */
    @JsMethod
    public native Cartesian2 positionToTileXY(Cartographic position, int level);

    /**
     * Calculates the tile x, y coordinates of the tile containing a given cartographic position.
     * @param position The position.
     * @param level The tile level-of-detail. Zero is the least detailed.
     * @param result The instance to which to copy the result, or undefined if a new instance should be created.
     * @return The specified 'result', or a new object containing the tile x, y coordinates if 'result' is undefined.
     */
    @JsMethod
    public native Cartesian2 positionToTileXY(Cartographic position, int level, Cartesian2 result);

    /**
     * Transforms an rectangle specified in geodetic radians to the native coordinate system of this tiling scheme.
     * @param rectangle The rectangle to transform.
     * @return The specified 'result', or a new object containing the native rectangle if 'result' is undefined.
     */
    @JsMethod
    public native Rectangle rectangleToNativeRectangle(Rectangle rectangle);

    /**
     * Transforms an rectangle specified in geodetic radians to the native coordinate system of this tiling scheme.
     * @param rectangle The rectangle to transform.
     * @param result The instance to which to copy the result, or undefined if a new instance should be created.
     * @return The specified 'result', or a new object containing the native rectangle if 'result' is undefined.
     */
    @JsMethod
    public native Rectangle rectangleToNativeRectangle(Rectangle rectangle, Rectangle result);

    /**
     * Converts tile x, y coordinates and level to an rectangle expressed in the native coordinates of the tiling scheme.
     * @param x The integer x coordinate of the tile.
     * @param y The integer y coordinate of the tile.
     * @param level The tile level-of-detail. Zero is the least detailed.
     * @return The specified 'result', or a new object containing the rectangle if 'result' is undefined.
     */
    @JsMethod
    public native Rectangle tileXYToNativeRectangle(int x, int y, int level);

    /**
     * Converts tile x, y coordinates and level to an rectangle expressed in the native coordinates of the tiling scheme.
     * @param x The integer x coordinate of the tile.
     * @param y The integer y coordinate of the tile.
     * @param level The tile level-of-detail. Zero is the least detailed.
     * @param result The instance to which to copy the result, or undefined if a new instance should be created.
     * @return The specified 'result', or a new object containing the rectangle if 'result' is undefined.
     */
    @JsMethod
    public native Rectangle tileXYToNativeRectangle(int x, int y, int level, Rectangle result);

    /**
     * Converts tile x, y coordinates and level to a cartographic rectangle in radians.
     * @param x The integer x coordinate of the tile.
     * @param y The integer y coordinate of the tile.
     * @param level The tile level-of-detail. Zero is the least detailed.
     * @return The specified 'result', or a new object containing the rectangle if 'result' is undefined.
     */
    @JsMethod
    public native Rectangle tileXYToRectangle(int x, int y, int level);

    /**
     * Converts tile x, y coordinates and level to a cartographic rectangle in radians.
     * @param x The integer x coordinate of the tile.
     * @param y The integer y coordinate of the tile.
     * @param level The tile level-of-detail. Zero is the least detailed.
     * @param result The instance to which to copy the result, or undefined if a new instance should be created.
     * @return The specified 'result', or a new object containing the rectangle if 'result' is undefined.
     */
    @JsMethod
    public native Rectangle tileXYToRectangle(int x, int y, int level, Rectangle result);
}
