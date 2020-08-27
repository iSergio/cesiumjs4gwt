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

package org.cesiumjs.cs.core;

import org.cesiumjs.cs.js.JsObject;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The request scheduler is used to track and constrain the number of active requests in order to 
 * prioritize incoming requests. The ability to retain control over the number of requests in 
 * CesiumJS is important because due to events such as changes in the camera position, 
 * a lot of new requests may be generated and a lot of in-flight requests may become redundant. 
 * The request scheduler manually constrains the number of requests so that newer requests wait 
 * in a shorter queue and don't have to compete for bandwidth with requests that have expired.
 */
@JsType(isNative = true, namespace = "Cesium", name = "RequestScheduler")
public class RequestScheduler {
  /**
   * The maximum number of simultaneous active requests. Un-throttled requests do not observe 
   * this limit.
   * Default: 50
   */
  @JsProperty
  public static Number maximumRequests;

  /**
   * The maximum number of simultaneous active requests per server. Un-throttled requests or 
   * servers specifically listed in requestsByServer do not observe this limit.
   * Default Value:  6
   */
  @JsProperty
  public static Number maximumRequestsPerServer;

  /**
   * A per server key list of overrides to use for throttling instead of maximumRequestsPerServer
   */
  @JsProperty
  public static JsObject requestsByServer;

  /**
   * Specifies if the request scheduler should throttle incoming requests, or let the browser 
   * queue requests under its control.
   * Default:  true
   */
  @JsProperty
  public static boolean throttleRequests;
}