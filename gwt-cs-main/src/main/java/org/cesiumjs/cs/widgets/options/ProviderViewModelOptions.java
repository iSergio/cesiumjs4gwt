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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.widgets.Command;
import org.cesiumjs.cs.widgets.ProviderViewModel;

/**
 * Options for {@link org.cesiumjs.cs.widgets.ProviderViewModel}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ProviderViewModelOptions {
    /**
     * The name of the layer.
     */
    @JsProperty
    public String name;
    /**
     * The tooltip to show when the item is moused over.
     */
    @JsProperty
    public String tooltip;
    /**
     * An icon representing the layer.
     */
    @JsProperty
    public String iconUrl;
    /**
     * A function or Command that creates one or more providers which will be added to the globe when this item is selected.
     * @see ProviderViewModel.ImageryProviderCreationFunction
     */
    @JsProperty(name = "creationFunction")
    public ProviderViewModel.ImageryProviderCreationFunction imageryProviderCreationFunction;
    /**
     * A function or Command that creates one or more providers which will be added to the globe when this item is selected.
     * @see ProviderViewModel.TerrainProviderCreationFunction
     */
    @JsProperty(name = "creationFunction")
    public ProviderViewModel.TerrainProviderCreationFunction terrainProviderCreationFunction;
    /**
     * A function or Command that creates one or more providers which will be added to the globe when this item is selected.
     */
    @JsProperty
    public Command createFunctionCommand;

    @JsConstructor
    public ProviderViewModelOptions() {}
}
