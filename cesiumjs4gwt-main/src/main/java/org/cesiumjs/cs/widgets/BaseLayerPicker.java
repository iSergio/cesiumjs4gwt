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

import org.cesiumjs.cs.widgets.options.BaseLayerPickerViewModelOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The BaseLayerPicker is a single button widget that displays a panel of
 * available imagery and terrain providers. When imagery is selected, the
 * corresponding imagery layer is created and inserted as the base layer of the
 * imagery collection; removing the existing base. When terrain is selected, it
 * replaces the current terrain provider. Each item in the available providers
 * list contains a name, a representative icon, and a tooltip to display more
 * information when hovered. The list is initially empty, and must be configured
 * before use, as illustrated in the below example.
 *
 * @see org.cesiumjs.cs.scene.providers.ImageryProvider
 * @see org.cesiumjs.cs.core.providers.TerrainProvider
 * @see org.cesiumjs.cs.collections.ImageryLayerCollection
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "BaseLayerPicker")
public class BaseLayerPicker {
  /**
   * Gets the parent container.
   */
  @JsProperty
  public Element container;
  /**
   * Gets the view model.
   */
  @JsProperty
  public BaseLayerPickerViewModel viewModel;

  /**
   * Constructor of {@link BaseLayerPicker}
   * 
   * @param container The parent HTML container node or ID for this widget.
   * @param options   object of {@link BaseLayerPickerViewModelOptions}.
   */
  @JsConstructor
  public BaseLayerPicker(Element container, BaseLayerPickerViewModelOptions options) {
  }

  /**
   * Constructor of {@link BaseLayerPicker}
   * 
   * @param container The parent HTML container node or ID for this widget.
   * @param options   object of {@link BaseLayerPickerViewModelOptions}.
   */
  @JsConstructor
  public BaseLayerPicker(String container, BaseLayerPickerViewModelOptions options) {
  }

  /**
   * Destroys the widget. Should be called if permanently removing the widget from
   * layout.
   */
  @JsMethod
  public native void destroy();

  /**
   *
   * @return true if the object has been destroyed, false otherwise.
   */
  @JsMethod
  public native boolean isDestroyed();
}
