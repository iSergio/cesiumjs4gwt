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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Sun")
public class Sun {
    /**
     * Gets or sets a number that controls how "bright" the Sun's lens flare appears to be. Zero shows just the Sun's
     * disc without any flare. Use larger values for a more pronounced flare around the Sun.
     * Default: 1.0
     */
    @JsProperty
    public double glowFactor;
    /**
     * Determines if the sun will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;

    /**
     * Draws a sun billboard.
     * This is only supported in 3D and Columbus view.
     * @see Scene#sun
     */
    @JsConstructor
    public Sun() {}

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed()
     */
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception.
     * @see #destroy()
     * @return true if this object was destroyed; otherwise, false.
     */
    public native boolean isDestroyed();
}
