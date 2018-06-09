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
public class StripeMaterialPropertyOptions {
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
     * A numeric Property specifying how many times the stripes repeat.
     * Default: 1
     */
    @JsProperty
    public Property repeat;
    /**
     * A numeric Property specifying how far into the pattern to start the material.
     * Default: 0
     */
    @JsProperty
    public Property offset;
    /**
     * A Property specifying the StripeOrientation.
     * Default: StripeOrientation.HORIZONTAL
     */
    //@JsProperty
    //public StripeOrientation orientation;
    
    /**
     * Options for {@link org.cesiumjs.cs.datasources.properties.StripeMaterialProperty}
     */
    @JsConstructor
    public StripeMaterialPropertyOptions() {}
}
