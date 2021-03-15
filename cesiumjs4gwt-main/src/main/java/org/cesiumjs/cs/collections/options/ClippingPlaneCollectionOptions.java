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

package org.cesiumjs.cs.collections.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.scene.ClippingPlane;

/**
 * Options for {@link org.cesiumjs.cs.collections.ClippingPlaneCollection}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ClippingPlaneCollectionOptions {
    /**
     * An array of up to 6 Plane objects used to selectively disable rendering on
     * the outside of each plane. Default: []
     */
    @JsProperty
    public ClippingPlane[] planes;
    /**
     * Determines whether the clipping planes are active. Default: true
     */
    @JsProperty
    public boolean enabled;
    /**
     * The 4x4 transformation matrix specifying an additional transform relative to
     * the clipping planes original coordinate system. Default:
     * {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}.
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * If true, a region will be clipped if included in any plane in the collection.
     * Otherwise, the region to be clipped must intersect the regions defined by all
     * planes in this collection. Default: false
     */
    @JsProperty
    public boolean unionClippingRegions;
    /**
     * The color applied to highlight the edge along which an object is clipped.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}.
     */
    @JsProperty
    public Color edgeColor;
    /**
     * The width, in pixels, of the highlight applied to the edge along which an
     * object is clipped. Default: 0.0
     */
    @JsProperty
    public double edgeWidth;

    @JsConstructor
    public ClippingPlaneCollectionOptions() {
    }
}
