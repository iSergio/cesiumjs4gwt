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

package org.cesiumjs.cs.core.options;

import com.google.gwt.typedarrays.shared.ArrayBuffer;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;

/**
 * Options for {@link org.cesiumjs.cs.core.GoogleEarthEnterpriseTerrainData}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class GoogleEarthEnterpriseTerrainDataOptions {
    /**
     * The buffer containing terrain data.
     */
    ArrayBuffer buffer;
    /**
     *  A bit mask indicating which of this tile's four children exist. If a child's bit is set,
     *  geometry will be requested for that tile as well when it is needed. If the bit is cleared,
     *  the child tile is not requested and geometry is instead upsampled from the parent. The bit values are as follows:
     *  Default: 15.
     */
    int childTileMask;
    /**
     * True if this instance was created by upsampling another instance; otherwise, false.
     * Default: false.
     */
    boolean createdByUpsampling;

    @JsConstructor
    private GoogleEarthEnterpriseTerrainDataOptions() {}

    @JsOverlay
    @JsMethod
    public static GoogleEarthEnterpriseTerrainDataOptions create(ArrayBuffer buffer) {
        GoogleEarthEnterpriseTerrainDataOptions options = new GoogleEarthEnterpriseTerrainDataOptions();
        options.buffer = buffer;
        return options;
    }
}
