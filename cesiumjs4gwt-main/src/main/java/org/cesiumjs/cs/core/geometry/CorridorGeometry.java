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
import org.cesiumjs.cs.core.geometry.options.CorridorGeometryOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A description of a corridor. Corridor geometry can be rendered with both
 * {@link org.cesiumjs.cs.scene.Primitive} and
 * {@link org.cesiumjs.cs.scene.GroundPrimitive}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "CorridorGeometry")
public class CorridorGeometry extends Geometry implements Packable {
  /**
   * The number of elements used to pack the object into an array.
   */
  @JsProperty
  public static double packedLength;

  /**
   * A description of a corridor. Corridor geometry can be rendered with both
   * {@link org.cesiumjs.cs.scene.Primitive} and
   * {@link org.cesiumjs.cs.scene.GroundPrimitive}.
   * 
   * @param options {@link CorridorGeometryOptions}.
   */
  @JsConstructor
  public CorridorGeometry(CorridorGeometryOptions options) {
  }

  /**
   * Computes the geometric representation of a corridor, including its vertices,
   * indices, and a bounding sphere.
   * 
   * @param corridorGeometry A description of the corridor.
   * @return The computed vertices and indices.
   */
  @JsMethod
  public static native Geometry createGeometry(CorridorGeometry corridorGeometry);

  /**
   * Stores the provided instance into the provided array.
   * 
   * @param value The value to pack.
   * @param array The array to pack into.
   * @return The array that was packed into
   */
  @JsMethod
  public static native double[] pack(CorridorGeometry value, double[] array);

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
  public static native double[] pack(CorridorGeometry value, double[] array, int startingIndex);

  /**
   * Retrieves an instance from a packed array.
   * 
   * @param array The packed array.
   * @return The modified result parameter or a new CorridorGeometry instance if
   *         one was not provided.
   */
  @JsMethod
  public static native CorridorGeometry unpack(double[] array);

  /**
   * Retrieves an instance from a packed array.
   * 
   * @param array         The packed array.
   * @param startingIndex The starting index of the element to be unpacked.
   * @return The modified result parameter or a new CorridorGeometry instance if
   *         one was not provided.
   */
  @JsMethod
  public static native CorridorGeometry unpack(double[] array, int startingIndex);

  /**
   * Retrieves an instance from a packed array.
   * 
   * @param array         The packed array.
   * @param startingIndex The starting index of the element to be unpacked.
   * @param result        The object into which to store the result.
   * @return The modified result parameter or a new CorridorGeometry instance if
   *         one was not provided.
   */
  @JsMethod
  public static native CorridorGeometry unpack(double[] array, int startingIndex, CorridorGeometry result);
}
