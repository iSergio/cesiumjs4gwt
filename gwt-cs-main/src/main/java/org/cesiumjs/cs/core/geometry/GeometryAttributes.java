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

package org.cesiumjs.cs.core.geometry;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "GeometryAttributes")
public class GeometryAttributes {
    /**
     * The binormal attribute (normalized), which is used for tangent-space effects like bump mapping.
     * 32-bit floating-point. 3 components per attribute.
     */
    GeometryAttribute binormal;
    /**
     * The color attribute.
     * 8-bit unsigned integer. 4 components per attribute.
     */
    GeometryAttribute color;
    /**
     * The normal attribute (normalized), which is commonly used for lighting.
     * 32-bit floating-point. 3 components per attribute.
     */
    GeometryAttribute normal;
    /**
     * The 3D position attribute.
     * 64-bit floating-point (for precision). 3 components per attribute.
     */
    GeometryAttribute position;
    /**
     * The 2D texture coordinate attribute.
     * 32-bit floating-point. 2 components per attribute
     */
    GeometryAttribute st;
    /**
     * The tangent attribute (normalized), which is used for tangent-space effects like bump mapping.
     * 32-bit floating-point. 3 components per attribute.
     */
    GeometryAttribute tangent;

    /**
     * Attributes, which make up a geometry's vertices. Each property in this object corresponds to a
     * GeometryAttribute containing the attribute's data.
     *
     * Attributes are always stored non-interleaved in a Geometry.
     */
    @JsConstructor
    public GeometryAttributes() {}
}
