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
 * Represents a Gregorian date in a more precise format than the JavaScript Date object. In addition to submillisecond precision,
 * this object can also represent leap seconds.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "GregorianDate")
public class GregorianDate {
    /**
     * Gets or sets the day of the month as a whole number starting at 1.
     */
    public int day;
    /**
     * Gets or sets the hour as a whole number with range [0, 23].
     */
    public int hour;
    /**
     * Gets or sets whether this time is during a leap second.
     */
    public boolean isLeapSecond;
    /**
     * Gets or sets the millisecond of the second as a floating point number with range [0.0, 1000.0).
     */
    public int millisecond;
    /**
     * Gets or sets the minute of the hour as a whole number with range [0, 59].
     */
    public int minute;
    /**
     * Gets or sets the month as a whole number with range [1, 12].
     */
    public int month;
    /**
     * Gets or sets the second of the minute as a whole number with range [0, 60], with 60 representing a leap second.
     */
    public int second;
    /**
     * Gets or sets the year as a whole number.
     */
    public int year;

    /**
     * Represents a Gregorian date in a more precise format than the JavaScript Date object. In addition to submillisecond
     * precision, this object can also represent leap seconds.
     * @see JulianDate#toGregorianDate(JulianDate)
     * @see JulianDate#toGregorianDate(JulianDate, GregorianDate)
     */
    @JsConstructor
    public GregorianDate() {}
}
