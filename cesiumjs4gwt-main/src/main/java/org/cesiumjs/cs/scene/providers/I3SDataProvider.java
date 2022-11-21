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

package org.cesiumjs.cs.scene.providers;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.core.providers.ArcGISTiledElevationTerrainProvider;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.I3SLayer;
import org.cesiumjs.cs.scene.providers.options.I3SDataProviderOptions;

import java.util.List;

/**
 * An I3SDataProvider is the main public class for I3S support. The url option should return a scene object.
 * Currently supported I3S versions are 1.6 and 1.7/1.8 (OGC I3S 1.2). I3SFeature and I3SNode classes implement the
 * Object Model for I3S entities, with public interfaces.
 */
@JsType(isNative = true, namespace = "Cesium", name = "I3SDataProvider")
public class I3SDataProvider implements ImageryProvider {
    /**
     * Gets the I3S data for this object.
     */
    @JsProperty(name = "data")
    public native JsObject data();
    /**
     * Gets the extent covered by this I3S.
     */
    @JsProperty(name = "extent")
    public native Rectangle extent();
    /**
     * The terrain provider referencing the GEOID service to be used for orthometric to ellipsoidal conversion.
     */
    @JsProperty(name = "geoidTiledTerrainProvider")
    public native ArcGISTiledElevationTerrainProvider geoidTiledTerrainProvider();
    /**
     * Gets the collection of layers.
     */
    @JsProperty(name = "layers")
    public native List<I3SLayer> layers();
    /**
     * Gets a human-readable name for this dataset.
     */
    @JsProperty(name = "name")
    public native String name();
    /**
     * When true, the I3S scene is loaded. This is set to true right before I3SDataProvider#readyPromise is resolved.
     */
    @JsProperty(name = "ready")
    public native boolean ready();
    /**
     * Gets the promise that will be resolved when the I3S scene is loaded.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<I3SDataProvider, Void> readyPromise();
    /**
     * The resource used to fetch the I3S dataset.
     */
    @JsProperty(name = "resource")
    public native Resource resource();
    /**
     * Determines if the dataset will be shown.
     */
    @JsProperty
    public boolean show;
    /**
     * Gets or sets debugging and tracing of I3S fetches.
     */
    @JsProperty
    public boolean traceFetches;

    public I3SDataProvider(I3SDataProviderOptions options) {
        //
    }

    @JsOverlay
    public static I3SDataProvider create(Resource url) {
        return new I3SDataProvider(I3SDataProviderOptions.create(url));
    }

    @JsOverlay
    public static I3SDataProvider create(String url) {
        return new I3SDataProvider(I3SDataProviderOptions.create(url));
    }
}
