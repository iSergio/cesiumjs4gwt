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

import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.typedarrays.shared.ArrayBufferView;
import com.google.gwt.typedarrays.shared.TypedArrays;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * WebGL component datatypes. Components are intrinsics, which form attributes, which form vertices.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesiun", name = "ComponentDatatype")
public class ComponentDatatype {
    /**
     * 64-bit floating-point corresponding to gl.DOUBLE (in Desktop OpenGL; this is not supported in WebGL,
     * and is emulated in Cesium via GeometryPipeline.encodeAttribute) and the type of an element in Float64Array.
     */
    @JsProperty(name = "DOUBLE")
    public static native double DOUBLE();
    /**
     * 32-bit signed int corresponding to INT and the type of an element in Int32Array.
     */
    @JsProperty(name = "INT")
    public static native double INT();
    /**
     * 32-bit unsigned int corresponding to UNSIGNED_INT and the type of an element in Uint32Array.
     */
    @JsProperty(name = "UNSIGNED_INT")
    public static native double UNSIGNED_INT();
    /**
     * 8-bit signed byte corresponding to gl.BYTE and the type of an element in Int8Array.
     */
    @JsProperty(name = "BYTE")
    public static native double BYTE();
    /**
     * 32-bit floating-point corresponding to FLOAT and the type of an element in Float32Array.
     */
    @JsProperty(name = "FLOAT")
    public static native double FLOAT();
    /**
     * 16-bit signed short corresponding to SHORT and the type of an element in Int16Array.
     */
    @JsProperty(name = "SHORT")
    public static native double SHORT();
    /**
     * 8-bit unsigned byte corresponding to UNSIGNED_BYTE and the type of an element in Uint8Array.
     */
    @JsProperty(name = "UNSIGNED_BYTE")
    public static native double UNSIGNED_BYTE();
    /**
     * 16-bit unsigned short corresponding to UNSIGNED_SHORT and the type of an element in Uint16Array.
     */
    @JsProperty(name = "UNSIGNED_SHORT")
    public static native double UNSIGNED_SHORT();

    /**
     * WebGL component datatypes. Components are intrinsics, which form attributes, which form vertices.
     */
    @JsConstructor
    private ComponentDatatype() {}

    /**
     * Creates a typed view of an array of bytes.
     * @param componentDatatype {@link ComponentDatatype} The type of the view to create.
     * @param buffer The buffer storage to use for the view.
     * @return A typed array view of the buffer. (Int8Array|Uint8Array|Int16Array|Uint16Array|Int32Array|Uint32Array|Float32Array|Float64Array)
     */
    @JsMethod
    public static native ArrayBufferView createArrayBufferView(double componentDatatype, ArrayBuffer buffer);

    /**
     * Creates a typed view of an array of bytes.
     * @param componentDatatype {@link ComponentDatatype} The type of the view to create.
     * @param buffer The buffer storage to use for the view.
     * @param byteOffset The offset, in bytes, to the first element in the view.
     * @param length The number of elements in the view.
     * @return A typed array view of the buffer. (Int8Array|Uint8Array|Int16Array|Uint16Array|Int32Array|Uint32Array|Float32Array|Float64Array)
     */
    @JsMethod
    public static native ArrayBufferView createArrayBufferView(double componentDatatype, ArrayBuffer buffer, int byteOffset, int length);

    /**
     * Creates a typed array corresponding to component data type.
     * <pre>
     *     Example:
     *     {@code
     *     // creates a Float32Array with length of 100
     *     Float32Array typedArray = ComponentDatatype.createTypedArray(ComponentDatatype.FLOAT(), 100);
     *     }
     * </pre>
     * @param componentDatatype
     * @param values The array to create or an array.
     * @return A typed array. (Int8Array|Uint8Array|Int16Array|Uint16Array|Int32Array|Uint32Array|Float32Array|Float64Array)
     */
    @JsMethod
    public static native ArrayBufferView createTypedArray(double componentDatatype, ArrayBuffer values);

    /**
     * Creates a typed array corresponding to component data type.
     * <pre>
     *     Example:
     *     {@code
     *     // creates a Float32Array with length of 100
     *     Float32Array typedArray = ComponentDatatype.createTypedArray(ComponentDatatype.FLOAT(), 100);
     *     }
     * </pre>
     * @param componentDatatype
     * @param length The length to create or an array.
     * @return A typed array. (Int8Array|Uint8Array|Int16Array|Uint16Array|Int32Array|Uint32Array|Float32Array|Float64Array)
     */
    @JsMethod
    public static native ArrayBufferView createTypedArray(double componentDatatype, int length);

    /**
     * Get the ComponentDatatype from its name.
     * @param name The name of the ComponentDatatype.
     * @return The ComponentDatatype.
     */
    @JsMethod
    public static native int fromName(String name);

    /**
     * Gets the ComponentDatatype for the provided TypedArray instance.
     * @param array The typed array.
     * @return The ComponentDatatype for the provided array, or undefined if the array is not a TypedArray.
     */
    @JsMethod
    public static native int fromTypedArray(TypedArrays array);

    /**
     * Returns the size, in bytes, of the corresponding datatype.
     * @param componentDatatype The component datatype to get the size of.
     * @return The size in bytes.
     */
    @JsMethod
    public static native int getSizeInBytes(int componentDatatype);

    /**
     * Validates that the provided component datatype is a valid ComponentDatatype
     * @param componentDatatype {@link ComponentDatatype} The component datatype to validate.
     * @return true if the provided component datatype is a valid value; otherwise, false.
     */
    //TODO: Example
    @JsMethod
    public static native boolean validate(int componentDatatype);
}
