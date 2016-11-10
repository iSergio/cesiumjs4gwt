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
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.scene.options.LabelCollectionOptions;
import org.cesiumjs.cs.scene.options.LabelOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "LabelCollection")
public class LabelCollection extends Primitive {
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     *
     * Draws the bounding sphere for each draw command in the primitive.
     *
     * Default: false
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * Returns the number of labels in this collection. This is commonly used with LabelCollection#get to iterate over
     * all the labels in the collection.
     */
    @JsProperty
    public int length;
    /**
     * The 4x4 transformation matrix that transforms each label in this collection from model to world coordinates.
     * When this is the identity matrix, the labels are drawn in world coordinates, i.e., Earth's WGS84 coordinates.
     * Local reference frames can be used by providing a different transformation matrix, like that returned by Transforms.eastNorthUpToFixedFrame.
     * Default: {@link Matrix4#IDENTITY()}
     */
    //TODO: examples
    @JsProperty
    public Matrix4 modelMatrix;

    @JsConstructor
    public LabelCollection() {}

    @JsConstructor
    public LabelCollection(LabelCollectionOptions options) {}

    /**
     * Creates and adds a label with the specified initial properties to the collection. The added label is returned
     * so it can be modified or removed from the collection later.
     *
     * Calling add is expected constant time. However, the collection's vertex buffer is rewritten; this operations is O(n)
     * and also incurs CPU to GPU overhead. For best performance, add as many billboards as possible before calling update.
     * @param options A template describing the label's properties.
     * @return The label that was added to the collection.
     * @see #remove(Label)
     * @see #removeAll()
     */
    //TODO: Examples
    @JsMethod
    public native Label add(LabelOptions options);

    /**
     * Check whether this collection contains a given label.
     * @param label The label to check for.
     * @return true if this collection contains the label, false otherwise.
     * @see #get(int)
     */
    @JsMethod
    public native boolean contains(Label label);

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of
     * WebGL resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed()
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns the label in the collection at the specified index. Indices are zero-based and increase as labels are added.
     * Removing a label shifts all labels after it to the left, changing their indices.
     * This function is commonly used with {@link LabelCollection#length} to iterate over all the labels in the collection.
     *
     * Performance:
     * Expected constant time. If labels were removed from the collection and Scene#render was not called, an implicit O(n) operation is performed.
     * @param index The zero-based index of the billboard.
     * @return The label at the specified index.
     * @see #length
     */
    //TODO: Examples
    @JsMethod
    public native Label get(int index);

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception.
     * @return True if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Removes a label from the collection. Once removed, a label is no longer usable.
     *
     * Performance:
     * Calling remove is expected constant time. However, the collection's vertex buffer is rewritten - an O(n) operation that also incurs CPU to GPU overhead. For best performance, remove as many labels as possible before calling update. If you intend to temporarily hide a label, it is usually more efficient to call Label#show instead of removing and re-adding the label.
     * @param label The label to remove.
     * @return true if the label was removed; false if the label was not found in the collection.
     * @see #add(LabelOptions)
     * @see #removeAll()
     * @see Label#show
     */
    //TODO: Examples
    @JsMethod
    public native boolean remove(Label label);

    /**
     * Removes all labels from the collection.
     * Performance:
     * O(n). It is more efficient to remove all the labels from a collection and then add new ones than to create a new collection entirely.
     * @see LabelCollection#add(LabelOptions)
     * @see #remove(Label)
     */
    //TODO: Examples
    @JsMethod
    public native void removeAll();
}
