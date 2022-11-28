/*
 * Copyright 2022 iSergio, Gis4Fun.
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

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Model;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ModelFeatureOptions {
    /**
     * The model the feature belongs to.
     */
    @JsProperty
    public Model model;
    /**
     * The unique integral identifier for this feature.
     */
    @JsProperty
    public double featureId;

    private ModelFeatureOptions() {}

    @JsOverlay
    public static ModelFeatureOptions create(Model model, double featureId) {
        ModelFeatureOptions options = new ModelFeatureOptions();
        options.model = model;
        options.featureId = featureId;
        return options;
    }
}
