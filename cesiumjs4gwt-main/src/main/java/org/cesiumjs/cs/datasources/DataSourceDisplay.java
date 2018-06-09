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
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.DataSourceCollection;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.datasources.options.DataSourceDisplayOptions;
import org.cesiumjs.cs.datasources.visualizer.Visualizer;
import org.cesiumjs.cs.scene.Scene;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "DataSourceDisplay")
public class DataSourceDisplay implements DataSource {
    /**
     * Gets or sets the default function which creates an array of visualizers used for visualization.
     * By default, this function uses all standard visualizers.
     */
    @JsProperty(name = "defaultVisualizersCallback")
    public static native VisualizersCallback defaultVisualizersCallback();
    /**
     * Gets the collection of data sources to display.
     */
    @JsProperty
    public DataSourceCollection dataSources;
    /**
     * Gets the default data source instance which can be used to manually create and visualize entities not tied to a specific data source.
     * This instance is always available and does not appear in the list dataSources collection.
     */
    @JsProperty
    public CustomDataSource defaultDataSource;
    /**
     * Gets a value indicating whether or not all entities in the data source are ready
     */
    @JsProperty(name = "ready")
    public static native boolean ready();
    /**
     * Gets the scene associated with this display.
     */
    @JsProperty
    public Scene scene;

    /**
     * Visualizes a collection of DataSource instances.
     * @param options Options
     */
    @JsConstructor
    public DataSourceDisplay(DataSourceDisplayOptions options) {}

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed()
     */
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception.
     * @return True if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    public native boolean isDestroyed();

    /**
     * Updates the display to the provided time.
     * @param time The simulation time.
     * @return True if all data sources are ready to be displayed, false otherwise.
     */
    @Override
    public native boolean update(JulianDate time);

    @JsFunction
    public interface VisualizersCallback {
        Visualizer[] function(Scene scene, DataSource dataSource);
    }
}
