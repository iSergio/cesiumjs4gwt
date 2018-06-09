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

import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.EntityCollection;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CustomDataSource")
public class CustomDataSource implements DataSource {
    /**
     * Gets an event that will be raised when the underlying data changes.
     */
    @JsProperty
    public Event changedEvent;
    /**
     * Gets or sets the clock for this instance.
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
     * Gets or sets whether the data source is currently loading data.
     */
    @JsProperty
    public boolean isLoading;
    /**
     * Gets an event that will be raised when the data source either starts or stops loading.
     */
    @JsProperty
    public Event loadingEvent;
    /**
     * Gets or sets a human-readable name for this instance.
     */
    @JsProperty
    public String name;
    /**
     * Gets whether or not this data source should be displayed.
     */
    @JsProperty
    public boolean show;

    /**
     * A {@link DataSource} implementation which can be used to manually manage a group of entities.
     * <pre>
     *     Example:
     *     {@code
     *     DataSource dataSource = new CustomDataSource("myData");
     *     BillboardGraphicsOptions options = new BillboardGraphicsOptions();
     *     options.image = "image.png";
     *     EntityOptions entityOptions = new EntityOptions();
     *     entityOptions.billboard = new BillboardGraphics(options);
     *     Entity entity = dataSource.entities().add(new Entity(entityOptions));
     *     viewer.dataSources.add(dataSource);
     *     }
     * </pre>
     */
    @JsConstructor
    public CustomDataSource() {}

    /**
     * A {@link DataSource} implementation which can be used to manually manage a group of entities.
     * <pre>
     *     Example:
     *     {@code
     *     DataSource dataSource = new CustomDataSource("myData");
     *     BillboardGraphicsOptions options = new BillboardGraphicsOptions();
     *     options.image = "image.png";
     *     EntityOptions entityOptions = new EntityOptions();
     *     entityOptions.billboard = new BillboardGraphics(options);
     *     Entity entity = dataSource.entities().add(new Entity(entityOptions));
     *     viewer.dataSources.add(dataSource);
     *     }
     * </pre>
     * @param name A human-readable name for this instance.
     */
    @JsConstructor
    public CustomDataSource(String name) {}

    @Override
    @JsMethod
    @JsIgnore
    public native boolean update(JulianDate time);
}
