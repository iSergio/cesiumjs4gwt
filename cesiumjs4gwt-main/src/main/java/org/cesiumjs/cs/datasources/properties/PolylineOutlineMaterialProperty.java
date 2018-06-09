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

package org.cesiumjs.cs.datasources.properties;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.datasources.properties.options.PolylineOutlineMaterialPropertyOptions;
import org.cesiumjs.cs.js.JsObject;

/**
 * A {@link MaterialProperty} that maps to polyline outline {@link org.cesiumjs.cs.scene.Material} uniforms.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PolylineOutlineMaterialProperty")
public class PolylineOutlineMaterialProperty extends MaterialProperty {
    /**
     * Gets or sets the Property specifying the Color of the line.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}
     */
    @JsProperty
    public Property color;
    /**
     * Gets the event that is raised whenever the definition of this property changes. The definition is considered to
     * have changed if a call to getValue would return a different result for the same time.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * Gets a value indicating if this property is constant. A property is considered constant if getValue
     * always returns the same result for the current definition.
     */
    @JsProperty(name = "isConstant")
    public native boolean isConstant();
    /**
     * Gets or sets the Property specifying the Color of the outline.
     * Default: {@link Color#BLACK()}
     */
    @JsProperty
    public Property outlineColor;
    /**
     * Gets or sets the numeric Property specifying the width of the outline.
     * Default: 1.0
     */
    @JsProperty
    public Property outlineWidth;

    @JsConstructor
    public PolylineOutlineMaterialProperty() {}

    @JsConstructor
    public PolylineOutlineMaterialProperty(PolylineOutlineMaterialPropertyOptions options) {}

    /**
     * Compares this property to the provided property and returns true if they are equal, false otherwise.
     * @param other The other property.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(PolylineOutlineMaterialProperty other);

    /**
     * Gets the value of the property at the provided time.
     * @param time The time for which to retrieve the value.
     * @param result The object to store the value into, if omitted, a new instance is created and returned.
     * @return The modified result parameter or a new instance if the result parameter was not supplied.
     */
    @JsMethod
    public native JsObject getValue(JulianDate time, JsObject result);
}
