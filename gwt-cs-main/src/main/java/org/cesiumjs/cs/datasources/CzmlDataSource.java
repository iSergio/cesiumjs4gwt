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
import org.cesiumjs.cs.datasources.options.CzmlDataSourceOptions;
import org.cesiumjs.cs.promise.Promise;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CzmlDataSource")
public class CzmlDataSource {
    //TODO: Gets the array of CZML processing functions.
//    staticCesium.CzmlDataSource.updaters : Array DataSources/CzmlDataSource.js 1965
//    Gets the array of CZML processing functions.
    /**
     * Gets an event that will be raised when the underlying data changes.
     */
    @JsProperty
    public Event changedEvent;
    /**
     * Gets the clock settings defined by the loaded CZML. If no clock is explicitly defined in the CZML,
     * the combined availability of all objects is returned. If only static data exists, this value is undefined.
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
    public Boolean isLoading;
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
    public Boolean show;

    /**
     * A {@link DataSource} which processes <a hreh="https://github.com/AnalyticalGraphicsInc/cesium/wiki/CZML-Guide">CZML</a>.
     */
    @JsConstructor
    public CzmlDataSource() {}

    /**
     * A {@link DataSource} which processes <a hreh="https://github.com/AnalyticalGraphicsInc/cesium/wiki/CZML-Guide">CZML</a>.
     * @param name An optional name for the data source. This value will be overwritten if a loaded document contains a name.
     */
    @JsConstructor
    public CzmlDataSource(String name) {}

    /**
     * Creates a Promise to a new instance loaded with the provided CZML data.
     * @param data A url to be processed.
     * @return A promise that resolves to the new instance once the data is processed.
     */
    @JsMethod
    public static native Promise<CzmlDataSource, Void> load(String data);

    /**
     * Creates a Promise to a new instance loaded with the provided CZML data.
     * @param data A url to be processed.
     * @param options Options.
     * @return A promise that resolves to the new instance once the data is processed.
     */
    @JsMethod
    public static native Promise<CzmlDataSource, Void> load(String data, CzmlDataSourceOptions options);

    /**
     * Creates a Promise to a new instance loaded with the provided CZML data.
     * @param data CZML object to be processed.
     * @return A promise that resolves to the new instance once the data is processed.
     */
    @JsMethod
    public static native Promise<CzmlDataSource, Void> load(Object data);

    /**
     * Creates a Promise to a new instance loaded with the provided CZML data.
     * @param data CZML object to be processed.
     * @param options Options.
     * @return A promise that resolves to the new instance once the data is processed.
     */
    @JsMethod
    public static native Promise<CzmlDataSource, Void> load(Object data, CzmlDataSourceOptions options);

//    Name	Type	Description
//    data	String | Object	A url or CZML object to be processed.
//    options	Object	optional An object with the following properties:
//    Name	Type	Description
//    sourceUri	String	optional Overrides the url to use for resolving relative links.
//            Returns:
//    A promise that resolves to the new instance once the data is processed.
//
//
//            staticCesium.CzmlDataSource.processMaterialPacketData(object, propertyName, packetData, interval, sourceUri, entityCollection) DataSources/CzmlDataSource.js 2052
//    A helper function used by custom CZML updater functions which creates or updates a MaterialProperty from a CZML packet.
//    Name	Type	Description
//    object	Object	The object on which the property will be added or updated.
//    propertyName	String	The name of the property on the object.
//    packetData	Object	The CZML packet being processed.
//    interval	TimeInterval	A constraining interval for which the data is valid.
//    sourceUri	String	The originating uri of the data being processed.
//    entityCollection	EntityCollection	The collection being processsed.
//            staticCesium.CzmlDataSource.processPacketData(type, object, propertyName, packetData, interval, sourceUri, entityCollection) DataSources/CzmlDataSource.js 2024
//    A helper function used by custom CZML updater functions which creates or updates a Property from a CZML packet.
//    Name	Type	Description
//    type	function	The constructor function for the property being processed.
//    object	Object	The object on which the property will be added or updated.
//    propertyName	String	The name of the property on the object.
//    packetData	Object	The CZML packet being processed.
//    interval	TimeInterval	A constraining interval for which the data is valid.
//    sourceUri	String	The originating uri of the data being processed.
//    entityCollection	EntityCollection	The collection being processsed.
//            staticCesium.CzmlDataSource.processPositionPacketData(object, propertyName, packetData, interval, sourceUri, entityCollection) DataSources/CzmlDataSource.js 2038
//    A helper function used by custom CZML updater functions which creates or updates a PositionProperty from a CZML packet.
//    Name	Type	Description
//    object	Object	The object on which the property will be added or updated.
//    propertyName	String	The name of the property on the object.
//    packetData	Object	The CZML packet being processed.
//    interval	TimeInterval	A constraining interval for which the data is valid.
//    sourceUri	String	The originating uri of the data being processed.
//    entityCollection	EntityCollection	The collection being processsed.
//    load(czml, options) → Promise.<CzmlDataSource> DataSources/CzmlDataSource.js 2007
//    Loads the provided url or CZML object, replacing any existing data.
//    Name	Type	Description
//    czml	String | Object	A url or CZML object to be processed.
//    options	Object	optional An object with the following properties:
//    Name	Type	Description
//    sourceUri	String	optional Overrides the url to use for resolving relative links.
//            Returns:
//    A promise that resolves to this instances once the data is processed.

    /**
     * Processes the provided url or CZML object without clearing any existing data.
     * @param czml A url to be processed.
     * @return A promise that resolves to this instances once the data is processed.
     */
    @JsMethod
    public native Promise<CzmlDataSource, Void> process(String czml);

    /**
     * Processes the provided url or CZML object without clearing any existing data.
     * @param czml A url to be processed.
     * @param options {@link CzmlDataSourceOptions}
     * @return A promise that resolves to this instances once the data is processed.
     */
    @JsMethod
    public native Promise<CzmlDataSource, Void> process(String czml, CzmlDataSourceOptions options);

    /**
     * Processes the provided url or CZML object without clearing any existing data.
     * @param czml CZML object to be processed.
     * @return A promise that resolves to this instances once the data is processed.
     */
    @JsMethod
    public native Promise<CzmlDataSource, Void> process(Object czml);

    /**
     * Processes the provided url or CZML object without clearing any existing data.
     * @param czml CZML object to be processed.
     * @param options {@link CzmlDataSourceOptions}
     * @return A promise that resolves to this instances once the data is processed.
     */
    @JsMethod
    public native Promise<CzmlDataSource, Void> process(Object czml, CzmlDataSourceOptions options);
}
