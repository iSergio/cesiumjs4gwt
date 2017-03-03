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

package org.cesiumjs.cs.js;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
//TODO: Later full functional
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Date")
public class JsDate {
    /**
     * Creates a JavaScript Date object for the current date and time according to system settings.
     */
    @JsConstructor
    public JsDate() {}

    @JsConstructor
    public JsDate(Integer value) {}

    @JsConstructor
    public JsDate(String dateString) {}

    /**
     * Creates a JavaScript Date object
     * @param year Integer value representing the year. Values from 0 to 99 map to the years 1900 to 1999.
     * @param month Integer value representing the month, beginning with 0 for January to 11 for December.
     */
    @JsConstructor
    public JsDate(Integer year, Integer month) {}

    /**
     * Creates a JavaScript Date object
     * @param year Integer value representing the year. Values from 0 to 99 map to the years 1900 to 1999.
     * @param month Integer value representing the month, beginning with 0 for January to 11 for December.
     * @param day Integer value representing the day of the month.
     */
    @JsConstructor
    public JsDate(Integer year, Integer month, Integer day) {}

    /**
     * Creates a JavaScript Date object
     * @param year Integer value representing the year. Values from 0 to 99 map to the years 1900 to 1999.
     * @param month Integer value representing the month, beginning with 0 for January to 11 for December.
     * @param day Integer value representing the day of the month.
     * @param hour Integer value representing the hour of the day.
     */
    @JsConstructor
    public JsDate(Integer year, Integer month, Integer day, Integer hour) {}

    /**
     * Creates a JavaScript Date object
     * @param year Integer value representing the year. Values from 0 to 99 map to the years 1900 to 1999.
     * @param month Integer value representing the month, beginning with 0 for January to 11 for December.
     * @param day Integer value representing the day of the month.
     * @param hour Integer value representing the hour of the day.
     * @param minute Integer value representing the minute segment of a time.
     */
    @JsConstructor
    public JsDate(Integer year, Integer month, Integer day, Integer hour, Integer minute) {}

    /**
     * Creates a JavaScript Date object
     * @param year Integer value representing the year. Values from 0 to 99 map to the years 1900 to 1999.
     * @param month Integer value representing the month, beginning with 0 for January to 11 for December.
     * @param day Integer value representing the day of the month.
     * @param hour Integer value representing the hour of the day.
     * @param minute Integer value representing the minute segment of a time.
     * @param second Integer value representing the second segment of a time.
     */
    @JsConstructor
    public JsDate(Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second) {}

    /**
     * Creates a JavaScript Date object
     * @param year Integer value representing the year. Values from 0 to 99 map to the years 1900 to 1999.
     * @param month Integer value representing the month, beginning with 0 for January to 11 for December.
     * @param day Integer value representing the day of the month.
     * @param hour Integer value representing the hour of the day.
     * @param minute Integer value representing the minute segment of a time.
     * @param second Integer value representing the second segment of a time.
     * @param millisecond Integer value representing the millisecond segment of a time.
     */
    @JsConstructor
    public JsDate(Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second, Integer millisecond) {}

    /**
     * Returns the numeric value corresponding to the current time - the number of milliseconds elapsed since 1
     * January 1970 00:00:00 UTC, with leap seconds ignored.
     * @return numeric value corresponding to the current time
     */
    @JsMethod
    public static native JsDate now();

    /**
     * Parses a string representation of a date and returns the number of milliseconds since 1 January,
     * 1970, 00:00:00, UTC, with leap seconds ignored.
     * @param dateString A string representing an RFC2822 or ISO 8601 date (other formats may be used, but results may be unexpected).
     * @return JsDate JavaScript object
     */
    @JsMethod
    public static native JsDate parse(String dateString);

    @JsMethod
    @Override
    public native String toString();
}
