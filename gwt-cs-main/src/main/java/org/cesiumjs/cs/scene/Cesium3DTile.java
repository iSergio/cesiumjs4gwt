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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.BoundingSphere;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.Matrix4;

/**
 * A tile in a {@link Cesium3DTileset}. When a tile is first created, its content is not loaded; the content is
 * loaded on-demand when needed based on the view.
 * Do not construct this directly, instead access tiles through {@link Cesium3DTileset#tileVisible}.

 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cesium3DTile")
public class Cesium3DTile {
    /**
     * Get the bounding sphere derived from the tile's bounding volume.
     */
    @JsProperty(name = "boundingSphere")
    public native BoundingSphere boundingSphere();
    /**
     * Gets the tile's children.
      */
    @JsProperty(name = "children")
    public native Cesium3DTile[] children();
    /**
     * The final computed transform of this tile
     */
    @JsProperty(name = "computedTransform")
    public native Matrix4 computedTransform();
    /**
     * The tile's content. This represents the actual tile's payload, not the content's metadata in tileset.json.
     */
    @JsProperty(name = "content")
    public native Cesium3DTileContent content();
    /**
     * The date when the content expires and new content is requested.
     */
    @JsProperty
    public JulianDate expireDate;
    /**
     * The time in seconds after the tile's content is ready when the content expires and new content is requested.
     */
    @JsProperty
    public double expireDuration;
    /**
     * The error, in meters, introduced if this tile is rendered and its children are not. This is used
     * to compute screen space error, i.e., the error measured in pixels.
     */
    @JsProperty(name = "geometricError")
    public native double geometricError();
    /**
     * This tile's parent or undefined if this tile is the root.
     * When a tile's content points to an external tileset.json, the external tileset's root tile's parent is not undefined;
     * instead, the parent references the tile (with its content pointing to an external tileset.json) as if the two tilesets were merged.
     */
    @JsProperty(name = "parent")
    public native Cesium3DTile parent();
    /**
     * The tileset containing this tile.
     */
    @JsProperty(name = "tileset")
    public native Cesium3DTileset tileset();
    /**
     * The local transform of this tile.
     */
    @JsProperty
    public Matrix4 transform;

    @JsConstructor
    private Cesium3DTile() {}
}
