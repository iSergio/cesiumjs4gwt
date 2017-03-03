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
import org.cesiumjs.cs.core.enums.Visibility;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Occluder")
public class Occluder {
    /**
     * The position of the camera.
     */
    @JsProperty
    public Cartesian3 cameraPosition;
    /**
     * The position of the occluder.
     */
    @JsProperty
    public Cartesian3 position;
    /**
     * The radius of the occluder.
     */
    @JsProperty
    public double radius;

    /**
     * Creates an Occluder derived from an object's position and radius, as well as the camera position.
     * The occluder can be used to determine whether or not other objects are visible or hidden behind the visible
     * horizon defined by the occluder and camera position.
     * <pre>
     *     Example:
     *     {@code
     *     // Construct an occluder one unit away from the origin with a radius of one.
     *     Cartesian3 cameraPosition = Cartesian3.ZERO();
     *     BoundingSphere occluderBoundingSphere = new BoundingSphere(new Cartesian3(0, 0, -1), 1);
     *     Occluder occluder = new Occluder(occluderBoundingSphere, cameraPosition);
     *     }
     * </pre>
     * @param occluderBoundingSphere The bounding sphere surrounding the occluder.
     * @param cameraPosition The coordinate of the viewer/camera.
     */
    @JsConstructor
    public Occluder(BoundingSphere occluderBoundingSphere, Cartesian3 cameraPosition) {}

    /**
     * Computes a point that can be used as the occludee position to the visibility functions.
     * Use a radius of zero for the occludee radius. Typically, a user computes a bounding sphere around an
     * object that is used for visibility; however it is also possible to compute a point that if seen/not seen
     * would also indicate if an object is visible/not visible. This function is better called for objects that do not
     * move relative to the occluder and is large, such as a chunk of terrain. You are better off not calling this
     * and using the object's bounding sphere for objects such as a satellite or ground vehicle.
     * <pre>
     *     {@code
     *     Cartesian3 cameraPosition = new Cartesian3(0, 0, 0);
     *     BoundingSphere occluderBoundingSphere = new BoundingSphere(new Cartesian3(0, 0, -8), 2);
     *     Occluder occluder = new Occluder(occluderBoundingSphere, cameraPosition);
     *     Cartesian3[] positions = {new Cartesian3(-0.25, 0, -5.3), new Cartesian3(0.25, 0, -5.3)};
     *     BoundingSphere tileOccluderSphere = BoundingSphere.fromPoints(positions);
     *     Cartesian3 occludeePosition = tileOccluderSphere.center;
     *     Object occludeePt = Occluder.computeOccludeePoint(occluderBoundingSphere, occludeePosition, positions);
     *     }
     * </pre>
     * @param occluderBoundingSphere The bounding sphere surrounding the occluder.
     * @param occludeePosition List of altitude points on the horizon near the surface of the occluder.
     * @param positions An object containing two attributes: occludeePoint and valid which is a boolean value.
     * @return An object containing two attributes: occludeePoint and valid which is a boolean value.
     */
    @JsMethod
    public static native Object computeOccludeePoint(BoundingSphere occluderBoundingSphere, Cartesian3 occludeePosition, Cartesian3[] positions);

    /**
     * Computes a point that can be used as the occludee position to the visibility functions from an rectangle.
     * @param rectangle The rectangle used to create a bounding sphere.
     * @return An object containing two attributes: occludeePoint and valid which is a boolean value.
     */
    @JsMethod
    public static native Object computeOccludeePointFromRectangle(Rectangle rectangle);

    /**
     * Computes a point that can be used as the occludee position to the visibility functions from an rectangle.
     * @param rectangle The rectangle used to create a bounding sphere.
     * @param ellipsoid The ellipsoid used to determine positions of the rectangle. Default: {@link Ellipsoid#WGS84()}
     * @return An object containing two attributes: occludeePoint and valid which is a boolean value.
     */
    @JsMethod
    public static native Object computeOccludeePointFromRectangle(Rectangle rectangle, Ellipsoid ellipsoid);

