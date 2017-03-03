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
import org.cesiumjs.cs.core.enums.Intersect;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "BoundingSphere")
public class BoundingSphere {
    /**
     * The center point of the sphere.
     * Default: {@link Cartesian3#ZERO()}
     */
    @JsProperty
    public Cartesian3 center;
    /**
     * The radius of the sphere.
     * Default: 0.0
     */
    @JsProperty
    public double radius;

    /**
     * A bounding sphere with a center and a radius.
     * @see Packable
     */
    @JsConstructor
    public BoundingSphere() {}

    /**
     * A bounding sphere with a center and a radius.
     * @param center The center of the bounding sphere. Default: {@link Cartesian3#ZERO()}
     * @param radius The radius of the bounding sphere. Default: 0.0
     * @see Packable
     */
    @JsConstructor
    public BoundingSphere(Cartesian3 center, double radius) {}

    /**
     * Duplicates a BoundingSphere instance.
     * @param sphere The bounding sphere to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided. (Returns undefined if sphere is undefined)
     */
    @JsMethod
    public static native BoundingSphere clone(BoundingSphere sphere, BoundingSphere result);

    /**
     * Duplicates a BoundingSphere instance.
     * @param sphere The bounding sphere to duplicate.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided. (Returns undefined if sphere is undefined)
     */
    @JsMethod
    public static native BoundingSphere clone(BoundingSphere sphere);

    /**
     * The distances calculated by the vector from the center of the bounding sphere to position projected onto direction plus/minus the radius of the bounding sphere.
     * @param sphere The bounding sphere to calculate the distance to.
     * @param position The position to calculate the distance from.
     * @param direction The direction from position.
     * @return The nearest and farthest distances on the bounding sphere from position in direction.
     */
    @JsMethod
    public static native Interval computePlaneDistances(BoundingSphere sphere, Cartesian3 position, Cartesian3 direction);

    /**
     * The distances calculated by the vector from the center of the bounding sphere to position projected onto direction plus/minus the radius of the bounding sphere.
     * @param sphere The bounding sphere to calculate the distance to.
     * @param position The position to calculate the distance from.
     * @param direction The direction from position.
     * @param result A Interval to store the nearest and farthest distances.
     * @return The nearest and farthest distances on the bounding sphere from position in direction.
     */
    @JsMethod
    public static native Interval computePlaneDistances(BoundingSphere sphere, Cartesian3 position, Cartesian3 direction, Interval result);

    /**
     * Computes the estimated distance squared from the closest point on a bounding sphere to a point.
     * @param sphere The sphere.
     * @param cartesian The point.
     * @return The estimated distance squared from the bounding sphere to the point.
     */
    @JsMethod
    public static native double distanceSquaredTo(BoundingSphere sphere, Cartesian3 cartesian);

