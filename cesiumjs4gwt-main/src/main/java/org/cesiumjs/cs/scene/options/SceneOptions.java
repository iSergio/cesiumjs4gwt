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

import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;

import org.cesiumjs.cs.core.projection.MapProjection;
import org.cesiumjs.cs.scene.enums.MapMode2D;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SceneOptions {
  /**
   * The HTML canvas element to create the scene for.
   */
  @JsProperty
  public CanvasElement canvas;
  /**
   * Context and WebGL creation properties. See details above.
   */
  // TODO: make later simple class
  @JsProperty
  public Object contextOptions;
  /**
   * The HTML element in which the credits will be displayed.
   */
  @JsProperty
  public Element creditContainer;
  /**
   * The map projection to use in 2D and Columbus View modes. Default:
   * {@link org.cesiumjs.cs.core.projection.GeographicProjection}
   */
  @JsProperty
  public MapProjection mapProjection;
  /**
   * If true and the configuration supports it, use order independent
   * translucency. Default: true
   */
  @JsProperty
  public boolean orderIndependentTranslucency;
  /**
   * If true, optimizes memory use and performance for 3D mode but disables the
   * ability to use 2D or Columbus View. Default: false
   */
  @JsProperty
  public boolean scene3DOnly;
  /**
   * A scalar used to exaggerate the terrain. Note that terrain exaggeration will
   * not modify any other primitive as they are positioned relative to the
   * ellipsoid. Default: 1.0
   */
  @JsProperty
  public double terrainExaggeration;
  /**
   * Determines if shadows are cast by the sun. Default: false
   */
  @JsProperty
  public boolean shadows;
  /**
   * Determines if the 2D map is rotatable or can be scrolled infinitely in the
   * horizontal direction. Default: {@link MapMode2D#INFINITE_SCROLL()}
   */
  @JsProperty
  public int mapMode2D;
  /**
   * If true, rendering a frame will only occur when needed as determined by
   * changes within the scene. Enabling improves performance of the application,
   * but requires using {@link org.cesiumjs.cs.scene.Scene#requestRender()} to
   * render a new frame explicitly in this mode. This will be necessary in many
   * cases after making changes to the scene in other parts of the API. See
   * Improving Performance with Explicit Rendering. Default: false
   */
  @JsProperty
  public boolean requestRenderMode;
  /**
   * If requestRenderMode is true, this value defines the maximum change in
   * simulation time allowed before a render is requested. See Improving
   * Performance with Explicit Rendering. Default: 0.0
   */
  @JsProperty
  public double maximumRenderTimeChange;
}
