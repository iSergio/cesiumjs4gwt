/*
 * Copyright 2020 iSerge.
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
package org.cesiumjs.cs.scene;

import org.cesiumjs.cs.scene.options.DebugCameraPrimitiveOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Draws the outline of the camera's view frustum.
 */
@JsType(isNative = true, namespace = "Cesium", name = "DebugCameraPrimitive")
public class DebugCameraPrimitive extends Primitive {
  /**
   * User-defined value returned when the primitive is picked. Default: undefined
   * 
   * @see org.cesiumjs.cs.scene.Scene#pick
   */
  @JsProperty
  public Object id;

  /**
   * Determines if this primitive will be shown. Default: true
   */
  @JsProperty
  public boolean show;

  /**
   * Draws the outline of the camera's view frustum.
   * 
   * @param options object
   */
  @JsConstructor
  public DebugCameraPrimitive(DebugCameraPrimitiveOptions options) {
  }
}