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

import com.google.gwt.typedarrays.shared.Uint8Array;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ColorGeometryInstanceAttribute")
public class ColorGeometryInstanceAttribute {
    /**
     * The datatype of each component in the attribute, e.g., individual elements in ColorGeometryInstanceAttribute#value.
     * Default: {@link ComponentDatatype#UNSIGNED_BYTE()}
     */
    @JsProperty(name = "componentDatatype")
    public native ComponentDatatype componentDatatype();
    /**
     * The number of components in the attributes, i.e., ColorGeometryInstanceAttribute#value.
     * Default: 4
     */
    @JsProperty(name = "componentsPerAttribute")
    public native double componentsPerAttribute();

    /**
     * When true and componentDatatype is an integer format, indicate that the components should be mapped to the
     * range [0, 1] (unsigned) or [-1, 1] (signed) when they are accessed as floating-point for rendering.
     * Default: true
     */
    @JsProperty(name = "normalize")
    public native boolean normalize();

    /**
     * The values for the attributes stored in a typed array.
     * Default: [255, 255, 255, 255]
     */
    @JsProperty
    public Uint8Array value;

    /**
     * Value and type information for per-instance geometry color.
     * @param red The red component.
     */
    @JsConstructor
    public ColorGeometryInstanceAttribute(double red) {}

    /**
     * Value and type information for per-instance geometry color.
     * @param red The red component.
     * @param green The green component.
     */
    @JsConstructor
    public ColorGeometryInstanceAttribute(double red, double green) {}

    /**
     * Value and type information for per-instance geometry color.
     * @param red The red component.
     * @param green The green component.
     * @param blue The blue component.
     */
    @JsConstructor
    public ColorGeometryInstanceAttribute(double red, double green, double blue) {}

    /**
     * Value and type information for per-instance geometry color.
     * @param red The red component.
     * @param green The green component.
     * @param blue The blue component.
     * @param alpha The alpha component.
     */
    @JsConstructor
    public ColorGeometryInstanceAttribute(double red, double green, double blue, double alpha) {}

    /**
     * Compares the provided ColorGeometryInstanceAttributes and returns true if they are equal, false otherwise.
     * @param left The first ColorGeometryInstanceAttribute.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(ColorGeometryInstanceAttribute left);

    /**
     * Compares the provided ColorGeometryInstanceAttributes and returns true if they are equal, false otherwise.
     * @param left The first ColorGeometryInstanceAttribute.
     * @param right The second ColorGeometryInstanceAttribute.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(ColorGeometryInstanceAttribute left, ColorGeometryInstanceAttribute right);

    /**
     * Creates a new ColorGeometryInstanceAttribute instance given the provided Color.
     * @param color The color.
     * @return The new ColorGeometryInstanceAttribute instance.
     */
    @JsMethod
    public static native ColorGeometryInstanceAttribute fromColor(Color color);

    /**
     * Converts a color to a typed array that can be used to assign a color attribute.
     * @param color The color.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    @JsMethod
    public static native Uint8Array toValue(Color color);

    /**
     * Converts a color to a typed array that can be used to assign a color attribute.
     * @param color The color.
     * @param result The array to store the result in, if undefined a new instance will be created.
     * @return The modified result parameter or a new instance if result was undefined.
     */
    @JsMethod
    public static native Uint8Array toValue(Color color, Uint8Array result);
}
