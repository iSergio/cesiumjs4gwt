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
import org.cesiumjs.cs.datasources.StripeOrientation;
import org.cesiumjs.cs.datasources.properties.options.StripeMaterialPropertyOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "StripeMaterialProperty")
public class StripeMaterialProperty extends MaterialProperty {
    /**
     * Gets or sets the Property specifying the first Color.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Property evenColor;
    /**
     * Gets or sets the Property specifying the second Color.
     * Default: {@link Color#BLACK()}
     */
    @JsProperty
    public Property oddColor;
    /**
     * Gets or sets the numeric Property specifying the point into the pattern to begin drawing; with 0.0 being the
     * beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again,
     * and any multiple or fractional values being in between.
     * Default: 0.0
     */
    @JsProperty
    public Property offset;
    /**
     * Gets or sets the Property specifying the StripeOrientation/
     * Default: {@link StripeOrientation#HORIZONTAL()}
     */
    @JsProperty
    public Property orientation;
    /**
     * Gets or sets the numeric Property specifying how many times the stripes repeat.
     * Default: 1.0
     */
    @JsProperty
    public Property repeat;

    /**
     * A {@link MaterialProperty} that maps to stripe {@link org.cesiumjs.cs.scene.Material} uniforms.
     */
    @JsConstructor
    public StripeMaterialProperty() {}

    /**
     * A {@link MaterialProperty} that maps to stripe {@link org.cesiumjs.cs.scene.Material} uniforms.
     * @param options Options
     */
    @JsConstructor
    public StripeMaterialProperty(StripeMaterialPropertyOptions options) {}
}
