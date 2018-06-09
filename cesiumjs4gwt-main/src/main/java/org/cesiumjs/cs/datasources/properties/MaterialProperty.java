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
import jsinterop.annotations.JsOptional;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.scene.Material;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "MaterialProperty")
public class MaterialProperty extends Property<Material> {
    /**
     * The interface for all {@link Property} objects that represent {@link org.cesiumjs.cs.scene.Material} uniforms.
     * This type defines an interface and cannot be instantiated directly.
     * @see ColorMaterialProperty
     * @see CompositeMaterialProperty
     * @see GridMaterialProperty
     * @see ImageMaterialProperty
     * @see PolylineGlowMaterialProperty
     * @see PolylineOutlineMaterialProperty
     * @see StripeMaterialProperty
     */
    @JsConstructor
    public MaterialProperty() {}

    /**
     * Gets the Material type at the provided time.
     * @return The type of material.
     */
    @JsMethod
    public native String getType();

    /**
     * Gets the Material type at the provided time.
     * @param time The time for which to retrieve the type.
     * @return The type of material.
     */
    @JsMethod
    public native String getType(@JsOptional JulianDate time);
}