    /**
     * Compares the provided BoundingSphere componentwise and returns true if they are equal, false otherwise.
     * @param left The first BoundingSphere.
     * @param right The second BoundingSphere.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(BoundingSphere left, BoundingSphere right);

    /**
     * Computes a bounding sphere by enlarging the provided sphere to contain the provided point.
     * @param sphere A sphere to expand.
     * @param point A point to enclose in a bounding sphere.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere expand(BoundingSphere sphere, Cartesian3 point, BoundingSphere result);

    /**
     * Computes a bounding sphere by enlarging the provided sphere to contain the provided point.
     * @param sphere A sphere to expand.
     * @param point A point to enclose in a bounding sphere.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere expand(BoundingSphere sphere, Cartesian3 point);

    /**
     * Computes a tight-fitting bounding sphere enclosing the provided array of bounding spheres.
     * @param boundingSpheres The array of bounding spheres.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromBoundingSpheres(BoundingSphere[] boundingSpheres);

    /**
     * Computes a tight-fitting bounding sphere enclosing the provided array of bounding spheres.
     * @param boundingSpheres The array of bounding spheres.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromBoundingSpheres(BoundingSphere[] boundingSpheres, BoundingSphere result);

    /**
     * Computes a bounding sphere from the corner points of an axis-aligned bounding box. The sphere tighly and fully encompases the box.
     * <pre>
     *     Example:
     *     {@code
     *     // Create a bounding sphere around the unit cube
     *     BoundingSphere sphere = BoundingSphere.fromCornerPoints(new Cartesian3(-0.5, -0.5, -0.5), new Cartesian3(0.5, 0.5, 0.5));
     *     }
     * </pre>
     * @param corner The minimum height over the rectangle.
     * @param oppositeCorner The maximum height over the rectangle.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromCornerPoints(Cartesian3 corner, Cartesian3 oppositeCorner);

    /**
     * Computes a bounding sphere from the corner points of an axis-aligned bounding box. The sphere tighly and fully encompases the box.
     * <pre>
     *     Example:
     *     {@code
     *     // Create a bounding sphere around the unit cube
     *     BoundingSphere sphere = BoundingSphere.fromCornerPoints(new Cartesian3(-0.5, -0.5, -0.5), new Cartesian3(0.5, 0.5, 0.5));
     *     }
     * </pre>
     * @param corner The minimum height over the rectangle.
     * @param oppositeCorner The maximum height over the rectangle.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromCornerPoints(Cartesian3 corner, Cartesian3 oppositeCorner, BoundingSphere result);

    /**
     * Creates a bounding sphere encompassing an ellipsoid.
     * <pre>
     *     Example:
     *     {@code
     *     BoundingSphere boundingSphere = BoundingSphere.fromEllipsoid(ellipsoid);
     *     }
     * </pre>
     * @param ellipsoid The ellipsoid around which to create a bounding sphere.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromEllipsoid(Ellipsoid ellipsoid);

    /**
     * Creates a bounding sphere encompassing an ellipsoid.
     * <pre>
     *     Example:
     *     {@code
     *     BoundingSphere boundingSphere = BoundingSphere.fromEllipsoid(ellipsoid);
     *     }
     * </pre>
     * @param ellipsoid The ellipsoid around which to create a bounding sphere.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromEllipsoid(Ellipsoid ellipsoid, BoundingSphere result);

    /**
     * Computes a tight-fitting bounding sphere enclosing a list of EncodedCartesian3s, where the points are stored in
     * parallel flat arrays in X, Y, Z, order. The bounding sphere is computed by running two algorithms, a naive
     * algorithm and Ritter's algorithm. The smaller of the two spheres is used to ensure a tight fit.
     * @param positionsHigh An array of high bits of the encoded cartesians that the bounding sphere will enclose.
     *                      Each point is formed from three elements in the array in the order X, Y, Z.
     * @param positionsLow An array of low bits of the encoded cartesians that the bounding sphere will enclose.
     *                     Each point is formed from three elements in the array in the order X, Y, Z.
     * @return The modified result parameter or a new BoundingSphere instance if one was not provided.
     * @see <a href="http://blogs.agi.com/insight3d/index.php/2008/02/04/a-bounding/">Sphere computation article</a>
     */
    @JsMethod
    public static native BoundingSphere fromEncodedCartesianVertices(double[] positionsHigh, double[] positionsLow);

    /**
     * Computes a tight-fitting bounding sphere enclosing a list of EncodedCartesian3s, where the points are stored in
     * parallel flat arrays in X, Y, Z, order. The bounding sphere is computed by running two algorithms, a naive
     * algorithm and Ritter's algorithm. The smaller of the two spheres is used to ensure a tight fit.
     * @param positionsHigh An array of high bits of the encoded cartesians that the bounding sphere will enclose.
     *                      Each point is formed from three elements in the array in the order X, Y, Z.
     * @param positionsLow An array of low bits of the encoded cartesians that the bounding sphere will enclose.
     *                     Each point is formed from three elements in the array in the order X, Y, Z.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if one was not provided.
     * @see <a href="http://blogs.agi.com/insight3d/index.php/2008/02/04/a-bounding/">Sphere computation article</a>
     */
    @JsMethod
    public static native BoundingSphere fromEncodedCartesianVertices(double[] positionsHigh, double[] positionsLow, BoundingSphere result);

