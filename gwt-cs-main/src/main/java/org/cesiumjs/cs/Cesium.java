/*
 * Copyright 2016 iserge.
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

package org.cesiumjs.cs;

import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LinkElement;
import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Cartographic;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.js.JsImage;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.providers.UrlTemplateImageryProvider;
import org.cesiumjs.cs.scene.providers.options.OpenStreetMapImageryProviderOptions;
import org.cesiumjs.cs.scene.providers.options.TileMapServiceImageryProviderOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Cesium {
    @JsProperty(namespace = JsPackage.GLOBAL, name = "Cesium")
    public static native boolean isInitialized();

    @JsProperty(namespace = "Cesium", name = "VERSION")
    public static native String version();

    @JsMethod(namespace = "Cesium")
    public static native boolean defined(Object object);

    @JsMethod(namespace = "Cesium", name = "loadImage")
    public static native Promise<JsImage, Void> loadImage(String url);
    /**
     * Asynchronously loads the given imagery URL. Returns a promise that will resolve to an Image once loaded, or reject if the imagery failed to load
     * @param url The source of the imagery, or a promise for the URL.
     * @param allowCrossOrigin Whether to request the imagery using Cross-Origin Resource Sharing (CORS).
     *                         CORS is only actually used if the imagery URL is actually cross-origin.
     *                         Data URIs are never requested using CORS.
     * @return a promise that will resolve to the requested data when loaded.
     */
    @JsMethod(namespace = "Cesium", name = "loadImage")
    public static native Promise<JsImage, Void> loadImage(String url, boolean allowCrossOrigin);

    /**
     * Initiates a terrain height query for an array of {@link Cartographic} positions by requesting tiles from a terrain provider,
     * sampling, and interpolating. The interpolation matches the triangles used to render the terrain at the specified level.
     * The query happens asynchronously, so this function returns a promise that is resolved when the query completes.
     * Each point height is modified in place. If a height can not be determined because no terrain data is available
     * for the specified level at that location, or another error occurs, the height is set to undefined.
     * As is typical of the {@link Cartographic} type, the supplied height is a height above the reference
     * ellipsoid (such as {@link Ellipsoid#WGS84()}) rather than an altitude above mean sea level.
     * In other words, it will not necessarily be 0.0 if sampled in the ocean.
     * @param terrainProvider The terrain provider from which to query heights.
     * @param level The terrain level-of-detail from which to query terrain heights.
     * @param positions The positions to update with terrain heights.
     * @return A promise that resolves to the provided list of positions when terrain the query has completed.
     */
    @JsMethod(namespace = "Cesium", name = "sampleTerrain")
    public static native Promise<Cartographic[], Void> sampleTerrain(TerrainProvider terrainProvider, int level, Cartographic[] positions);

    /**
     * Creates a UrlTemplateImageryProvider instance that provides tiled imagery hosted by OpenStreetMap or
     * another provider of Slippy tiles. The default url connects to OpenStreetMap's volunteer-run servers,
     * so you must conform to their Tile Usage Policy.
     * @return The imagery provider.
     */
    @JsMethod(namespace = "Cesium", name = "createOpenStreetMapImageryProvider")
    public static native UrlTemplateImageryProvider createOpenStreetMapImageryProvider();

    /**
     * Creates a UrlTemplateImageryProvider instance that provides tiled imagery hosted by OpenStreetMap or
     * another provider of Slippy tiles. The default url connects to OpenStreetMap's volunteer-run servers,
     * so you must conform to their Tile Usage Policy.
     * @param options Options
     * @return The imagery provider.
     */
    @JsMethod(namespace = "Cesium", name = "createOpenStreetMapImageryProvider")
    public static native UrlTemplateImageryProvider createOpenStreetMapImageryProvider(OpenStreetMapImageryProviderOptions options);

    /**
     * Creates a UrlTemplateImageryProvider instance that provides tiled imagery as generated by GDDAL2Tiles etc.
     * @return The imagery provider.
     */
    @JsMethod(namespace = "Cesium", name = "createTileMapServiceImageryProvider")
    public static native UrlTemplateImageryProvider createTileMapServiceImageryProvider();

    /**
     * Creates a UrlTemplateImageryProvider instance that provides tiled imagery as generated by GDDAL2Tiles etc.
     * @param options Options
     * @return The imagery provider.
     */
    @JsMethod(namespace = "Cesium", name = "createTileMapServiceImageryProvider")
    public static native UrlTemplateImageryProvider createTileMapServiceImageryProvider(TileMapServiceImageryProviderOptions options);

    public static void initialize(String path, Document document, Callback<Void, Exception> callback) {
        Initializer initializer = Initializer.get(document);
        if (initializer != null) {
            initializer.addCallback(callback);
            initializer.invokeCallback(callback);
        } else {
            LinkElement linkElement = Document.get().createLinkElement();
            linkElement.setRel("stylesheet");
            linkElement.setHref(path + "Widgets/widgets.css");
            document.getElementsByTagName("head").getItem(0).appendChild(linkElement);

            new Initializer(path, document, callback).initialize();
        }
    }
}
