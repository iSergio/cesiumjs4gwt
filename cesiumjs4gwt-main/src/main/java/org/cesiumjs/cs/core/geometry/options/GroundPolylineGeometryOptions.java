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

import org.cesiumjs.cs.core.Cartesian3;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link org.cesiumjs.cs.core.geometry.GroundPolylineGeometry}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GroundPolylineGeometryOptions {
  /**
   * An array of Cartesian3 defining the polyline's points. Heights above the
   * ellipsoid will be ignored.
   */
  @JsProperty
  public Cartesian3[] positions;
  /**
   * The screen space width in pixels. Default: 1
   */
  @JsProperty
  public int width;
  /**
   * The distance interval in meters used for interpolating options.points.
   * Defaults to 9999.0 meters. Zero indicates no interpolation. Default: 9999.0
   */
  @JsProperty
  public double granularity;
  /**
   * Whether during geometry creation a line segment will be added between the
   * last and first line positions to make this Polyline a loop. Default: false
   */
  @JsProperty
  public boolean loop;

  @JsConstructor
  private GroundPolylineGeometryOptions() {
  }

  @JsOverlay
  public static GroundPolylineGeometryOptions create(Cartesian3[] positions) {
    GroundPolylineGeometryOptions options = new GroundPolylineGeometryOptions();
    options.positions = positions;
    return options;
  }
}
