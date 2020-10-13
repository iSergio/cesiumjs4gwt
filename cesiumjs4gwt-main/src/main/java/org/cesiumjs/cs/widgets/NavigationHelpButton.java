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

import org.cesiumjs.cs.widgets.options.NavigationHelpButtonOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The NavigationHelpButton is a single button widget for displaying
 * instructions for navigating the globe with the mouse.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "NavigationHelpButton")
public class NavigationHelpButton {
  /**
   * Gets the parent container.
   */
  @JsProperty
  public Element container;
  /**
   * Gets the view model.
   */
  @JsProperty
  public NavigationHelpButtonViewModel viewModel;

  @JsConstructor
  private NavigationHelpButton() {
  }

  /**
   * The NavigationHelpButton is a single button widget for displaying
   * instructions for navigating the globe with the mouse.
   * 
   * @param options object {@link NavigationHelpButtonOptions}
   */
  @JsConstructor
  public NavigationHelpButton(NavigationHelpButtonOptions options) {
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
