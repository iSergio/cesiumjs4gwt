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

package org.cesiumjs.cs.widgets;

import com.google.gwt.dom.client.Element;

import org.cesiumjs.cs.scene.Scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A single button widget for toggling vr mode.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "VRButton")
public class VRButton {
  /**
   * Gets the parent container.
   */
  @JsProperty
  public Element container;
  /**
   * Gets the view model.
   */
  @JsProperty
  public VRButtonViewModel viewModel;

  /**
   * A single button widget for toggling vr mode.
   * 
   * @param container The ID that will contain the widget.
   * @param scene     The scene.
   */
  @JsConstructor
  public VRButton(String container, Scene scene) {
  }

  /**
   * A single button widget for toggling vr mode.
   * 
   * @param container The ID that will contain the widget.
   * @param scene     The scene.
   * @param vrElement The element or id to be placed into vr mode.
   */
  @JsConstructor
  public VRButton(String container, Scene scene, Element vrElement) {
  }

  /**
   * A single button widget for toggling vr mode.
   * 
   * @param container The DOM element that will contain the widget.
   * @param scene     The scene.
   */
  @JsConstructor
  public VRButton(Element container, Scene scene) {
  }

  /**
   * A single button widget for toggling vr mode.
   * 
   * @param container The DOM element that will contain the widget.
   * @param scene     The scene.
   * @param vrElement The element or id to be placed into vr mode.
   */
  @JsConstructor
  public VRButton(Element container, Scene scene, Element vrElement) {
  }

  /**
   * Destroys the widget. Should be called if permanently removing the widget from
   * layout.
   */
  @JsMethod
  public native void destroy();

  /**
   * true if the object has been destroyed, false otherwise.
   * 
   * @return true if the object has been destroyed, false otherwise.
   */
  @JsMethod
  public native boolean isDestroyed();
}
