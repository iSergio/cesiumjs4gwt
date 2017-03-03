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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.options.PointPrimitiveCollectionOptions;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.scene.PointPrimitive;
import org.cesiumjs.cs.scene.enums.BlendOption;
import org.cesiumjs.cs.scene.options.PointPrimitiveOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PointPrimitiveCollection")
public class PointPrimitiveCollection extends Collection<PointPrimitive> {
    /**
     * The billboard blending option. The default is used for rendering both opaque and translucent billboards.
     * However, if either all of the billboards are completely opaque or all are completely translucent, setting the
     * technique to BillboardRenderTechnique.OPAQUE or BillboardRenderTechnique.TRANSLUCENT can improve performance by up to 2x.
     * Default: {@link BlendOption#OPAQUE_AND_TRANSLUCENT()}
     */
    @JsProperty
    public Number blendOption;
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
     * A renderable collection of points.
     *
     * Points are added and removed from the collection using {@link #add} and {@link #remove}.
     *
     * Performance:
     *
     * For best performance, prefer a few collections, each with many points, to many collections with only a few points each.
     * Organize collections so that points with the same update frequency are in the same collection, i.e.,
     * points that do not change should be in one collection; points that change every frame should be in another collection; and so on.
     * @param options {@link PointPrimitiveCollectionOptions}
     */
    @JsConstructor
    public PointPrimitiveCollection(PointPrimitiveCollectionOptions options) {}

    /**
     * Creates and adds a point with the specified initial properties to the collection.
     * The added point is returned so it can be modified or removed from the collection later.
     *
     * Performance:
     * Calling add is expected constant time. However, the collection's vertex buffer is rewritten - an O(n)
     * operation that also incurs CPU to GPU overhead. For best performance, add as many pointPrimitives as
     * possible before calling update.
     * @param options {@link PointPrimitiveOptions}
     * @return The point that was added to the collection.
     */
    public native PointPrimitive add(PointPrimitiveOptions options);
}
