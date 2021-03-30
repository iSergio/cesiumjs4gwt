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
 * The view model for {@link ProjectionPicker}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "ProjectionPickerViewModel")
public class ProjectionPickerViewModel {
    /**
     * Gets or sets whether the button drop-down is currently visible. This property
     * is observable. Default: false
     */
    @JsProperty
    public boolean dropDownVisible;
    /**
     * Gets whether the scene is currently using an orthographic projection.
     */
    @JsProperty
    public Command isOrthographicProjection;
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
     * Gets the command to switch to orthographic projection.
     */
    @JsProperty
    public Command switchToOrthographic;
    /**
     * Gets the command to switch to a perspective projection.
     */
    @JsProperty
    public Command switchToPerspective;
    /**
     * Gets the command to toggle the drop down box.
     */
    @JsProperty
    public Command toggleDropDown;
    /**
     * Gets or sets the orthographic projection tooltip. This property is
     * observable. Default: "Orthographic Projection"
     */
    @JsProperty
    public String tooltipOrthographic;
    /**
     * Gets or sets the perspective projection tooltip. This property is observable.
     * Default: "Perspective Projection"
     */
    @JsProperty
    public String tooltipPerspective;

    /**
     * The view model for {@link ProjectionPicker}.
     *
     * @param scene The Scene to switch projections.
     */
    @JsConstructor
    public ProjectionPickerViewModel(Scene scene) {
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
