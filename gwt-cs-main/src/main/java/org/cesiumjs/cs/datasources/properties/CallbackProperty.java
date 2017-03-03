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

package org.cesiumjs.cs.datasources.properties;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.JulianDate;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CallbackProperty")
public class CallbackProperty<T> extends Property<T> {
    @JsConstructor
    public CallbackProperty(Callback callback, boolean isConstant) {}

    /**
     * Sets the callback to be used.
     * @param callback The function to be called when the property is evaluated.
     * @param isConstant true when the callback function returns the same value every time, false if the value will change.
     */
    @JsMethod
    public native void setCallback(Callback<T> callback, boolean isConstant);

    @JsFunction
    public interface Callback<T> {
        /**
         * A function that returns the value of the property.
         * @param time The time for which to retrieve the value.
         * @param result The object to store the value into, if omitted, a new instance is created and returned.
         * @return The modified result parameter or a new instance if the result parameter was not supplied or is unsupported.
         */
        T function(JulianDate time, T result);
    }
}
