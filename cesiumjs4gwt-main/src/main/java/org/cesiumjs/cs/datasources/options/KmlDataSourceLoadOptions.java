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

import org.cesiumjs.cs.core.Ellipsoid;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for
 * {@link org.cesiumjs.cs.datasources.KmlDataSource#load(String, KmlDataSourceLoadOptions)}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class KmlDataSourceLoadOptions {
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
   * The global ellipsoid used for geographical calculations.
   *
   */
  @JsProperty
  public Ellipsoid ellipsoid;

  /**
   * Options for
   * {@link org.cesiumjs.cs.datasources.KmlDataSource#load(String, KmlDataSourceLoadOptions)}.
   */
  @JsConstructor
  public KmlDataSourceLoadOptions() {
  }
}
