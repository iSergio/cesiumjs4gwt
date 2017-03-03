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

import com.google.gwt.typedarrays.shared.Uint32Array;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.BoundingSphere;
import org.cesiumjs.cs.core.enums.PrimitiveType;
import org.cesiumjs.cs.core.geometry.GeometryAttributes;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeometryOptions {
    /**
     * Attributes, which make up the geometry's vertices.
     */
    @JsProperty
    public GeometryAttributes attributes;
    /**
     * {@link PrimitiveType}
     * The type of primitives in the geometry.
     * Default: PrimitiveType.TRIANGLES
     */
    @JsProperty
    public Integer primitiveType;
    /**
     * Optional index data that determines the primitives in the geometry.
     */
    @JsProperty
    public Uint32Array indices;
    /**
     * An optional bounding sphere that fully enclosed the geometry.
     */
    @JsProperty
    public BoundingSphere boundingSphere;

    @JsConstructor
    public GeometryOptions() {}
}
