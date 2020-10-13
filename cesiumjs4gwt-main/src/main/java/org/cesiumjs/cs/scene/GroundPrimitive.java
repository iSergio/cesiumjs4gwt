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

package org.cesiumjs.cs.scene;

import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.enums.ClassificationType;
import org.cesiumjs.cs.scene.options.GroundPrimitiveOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A ground primitive represents geometry draped over the terrain in the
 * {@link Scene}. The geometry must be from a single
 * {@link org.cesiumjs.cs.core.geometry.GeometryInstance}. Batching multiple
 * geometries is not yet supported.
 *
 * A primitive combines the geometry instance with an
 * {@link org.cesiumjs.cs.scene.apperances.Appearance} that describes the full
 * shading, including {@link Material} and RenderState. Roughly, the geometry
 * instance defines the structure and placement, and the appearance defines the
 * visual characteristics. Decoupling geometry and appearance allows us to mix
 * and match most of them and add a new geometry or appearance independently of
 * each other. Only the
 * {@link org.cesiumjs.cs.scene.apperances.PerInstanceColorAppearance} is
 * supported at this time.
 *
 * For correct rendering, this feature requires the EXT_frag_depth WebGL
 * extension. For hardware that do not support this extension, there will be
 * rendering artifacts for some viewing angles.
 *
 * @see Primitive
 * @see ClassificationPrimitive
 * @see org.cesiumjs.cs.core.geometry.GeometryInstance
 * @see org.cesiumjs.cs.scene.apperances.Appearance
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "GroundPrimitive")
public class GroundPrimitive extends Primitive {
  /**
   * When true, each geometry instance will only be pickable with Scene#pick. When
   * false, GPU memory is saved. Default: true
   */
  @JsProperty(name = "allowPicking")
  public native boolean allowPicking();

  /**
   * Determines if the geometry instances will be created and batched on a web
   * worker. Default: true
   */
  @JsProperty(name = "asynchronous")
  public native boolean asynchronous();

  /**
   * Determines whether terrain, 3D Tiles or both will be classified. Default:
   * {@link ClassificationType#TERRAIN()}
   */
  @JsProperty
  public Number classificationType;

  /**
   * When true, geometry vertices are compressed, which will save memory. Default:
   * true
   */
  @JsProperty(name = "compressVertices")
  public native boolean compressVertices();

  /**
   * This property is for debugging only; it is not for production use nor is it
   * optimized. Draws the bounding sphere for each draw command in the primitive.
   * Default: false
   */
  @JsProperty
  public boolean debugShowBoundingVolume;
  /**
   * This property is for debugging only; it is not for production use nor is it
   * optimized. Draws the shadow volume for each geometry in the primitive.
   */
  @JsProperty
  public boolean debugShowShadowVolume;

  /**
   * The geometry instance rendered with this primitive. This may be undefined if
   * options.releaseGeometryInstances is true when the primitive is constructed.
   * Changing this property after the primitive is rendered has no effect.
   *
   * Because of the rendering technique used, all geometry instances must be the
   * same color. If there is an instance with a differing color, a DeveloperError
   * will be thrown on the first attempt to render.
   *
   * Default: undefined
   */
  @JsProperty(name = "geometryInstances")
  public native GeometryInstance[] geometryInstances();

  /**
   * Determines if geometry vertex attributes are interleaved, which can slightly
   * improve rendering performance. Default: false
   */
  @JsProperty(name = "interleave")
  public native boolean interleave();

  /**
   * Determines if the primitive is complete and ready to render. If this property
   * is true, the primitive will be rendered the next time that
   * {@link GroundPrimitive#update(Object)} is called.
   */
  @JsProperty(name = "ready")
  public native boolean ready();

  /**
   * Gets a promise that resolves when the primitive is ready to render.
   */
  @JsProperty(name = "readyPromise")
  public native Promise<Primitive, Void> readyPromise();

  /**
   * When true, the primitive does not keep a reference to the input
   * geometryInstances to save memory. Default: true
   */
  @JsProperty(name = "releaseGeometryInstances")
  public native boolean releaseGeometryInstances();

  /**
   * Determines if the primitive will be shown. This affects all geometry
   * instances in the primitive. Default: true
   */
  @JsProperty
  public boolean show;

  /**
   * When true, geometry vertices are optimized for the pre and post-vertex-shader
   * caches. Default: true
   */
  @JsProperty(name = "vertexCacheOptimize")
  public native boolean vertexCacheOptimize();

  // TODO: Examples
  @JsConstructor
  public GroundPrimitive() {
  }

  // TODO: Examples
  @JsConstructor
  public GroundPrimitive(GroundPrimitiveOptions options) {
  }

  /**
   * Initializes the minimum and maximum terrain heights. This only needs to be
   * called if you are creating the GroundPrimitive synchronously.
   * 
   * @return A promise that will resolve once the terrain heights have been
   *         loaded.
   */
  @JsMethod
  public static native Promise<JsObject, Void> initializeTerrainHeights();

  /**
   * Determines if GroundPrimitive rendering is supported.
   * 
   * @param scene The scene.
   * @return true if GroundPrimitives are supported; otherwise, returns false
   */
  @JsMethod
  public static native boolean isSupported(Scene scene);

  /**
   * Checks if the given Scene supports materials on GroundPrimitives. Materials
   * on GroundPrimitives require support for the WEBGL_depth_texture extension.
   * 
   * @param scene The current scene.
   * @return Whether or not the current scene supports materials on
   *         GroundPrimitives.
   */
  @JsMethod
  public static native boolean supportsMaterials(Scene scene);
}
