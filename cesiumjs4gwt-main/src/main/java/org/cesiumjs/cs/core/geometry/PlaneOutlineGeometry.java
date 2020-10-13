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

package org.cesiumjs.cs.core.geometry;

import org.cesiumjs.cs.core.Packable;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Describes geometry representing the outline of a plane centered at the
 * origin, with a unit width and length.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PlaneOutlineGeometry")
public class PlaneOutlineGeometry extends Geometry implements Packable {
  /**
   * Describes geometry representing the outline of a plane centered at the
   * origin, with a unit width and length.
   */
  @JsConstructor
  public PlaneOutlineGeometry() {
  }
}
