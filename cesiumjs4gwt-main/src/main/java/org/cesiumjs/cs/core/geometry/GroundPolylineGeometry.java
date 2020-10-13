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

import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Packable;
import org.cesiumjs.cs.core.geometry.options.GroundPolylineGeometryOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A description of a polyline on terrain. Only to be used with
 * {@link org.cesiumjs.cs.scene.GroundPolylinePrimitive}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "GroundPolylineGeometry")
public class GroundPolylineGeometry extends Geometry implements Packable {
  /**
   * The distance interval used for interpolating options.points. Zero indicates
   * no interpolation. Default of 9999.0 allows centimeter accuracy with 32 bit
   * floating point. Default: 9999.0
   */
  @JsProperty
  public double granularity;
  /**
   * Whether during geometry creation a line segment will be added between the
   * last and first line positions to make this Polyline a loop. If the geometry
   * has two positions this parameter will be ignored. Default: false
   */
  @JsProperty
  public boolean loop;
  /**
   * The screen space width in pixels.
   */
  @JsProperty
  public double width;

  @JsConstructor
  private GroundPolylineGeometry() {
  }

  /**
   * A description of a polyline on terrain. Only to be used with
   * {@link org.cesiumjs.cs.scene.GroundPolylinePrimitive}.
   * 
   * @param options {@link GroundPolylineGeometryOptions} object.
   *
   *                Example: {@code
   * Cartesian3[] positions = Cartesian3.fromDegreesArray(new double[]{-112.1340164450331, 36.05494287836128,
   *                                                                   -112.08821010582645, 36.097804071380715,
   *                -112.13296079730024, 36.168769146801104});
   *                GroundPolylineGeometry geometry =
   *                GroundPolylineGeometry.create(positions); }
   */
  @JsConstructor
  public GroundPolylineGeometry(GroundPolylineGeometryOptions options) {
  }

  /**
   * A description of a polyline on terrain. Only to be used with
   * {@link org.cesiumjs.cs.scene.GroundPolylinePrimitive}.
   * 
   * @param positions An array of Cartesian3 defining the polyline's points.
   *                  Heights above the ellipsoid will be ignored.
   * @return {@link GroundPolylineGeometry} instance.
   *
   *         Example: {@code
   * Cartesian3[] positions = Cartesian3.fromDegreesArray(new double[]{-112.1340164450331, 36.05494287836128,
   *                                                                   -112.08821010582645, 36.097804071380715,
   *         -112.13296079730024, 36.168769146801104}); GroundPolylineGeometry
   *         geometry = GroundPolylineGeometry.create(positions); }
   */
  @JsOverlay
  public static GroundPolylineGeometry create(Cartesian3[] positions) {
    return new GroundPolylineGeometry(GroundPolylineGeometryOptions.create(positions));
  }

  /**
   * Stores the provided instance into the provided array.
   * 
   * @param value The value to pack.
   * @param array The array to pack into.
   * @return The array that was packed into
   */
  @JsMethod
  public static native double[] pack(PolygonGeometry value, double[] array);

  /**
   * Stores the provided instance into the provided array.
   * 
   * @param value         The value to pack.
   * @param array         The array to pack into.
   * @param startingIndex The index into the array at which to start packing the
   *                      elements.
   * @return The array that was packed into
   */
  @JsMethod
  public static native double[] pack(PolygonGeometry value, double[] array, int startingIndex);

  /**
   * Retrieves an instance from a packed array.
   * 
   * @param array The packed array.
   * @return The object into which to store the result.
   */
  @JsMethod
  public static native PolygonGeometry unpack(double[] array);

  /**
   * Retrieves an instance from a packed array.
   * 
   * @param array         The packed array.
   * @param startingIndex The starting index of the element to be unpacked.
   * @return The object into which to store the result.
   */
  @JsMethod
  public static native PolygonGeometry unpack(double[] array, int startingIndex);

  /**
   * Retrieves an instance from a packed array.
   * 
   * @param array         The packed array.
   * @param startingIndex The starting index of the element to be unpacked.
   * @param result        The object into which to store the result.
   * @return The object into which to store the result.
   */
  @JsMethod
  public static native PolygonGeometry unpack(double[] array, int startingIndex, PolygonGeometry result);
}
