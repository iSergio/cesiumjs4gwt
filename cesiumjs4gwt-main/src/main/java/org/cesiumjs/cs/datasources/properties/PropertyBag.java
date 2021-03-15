/*
 * Copyright 2021 iserge.
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

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.js.JsObject;

/**
 * A {@link Property} whose value is a key-value mapping of property names to the computed value of other properties.
 */
@JsType(isNative = true, namespace = "Cesium", name = "PropertyBag")
public class PropertyBag extends Property {
    /**
     * Gets the event that is raised whenever the set of properties contained in this object changes,
     * or one of the properties itself changes.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * Gets a value indicating if this property is constant. This property is considered constant
     * if all property items in this object are constant.
     */
    @JsProperty(name = "isConstant")
    public native boolean isConstant();
    /**
     * Gets the names of all properties registered on this instance.
     */
    @JsProperty(name = "propertyNames")
    public native String[] propertyNames();

    @JsConstructor
    public PropertyBag() {}

    /**
     * Adds a property to this object.
     * @param propertyName The name of the property to add.
     * @throws "propertyName" is already a registered property.
     */
    @JsMethod
    public native void addProperty(String propertyName);

    /**
     * Adds a property to this object.
     * @param propertyName The name of the property to add.
     * @param value The value of the new property, if provided.
     * @throws "propertyName" is already a registered property.
     */
    @JsMethod
    public native void addProperty(String propertyName, Object value);

    /**
     * Adds a property to this object.
     * @param propertyName The name of the property to add.
     * @param value The value of the new property, if provided.
     * @param createPropertyCallback A function that will be called when the value of this new property is set to a
     *                               value that is not a Property.
     * @throws "propertyName" is already a registered property.
     */
    @JsMethod
    public native void addProperty(String propertyName, Object value, CreatePropertyCallback createPropertyCallback);

    /**
     * Compares this property to the provided property and returns true if they are equal, false otherwise.
     * @param other The other property.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(Property other);

    /**
     * Gets the value of this property. Each contained property will be evaluated at the given time, and the overall
     * result will be an object, mapping property names to those values.
     * @param time The time for which to retrieve the value.
     * @return The modified result parameter or a new instance if the result parameter was not supplied.
     */
    @JsMethod
    public native JsObject getValue(JulianDate time);

    /**
     * Gets the value of this property. Each contained property will be evaluated at the given time, and the overall
     * result will be an object, mapping property names to those values.
     * @param time The time for which to retrieve the value.
     * @param result The object to store the value into, if omitted, a new instance is created and returned.
     *               Note that any properties in result which are not part of this PropertyBag will be left as-is.
     * @return The modified result parameter or a new instance if the result parameter was not supplied.
     */
    @JsMethod
    public native JsObject getValue(JulianDate time, JsObject result);

    /**
     * Determines if this object has defined a property with the given name.
     * @param propertyName The name of the property to check for.
     * @return True if this object has defined a property with the given name, false otherwise.
     */
    @JsMethod
    public native boolean hasProperty(String propertyName);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    @JsMethod
    public native void merge(JsObject source);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     * @param createPropertyCallback A function that will be called when the value of any of
     *                               the properties in value are not a Property.
     */
    @JsMethod
    public native void merge(JsObject source, CreatePropertyCallback createPropertyCallback);

    /**
     * Removed a property previously added with addProperty.
     * @param propertyName String	The name of the property to remove.
     * @throws "propertyName" is not a registered property.
     */
    @JsMethod
    public native void removeProperty(String propertyName);

    @JsFunction
    @FunctionalInterface
    public interface CreatePropertyCallback {
        void callback();
    }
}
