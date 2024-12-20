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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.js.JsObject;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FromGltfAsyncOptions extends FromGltfOptions {
    /**
     * A function that is called with the loaded gltf object once loaded.
     */
    @JsProperty
    public GltfCallback gltfCallback;

    public interface GltfCallback {
        void callback(JsObject gltf);
    }
}
