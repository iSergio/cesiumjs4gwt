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
import org.cesiumjs.cs.scene.options.PrimitiveCollectionOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PrimitiveCollection")
public class PrimitiveCollection<T> {
    /**
     * Determines if primitives in the collection are destroyed when they are removed by {@link PrimitiveCollection#destroy()} or
     * {@link PrimitiveCollection#remove(Object)} or implicitly by PrimitiveCollection#removeAll.
     * Default: true
     */
    @JsProperty
    public boolean destroyPrimitives;
    /**
     * Gets the number of primitives in the collection.
     */
    @JsProperty(name = "length")
    public native int length();

    /**
     * Determines if primitives in this collection will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;

    /**
     * A collection of primitives. This is most often used with {@link Scene#primitives()}, but PrimitiveCollection is also a
     * primitive itself so collections can be added to collections forming a hierarchy.
     */
    @JsConstructor
    public PrimitiveCollection() {}

    // TODO: examples
    /**
     * A collection of primitives. This is most often used with {@link Scene#primitives()}, but PrimitiveCollection is also a
     * primitive itself so collections can be added to collections forming a hierarchy.
     * @param options Options.
     */
    @JsConstructor
    public PrimitiveCollection(PrimitiveCollectionOptions options) {}

    /**
     * Adds a primitive to the collection.
     * <pre>
     *     Example:
     *     {@code
     *     Object billboards = scene.primitives.add(new BillboardCollection());
     *     }
     * </pre>
     * @param primitive The primitive to add.
     * @return The primitive added to the collection.
     */
    @JsMethod
    public native T add(T primitive);

//    public native LabelCollection add(LabelCollection primitive);

    /**
     * Determines if this collection contains a primitive.
     * @param primitive The primitive to check for.
     * @return true if the primitive is in the collection; false if the primitive is undefined or was not found in the collection.
     * @see #get(int)
     */
    @JsMethod
    public native boolean contains(T primitive);

    /**
     * Destroys the WebGL resources held by each primitive in this collection. Explicitly destroying this collection
     * allows for deterministic release of WebGL resources, instead of relying on the garbage collector to destroy this collection.
     *
     * Since destroying a collection destroys all the contained primitives, only destroy a collection when you are sure
     * no other code is still using any of the contained primitives.
     *
     * Once this collection is destroyed, it should not be used; calling any function other than isDestroyed will result
     * in a DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * #see #isDestroyed()
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns the primitive in the collection at the specified index.
     * @param index The zero-based index of the primitive to return.
     * @return The zero-based index of the primitive to return.
     * @see #length()
     */
    // TODO: examples
    @JsMethod
    public native T get(int index);

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
     * Lowers a primitive "down one" in the collection. If all primitives in the collection are drawn on the globe surface,
     * this visually moves the primitive down one.
     * @param primitive The primitive to lower.
     * @see #lowerToBottom(Object)
     * @see #raise(Object)
     * @see #raiseToTop(Object)
     */
    @JsMethod
    public native void lower(T primitive);

    /**
     * Lowers a primitive to the "bottom" of the collection. If all primitives in the collection are drawn on the globe
     * surface, this visually moves the primitive to the bottom.
     * @param primitive The primitive to lower to the bottom.
     */
    @JsMethod
    public native void lowerToBottom(T primitive);

    /**
     * Raises a primitive "up one" in the collection. If all primitives in the collection are drawn on the globe surface,
     * this visually moves the primitive up one.
     * @param primitive The primitive to raise.
     * @see #raiseToTop(Object)
     * @see #lower(Object)
     * @see #lowerToBottom(Object)
     */
    @JsMethod
    public native void raise(T primitive);

    /**
     * Raises a primitive to the "top" of the collection. If all primitives in the collection are drawn on the globe surface,
     * this visually moves the primitive to the top.
     * @param primitive The primitive to raise the top.
     * @see #raise(Object)
     * @see #lower(Object)
     * @see #lowerToBottom(Object)
     */
    @JsMethod
    public native void raiseToTop(T primitive);

    /**
     * Removes a primitive from the collection.
     * @param primitive The primitive to remove.
     * @return true if the primitive was removed; false if the primitive is undefined or was not found in the collection.
     * @see #destroyPrimitives
     */
    // TODO: example
    @JsMethod
    public native boolean remove(T primitive);

    /**
     * Removes all primitives in the collection.
     * @see #destroyPrimitives
     */
    @JsMethod
    public native void removeAll();
}
