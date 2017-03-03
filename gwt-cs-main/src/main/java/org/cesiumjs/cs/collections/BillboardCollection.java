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
import org.cesiumjs.cs.collections.options.BillboardCollectionOptions;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.scene.Billboard;
import org.cesiumjs.cs.scene.enums.BlendOption;
import org.cesiumjs.cs.scene.options.BillboardOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
//TODO: Examples
@JsType(isNative = true, namespace = "Cesium", name = "BillboardCollection")
public class BillboardCollection extends Collection<Billboard> {
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
    public Boolean debugShowBoundingVolume;
    /**
     * The 4x4 transformation matrix that transforms each billboard in this collection from model to world coordinates. When this is the identity matrix, the billboards are drawn in world coordinates, i.e., Earth's WGS84 coordinates. Local reference frames can be used by providing a different transformation matrix, like that returned by Transforms.eastNorthUpToFixedFrame.
     * Default: {@link Matrix4#IDENTITY()}
     * @see {@link Transforms#eastNorthUpToFixedFrame}
     */
    @JsProperty
    public Matrix4 modelMatrix;

    /**
     * A renderable collection of billboards. Billboards are viewport-aligned images positioned in the 3D scene.
     * Billboards are added and removed from the collection using {@link BillboardCollection#add} and {@link BillboardCollection#remove}.
     * Billboards in a collection automatically share textures for images with the same identifier.
     *
     * Performance:
     *
     * For best performance, prefer a few collections, each with many billboards, to many collections with only a few billboards each.
     * Organize collections so that billboards with the same update frequency are in the same collection, i.e.,
     * billboards that do not change should be in one collection; billboards that change every frame should be in another collection; and so on.
     * @see BillboardCollection#add
     * @see BillboardCollection#remove
     * @see Billboard
     * @see LabelCollection
     */
    @JsConstructor
    public BillboardCollection() {}

    /**
     * A renderable collection of billboards. Billboards are viewport-aligned images positioned in the 3D scene.
     * Billboards are added and removed from the collection using {@link BillboardCollection#add} and {@link BillboardCollection#remove}.
     * Billboards in a collection automatically share textures for images with the same identifier.
     *
     * Performance:
     *
     * For best performance, prefer a few collections, each with many billboards, to many collections with only a few billboards each.
     * Organize collections so that billboards with the same update frequency are in the same collection, i.e.,
     * billboards that do not change should be in one collection; billboards that change every frame should be in another collection; and so on.
     * @param options Options
     * @see BillboardCollection#add
     * @see BillboardCollection#remove
     * @see Billboard
     * @see LabelCollection
     */
    @JsConstructor
    public BillboardCollection(BillboardCollectionOptions options) {}

    /**
     * Creates and adds a billboard with the specified initial properties to the collection. The added billboard is
     * returned so it can be modified or removed from the collection later.
     *
     * Performance:
     * Calling add is expected constant time. However, the collection's vertex buffer is rewritten - an O(n)
     * operation that also incurs CPU to GPU overhead. For best performance, add as many billboards as possible before calling update.
     * @param billboard Options
     * @return The billboard that was added to the collection.
     * @see BillboardCollection#remove
     * @see BillboardCollection#removeAll
     */
    @JsMethod
    public native Billboard add(BillboardOptions billboard);
}
