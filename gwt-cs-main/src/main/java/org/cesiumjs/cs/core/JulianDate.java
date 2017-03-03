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
import org.cesiumjs.cs.core.enums.TimeStandard;
import org.cesiumjs.cs.js.JsDate;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "JulianDate")
public class JulianDate {
    /**
     * Gets or sets the list of leap seconds used throughout Cesium.
     */
    public LeapSecond[] leapSeconds;
    /**
     * Gets or sets the list of leap seconds used throughout Cesium.
     */
    public int dayNumber;
    /**
     * Gets or sets the number of seconds into the current day.
     */
    public int secondsOfDay;
    /**
     * Represents an astronomical Julian date, which is the number of days since noon on January 1, -4712 (4713 BC).
     * For increased precision, this class stores the whole number part of the date and the seconds part of the date in
     * separate components. In order to be safe for arithmetic and represent leap seconds, the date is always stored in
     * the International Atomic Time standard TimeStandard.TAI.
     */
    @JsConstructor
    public JulianDate() {}

    /**
     * Represents an astronomical Julian date, which is the number of days since noon on January 1, -4712 (4713 BC).
     * For increased precision, this class stores the whole number part of the date and the seconds part of the date in
     * separate components. In order to be safe for arithmetic and represent leap seconds, the date is always stored in
     * the International Atomic Time standard TimeStandard.TAI.
     * @param julianDayNumber The Julian Day Number representing the number of whole days. Fractional days will also be
     *                        handled correctly. Default: 0.
     */
    @JsConstructor
    public JulianDate(double julianDayNumber) {}

    /**
     * Represents an astronomical Julian date, which is the number of days since noon on January 1, -4712 (4713 BC).
     * For increased precision, this class stores the whole number part of the date and the seconds part of the date in
     * separate components. In order to be safe for arithmetic and represent leap seconds, the date is always stored in
     * the International Atomic Time standard TimeStandard.TAI.
     * @param julianDayNumber The Julian Day Number representing the number of whole days. Fractional days will also be
     *                        handled correctly. Default: 0.
     * @param secondsOfDay The number of seconds into the current Julian Day Number. Fractional seconds,
     *                     negative seconds and seconds greater than a day will be handled correctly. Default: 0.
     */
    @JsConstructor
    public JulianDate(double julianDayNumber, double secondsOfDay) {}

    /**
     * Represents an astronomical Julian date, which is the number of days since noon on January 1, -4712 (4713 BC).
     * For increased precision, this class stores the whole number part of the date and the seconds part of the date in
     * separate components. In order to be safe for arithmetic and represent leap seconds, the date is always stored in
     * the International Atomic Time standard TimeStandard.TAI.
     * @param julianDayNumber The Julian Day Number representing the number of whole days. Fractional days will also be
     *                        handled correctly. Default: 0.
     * @param secondsOfDay The number of seconds into the current Julian Day Number. Fractional seconds,
     *                     negative seconds and seconds greater than a day will be handled correctly. Default: 0.
     * @param timeStandard The time standard in which the first two parameters are defined. Default: {@link TimeStandard#UTC()}.
     */
    @JsConstructor
    public JulianDate(double julianDayNumber, double secondsOfDay, Integer timeStandard) {}

    /**
     * Adds the provided number of days to the provided date instance.
     * @param julianDate The date.
     * @param days The number of days to add or subtract.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter.
     */
    public static native JulianDate addDays(JulianDate julianDate, int days, JulianDate result);

    /**
     * Adds the provided number of hours to the provided date instance.
     * @param julianDate The date.
     * @param hours The number of hours to add or subtract.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter.
     */
    public static native JulianDate addHours(JulianDate julianDate, int hours, JulianDate result);

    /**
     * Adds the provided number of minutes to the provided date instance.
     * @param julianDate The date.
     * @param minutes The number of minutes to add or subtract.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter.
     */
    public static native JulianDate addMinutes(JulianDate julianDate, int minutes, JulianDate result);

