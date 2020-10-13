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

package org.cesiumjs.cs.scene.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Whether a classification affects terrain, 3D Tiles or both.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "ClassificationType")
public class ClassificationType {
  /**
   * Only terrain will be classified.
   */
  @JsProperty(name = "TERRAIN")
  public static native Number TERRAIN();

  /**
   * Only 3D Tiles will be classified.
   */
  @JsProperty(name = "CESIUM_3D_TILE")
  public static native Number CESIUM_3D_TILE();

  /**
   * Both terrain and 3D Tiles will be classified.
   */
  @JsProperty(name = "BOTH")
  public static native Number BOTH();

  @JsConstructor
  private ClassificationType() {
  }
}
