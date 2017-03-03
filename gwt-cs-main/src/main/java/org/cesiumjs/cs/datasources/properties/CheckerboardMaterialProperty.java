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
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.datasources.properties.options.CheckerboardMaterialPropertyOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CheckerboardMaterialProperty")
public class CheckerboardMaterialProperty extends MaterialProperty {
    /**
     * Gets the event that is raised whenever the definition of this property changes.
     * The definition is considered to have changed if a call to getValue would return a different result for the same time.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * A Property specifying the first Color.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Property evenColor;
    /**
     * A Property specifying the second Color.
     * Default: {@link Color#BLACK()}
     */
    @JsProperty
    public Property oddColor;
    /**
     * A Cartesian2 Property specifying how many times the tiles repeat in each direction.
     * Default: new Cartesian2(2.0, 2.0)
     */
    @JsProperty
    public Property repeat;

    /**
     * A {@link MaterialProperty} that maps to checkerboard {@link org.cesiumjs.cs.scene.Material} uniforms.
     */
    @JsConstructor
    public CheckerboardMaterialProperty() {}

    /**
     * A {@link MaterialProperty} that maps to checkerboard {@link org.cesiumjs.cs.scene.Material} uniforms.
     * @param options Options
     */
    @JsConstructor
    public CheckerboardMaterialProperty(CheckerboardMaterialPropertyOptions options) {}
}
