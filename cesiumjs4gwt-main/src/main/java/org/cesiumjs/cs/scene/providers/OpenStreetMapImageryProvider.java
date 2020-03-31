/*
 * Copyright 2019 iserge.
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

package org.cesiumjs.cs.scene.providers;

import org.cesiumjs.cs.scene.providers.options.OpenStreetMapImageryProviderOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * An imagery provider that provides tiled imagery hosted by OpenStreetMap or another provider of Slippy tiles.
 * The default url connects to OpenStreetMap's volunteer-run servers, so you must conform to their Tile Usage Policy.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "OpenStreetMapImageryProvider")
public class OpenStreetMapImageryProvider implements ImageryProvider {
    /**
     * An imagery provider that provides tiled imagery hosted by OpenStreetMap or another provider of Slippy tiles.
     * The default url connects to OpenStreetMap's volunteer-run servers, so you must conform to their Tile Usage Policy.
     */
    @JsConstructor
    public OpenStreetMapImageryProvider() {}

    /**
     * An imagery provider that provides tiled imagery hosted by OpenStreetMap or another provider of Slippy tiles.
     * The default url connects to OpenStreetMap's volunteer-run servers, so you must conform to their Tile Usage Policy.
     * @param options Options {@link OpenStreetMapImageryProviderOptions}
     */
    @JsConstructor
    public OpenStreetMapImageryProvider(OpenStreetMapImageryProviderOptions options) {}

}
