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

import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A material Property that maps to PolylineArrow
 * {@link org.cesiumjs.cs.scene.Material} uniforms.
 */
@JsType(isNative = true, name = "PolylineArrowMaterialProperty", namespace = "Cesium")
public class PolylineArrowMaterialProperty extends MaterialProperty {

  /**
   * Gets or sets the {@link org.cesiumjs.cs.core.Color} {@link Property}.
   */
  @JsProperty
  public Property color;

  /**
   * A {@link MaterialProperty} that maps to PolylineArrow
   * {@link org.cesiumjs.cs.scene.Material} uniforms.
   * 
   * @param color - The {@link org.cesiumjs.cs.core.Color} Property to be used.
   *              Optional.
   */
  @JsConstructor
  public PolylineArrowMaterialProperty(Property color) {
  }

}
