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

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Ray;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.ImageryLayer;
import org.cesiumjs.cs.scene.ImageryLayerFeatureInfo;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.providers.ImageryProvider;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ImageryLayerCollection")
public class ImageryLayerCollection extends Collection<ImageryLayer> {
    /**
     * An event that is raised when a layer is added to the collection.
     * Event handlers are passed the layer that was added and the index at which it was added.
     Default: Event()
     */
    @JsProperty
    public Event layerAdded;
    /**
     * An event that is raised when a layer changes position in the collection.
     * Event handlers are passed the layer that was moved, its new index after the move, and its old index prior to the move.
     * Default: Event()
     */
    @JsProperty
    public Event layerMoved;
    /**
     * An event that is raised when a layer is removed from the collection.
     * Event handlers are passed the layer that was removed and the index from which it was removed.
     * Default: Event()
     */
    @JsProperty
    public Event layerRemoved;
    /**
     * An event that is raised when a layer is shown or hidden by setting the ImageryLayer#show property.
     * Event handlers are passed a reference to this layer, the index of the layer in the collection, and a flag that is
     * true if the layer is now shown or false if it is now hidden.
     * Default: Event()
     */
    @JsProperty
    public Event layerShownOrHidden;

    /**
     * An ordered collection of imagery layers.
     */
    @JsConstructor
    public ImageryLayerCollection() {}

    /**
     * Adds a layer to the collection.
     * @param layer the layer to add.
     * @param index the index to add the layer at. If omitted, the layer will added on top of all existing layers.
     */
    @JsMethod
    public native void add(ImageryLayer layer, int index);

    /**
     * Creates a new layer using the given ImageryProvider and adds it to the collection.
     * @param imageryProvider the imagery provider to create a new layer for.
     * @return The newly created layer.
     */
    @JsMethod
    public native ImageryLayer addImageryProvider(ImageryProvider imageryProvider);

    /**
     * Creates a new layer using the given ImageryProvider and adds it to the collection.
     * @param imageryProvider the imagery provider to create a new layer for.
     * @param index the index to add the layer at. If omitted, the layer will added on top of all existing layers.
     * @return The newly created layer.
     */
    @JsMethod
    public native ImageryLayer addImageryProvider(ImageryProvider imageryProvider, int index);

    /**
     * Determines the index of a given layer in the collection.
     * @param layer The layer to find the index of.
     * @return The index of the layer in the collection, or -1 if the layer does not exist in the collection.
     */
    @JsMethod
    public native int indexOf(ImageryLayer layer);

    /**
     * Lowers a layer down one position in the collection.
     * @param layer the layer to move.
     */
    @JsMethod
    public native void lower(ImageryLayer layer);

    /**
     * Lowers a layer to the bottom of the collection.
     * @param layer the layer to move.
     */
    @JsMethod
    public native void lowerToBottom(ImageryLayer layer);

    /**
     * Asynchronously determines the imagery layer features that are intersected by a pick ray.
     * The intersected imagery layer features are found by invoking ImageryProvider#pickFeatures for each imagery
     * layer tile intersected by the pick ray. To compute a pick ray from a location on the screen, use Camera.getPickRay.
     * @param ray The ray to test for intersection.
     * @param scene The scene.
     * @return A promise that resolves to an array of features intersected by the pick ray. If it can be quickly determined that no features are intersected (for example, because no active imagery providers support ImageryProvider#pickFeatures or because the pick ray does not intersect the surface), this function will return undefined.
     */
    @JsMethod
    public native Promise<ImageryLayerFeatureInfo[], Void> pickImageryLayerFeatures(Ray ray, Scene scene);

    /**
     * Raises a layer up one position in the collection.
     * @param layer the layer to move.
     */
    @JsMethod
    public native void raise(ImageryLayer layer);

    /**
     * Raises a layer to the top of the collection.
     * @param layer the layer to move.
     */
    @JsMethod
    public native void raiseToTop(ImageryLayer layer);

    /**
     * Removes a layer from this collection, if present.
     * @param layer The layer to remove.
     * @param destroy whether to destroy the layers in addition to removing them. Default: true
     * @return true if the layer was in the collection and was removed, false if the layer was not in the collection.
     */
    @JsMethod
    public native boolean remove(ImageryLayer layer, boolean destroy);

    /**
     * Removes all layers from this collection.
     * @param destroy whether to destroy the layers in addition to removing them. Default: true
     */
    @JsMethod
    public native void removeAll(boolean destroy);

    @JsFunction
    public interface Listener {
        void function(ImageryLayer imageryLayer, int index);
    }
}
