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

package org.cesiumjs.cs.core.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The type of geocoding to be performed by a
 * {@link org.cesiumjs.cs.core.GeocoderService}.
 * 
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "GeocodeType")
public class GeocodeType {
  /**
   * Perform an auto-complete using partial input, typically reserved for
   * providing possible results as a user is typing.
   */
  @JsProperty(name = "AUTOCOMPLETE")
  public static native Number AUTOCOMPLETE();

  /**
   * Perform a search where the input is considered complete.
   */
  @JsProperty(name = "SEARCH")
  public static native Number SEARCH();

  @JsConstructor
  private GeocodeType() {
  }
}
