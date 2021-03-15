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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "Plane")
public class Plane {
    /**
     * The shortest distance from the origin to the plane. The sign of distance
     * determines which side of the plane the origin is on. If distance is positive,
     * the origin is in the half-space in the direction of the normal; if negative,
     * the origin is in the half-space opposite to the normal; if zero, the plane
     * passes through the origin.
     */
    @JsProperty
    public double distance;
    /**
     * The plane's normal.
     */
    @JsProperty
    public Cartesian3 normal;

    /**
     * A plane in Hessian Normal Form defined by
     * <p>
     * ax + by + cz + d = 0
     * <p>
     * where (a, b, c) is the plane's normal, d is the signed distance to the plane,
     * and (x, y, z) is any point on the plane.
     *
     * @param normal   The plane's normal (normalized).
     * @param distance The shortest distance from the origin to the plane. The sign
     *                 of distance determines which side of the plane the origin is
     *                 on. If distance is positive, the origin is in the half-space
     *                 in the direction of the normal; if negative, the origin is in
     *                 the half-space opposite to the normal; if zero, the plane
     *                 passes through the origin.
     */
    @JsConstructor
    public Plane(Cartesian3 normal, double distance) {
    }

    /**
     * A constant initialized to the XY plane passing through the origin, with
     * normal in positive Z.
     */
    @JsProperty(name = "ORIGIN_XY_PLANE")
    public static native Plane ORIGIN_XY_PLANE();

    /**
     * A constant initialized to the YZ plane passing through the origin, with
     * normal in positive X.
     */
    @JsProperty(name = "ORIGIN_YZ_PLANE")
    public static native Plane ORIGIN_YZ_PLANE();

    /**
     * A constant initialized to the ZX plane passing through the origin, with
     * normal in positive Y.
     */
    @JsProperty(name = "ORIGIN_ZX_PLANE")
    public static native Plane ORIGIN_ZX_PLANE();

    /**
     * Duplicates a Plane instance.
     *
     * @param plane The plane to duplicate.
     * @return The modified result parameter or a new Plane instance if one was not
     * provided.
     */
    @JsMethod
    public static native Plane clone(Plane plane);

    /**
     * Duplicates a Plane instance.
     *
     * @param plane  The plane to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Plane instance if one was not
     * provided.
     */
    @JsMethod
    public static native Plane clone(Plane plane, Plane result);

    /**
     * Compares the provided Planes by normal and distance and returns true if they
     * are equal, false otherwise.
     *
     * @param left  The first plane.
     * @param right The second plane.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native Plane equals(Plane left, Plane right);

    /**
     * Creates a plane from the general equation
     *
     * @param coefficients The plane's normal (normalized).
     * @return A new plane instance or the modified result parameter.
     */
    @JsMethod
    public static native Plane fromCartesian4(Cartesian4 coefficients);

    /**
     * Creates a plane from the general equation
     *
     * @param coefficients The plane's normal (normalized).
     * @param result       The object onto which to store the result.
     * @return A new plane instance or the modified result parameter.
     */
    @JsMethod
    public static native Plane fromCartesian4(Cartesian4 coefficients, Plane result);

    /**
     * Creates a plane from a normal and a point on the plane.
     *
     * <pre>
     * Example: {
     *   &#64;code
     *   Cartesian3 point = Cartesian3.fromDegrees(-72.0, 40.0);
     *   Cartesian3 normal = ellipsoid.geodeticSurfaceNormal(point);
     *   Plane tangentPlane = Plane.fromPointNormal(point, normal);
     * }
     * </pre>
     *
     * @param point  The point on the plane.
     * @param normal The plane's normal (normalized).
     * @return A new plane instance or the modified result parameter.
     */
    @JsMethod
    public static native Plane fromPointNormal(Cartesian3 point, Cartesian3 normal);

    /**
     * Creates a plane from a normal and a point on the plane.
     *
     * <pre>
     * Example: {
     *   &#64;code
     *   Cartesian3 point = Cartesian3.fromDegrees(-72.0, 40.0);
     *   Cartesian3 normal = ellipsoid.geodeticSurfaceNormal(point);
     *   Plane tangentPlane = Plane.fromPointNormal(point, normal);
     * }
     * </pre>
     *
     * @param point  The point on the plane.
     * @param normal The plane's normal (normalized).
     * @param result The object onto which to store the result.
     * @return A new plane instance or the modified result parameter.
     */
    @JsMethod
    public static native Plane fromPointNormal(Cartesian3 point, Cartesian3 normal, Plane result);

    /**
     * Computes the signed shortest distance of a point to a plane. The sign of the
     * distance determines which side of the plane the point is on. If the distance
     * is positive, the point is in the half-space in the direction of the normal;
     * if negative, the point is in the half-space opposite to the normal; if zero,
     * the plane passes through the point.
     *
     * @param plane The plane.
     * @param point The point.
     * @return The signed shortest distance of the point to the plane.
     */
    @JsMethod
    public static native double getPointDistance(Plane plane, Cartesian3 point);

    /**
     * Projects a point onto the plane.
     *
     * @param plane The plane to project the point onto
     * @param point The point to project onto the plane
     * @return The result point.
     */
    @JsMethod
    public static native Cartesian3 projectPointOntoPlane(Plane plane, Cartesian3 point);

    /**
     * Projects a point onto the plane.
     *
     * @param plane  The plane to project the point onto
     * @param point  The point to project onto the plane
     * @param result The result point. If undefined, a new Cartesian3 will be
     *               created.
     * @return The result point.
     */
    @JsMethod
    public static native Cartesian3 projectPointOntoPlane(Plane plane, Cartesian3 point, Cartesian3 result);

    /**
     * Transforms the plane by the given transformation matrix.
     *
     * @param plane     The plane.
     * @param transform The transformation matrix.
     * @return The plane transformed by the given transformation matrix.
     */
    @JsMethod
    public static native Plane transform(Plane plane, Matrix4 transform);

    /**
     * Transforms the plane by the given transformation matrix.
     *
     * @param plane     The plane.
     * @param transform The transformation matrix.
     * @param result    The object into which to store the result.
     * @return The plane transformed by the given transformation matrix.
     */
    @JsMethod
    public static native Plane transform(Plane plane, Matrix4 transform, Plane result);
}
