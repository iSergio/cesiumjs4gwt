/*
 * Copyright 2018 iserge.
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
import org.cesiumjs.cs.core.Ellipsoid;

/**
 * The map projection used by Google Maps, Bing Maps, and most of ArcGIS Online, EPSG:3857. This projection use
 * longitude and latitude expressed with the WGS84 and transforms them to Mercator
 * using the spherical (rather than ellipsoidal) equations.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "WebMercatorProjection")
public class WebMercatorProjection extends MapProjection {
    /**
     * The maximum latitude (both North and South) supported by a Web Mercator (EPSG:3857) projection. Technically,
     * the Mercator projection is defined for any latitude up to (but not including) 90 degrees, but it makes sense
     * to cut it off sooner because it grows exponentially with increasing latitude. The logic behind this particular
     * cutoff value, which is the one used by Google Maps, Bing Maps, and Esri, is that it makes the projection square.
     * That is, the rectangle is equal in the X and Y directions.
     * The constant value is computed by calling: {@link #mercatorAngleToGeodeticLatitude(double)}
     */
    @JsProperty(name = "MaximumLatitude")
    public static native double MaximumLatitude();
    /**
     * Gets the Ellipsoid.
     */
    @JsProperty(name = "ellipsoid")
    public native Ellipsoid ellipsoid();

    /**
     * The map projection used by Google Maps, Bing Maps, and most of ArcGIS Online, EPSG:3857. This projection use
     * longitude and latitude expressed with the WGS84 and transforms them to Mercator using the spherical
     * (rather than ellipsoidal) equations.
     * @see GeographicProjection
     */
    @JsConstructor
    public WebMercatorProjection() {}

    /**
     * The map projection used by Google Maps, Bing Maps, and most of ArcGIS Online, EPSG:3857. This projection use
     * longitude and latitude expressed with the WGS84 and transforms them to Mercator using the spherical
     * (rather than ellipsoidal) equations.
     * @param ellipsoid The ellipsoid.
     * @see GeographicProjection
     */
    @JsConstructor
    public WebMercatorProjection(Ellipsoid ellipsoid) {}

    /**
     * Converts a geodetic latitude in radians, in the range -PI/2 to PI/2, to a Mercator angle in the range -PI to PI.
     * @param latitude The geodetic latitude in radians.
     * @return The Mercator angle.
     */
    @JsMethod
    public static native double geodeticLatitudeToMercatorAngle(double latitude);

    /**
     * Converts a Mercator angle, in the range -PI to PI, to a geodetic latitude in the range -PI/2 to PI/2.
     * @param mercatorAngle The angle to convert.
     * @return The geodetic latitude in radians.
     */
    @JsMethod
    public static native double mercatorAngleToGeodeticLatitude(double mercatorAngle);
}
