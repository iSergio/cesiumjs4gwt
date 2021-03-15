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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Cartesian3;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DirectionalLightOptions extends SunLightOptions {
    /**
     * The direction in which light gets emitted.
     */
    @JsProperty
    public Cartesian3 direction;

    @JsConstructor
    protected DirectionalLightOptions() {
    }

    /**
     * Constructor for {@link org.cesiumjs.cs.scene.DirectionalLight}
     *
     * @param direction
     * @return options object
     */
    @JsOverlay
    public static DirectionalLightOptions create(Cartesian3 direction) {
        DirectionalLightOptions options = new DirectionalLightOptions();
        options.direction = direction;
        return options;
    }
}