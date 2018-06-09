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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ConstantProperty")
public class ConstantProperty<T> extends Property<T> {
    /**
     * A {@link Property} whose value does not change with respect to simulation time.
     * @see ConstantPositionProperty
     */
    @JsConstructor
    public ConstantProperty() {}

    /**
     * A {@link Property} whose value does not change with respect to simulation time.
     * @param value The property value.
     * @see ConstantPositionProperty
     */
    @JsConstructor
    public ConstantProperty(T value) {}

    /**
     * Sets the value of the property.
     * @param value The property value.
     */
    @JsMethod
    public native void setValue(T value);

    /**
     * Gets the value of the property at the provided time.
     * @return The modified result parameter or a new instance if the result parameter was not supplied.
     */
    @JsMethod
    public native T getValue();
}
