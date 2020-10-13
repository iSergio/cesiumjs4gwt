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

import org.cesiumjs.cs.scene.Globe;
import org.cesiumjs.cs.widgets.options.BaseLayerPickerViewModelOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The view model for {@link BaseLayerPicker}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "BaseLayerPickerViewModel")
public class BaseLayerPickerViewModel {
  /**
   * Gets the button background image. This property is observable.
   */
  @JsProperty
  public String buttonImageUrl;
  /**
   * Gets the button tooltip. This property is observable.
   */
  @JsProperty
  public String buttonTooltip;
  /**
   * Gets or sets whether the imagery selection drop-down is currently visible.
   * Default: false
   */
  @JsProperty
  public boolean dropDownVisible;
  /**
   * Gets the globe.
   */
  @JsProperty
  public Globe globe;
  /**
   * Gets or sets an array of ProviderViewModel instances available for imagery
   * selection. This property is observable.
   */
  @JsProperty
  public ProviderViewModel[] imageryProviderViewModels;
  /**
   * Gets or sets the currently selected imagery. This property is observable.
   * Default: undefined
   */
  @JsProperty
  public ProviderViewModel selectedImagery;
  /**
   * Gets or sets the currently selected terrain. This property is observable.
   * Default: undefined
   */
  @JsProperty
  public ProviderViewModel selectedTerrain;
  /**
   * Gets or sets an array of ProviderViewModel instances available for terrain
   * selection. This property is observable.
   */
  @JsProperty
  public ProviderViewModel[] terrainProviderViewModels;
  /**
   * Gets the command to toggle the visibility of the drop down.
   */
  @JsProperty
  public Command toggleDropDown;

  /**
   * The view model for {@link BaseLayerPicker}.
   * 
   * @param options object {@link BaseLayerPickerViewModelOptions}
   */
  @JsConstructor
  public BaseLayerPickerViewModel(BaseLayerPickerViewModelOptions options) {
  }
}
