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
import jsinterop.annotations.JsType;

/**
 * Functions for computing the intersection between geometries such as rays, planes, triangles, and ellipsoids.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "IntersectionTests")
public class IntersectionTests {
    @JsConstructor
    private IntersectionTests() {}

    /**
     * Computes the intersection points of a line segment with a sphere.
     * @param p0 An end point of the line segment.
     * @param p1 The other end point of the line segment.
     * @param sphere The sphere.
     * @return The interval containing scalar points along the ray or undefined if there are no intersections.
     */
    @JsMethod
    public static native Interval lineSegmentSphere(Cartesian3 p0, Cartesian3 p1, BoundingSphere sphere);

    /**
     * Computes the intersection points of a line segment with a sphere.
     * @param p0 An end point of the line segment.
     * @param p1 The other end point of the line segment.
     * @param sphere The sphere.
     * @param result The result onto which to store the result.
     * @return The interval containing scalar points along the ray or undefined if there are no intersections.
     */
    @JsMethod
    public static native Interval lineSegmentSphere(Cartesian3 p0, Cartesian3 p1, BoundingSphere sphere, Interval result);

    /**
     * Computes the intersection of a line segment and a triangle.
     * @param v0 The an end point of the line segment.
     * @param v1 The other end point of the line segment.
     * @param p0 The first vertex of the triangle.
     * @param p1 The second vertex of the triangle.
     * @param p2 The third vertex of the triangle.
     * @param cullBackFaces If true, will only compute an intersection with the front face of the triangle and return
     *                      undefined for intersections with the back face.
     * @return The intersection point or undefined if there is no intersections.
     */
    @JsMethod
    public static native Cartesian3 lineSegmentTriangle(Cartesian3 v0, Cartesian3 v1, Cartesian3 p0, Cartesian3 p1, Cartesian3 p2);

    /**
     * Computes the intersection of a line segment and a triangle.
     * @param v0 The an end point of the line segment.
     * @param v1 The other end point of the line segment.
     * @param p0 The first vertex of the triangle.
     * @param p1 The second vertex of the triangle.
     * @param p2 The third vertex of the triangle.
     * @param cullBackFaces If true, will only compute an intersection with the front face of the triangle and return
     *                      undefined for intersections with the back face.
     * @return The intersection point or undefined if there is no intersections.
     */
    @JsMethod
    public static native Cartesian3 lineSegmentTriangle(Cartesian3 v0, Cartesian3 v1, Cartesian3 p0, Cartesian3 p1, Cartesian3 p2, boolean cullBackFaces);

    /**
     * Computes the intersection of a line segment and a triangle.
     * @param v0 The an end point of the line segment.
     * @param v1 The other end point of the line segment.
     * @param p0 The first vertex of the triangle.
     * @param p1 The second vertex of the triangle.
     * @param p2 The third vertex of the triangle.
     * @param cullBackFaces If true, will only compute an intersection with the front face of the triangle and return
     *                      undefined for intersections with the back face.
     * @param result The Cartesian3 onto which to store the result.
     * @return The intersection point or undefined if there is no intersections.
     */
    @JsMethod
    public static native Cartesian3 lineSegmentTriangle(Cartesian3 v0, Cartesian3 v1, Cartesian3 p0, Cartesian3 p1, Cartesian3 p2, boolean cullBackFaces, Cartesian3 result);

    /**
     * Computes the intersection points of a ray with a sphere.
     * @param ray The ray.
     * @param sphere The sphere.
     * @return The interval containing scalar points along the ray or undefined if there are no intersections.
     */
    @JsMethod
    public static native Interval raySphere(Ray ray, BoundingSphere sphere);

    /**
     * Computes the intersection points of a ray with a sphere.
     * @param ray The ray.
     * @param sphere The sphere.
     * @param result The result onto which to store the result.
     * @return The interval containing scalar points along the ray or undefined if there are no intersections.
     */
    @JsMethod
    public static native Interval raySphere(Ray ray, BoundingSphere sphere, Interval result);

    /**
     * Computes the intersection of a ray and a triangle as a Cartesian3 coordinate.
     * Implements <a href="https://cadxfem.org/inf/Fast%20MinimumStorage%20RayTriangle%20Intersection.pdf>Fast Minimum Storage Ray/Triangle Intersection</a> by Tomas Moller and Ben Trumbore.
     * @param ray The ray.
     * @param p0 The first vertex of the triangle.
     * @param p1 The second vertex of the triangle.
     * @param p2 The third vertex of the triangle.
     * @return The intersection point or undefined if there is no intersections.
     */
    @JsMethod
    public static native Cartesian3 rayTriangle(Ray ray, Cartesian3 p0, Cartesian3 p1, Cartesian3 p2);

    /**
     * Computes the intersection of a ray and a triangle as a Cartesian3 coordinate.
     * Implements <a href="https://cadxfem.org/inf/Fast%20MinimumStorage%20RayTriangle%20Intersection.pdf>Fast Minimum Storage Ray/Triangle Intersection</a> by Tomas Moller and Ben Trumbore.
     * @param ray The ray.
     * @param p0 The first vertex of the triangle.
     * @param p1 The second vertex of the triangle.
     * @param p2 The third vertex of the triangle.
     * @param cullBackFaces If true, will only compute an intersection with the front face of the triangle and return undefined for intersections with the back face.
     * @return The intersection point or undefined if there is no intersections.
     */
    @JsMethod
    public static native Cartesian3 rayTriangle(Ray ray, Cartesian3 p0, Cartesian3 p1, Cartesian3 p2, boolean cullBackFaces);

    /**
     * Computes the intersection of a ray and a triangle as a Cartesian3 coordinate.
     * Implements <a href="https://cadxfem.org/inf/Fast%20MinimumStorage%20RayTriangle%20Intersection.pdf>Fast Minimum Storage Ray/Triangle Intersection</a> by Tomas Moller and Ben Trumbore.
     * @param ray The ray.
     * @param p0 The first vertex of the triangle.
     * @param p1 The second vertex of the triangle.
     * @param p2 The third vertex of the triangle.
     * @param cullBackFaces If true, will only compute an intersection with the front face of the triangle and return undefined for intersections with the back face.
     * @param result  The Cartesian3 onto which to store the result.
     * @return The intersection point or undefined if there is no intersections.
     */
    @JsMethod
    public static native Cartesian3 rayTriangle(Ray ray, Cartesian3 p0, Cartesian3 p1, Cartesian3 p2, boolean cullBackFaces, Cartesian3 result);

    /**
     * Computes the intersection of a ray and a triangle as a parametric distance along the input ray.
     * Implements <a href="https://cadxfem.org/inf/Fast%20MinimumStorage%20RayTriangle%20Intersection.pdf">Fast Minimum Storage Ray/Triangle Intersection</a> by Tomas Moller and Ben Trumbore.
     * @param ray The ray.
     * @param p0 The first vertex of the triangle.
     * @param p1 The second vertex of the triangle.
     * @param p2 The third vertex of the triangle.
     * @return The intersection as a parametric distance along the ray, or undefined if there is no intersection.
     */
    @JsMethod
    public static native double rayTriangleParametric(Cartesian3 ray, Cartesian3 p0, Cartesian3 p1, Cartesian3 p2);

    /**
     * Computes the intersection of a ray and a triangle as a parametric distance along the input ray.
     * Implements <a href="https://cadxfem.org/inf/Fast%20MinimumStorage%20RayTriangle%20Intersection.pdf">Fast Minimum Storage Ray/Triangle Intersection</a> by Tomas Moller and Ben Trumbore.
     * @param ray The ray.
     * @param p0 The first vertex of the triangle.
     * @param p1 The second vertex of the triangle.
     * @param p2 The third vertex of the triangle.
     * @param cullBackFaces If true, will only compute an intersection with the front face of the triangle and return undefined for intersections with the back face.
     * @return The intersection as a parametric distance along the ray, or undefined if there is no intersection.
     */
    @JsMethod
    public static native double rayTriangleParametric(Cartesian3 ray, Cartesian3 p0, Cartesian3 p1, Cartesian3 p2, boolean cullBackFaces);

    /**
     * Provides the point along the ray which is nearest to the ellipsoid.
     * @param ray The ray.
     * @param ellipsoid The ellipsoid.
     * @return The nearest planetodetic point on the ray.
     */
    @JsMethod
    public static native Cartesian3 grazingAltitudeLocation(Ray ray, Ellipsoid ellipsoid);

    /**
     * Computes the intersection of a line segment and a plane.
     * @param endPoint0 An end point of the line segment.
     * @param endPoint1 The other end point of the line segment.
     * @param plane The plane.
     * @return The intersection point or undefined if there is no intersection.
     */
    @JsMethod
    public static native Cartesian3 lineSegmentPlane(Cartesian3 endPoint0, Cartesian3 endPoint1, Plane plane);

    /**
     * Computes the intersection of a line segment and a plane.
     * @param endPoint0 An end point of the line segment.
     * @param endPoint1 The other end point of the line segment.
     * @param plane The plane.
     * @param result The object onto which to store the result.
     * @return The intersection point or undefined if there is no intersection.
     */
    @JsMethod
    public static native Cartesian3 lineSegmentPlane(Cartesian3 endPoint0, Cartesian3 endPoint1, Plane plane, Cartesian3 result);

    /**
     * Computes the intersection points of a ray with an ellipsoid.
     * @param ray The ray.
     * @param ellipsoid The ellipsoid.
     * @return The interval containing scalar points along the ray or undefined if there are no intersections.
     */
    @JsMethod
    public static native Interval rayEllipsoid(Ray ray, Ellipsoid ellipsoid);

    /**
     * Computes the intersection of a ray and a plane.
     * @param ray The ray.
     * @param plane The plane.
     * @return The intersection point or undefined if there is no intersections.
     */
    @JsMethod
    public static native Cartesian3 rayPlane(Ray ray, Plane plane);

    /**
     * Computes the intersection of a ray and a plane.
     * @param ray The ray.
     * @param plane The plane.
     * @param result The object onto which to store the result.
     * @return The intersection point or undefined if there is no intersections.
     */
    @JsMethod
    public static native Cartesian3 rayPlane(Ray ray, Plane plane, Cartesian3 result);

    /**
     * Computes the intersection of a triangle and a plane
     * @param p0 First point of the triangle
     * @param p1 Second point of the triangle
     * @param p2 Third point of the triangle
     * @param plane Intersection plane
     * @return An object with properties positions and indices, which are arrays that represent three triangles that
     * do not cross the plane. (Undefined if no intersection exists)
     */
    @JsMethod
    public static native Object trianglePlaneIntersection(Cartesian3 p0, Cartesian3 p1, Cartesian3 p2, Plane plane);
}
