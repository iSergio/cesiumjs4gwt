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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * Describes a single leap second, which is constructed from a JulianDate and a numerical offset representing the
 * number of seconds TAI is ahead of the UTC time standard.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "LeapSecond")
public class LeapSecond {
    /**
     * Gets or sets the date at which this leap second occurs.
     */
    public JulianDate julianDate;
    /**
     * Gets or sets the cumulative number of seconds between the UTC and TAI time standards at the time of this leap second.
     */
    public int offset;
    /**
     * Describes a single leap second, which is constructed from a JulianDate and a numerical offset representing the
     * number of seconds TAI is ahead of the UTC time standard.
     */
    @JsConstructor
    public LeapSecond() {}

    /**
     * Describes a single leap second, which is constructed from a JulianDate and a numerical offset representing the
     * number of seconds TAI is ahead of the UTC time standard.
     * @param date A Julian date representing the time of the leap second.
     * @param offset The cumulative number of seconds that TAI is ahead of UTC at the provided date.
     */
    @JsConstructor
    public LeapSecond(JulianDate date, int offset) {}
}
