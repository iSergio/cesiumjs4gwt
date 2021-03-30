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

package org.cesiumjs.cs.core.providers;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Request;
import org.cesiumjs.cs.core.TerrainData;
import org.cesiumjs.cs.core.providers.options.ArcGISTiledElevationTerrainProviderOptions;
import org.cesiumjs.cs.promise.Promise;

/**
 * A {@link TerrainProvider} that produces terrain geometry by tessellating
 * height maps retrieved from Elevation Tiles of an an ArcGIS ImageService.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "ArcGISTiledElevationTerrainProvider")
public class ArcGISTiledElevationTerrainProvider implements TerrainProvider {
    @JsConstructor
    private ArcGISTiledElevationTerrainProvider() {
    }

    @JsConstructor
    public ArcGISTiledElevationTerrainProvider(ArcGISTiledElevationTerrainProviderOptions options) {
    }

    @Override
    @JsMethod
    public native double getLevelMaximumGeometricError(int level);

    @Override
    @JsMethod
    public native boolean getTileDataAvailable(int x, int y, int level);

    @Override
    @JsMethod
    public native Promise<TerrainData, Void> requestTileGeometry(int x, int y, int level, Request request);
}
