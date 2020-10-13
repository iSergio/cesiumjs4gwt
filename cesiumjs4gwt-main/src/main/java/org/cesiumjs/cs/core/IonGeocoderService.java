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

import org.cesiumjs.cs.core.enums.GeocodeType;
import org.cesiumjs.cs.core.options.IonGeocoderServiceOptions;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.Scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;

/**
 * Provides geocoding through Cesium ion.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "IonGeocoderService")
public class IonGeocoderService implements GeocoderService {
  @JsConstructor
  private IonGeocoderService() {
  }

  /**
   * Provides geocoding through Cesium ion.
   * 
   * @param options {@link IonGeocoderServiceOptions} object.
   */
  @JsConstructor
  public IonGeocoderService(IonGeocoderServiceOptions options) {
  }

  /**
   * Fast create {@link IonGeocoderService} instance by Scene
   * 
   * @param scene The scene
   * @return {@link IonGeocoderService} instance;
   */
  @JsOverlay
  public static IonGeocoderService create(Scene scene) {
    return new IonGeocoderService(IonGeocoderServiceOptions.create(scene));
  }

  /**
   * Process query request to service
   * 
   * @param query The query to be sent to the geocoder service
   * @return query result
   */
  @JsMethod
  public native Promise<GeocoderResult[], Void> geocode(String query);

  /**
   * Process query request to service
   * 
   * @param query The query to be sent to the geocoder service
   * @param type  The type of geocode to perform.
   * @return query result
   */
  @JsMethod
  public native Promise<GeocoderResult[], Void> geocode(String query, GeocodeType type);
}
