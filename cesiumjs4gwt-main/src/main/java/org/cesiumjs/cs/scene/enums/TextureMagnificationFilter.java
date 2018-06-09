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

package org.cesiumjs.cs.scene.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Enumerates all possible filters used when magnifying WebGL textures, which takes places when zooming into imagery.
 * Provides the possible values for the {@link org.cesiumjs.cs.scene.ImageryLayer#magnificationFilter} property.
 * @see TextureMinificationFilter
 * @see org.cesiumjs.cs.scene.ImageryLayer#magnificationFilter
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TextureMagnificationFilter")
public class TextureMagnificationFilter {
    /**
     * Bi-linear interpolation of image pixels to texture.
     */
    @JsProperty(name = "LINEAR")
    public static native Number LINEAR();
    /**
     * Nearest neighbor sampling of image pixels to texture.
     */
    @JsProperty(name = "NEAREST")
    public static native Number NEAREST();

    @JsConstructor
    private TextureMagnificationFilter() {}
}
