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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOptional;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PolygonHierarchy")
public class PolygonHierarchy {
    /**
     * A linear ring defining the outer boundary of the polygon or hole.
     */
    @JsProperty
    public Cartesian3[] positions;
    /**
     * An array of polygon hierarchies defining holes in the polygon.
     */
    @JsProperty
    public PolygonHierarchy[] holes;

    /**
     * An hierarchy of linear rings which define a polygon and its holes.
     * The holes themselves may also have holes which nest inner polygons.
     */
    @JsConstructor
    public PolygonHierarchy() {}

    /**
     * An hierarchy of linear rings which define a polygon and its holes.
     * The holes themselves may also have holes which nest inner polygons.
     * @param positions Positions
     */
    @JsConstructor
    public PolygonHierarchy(@JsOptional Cartesian3[] positions) {}

    /**
     * An hierarchy of linear rings which define a polygon and its holes.
     * The holes themselves may also have holes which nest inner polygons.
     * @param positions A linear ring defining the outer boundary of the polygon or hole.
     * @param holes An array of polygon hierarchies defining holes in the polygon.
     */
    @JsConstructor
    public PolygonHierarchy(@JsOptional Cartesian3[] positions, @JsOptional PolygonHierarchy[] holes) {}
}
