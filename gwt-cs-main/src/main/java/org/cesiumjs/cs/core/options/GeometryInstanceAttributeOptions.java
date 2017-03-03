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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.ComponentDatatype;
import org.cesiumjs.cs.core.GeometryInstanceAttribute;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeometryInstanceAttributeOptions {
    /**
     * The datatype of each component in the attribute, e.g., individual elements in values.
     */
    @JsProperty
    public ComponentDatatype componentDatatype;
    /**
     * A number between 1 and 4 that defines the number of components in an attributes.
     */
    @JsProperty
    public double componentsPerAttribute;
    /**
     * When true and componentDatatype is an integer format, indicate that the components should be mapped to the
     * range [0, 1] (unsigned) or [-1, 1] (signed) when they are accessed as floating-point for rendering.
     */
    @JsProperty
    public boolean normalize;
    /**
     * The value for the attribute.
     */
    @JsProperty
    public double[] value;

    /**
     * Options for {@link GeometryInstanceAttribute}
     */
    @JsConstructor
    public GeometryInstanceAttributeOptions() {}
}
