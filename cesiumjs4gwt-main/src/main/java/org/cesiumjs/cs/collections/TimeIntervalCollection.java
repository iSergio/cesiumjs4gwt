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

package org.cesiumjs.cs.collections;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.options.FromIso8601DateArrayOptions;
import org.cesiumjs.cs.collections.options.FromIso8601DurationArrayOptions;
import org.cesiumjs.cs.collections.options.FromIso8601Options;
import org.cesiumjs.cs.collections.options.FromJulianDateArrayOptions;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.TimeInterval;
import org.cesiumjs.cs.core.options.TimeIntervalOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TimeIntervalCollection")
public class TimeIntervalCollection {
    /**
     * Gets an event that is raised whenever the collection of intervals change.
     */
    @JsProperty(name = "changedEvent")
    public native Event changedEvent();
    /**
     * Gets whether or not the collection is empty.
     */
    @JsProperty(name = "isEmpty")
    public native boolean isEmpty();
    /**
     * Gets whether or not the start time is included in the collection.
     */
    @JsProperty(name = "isStartIncluded")
    public native boolean isStartIncluded();
    /**
     * Gets whether or not the stop time is included in the collection.
     */
    @JsProperty(name = "isStopIncluded")
    public native boolean isStopIncluded();
    /**
     * Gets the number of intervals in the collection.
     */
    @JsProperty(name = "length")
    public native int length();
    /**
     * Gets the start time of the collection.
     */
    @JsProperty(name = "start")
    public native JulianDate start();
    /**
     * Gets the stop time of the collection.
     */
    @JsProperty(name = "stop")
    public native JulianDate stop();

    /**
     * A non-overlapping collection of {@link TimeInterval} instances sorted by start time.
     */
    @JsConstructor
    public TimeIntervalCollection() {}

    /**
     * A non-overlapping collection of {@link TimeInterval} instances sorted by start time.
     * @param intervals An array of intervals to add to the collection.
     */
    @JsConstructor
    public TimeIntervalCollection(TimeInterval[] intervals) {}

    /**
     * Creates a new instance from an ISO 8601 time interval (start/end/duration).
     * @param options {@link FromIso8601Options}
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeIntervalCollection fromIso8601(FromIso8601Options options);

    /**
     * Creates a new instance from an ISO 8601 time interval (start/end/duration).
     * @param options {@link FromIso8601Options}
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeIntervalCollection fromIso8601(FromIso8601Options options, TimeIntervalCollection result);

    /**
     * Creates a new instance from a ISO 8601 date array.
     * @param options {@link FromIso8601DateArrayOptions}
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeIntervalCollection fromIso8601DateArray(FromIso8601DateArrayOptions options);

    /**
     * Creates a new instance from a ISO 8601 date array.
     * @param options {@link FromIso8601DateArrayOptions}
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeIntervalCollection fromIso8601DateArray(FromIso8601DateArrayOptions options, TimeIntervalCollection result);

    /**
     * Creates a new instance from a ISO 8601 duration array.
     * @param options {@link FromIso8601DurationArrayOptions}
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeIntervalCollection fromIso8601DurationArray(FromIso8601DurationArrayOptions options);

    /**
     * Creates a new instance from a ISO 8601 duration array.
     * @param options {@link FromIso8601DurationArrayOptions}
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeIntervalCollection fromIso8601DurationArray(FromIso8601DurationArrayOptions options, TimeIntervalCollection result);

    /**
     * Creates a new instance from a JulianDate array.
     * @param options {@link FromJulianDateArrayOptions}.
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeIntervalCollection fromJulianDateArray(FromJulianDateArrayOptions options);

    /**
     * Creates a new instance from a JulianDate array.
     * @param options {@link FromJulianDateArrayOptions}.
     * @param result An existing instance to use for the result.
     * @return The modified result parameter or a new instance if none was provided.
     */
    @JsMethod
    public static native TimeIntervalCollection fromJulianDateArray(FromJulianDateArrayOptions options, TimeIntervalCollection result);

    /**
     * Adds an interval to the collection, merging intervals that contain the same data and splitting intervals of
     * different data as needed in order to maintain a non-overlapping collection. The data in the new interval takes
     * precedence over any existing intervals in the collection.
     * @param interval The interval to add.
     */
    @JsMethod
    public native void addInterval(TimeInterval interval);

