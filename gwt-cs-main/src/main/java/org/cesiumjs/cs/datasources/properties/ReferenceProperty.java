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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.EntityCollection;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.enums.ReferenceFrame;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ReferenceProperty")
public class ReferenceProperty extends Property {
    /**
     * Gets the event that is raised whenever the definition of this property changes.
     * The definition is considered to have changed if a call to getValue would return a different result for the same time.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * Gets a value indicating if this property is constant.
     * A property is considered constant if getValue always returns the same result for the current definition.
     */
    @JsProperty(name = "isConstant")
    public native boolean isConstant();
    /**
     * Gets the reference frame that the position is defined in. This property is only valid if the referenced property is a PositionProperty.
     */
    @JsProperty(name = "referenceFrame")
    public native Integer referenceFrame();
    /**
     * Gets the resolved instance of the underlying referenced property.
     */
    @JsProperty(name = "resolvedProperty")
    public native Property resolvedProperty();
    /**
     * Gets the collection containing the entity being referenced.
     */
    @JsProperty(name = "targetCollection")
    public native EntityCollection targetCollection();
    /**
     * Gets the id of the entity being referenced.
     */
    @JsProperty(name = "targetId")
    public native String targetId();
    /**
     * Gets the array of property names used to retrieve the referenced property.
     */
    @JsProperty(name = "targetPropertyNames")
    public native String[] targetPropertyNames();

    //TODO: Examples
    /**
     * A Property which transparently links to another property on a provided object.
     * @param targetCollection The entity collection which will be used to resolve the reference.
     * @param targetId The id of the entity which is being referenced.
     * @param targetPropertyNames The names of the property on the target entity which we will use.
     */
    @JsConstructor
    public ReferenceProperty(EntityCollection targetCollection, String targetId, String[] targetPropertyNames) {}

    /**
     * Creates a new instance given the entity collection that will be used to resolve it and a string indicating the
     * target entity id and property. The format of the string is "objectId#foo.bar", where # separates the id from
     * property path and . separates sub-properties. If the reference identifier or or any sub-properties
     * contains a # . or \ they must be escaped.
     * @param targetCollection
     * @param referenceString
     * @return A new instance of ReferenceProperty.
     */
    @JsMethod
    public native ReferenceProperty fromString(EntityCollection targetCollection, String referenceString);

    /**
     * Compares this property to the provided property and returns true if they are equal, false otherwise.
     * @param other The other property.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(Property other);

    /**
     * Gets the Material type at the provided time. This method is only valid if the property being referenced is a MaterialProperty.
     * @param time The time for which to retrieve the type.
     * @return The type of material.
     */
    @JsMethod
    public native String getType(JulianDate time);

    /**
     * Gets the value of the property at the provided time.
     * @param time The time for which to retrieve the value.
     * @return The modified result parameter or a new instance if the result parameter was not supplied.
     */
    @JsMethod
    public native Object getValue(JulianDate time);

    /**
     * Gets the value of the property at the provided time.
     * @param time The time for which to retrieve the value.
     * @param result The object to store the value into, if omitted, a new instance is created and returned.
     * @return The modified result parameter or a new instance if the result parameter was not supplied.
     */
    @JsMethod
    public native Object getValue(JulianDate time, Object result);

    /**
     * Gets the value of the property at the provided time and in the provided reference frame.
     * This method is only valid if the property being referenced is a PositionProperty.
     * @param time The time for which to retrieve the value.
     * @param referenceFrame {@link ReferenceFrame} The desired referenceFrame of the result.
     * @return The modified result parameter or a new instance if the result parameter was not supplied.
     */
    @JsMethod
    public native Cartesian3 getValueInReferenceFrame(JulianDate time, Integer referenceFrame);

    /**
     * Gets the value of the property at the provided time and in the provided reference frame.
     * This method is only valid if the property being referenced is a PositionProperty.
     * @param time The time for which to retrieve the value.
     * @param referenceFrame {@link ReferenceFrame} The desired referenceFrame of the result.
     * @param result The object to store the value into, if omitted, a new instance is created and returned.
     * @return The modified result parameter or a new instance if the result parameter was not supplied.
     */
    @JsMethod
    public native Cartesian3 getValueInReferenceFrame(JulianDate time, Integer referenceFrame, Cartesian3 result);
}
