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

import jsinterop.annotations.*;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Event")
public class Event<T> {
    @JsProperty(name = "numberOfListeners")
    public native int numberOfListeners();
    /**
     * A generic utility class for managing subscribers for a particular event. This class is usually instantiated inside
     * of a container class and exposed as a property for others to subscribe to.
     */
    @JsConstructor
    public Event() {}

    /**
     * Registers a callback function to be executed whenever the event is raised. An optional scope can be provided to
     * serve as the this pointer in which the function will execute.
     * @param listener The function to be executed when the event is raised.
     * @return A function that will remove this event listener when invoked.
     */
    @JsMethod
    public native RemoveCallback addEventListener(T listener);

    /**
     * Registers a callback function to be executed whenever the event is raised. An optional scope can be provided to
     * serve as the this pointer in which the function will execute.
     * @param listener The function to be executed when the event is raised.
     * @param scope An optional object scope to serve as the this pointer in which the listener function will execute.
     * @return A function that will remove this event listener when invoked.
     */
    @JsMethod
    public native RemoveCallback addEventListener(T listener, Object scope);

    // TODO: I'm dont understand this moment
//    @JsMethod
//    public native void raiseEvent(*)

    /**
     * Unregisters a previously registered callback.
     * @param listener he function to be unregistered.
     * @return true if the listener was removed; false if the listener and scope are not registered with the event.
     */
    @JsMethod
    public native boolean removeEventListener(T listener);

    /**
     * Unregisters a previously registered callback.
     * @param listener he function to be unregistered.
     * @param scope The scope that was originally passed to addEventListener.
     * @return true if the listener was removed; false if the listener and scope are not registered with the event.
     */
    @JsMethod
    public native boolean removeEventListener(T listener, Object scope);

    /**
     * Universal callback listener, supports array params
     */
    @JsFunction
    public interface Listener {
        void function(Object ...o);
    }

    /**
     * A function that removes a listener.
     */
    @JsFunction
    public interface RemoveCallback {
        void function();
    }
}
