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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.SceneMode;

/**
 * The view model for {@link SceneModePicker}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "SceneModePickerViewModel")
public class SceneModePickerViewModel {
    /**
     * Gets or sets whether the button drop-down is currently visible. This property
     * is observable. Default: false
     */
    @JsProperty
    public boolean dropDownVisible;
    /**
     * Gets or sets the the duration of scene mode transition animations in seconds.
     * A value of zero causes the scene to instantly change modes.
     */
    @JsProperty
    public double duration;
    /**
     * Gets the command to morph to 2D.
     */
    @JsProperty
    public Command morphTo2D;
    /**
     * Gets the command to morph to 3D.
     */
    @JsProperty
    public Command morphTo3D;
    /**
     * Gets the command to morph to Columbus View.
     */
    @JsProperty
    public Command morphToColumbusView;
    /**
     * Gets the scene
     */
    @JsProperty
    public Scene scene;
    /**
     * Gets or sets the current SceneMode. This property is observable.
     */
    @JsProperty
    public SceneMode sceneMode;
    /**
     * Gets the currently active tooltip. This property is observable.
     */
    @JsProperty
    public String selectedTooltip;
    /**
     * Gets the command to toggle the drop down box.
     */
    @JsProperty
    public Command toggleDropDown;
    /**
     * Gets or sets the 2D tooltip. This property is observable. Default: "2D"
     */
    @JsProperty
    public String tooltip2D;
    /**
     * Gets or sets the 3D tooltip. This property is observable. Default: "3D"
     */
    @JsProperty
    public String tooltip3D;
    /**
     * Gets or sets the Columbus View tooltip. This property is observable. Default:
     * "Columbus View"
     */
    @JsProperty
    public String tooltipColumbusView;

    /**
     * The view model for {@link SceneModePicker}.
     *
     * @param scene The Scene to morph
     */
    @JsConstructor
    public SceneModePickerViewModel(Scene scene) {
    }

    /**
     * The view model for {@link SceneModePicker}.
     *
     * @param scene    The Scene to morph
     * @param duration The duration of scene morph animations, in seconds
     */
    @JsConstructor
    public SceneModePickerViewModel(Scene scene, double duration) {
    }

    /**
     * Destroys the view model.
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
