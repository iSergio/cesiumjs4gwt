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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.scene.enums.ImagerySplitDirection;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageryLayerOptions {
    /**
     * The rectangle of the layer. This rectangle can limit the visible portion of the imagery provider.
     * Default: imageryProvider.rectangle
     */
    @JsProperty
    public Rectangle rectangle;
    /**
     * The alpha blending value of this layer, from 0.0 to 1.0. This can either be a simple number or a function with
     * the signature function(frameState, layer, x, y, level). The function is passed the current frame state, this layer,
     * and the x, y, and level coordinates of the imagery tile for which the alpha is required, and it is expected to
     * return the alpha value to use for the tile.
     * Default: 1.0
     */
    @JsProperty
    public float alpha;
    /**
     * The brightness of this layer. 1.0 uses the unmodified imagery color. Less than 1.0 makes the imagery darker
     * while greater than 1.0 makes it brighter. This can either be a simple number or a function with the signature
     * function(frameState, layer, x, y, level). The function is passed the current frame state, this layer, and the x,
     * y, and level coordinates of the imagery tile for which the brightness is required, and it is expected to return
     * the brightness value to use for the tile. The function is executed for every frame and for every tile, so it must be fast.
     * Default: 1.0
     */
    @JsProperty
    public float brightness;
    /**
     * The contrast of this layer. 1.0 uses the unmodified imagery color. Less than 1.0 reduces the contrast while
     * greater than 1.0 increases it. This can either be a simple number or a function with the signature
     * function(frameState, layer, x, y, level). The function is passed the current frame state, this layer, and the x, y, and
     * level coordinates of the imagery tile for which the contrast is required, and it is expected to return the
     * contrast value to use for the tile. The function is executed for every frame and for every tile, so it must be fast.
     * Default: 1.0
     */
    @JsProperty
    public float contrast;
    /**
     * The hue of this layer. 0.0 uses the unmodified imagery color. This can either be a simple number or a function
     * with the signature function(frameState, layer, x, y, level). The function is passed the current frame state, this
     * layer, and the x, y, and level coordinates of the imagery tile for which the hue is required, and it is expected to
     * return the contrast value to use for the tile. The function is executed for every frame and for every tile, so it must be fast.
     * Default: 0.0
     */
    @JsProperty
    public float hue;
    /**
     * The saturation of this layer. 1.0 uses the unmodified imagery color. Less than 1.0 reduces the saturation while
     * greater than 1.0 increases it. This can either be a simple number or a function with the signature
     * function(frameState, layer, x, y, level). The function is passed the current frame state, this layer, and the
     * x, y, and level coordinates of the imagery tile for which the saturation is required, and it is expected to
     * return the contrast value to use for the tile. The function is executed for every frame and for every tile, so it must be fast.
     * Default: 1.0
     */
    @JsProperty
    public float saturation;
    /**
     * The gamma correction to apply to this layer. 1.0 uses the unmodified imagery color. This can either be a simple
     * number or a function with the signature function(frameState, layer, x, y, level). The function is passed the
     * current frame state, this layer, and the x, y, and level coordinates of the imagery tile for which the gamma is
     * required, and it is expected to return the gamma value to use for the tile. The function is executed for every
     * frame and for every tile, so it must be fast.
     * Default: 1.0
     */
    @JsProperty
    public float gamma;
    /**
     * The {@link ImagerySplitDirection} split to apply to this layer. Default {@link ImagerySplitDirection#NONE()}
     */
    @JsProperty
    public Number splitDirection;
    /**
     * The function split to apply to this layer. Default {@link ImagerySplitDirection#NONE()}
     */
    @JsProperty(name = "splitDirection")
    public ImagerySplitDirectionFunction splitDirectionFunction;
    /**
     * True if the layer is shown; otherwise, false.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * The maximum anisotropy level to use for texture filtering. If this parameter is not specified, the maximum
     * anisotropy supported by the WebGL stack will be used. Larger values make the imagery look better in horizon views.
     */
    @JsProperty
    public double maximumAnisotropy;
    /**
     * The minimum terrain level-of-detail at which to show this imagery layer, or undefined to show it at all levels.
     * Level zero is the least-detailed level.
     */
    @JsProperty
    public double minimumTerrainLevel;
    /**
     * The maximum terrain level-of-detail at which to show this imagery layer, or undefined to show it at all levels. Level zero is the least-detailed level.
     */
    public double maximumTerrainLevel;
    @JsConstructor
    public ImageryLayerOptions() {}

    @JsFunction
    public interface ImagerySplitDirectionFunction {
        void function(Object ...args);
    }
}
