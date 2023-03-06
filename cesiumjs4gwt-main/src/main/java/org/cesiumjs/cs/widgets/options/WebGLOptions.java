/*
 * Copyright 2023 iSergio, Gis4Fun.
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

package org.cesiumjs.cs.widgets.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * WebGL options to be passed on to HTMLCanvasElement.getContext(). See WebGLContextAttributes but note the modified
 * defaults for 'alpha', 'stencil', and 'powerPreference'
 * <p>alpha defaults to false, which can improve performance compared to the standard WebGL default of true.
 * If an application needs to composite Cesium above other HTML elements using alpha-blending, set alpha to true.</p>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WebGLOptions {
    /**
     * Default: false
     */
    @JsProperty
    public boolean alpha;
    /**
     * Default: true
     */
    @JsProperty
    public boolean depth;
    /**
     * Default: false
     */
    @JsProperty
    public boolean stencil;
    /**
     * Default: true
     */
    @JsProperty
    public boolean antialias;
    /**
     * Default: true
     */
    @JsProperty
    public boolean premultipliedAlpha;
    /**
     * Default: false
     */
    @JsProperty
    public boolean preserveDrawingBuffer;
    /**
     * "default" | "low-power" | "high-performance"
     * Default: high-performance
     */
    @JsProperty
    public String powerPreference;
    /**
     * Default: false
     */
    @JsProperty
    public boolean failIfMajorPerformanceCaveat;
}
