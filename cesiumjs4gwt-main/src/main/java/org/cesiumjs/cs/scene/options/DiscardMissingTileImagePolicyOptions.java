/*
 * Copyright 2019 iserge.
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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Resource;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DiscardMissingTileImagePolicyOptions {
    /**
     * The URL of the known missing image.
     */
    @JsProperty
    public Resource missingImageUrl;
    /**
     * The URL of the known missing image.
     */
    @JsProperty(name = "missingImageUrl")
    public Resource missingImageUrlStr;
    /**
     * An array of Cartesian2 pixel positions to compare against the missing image.
     */
    @JsProperty
    public Cartesian2[] pixelsToCheck;
    /**
     * If true, the discard check will be disabled if all of the pixelsToCheck in
     * the missingImageUrl have an alpha value of 0. If false, the discard check
     * will proceed no matter the values of the pixelsToCheck. Default: false
     */
    @JsProperty
    public boolean disableCheckIfAllPixelsAreTransparent;

    @JsConstructor
    public DiscardMissingTileImagePolicyOptions() {
    }
}
