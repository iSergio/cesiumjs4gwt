/*
 * Copyright 2020 iSerge.
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
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.scene.options.DirectionalLightOptions;

/**
 * A light that gets emitted in a single direction from infinitely far away.
 */
@JsType(isNative = true, namespace = "Cesium", name = "DirectionalLight")
public class DirectionalLight extends Light {
    /**
     * The direction in which light gets emitted.
     */
    @JsProperty
    public Cartesian3 direction;

    @JsConstructor
    protected DirectionalLight(DirectionalLightOptions options) {
    }

    @JsOverlay
    public static DirectionalLight create(Cartesian3 direction) {
        DirectionalLightOptions options = DirectionalLightOptions.create(direction);
        return new DirectionalLight(options);
    }

    @JsOverlay
    public static DirectionalLight create(DirectionalLightOptions options) {
        return new DirectionalLight(options);
    }
}