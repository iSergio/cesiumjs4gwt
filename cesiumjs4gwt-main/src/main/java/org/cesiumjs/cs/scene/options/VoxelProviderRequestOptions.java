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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class VoxelProviderRequestOptions {
    /**
     * The tile's level.
     */
    @JsProperty
    public int tileLevel;
    /**
     * The tile's X coordinate.
     */
    @JsProperty
    public int tileX;
    /**
     * The tile's Y coordinate.
     */
    @JsProperty
    public int tileY;
    /**
     * The tile's Z coordinate.
     */
    @JsProperty
    public int tileZ;

    @JsConstructor
    public VoxelProviderRequestOptions() {}

    @JsOverlay
    public static VoxelProviderRequestOptions create(int tileLevel, int tileX, int tileY, int tileZ) {
        VoxelProviderRequestOptions options = new VoxelProviderRequestOptions();
        options.tileLevel = tileLevel;
        options.tileX = tileX;
        options.tileY = tileY;
        options.tileZ = tileZ;
        return options;
    }
}
