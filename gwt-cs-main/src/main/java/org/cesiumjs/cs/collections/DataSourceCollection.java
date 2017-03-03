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
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.datasources.DataSource;
import org.cesiumjs.cs.promise.Promise;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "DataSourceCollection")
public class DataSourceCollection<T extends DataSource> extends Collection<DataSource> {
    /**
     * An event that is raised when a data source is added to the collection. Event handlers are passed the data source that was added.
     */
    @JsProperty(name = "dataSourceAdded")
    public native Event dataSourceAdded();
    /**
     * An event that is raised when a data source is removed from the collection. Event handlers are passed the data source that was removed.
     */
    @JsProperty(name = "dataSourceRemoved")
    public native Event dataSourceRemoved();

    @JsConstructor
    public DataSourceCollection() {}

    /**
     * Adds a data source to the collection.
     * @param dataSource A data source or a promise to a data source to add to the collection. When passing a promise,
     *                   the data source will not actually be added to the collection until the promise resolves successfully.
     */
    @JsMethod
    public native Promise<T, Void> add(Promise<T, Void> dataSource);

    /**
     * Adds a data source to the collection.
     * @param dataSource A data source or a promise to a data source to add to the collection. When passing a promise,
     *                   the data source will not actually be added to the collection until the promise resolves successfully.
     */
    @JsMethod
    public native Promise<T, Void> add(T dataSource);

    /**
     * Determines the index of a given data source in the collection.
     * @param dataSource The data source to find the index of.
     * @return The index of the data source in the collection, or -1 if the data source does not exist in the collection.
     */
    @JsMethod
    public native int indexOf(T dataSource);

    /**
     * Removes a data source from this collection, if present.
     * @param dataSource The data source to remove.
     * @param destroy Whether to destroy the data source in addition to removing it. Default: false
     * @return true if the data source was in the collection and was removed, false if the data source was not in the collection.
     */
    @JsMethod
    public native boolean remove(T dataSource, boolean destroy);

    /**
     * Removes all data sources from this collection.
     * @param destroy whether to destroy the data sources in addition to removing them. Default: false
     */
    @JsMethod
    public native void removeAll(boolean destroy);
}
