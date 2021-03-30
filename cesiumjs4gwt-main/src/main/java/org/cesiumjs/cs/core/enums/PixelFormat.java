/*
 * Copyright 2018 iserge.
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

package org.cesiumjs.cs.core.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The format of a pixel, i.e., the number of components it has and what they
 * represent.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PixelFormat")
public class PixelFormat {
    @JsConstructor
    private PixelFormat() {
    }

    /**
     * A pixel format containing an alpha channel.
     */
    @JsProperty(name = "ALPHA")
    public static native Number ALPHA();

    /**
     * A pixel format containing a depth value.
     */
    @JsProperty(name = "DEPTH_COMPONENT")
    public static native Number DEPTH_COMPONENT();

    /**
     * A pixel format containing a depth and stencil value, most often used with
     * PixelDatatype.UNSIGNED_INT_24_8.
     */
    @JsProperty(name = "DEPTH_STENCIL")
    public static native Number DEPTH_STENCIL();

    /**
     * A pixel format containing a luminance (intensity) channel.
     */
    @JsProperty(name = "LUMINANCE")
    public static native Number LUMINANCE();

    /**
     * A pixel format containing luminance (intensity) and alpha channels.
     */
    @JsProperty(name = "LUMINANCE_ALPHA")
    public static native Number LUMINANCE_ALPHA();

    /**
     * A pixel format containing red, green, and blue channels.
     */
    @JsProperty(name = "RGB")
    public static native Number RGB();

    /**
     * A pixel format containing red, green, and blue channels that is DXT1
     * compressed.
     */
    @JsProperty(name = "RGB_DXT1")
    public static native Number RGB_DXT1();

    /**
     * A pixel format containing red, green, and blue channels that is ETC1
     * compressed.
     */
    @JsProperty(name = "RGB_ETC1")
    public static native Number RGB_ETC1();

    /**
     * A pixel format containing red, green, and blue channels that is PVR 2bpp
     * compressed.
     */
    @JsProperty(name = "RGB_PVRTC_2BPPV1")
    public static native Number RGB_PVRTC_2BPPV1();

    /**
     * A pixel format containing red, green, and blue channels that is PVR 4bpp
     * compressed.
     */
    @JsProperty(name = "RGB_PVRTC_4BPPV1")
    public static native Number RGB_PVRTC_4BPPV1();

    /**
     * A pixel format containing red, green, blue, and alpha channels.
     */
    @JsProperty(name = "RGBA")
    public static native Number RGBA();

    /**
     * A pixel format containing red, green, blue, and alpha channels that is DXT1
     * compressed.
     */
    @JsProperty(name = "RGBA_DXT1")
    public static native Number RGBA_DXT1();

    /**
     * A pixel format containing red, green, blue, and alpha channels that is DXT3
     * compressed.
     */
    @JsProperty(name = "RGBA_DXT3")
    public static native Number RGBA_DXT3();

    /**
     * A pixel format containing red, green, blue, and alpha channels that is DXT5
     * compressed.
     */
    @JsProperty(name = "RGBA_DXT5")
    public static native Number RGBA_DXT5();

    /**
     * A pixel format containing red, green, blue, and alpha channels that is PVR
     * 2bpp compressed.
     */
    @JsProperty(name = "RGBA_PVRTC_2BPPV1")
    public static native Number RGBA_PVRTC_2BPPV1();

    /**
     * A pixel format containing red, green, blue, and alpha channels that is PVR
     * 4bpp compressed.
     */
    @JsProperty(name = "RGBA_PVRTC_4BPPV1")
    public static native Number RGBA_PVRTC_4BPPV1();
}
