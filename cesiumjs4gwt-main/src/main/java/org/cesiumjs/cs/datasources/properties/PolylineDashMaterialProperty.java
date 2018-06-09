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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.datasources.properties.options.PolylineDashMaterialPropertyOptions;

/**
 * A {@link MaterialProperty} that maps to polyline dash Material uniforms.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PolylineDashMaterialProperty")
public class PolylineDashMaterialProperty extends MaterialProperty {
    /**
     * Gets or sets the Property specifying the Color of the line.
     */
    @JsProperty
    public Property color;
    /**
     * Gets or sets the numeric Property specifying the length of a dash cycle
     */
    @JsProperty
    public Property dashLength;
    /**
     * Gets or sets the numeric Property specifying a dash pattern
     */
    @JsProperty
    public Property dashPattern;
    /**
     * Gets the event that is raised whenever the definition of this property changes.
     * The definition is considered to
     * have changed if a call to getValue would return a different result for the same time.
     */
    @JsProperty
    public native Event definitionChanged();
    /**
     * Gets or sets the Property specifying the Color of the gaps in the line.
     */
    @JsProperty
    public Property gapColor;
    /**
     * Gets a value indicating if this property is constant. A property is considered constant
     * if getValue always returns the same result for the current definition.
     */
    @JsProperty
    public native boolean isConstant();

    @JsConstructor
    public PolylineDashMaterialProperty() {}

    @JsConstructor
    public PolylineDashMaterialProperty(PolylineDashMaterialPropertyOptions options) {}
}
