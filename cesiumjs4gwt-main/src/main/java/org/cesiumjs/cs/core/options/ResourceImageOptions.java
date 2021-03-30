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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for
 * {@link org.cesiumjs.cs.core.Resource#fetchImage(ResourceImageOptions)}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ResourceImageOptions extends ResourceOptions {
    /**
     * If true, we will load the image via a blob. Default: false
     */
    @JsProperty
    public boolean preferBlob;
    /**
     * If true, image will be decoded during fetch and an ImageBitmap is returned.
     * Default: false
     */
    @JsProperty
    public boolean preferImageBitmap;
    /**
     * Whether to vertically flip the image during fetch and decode. Only applies
     * when requesting an image and the browser supports createImageBitmap. Default:
     * false
     */
    @JsProperty
    public boolean flipY;
}
