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
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Scene;

/**
 * The SceneModePicker is a single button widget for switching between scene modes; shown to the left in its expanded state.
 * Programatic switching of scene modes will be automatically reflected in the widget as long as the specified Scene is
 * used to perform the change.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "SceneModePicker")
public class SceneModePicker {
    /**
     * Gets the parent container.
     */
    @JsProperty
    public Element container;
    /**
     * Gets the view model.
     */
    @JsProperty
    public SceneModePickerViewModel viewModel;

    /**
     * The SceneModePicker is a single button widget for switching between scene modes; shown to the left in its expanded state.
     * Programatic switching of scene modes will be automatically reflected in the widget as long as the specified Scene is
     * used to perform the change.
     * @param element The DOM element or ID that will contain the widget.
     * @param scene The Scene instance to use.
     */
    @JsConstructor
    public SceneModePicker(String element, Scene scene) {}

    /**
     * The SceneModePicker is a single button widget for switching between scene modes; shown to the left in its expanded state.
     * Programatic switching of scene modes will be automatically reflected in the widget as long as the specified Scene is
     * used to perform the change.
     * @param element The DOM element or ID that will contain the widget.
     * @param scene The Scene instance to use.
     */
    @JsConstructor
    public SceneModePicker(Element element, Scene scene) {}

    /**
     * The SceneModePicker is a single button widget for switching between scene modes; shown to the left in its expanded state.
     * Programatic switching of scene modes will be automatically reflected in the widget as long as the specified Scene is
     * used to perform the change.
     * @param element The DOM element or ID that will contain the widget.
     * @param scene The Scene instance to use.
     * @param duration The time, in seconds, it takes for the scene to transition.
     */
    @JsConstructor
    public SceneModePicker(String element, Scene scene, double duration) {}

    /**
     * The SceneModePicker is a single button widget for switching between scene modes; shown to the left in its expanded state.
     * Programatic switching of scene modes will be automatically reflected in the widget as long as the specified Scene is
     * used to perform the change.
     * @param element The DOM element or ID that will contain the widget.
     * @param scene The Scene instance to use.
     * @param duration The time, in seconds, it takes for the scene to transition.
     */
    @JsConstructor
    public SceneModePicker(Element element, Scene scene, double duration) {}

    /**
     * Destroys the widget. Should be called if permanently removing the widget from layout.
     */
    @JsMethod
    public native void destroy();

    /**
     * true if the object has been destroyed, false otherwise.
     * @return true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();
}
