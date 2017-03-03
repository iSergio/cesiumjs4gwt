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
import org.cesiumjs.cs.datasources.properties.options.ImageMaterialPropertyOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ImageMaterialProperty")
public class ImageMaterialProperty extends MaterialProperty {
    /**
     * Gets or sets the Color Property specifying the desired color applied to the imagery.
     * Default:  1.0
     */
    @JsProperty
    public Property color;
    /**
     * Gets or sets the Property specifying Image, URL, Canvas, or Video to use.
     */
    @JsProperty
    public Property image;
    /**
     * Gets or sets the Cartesian2 Property specifying the number of times the imagery repeats in each direction.
     * Default: new Cartesian2(1, 1)
     */
    @JsProperty
    public Property repeat;
    /**
     * Gets or sets the Boolean Property specifying whether the imagery has transparency
     * Default: 1.0
     */
    @JsProperty
    public Property transparent;

    /**
     * A {@link MaterialProperty} that maps to imagery {@link org.cesiumjs.cs.scene.Material} uniforms.
     */
    @JsConstructor
    public ImageMaterialProperty() {}

    /**
     * A {@link MaterialProperty} that maps to imagery {@link org.cesiumjs.cs.scene.Material} uniforms.
     * @param options Options
     */
    @JsConstructor
    public ImageMaterialProperty(ImageMaterialPropertyOptions options) {}
}
