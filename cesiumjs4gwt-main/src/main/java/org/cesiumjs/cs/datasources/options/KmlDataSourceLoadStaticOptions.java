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

package org.cesiumjs.cs.datasources.options;

import com.google.gwt.dom.client.CanvasElement;

import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.datasources.KmlDataSource;
import org.cesiumjs.cs.scene.Camera;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link KmlDataSource}
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class KmlDataSourceLoadStaticOptions extends KmlDataSourceOptions {
  /**
   * Overrides the url to use for resolving relative links and other KML network
   * features.
   */
  @JsProperty
  public String sourceUri;
  /**
   * true if we want the geometry features (Polygons, LineStrings and LinearRings)
   * clamped to the ground. If true, lines will use corridors so use
   * Entity.corridor instead of Entity.polyline. Default: true
   */
  @JsProperty
  public boolean clampToGround;
  /**
   * A credit for the data source, which is displayed on the canvas.
   */
  @JsProperty
  public Credit credit;
  /**
   * A credit for the data source, which is displayed on the canvas.
   */
  @JsProperty(name = "credit")
  public String creditStr;

  /**
   * Options for {@link KmlDataSource}
   */
  @JsConstructor
  protected KmlDataSourceLoadStaticOptions() {
  }

  /**
   * Create instance options for {@link org.cesiumjs.cs.datasources.KmlDataSource}
   * 
   * @param camera The camera that is used for viewRefreshModes and sending camera
   *               properties to network links.
   * @param canvas The canvas that is used for sending viewer properties to
   *               network links.
   * @return instance options for
   *         {@link org.cesiumjs.cs.datasources.KmlDataSource}
   */
  @JsOverlay
  public static KmlDataSourceLoadStaticOptions create(Camera camera, CanvasElement canvas) {
    KmlDataSourceLoadStaticOptions options = new KmlDataSourceLoadStaticOptions();
    options.camera = camera;
    options.canvas = canvas;
    return options;
  }

  /**
   * Create instance options for {@link org.cesiumjs.cs.datasources.KmlDataSource}
   * 
   * @param camera The camera that is used for viewRefreshModes and sending camera
   *               properties to network links.
   * @param canvas The canvas that is used for sending viewer properties to
   *               network links.
   * @return instance options for
   *         {@link org.cesiumjs.cs.datasources.KmlDataSource}
   */
  @JsOverlay
  public static KmlDataSourceLoadStaticOptions create(Camera camera, CanvasElement canvas, Ellipsoid ellipsoid) {
    KmlDataSourceLoadStaticOptions options = new KmlDataSourceLoadStaticOptions();
    options.camera = camera;
    options.canvas = canvas;
    options.ellipsoid = ellipsoid;
    return options;
  }
}
