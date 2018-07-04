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
import org.cesiumjs.cs.scene.Scene;

/**
 * The view model for {@link HomeButton}
 */
@JsType(isNative = true, namespace = "Cesium", name = "HomeButtonViewModel")
public class HomeButtonViewModel {

    /**
     * Gets the {@link Command} that is executed when the button is clicked.
     */
    @JsProperty
    public Command command;

    /**
     * Gets or sets the duration of the camera flight in seconds.  A value of zero causes the camera to instantly
     * switch to home view. The duration will be computed based on the distance when undefined.
     */
    @JsProperty
    public Number duration;

    /**
     * Gets the scene to control.
     */
    @JsProperty
    public Scene scene;

    /**
     * Gets or sets the tooltip.  This property is observable.
     */
    @JsProperty
    public String tooltip;

    /**
     * The view model for {@link HomeButton}.
     * @param scene The scene instance to use.
     * @param duration The duration of the camera flight in seconds.  Optional.
     */
    @JsConstructor
    public HomeButtonViewModel(Scene scene, Number duration) {}

}
