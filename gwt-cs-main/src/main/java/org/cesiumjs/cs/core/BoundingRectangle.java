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
import org.cesiumjs.cs.core.projection.MapProjection;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "BoundingRectangle")
public class BoundingRectangle {
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty(name = "packedLength")
    public static native int packedLength();
    /**
     * The height of the rectangle.
     * Default: 0.0
     */
    @JsProperty
    public double height;

    /**
     * The width of the rectangle.
     * Defult: 0.0
     */
    @JsProperty
    double width;
    /**
     * The x coordinate of the rectangle.
     * Default: 0.0
     */
    @JsProperty
    double x;
    /**
     * The y coordinate of the rectangle.
     * Default: 0.0
     */
    @JsProperty
    double y;

    @JsConstructor
    public BoundingRectangle() {}

    /**
     * A bounding rectangle given by a corner, width and height.
     * @param x The x coordinate of the rectangle.
     * @param y The y coordinate of the rectangle.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    @JsConstructor
    public BoundingRectangle(double x, double y, double width, double height) {}

    /**
     * Duplicates a BoundingRectangle instance.
     * @param rectangle The bounding rectangle to duplicate.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     * (Returns undefined if rectangle is undefined)
     */
    @JsMethod
    public static native BoundingRectangle clone(BoundingRectangle rectangle);

    /**
     * Duplicates a BoundingRectangle instance.
     * @param rectangle The bounding rectangle to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     * (Returns undefined if rectangle is undefined)
     */
    @JsMethod
    public static native BoundingRectangle clone(BoundingRectangle rectangle, BoundingRectangle result);

    /**
     * Compares the provided BoundingRectangles componentwise and returns true if they are equal, false otherwise.
     * @param left The first BoundingRectangle.
     * @param right The second BoundingRectangle.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(BoundingRectangle left, BoundingRectangle right);

    /**
     * Computes a bounding rectangle by enlarging the provided rectangle until it contains the provided point.
     * @param rectangle A rectangle to expand.
     * @param point A point to enclose in a bounding rectangle.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle expand(BoundingRectangle rectangle, Cartesian2 point);

    /**
     * Computes a bounding rectangle by enlarging the provided rectangle until it contains the provided point.
     * @param rectangle A rectangle to expand.
     * @param point A point to enclose in a bounding rectangle.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle expand(BoundingRectangle rectangle, Cartesian2 point, BoundingRectangle result);

    /**
     * Computes a bounding rectangle enclosing the list of 2D points. The rectangle is oriented with the corner at the bottom left.
     * @param positions List of points that the bounding rectangle will enclose. Each point must have x and y properties.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle fromPoints(Cartesian2[] positions);

    /**
     * Computes a bounding rectangle enclosing the list of 2D points. The rectangle is oriented with the corner at the bottom left.
     * @param positions List of points that the bounding rectangle will enclose. Each point must have x and y properties.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle fromPoints(Cartesian2[] positions, BoundingRectangle result);

    /**
     * Computes a bounding rectangle from an rectangle.
     * @param rectangle The valid rectangle used to create a bounding rectangle.
     * @param projection The projection used to project the rectangle into 2D. Default: {@link org.cesiumjs.cs.core.projection.GeographicProjection}
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle fromRectangle(Rectangle rectangle, MapProjection projection);

    /**
     * Computes a bounding rectangle from an rectangle.
     * @param rectangle The valid rectangle used to create a bounding rectangle.
     * @param projection The projection used to project the rectangle into 2D. Default: {@link org.cesiumjs.cs.core.projection.GeographicProjection}
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle fromRectangle(Rectangle rectangle, MapProjection projection, BoundingRectangle result);

    /**
     * Determines if two rectangles intersect.
     * @param left A rectangle to check for intersection.
     * @param right The other rectangle to check for intersection.
     * @return {@link Intersect#INTERSECTING()} if the rectangles intersect, {@link Intersect#OUTSIDE()}  otherwise.
     */
    @JsMethod
    public static native Integer intersect(BoundingRectangle left, BoundingRectangle right);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(BoundingRectangle value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(BoundingRectangle value, double[] array, int startingIndex);

    /**
     * Computes a bounding rectangle that is the union of the left and right bounding rectangles.
     * @param left A rectangle to enclose in bounding rectangle.
     * @param right A rectangle to enclose in a bounding rectangle.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle union(BoundingRectangle left, BoundingRectangle right);

    /**
     * Computes a bounding rectangle that is the union of the left and right bounding rectangles.
     * @param left A rectangle to enclose in bounding rectangle.
     * @param right A rectangle to enclose in a bounding rectangle.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle union(BoundingRectangle left, BoundingRectangle right, BoundingRectangle result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public static native BoundingRectangle unpack(double[] array, int startingIndex, BoundingRectangle result);

    /**
     * Duplicates this BoundingRectangle instance.
     * @return The modified result parameter or a new BoundingRectangle instance if one was not provided.
     */
    @JsMethod
    public native BoundingRectangle clone();

    /**
     * Compares this BoundingRectangle against the provided BoundingRectangle componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side BoundingRectangle.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(BoundingRectangle right);

    /**
     * Determines if this rectangle intersects with another.
     * @param right A rectangle to check for intersection.
     * @return {@link Intersect#INTERSECTING()} if the rectangles intersect, {@link Intersect#OUTSIDE()} otherwise}.
     */
    @JsMethod
    public native Integer intersect(BoundingRectangle right);
}
