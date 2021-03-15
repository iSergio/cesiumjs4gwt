/*
 * Copyright 2018 iserge.
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
import org.cesiumjs.cs.collections.options.ClippingPlaneCollectionOptions;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.scene.ClippingPlane;

/**
 * Specifies a set of clipping planes. Clipping planes selectively disable
 * rendering in a region on the outside of the specified list of
 * {@link ClippingPlane} objects for a single gltf model, 3D Tileset, or the
 * globe.
 *
 * @author Serge Silaev aka iSergio
 */
@SuppressWarnings("rawtypes")
@JsType(isNative = true, namespace = "Cesium", name = "ClippingPlaneCollection")
public class ClippingPlaneCollection extends Collection<ClippingPlane> {
    /**
     * The color applied to highlight the edge along which an object is clipped.
     * Default: {@link Color#WHITE()}.
     */
    @JsProperty
    public Color edgeColor;
    /**
     * The width, in pixels, of the highlight applied to the edge along which an
     * object is clipped. Default: 0.0
     */
    @JsProperty
    public double edgeWidth;
    /**
     * Determines whether the clipping planes are active. Default: true
     */
    @JsProperty
    public boolean enabled;
    /**
     * The 4x4 transformation matrix specifying an additional transform relative to
     * the clipping planes original coordinate system. Default:
     * {@link Matrix4#IDENTITY()}.
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * An event triggered when a new clipping plane is added to the collection.
     * Event handlers are passed the new plane and the index at which it was added.
     * Default: Event()
     */
    @JsProperty
    public Event planeAdded;
    /**
     * An event triggered when a new clipping plane is removed from the collection.
     * Event handlers are passed the new plane and the index from which it was
     * removed. Default: Event()
     */
    @JsProperty
    public Event planeRemoved;
    /**
     * If true, a region will be clipped if included in any plane in the collection.
     * Otherwise, the region to be clipped must intersect the regions defined by all
     * planes in this collection. Default: true
     */
    @JsProperty
    public boolean unionClippingRegions;

    /**
     * Specifies a set of clipping planes. Clipping planes selectively disable
     * rendering in a region on the outside of the specified list of Plane objects.
     */
    @JsConstructor
    public ClippingPlaneCollection() {
    }

    /**
     * Specifies a set of clipping planes. Clipping planes selectively disable
     * rendering in a region on the outside of the specified list of Plane objects.
     *
     * @param options {@link ClippingPlaneCollectionOptions} object.
     */
    @JsConstructor
    public ClippingPlaneCollection(ClippingPlaneCollectionOptions options) {
    }
}
