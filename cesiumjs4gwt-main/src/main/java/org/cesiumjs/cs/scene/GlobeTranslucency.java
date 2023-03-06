/*
 * Copyright 2023 iSergio, Gis4Fun.
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
import org.cesiumjs.cs.core.NearFarScalar;
import org.cesiumjs.cs.core.Rectangle;

/**
 * Properties for controlling globe translucency.
 */
@JsType(isNative = true, namespace = "Cesium", name = "GlobeTranslucency")
public class GlobeTranslucency {
    /**
     * A constant translucency to apply to back faces of the globe.
     * Default: 1.0
     */
    @JsProperty
    public double backFaceAlpha;
    /**
     * Gets or sets near and far translucency properties of back faces of the globe based on the distance to the camera.
     */
    @JsProperty
    public NearFarScalar backFaceAlphaByDistance;
    /**
     * When true, the globe is rendered as a translucent surface.
     * Default: false
     */
    @JsProperty
    public boolean enabled;
    /**
     * A constant translucency to apply to front faces of the globe.
     * <p>GlobeTranslucency#enabled must be set to true for this option to take effect.</p>
     * Default: 1.0
     */
    @JsProperty
    public boolean frontFaceAlpha;
    /**
     * Gets or sets near and far translucency properties of front faces of the globe based on the
     * distance to the camera.
     */
    @JsProperty
    public NearFarScalar frontFaceAlphaByDistance;
    /**
     * A property specifying a Rectangle used to limit translucency to a cartographic area. Defaults to the maximum
     * extent of cartographic coordinates.
     * Default: {@link Rectangle#MAX_VALUE()}
     */
    @JsProperty
    public Rectangle rectangle;

    /**
     * Properties for controlling globe translucency.
     */
    @JsConstructor
    public GlobeTranslucency() {}
}
