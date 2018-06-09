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

package org.cesiumjs.cs.datasources;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Clock;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.enums.ClockRange;
import org.cesiumjs.cs.core.enums.ClockStep;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "DataSourceClock")
public class DataSourceClock {
    /**
     * Gets or sets the desired clock range setting. See {@link org.cesiumjs.cs.core.Clock#clockRange}.
     */
    @JsProperty
    public ClockRange clockRange;
    /**
     * Gets or sets the desired clock step setting. See {@link org.cesiumjs.cs.core.Clock#clockStep}.
     */
    @JsProperty
    public ClockStep clockStep;
    /**
     * Gets or sets the desired current time when this data source is loaded. See {@link org.cesiumjs.cs.core.Clock#currentTime}.
     */
    @JsProperty
    public JulianDate currentTime;
    /**
     * Gets the event that is raised whenever a new property is assigned.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * Gets or sets the desired clock multiplier. See {@link org.cesiumjs.cs.core.Clock#multiplier}.
     */
    @JsProperty
    public int multiplier;
    /**
     * Gets or sets the desired start time of the clock. See {@link org.cesiumjs.cs.core.Clock#startTime}.
     */
    @JsProperty
    public JulianDate startTime;
    /**
     * Gets or sets the desired stop time of the clock. See {@link org.cesiumjs.cs.core.Clock#stopTime}.
     */
    @JsProperty
    public JulianDate stopTime;

    /**
     * Represents desired clock settings for a particular DataSource. These settings may be applied to the Clock when the
     * {@link DataSource} is loaded.
     */
    @JsConstructor
    public DataSourceClock() {}

    /**
     * Duplicates a DataSourceClock instance.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    @JsMethod
    public native DataSourceClock clone();

    /**
     * Duplicates a DataSourceClock instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    @JsMethod
    public native DataSourceClock clone(DataSourceClock result);

    /**
     * Returns true if this DataSourceClock is equivalent to the other
     * @param other The other DataSourceClock to compare to.
     * @return true if the DataSourceClocks are equal; otherwise, false.
     */
    @JsMethod
    public native boolean equals(DataSourceClock other);

    /**
     * Gets the value of this clock instance as a Clock object.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    @JsMethod
    public native Clock getValue();

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    @JsMethod
    public native void merge(DataSourceClock source);
}
