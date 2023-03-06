/*
 * Copyright 2018 iserge.
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
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Scene;

/**
 * A set of functions to detect whether the current browser supports various
 * features.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "FeatureDetection")
public class FeatureDetection {
    /**
     * A set of functions to detect whether the current browser supports various
     * features.
     */
    @JsConstructor
    private FeatureDetection() {
    }

    /**
     * Detects whether the current browser supports Basis Universal textures and the web assembly modules needed
     * to transcode them.
     * @param scene Scene
     * @return true if the browser supports web assembly modules and the scene supports Basis Universal textures, false if not.
     */
    public static native boolean supportsBasis(Scene scene);

    /**
     * Detects whether the current browser supports BigInt.
     * @return true if the browser supports BigInt, false if not.
     * @see <a href="https://tc39.es/ecma262/#sec-bigint-objects">BigInt Specification</a>
     */
    @JsMethod
    public static native boolean supportsBigInt();

    /**
     * Detects whether the current browser supports BigInt64Array typed arrays.
     * @return true if the browser supports BigInt64Array typed arrays, false if not.
     * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">Typed Array Specification</a>
     */
    @JsMethod
    public static native boolean supportsBigInt64Array();

    /**
     * Detects whether the current browser supports BigUint64Array typed arrays.
     * @return true if the browser supports BigUint64Array typed arrays, false if not.
     * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">Typed Array Specification</a>
     */
    @JsMethod
    public static native boolean supportsBigUint64Array();

    /**
     * Detects whether the current browser supports the full screen standard.
     *
     * @return true if the browser supports the full screen standard, false if not.
     * @see Fullscreen
     * @see <a href=
     * "http://dvcs.w3.org/hg/fullscreen/raw-file/tip/Overview.html">W3C
     * Fullscreen Living Specification</a>
     */
    @JsMethod
    public static native boolean supportsFullscreen();

    /**
     * Detects whether the current browser supports typed arrays.
     *
     * @return true if the browser supports typed arrays, false if not.
     * @see <a href="http://www.khronos.org/registry/typedarray/specs/latest/">Typed
     * Array Specification</a>
     */
    @JsMethod
    public static native boolean supportsTypedArrays();

    /**
     * Detects whether the current browser supports Web Assembly.
     *
     * @return true if the browsers supports Web Assembly, false if not.
     * @see <a href=
     * "https://developer.mozilla.org/en-US/docs/WebAssembly">https://developer.mozilla.org/en-US/docs/WebAssembly</a>
     */
    @JsMethod
    public static native boolean supportsWebAssembly();

    /**
     * Detects whether the current browser supports a WebGL2 rendering context for the specified scene.
     * @param scene the Cesium scene specifying the rendering context
     * @return true if the browser supports a WebGL2 rendering context, false if not.
     */
    @JsMethod
    public static native boolean supportsWebgl2(Scene scene);

    /**
     * Detects whether the current browser supports Web Workers.
     *
     * @return true if the browsers supports Web Workers, false if not.
     * @see <a href=
     * "http://www.w3.org/TR/workers/">http://www.w3.org/TR/workers/</a>
     */
    @JsMethod
    public static native boolean supportsWebWorkers();
}
