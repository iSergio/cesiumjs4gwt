/*
 * Copyright 2019 iserge.
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
 * Initializes a rhumb line on the ellipsoid connecting the two provided
 * planetodetic points.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "EllipsoidRhumbLine")
public class EllipsoidRhumbLine {
    /**
     * Initializes a rhumb line on the ellipsoid connecting the two provided
     * planetodetic points.
     */
    @JsConstructor
    public EllipsoidRhumbLine() {
    }

    /**
     * Initializes a rhumb line on the ellipsoid connecting the two provided
     * planetodetic points.
     *
     * @param start The initial planetodetic point on the path.
     */
    @JsConstructor
    public EllipsoidRhumbLine(Cartographic start) {
    }

    /**
     * Initializes a rhumb line on the ellipsoid connecting the two provided
     * planetodetic points.
     *
     * @param start The initial planetodetic point on the path.
     * @param end   The final planetodetic point on the path.
     */
    @JsConstructor
    public EllipsoidRhumbLine(Cartographic start, Cartographic end) {
    }

    /**
     * Initializes a rhumb line on the ellipsoid connecting the two provided
     * planetodetic points.
     *
     * @param start     The initial planetodetic point on the path.
     * @param end       The final planetodetic point on the path.
     * @param ellipsoid The ellipsoid on which the rhumb line lies.
     */
    @JsConstructor
    public EllipsoidRhumbLine(Cartographic start, Cartographic end, Ellipsoid ellipsoid) {
    }

    /**
     * Create a rhumb line using an initial position with a heading and distance.
     *
     * @param start    The initial planetodetic point on the path.
     * @param heading  The heading in radians.
     * @param distance The rhumb line distance between the start and end point.
     * @return The EllipsoidRhumbLine object.
     */
    @JsMethod
    public static native EllipsoidRhumbLine fromStartHeadingDistance(Cartographic start, double heading, double distance);

    /**
     * Create a rhumb line using an initial position with a heading and distance.
     *
     * @param start     The initial planetodetic point on the path.
     * @param heading   The heading in radians.
     * @param distance  The rhumb line distance between the start and end point.
     * @param ellipsoid The ellipsoid on which the rhumb line lies.
     * @return The EllipsoidRhumbLine object.
     */
    @JsMethod
    public static native EllipsoidRhumbLine fromStartHeadingDistance(Cartographic start, double heading, double distance,
                                                                     Ellipsoid ellipsoid);

    /**
     * Create a rhumb line using an initial position with a heading and distance.
     *
     * @param start     The initial planetodetic point on the path.
     * @param heading   The heading in radians.
     * @param distance  The rhumb line distance between the start and end point.
     * @param ellipsoid The ellipsoid on which the rhumb line lies.
     * @param result    The object in which to store the result.
     * @return The EllipsoidRhumbLine object.
     */
    @JsMethod
    public static native EllipsoidRhumbLine fromStartHeadingDistance(Cartographic start, double heading, double distance,
                                                                     Ellipsoid ellipsoid, EllipsoidRhumbLine result);

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
     * Gets the heading from the start point to the end point.
     */
    @JsProperty(name = "heading")
    public native double heading();

    /**
     * Gets the initial planetodetic point on the path.
     */
    @JsProperty(name = "start")
    public native Cartographic start();

    /**
     * Gets the surface distance between the start and end point
     */
    @JsProperty(name = "surfaceDistance")
    public native double surfaceDistance();

    /**
     * Provides the location of a point at the indicated latitude along the rhumb
     * line. If the latitude is outside the range of start and end points, the first
     * intersection with the latitude from that start point in the direction of the
     * heading is returned. This follows the spiral property of a rhumb line.
     *
     * @param intersectionLatitude The latitude, in radians, at which to find the
     *                             intersection point from the starting point using
     *                             the heading.
     * @return The location of the intersection point along the rhumb line,
     * undefined if there is no intersection or infinite intersections.
     */
    @JsMethod
    public native Cartographic findIntersectionWithLatitude(double intersectionLatitude);

    /**
     * Provides the location of a point at the indicated latitude along the rhumb
     * line. If the latitude is outside the range of start and end points, the first
     * intersection with the latitude from that start point in the direction of the
     * heading is returned. This follows the spiral property of a rhumb line.
     *
     * @param intersectionLatitude The latitude, in radians, at which to find the
     *                             intersection point from the starting point using
     *                             the heading.
     * @param result               The object in which to store the result.
     * @return The location of the intersection point along the rhumb line,
     * undefined if there is no intersection or infinite intersections.
     */
    @JsMethod
    public native Cartographic findIntersectionWithLatitude(double intersectionLatitude, Cartographic result);

    /**
     * Provides the location of a point at the indicated longitude along the rhumb
     * line. If the longitude is outside the range of start and end points, the
     * first intersection with the longitude from the start point in the direction
     * of the heading is returned. This follows the spiral property of a rhumb line.
     *
     * @param intersectionLongitude The longitude, in radians, at which to find the
     *                              intersection point from the starting point using
     *                              the heading.
     * @return The location of the intersection point along the rhumb line,
     * undefined if there is no intersection or infinite intersections.
     */
    @JsMethod
    public native Cartographic findIntersectionWithLongitude(double intersectionLongitude);

    /**
     * Provides the location of a point at the indicated longitude along the rhumb
     * line. If the longitude is outside the range of start and end points, the
     * first intersection with the longitude from the start point in the direction
     * of the heading is returned. This follows the spiral property of a rhumb line.
     *
     * @param intersectionLongitude The longitude, in radians, at which to find the
     *                              intersection point from the starting point using
     *                              the heading.
     * @param result                The object in which to store the result.
     * @return The location of the intersection point along the rhumb line,
     * undefined if there is no intersection or infinite intersections.
     */
    @JsMethod
    public native Cartographic findIntersectionWithLongitude(double intersectionLongitude, Cartographic result);

    /**
     * Provides the location of a point at the indicated portion along the rhumb
     * line.
     *
     * @param fraction The portion of the distance between the initial and final
     *                 points.
     * @return The location of the point along the rhumb line.
     */
    @JsMethod
    public native Cartographic interpolateUsingFraction(double fraction);

    /**
     * Provides the location of a point at the indicated distance along the rhumb
     * line.
     *
     * @param distance The distance from the inital point to the point of interest
     *                 along the rhumbLine.
     * @return The location of the point along the rhumb line.
     */
    @JsMethod
    public native Cartographic interpolateUsingSurfaceDistance(double distance);

    /**
     * Provides the location of a point at the indicated distance along the rhumb
     * line.
     *
     * @param distance The distance from the inital point to the point of interest
     *                 along the rhumbLine.
     * @param result   The object in which to store the result.
     * @return The location of the point along the rhumb line.
     */
    @JsMethod
    public native Cartographic interpolateUsingSurfaceDistance(double distance, Cartographic result);

    /**
     * Sets the start and end points of the rhumb line.
     *
     * @param start The initial planetodetic point on the path.
     * @param end   The final planetodetic point on the path.
     */
    @JsMethod
    public native void setEndPoints(Cartographic start, Cartographic end);
}
