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
import org.cesiumjs.cs.collections.EntityCollection;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.datasources.options.KmlDataSourceOptions;
import org.cesiumjs.cs.promise.Promise;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
//TODO: Examples, Blobs, Documents
@JsType(isNative = true, namespace = "Cesium", name = "KmlDataSource")
public class KmlDataSource implements DataSource {
    /**
     * Gets an event that will be raised when the underlying data changes.
     */
    @JsProperty
    public Event changedEvent;
    /**
     * Gets the clock settings defined by the loaded KML. This represents the total availability interval for all time-dynamic data.
     * If the KML does not contain time-dynamic data, this value is undefined.
     */
    @JsProperty
    public DataSourceClock clock;
    /**
     * Gets or sets the clustering options for this data source. This object can be shared between multiple data sources.
     */
    @JsProperty
    public EntityCluster clustering;
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
     * Gets a human-readable name for this instance. This will be automatically be set to the KML document name on load.
     */
    @JsProperty
    public String name;
    /**
     * Gets an event that will be raised when the data source refreshes a network link.
     */
    @JsProperty
    public Event refreshEvent;
    /**
     * Gets whether or not this data source should be displayed.
     */
    @JsProperty
    public boolean show;
    /**
     * Gets an event that will be raised when the data source finds an unsupported node type.
     */
    @JsProperty
    public Event unsupportedNodeEvent;

    /**
     * A DataSource which processes Keyhole Markup Language 2.2 (KML).
     * KML support in Cesium is incomplete, but a large amount of the standard, as well as Google's gx extension namespace,
     * is supported. See Github issue #873 for a detailed list of what is and isn't support.
     * Cesium will also write information to the console when it encounters most unsupported features.
     *
     * Non visual feature data, such as atom:author and ExtendedData is exposed via an instance of KmlFeatureData,
     * which is added to each Entity under the kml property.
     * @param options Options
     * @see <a href="http://www.opengeospatial.org/standards/kml/">Open Geospatial Consortium KML Standard</a>
     * @see <a href="https://developers.google.com/kml//">Google KML Documentation</a>
     */
    @JsConstructor
    public KmlDataSource(KmlDataSourceOptions options) {}

    /**
     * Creates a Promise to a new instance loaded with the provided KML data.
     * @param data A url containing binary KMZ data or a parsed KML document.
     * @param options {@link KmlDataSourceOptions}
     * @return A promise that will resolve to a new KmlDataSource instance once the KML is loaded.
     */
    public static native Promise<KmlDataSource, Void> load(String data, KmlDataSourceOptions options);

    @Override
    @JsMethod
    public native boolean update(JulianDate time);
}
