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

package org.cesiumjs.cs.scene;

import com.google.gwt.typedarrays.shared.Uint8Array;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.core.enums.PixelDatatype;
import org.cesiumjs.cs.core.enums.PixelFormat;
import org.cesiumjs.cs.scene.options.TextureUniformOptions;

/**
 * A simple struct that serves as a value of a sampler2D-valued uniform.
 * This is used with {@link CustomShader} and {@link TextureManager}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "TextureUniform")
public class TextureUniform {
    /**
     * A typed array storing the contents of a texture. Values are stored in row-major order. Since WebGL uses a y-up
     * convention for textures, rows are listed from bottom to top.
     */
    @JsProperty(name = "typedArray")
    public native Uint8Array typedArray();
    /**
     * The width of the image. Required when {@link this#typedArray} is present.
     */
    @JsProperty(name = "width")
    public native Number width();
    /**
     * The height of the image. Required when {@link this#typedArray} is present.
     */
    @JsProperty(name = "height")
    public native Number height();
    /**
     * When {@link this#typedArray} is defined, this is used to determine the pixel format of the texture
     * Default: {@link PixelFormat#RGBA()}
     */
    @JsProperty(name = "pixelFormat")
    public native Number pixelFormat();
    /**
     * When {@link this#typedArray} is defined, this is the data type of pixel values in the typed array.
     * Default: {@link PixelDatatype#UNSIGNED_BYTE()}
     */
    @JsProperty(name = "pixelDatatype")
    public native Number pixelDatatype();

    @JsConstructor
    public TextureUniform(TextureUniformOptions options) {}

    @JsOverlay
    public static TextureUniform create(String url) {
        return new TextureUniform(new TextureUniformOptions().setUrl(url));
    }

    @JsOverlay
    public static TextureUniform create(Resource url) {
        return new TextureUniform(new TextureUniformOptions().setUrl(url));
    }
}
