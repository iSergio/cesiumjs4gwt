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

package org.cesiumjs.cs.collections;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.options.PolylineCollectionOptions;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.scene.Polyline;
import org.cesiumjs.cs.scene.options.PolylineOptions;

//TODO: Example
/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PolylineCollection")
public class PolylineCollection extends Collection<Polyline> {
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     * Draws the bounding sphere for each draw command in the primitive.
     * Default: false
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * The 4x4 transformation matrix that transforms each polyline in this collection from model to world coordinates.
     * When this is the identity matrix, the polylines are drawn in world coordinates, i.e., Earth's WGS84 coordinates.
     * Local reference frames can be used by providing a different transformation matrix, like that returned by
     * {@link Transforms#eastNorthUpToFixedFrame}.
     * Default: {@link Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;

    /**
     * A renderable collection of polylines.
     * Polylines are added and removed from the collection using {@link PolylineCollection#add} and {@link PolylineCollection#remove}.
     *
     * Performance:
     *
     * For best performance, prefer a few collections, each with many polylines, to many collections with only a few
     * polylines each. Organize collections so that polylines with the same update frequency are in the same collection,
     * i.e., polylines that do not change should be in one collection; polylines that change every frame should be in
     * another collection; and so on.
     */
    @JsConstructor
    public PolylineCollection() {}

    /**
     * A renderable collection of polylines.
     * Polylines are added and removed from the collection using {@link PolylineCollection#add} and {@link PolylineCollection#remove}.
     *
     * Performance:
     *
     * For best performance, prefer a few collections, each with many polylines, to many collections with only a few
     * polylines each. Organize collections so that polylines with the same update frequency are in the same collection,
     * i.e., polylines that do not change should be in one collection; polylines that change every frame should be in
     * another collection; and so on.
     * @param options {@link PolylineCollectionOptions}
     */
    @JsConstructor
    public PolylineCollection(PolylineCollectionOptions options) {}

    /**
     * Creates and adds a polyline with the specified initial properties to the collection.
     * The added polyline is returned so it can be modified or removed from the collection later.
     *
     * Performance:
     *
     * After calling add, {@link PolylineCollection#update} is called and the collection's vertex buffer is rewritten - an O(n)
     * operation that also incurs CPU to GPU overhead. For best performance, add as many polylines as possible before calling update.
     * @param polylineOptions {@link org.cesiumjs.cs.scene.options.PolylineOptions}
     * @return The polyline that was added to the collection.
     */
    @JsMethod
    public native Polyline add(PolylineOptions polylineOptions);
}
