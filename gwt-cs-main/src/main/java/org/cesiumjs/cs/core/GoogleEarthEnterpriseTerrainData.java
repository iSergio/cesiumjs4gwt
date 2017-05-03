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

import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.typedarrays.shared.Uint8Array;
import jsinterop.annotations.*;
import org.cesiumjs.cs.core.options.GoogleEarthEnterpriseTerrainDataOptions;

/**
 * Terrain data for a single tile from a Google Earth Enterprise server.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "GoogleEarthEnterpriseTerrainData")
public class GoogleEarthEnterpriseTerrainData {
    /**
     * The water mask included in this terrain data, if any. A water mask is a rectangular Uint8Array or
     * image where a value of 255 indicates water and a value of 0 indicates land.
     * Values in between 0 and 255 are allowed as well to smoothly blend between land and water.
     */
    @JsProperty
    public Uint8Array waterMask;

    @JsConstructor
    private GoogleEarthEnterpriseTerrainData(GoogleEarthEnterpriseTerrainDataOptions options) {}

    @JsOverlay
    @JsMethod
    public static GoogleEarthEnterpriseTerrainData create(ArrayBuffer buffer) {
        return new GoogleEarthEnterpriseTerrainData(GoogleEarthEnterpriseTerrainDataOptions.create(buffer));
    }
}
