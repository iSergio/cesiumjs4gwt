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
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.enums.Intersect;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "OrientedBoundingBox")
public class OrientedBoundingBox {
    /**
     * The center of the box.
     * Default: {@link Cartesian3#ZERO()}
     */
    public Cartesian3 center;
    /**
     * The transformation matrix, to rotate the box to the right position.
     * Default: {@link Matrix3#IDENTITY()}
     */
    public Matrix3 halfAxes;

    /**
     * Creates an instance of an OrientedBoundingBox. An OrientedBoundingBox of some object is a closed and convex cuboid.
     * It can provide a tighter bounding volume than {@link BoundingSphere} or {@link AxisAlignedBoundingBox} in many cases.
     * @see BoundingSphere
     * @see BoundingRectangle
     */
    @JsConstructor
    public OrientedBoundingBox() {}

    /**
     * Creates an instance of an OrientedBoundingBox. An OrientedBoundingBox of some object is a closed and convex cuboid.
     * It can provide a tighter bounding volume than {@link BoundingSphere} or {@link AxisAlignedBoundingBox} in many cases.
     * <pre>
     *     Example:
     *     {@code
     *     // Create an OrientedBoundingBox using a transformation matrix, a position where the box will be translated, and a scale.
     *     Cartesian3 center = new Cartesian3(1.0, 0.0, 0.0);
     *     Matrix3 halfAxes = Matrix3.fromScale(new Cartesian3(1.0, 3.0, 2.0), new Matrix3());
     *     OrientedBoundingBox obb = new OrientedBoundingBox(center, halfAxes);
     *     }
     * </pre>
     * @param center The center of the box. Default: {@link Cartesian3#ZERO()}
     * @param halfAxes The three orthogonal half-axes of the bounding box. Equivalently, the transformation matrix,
     *                 to rotate and scale a 2x2x2 cube centered at the origin. Default: {@link Matrix3#ZERO()}
     * @see BoundingSphere
     * @see BoundingRectangle
     */
    @JsConstructor
    public OrientedBoundingBox(Cartesian3 center, Matrix3 halfAxes) {}

    /**
     * Duplicates a OrientedBoundingBox instance.
     * @param box The bounding box to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new OrientedBoundingBox instance if none was provided. (Returns undefined if box is undefined)
     */
    public static native OrientedBoundingBox clone(OrientedBoundingBox box, OrientedBoundingBox result);

    /**
     * The distances calculated by the vector from the center of the bounding box to position projected onto direction.
     * If you imagine the infinite number of planes with normal direction, this computes the smallest distance to the
     * closest and farthest planes from position that intersect the bounding box.
     * @param box The bounding box to calculate the distance to.
     * @param position The position to calculate the distance from.
     * @param direction The direction from position.
     * @return The nearest and farthest distances on the bounding box from position in direction.
     */
    public static native Interval computePlaneDistances(OrientedBoundingBox box, Cartesian3 position, Cartesian3 direction);

    /**
     * The distances calculated by the vector from the center of the bounding box to position projected onto direction.
     * If you imagine the infinite number of planes with normal direction, this computes the smallest distance to the
     * closest and farthest planes from position that intersect the bounding box.
     * @param box The bounding box to calculate the distance to.
     * @param position The position to calculate the distance from.
     * @param direction The direction from position.
     * @param result A Interval to store the nearest and farthest distances.
     * @return The nearest and farthest distances on the bounding box from position in direction.
     */
    public static native Interval computePlaneDistances(OrientedBoundingBox box, Cartesian3 position, Cartesian3 direction, Interval result);

    /**
     * Computes the estimated distance squared from the closest point on a bounding box to a point.
     * @param box The box.
     * @param cartesian The point.
     * @return The estimated distance squared from the bounding sphere to the point.
     */
    public static native double distanceSquaredTo(OrientedBoundingBox box, Cartesian3 cartesian);

    /**
     * Compares the provided OrientedBoundingBox componentwise and returns true if they are equal, false otherwise.
     * @param left The first OrientedBoundingBox.
     * @param right The second OrientedBoundingBox.
     * @return true if left and right are equal, false otherwise.
     */
    public static native boolean equals(OrientedBoundingBox left, OrientedBoundingBox right);

    /**
     * Computes an instance of an OrientedBoundingBox of the given positions. This is an implementation of Stefan Gottschalk's
     * Collision Queries using Oriented Bounding Boxes solution (PHD thesis). Reference: http://gamma.cs.unc.edu/users/gottschalk/main.pdf
     * <pre>
     *     Example:
     *     {@code
     *     // Compute an object oriented bounding box enclosing two points.
     *     OrientedBoundingBox box = OrientedBoundingBox.fromPoints([new Cartesian3(2, 0, 0), new Cartesian3(-2, 0, 0)]);
     *     }
     * </pre>
     * @param positions List of Cartesian3 points that the bounding box will enclose.
     * @return The modified result parameter or a new OrientedBoundingBox instance if one was not provided.
     */
    public static native OrientedBoundingBox fromPoints(Cartesian3[] positions);

    /**
     * Computes an instance of an OrientedBoundingBox of the given positions. This is an implementation of Stefan Gottschalk's
     * Collision Queries using Oriented Bounding Boxes solution (PHD thesis). Reference: http://gamma.cs.unc.edu/users/gottschalk/main.pdf
     * <pre>
     *     Example:
     *     {@code
     *     // Compute an object oriented bounding box enclosing two points.
     *     OrientedBoundingBox box = OrientedBoundingBox.fromPoints([new Cartesian3(2, 0, 0), new Cartesian3(-2, 0, 0)]);
     *     }
     * </pre>
     * @param positions List of Cartesian3 points that the bounding box will enclose.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new OrientedBoundingBox instance if one was not provided.
     */
    public static native OrientedBoundingBox fromPoints(Cartesian3[] positions, OrientedBoundingBox result);

