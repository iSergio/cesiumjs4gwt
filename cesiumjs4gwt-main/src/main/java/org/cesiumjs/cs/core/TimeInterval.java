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

import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.core.options.TimeIntervalIso8601Options;
import org.cesiumjs.cs.core.options.TimeIntervalOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TimeInterval")
public class TimeInterval {
    /**
     * An immutable empty interval.
     */
    @JsProperty(name = "EMPTY")
    public native TimeInterval EMPTY();
    /**
     * Gets or sets the data associated with this interval.
     */
    @JsProperty
    public Object data;
    /**
     * Gets whether or not this interval is empty.
     */
    @JsProperty(name = "isEmpty")
    public native boolean isEmpty();
    /**
     * Gets or sets whether or not the start time is included in this interval.
     * Default: true
     */
    @JsProperty
    public boolean isStartIncluded;
    /**
     * Gets or sets whether or not the stop time is included in this interval.
     * Default: true
     */
    @JsProperty
    public boolean isStopIncluded;
    /**
     * Gets or sets the start time of this interval.
     */
    @JsProperty
    public JulianDate start;
    /**
     * Gets or sets the stop time of this interval.
     */
    @JsProperty
    public JulianDate stop;

    /**
     * An interval defined by a start and a stop time; optionally including those times as part of the interval.
     * Arbitrary data can optionally be associated with each instance for used with {@link TimeIntervalCollection}.
     */
    @JsConstructor
    public TimeInterval() {}

    /**
     * An interval defined by a start and a stop time; optionally including those times as part of the interval.
     * Arbitrary data can optionally be associated with each instance for used with {@link TimeIntervalCollection}.
     * @param options Options
     */
    //TODO: Examples
    @JsConstructor
    public TimeInterval(TimeIntervalOptions options) {}

    @JsOverlay
    public static TimeInterval create(JulianDate start, JulianDate stop) {
        TimeIntervalOptions options = new TimeIntervalOptions();
        options.start = start;
        options.stop = stop;
        return new TimeInterval(options);
    }

    /**
     * Duplicates the provided instance.
     * @param timeInterval The instance to clone.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeInterval clone(TimeInterval timeInterval, TimeInterval result);

    /**
     * Checks if the specified date is inside the provided interval.
     * @param timeInterval The interval.
     * @param julianDate The date to check.
     * @return true if the interval contains the specified date, false otherwise.
     */
    @JsMethod
    public static native boolean contains(TimeInterval timeInterval, JulianDate julianDate);

    /**
     * Compares two instances and returns true if they are equal, false otherwise.
     * @param left The first instance.
     * @param right The second instance.
     * @return true if the dates are equal; otherwise, false.
     */
    @JsMethod
    public static native boolean equals(TimeInterval left, TimeInterval right);

    /**
     * Compares two instances and returns true if they are equal, false otherwise.
     * @param left The first instance.
     * @param right The second instance.
     * @param dataComparer A function which compares the data of the two intervals. If omitted, reference equality is used.
     * @return true if the dates are equal; otherwise, false.
     */
    @JsMethod
    public static native boolean equals(TimeInterval left, TimeInterval right, DataComparer dataComparer);

    /**
     * Compares two instances and returns true if they are within epsilon seconds of each other. That is, in order for the dates to be considered equal (and for this function to return true), the absolute value of the difference between them, in seconds, must be less than epsilon.
     * @param left The first instance.
     * @param right The second instance.
     * @param epsilon The maximum number of seconds that should separate the two instances.
     * @return true if the two dates are within epsilon seconds of each other; otherwise false.
     */
    @JsMethod
    public static native boolean equalsEpsilon(TimeInterval left, TimeInterval right, double epsilon);

    /**
     * Compares two instances and returns true if they are within epsilon seconds of each other. That is, in order for the dates to be considered equal (and for this function to return true), the absolute value of the difference between them, in seconds, must be less than epsilon.
     * @param left The first instance.
     * @param right The second instance.
     * @param epsilon The maximum number of seconds that should separate the two instances.
     * @param dataComparer A function which compares the data of the two intervals. If omitted, reference equality is used.
     * @return true if the two dates are within epsilon seconds of each other; otherwise false.
     */
    @JsMethod
    public static native boolean equalsEpsilon(TimeInterval left, TimeInterval right, double epsilon, DataComparer dataComparer);

    /**
     * Creates a new instance from an <a href="http://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a> interval.
     * @param options Options.
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeInterval fromIso8601(TimeIntervalIso8601Options options);

    /**
     * Creates a new instance from an <a href="http://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a> interval.
     * @param options Options.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeInterval fromIso8601(TimeIntervalIso8601Options options, TimeInterval result);

    /**
     *
     * @param left The first interval.
     * @param right The second interval.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native TimeInterval intersect(TimeInterval left, TimeInterval right, TimeInterval result);

    /**
     *
     * @param left The first interval.
     * @param right The second interval.
     * @param result An existing instance to use for the result.
     * @param mergeCallback A function which merges the data of the two intervals. If omitted, the data from the left interval will be used.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native TimeInterval intersect(TimeInterval left, TimeInterval right, TimeInterval result, MergeCallback mergeCallback);

    /**
     * Creates an ISO8601 representation of the provided interval.
     * @param timeInterval The interval to be converted.
     * @return The ISO8601 representation of the provided interval.
     */
    @JsMethod
    public static native String toIso8601(TimeInterval timeInterval);

    /**
     * Creates an ISO8601 representation of the provided interval.
     * @param timeInterval The interval to be converted.
     * @param precision The number of fractional digits used to represent the seconds component. By default, the most precise representation is used.
     * @return The ISO8601 representation of the provided interval.
     */
    @JsMethod
    public static native String toIso8601(TimeInterval timeInterval, double precision);

    /**
     * Duplicates this instance.
     * @return a new instance if none was provided.
     */
    @JsMethod
    public native TimeInterval clone();

    /**
     * Compares this instance against the provided instance componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side interval.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(TimeInterval right);

    /**
     * Compares this instance against the provided instance componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side interval.
     * @param dataComparer A function which compares the data of the two intervals. If omitted, reference equality is used.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(TimeInterval right, DataComparer dataComparer);

    /**
     * Compares this instance against the provided instance componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param right The right hand side interval.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if they are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(TimeInterval right, double epsilon);

    /**
     * Compares this instance against the provided instance componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param right The right hand side interval.
     * @param epsilon The epsilon to use for equality testing.
     * @param dataComparer A function which compares the data of the two intervals. If omitted, reference equality is used.
     * @return true if they are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(TimeInterval right, double epsilon, DataComparer dataComparer);

    /**
     * Creates a string representing this TimeInterval in ISO8601 format.
     * @return A string representing this TimeInterval in ISO8601 format.
     */
    @JsMethod
    public native String toString();

    /**
     * Function interface for comparing interval data.
     */
    @JsFunction
    public interface DataComparer {
        /**
         * Function interface for comparing interval data.
         * @param leftData The first data instance.
         * @param rightData The second data instance.
         * @return true if the provided instances are equal, false otherwise.
         */
        boolean function(TimeInterval leftData, TimeInterval rightData);
    }

    /**
     * Function interface for merging interval data.
     */
    @JsFunction
    public interface MergeCallback {
        /**
         * Function interface for merging interval data.
         * @param leftData The first data instance.
         * @param rightData The second data instance.
         * @return The result of merging the two data instances.
         */
        Object function(TimeInterval leftData, TimeInterval rightData);
    }
}
