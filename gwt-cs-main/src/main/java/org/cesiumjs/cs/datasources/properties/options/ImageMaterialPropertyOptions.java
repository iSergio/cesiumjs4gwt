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
import org.cesiumjs.cs.datasources.properties.Property;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ImageMaterialPropertyOptions {
    /**
     * A Property specifying the Image, URL, Canvas, or Video.
     */
    //TODO: Check
    @JsProperty
    public Property image;
    /**
     * A Cartesian2 Property specifying the number of times the imagery repeats in each direction.
     * Default: new Cartesian2(1.0, 1.0)
     */
    @JsProperty
    public Property repeat;
    /**
     * The color applied to the imagery
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}
     */
    @JsProperty
    public Property color;
    /**
     * Set to true when the imagery has transparency (for example, when a png has transparent sections)
     */
    @JsProperty
    public boolean transparent;

    @JsConstructor
    public ImageMaterialPropertyOptions() {}
}
