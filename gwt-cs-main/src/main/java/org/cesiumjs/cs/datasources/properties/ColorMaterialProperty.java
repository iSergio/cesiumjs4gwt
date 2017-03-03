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
import org.cesiumjs.cs.core.Color;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ColorMaterialProperty")
public class ColorMaterialProperty extends MaterialProperty {
    /**
     * Gets or sets the Color Property.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Property color;

    /**
     * A MaterialProperty that maps to solid color Material uniforms.
     */
    @JsConstructor
    public ColorMaterialProperty() {}

    /**
     * A MaterialProperty that maps to solid color Material uniforms.
     * @param color The {@link Color} Property to be used. Default: {@link Color#WHITE()}
     */
    @JsConstructor
    public ColorMaterialProperty(Property color) {}

    @JsConstructor
    public ColorMaterialProperty(Color color) {}
}
