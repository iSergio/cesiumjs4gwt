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
 * Options to control the setting up of a WebGL Context.
 * allowTextureFilterAnisotropic defaults to true, which enables anisotropic texture filtering when the WebGL extension
 * is supported. Setting this to false will improve performance, but hurt visual quality, especially for horizon views.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ContextOptions {
    /**
     * If true and the browser supports it, use a WebGL 1 rendering context.
     * Default: true
     */
    @JsProperty
    public boolean requestWebgl1;
    /**
     * @deprecated ContextOptions.requestWebgl2 was deprecated in CesiumJS 1.101 and will be removed in 1.102. Instead,
     * CesiumJS will default to using a WebGL2 context for rendering. Use ContextOptions.requestWebgl1 to
     * request a WebGL1 or WebGL2 context.
     */
    @Deprecated
    @JsProperty
    public boolean requestWebgl2;
    /**
     * If true, use anisotropic filtering during texture sampling.
     * Default: true
     */
    @JsProperty
    public boolean allowTextureFilterAnisotropic;
    /**
     * WebGL options to be passed on to canvas.getContext
     */
    @JsProperty
    public WebGLOptions webgl;

//    getWebGLStub	function	<optional>
//    A function to create a WebGL stub for testing
}