    /**
     * Creates an occluder from a bounding sphere and the camera position.
     * @param occluderBoundingSphere The bounding sphere surrounding the occluder.
     * @param cameraPosition The coordinate of the viewer/camera.
     * @return The occluder derived from an object's position and radius, as well as the camera position.
     */
    @JsMethod
    public static native Occluder fromBoundingSphere(BoundingSphere occluderBoundingSphere, Cartesian3 cameraPosition);

    /**
     * Creates an occluder from a bounding sphere and the camera position.
     * @param occluderBoundingSphere The bounding sphere surrounding the occluder.
     * @param cameraPosition The coordinate of the viewer/camera.
     * @param result The object onto which to store the result.
     * @return The occluder derived from an object's position and radius, as well as the camera position.
     */
    @JsMethod
    public static native Occluder fromBoundingSphere(BoundingSphere occluderBoundingSphere, Cartesian3 cameraPosition, Occluder result);

    /**
     * Determine to what extent an occludee is visible (not visible, partially visible, or fully visible).
     * <pre>
     *     Example:
     *     {@code
     *     BoundingSphere sphere1 = new BoundingSphere(new Cartesian3(0, 0, -1.5), 0.5);
     *     BoundingSphere sphere2 = new BoundingSphere(new Cartesian3(0, 0, -2.5), 0.5);
     *     Cartesian3 cameraPosition = new Cartesian3(0, 0, 0);
     *     Occluder occluder = new Occluder(sphere1, cameraPosition);
     *     occluder.computeVisibility(sphere2); //returns Visibility.NONE
     *     }
     * </pre>
     * @param occludeeBS The bounding sphere of the occludee.
     * @return {@link Visibility#NONE()} if the occludee is not visible, {@link Visibility#PARTIAL()} if the
     * occludee is partially visible, or {@link Visibility#FULL()} if the occludee is fully visible.
     */
    @JsMethod
    public native Integer computeVisibility(BoundingSphere occludeeBS);

    /**
     * Determines whether or not a sphere, the occludee, is hidden from view by the occluder.
     * <pre>
     *     Example:
     *     {@code
     *     Cartesian3 cameraPosition = new Cesium.Cartesian3(0, 0, 0);
     *     BoundingSphere littleSphere = new BoundingSphere(new Cartesian3(0, 0, -1), 0.25);
     *     Occluder occluder = new Occluder(littleSphere, cameraPosition);
     *     BoundingSphere bigSphere = new BoundingSphere(new Cartesian3(0, 0, -3), 1);
     *     occluder.isBoundingSphereVisible(bigSphere); //returns true
     *     }
     * </pre>
     * @param occludee The bounding sphere surrounding the occludee object.
     * @return true if the occludee is visible; otherwise false.
     * @see #computeVisibility(BoundingSphere)
     */
    @JsMethod
    public native boolean isBoundingSphereVisible(BoundingSphere occludee);

    /**
     * etermines whether or not a point, the occludee, is hidden from view by the occluder.
     * <pre>
     *     Example:
     *     {@code
     *     Cartesian3 cameraPosition = new Cartesian3(0, 0, 0);
     *     BoundingSphere littleSphere = new BoundingSphere(new Cartesian3(0, 0, -1), 0.25);
     *     Occluder occluder = new Occluder(littleSphere, cameraPosition);
     *     Cartesian3 point = new Cartesian3(0, 0, -3);
     *     occluder.isPointVisible(point); //returns true
     *     }
     * </pre>
     * @param occludee The point surrounding the occludee object.
     * @return true if the occludee is visible; otherwise false.
     * @see #computeVisibility(BoundingSphere)
     */
    @JsMethod
    public native boolean isPointVisible(Cartesian3 occludee);
}
