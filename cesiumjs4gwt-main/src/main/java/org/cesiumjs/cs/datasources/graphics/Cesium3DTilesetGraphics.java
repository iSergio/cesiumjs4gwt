/*
 * Copyright 2020 iSerge.
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

package org.cesiumjs.cs.datasources.graphics;

import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.datasources.graphics.options.Cesium3DTilesetGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.Property;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "Cesium", name = "Cesium3DTilesetGraphics")
public class Cesium3DTilesetGraphics {
  /**
   * Gets the event that is raised whenever a property or sub-property is changed
   * or modified.
   */
  @JsProperty(name = "definitionChanged")
  public native Event definitionChanged();

  /**
   * Gets or sets the maximum screen space error used to drive level of detail
   * refinement.
   */
  @JsProperty
  public Property maximumScreenSpaceError;
  /**
   * Gets or sets the boolean Property specifying the visibility of the model.
   * Default: true
   */
  @JsProperty
  public boolean show;
  /**
   * Gets or sets the string Property specifying the URI of the glTF asset.
   */
  @JsProperty
  public Property uri;

  @JsConstructor
  public Cesium3DTilesetGraphics() {
  }

  @JsConstructor
  public Cesium3DTilesetGraphics(Cesium3DTilesetGraphicsOptions options) {
  }

  /**
   * Duplicates this instance.
   * 
   * @return The modified result parameter or a new instance if one was not
   *         provided.
   */
  @JsMethod
  public native Cesium3DTilesetGraphics clone();

  /**
   * Duplicates this instance.
   * 
   * @param result The object onto which to store the result.
   * @return The modified result parameter or a new instance if one was not
   *         provided.
   */
  @JsMethod
  public native Cesium3DTilesetGraphics clone(Cesium3DTilesetGraphics result);

  /**
   * Assigns each unassigned property on this object to the value of the same
   * property on the provided source object.
   * 
   * @param source The object to be merged into this object.
   */
  @JsMethod
  public native void megre(Cesium3DTilesetGraphics source);
}