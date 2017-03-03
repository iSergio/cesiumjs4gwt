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
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.scene.options.MoonOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Moon")
public class Moon {
    /**
     * Determines whether the moon will be rendered.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * The moon texture.
     * Default: buildModuleUrl('Assets/Textures/moonSmall.jpg')
     */
    @JsProperty
    public String textureUrl;
    /**
     * The moon ellipsoid.
     * Default: {@link Ellipsoid#MOON()}
     */
    @JsProperty(name = "ellipsoid")
    public native Ellipsoid ellipsoid();
    /**
     * Use the sun as the only light source.
     * Default: true
     */
    @JsProperty
    public boolean onlySunLighting;

    /**
     * Draws the Moon in 3D.
     * @see Scene#moon
     */
    @JsConstructor
    public Moon() {}

    /**
     * Draws the Moon in 3D.
     * @param options Options.
     * @see Scene#moon
     */
    @JsConstructor
    public Moon(MoonOptions options) {}

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
     * @return true if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    public native boolean isDestroyed();
}
