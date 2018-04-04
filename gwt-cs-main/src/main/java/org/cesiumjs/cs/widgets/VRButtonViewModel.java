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
 * The view model for {@link VRButton}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "VRButtonViewModel")
public class VRButtonViewModel {
    /**
     * Gets the Command to toggle VR mode.
     */
    @JsProperty
    public Command command;
    /**
     * Gets or sets whether or not VR functionality should be enabled.
     * @see Fullscreen.enabled
     */
    @JsProperty
    public boolean isVREnabled;
    /**
     * Gets whether or not VR mode is active.
     */
    @JsProperty
    public boolean isVRMode;
    /**
     * Gets the tooltip. This property is observable.
     */
    @JsProperty
    public String tooltip;
    /**
     * Gets or sets the HTML element to place into VR mode when the corresponding button is pressed.
     */
    @JsProperty
    public Element vrElement;

    /**
     * The view model for {@link VRButton}.
     * @param scene The scene.
     */
    @JsConstructor
    public VRButtonViewModel(Scene scene) {}

    /**
     * The view model for {@link VRButton}.
     * @param scene The scene.
     * @param vrElement The id to be placed into VR mode.
     */
    @JsConstructor
    public VRButtonViewModel(Scene scene, String vrElement) {}

    /**
     * The view model for {@link VRButton}.
     * @param scene The scene.
     * @param vrElement The element to be placed into VR mode.
     */
    @JsConstructor
    public VRButtonViewModel(Scene scene, Element vrElement) {}

    /**
     * Destroys the view model.
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