    /**
     * Computes an OrientedBoundingBox that bounds a Rectangle on the surface of an Ellipsoid. There are no guarantees
     * about the orientation of the bounding box.
     * @param rectangle The cartographic rectangle on the surface of the ellipsoid.
     * @return The modified result parameter or a new OrientedBoundingBox instance if none was provided.
     */
    public static native OrientedBoundingBox fromRectangle(Rectangle rectangle);

    /**
     * Computes an OrientedBoundingBox that bounds a Rectangle on the surface of an Ellipsoid. There are no guarantees
     * about the orientation of the bounding box.
     * @param rectangle The cartographic rectangle on the surface of the ellipsoid.
     * @param minimumHeight The minimum height (elevation) within the tile. Default: 0.0
     * @param maximumHeight The maximum height (elevation) within the tile. Default: 0.0
     * @param ellipsoid The ellipsoid on which the rectangle is defined. Default: {@link Ellipsoid#WGS84()}
     * @return The modified result parameter or a new OrientedBoundingBox instance if none was provided.
     */
    public static native OrientedBoundingBox fromRectangle(Rectangle rectangle, double minimumHeight, double maximumHeight, Ellipsoid ellipsoid);

    /**
     * Computes an OrientedBoundingBox that bounds a Rectangle on the surface of an Ellipsoid. There are no guarantees
     * about the orientation of the bounding box.
     * @param rectangle The cartographic rectangle on the surface of the ellipsoid.
     * @param minimumHeight The minimum height (elevation) within the tile. Default: 0.0
     * @param maximumHeight The maximum height (elevation) within the tile. Default: 0.0
     * @param ellipsoid The ellipsoid on which the rectangle is defined. Default: {@link Ellipsoid#WGS84()}
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new OrientedBoundingBox instance if none was provided.
     */
    public static native OrientedBoundingBox fromRectangle(Rectangle rectangle, double minimumHeight, double maximumHeight, Ellipsoid ellipsoid, OrientedBoundingBox result);

    /**
     * Determines which side of a plane the oriented bounding box is located.
     * @param box The oriented bounding box to test.
     * @param plane The plane to test against.
     * @return Intersect.INSIDE if the entire box is on the side of the plane the normal is pointing, Intersect.OUTSIDE
     * if the entire box is on the opposite side, and {@link Intersect#INTERSECTING()}  if the box intersects the plane.
     */
    public static native Integer intersectPlane(OrientedBoundingBox box, Plane plane);

    /**
     * Determines whether or not a bounding box is hidden from view by the occluder.
     * @param box The bounding box surrounding the occludee object.
     * @param occluder The occluder.
     * @return true if the box is not visible; otherwise false.
     */
    public static native boolean isOccluded(OrientedBoundingBox box, Occluder occluder);

    /**
     * Duplicates this OrientedBoundingBox instance.
     * @return a new OrientedBoundingBox instance if one was not provided.
     */
    public native OrientedBoundingBox clone();

    /**
     * The distances calculated by the vector from the center of the bounding box to position projected onto direction.
     * If you imagine the infinite number of planes with normal direction, this computes the smallest distance to the
     * closest and farthest planes from position that intersect the bounding box.
     * @param position The position to calculate the distance from.
     * @param direction The direction from position.
     * @return The nearest and farthest distances on the bounding box from position in direction.
     */
    public native Interval computePlaneDistances(Cartesian3 position, Cartesian3 direction);

    /**
     * The distances calculated by the vector from the center of the bounding box to position projected onto direction.
     * If you imagine the infinite number of planes with normal direction, this computes the smallest distance to the
     * closest and farthest planes from position that intersect the bounding box.
     * @param position The position to calculate the distance from.
     * @param direction The direction from position.
     * @param result A Interval to store the nearest and farthest distances.
     * @return The nearest and farthest distances on the bounding box from position in direction.
     */
    public native Interval computePlaneDistances(Cartesian3 position, Cartesian3 direction, Interval result);

    /**
     * Computes the estimated distance squared from the closest point on a bounding box to a point.
     * @param cartesian The point
     * @return The estimated distance squared from the bounding sphere to the point.
     */
    public native double distanceSquaredTo(Cartesian3 cartesian);

    /**
     * Compares this OrientedBoundingBox against the provided OrientedBoundingBox componentwise and returns true if
     * they are equal, false otherwise.
     * @param right The right hand side OrientedBoundingBox.
     * @return true if they are equal, false otherwise.
     */
    public native boolean equals(OrientedBoundingBox right);

    /**
     * Determines which side of a plane the oriented bounding box is located.
     * @param plane The plane to test against.
     * @return Intersect.INSIDE if the entire box is on the side of the plane the normal is pointing, Intersect.OUTSIDE
     * if the entire box is on the opposite side, and {@link Intersect#INTERSECTING()} if the box intersects the plane.
     */
    public native Integer intersectPlane(Plane plane);

    /**
     * Determines whether or not a bounding box is hidden from view by the occluder.
     * @param occluder The occluder.
     * @return true if the sphere is not visible; otherwise false.
     */
    public native boolean isOccluded(Occluder occluder);
}
