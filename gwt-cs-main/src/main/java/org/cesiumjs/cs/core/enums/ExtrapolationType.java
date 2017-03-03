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

package org.cesiumjs.cs.core.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Constants to determine how an interpolated value is extrapolated when querying outside the bounds of available data.
 * @see org.cesiumjs.cs.datasources.properties.SampledProperty
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ExtrapolationType")
public class ExtrapolationType {
    /**
     * The value is extrapolated.
     */
    @JsProperty(name = "EXTRAPOLATE")
    public static native Number EXTRAPOLATE();
    /**
     * The first or last value is used when outside the range of sample data.
     */
    @JsProperty(name = "HOLD")
    public static native Number HOLD();
    /**
     * No extrapolation occurs.
     */
    @JsProperty(name = "NONE")
    public static native Number NONE();

    @JsConstructor
    private ExtrapolationType() {}
}
