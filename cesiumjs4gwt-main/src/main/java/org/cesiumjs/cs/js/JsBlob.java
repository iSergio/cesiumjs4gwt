/*
 * Copyright 2019 iserge.
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

package org.cesiumjs.cs.js;

import com.google.gwt.typedarrays.shared.ArrayBuffer;
import jsinterop.annotations.*;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Blob")
public class JsBlob {
    @JsConstructor
    public JsBlob(JsObject[] array) {
    }

    @JsConstructor
    public JsBlob(JsObject[] array, JsObjectOptions options) {
    }

    /**
     * The size, in bytes, of the data contained in the Blob object.
     */
    @JsProperty(name = "size")
    public native int size();

    /**
     * A string indicating the MIME type of the data contained in the Blob. If the
     * type is unknown, this string is empty.
     */
    @JsProperty(name = "type")
    public native String type();

    // Blob.slice([start[, end[, contentType]]])
    // Returns a new Blob object containing the data in the specified range of bytes
    // of the source Blob.
    // Blob.stream()
    // Transforms the Blob into a ReadableStream that can be used to read the Blob
    // contents.

    /**
     * Transforms the Blob into a stream and reads it to completion. It returns a
     * promise that resolves with a USVString (text).
     *
     * @return text string
     */
    @JsMethod
    public native String text();

    /**
     * Transforms the Blob into a stream and reads it to completion. It returns a
     * promise that resolves with an ArrayBuffer.
     *
     * @return ArrayBuffer
     */
    @JsMethod
    public native ArrayBuffer arrayBuffer();

    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    public static class JsObjectOptions {
        /**
         * type, with a default value of "", that represents the MIME type of the
         * content of the array that will be put in the blob.
         */
        @JsProperty
        public String type;
        /**
         * That specifies how strings containing the line ending character \n are to be
         * written out. It is one of the two values: "native", meaning that line ending
         * characters are changed to match host OS filesystem convention, or
         * "transparent", meaning that endings are stored in the blob without change.
         * Default: transparent
         */
        @JsProperty
        public String endings;

        @JsConstructor
        public JsObjectOptions() {
        }
    }
}
