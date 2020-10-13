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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for
 * {@link org.cesiumjs.cs.core.TaskProcessor#initWebAssemblyModule(WebAssemblyOptions)}
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WebAssemblyOptions {
  /**
   * The path of the web assembly JavaScript wrapper module.
   */
  @JsProperty
  public String modulePath;
  /**
   * The path of the web assembly binary file.
   */
  @JsProperty
  public String wasmBinaryFile;
  /**
   * The path of the fallback JavaScript module to use if web assembly is not
   * supported.
   */
  @JsProperty
  public String fallbackModulePath;

  @JsConstructor
  public WebAssemblyOptions() {
  }
}