    /**
     * Adds the provided number of seconds to the provided date instance.
     * @param julianDate The date.
     * @param seconds The number of seconds to add or subtract.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter.
     */
    public static native JulianDate addSeconds(JulianDate julianDate, int seconds, JulianDate result);

    /**
     * Duplicates a JulianDate instance.
     * @param julianDate The date to duplicate.
     * @return The modified result parameter or a new instance if none was provided. Returns undefined if julianDate is undefined.
     */
    public static native JulianDate clone(JulianDate julianDate);

    /**
     * Duplicates a JulianDate instance.
     * @param julianDate The date to duplicate.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided. Returns undefined if julianDate is undefined.
     */
    public static native JulianDate clone(JulianDate julianDate, JulianDate result);

    /**
     * Compares two instances.
     * @param left The first instance.
     * @param right The second instance.
     * @return A negative value if left is less than right, a positive value if left is greater than right, or zero if left and right are equal.
     */
    public static native int compare(JulianDate left, JulianDate right);

    /**
     * Computes the number of seconds the provided instance is ahead of UTC.
     * @param julianDate The date.
     * @return The number of seconds the provided instance is ahead of UTC
     */
    public static native int computeTaiMinusUtc(JulianDate julianDate);

    /**
     * Computes the difference in days between the provided instance.
     * @param left The first instance.
     * @param right The second instance.
     * @return The difference, in days, when subtracting right from left.
     */
    public static native int daysDifference(JulianDate left, JulianDate right);

    /**
     * Compares two instances and returns true if they are equal, false otherwise.
     * @param left The first instance.
     * @param right The second instance.
     * @return true if the dates are equal; otherwise, false.
     */
    public static native boolean equals(JulianDate left, JulianDate right);

    /**
     * Compares two instances and returns true if they are within epsilon seconds of each other. That is, in order
     * for the dates to be considered equal (and for this function to return true), the absolute value of the difference
     * between them, in seconds, must be less than epsilon.
     * @param left The first instance.
     * @param right The second instance.
     * @param epsilon The maximum number of seconds that should separate the two instances.
     * @return true if the two dates are within epsilon seconds of each other; otherwise false.
     */
    public static native boolean equalsEpsilon(JulianDate left, JulianDate right, int epsilon);

    /**
     * Creates a new instance from a JavaScript Date.
     * @param date A JavaScript Date.
     * @return The modified result parameter or a new instance if none was provided.
     */
    public static native JulianDate fromDate(JsDate date);

    /**
     * Creates a new instance from a JavaScript Date.
     * @param date A JavaScript Date.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided.
     */
    public static native JulianDate fromDate(JsDate date, JulianDate result);

    /**
     * Creates a new instance from a from an ISO 8601 date. This method is superior to Date.parse because it will handle
     * all valid formats defined by the ISO 8601 specification, including leap seconds and sub-millisecond times,
     * which discarded by most JavaScript implementations.
     * @param iso8601String An ISO 8601 date.
     * @return The modified result parameter or a new instance if none was provided.
     */
    public static native JulianDate fromIso8601(String iso8601String);

    /**
     * Creates a new instance from a from an ISO 8601 date. This method is superior to Date.parse because it will handle
     * all valid formats defined by the ISO 8601 specification, including leap seconds and sub-millisecond times,
     * which discarded by most JavaScript implementations.
     * @param iso8601String An ISO 8601 date.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided.
     */
    public static native JulianDate fromIso8601(String iso8601String, JulianDate result);

    /**
     * Compares the provided instances and returns true if left is later than right, false otherwise.
     * @param left The first instance.
     * @param right The second instance.
     * @return true if left is later than right, false otherwise.
     */
    public static native boolean greaterThan(JulianDate left, JulianDate right);

    /**
     * Compares the provided instances and returns true if left is later than or equal to right, false otherwise.
     * @param left The first instance.
     * @param right The second instance.
     * @return true if left is later than or equal to right, false otherwise.
     */
    public static native boolean greaterThanOrEquals(JulianDate left, JulianDate right);

