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
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Ellipsoid;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "GeographicProjection")
public class GeographicProjection extends MapProjection {
    @JsConstructor
    public GeographicProjection() {}

    /**
     * A simple map projection where longitude and latitude are linearly mapped to X and Y by multiplying them by the
     * {@link Ellipsoid#maximumRadius}. This projection is commonly known as geographic, equirectangular,
     * equidistant cylindrical, or plate carrée. It is also known as EPSG:4326.
     * @param ellipsoid The ellipsoid. Default: {@link Ellipsoid#WGS84()}
     * @see WebMercatorProjection
     */
    @JsConstructor
    public GeographicProjection(Ellipsoid ellipsoid) {}
}
