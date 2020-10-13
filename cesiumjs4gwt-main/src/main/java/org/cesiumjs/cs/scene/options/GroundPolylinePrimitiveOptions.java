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

package org.cesiumjs.cs.scene.options;

import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.scene.apperances.Appearance;
import org.cesiumjs.cs.scene.enums.ClassificationType;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link org.cesiumjs.cs.scene.GroundPolylinePrimitive}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GroundPolylinePrimitiveOptions {
  /**
   * GeometryInstances containing GroundPolylineGeometry
   */
  @JsProperty
  public GeometryInstance[] geometryInstances;
  /**
   * The Appearance used to render the polyline. Defaults to a white color
   * Material on a PolylineMaterialAppearance.
   */
  @JsProperty
  public Appearance appearance;
  /**
   * Determines if this primitive will be shown. Default: true
   */
  @JsProperty
  public boolean show;
  /**
   * When true, geometry vertex attributes are interleaved, which can slightly
   * improve rendering performance but increases load time. Default: false
   */
  @JsProperty
  public boolean interleave;
  /**
   * When true, the primitive does not keep a reference to the input
   * geometryInstances to save memory. Default: true
   */
  @JsProperty
  public boolean releaseGeometryInstances;
  /**
   * When true, each geometry instance will only be pickable with Scene#pick. When
   * false, GPU memory is saved. Default: true
   */
  @JsProperty
  public boolean allowPicking;
  /**
   * Determines if the primitive will be created asynchronously or block until
   * ready. If false initializeTerrainHeights() must be called first. Default:
   * true
   */
  @JsProperty
  public boolean asynchronous;
  /**
   * Determines whether terrain, 3D Tiles or both will be classified. Default:
   * {@link ClassificationType#BOTH()}
   */
  @JsProperty
  public ClassificationType classificationType;
  /**
   * For debugging only. Determines if this primitive's commands' bounding spheres
   * are shown. Default: false
   */
  @JsProperty
  public boolean debugShowBoundingVolume;
  /**
   * For debugging only. Determines if the shadow volume for each geometry in the
   * primitive is drawn. Must be true on creation to have effect. Default: false
   */
  @JsProperty
  public boolean debugShowShadowVolume;

  /**
   * Options instance for {@link org.cesiumjs.cs.scene.GroundPolylinePrimitive}
   */
  @JsConstructor
  public GroundPolylinePrimitiveOptions() {
  }

}
