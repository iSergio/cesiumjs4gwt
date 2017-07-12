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
import org.cesiumjs.cs.collections.options.PrimitiveCollectionOptions;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Model;
import org.cesiumjs.cs.scene.Primitive;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.particle.ParticleSystem;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
// TODO: examples
@JsType(isNative = true, namespace = "Cesium", name = "PrimitiveCollection")
public class PrimitiveCollection extends Collection<Primitive> {
    /**
     * Determines if primitives in the collection are destroyed when they are removed by {@link PrimitiveCollection#destroy()} or
     * {@link PrimitiveCollection#remove(Object)} or implicitly by PrimitiveCollection#removeAll.
     * Default: true
     */
    @JsProperty
    public boolean destroyPrimitives;
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

    /**
     * A collection of primitives. This is most often used with {@link Scene#primitives()}, but PrimitiveCollection is also a
     * primitive itself so collections can be added to collections forming a hierarchy.
     * @param options Options.
     */
    @JsConstructor
    public PrimitiveCollection(PrimitiveCollectionOptions options) {}

    /**
     * Add collection
     * @param collection Collection
     * @return collection
     */
    @JsMethod
    public native Collection add(Collection collection);

    /**
     * Add model to collecntion
     * @param model Model to add
     * @return added Model
     */
    @JsMethod
    public native Model add(Model model);

    @JsMethod
    public native ParticleSystem add(ParticleSystem particleSystem);
    @JsMethod
    public native Cesium3DTileset add(Cesium3DTileset cesium3DTileset);

    /**
     * Lowers a primitive "down one" in the collection. If all primitives in the collection are drawn on the globe surface,
     * this visually moves the primitive down one.
     * @param primitive The primitive to lower.
     * @see #lowerToBottom
     * @see #raise
     * @see #raiseToTop
     */
    @JsMethod
    public native void lower(Primitive primitive);

    /**
     * Lowers a primitive to the "bottom" of the collection. If all primitives in the collection are drawn on the globe
     * surface, this visually moves the primitive to the bottom.
     * @param primitive The primitive to lower to the bottom.
     */
    @JsMethod
    public native void lowerToBottom(Primitive primitive);

    /**
     * Raises a primitive "up one" in the collection. If all primitives in the collection are drawn on the globe surface,
     * this visually moves the primitive up one.
     * @param primitive The primitive to raise.
     * @see #raiseToTop
     * @see #lower
     * @see #lowerToBottom
     */
    @JsMethod
    public native void raise(Primitive primitive);

    /**
     * Raises a primitive to the "top" of the collection. If all primitives in the collection are drawn on the globe surface,
     * this visually moves the primitive to the top.
     * @param primitive The primitive to raise the top.
     * @see #raise
     * @see #lower
     * @see #lowerToBottom
     */
    @JsMethod
    public native void raiseToTop(Primitive primitive);
}
