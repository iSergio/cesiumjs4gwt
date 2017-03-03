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

import com.google.gwt.typedarrays.shared.TypedArrays;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.ComponentDatatype;
import org.cesiumjs.cs.core.options.GeometryAttributeOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "GeometryAttribute")
public class GeometryAttribute {
    /**
     * {@link ComponentDatatype}
     * The datatype of each component in the attribute, e.g., individual elements in GeometryAttribute#values.
     */
    @JsProperty
    public int componentDatatype;
    /**
     * A number between 1 and 4 that defines the number of components in an attributes. For example,
     * a position attribute with x, y, and z components would have 3 as shown in the code example.
     */
    @JsProperty
    public int componentsPerAttribute;
    /**
     * When true and componentDatatype is an integer format, indicate that the components should be mapped to the range [0, 1]
     * (unsigned) or [-1, 1] (signed) when they are accessed as floating-point for rendering.
     * This is commonly used when storing colors using ComponentDatatype.UNSIGNED_BYTE.
     *
     * Default: false
     */
    @JsProperty
    public boolean normalize;
    /**
     * The values for the attributes stored in a typed array. In the code example, every three elements
     * in values defines one attributes since componentsPerAttribute is 3.
     */
    @JsProperty
    public TypedArrays values;

    /**
     * Values and type information for geometry attributes.
     * A Geometry generally contains one or more attributes. All attributes together form the geometry's vertices.
     */
    @JsConstructor
    public GeometryAttribute() {}

    /**
     * Values and type information for geometry attributes.
     * A Geometry generally contains one or more attributes. All attributes together form the geometry's vertices.
     * @param options Options
     */
    //TODO: Examples
    @JsConstructor
    public GeometryAttribute(GeometryAttributeOptions options) {}
}
