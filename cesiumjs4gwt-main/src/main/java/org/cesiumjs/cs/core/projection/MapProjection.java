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

package org.cesiumjs.cs.core.projection;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Cartographic;
import org.cesiumjs.cs.core.Ellipsoid;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "MapProjection")
public class MapProjection {
    /**
     * Gets the Ellipsoid.
     */
    @JsProperty(name = "ellipsoid")
    public native Ellipsoid ellipsoid();
    /**
     * Defines how geodetic ellipsoid coordinates (Cartographic) project to a flat map like Cesium's 2D and Columbus View modes.
     * @see GeographicProjection
     * @see WebMercatorProjection
     */
    @JsConstructor
    public MapProjection() {}

    /**
     * Projects Cartographic coordinates, in radians, to projection-specific map coordinates, in meters.
     * @param cartographic The coordinates to project.
     * @return The projected coordinates. If the result parameter is not undefined, the coordinates are copied there and that instance is returned.
     * Otherwise, a new instance is created and returned.
     */
    @JsMethod
    public native Cartesian3 project(Cartographic cartographic);

    /**
     * Projects Cartographic coordinates, in radians, to projection-specific map coordinates, in meters.
     * @param cartographic The coordinates to project.
     * @param result An instance into which to copy the result. If this parameter is undefined, a new instance is created and returned.
     * @return The projected coordinates. If the result parameter is not undefined, the coordinates are copied there and that instance is returned.
     * Otherwise, a new instance is created and returned.
     */
    @JsMethod
    public native Cartesian3 project(Cartographic cartographic, Cartesian3 result);

    /**
     * Unprojects projection-specific map Cartesian3 coordinates, in meters, to Cartographic coordinates, in radians.
     * @param cartesian The Cartesian position to unproject with height (z) in meters.
     * @return The unprojected coordinates. If the result parameter is not undefined, the coordinates are copied there and that instance is returned. Otherwise, a new instance is created and returned.
     */
    @JsMethod
    public native Cartographic unproject(Cartesian3 cartesian);

    /**
     * Unprojects projection-specific map Cartesian3 coordinates, in meters, to Cartographic coordinates, in radians.
     * @param cartesian The Cartesian position to unproject with height (z) in meters.
     * @param result An instance into which to copy the result. If this parameter is undefined, a new instance is created and returned.
     * @return The unprojected coordinates. If the result parameter is not undefined, the coordinates are copied there and that instance is returned. Otherwise, a new instance is created and returned.
     */
    @JsMethod
    public native Cartographic unproject(Cartesian3 cartesian, Cartographic result);
}
