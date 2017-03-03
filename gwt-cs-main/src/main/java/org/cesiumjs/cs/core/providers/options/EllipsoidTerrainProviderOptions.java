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

package org.cesiumjs.cs.core.providers.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.TilingScheme;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "EllipsoidTerrainProviderOptions")
public class EllipsoidTerrainProviderOptions {
    /**
     * The tiling scheme specifying how the ellipsoidal surface is broken into tiles.
     * If this parameter is not provided, a {@link org.cesiumjs.core.GeographicTilingScheme} is used.
     */
    public TilingScheme tilingScheme;
    /**
     * The ellipsoid. If the tilingScheme is specified, this parameter is ignored and the tiling scheme's ellipsoid is used instead.
     * If neither parameter is specified, the {@link Ellipsoid#WGS84()} ellipsoid is used.
     */
    public Ellipsoid ellipsoid;

    @JsConstructor
    private EllipsoidTerrainProviderOptions() {}
}
