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
import org.cesiumjs.cs.core.JulianDate;

/**
 * Provides the type of time standards which JulianDate can take as input.
 * @see JulianDate
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TimeStandard")
public class TimeStandard {
    /**
     * Represents the coordinated Universal Time (UTC) time standard. UTC is related to TAI according to the relationship
     * UTC = TAI - deltaT where deltaT is the number of leap seconds which have been introduced as of the time in TAI.
     * @return UTC standard
     */
    @JsProperty(name = "UTC")
    public static native Number UTC();

    /**
     * Represents the International Atomic Time (TAI) time standard. TAI is the principal time standard to which the
     * other time standards are related.
     * @return TAI standard
     */
    @JsProperty(name = "TAI")
    public static native Number TAI();

    @JsConstructor
    private TimeStandard() {}
}
