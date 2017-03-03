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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.options.VertexFormatOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "VertexFormat")
public class VertexFormat implements Packable {
    /**
     * An immutable vertex format with position, normal, and st attributes.
     * This is compatible with most appearances and materials; however normal and st attributes are not always required.
     * When this is known in advance, another VertexFormat should be used.
     * @see #position
     * @see #normal
     */
    @JsProperty(name = "DEFAULT")
    public static native VertexFormat DEFAULT();
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty(name = "packedLength")
    public static native int packedLength();
    /**
     * An immutable vertex format with position and color attributes.
     * @see #position
     * @see #color
     */
    @JsProperty(name = "POSITION_AND_COLOR")
    public static native VertexFormat POSITION_AND_COLOR();

    /**
     * An immutable vertex format with position and normal attributes.
     * This is compatible with per-instance color appearances like PerInstanceColorAppearance.
     * @see #position
     * @see #normal
     */
    @JsProperty(name = "POSITION_AND_NORMAL")
    public static native VertexFormat POSITION_AND_NORMAL();
    /**
     * An immutable vertex format with position and st attributes. This is compatible with EllipsoidSurfaceAppearance.
     * @see #position
     * @see #st
     */
    @JsProperty(name = "POSITION_AND_ST")
    public static native VertexFormat POSITION_AND_ST();
    /**
     * An immutable vertex format with position, normal, and st attributes.
     * This is compatible with MaterialAppearance when MaterialAppearance#materialSupport is TEXTURED/code>.
     * @see #position
     * @see #normal
     * @see #st
     */
    @JsProperty(name = "POSITION_NORMAL_AND_ST")
    public static native VertexFormat POSITION_NORMAL_AND_ST();
    /**
     * An immutable vertex format with only a position attribute.
     * @see #position
     */
    @JsProperty(name = "POSITION_ONLY")
    public static native VertexFormat POSITION_ONLY();

    /**
     * When true, the vertex has a bitangent attribute (normalized), which is used for tangent-space effects like bump mapping.
     * 32-bit floating-point. 3 components per attribute.
     * Default: false
     */
    @JsProperty
    public boolean bitangent;
    /**
     * When true, the vertex has an RGB color attribute.
     * 8-bit unsigned byte. 3 components per attribute.
     * Default: false
     */
    @JsProperty
    public boolean color;
    /**
     * When true, the vertex has a normal attribute (normalized), which is commonly used for lighting.
     * 32-bit floating-point. 3 components per attribute.
     * Default: false
     */
    @JsProperty
    public boolean normal;
    /**
     * When true, the vertex has a 3D position attribute.
     * 64-bit floating-point (for precision). 3 components per attribute.
     * Default: false
     */
    @JsProperty
    public boolean position;
    /**
     * When true, the vertex has a 2D texture coordinate attribute.
     * 32-bit floating-point. 2 components per attribute
     * Default: false
     */
    @JsProperty
    public boolean st;
    /**
     * When true, the vertex has a tangent attribute (normalized), which is used for tangent-space effects like bump mapping.
     * 32-bit floating-point. 3 components per attribute.
     * Default: false
     */
    @JsProperty
    public boolean tangent;

    /**
     * A vertex format defines what attributes make up a vertex.
     * A VertexFormat can be provided to a Geometry to request that certain properties be computed, e.g.,
     * just position, position and normal, etc.
     */
    @JsConstructor
    public VertexFormat() {}

    /**
     * A vertex format defines what attributes make up a vertex.
     * A VertexFormat can be provided to a Geometry to request that certain properties be computed, e.g.,
     * just position, position and normal, etc.
     * @param options Options
     */
    @JsConstructor
    public VertexFormat(VertexFormatOptions options) {}

    /**
     * Duplicates a VertexFormat instance.
     * @param cartesian The vertex format to duplicate.
     * @return The modified result parameter or a new VertexFormat instance if one was not provided. (Returns undefined if vertexFormat is undefined)
     */
    @JsMethod
    public static native VertexFormat clone(VertexFormat cartesian);

    /**
     * Duplicates a VertexFormat instance.
     * @param cartesian The vertex format to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new VertexFormat instance if one was not provided. (Returns undefined if vertexFormat is undefined)
     */
    @JsMethod
    public static native VertexFormat clone(VertexFormat cartesian, VertexFormat result);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(VertexFormat value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(VertexFormat value, double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new VertexFormat instance if one was not provided.
     */
    @JsMethod
    public static native VertexFormat unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @return The modified result parameter or a new VertexFormat instance if one was not provided.
     */
    @JsMethod
    public static native VertexFormat unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new VertexFormat instance if one was not provided.
     */
    @JsMethod
    public static native VertexFormat unpack(double[] array, int startingIndex, VertexFormat result);
}
