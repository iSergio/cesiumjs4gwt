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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Camera;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ShadowMapOptions {
    /**
     * The context in which to create the shadow map.
     */
    // TODO: in documentation of CesiumJS error
//    public Context context;
    /**
     * A camera representing the light source.
     */
    @JsProperty
    Camera lightCamera;
    /**
     * Whether the shadow map is enabled.
     * Default: true
     */
    @JsProperty
    public boolean enabled;
    /**
     * Whether the light source is a point light. Point light shadows do not use cascades.
     * Default: false
     */
    @JsProperty
    public boolean isPointLight;
    /**
     * Radius of the point light.
     * Default: 100.0
     */
    @JsProperty
    public double pointLightRadius;
    /**
     * Use multiple shadow maps to cover different partitions of the view frustum.
     * Default: true
     */
    @JsProperty
    public boolean cascadesEnabled;
    /**
     * The number of cascades to use for the shadow map. Supported values are one and four.
     * Default: 4
     */
    @JsProperty
    public int numberOfCascades;
    /**
     * The maximum distance used for generating cascaded shadows. Lower values improve shadow quality.
     * Default: 5000.0
     */
    @JsProperty
    public double maximumDistance;
    /**
     * The width and height, in pixels, of each shadow map.
     * Default: 2048
     */
    @JsProperty
    public int size;
    /**
     * Whether percentage-closer-filtering is enabled for producing softer shadows.
     * Default: false
     */
    @JsProperty
    public boolean softShadows;
    /**
     * The shadow darkness.
     * Default: 0.3
     */
    @JsProperty
    public double darkness;

    @JsConstructor
    public ShadowMapOptions() {}
}