    /**
     * Computes a tight-fitting bounding sphere enclosing the provided oriented bounding box.
     * @param orientedBoundingBox The oriented bounding box.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromOrientedBoundingBox(OrientedBoundingBox orientedBoundingBox);

    /**
     * Computes a tight-fitting bounding sphere enclosing the provided oriented bounding box.
     * @param orientedBoundingBox The oriented bounding box.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromOrientedBoundingBox(OrientedBoundingBox orientedBoundingBox, BoundingSphere result);

    /**
     * Computes a tight-fitting bounding sphere enclosing a list of 3D Cartesian points. The bounding sphere is computed
     * by running two algorithms, a naive algorithm and Ritter's algorithm. The smaller of the two spheres is used to ensure a tight fit.
     * @param positions An array of points that the bounding sphere will enclose. Each point must have x, y, and z properties.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if one was not provided.
     * @see <a href="http://blogs.agi.com/insight3d/index.php/2008/02/04/a-bounding/">Bounding Sphere computation article</a>
     */
    @JsMethod
    public static native BoundingSphere fromPoints(Cartesian3[] positions, BoundingSphere result);

    /**
     * Computes a bounding sphere from an rectangle projected in 2D.
     * @param rectangle The rectangle around which to create a bounding sphere.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromRectangle2D(Rectangle rectangle);

    /**
     * Computes a bounding sphere from an rectangle projected in 2D.
     * @param rectangle The rectangle around which to create a bounding sphere.
     * @param projection The projection used to project the rectangle into 2D. Default: {@link org.cesiumjs.cs.core.projection.GeographicProjection}
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromRectangle2D(Rectangle rectangle, Object projection);

    /**
     * Computes a bounding sphere from an rectangle projected in 2D.
     * @param rectangle The rectangle around which to create a bounding sphere.
     * @param projection The projection used to project the rectangle into 2D. Default: {@link org.cesiumjs.cs.core.projection.GeographicProjection}
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromRectangle2D(Rectangle rectangle, Object projection, BoundingSphere result);

    /**
     * Computes a bounding sphere from an rectangle in 3D. The bounding sphere is created using a subsample of points on
     * the ellipsoid and contained in the rectangle. It may not be accurate for all rectangles on all types of ellipsoids.
     * @param rectangle The valid rectangle used to create a bounding sphere.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromRectangle3D(Rectangle rectangle);

    /**
     * Computes a bounding sphere from an rectangle in 3D. The bounding sphere is created using a subsample of points on
     * the ellipsoid and contained in the rectangle. It may not be accurate for all rectangles on all types of ellipsoids.
     * @param rectangle The valid rectangle used to create a bounding sphere.
     * @param ellipsoid The ellipsoid used to determine positions of the rectangle. Default: {@link Ellipsoid#WGS84()}
     * @param surfaceHeight The height above the surface of the ellipsoid.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromRectangle3D(Rectangle rectangle, Ellipsoid ellipsoid, double surfaceHeight);

    /**
     * Computes a bounding sphere from an rectangle in 3D. The bounding sphere is created using a subsample of points on
     * the ellipsoid and contained in the rectangle. It may not be accurate for all rectangles on all types of ellipsoids.
     * @param rectangle The valid rectangle used to create a bounding sphere.
     * @param ellipsoid The ellipsoid used to determine positions of the rectangle. Default: {@link Ellipsoid#WGS84()}
     * @param surfaceHeight The height above the surface of the ellipsoid.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromRectangle3D(Rectangle rectangle, Ellipsoid ellipsoid, double surfaceHeight, BoundingSphere result);

    /**
     * Computes a bounding sphere from an rectangle projected in 2D. The bounding sphere accounts for the object's
     * minimum and maximum heights over the rectangle.
     * @param rectangle The rectangle around which to create a bounding sphere.
     * @param projection The projection used to project the rectangle into 2D. Default: {@link org.cesiumjs.cs.core.projection.GeographicProjection}
     * @param minimumHeight The minimum height over the rectangle. Default: 0.0
     * @param maximumHeight The maximum height over the rectangle. Default: 0.0
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromRectangleWithHeights2D(Rectangle rectangle, Object projection, double minimumHeight, double maximumHeight);

    /**
     * Computes a bounding sphere from an rectangle projected in 2D. The bounding sphere accounts for the object's
     * minimum and maximum heights over the rectangle.
     * @param rectangle The rectangle around which to create a bounding sphere.
     * @param projection The projection used to project the rectangle into 2D. Default: {@link org.cesiumjs.cs.core.projection.GeographicProjection}
     * @param minimumHeight The minimum height over the rectangle. Default: 0.0
     * @param maximumHeight The maximum height over the rectangle. Default: 0.0
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere fromRectangleWithHeights2D(Rectangle rectangle, Object projection, double minimumHeight, double maximumHeight, BoundingSphere result);

    /**
     * Computes a tight-fitting bounding sphere enclosing a list of 3D points, where the points are stored in a flat
     * array in X, Y, Z, order. The bounding sphere is computed by running two algorithms, a naive algorithm and
     * Ritter's algorithm. The smaller of the two spheres is used to ensure a tight fit.
     * @param positions An array of points that the bounding sphere will enclose. Each point is formed
     *                  from three elements in the array in the order X, Y, Z.
     * @return The modified result parameter or a new BoundingSphere instance if one was not provided.
     * @see <a href="http://blogs.agi.com/insight3d/index.php/2008/02/04/a-bounding/">Sphere computation article</a>
     */
    @JsMethod
    public static native BoundingSphere fromVertices(double[] positions);

