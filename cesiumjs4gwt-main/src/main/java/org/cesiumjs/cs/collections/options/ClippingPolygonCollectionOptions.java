/*
 * Copyright 2024 iSergio, Gis4Fun.
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
import org.cesiumjs.cs.scene.options.ClippingPolygon;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ClippingPolygonCollectionOptions {
    /**
     * An array of ClippingPolygon objects used to selectively disable rendering on the inside of each polygon.
     */
    @JsProperty
    public ClippingPolygon[] polygons;

    /**
     * Determines whether the clipping polygons are active.
     * Default: true
     */
    @JsProperty
    public boolean enabled;

    /**
     * If true, a region will be clipped if it is outside of every polygon in the collection. Otherwise, a region will only be clipped if it is on the inside of any polygon.
     * Default: false
     */
    @JsProperty
    public boolean inverse;

    @JsConstructor
    public ClippingPolygonCollectionOptions() {}
}
