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

import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.scene.Camera;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class KmlDataSourceOptions {
  /**
   * The camera that is used for viewRefreshModes and sending camera properties to
   * network links.
   */
  @JsProperty
  public Camera camera;
  /**
   * The canvas that is used for sending viewer properties to network links.
   */
  @JsProperty
  public CanvasElement canvas;
  /**
   * The global ellipsoid used for geographical calculations.
   *
   */
  @JsProperty
  public Ellipsoid ellipsoid;

  /**
   * Options for {@link org.cesiumjs.cs.datasources.KmlDataSource}
   */
  @JsConstructor
  protected KmlDataSourceOptions() {
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
  public static KmlDataSourceOptions create(Camera camera, CanvasElement canvas) {
    KmlDataSourceOptions options = new KmlDataSourceOptions();
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
  public static KmlDataSourceOptions create(Camera camera, CanvasElement canvas, Ellipsoid ellipsoid) {
    KmlDataSourceOptions options = new KmlDataSourceOptions();
    options.camera = camera;
    options.canvas = canvas;
    options.ellipsoid = ellipsoid;
    return options;
  }
}
