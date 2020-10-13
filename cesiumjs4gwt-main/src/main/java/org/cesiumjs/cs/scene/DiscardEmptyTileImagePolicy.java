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

package org.cesiumjs.cs.scene;

import org.cesiumjs.cs.js.JsImage;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A policy for discarding tile images that contain no data (and so aren't
 * actually images). This policy discards
 * DiscardEmptyTileImagePolicy.EMPTY_IMAGE, which is expected to be used in
 * place of any empty tile images by the image loading code.
 * 
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "DiscardEmptyTileImagePolicy")
public class DiscardEmptyTileImagePolicy extends TileDiscardPolicy {
  /**
   * Default value for representing an empty image.
   */
  @JsProperty(name = "EMPTY_IMAGE")
  public static native JsImage EMPTY_IMAGE();

  @JsConstructor
  public DiscardEmptyTileImagePolicy() {
  }
}