    /**
     * Adds an interval to the collection, merging intervals that contain the same data and splitting intervals of
     * different data as needed in order to maintain a non-overlapping collection. The data in the new interval takes
     * precedence over any existing intervals in the collection.
     * @param interval The interval to add.
     * @param dataComparer A function which compares the data of the two intervals. If omitted, reference equality is used.
     */
    @JsMethod
    public native void addInterval(TimeInterval interval, TimeInterval.DataComparer dataComparer);

    /**
     * Checks if the specified date is inside this collection.
     * @param julianDate The date to check.
     * @return true if the collection contains the specified date, false otherwise.
     */
    @JsMethod
    public native boolean contains(JulianDate julianDate);

    /**
     * Compares this instance against the provided instance componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side collection.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(TimeIntervalCollection right);

    /**
     * Compares this instance against the provided instance componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side collection.
     * @param dataComparer A function which compares the data of the two intervals. If omitted, reference equality is used.
     * @return true if they are equal, false otherwise.
     */
    public native boolean equals(TimeIntervalCollection right, TimeInterval.DataComparer dataComparer);

    /**
     * Finds and returns the data for the interval that contains the specified date.
     * @param date The date to search for.
     * @return The data for the interval containing the specified date, or undefined if no such interval exists.
     */
    @JsMethod
    public native Object findDataForIntervalContainingDate(JulianDate date);

    /**
     * Returns the first interval in the collection that matches the specified parameters.
     * All parameters are optional and undefined parameters are treated as a don't care condition.
     * @return The first interval in the collection that matches the specified parameters.
     */
    @JsMethod
    public native TimeInterval findInterval();

    /**
     * Returns the first interval in the collection that matches the specified parameters.
     * All parameters are optional and undefined parameters are treated as a don't care condition.
     * @param options {@link TimeIntervalOptions}
     * @return The first interval in the collection that matches the specified parameters.
     */
    @JsMethod
    public native TimeInterval findInterval(TimeIntervalOptions options);

    /**
     * The date to search for.
     * @param date The date to search for.
     * @return The interval containing the specified date, undefined if no such interval exists.
     */
    @JsMethod
    public native TimeInterval findIntervalContainingDate(JulianDate date);

    /**
     * Gets the interval at the specified index.
     * @param index The index of the interval to retrieve.
     * @return The interval at the specified index, or undefined if no interval exists as that index.
     */
    @JsMethod
    public native TimeInterval get(int index);

    /**
     * Finds and returns the index of the interval in the collection that contains the specified date.
     * @param date The date to search for.
     * @return The index of the interval that contains the specified date, if no such interval exists,
     * it returns a negative number which is the bitwise complement of the index of the next interval that starts after
     * the date, or if no interval starts after the specified date, the bitwise complement of the length of the collection.
     */
    @JsMethod
    public native int indexOf(JulianDate date);

    /**
     * Creates a new instance that is the intersection of this collection and the provided collection.
     * @param other The collection to intersect with.
     * @return A new TimeIntervalCollection which is the intersection of this collection and the provided collection.
     */
    @JsMethod
    public native TimeIntervalCollection intersect(TimeIntervalCollection other);

    /**
     * Creates a new instance that is the intersection of this collection and the provided collection.
     * @param other The collection to intersect with.
     * @param dataComparer A function which compares the data of the two intervals. If omitted, reference equality is used.
     * @return A new TimeIntervalCollection which is the intersection of this collection and the provided collection.
     */
    @JsMethod
    public native TimeIntervalCollection intersect(TimeIntervalCollection other, TimeInterval.DataComparer dataComparer);

    /**
     * Creates a new instance that is the intersection of this collection and the provided collection.
     * @param other The collection to intersect with.
     * @param dataComparer A function which compares the data of the two intervals. If omitted, reference equality is used.
     * @param mergeCallback A function which merges the data of the two intervals. If omitted, the data from the left interval will be used.
     * @return A new TimeIntervalCollection which is the intersection of this collection and the provided collection.
     */
    @JsMethod
    public native TimeIntervalCollection intersect(TimeIntervalCollection other, TimeInterval.DataComparer dataComparer, TimeInterval.MergeCallback mergeCallback);

    /**
     * Removes all intervals from the collection.
     */
    @JsMethod
    public native void removeAll();

    /**
     * Removes the specified interval from this interval collection, creating a hole over the specified interval.
     * The data property of the input interval is ignored.
     * @param interval true if the interval was removed, false if no part of the interval was in the collection.
     */
    @JsMethod
    public native void removeInterval(TimeInterval interval);
}
