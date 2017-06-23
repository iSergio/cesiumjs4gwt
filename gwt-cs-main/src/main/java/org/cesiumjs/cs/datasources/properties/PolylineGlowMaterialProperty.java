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

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.datasources.properties.options.PolylineGlowMaterialPropertyOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PolylineGlowMaterialProperty")
public class PolylineGlowMaterialProperty extends MaterialProperty {
    /**
     * A Property specifying the Color of the line.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Property color;
    /**
     * A numeric Property specifying the strength of the glow, as a percentage of the total line width.
     * Default: 0.25
     */
    @JsProperty
    public Property glowPower;

    /**
     * A {@link MaterialProperty} that maps to polyline glow {@link org.cesiumjs.cs.scene.Material} uniforms.
     */
    @JsConstructor
    public PolylineGlowMaterialProperty() {}

    /**
     * Simple method for create PolylineGlowMaterialProperty by color and glowPower.
     * @param color A Property specifying the Color of the line.
     * @param glowPower A numeric Property specifying the strength of the glow, as a percentage of the total line width.
     * @return PolylineGlowMaterialProperty
     */
    @JsOverlay
    public static PolylineGlowMaterialProperty create(Color color, double glowPower) {
        PolylineGlowMaterialPropertyOptions options = new PolylineGlowMaterialPropertyOptions();
        options.color = new ConstantProperty<>(color);
        options.glowPower = new ConstantProperty<>(glowPower);
        return new PolylineGlowMaterialProperty(options);
    }

    /**
     * A {@link MaterialProperty} that maps to polyline glow {@link org.cesiumjs.cs.scene.Material} uniforms.
     * @param options Options
     */
    @JsConstructor
    public PolylineGlowMaterialProperty(PolylineGlowMaterialPropertyOptions options) {}
}
