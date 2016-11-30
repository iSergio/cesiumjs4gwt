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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Transforms;
import org.cesiumjs.cs.scene.options.BillboardCollectionOptions;
import org.cesiumjs.cs.scene.options.BillboardOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
//TODO: Examples
@JsType(isNative = true, namespace = "Cesium", name = "BillboardCollection")
public class BillboardCollection {
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     * Draws the bounding sphere for each draw command in the primitive.
     * Default: false
     */
    @JsProperty
    public Boolean debugShowBoundingVolume;
    /**
     * Returns the number of billboards in this collection.
     * This is commonly used with BillboardCollection#get to iterate over all the billboards in the collection.
     */
    @JsProperty
    public Number length;
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

    /**
     * Check whether this collection contains a given billboard.
     * @param billboard The billboard to check for.
     * @return true if this collection contains the billboard, false otherwise.
     * @see BillboardCollection#get
     */
    @JsMethod
    public native Boolean contains(Billboard billboard);

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     * @see BillboardCollection#isDestroyed
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns the billboard in the collection at the specified index. Indices are zero-based and increase as billboards are added.
     * Removing a billboard shifts all billboards after it to the left, changing their indices.
     * This function is commonly used with BillboardCollection#length to iterate over all the billboards in the collection.
     *
     * Performance:
     * Expected constant time. If billboards were removed from the collection and BillboardCollection#update was not
     * called, an implicit O(n) operation is performed.
     * @param index The zero-based index of the billboard.
     * @return The billboard at the specified index.
     * @see BillboardCollection#length
     */
    @JsMethod
    public native Billboard get(Number index);

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will result in a DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     * @see BillboardCollection#destroy
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Removes a billboard from the collection.
     *
     * Performance:
     * Calling remove is expected constant time. However, the collection's vertex buffer is rewritten - an O(n)
     * operation that also incurs CPU to GPU overhead. For best performance, remove as many billboards as
     * possible before calling update. If you intend to temporarily hide a billboard, it is usually more efficient to
     * call Billboard#show instead of removing and re-adding the billboard.
     * @param billboard The billboard to remove.
     * @return true if the billboard was removed; false if the billboard was not found in the collection.
     * @see BillboardCollection#add
     * @see BillboardCollection#removeAll
     * @see Billboard#show
     */
    @JsMethod
    public native Boolean remove(Billboard billboard);

    /**
     * Removes all billboards from the collection.
     * Performance:
     * O(n). It is more efficient to remove all the billboards from a collection and then add new ones than to create a new collection entirely.
     * @see BillboardCollection#add
     * @see BillboardCollection#remove
     */
    @JsMethod
    public native void removeAll();

    /**
     * Called when Viewer or CesiumWidget render the scene to get the draw commands needed to render this primitive.
     * Do not call this function directly. This is documented just to list the exceptions that may be propagated when the scene is rendered:
     */
    @JsMethod
    public native void update();
}
