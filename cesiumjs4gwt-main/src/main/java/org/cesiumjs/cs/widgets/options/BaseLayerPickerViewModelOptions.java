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

import jsinterop.annotations.*;
import org.cesiumjs.cs.scene.Globe;
import org.cesiumjs.cs.widgets.ProviderViewModel;

/**
 * Options for {@link org.cesiumjs.cs.widgets.BaseLayerPicker}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class BaseLayerPickerViewModelOptions {
    /**
     * The Globe to use.
     */
    @JsProperty
    public Globe globe;
    /**
     * The array of ProviderViewModel instances to use for imagery.
     */
    @JsProperty
    public ProviderViewModel[] imageryProviderViewModels;
    /**
     * The view model for the current base imagery layer, if not supplied the first available imagery layer is used.
     */
    @JsProperty
    public ProviderViewModel selectedImageryProviderViewModel;
    /**
     * The array of ProviderViewModel instances to use for terrain.
     */
    @JsProperty
    public ProviderViewModel[] terrainProviderViewModels;
    /**
     * The view model for the current base terrain layer, if not supplied the first available terrain layer is used.
     */
    @JsProperty
    public ProviderViewModel selectedTerrainProviderViewModel;

    @JsConstructor
    private BaseLayerPickerViewModelOptions() {}

    /**
     * Create instance of {@link BaseLayerPickerViewModelOptions}.
     * @param globe The Globe to use
     * @return instance of {@link BaseLayerPickerViewModelOptions}.
     */
    @JsOverlay
    public static final BaseLayerPickerViewModelOptions create(Globe globe) {
        BaseLayerPickerViewModelOptions options = new BaseLayerPickerViewModelOptions();
        options.globe = globe;
        return options;
    }
}