    /**
     * Computes a tight-fitting bounding sphere enclosing a list of 3D points, where the points are stored in a flat
     * array in X, Y, Z, order. The bounding sphere is computed by running two algorithms, a naive algorithm and
     * Ritter's algorithm. The smaller of the two spheres is used to ensure a tight fit.
     * <pre>
     *     Example:
     *     {@code
     *     // Compute the bounding sphere from 3 positions, each specified relative to a center.
     *     // In addition to the X, Y, and Z coordinates, the points array contains two additional
     *     // elements per point which are ignored for the purpose of computing the bounding sphere.
     *     Cartesian3 center = new Cartesian3(1.0, 2.0, 3.0);
     *     double[] points = {1.0, 2.0, 3.0, 0.1, 0.2, 4.0, 5.0, 6.0, 0.1, 0.2, 7.0, 8.0, 9.0, 0.1, 0.2};
     *     BoundingSphere sphere = BoundingSphere.fromVertices(points, center, 5);
     *     }
     * </pre>
     * @param positions An array of points that the bounding sphere will enclose. Each point is formed
     *                  from three elements in the array in the order X, Y, Z.
     * @param center The position to which the positions are relative, which need not be the origin of the coordinate system.
     *               This is useful when the positions are to be used for relative-to-center (RTC) rendering. Default: {@link Cartesian3#ZERO()}
     * @param stride The number of array elements per vertex. It must be at least 3, but it may be higher.
     *               Regardless of the value of this parameter, the X coordinate of the first position is at array index 0,
     *               the Y coordinate is at array index 1, and the Z coordinate is at array index 2. When stride is 3,
     *               the X coordinate of the next position then begins at array index 3. If the stride is 5, however,
     *               two array elements are skipped and the next position begins at array index 5. Default: 0
     * @return The modified result parameter or a new BoundingSphere instance if one was not provided.
     * @see <a href="http://blogs.agi.com/insight3d/index.php/2008/02/04/a-bounding/">Sphere computation article</a>
     */
    @JsMethod
    public static native BoundingSphere fromVertices(double[] positions, Cartesian3 center, int stride);

    /**
     * Computes a tight-fitting bounding sphere enclosing a list of 3D points, where the points are stored in a flat
     * array in X, Y, Z, order. The bounding sphere is computed by running two algorithms, a naive algorithm and
     * Ritter's algorithm. The smaller of the two spheres is used to ensure a tight fit.
     * <pre>
     *     Example:
     *     {@code
     *     // Compute the bounding sphere from 3 positions, each specified relative to a center.
     *     // In addition to the X, Y, and Z coordinates, the points array contains two additional
     *     // elements per point which are ignored for the purpose of computing the bounding sphere.
     *     Cartesian3 center = new Cartesian3(1.0, 2.0, 3.0);
     *     double[] points = {1.0, 2.0, 3.0, 0.1, 0.2, 4.0, 5.0, 6.0, 0.1, 0.2, 7.0, 8.0, 9.0, 0.1, 0.2};
     *     BoundingSphere sphere = BoundingSphere.fromVertices(points, center, 5);
     *     }
     * </pre>
     * @param positions An array of points that the bounding sphere will enclose. Each point is formed
     *                  from three elements in the array in the order X, Y, Z.
     * @param center The position to which the positions are relative, which need not be the origin of the coordinate system.
     *               This is useful when the positions are to be used for relative-to-center (RTC) rendering. Default: {@link Cartesian3#ZERO()}
     * @param stride The number of array elements per vertex. It must be at least 3, but it may be higher.
     *               Regardless of the value of this parameter, the X coordinate of the first position is at array index 0,
     *               the Y coordinate is at array index 1, and the Z coordinate is at array index 2. When stride is 3,
     *               the X coordinate of the next position then begins at array index 3. If the stride is 5, however,
     *               two array elements are skipped and the next position begins at array index 5. Default: 0
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if one was not provided.
     * @see <a href="http://blogs.agi.com/insight3d/index.php/2008/02/04/a-bounding/">Sphere computation article</a>
     */
    @JsMethod
    public static native BoundingSphere fromVertices(double[] positions, Cartesian3 center, int stride, BoundingSphere result);

