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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.enums.ImagerySplitDirection;
import org.cesiumjs.cs.scene.options.ImageryLayerOptions;
import org.cesiumjs.cs.scene.providers.ImageryProvider;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ImageryLayer")
public class ImageryLayer {
    /**
     * This value is used as the default brightness for the imagery layer if one is not provided during construction
     * or by the imagery provider. This value does not modify the brightness of the imagery.
     * Default: 1.0
     */
    @JsProperty
    public static float DEFAULT_BRIGHTNESS;
    /**
     * This value is used as the default contrast for the imagery layer if one is not provided during construction
     * or by the imagery provider. This value does not modify the contrast of the imagery.
     * Default: 1.0
     */
    @JsProperty
    public static float DEFAULT_CONTRAST;
    /**
     * This value is used as the default gamma for the imagery layer if one is not provided during construction
     * or by the imagery provider. This value does not modify the gamma of the imagery.
     * Default: 1.0
     */
    @JsProperty
    public static float DEFAULT_GAMMA;
    /**
     * This value is used as the default hue for the imagery layer if one is not provided during construction
     * or by the imagery provider. This value does not modify the hue of the imagery.
     * Default: 0.0
     */
    @JsProperty
    public static float DEFAULT_HUE;
    /**
     * This value is used as the default saturation for the imagery layer if one is not provided during construction
     * or by the imagery provider. This value does not modify the saturation of the imagery.
     * Default: 1.0
     */
    @JsProperty
    public static float DEFAULT_SATURATION;
    /**
     * This value is used as the default spliat for the imagery layer if one is not provided during construction or by the imagery provider.
     * Default: {@link ImagerySplitDirection#NONE()}
     */
    @JsProperty
    public static Number DEFAULT_SPLIT;
    /**
     * The alpha blending value of this layer, with 0.0 representing fully transparent and 1.0 representing fully opaque.
     * Default: 1.0
     */
    @JsProperty
    public float alpha;
    /**
     * The brightness of this layer. 1.0 uses the unmodified imagery color. Less than 1.0 makes the imagery darker
     * while greater than 1.0 makes it brighter.
     * Default: {@link ImageryLayer#DEFAULT_BRIGHTNESS}
     */
    @JsProperty
    public float brightness;
    /**
     * The contrast of this layer. 1.0 uses the unmodified imagery color. Less than 1.0 reduces the contrast while
     * greater than 1.0 increases it.
     * Default: {@link ImageryLayer#DEFAULT_CONTRAST}
     */
    @JsProperty
    public float contrast;
    /**
     * The gamma correction to apply to this layer. 1.0 uses the unmodified imagery color.
     * Default: {@link ImageryLayer#DEFAULT_GAMMA}
     */
    @JsProperty
    public float gamma;
    /**
     * The hue of this layer in radians. 0.0 uses the unmodified imagery color.
     * Default: {@link ImageryLayer#DEFAULT_HUE}
     */
    @JsProperty
    public float hue;
    /**
     * Gets the imagery provider for this layer.
     */
    @JsProperty(name = "imageryProvider")
    public native ImageryProvider imageryProvider();
    /**
     * Gets the rectangle of this layer. If this rectangle is smaller than the rectangle of the ImageryProvider,
     * only a portion of the imagery provider is shown.
     */
    @JsProperty(name = "rectangle")
    public native Rectangle rectangle();
    /**
     * The saturation of this layer. 1.0 uses the unmodified imagery color. Less than 1.0 reduces the saturation while
     * greater than 1.0 increases it.
     * Default: {@link ImageryLayer#DEFAULT_SATURATION}
     */
    @JsProperty
    public float saturation;
    /**
     * Determines if this layer is shown.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * The {@link org.cesiumjs.cs.scene.enums.ImagerySplitDirection} to apply to this layer.
     * Default: {ImageryLayer#DEFAULT_SPLIT}.
     */
    @JsProperty
    public Number splitDirection;

    /**
     * An imagery layer that displays tiled imagery data from a single imagery provider on a {@link org.cesiumjs.cs.core.Globe}.
     * @param imageryProvider The imagery provider to use.
     */
    @JsConstructor
    public ImageryLayer(ImageryProvider imageryProvider) {}

    /**
     * An imagery layer that displays tiled imagery data from a single imagery provider on a {@link org.cesiumjs.cs.core.Globe}.
     * @param imageryProvider The imagery provider to use.
     * @param options Options.
     */
    @JsConstructor
    public ImageryLayer(ImageryProvider imageryProvider, ImageryLayerOptions options) {}

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed()
     */
    @JsMethod
    public native void destroy();

    /**
     * Computes the intersection of this layer's rectangle with the imagery provider's availability rectangle, producing
     * the overall bounds of imagery that can be produced by this layer.
     * @return A promise to a rectangle which defines the overall bounds of imagery that can be produced by this layer.
     */
    @JsMethod
    public native Promise<Rectangle, Void> getViewableRectangle();

    /**
     * Gets a value indicating whether this layer is the base layer in the ImageryLayerCollection. The base layer is the
     * one that underlies all others. It is special in that it is treated as if it has global rectangle, even if it actually
     * does not, by stretching the texels at the edges over the entire globe.
     * @return true if this is the base layer; otherwise, false.
     */
    @JsMethod
    public native boolean isBaseLayer();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception.
     * @return True if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    @JsMethod
    public native boolean isDestroyed();
}
