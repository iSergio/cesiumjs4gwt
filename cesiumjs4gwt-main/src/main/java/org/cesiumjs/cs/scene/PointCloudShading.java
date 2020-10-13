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

import org.cesiumjs.cs.scene.options.PointCloudShadingOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for performing point attenuation based on geometric error when
 * rendering point clouds using 3D Tiles.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PointCloudShading")
public class PointCloudShading {
  /**
   * Perform point attenuation based on geometric error. Default: false
   */
  @JsProperty
  public boolean attenuation;
  /**
   * Determines whether back-facing points are hidden. This option works only if
   * data has normals included. Default: false
   */
  @JsProperty
  public boolean backFaceCulling;
  /**
   * Scale to be applied to each tile's geometric error. Default: 1.0
   */
  @JsProperty
  public double geometricErrorScale;
  /**
   * Maximum attenuation in pixels. Defaults to the Cesium3DTileset's
   * maximumScreenSpaceError.
   */
  @JsProperty
  public int maximumAttenuation;
  /**
   * Average base resolution for the dataset in meters. Substitute for Geometric
   * Error when not available.
   */
  @JsProperty
  public double baseResolution;
  /**
   * When true, use eye dome lighting when drawing with point attenuation.
   * Default: true
   */
  @JsProperty
  public boolean eyeDomeLighting;
  /**
   * Increasing this value increases contrast on slopes and edges. Default: 1.0
   */
  @JsProperty
  public double eyeDomeLightingStrength;
  /**
   * Increase the thickness of contours from eye dome lighting. Default: 1.0
   */
  @JsProperty
  public double eyeDomeLightingRadius;
  /**
   * Determines whether a point cloud that contains normals is shaded based on the
   * sun direction. Default: true
   */
  @JsProperty
  public boolean normalShading;

  /**
   * Options for performing point attenuation based on geometric error when
   * rendering point clouds using 3D Tiles.
   */
  @JsConstructor
  public PointCloudShading() {
  }

  /**
   * Options for performing point attenuation based on geometric error when
   * rendering point clouds using 3D Tiles.
   * 
   * @param options object {@link PointCloudShadingOptions}
   */
  @JsConstructor
  public PointCloudShading(PointCloudShadingOptions options) {
  }

  /**
   * Determines if point cloud shading is supported.
   * 
   * @param scene The scene.
   * @return true if point cloud shading is supported; otherwise, returns false
   */
  @JsMethod
  public static native boolean isSupported(Scene scene);
}
