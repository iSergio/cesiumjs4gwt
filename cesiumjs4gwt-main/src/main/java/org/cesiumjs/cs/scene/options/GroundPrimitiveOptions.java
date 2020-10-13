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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link org.cesiumjs.cs.scene.GroundPrimitive}
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GroundPrimitiveOptions {
  /**
   * The geometry instances to render.
   */
  @JsProperty
  public GeometryInstance[] geometryInstances;
  /**
   * Determines if this primitive will be shown. Default: true
   */
  @JsProperty
  public boolean show;
  /**
   * When true, geometry vertices are optimized for the pre and post-vertex-shader
   * caches. Default: false
   */
  @JsProperty
  public boolean vertexCacheOptimize;
  /**
   * When true, geometry vertex attributes are interleaved, which can slightly
   * improve rendering performance but increases load time. Default: false
   */
  @JsProperty
  public boolean interleave;
  /**
   * When true, the geometry vertices are compressed, which will save memory.
   * Default: true
   */
  @JsProperty
  public boolean compressVertices;
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
   * {@link org.cesiumjs.cs.scene.enums.ClassificationType#BOTH()}
   */
  @JsProperty
  public Number classificationType;
  /**
   * For debugging only. Determines if this primitive's commands' bounding spheres
   * are shown. Default: false
   */
  @JsProperty
  public boolean debugShowBoundingVolume;
  /**
   * For debugging only. Determines if the shadow volume for each geometry in the
   * primitive is drawn. Must be true on creation for the volumes to be created
   * before the geometry is released or options.releaseGeometryInstance must be
   * false. Default: false
   */
  @JsProperty
  public boolean debugShowShadowVolume;

  @JsConstructor
  public GroundPrimitiveOptions() {
  }
}