    /**
     * Determines which side of a plane a sphere is located.
     * @param sphere The bounding sphere to test.
     * @param plane The plane to test against.
     * @return {@link Intersect#INSIDE()} if the entire sphere is on the side of the plane the normal is pointing,
     * {@link Intersect#OUTSIDE()} if the entire sphere is on the opposite side, and
     * {@link Intersect#INTERSECTING()} if the sphere intersects the plane.
     */
    @JsMethod
    public static native Integer intersectPlane(BoundingSphere sphere, Plane plane);

    /**
     * Determines whether or not a sphere is hidden from view by the occluder.
     * @param sphere The bounding sphere surrounding the occludee object.
     * @param occluder The occluder.
     * @return true if the sphere is not visible; otherwise false.
     */
    @JsMethod
    public static native boolean isOccluded(BoundingSphere sphere, Occluder occluder);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    public static native double[] pack(BoundingSphere value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements. Default: 0
     * @return The array that was packed into
     */
    public static native double[] pack(BoundingSphere value, double[] array, int startingIndex);

    /**
     * Creates a bounding sphere in 2D from a bounding sphere in 3D world coordinates.
     * @param sphere The bounding sphere to transform to 2D.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere projectTo2D(BoundingSphere sphere);

    /**
     * Creates a bounding sphere in 2D from a bounding sphere in 3D world coordinates.
     * @param sphere The bounding sphere to transform to 2D.
     * @param projection The projection to 2D. Default: {@link org.cesiumjs.cs.core.projection.GeographicProjection}
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere projectTo2D(BoundingSphere sphere, Object projection);

    /**
     * Creates a bounding sphere in 2D from a bounding sphere in 3D world coordinates.
     * @param sphere The bounding sphere to transform to 2D.
     * @param projection The projection to 2D. Default: {@link org.cesiumjs.cs.core.projection.GeographicProjection}
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere projectTo2D(BoundingSphere sphere, Object projection, BoundingSphere result);

    /**
     * Applies a 4x4 affine transformation matrix to a bounding sphere.
     * @param sphere The bounding sphere to apply the transformation to.
     * @param transform The transformation matrix to apply to the bounding sphere.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere transform(BoundingSphere sphere, Matrix4 transform);

    /**
     * Applies a 4x4 affine transformation matrix to a bounding sphere.
     * @param sphere The bounding sphere to apply the transformation to.
     * @param transform The transformation matrix to apply to the bounding sphere.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere transform(BoundingSphere sphere, Matrix4 transform, BoundingSphere result);

    /**
     * Applies a 4x4 affine transformation matrix to a bounding sphere where there is no scale
     * The transformation matrix is not verified to have a uniform scale of 1. This method is faster than computing
     * the general bounding sphere transform using BoundingSphere.transform.
     * <pre>
     *     Example:
     *     {@code
     *     var modelMatrix = Transforms.eastNorthUpToFixedFrame(positionOnEllipsoid);
     *     BoundingSphere boundingSphere = new BoundingSphere();
     *     BoundingSphere newBoundingSphere = BoundingSphere.transformWithoutScale(boundingSphere, modelMatrix);
     *     }
     * </pre>
     * @param sphere The bounding sphere to apply the transformation to.
     * @param transform The transformation matrix to apply to the bounding sphere.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere transformWithoutScale(BoundingSphere sphere, Matrix4 transform);

    /**
     * Applies a 4x4 affine transformation matrix to a bounding sphere where there is no scale
     * The transformation matrix is not verified to have a uniform scale of 1. This method is faster than computing
     * the general bounding sphere transform using BoundingSphere.transform.
     * <pre>
     *     Example:
     *     {@code
     *     var modelMatrix = Transforms.eastNorthUpToFixedFrame(positionOnEllipsoid);
     *     BoundingSphere boundingSphere = new BoundingSphere();
     *     BoundingSphere newBoundingSphere = BoundingSphere.transformWithoutScale(boundingSphere, modelMatrix);
     *     }
     * </pre>
     * @param sphere The bounding sphere to apply the transformation to.
     * @param transform The transformation matrix to apply to the bounding sphere.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere transformWithoutScale(BoundingSphere sphere, Matrix4 transform, BoundingSphere result);

    /**
     * Computes a bounding sphere that contains both the left and right bounding spheres.
     * @param left A sphere to enclose in a bounding sphere.
     * @param right A sphere to enclose in a bounding sphere.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere union(BoundingSphere left, BoundingSphere right);

    /**
     * Computes a bounding sphere that contains both the left and right bounding spheres.
     * @param left A sphere to enclose in a bounding sphere.
     * @param right A sphere to enclose in a bounding sphere.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public static native BoundingSphere union(BoundingSphere left, BoundingSphere right, BoundingSphere result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new BoundingSphere instance if one was not provided.
     */
    public static native BoundingSphere unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Default: 0
     * @return The modified result parameter or a new BoundingSphere instance if one was not provided.
     */
    public static native BoundingSphere unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Default: 0
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new BoundingSphere instance if one was not provided.
     */
    public static native BoundingSphere unpack(double[] array, int startingIndex, BoundingSphere result);

    /**
     * Duplicates this BoundingSphere instance.
     * @return The modified result parameter or a new BoundingSphere instance if none was provided.
     */
    @JsMethod
    public native BoundingSphere clone();

    /**
     * The distances calculated by the vector from the center of the bounding sphere to position projected onto
     * direction plus/minus the radius of the bounding sphere.
     * If you imagine the infinite number of planes with normal direction, this computes the smallest distance to the
     * closest and farthest planes from position that intersect the bounding sphere.
     * @param position The position to calculate the distance from.
     * @param direction The direction from position.
     * @return The nearest and farthest distances on the bounding sphere from position in direction.
     */
    @JsMethod
    public native Interval computePlaneDistances(Cartesian3 position, Cartesian3 direction);

    /**
     * The distances calculated by the vector from the center of the bounding sphere to position projected onto
     * direction plus/minus the radius of the bounding sphere.
     * If you imagine the infinite number of planes with normal direction, this computes the smallest distance to the
     * closest and farthest planes from position that intersect the bounding sphere.
     * @param position The position to calculate the distance from.
     * @param direction The direction from position.
     * @param result A Interval to store the nearest and farthest distances.
     * @return The nearest and farthest distances on the bounding sphere from position in direction.
     */
    @JsMethod
    public native Interval computePlaneDistances(Cartesian3 position, Cartesian3 direction, Interval result);

    /**
     * Computes the estimated distance squared from the closest point on a bounding sphere to a point.
     * @param cartesian The point
     * @return The estimated distance squared from the bounding sphere to the point.
     */
    @JsMethod
    public native double distanceSquaredTo(Cartesian3 cartesian);

    /**
     * Compares this BoundingSphere against the provided BoundingSphere componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side BoundingSphere.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(BoundingSphere right);

    /**
     * Determines which side of a plane the sphere is located.
     * @param plane The plane to test against.
     * @return {@link Intersect#INSIDE()} if the entire sphere is on the side of the plane the normal is pointing, {@link Intersect#OUTSIDE()}
     * if the entire sphere is on the opposite side, and {@link Intersect#INTERSECTING()} if the sphere intersects the plane.
     */
    @JsMethod
    public native Integer intersectPlane(Plane plane);

    /**
     * Determines whether or not a sphere is hidden from view by the occluder.
     * @param occluder The occluder.
     * @return true if the sphere is not visible; otherwise false.
     */
    @JsMethod
    public native boolean isOccluded(Occluder occluder);
}
