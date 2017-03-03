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

import com.google.gwt.json.client.JSONObject;
import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.EntityCollection;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.datasources.options.GeoJsonDataSourceOptions;
import org.cesiumjs.cs.promise.Promise;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "GeoJsonDataSource")
public class GeoJsonDataSource implements DataSource {
    /**
     * Gets or sets default of whether to clamp to the ground.
     * Default: false
     */
    @JsProperty
    public static boolean clampToGround;
    /**
     * Gets an object that maps the href property of a crs link to a callback function which takes the crs properties
     * object and returns a Promise that resolves to a function that takes a GeoJSON coordinate and transforms it into a
     * WGS84 Earth-fixed Cartesian. Items in this object take precedence over those defined in crsLinkHrefs, assuming
     * the link has a type specified.
     */
    @JsProperty
    public static Object crsLinkHrefs;
    /**
     * Gets an object that maps the type property of a crs link to a callback function which takes the crs properties
     * object and returns a Promise that resolves to a function that takes a GeoJSON coordinate and transforms it into a
     * WGS84 Earth-fixed Cartesian. Items in crsLinkHrefs take precedence over this object.
     */
    @JsProperty
    public static Object crsLinkTypes;
    /**
     * Gets an object that maps the name of a crs to a callback function which takes a GeoJSON coordinate and transforms
     * it into a WGS84 Earth-fixed Cartesian. Older versions of GeoJSON which supported the EPSG type can be added
     * to this list as well, by specifying the complete EPSG name, for example 'EPSG:4326'.
     */
    @JsProperty
    public static Object crsNames;
    /**
     * Gets or sets default color for polygon interiors.
     * Default: {@link Color#YELLOW()}
     */
    @JsProperty
    public static Color fill;
    /**
     * Gets or sets the default color of the map pin created for each point.
     * Default: {@link Color#ROYALBLUE()}
     */
    @JsProperty
    public static Color markerColor;
    /**
     * Gets or sets the default size of the map pin created for each point, in pixels.
     * Deafult: 48
     */
    @JsProperty
    public static int markerSize;
    /**
     * Gets or sets the default symbol of the map pin created for each point.
     * This can be any valid Maki identifier, any single character, or blank if no symbol is to be used.
     */
    @JsProperty
    public static String markerSymbol;
    /**
     * Gets or sets the default color of polylines and polygon outlines.
     * Default: {@link Color#BLACK()}
     */
    @JsProperty
    public static Color stroke;
    /**
     * Gets or sets the default width of polylines and polygon outlines.
     * Default: 2.0
     */
    @JsProperty
    public static double strokeWidth;
    /**
     * Gets an event that will be raised when the underlying data changes.
     */
    @JsProperty
    public Event changedEvent;
    /**
     * This DataSource only defines static data, therefore this property is always undefined.
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
     * Gets a human-readable name for this instance.
     */
    @JsProperty
    public String name;
    /**
     * Gets whether or not this data source should be displayed.
     */
    @JsProperty
    public boolean show;

    /**
     * A {@link DataSource} which processes both <a href="http://www.geojson.org/">GeoJSON</a> and <a href="https://github.com/mbostock/topojson">TopoJSON</a> data.
     * <a href="https://github.com/mapbox/simplestyle-spec">simplestyle-spec</a> properties will also be used if they are present.
     */
    @JsConstructor
    public GeoJsonDataSource() {}

    /**
     * A {@link DataSource} which processes both <a href="http://www.geojson.org/">GeoJSON</a> and <a href="https://github.com/mbostock/topojson">TopoJSON</a> data.
     * <a href="https://github.com/mapbox/simplestyle-spec">simplestyle-spec</a> properties will also be used if they are present.
     * @param name The name of this data source. If undefined, a name will be taken from the name of the GeoJSON file.
     */
    @JsConstructor
    public GeoJsonDataSource(String name) {}

    /**
     * Creates a Promise to a new instance loaded with the provided GeoJSON or TopoJSON data.
     * @param data A url, GeoJSON object, or TopoJSON object to be loaded.
     * @return A promise that will resolve when the data is loaded.
     */
    @JsMethod
    public static native Promise<GeoJsonDataSource, String> load(JSONObject data);

    /**
     * Creates a Promise to a new instance loaded with the provided GeoJSON or TopoJSON data.
     * @param data A url, GeoJSON object, or TopoJSON object to be loaded.
     * @return A promise that will resolve when the data is loaded.
     */
    @JsMethod
    public static native Promise<GeoJsonDataSource, String> load(String data);

    /**
     * Creates a Promise to a new instance loaded with the provided GeoJSON or TopoJSON data.
     * @param data A url, GeoJSON object, or TopoJSON object to be loaded.
     * @param options Options
     * @return A promise that will resolve when the data is loaded.
     */
    @JsMethod
    public static native Promise<GeoJsonDataSource, String> load(JSONObject data, GeoJsonDataSourceOptions options);

    /**
     * Creates a Promise to a new instance loaded with the provided GeoJSON or TopoJSON data.
     * @param data A url, GeoJSON object, or TopoJSON object to be loaded.
     * @param options Options
     * @return A promise that will resolve when the data is loaded.
     */
    @JsMethod
    public static native Promise<GeoJsonDataSource, String> load(String data, GeoJsonDataSourceOptions options);

    @Override
    @JsMethod
    @JsIgnore
    public native boolean update(JulianDate time);

    /**
     * This callback is displayed as part of the GeoJsonDataSource class.
     */
    @JsFunction
    public interface discribe {
        /**
         * This callback is displayed as part of the GeoJsonDataSource class.
         * @param properties The properties of the feature.
         * @param nameProperty The property key that Cesium estimates to have the name of the feature.
         */
        void function(Object properties, String nameProperty);
    }
}
