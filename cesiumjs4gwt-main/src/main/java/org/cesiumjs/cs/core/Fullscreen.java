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

import org.cesiumjs.cs.js.HMDVRDevice;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Browser-independent functions for working with the standard fullscreen API.
 * See:
 * <a href="http://dvcs.w3.org/hg/fullscreen/raw-file/tip/Overview.html">W3C
 * Fullscreen Living Specification</a>
 * 
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "Fullscreen")
public class Fullscreen {
  /**
   * The name of the event on the document that is fired when fullscreen is
   * entered or exited. This event name is intended for use with addEventListener.
   * In your event handler, to determine if the browser is in fullscreen mode or
   * not, use Fullscreen#fullscreen.
   */
  @JsProperty(name = "changeEventName")
  public static native String changeEventName();

  /**
   * The element that is currently fullscreen, if any. To simply check if the
   * browser is in fullscreen mode or not, use Fullscreen#fullscreen.
   */
  @JsProperty(name = "element")
  public static native Object element();

  /**
   * Determine whether the browser will allow an element to be made fullscreen, or
   * not. For example, by default, iframes cannot go fullscreen unless the
   * containing page adds an "allowfullscreen" attribute (or prefixed equivalent).
   */
  @JsProperty(name = "enabled")
  public static native boolean enabled();

  /**
   * The name of the event that is fired when a fullscreen error occurs. This
   * event name is intended for use with addEventListener.
   */
  @JsProperty(name = "errorEventName")
  public static native String errorEventName();

  /**
   * Determines if the browser is currently in fullscreen mode.
   */
  @JsProperty(name = "fullscreen")
  public static native boolean fullscreen();

  @JsConstructor
  private Fullscreen() {
  }

  /**
   * Asynchronously exits fullscreen mode. If the browser is not currently in
   * fullscreen, or if fullscreen mode is not supported by the browser, does
   * nothing.
   */
  @JsMethod
  public static native void exitFullscreen();

  // TODO: example usage
  /**
   * Asynchronously requests the browser to enter fullscreen mode on the given
   * element. If fullscreen mode is not supported by the browser, does nothing.
   * 
   * @param element The HTML element which will be placed into fullscreen mode.
   */
  @JsMethod
  public static native void requestFullscreen(Object element);

  // TODO: example usage
  /**
   * Asynchronously requests the browser to enter fullscreen mode on the given
   * element. If fullscreen mode is not supported by the browser, does nothing.
   * 
   * @param element  The HTML element which will be placed into fullscreen mode.
   * @param vrDevice The VR device.
   */
  @JsMethod
  public static native void requestFullscreen(Object element, HMDVRDevice vrDevice);

  /**
   * Detects whether the browser supports the standard fullscreen API.
   * 
   * @return true if the browser supports the standard fullscreen API, false
   *         otherwise.
   */
  @JsMethod
  public static native boolean supportsFullscreen();
}
