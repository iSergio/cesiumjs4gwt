/*
 * Copyright 2022 iSergio, Gis4Fun.
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

import com.google.gwt.dom.client.Document;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.EntityCollection;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.datasources.options.GpxDataSourceOptions;
import org.cesiumjs.cs.js.JsBlob;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;

/**
 * A {@link DataSource} which processes the GPS Exchange Format (GPX).
 */
@JsType(isNative = true, namespace = "Cesium", name = "GpxDataSource")
public class GpxDataSource implements DataSource {
    /**
     * Gets an event that will be raised when the underlying data changes.
     */
    @JsProperty
    public Event changedEvent;
    /**
     * Gets the clock settings defined by the loaded GPX. This represents the total availability interval for all
     * time-dynamic data. If the GPX does not contain time-dynamic data, this value is undefined.
     */
    @JsProperty
    public DataSourceClock clock;
    /**
     * Gets or sets the clustering options for this data source.
     * This object can be shared between multiple data sources.
     */
    @JsProperty
    public EntityCluster clustering;
    /**
     * Gets the creator of the GPX document.
     */
    @JsProperty
    public String creator;
    /**
     * Gets the collection of Entity instances.
     */
    @JsProperty
    public EntityCollection entities;
    /**
     * Gets an event that will be raised if an error is encountered during processing.
     */
    @JsProperty
    public Event errorEvent;
    /**
     * Gets a value indicating if the data source is currently loading data.
     */
    @JsProperty
    public boolean isLoading;
    /**
     * Gets an event that will be raised when the data source either starts or stops loading.
     */
    @JsProperty
    public Event loadingEvent;
    /**
     * Gets an object containing metadata about the GPX file.
     */
    @JsProperty
    public JsObject metadata;
    /**
     * Gets a human-readable name for this instance. This will be automatically be set to the GPX document name on load.
     */
    @JsProperty
    public String name;
    /**
     * Gets whether or not this data source should be displayed.
     */
    @JsProperty
    public boolean show;
    /**
     * Gets the version of the GPX Schema in use.
     */
    @JsProperty
    public String version;

    @Override
    @JsMethod
    public native boolean update(JulianDate time);

    /**
     * Creates a Promise to a new instance loaded with the provided GPX data.
     * @param data A url containing binary GPX data
     * @return promise
     */
    @JsMethod
    public static native Promise<GpxDataSource, Void> load(String data);

    /**
     * Creates a Promise to a new instance loaded with the provided GPX data.
     * @param data A url containing binary GPX data
     * @param options {@link GpxDataSourceOptions}
     * @return promise
     */
    @JsMethod
    public static native Promise<GpxDataSource, Void> load(String data, GpxDataSourceOptions options);

//    /**
//     * Creates a Promise to a new instance loaded with the provided GPX data.
//     * @param data parsed GPX document GPX data
//     * @return promise
//     */
//    @JsMethod
//    public static native Promise<GpxDataSource, Void> load(Document data);
//
//    /**
//     * Creates a Promise to a new instance loaded with the provided GPX data.
//     * @param data parsed GPX document GPX data
//     * @param options {@link GpxDataSourceOptions}
//     * @return promise
//     */
//    @JsMethod
//    public static native Promise<GpxDataSource, Void> load(Document data, GpxDataSourceOptions options);

    /**
     * Creates a Promise to a new instance loaded with the provided GPX data.
     * @param data Blob containing binary GPX data
     * @return promise
     */
    @JsMethod
    public static native Promise<GpxDataSource, Void> load(JsBlob data);

    /**
     * Creates a Promise to a new instance loaded with the provided GPX data.
     * @param data Blob containing binary GPX data
     * @param options {@link GpxDataSourceOptions}
     * @return promise
     */
    @JsMethod
    public static native Promise<GpxDataSource, Void> load(JsBlob data, GpxDataSourceOptions options);

}
