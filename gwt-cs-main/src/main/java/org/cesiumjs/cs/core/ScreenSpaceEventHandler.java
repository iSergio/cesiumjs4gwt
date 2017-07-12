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

package org.cesiumjs.cs.core;

import com.google.gwt.dom.client.CanvasElement;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.enums.KeyboardEventModifier;
import org.cesiumjs.cs.core.enums.ScreenSpaceEventType;
import org.cesiumjs.cs.promise.Function;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ScreenSpaceEventHandler")
public class ScreenSpaceEventHandler {
    /**
     * The amount of time, in milliseconds, that mouse events will be disabled after receiving any touch events,
     * such that any emulated mouse events will be ignored.
     * Default: 800
     */
    @JsProperty
    public static int mouseEmulationIgnoreMilliseconds;

    /**
     * Handles user input events. Custom functions can be added to be executed on when the user enters input.
     * @param element The element to add events to. Default: document
     */
    @JsConstructor
    public ScreenSpaceEventHandler(CanvasElement element) {}

    //TODO: Example
    /**
     * Removes listeners held by this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed()
     */
    public native void destroy();

    /**
     * Returns the function to be executed on an input event.
     * @param type The {@link ScreenSpaceEventType} of input event.
     * @return Returns the function to be executed on an input event.
     * @see #setInputAction
     * @see #removeInputAction
     */
    public native Function getInputAction(Number type);

    /**
     * Returns the function to be executed on an input event.
     * @param type The {@link ScreenSpaceEventType} of input event.
     * @param modifier A {@link KeyboardEventModifier} key that is held when a type event occurs.
     * @return Returns the function to be executed on an input event.
     * @see #setInputAction
     * @see #removeInputAction
     */
    public native Function getInputAction(Integer type, Integer modifier);

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    public native boolean isDestroyed();

    /**
     * Removes the function to be executed on an input event.
     * @param type The {@link ScreenSpaceEventType} of input event.
     * @see #setInputAction
     */
    public native void removeInputAction(Number type);

    /**
     * Removes the function to be executed on an input event.
     * @param type The {@link ScreenSpaceEventType} of input event.
     * @param modifier A {@link KeyboardEventModifier} key that is held when a type event occurs.
     * @see  #getInputAction
     * @see #setInputAction
     */
    public native void removeInputAction(Number type, Number modifier);

    /**
     * Set a function to be executed on an input event.
     * @param action Function to be executed when the input event occurs.
     * @param type The {@link ScreenSpaceEventType} of input event.
     * @see #getInputAction
     * @see #removeInputAction
     */
    public native void setInputAction(Listener action, Number type);

    /**
     * Set a function to be executed on an input event.
     * @param action Function to be executed when the input event occurs.
     * @param type The {@link ScreenSpaceEventType} of input event.
     * @param modifier A {@link KeyboardEventModifier} key that is held when a type event occurs.
     * @see #getInputAction
     * @see #removeInputAction
     */
    public native void setInputAction(Listener action, Number type, Number modifier);

    @JsFunction
    public interface Listener<T> {
        void function(T event);
    }
}
