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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Initializes a geodesic on the ellipsoid connecting the two provided planetodetic points.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "EllipsoidGeodesic")
public class EllipsoidGeodesic {
    /**
     * Gets the ellipsoid.
     */
    @JsProperty(name = "ellipsoid")
    public native Ellipsoid ellipsoid();
    /**
     * Gets the final planetodetic point on the path.
     */
    @JsProperty(name = "end")
    public native Cartographic end();
    /**
     * Gets the heading at the final point.
     */
    @JsProperty(name = "endHeading")
    public native double endHeading();
    /**
     * Gets the initial planetodetic point on the path.
     */
    @JsProperty(name = "start")
    public native Cartographic start();
    /**
     * Gets the heading at the initial point.
     */
    @JsProperty(name = "startHeading")
    public native double startHeading();
    /**
     * Gets the surface distance between the start and end point
     */
    @JsProperty(name = "surfaceDistance")
    public native double surfaceDistance();

    /**
     * Initializes a geodesic on the ellipsoid connecting the two provided planetodetic points.
     */
    @JsConstructor
    public EllipsoidGeodesic() {}

    /**
     * Initializes a geodesic on the ellipsoid connecting the two provided planetodetic points.
     * @param start The initial planetodetic point on the path.
     */
    @JsConstructor
    public EllipsoidGeodesic(Cartographic start) {}

    /**
     * Initializes a geodesic on the ellipsoid connecting the two provided planetodetic points.
     * @param start The initial planetodetic point on the path.
     * @param end The final planetodetic point on the path.
     */
    @JsConstructor
    public EllipsoidGeodesic(Cartographic start, Cartographic end) {}

    /**
     * Initializes a geodesic on the ellipsoid connecting the two provided planetodetic points.
     * @param start The initial planetodetic point on the path.
     * @param end The final planetodetic point on the path.
     * @param ellipsoid The ellipsoid on which the geodesic lies. Default: {@link Ellipsoid#WGS84()}
     */
    @JsConstructor
    public EllipsoidGeodesic(Cartographic start, Cartographic end, Ellipsoid ellipsoid) {}

    /**
     * Provides the location of a point at the indicated portion along the geodesic.
     * @param fraction The portion of the distance between the initial and final points.
     * @param result The object in which to store the result.
     * @return The location of the point along the geodesic.
     */
    @JsMethod
    public native Cartographic interpolateUsingFraction(double fraction, Cartographic result);

    /**
     * Provides the location of a point at the indicated distance along the geodesic.
     * @param distance The distance from the inital point to the point of interest along the geodesic
     * @param result The object in which to store the result.
     * @return The location of the point along the geodesic.
     */
    @JsMethod
    public native Cartographic interpolateUsingSurfaceDistance(double distance, Cartographic result);

    /**
     * Sets the start and end points of the geodesic
     * @param start The initial planetodetic point on the path.
     * @param end The final planetodetic point on the path.
     */
    @JsMethod
    public native void setEndPoints(Cartographic start, Cartographic end);
}
