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

package org.cesiumjs.cs.collections;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Collection")
public class Collection<T> {
    /**
     * Returns the number of elements in this collection.
     * This is commonly used with Collection#get to iterate over all the elements in the collection.
     */
    @JsProperty(name = "length")
    public native int length();

    @JsConstructor
    public Collection() {}

    @JsMethod
    public native T add(T value);

    @JsMethod
    private native Collection add(Collection value);

    @JsMethod
    public native boolean contains(T value);

    @JsMethod
    public native void destroy();

    @JsMethod
    public native T get(Integer index);

    @JsMethod
    public native boolean isDestroyed();

    @JsMethod
    public native boolean remove(T value);

    @JsMethod
    public native void removeAll();

    @JsMethod
    public native void update();
}
