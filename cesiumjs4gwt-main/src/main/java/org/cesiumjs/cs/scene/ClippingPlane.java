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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Plane;

/**
 * A Plane in Hessian Normal form to be used with
 * {@link org.cesiumjs.cs.collections.ClippingPlaneCollection}. Compatible with
 * mathematics functions in {@link org.cesiumjs.cs.core.Plane}
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "ClippingPlane")
public class ClippingPlane extends Plane {
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
     *                 the half-space opposite to the normal;
     */
    public ClippingPlane(Cartesian3 normal, double distance) {
        super(normal, distance);
    }

    // @JsConstructor
    // private ClippingPlane() {}
    //
    // /**
    // * A Plane in Hessian Normal form to be used with {@link
    // org.cesiumjs.cs.collections.ClippingPlaneCollection}.
    // * Compatible with mathematics functions in {@link org.cesiumjs.cs.core.Plane}
    // * @param normal The plane's normal (normalized).
    // * @param distance The shortest distance from the origin to the plane. The
    // sign of distance determines which side
    // * of the plane the origin is on. If distance is positive, the origin is in
    // the half-space in the
    // * direction of the normal; if negative, the origin is in the half-space
    // opposite to the normal;
    // * if zero, the plane passes through the origin.
    // */
    // @JsConstructor
    // public ClippingPlane(Cartesian3 normal, double distance) {}

    /**
     * Clones the ClippingPlane without setting its ownership.
     *
     * @param clippingPlane The ClippingPlane to be cloned
     * @return a clone of the input ClippingPlane
     */
    @JsMethod
    public static native ClippingPlane clone(ClippingPlane clippingPlane);

    /**
     * Clones the ClippingPlane without setting its ownership.
     *
     * @param clippingPlane The ClippingPlane to be cloned
     * @param result        The object on which to store the cloned parameters.
     * @return a clone of the input ClippingPlane
     */
    @JsMethod
    public static native ClippingPlane clone(ClippingPlane clippingPlane, ClippingPlane result);

    /**
     * Create a ClippingPlane from a Plane object.
     *
     * @param plane The plane containing parameters to copy
     * @return The ClippingPlane generated from the plane's parameters.
     */
    @JsMethod
    public static native ClippingPlane fromPlane(Plane plane);

    /**
     * Create a ClippingPlane from a Plane object.
     *
     * @param plane  The plane containing parameters to copy
     * @param result The object on which to store the result
     * @return The ClippingPlane generated from the plane's parameters.
     */
    @JsMethod
    public static native ClippingPlane fromPlane(Plane plane, ClippingPlane result);
}
