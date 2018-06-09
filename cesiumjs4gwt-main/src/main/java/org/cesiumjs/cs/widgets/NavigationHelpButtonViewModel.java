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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The view model for {@link NavigationHelpButton}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "NavigationHelpButtonViewModel")
public class NavigationHelpButtonViewModel {
    /**
     * Gets the Command that is executed when the button is clicked.
     */
    @JsProperty
    public Command command;
    /**
     * Gets the Command that is executed when the mouse instructions should be shown.
     */
    @JsProperty
    public Command showClick;
    /**
     * Gets or sets whether the instructions are currently shown. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean showInstructions;
    /**
     * Gets the Command that is executed when the touch instructions should be shown.
     */
    @JsProperty
    public Command showTouch;
    /**
     * Gets or sets the tooltip. This property is observable.
     */
    @JsProperty
    public String tooltip;

    /**
     * The view model for {@link NavigationHelpButton}.
     */
    @JsConstructor
    public NavigationHelpButtonViewModel() {}
}
