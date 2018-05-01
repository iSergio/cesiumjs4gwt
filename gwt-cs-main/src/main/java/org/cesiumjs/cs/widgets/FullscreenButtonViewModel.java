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
import org.cesiumjs.cs.core.Fullscreen;

/**
 * The view model for {@link FullscreenButton}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "FullscreenButtonViewModel")
public class FullscreenButtonViewModel {
    /**
     * Gets the Command to toggle fullscreen mode.
     */
    @JsProperty
    public Command command;
    /**
     * Gets or sets the HTML element to place into fullscreen mode when the corresponding button is pressed.
     */
    @JsProperty
    public Element fullscreenElement;
    /**
     * Gets whether or not fullscreen mode is active. This property is observable.
     */
    @JsProperty
    public boolean isFullscreen;
    /**
     * Gets or sets whether or not fullscreen functionality should be enabled. This property is observable.
     * @see Fullscreen#enabled()
     */
    @JsProperty
    public boolean isFullscreenEnabled;
    /**
     * Gets the tooltip. This property is observable.
     */
    @JsProperty
    public String tooltip;

    /**
     * The view model for {@link FullscreenButton}.
     */
    @JsConstructor
    public FullscreenButtonViewModel() {}

    /**
     * The view model for {@link FullscreenButton}.
     * @param fullscreenElement The element or id to be placed into fullscreen mode.
     */
    @JsConstructor
    public FullscreenButtonViewModel(String fullscreenElement) {}

    /**
     * The view model for {@link FullscreenButton}.
     * @param fullscreenElement The element or id to be placed into fullscreen mode.
     */
    @JsConstructor
    public FullscreenButtonViewModel(Element fullscreenElement) {}

    /**
     * Destroys the view model. Should be called to properly clean up the view model when it is no longer needed.
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
