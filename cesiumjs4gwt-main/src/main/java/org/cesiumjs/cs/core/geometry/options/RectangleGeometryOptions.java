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

package org.cesiumjs.cs.core.geometry.options;

import org.cesiumjs.cs.core.VertexFormat;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class RectangleGeometryOptions extends RectangleOutlineGeometryOptions {
  /**
   * The vertex attributes to be computed. Default
   * {@link org.cesiumjs.cs.core.VertexFormat#DEFAULT()}
   */
  @JsProperty
  public VertexFormat vertexFormat;
  /**
   * The rotation of the texture coordinates, in radians. A positive rotation is
   * counter-clockwise. Default: 0.0
   */
  @JsProperty
  public double stRotation;
  /**
   * Specifies whether the rectangle has a top cover when extruded. Default: true
   */
  @JsProperty
  public boolean closeTop;
  /**
   * Specifies whether the rectangle has a bottom cover when extruded. Default:
   * true
   */
  @JsProperty
  public boolean closeBottom;

  /**
   * Options for {@link org.cesiumjs.cs.core.geometry.RectangleGeometry}
   */
  @JsConstructor
  public RectangleGeometryOptions() {
  }
}
