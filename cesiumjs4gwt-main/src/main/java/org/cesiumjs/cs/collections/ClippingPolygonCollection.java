/*
 * Copyright 2024 iSergio, Gis4Fun.
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

package org.cesiumjs.cs.collections;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.options.ClippingPolygon;
import org.cesiumjs.cs.scene.options.ClippingPolygonOptions;

/**
 * Specifies a set of clipping polygons. Clipping polygons selectively disable rendering in a region inside or outside
 * the specified list of ClippingPolygon objects for a single glTF model, 3D Tileset, or the globe. Clipping Polygons
 * are only supported in WebGL 2 contexts.
 */
@JsType(isNative = true, namespace = "Cesium", name = "ClippingPolygonCollection")
public class ClippingPolygonCollection extends Collection<ClippingPolygon> {
    /**
     * Function for checking if the context will allow clipping polygons, which require floating point textures.
     * @param scene The scene that will contain clipped objects and clipping textures.
     * @return true if the context supports clipping polygons.
     */
    public static native boolean isSupported(Scene scene);

    @JsConstructor
    public ClippingPolygonCollection() {}

    @JsConstructor
    public ClippingPolygonCollection(ClippingPolygonOptions options) {}
}
