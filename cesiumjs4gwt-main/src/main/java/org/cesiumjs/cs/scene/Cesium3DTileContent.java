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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.promise.Promise;

/**
 * The content of a tile in a {@link Cesium3DTileset}.
 * Derived classes of this interface provide access to individual features in the tile. Access derived objects through {@link Cesium3DTile#content}.
 *
 * This type describes an interface and is not intended to be instantiated directly.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cesium3DTileContent")
public class Cesium3DTileContent {
    /**
     * Gets the amount of memory used by the batch table textures, in bytes.
     */
    @JsProperty(name = "batchTableByteLength")
    public native int batchTableByteLength();
    /**
     * Gets the number of features in the tile.
     */
    @JsProperty(name = "featuresLength")
    public native int featuresLength();
    /**
     * Gets the tile's geometry memory in bytes.
     */
    @JsProperty(name = "geometryByteLength")
    public native int geometryByteLength();
    /**
     * Gets the array of Cesium3DTileContent objects that represent the content a composite's inner tiles, which can also be composites.
     */
    @JsProperty(name = "innerContents")
    public native Cesium3DTileContent[] innerContents();
    /**
     * Gets the number of points in the tile.
     * Only applicable for tiles with Point Cloud content. This is different than Cesium3DTileContent#featuresLength
     * which equals the number of groups of points as distinguished by the BATCH_ID feature table semantic.
     */
    @JsProperty(name = "pointsLength")
    public native int pointsLength();
    /**
     * Gets the promise that will be resolved when the tile's content is ready to render.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<Cesium3DTileContent, Void> readyPromise();
    /**
     * Gets the tile's texture memory in bytes.
     */
    @JsProperty(name = "texturesByteLength")
    public native int texturesByteLength();
    /**
     * Gets the number of triangles in the tile.
     */
    @JsProperty(name = "trianglesLength")
    public native int trianglesLength();
    /**
     * Gets the url of the tile's content.
     */
    @JsProperty(name = "url")
    public native String url();

    @JsConstructor
    private Cesium3DTileContent() {}

    /**
     * Returns the Cesium3DTileFeature object for the feature with the given batchId.
     * This object is used to get and modify the feature's properties.
     * Features in a tile are ordered by batchId, an index used to retrieve their metadata from the batch table.
     * @param batchId The batchId for the feature.
     * @see <a href="https://github.com/AnalyticalGraphicsInc/3d-tiles/tree/master/TileFormats/BatchTable.">link</a>
     * @return The corresponding {@link Cesium3DTileFeature} object.
     */
    @JsMethod
    public native Cesium3DTileFeature getFeature(int batchId);

    /**
     * Determines if the tile's batch table has a property. If it does, each feature in the tile will have the property.
     * @param batchId The batchId for the feature.
     * @param name The case-sensitive name of the property.
     * @return true if the property exists; otherwise, false.
     */
    @JsMethod
    public native boolean hasProperty(int batchId, String name);
}
