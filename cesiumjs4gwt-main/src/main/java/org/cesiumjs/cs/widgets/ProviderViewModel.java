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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.scene.providers.ImageryProvider;
import org.cesiumjs.cs.widgets.options.ProviderViewModelOptions;

/**
 * A view model that represents each item in the {@link BaseLayerPicker}.
 * @see BaseLayerPicker
 * @see ImageryProvider
 * @see TerrainProvider
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ProviderViewModel")
public class ProviderViewModel {
    /**
     * Gets the category
     */
    @JsProperty(name = "category")
    public native String category();
    /**
     * Gets the Command that creates one or more providers which will be added to the globe when this item is selected.
     */
    @JsProperty(name = "creationCommand")
    public native Command creationCommand();
    /**
     * Gets the icon. This property is observable.
     */
    @JsProperty
    public String iconUrl;
    /**
     * Gets the display name. This property is observable.
     */
    @JsProperty
    public String name;
    /**
     * Gets the tooltip. This property is observable.
     */
    @JsProperty
    public String tooltip;

    /**
     * Constructor of a view model that represents each item in the {@link BaseLayerPicker}.
     * @param options {@link ProviderViewModelOptions} object.
     */
    @JsConstructor
    public ProviderViewModel(ProviderViewModelOptions options) {}

    /**
     * A function which creates one or more providers.
     */
    @JsFunction
    public interface ImageryProviderCreationFunction {
        /**
         * A function which creates one or more providers.
         * @return The ImageryProvider array of providers, to be added to the globe.
         */
        ImageryProvider function();
    }

    @JsFunction
    public interface TerrainProviderCreationFunction {
        /**
         * A function which creates one or more providers.
         * @return The TerrainProvider array of providers, to be added to the globe.
         */
        TerrainProvider function();
    }
}
