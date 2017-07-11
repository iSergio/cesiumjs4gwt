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

package org.cesiumjs.cs.collections.options;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public abstract class FromIso8601OptionsAbstract {
    /**
     * if start time is included in the interval, false otherwise.
     * Default: true
     */
    @JsProperty
    public boolean isStartIncluded;
    /**
     * if stop time is included in the interval, false otherwise.
     * Default: true
     */
    @JsProperty
    public boolean isStopIncluded;
    /**
     * if you want to add a interval from Iso8601.MINIMUM_VALUE to start time, false otherwise.
     * Default: false
     */
    @JsProperty
    public boolean leadingInterval;
    /**
     * if you want to add a interval from stop time to Iso8601.MAXIMUM_VALUE, false otherwise.
     * Default: false
     */
    @JsProperty
    public boolean trailingInterval;
    /**
     * A function that will be return the data that is called with each interval before it is added to the collection.
     * If unspecified, the data will be the index in the collection.
     */
    @JsProperty
    public DataCallback dataCallback;

    @JsFunction
    public interface DataCallback {
        void function();
    }
}
