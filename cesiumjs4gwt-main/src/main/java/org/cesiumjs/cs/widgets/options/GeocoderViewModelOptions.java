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

package org.cesiumjs.cs.widgets.options;

import org.cesiumjs.cs.core.GeocoderService;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.widgets.GeocoderViewModel;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link org.cesiumjs.cs.widgets.GeocoderViewModel}
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeocoderViewModelOptions {
  /**
   * The Scene instance to use.
   */
  @JsProperty
  public Scene scene;
  /**
   * Geocoder services to use for geocoding queries. If more than one are
   * supplied, suggestions will be gathered for the geocoders that support it, and
   * if no suggestion is selected the result from the first geocoder service wil
   * be used.
   */
  @JsProperty
  public GeocoderService[] geocoderServices;
  /**
   * The duration of the camera flight to an entered location, in seconds.
   */
  @JsProperty
  public double flightDuration;
  /**
   * A callback function that is called after a successful geocode. If not
   * supplied, the default behavior is to fly the camera to the result
   * destination.
   */
  @JsProperty
  public GeocoderViewModel.DestinationFoundFunction destinationFound;

  @JsConstructor
  private GeocoderViewModelOptions() {
  }

  /**
   * Fast create instance of {@link GeocoderViewModelOptions} by mandatory params
   * 
   * @param scene The Scene instance to use.
   * @return {@link GeocoderViewModelOptions} instance.
   */
  @JsOverlay
  public static GeocoderViewModelOptions create(Scene scene) {
    GeocoderViewModelOptions options = new GeocoderViewModelOptions();
    options.scene = scene;
    return options;
  }
}
