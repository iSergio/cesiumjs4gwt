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

package org.cesiumjs.cs.scene.options;

import com.google.gwt.typedarrays.shared.Uint8Array;
import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.core.enums.PixelDatatype;
import org.cesiumjs.cs.core.enums.PixelFormat;
import org.cesiumjs.cs.scene.TextureUniform;
import org.cesiumjs.cs.scene.enums.TextureMagnificationFilter;
import org.cesiumjs.cs.scene.enums.TextureMinificationFilter;

/**
 * Options for {@link TextureUniform}.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TextureUniformOptions {
    /**
     * A typed array storing the contents of a texture. Values are stored in row-major order. Since WebGL uses a y-up
     * convention for textures, rows are listed from bottom to top.
     */
    @JsProperty
    public Uint8Array typedArray;
    /**
     * The width of the image. Required when {@link this#typedArray} is present.
     */
    @JsProperty
    public int width;
    /**
     * The height of the image. Required when {@link this#typedArray} is present.
     */
    @JsProperty
    public int height;
    /**
     * A URL string or resource pointing to a texture image.
     */
    @JsProperty
    public String url;
    /**
     * A URL resource or resource pointing to a texture image.
     */
    @JsProperty(name = "url")
    public Resource urlRes;
    /**
     * When defined, the texture sampler will be set to wrap in both directions.
     * Default: true
     */
    @JsProperty
    public boolean repeat;
    /**
     * When {@link this#typedArray} is defined, this is used to determine the pixel format of the texture
     * Default: {@link PixelFormat#RGBA()}
     */
    @JsProperty
    public Number pixelFormat;
    /**
     * When {@link this#typedArray} is defined, this is the data type of pixel values in the typed array.
     * Default: {@link PixelDatatype#UNSIGNED_BYTE()}
     */
    @JsProperty
    public Number pixelDatatype;
    /**
     * The minification filter of the texture sampler.
     * Default: {@link TextureMinificationFilter#LINEAR()}
     */
    @JsProperty
    public Number minificationFilter;
    /**
     * The magnification filter of the texture sampler.
     * Default: {@link TextureMagnificationFilter#LINEAR()}
     */
    @JsProperty
    public Number magnificationFilter;
    /**
     * The maximum anisotropy of the texture sampler.
     * Default: 1.0
     */
    @JsProperty
    public Number maximumAnisotropy;

    @JsConstructor
    public TextureUniformOptions() {}

    @JsOverlay
    public final TextureUniformOptions setTypedArray(Uint8Array typedArray) {
        this.typedArray = typedArray;
        return this;
    }

    @JsOverlay
    public final TextureUniformOptions setWidth(int width) {
        this.width = width;
        return this;
    }

    @JsOverlay
    public final TextureUniformOptions setHeight(int height) {
        this.height = height;
        return this;
    }

    @JsOverlay
    public final TextureUniformOptions setUrl(String url) {
        this.url = url;
        return this;
    }

    @JsOverlay
    public final TextureUniformOptions setUrl(Resource url) {
        this.urlRes = url;
        return this;
    }

    @JsOverlay
    public final TextureUniformOptions setRepeat(boolean repeat) {
        this.repeat = repeat;
        return this;
    }

    @JsOverlay
    public final TextureUniformOptions setPixelFormat(Number pixelFormat) {
        this.pixelFormat = pixelFormat;
        return this;
    }

    @JsOverlay
    public final TextureUniformOptions setPixelDatatype(Number pixelDatatype) {
        this.pixelDatatype = pixelDatatype;
        return this;
    }

    @JsOverlay
    public final TextureUniformOptions setMinificationFilter(Number minificationFilter) {
        this.minificationFilter = minificationFilter;
        return this;
    }

    @JsOverlay
    public final TextureUniformOptions setMagnificationFilter(Number magnificationFilter) {
        this.magnificationFilter = magnificationFilter;
        return this;
    }

    @JsOverlay
    public final TextureUniformOptions setMaximumAnisotropy(Number maximumAnisotropy) {
        this.maximumAnisotropy = maximumAnisotropy;
        return this;
    }
}
