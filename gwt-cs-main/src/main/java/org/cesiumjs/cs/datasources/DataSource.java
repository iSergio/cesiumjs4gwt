/*
 * Copyright 2016 iserge.
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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "DataSource")
public interface DataSource {
//    /**
//     * Gets an event that will be raised when the underlying data changes.
//     */
//    @JsProperty
//    public Event changedEvent;
//    /**
//     * Gets the preferred clock settings for this data source.
//     */
//    @JsProperty
//    public DataSourceClock clock;
//    /**
//     * Gets or sets the clustering options for this data source. This object can be shared between multiple data sources.
//     */
//    @JsProperty
//    public EntityCluster clustering;
//    /**
//     * Gets the collection of Entity instances.
//     */
//    @JsProperty
//    public EntityCollection entities;
//    /**
//     * Gets an event that will be raised if an error is encountered during processing.
//     */
//    @JsProperty
//    public Event errorEvent;
//    /**
//     * Gets a value indicating if the data source is currently loading data.
//     */
//    @JsProperty
//    public boolean isLoading;
//    /**
//     * Gets an event that will be raised when the value of isLoading changes.
//     */
//    @JsProperty
//    public Event loadingEvent;
//    /**
//     * Gets a human-readable name for this instance.
//     */
//    @JsProperty
//    public String name;
//    /**
//     * Gets whether or not this data source should be displayed.
//     */
//    @JsProperty
//    public boolean show;
//
//    /**
//     * Defines the interface for data sources, which turn arbitrary data into a EntityCollection for generic consumption.
//     * This object is an interface for documentation purposes and is not intended to be instantiated directly.
//     */
//    @JsConstructor
//    public DataSource() {}
//
//    /**
//     * Updates the data source to the provided time. This function is optional and is not required to be implemented.
//     * It is provided for data sources which retrieve data based on the current animation time or scene state.
//     * If implemented, update will be called by DataSourceDisplay once a frame.
//     * @param time The simulation time.
//     * @return True if this data source is ready to be displayed at the provided time, false otherwise.
//     */
//    public native boolean update(JulianDate time);
}
