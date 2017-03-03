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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.geometry.Geometry;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeometryInstanceOptions {
    /**
     * The geometry to instance.
     */
    public Geometry geometry;
    /**
     * The model matrix that transforms to transform the geometry from model to world coordinates.
     * Default: {@link Matrix4#IDENTITY()}
     */
    public Matrix4 modelMatrix;
    /**
     * A user-defined object to return when the instance is picked with Scene#pick or get/set per-instance attributes with Primitive#getGeometryInstanceAttributes.
     */
    public Object id;
    /**
     * Per-instance attributes like a show or color attribute shown in the example below.
     */
    public Object attributes;

    @JsConstructor
    public GeometryInstanceOptions() {}
}
