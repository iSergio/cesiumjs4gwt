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
package org.cesiumjs.cs.scene.options;

import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.scene.Camera;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@see org.cesiumjs.cs.scene.DebugCameraPrimitive}
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DebugCameraPrimitiveOptions {
  /**
   * The camera.
   */
  @JsProperty
  public Camera camera;
  /**
   * Distances to the near and far planes of the camera frustums. 
   * This overrides the camera's frustum near and far values.
   */
  @JsProperty
  public Number[] frustumSplits;
  /**
   * The color of the debug outline.
   * Default: Color.CYAN
   */
  @JsProperty
  public Color color;
  /**
   * Whether the primitive updates when the underlying camera changes.
   * Default: true
   */
  @JsProperty
  public boolean updateOnChange;
  /**
   * Determines if this primitive will be shown.
   * Default: true
   */
  @JsProperty
  public boolean show;
  /**
   * A user-defined object to return when the instance is picked with Scene#pick.
   */
  @JsProperty
  public Object id;

  @JsConstructor
  protected DebugCameraPrimitiveOptions() {}

  /**
   * Create new instance
   * @param camera The camera.
   * @return options
   */
  @JsOverlay
  public static DebugCameraPrimitiveOptions create(Camera camera) {
    DebugCameraPrimitiveOptions options = new DebugCameraPrimitiveOptions();
    options.camera = camera;
    return options;
  }
}