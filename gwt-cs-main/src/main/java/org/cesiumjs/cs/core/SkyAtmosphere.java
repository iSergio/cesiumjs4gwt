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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "SkyAtmosphere")
public class SkyAtmosphere {
    /**
     * The brightness shift to apply to the atmosphere. Defaults to 0.0 (no shift).
     * A brightness shift of -1.0 is complete darkness, which will let space show through.
     * Default:  0.0
     */
    @JsProperty
    public float brightnessShift;
    /**
     * Gets the ellipsoid the atmosphere is drawn around.
     */
    @JsProperty(name = "ellipsoid")
    public native Ellipsoid ellipsoid();
    /**
     * The hue shift to apply to the atmosphere. Defaults to 0.0 (no shift). A hue shift of 1.0 indicates a complete rotation of the hues available.
     * Default:  0.0
     */
    @JsProperty
    public float hueShift;
    /**
     * The saturation shift to apply to the atmosphere. Defaults to 0.0 (no shift). A saturation shift of -1.0 is monochrome.
     * Default:  0.0
     */
    @JsProperty
    public float saturationShift;
    /**
     * Determines if the atmosphere is shown.
     * Default:  true
     */
    @JsProperty
    public boolean show;

    /**
     * An atmosphere drawn around the limb of the provided ellipsoid. Based on Accurate Atmospheric Scattering in GPU Gems 2.
     * This is only supported in 3D. atmosphere is faded out when morphing to 2D or Columbus view.
     * @see org.cesiumjs.cs.scene.Scene#skyAtmosphere
     */
    @JsConstructor
    public SkyAtmosphere() {}

    /**
     * An atmosphere drawn around the limb of the provided ellipsoid. Based on Accurate Atmospheric Scattering in GPU Gems 2.
     * This is only supported in 3D. atmosphere is faded out when morphing to 2D or Columbus view.
     * @param ellipsoid The ellipsoid that the atmosphere is drawn around. Default: {@link Ellipsoid#WGS84()}
     * @see org.cesiumjs.cs.scene.Scene#skyAtmosphere
     */
    @JsConstructor
    public SkyAtmosphere(Ellipsoid ellipsoid) {}

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed()
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    @JsMethod
    public native boolean isDestroyed();
}
