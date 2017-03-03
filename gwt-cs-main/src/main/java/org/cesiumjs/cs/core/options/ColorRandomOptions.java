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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ColorRandomOptions {
    /**
     * If specified, the red component to use instead of a randomized value. Optional.
     */
    @JsProperty
    public float red;
    /**
     * The maximum red value to generate if none was specified. Optional.
     */
    @JsProperty
    public float minimumRed;// = 0.0f;
    /**
     * The minimum red value to generate if none was specified. Optional.
     */
    @JsProperty
    public float maximumRed;//	= 1.0f;
    /**
     * If specified, the green component to use instead of a randomized value.
     */
    @JsProperty
    public float green;
    /**
     * The maximum green value to generate if none was specified.
     */
    @JsProperty
    public float minimumGreen;// = 0.0f;
    /**
     * The minimum green value to generate if none was specified.
     */
    @JsProperty
    public float maximumGreen;// = 1.0f;
    /**
     * If specified, the blue component to use instead of a randomized value.
     */
    @JsProperty
    public float blue;
    /**
     * The maximum blue value to generate if none was specified.
     */
    @JsProperty
    public float minimumBlue;// = 0.0f;
    /**
     * The minimum blue value to generate if none was specified.
     */
    @JsProperty
    public float maximumBlue;// = 1.0f;
    /**
     * If specified, the alpha component to use instead of a randomized value.
     */
    @JsProperty
    public float alpha;
    /**
     * The maximum alpha value to generate if none was specified.
     */
    @JsProperty
    public float minimumAlpha;// = 0.0f;
    /**
     * The minimum alpha value to generate if none was specified.
     */
    @JsProperty
    public float maximumAlpha;// = 1.0f;

    @JsConstructor
    public ColorRandomOptions() {}
}
