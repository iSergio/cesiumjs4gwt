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

package org.cesiumjs.cs.datasources.properties.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.datasources.properties.Property;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GridMaterialPropertyOptions {
    /**
     * A Property specifying the grid Color.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Property color;
    /**
     * A numeric Property specifying cell alpha values.
     * Default: 0.1
     */
    @JsProperty
    public double cellAlpha;
    /**
     * A Cartesian2 Property specifying the number of grid lines along each axis.
     * Default: new Cartesian2(8, 8);
     */
    @JsProperty
    public Property lineCount;
    /**
     * A Cartesian2 Property specifying the thickness of grid lines along each axis.
     * Default: A Cartesian2 Property specifying the thickness of grid lines along each axis.
     */
    @JsProperty
    public Property lineThickness;
    /**
     * A Cartesian2 Property specifying starting offset of grid lines along each axis.
     * Default: new Cartesian2(0.0, 0.0)
     */
    @JsProperty
    public Property lineOffset;

    @JsConstructor
    public GridMaterialPropertyOptions() {}
}
