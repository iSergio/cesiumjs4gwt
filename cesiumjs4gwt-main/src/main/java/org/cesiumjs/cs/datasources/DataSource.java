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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.JulianDate;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "DataSource")
public interface DataSource {
    /**
     * Updates the data source to the provided time. This function is optional and is not required to be implemented.
     * It is provided for data sources which retrieve data based on the current animation time or scene state.
     * If implemented, update will be called by DataSourceDisplay once a frame.
     * @param time The simulation time.
     * @return True if this data source is ready to be displayed at the provided time, false otherwise.
     */
    @JsMethod
    boolean update(JulianDate time);
}
