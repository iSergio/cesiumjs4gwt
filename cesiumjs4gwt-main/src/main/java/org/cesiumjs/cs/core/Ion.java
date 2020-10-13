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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Default settings for accessing the Cesium Ion API.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "Ion")
public class Ion {
  /**
   * Gets or sets the default Cesium ion access token.
   */
  @JsProperty
  public static String defaultAccessToken;
  /**
   * Gets or sets the default Cesium ion server. Default: https://api.cesium.com
   */
  @JsProperty
  public static String defaultServer;

  @JsConstructor
  private Ion() {
  }
}
