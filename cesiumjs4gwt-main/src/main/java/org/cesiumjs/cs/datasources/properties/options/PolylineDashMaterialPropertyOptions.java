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

package org.cesiumjs.cs.datasources.properties.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.datasources.properties.Property;

/**
 * Options for
 * {@link org.cesiumjs.cs.datasources.properties.PolylineDashMaterialProperty}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PolylineDashMaterialPropertyOptions {
    /**
     * A Property specifying the Color of the line. Default: {@link Color#WHITE()}.
     */
    @JsProperty
    public Property color;
    /**
     * A Property specifying the Color of the gaps in the line. Default:
     * {@link Color#TRANSPARENT()}.
     */
    @JsProperty
    public Property gapColor;
    /**
     * A numeric Property specifying the length of the dash pattern in pixels
     * Dedault: 16.0;
     */
    @JsProperty
    public Property dashLength;
    /**
     * A numeric Property specifying a 16 bit pattern for the dash Default: 255.0
     */
    @JsProperty
    public Property dashPattern;

    @JsConstructor
    public PolylineDashMaterialPropertyOptions() {
    }
}
