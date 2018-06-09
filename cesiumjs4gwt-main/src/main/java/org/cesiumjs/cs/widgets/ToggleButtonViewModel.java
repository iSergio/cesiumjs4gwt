/*
 * Copyright 2017 iserge.
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

import jsinterop.annotations.JsType;
import net.sourceforge.htmlunit.corejs.javascript.annotations.JSConstructor;
import org.cesiumjs.cs.widgets.options.ToggleButtonViewModelOptions;

/**
 * A view model which exposes the properties of a toggle button.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ToggleButtonViewModel")
public class ToggleButtonViewModel {
    /**
     * Gets the command which will be executed when the button is toggled.
     */
    public Command command;

    /**
     * Gets or sets whether the button is currently toggled. This property is observable.
     * Default: false
     */
    public boolean toggled;

    /**
     * Gets or sets the button's tooltip. This property is observable.
     * Default: ''
     */
    public String tooltip;

    /**
     * A view model which exposes the properties of a toggle button.
     * @param command The command which will be executed when the button is toggled.
     */
    @JSConstructor
    public ToggleButtonViewModel(Command command) {}

    /**
     * A view model which exposes the properties of a toggle button.
     * @param command The command which will be executed when the button is toggled.
     * @param options options object
     */
    @JSConstructor
    public ToggleButtonViewModel(Command command, ToggleButtonViewModelOptions options) {}
}