    /**
     * Compares the provided instances and returns true if left is earlier than right, false otherwise.
     * @param left The first instance.
     * @param right The second instance.
     * @return true if left is earlier than right, false otherwise.
     */
    public static native boolean lessThan(JulianDate left, JulianDate right);

    /**
     * Compares the provided instances and returns true if left is earlier than or equal to right, false otherwise.
     * @param left The first instance.
     * @param right The second instance.
     * @return true if left is earlier than or equal to right, false otherwise.
     */
    public static native boolean lessThanOrEquals(JulianDate left, JulianDate right);

    /**
     * Creates a new instance that represents the current system time. This is equivalent to calling JulianDate.fromDate(new Date());.
     * @return The modified result parameter or a new instance if none was provided.
     */
    public static native JulianDate now();

    /**
     * Creates a new instance that represents the current system time. This is equivalent to calling JulianDate.fromDate(new Date());.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided.
     */
    public static native JulianDate now(JulianDate result);

    /**
     * Computes the difference in seconds between the provided instance.
     * @param left The first instance.
     * @param right The second instance.
     * @return The difference, in seconds, when subtracting right from left.
     */
    public static native int secondsDifference(JulianDate left, JulianDate right);

    /**
     * Creates a JavaScript Date from the provided instance. Since JavaScript dates are only accurate to the nearest
     * millisecond and cannot represent a leap second, consider using JulianDate.toGregorianDate instead.
     * If the provided JulianDate is during a leap second, the previous second is used.
     * @param julianDate The date to be converted.
     * @return A new instance representing the provided date.
     */
    public static native JsDate toDate(JulianDate julianDate);

    /**
     * Creates a GregorianDate from the provided instance.
     * @param julianDate The date to be converted.
     * @return The modified result parameter or a new instance if none was provided.
     */
    public static native GregorianDate toGregorianDate(JulianDate julianDate);

    /**
     * Creates a GregorianDate from the provided instance.
     * @param julianDate The date to be converted.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided.
     */
    public static native GregorianDate toGregorianDate(JulianDate julianDate, GregorianDate result);

    /**
     * Creates an ISO8601 representation of the provided date.
     * @param julianDate The date to be converted.
     * @return The ISO8601 representation of the provided date.
     */
    public static native String toIso8601(JulianDate julianDate);

    /**
     * Creates an ISO8601 representation of the provided date.
     * @param julianDate The date to be converted.
     * @param precision The number of fractional digits used to represent the seconds component.
     *                  By default, the most precise representation is used.
     * @return The ISO8601 representation of the provided date.
     */
    public static native String toIso8601(JulianDate julianDate, int precision);

    /**
     * Computes the total number of whole and fractional days represented by the provided instance.
     * @param julianDate The date.
     * @return The Julian date as single floating point number.
     */
    public static native int totalDays(JulianDate julianDate);

    /**
     * Duplicates this instance.
     * @return The modified result parameter or a new instance if none was provided.
     */
    public native JulianDate clone();

    /**
     * Compares this and the provided instance and returns true if they are equal, false otherwise.
     * @param right The second instance.
     * @return true if the dates are equal; otherwise, false.
     */
    public native boolean equals(JulianDate right);

    /**
     * Compares this and the provided instance and returns true if they are within epsilon seconds of each other.
     * That is, in order for the dates to be considered equal (and for this function to return true),
     * the absolute value of the difference between them, in seconds, must be less than epsilon.
     * @param right The second instance.
     * @param epsilon The maximum number of seconds that should separate the two instances.
     * @return true if the two dates are within epsilon seconds of each other; otherwise false.
     */
    public native boolean equalsEpsilon(JulianDate right, int epsilon);

    /**
     * Creates a string representing this date in ISO8601 format.
     * @return A string representing this date in ISO8601 format.
     */
    public native String toString();
}
