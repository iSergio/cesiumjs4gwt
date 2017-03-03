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
import org.cesiumjs.cs.scene.options.ShadowMapOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ShadowMap")
public class ShadowMap {
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
    /**
     * Whether the shadow map is enabled.
     * Default: true
     */
    @JsProperty
    public boolean enabled;

    /**
     * Creates a shadow map from the provided light camera. The normalOffset bias pushes the shadows forward slightly,
     * and may be disabled for applications that require ultra precise shadows.
     */
    @JsConstructor
    private ShadowMap() {}

    /**
     * Creates a shadow map from the provided light camera. The normalOffset bias pushes the shadows forward slightly,
     * and may be disabled for applications that require ultra precise shadows.
     * @param options Options
     */
    @JsConstructor
    private ShadowMap(ShadowMapOptions options) {}
}
