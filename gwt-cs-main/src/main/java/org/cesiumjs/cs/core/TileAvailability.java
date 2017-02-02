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
import jsinterop.annotations.JsType;

/**
 * Reports the availability of tiles in a TilingScheme.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TileAvailability")
public class TileAvailability {
    /**
     * Reports the availability of tiles in a TilingScheme.
     * @param tilingScheme The tiling scheme in which to report availability.
     * @param maximumLevel The maximum tile level that is potentially available.
     */
    @JsConstructor
    public TileAvailability(TilingScheme tilingScheme, int maximumLevel) {}

    /**
     * Marks a rectangular range of tiles in a particular level as being available. For best performance, add your ranges in order of increasing level.
     * @param level The level.
     * @param startX The X coordinate of the first available tiles at the level.
     * @param startY The Y coordinate of the first available tiles at the level.
     * @param endX The X coordinate of the last available tiles at the level.
     * @param endY The Y coordinate of the last available tiles at the level.
     */
    @JsMethod
    public native void addAvailableTileRange(int level, int startX, int startY, int endX, int endY);

    /**
     * Finds the most detailed level that is available _everywhere_ within a given rectangle. More detailed tiles may be
     * available in parts of the rectangle, but not the whole thing. The return value of this function may be safely
     * passed to sampleTerrain for any position within the rectangle. This function usually completes in time logarithmic
     * to the number of rectangles added with TileAvailability#addAvailableTileRange.
     * @param rectangle The rectangle.
     * @return The best available level for the entire rectangle.
     */
    @JsMethod
    public native int computeBestAvailableLevelOverRectangle(Rectangle rectangle);

    /**
     * Computes a bit mask indicating which of a tile's four children exist. If a child's bit is set, a tile is available
     * for that child. If it is cleared, the tile is not available. The bit values are as follows:
     * <pre>
     *     {@code
     *         Bit Position	Bit Value	Child Tile
     *         0	        1       	Southwest
     *         1	        2	        Southeast
     *         2	        4	        Northwest
     *         3	        8	        Northeast
     *     }
     * </pre>
     * @param level The level of the parent tile.
     * @param x The X coordinate of the parent tile.
     * @param y The Y coordinate of the parent tile.
     * @return The bit mask indicating child availability.
     */
    @JsMethod
    public native int computeChildMaskForTile(int level, int x, int y);

    /**
     * Determines the level of the most detailed tile covering the position. This function usually completes in time
     * logarithmic to the number of rectangles added with TileAvailability#addAvailableTileRange.
     * @param position The position for which to determine the maximum available level. The height component is ignored.
     * @return The level of the most detailed tile covering the position.
     */
    @JsMethod
    public native int computeMaximumLevelAtPosition(Cartographic position);

    /**
     * Determines if a particular tile is available.
     * @param level The tile level to check.
     * @param x The X coordinate of the tile to check.
     * @param y The Y coordinate of the tile to check.
     * @return True if the tile is available; otherwise, false.
     */
    @JsMethod
    public native boolean isTileAvailable(int level, int x, int y);
}
