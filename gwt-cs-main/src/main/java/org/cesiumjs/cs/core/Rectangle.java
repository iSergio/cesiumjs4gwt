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
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Rectangle")
public class Rectangle {
    /**
     * The largest possible rectangle.
     */
    public static native Rectangle MAX_VALUE();
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public static int packedLength;
    /**
     * The easternmost longitude in radians in the range [-Pi, Pi].
     * Default: 0.0
     */
    @JsProperty
    public double east;
    /**
     * Gets the height of the rectangle in radians.
     */
    @JsProperty
    public double height;
    /**
     * The northernmost latitude in radians in the range [-Pi/2, Pi/2].
     * Default: 0.0
     */
    @JsProperty
    public double north;
    /**
     * The southernmost latitude in radians in the range [-Pi/2, Pi/2].
     * Default:  0.0
     */
    @JsProperty
    public double south;
    /**
     * The westernmost longitude in radians in the range [-Pi, Pi].
     * Default: 0.0
     */
    @JsProperty
    public double west;
    /**
     * Gets the width of the rectangle in radians.
     */
    @JsProperty
    public double width;

    /**
     * A two dimensional region specified as longitude and latitude coordinates.
     * @see Packable
     */
    @JsConstructor
    public Rectangle() {}

    /**
     * A two dimensional region specified as longitude and latitude coordinates.
     * @param west The westernmost longitude, in radians, in the range [-Pi, Pi].
     * @param south The southernmost latitude, in radians, in the range [-Pi/2, Pi/2].
     * @param east The easternmost longitude, in radians, in the range [-Pi, Pi].
     * @param north The northernmost latitude, in radians, in the range [-Pi/2, Pi/2].
     * @see Packable
     */
    @JsConstructor
    public Rectangle(double west, double south, double east, double north) {}

    /**
     * Computes the center of an rectangle.
     * @param rectangle The rectangle for which to find the center
     * @return The modified result parameter or a new Cartographic instance if none was provided.
     */
    @JsMethod
    public static native Cartographic center(Rectangle rectangle);

    /**
     * Computes the center of an rectangle.
     * @param rectangle The rectangle for which to find the center
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Cartographic instance if none was provided.
     */
    @JsMethod
    public static native Cartographic center(Rectangle rectangle, Cartographic result);

    /**
     * Duplicates an Rectangle.
     * @param rectangle The rectangle to clone.
     * @return The modified result parameter or a new Rectangle instance if none was provided. (Returns undefined if rectangle is undefined)
     */
    @JsMethod
    public static native Rectangle clone(Rectangle rectangle);

    /**
     * Duplicates an Rectangle.
     * @param rectangle The rectangle to clone.
     * @param result The object onto which to store the result, or undefined if a new instance should be created.
     * @return The modified result parameter or a new Rectangle instance if none was provided. (Returns undefined if rectangle is undefined)
     */
    @JsMethod
    public static native Rectangle clone(Rectangle rectangle, Rectangle result);

    /**
     * Computes the height of a rectangle in radians.
     * @param rectangle The rectangle to compute the height of.
     * @return The height.
     */
    @JsMethod
    public static native double computeHeight(Rectangle rectangle);

    /**
     * Computes the width of a rectangle in radians.
     * @param rectangle The rectangle to compute the width of.
     * @return The width.
     */
    @JsMethod
    public static native double computeWidth(Rectangle rectangle);

    /**
     * Returns true if the cartographic is on or inside the rectangle, false otherwise.
     * @param rectangle The rectangle
     * @param cartographic The cartographic to test.
     * @return true if the provided cartographic is inside the rectangle, false otherwise.
     */
    @JsMethod
    public static native boolean contains(Rectangle rectangle, Cartographic cartographic);

    /**
     * Compares the provided rectangles and returns true if they are equal, false otherwise.
     * @param left The first Rectangle.
     * @param right The second Rectangle.
     * @return true if left and right are equal; otherwise false.
     */
    @JsMethod
    public static native boolean equals(Rectangle left, Rectangle right);

    /**
     * Computes a rectangle by enlarging the provided rectangle until it contains the provided cartographic.
     * @param rectangle A rectangle to expand.
     * @param cartographic A cartographic to enclose in a rectangle.
     * @return The modified result parameter or a new Rectangle instance if one was not provided.
     */
    @JsMethod
    public static native Rectangle expand(Rectangle rectangle, Cartographic cartographic);

    /**
     * Computes a rectangle by enlarging the provided rectangle until it contains the provided cartographic.
     * @param rectangle A rectangle to expand.
     * @param cartographic A cartographic to enclose in a rectangle.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Rectangle instance if one was not provided.
     */
    @JsMethod
    public static native Rectangle expand(Rectangle rectangle, Cartographic cartographic, Rectangle result);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartesians The list of Cartesian instances.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartesianArray(Cartesian2[] cartesians);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartesians The list of Cartesian instances.
     * @param ellipsoid The ellipsoid the cartesians are on. Default: {@link Ellipsoid#WGS84}.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartesianArray(Cartesian2[] cartesians, Ellipsoid ellipsoid);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartesians The list of Cartesian instances.
     * @param ellipsoid The ellipsoid the cartesians are on. Default: {@link Ellipsoid#WGS84}.
     * @param result The object onto which to store the result, or undefined if a new instance should be created.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartesianArray(Cartesian2[] cartesians, Ellipsoid ellipsoid, Rectangle result);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartesians The list of Cartesian instances.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartesianArray(Cartesian3[] cartesians);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartesians The list of Cartesian instances.
     * @param ellipsoid The ellipsoid the cartesians are on. Default: {@link Ellipsoid#WGS84}.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartesianArray(Cartesian3[] cartesians, Ellipsoid ellipsoid);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartesians The list of Cartesian instances.
     * @param ellipsoid The ellipsoid the cartesians are on. Default: {@link Ellipsoid#WGS84}.
     * @param result The object onto which to store the result, or undefined if a new instance should be created.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartesianArray(Cartesian3[] cartesians, Ellipsoid ellipsoid, Rectangle result);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartesians The list of Cartesian instances.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartesianArray(Cartesian4[] cartesians);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartesians The list of Cartesian instances.
     * @param ellipsoid The ellipsoid the cartesians are on. Default: {@link Ellipsoid#WGS84}.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartesianArray(Cartesian4[] cartesians, Ellipsoid ellipsoid);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartesians The list of Cartesian instances.
     * @param ellipsoid The ellipsoid the cartesians are on. Default: {@link Ellipsoid#WGS84}.
     * @param result The object onto which to store the result, or undefined if a new instance should be created.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartesianArray(Cartesian4[] cartesians, Ellipsoid ellipsoid, Rectangle result);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartographics The list of Cartographic instances.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartographicArray(Cartographic[] cartographics);

    /**
     * Creates the smallest possible Rectangle that encloses all positions in the provided array.
     * @param cartographics The list of Cartographic instances.
     * @param result The object onto which to store the result, or undefined if a new instance should be created.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromCartographicArray(Cartographic[] cartographics, Rectangle result);

    /**
     * Creates an rectangle given the boundary longitude and latitude in degrees.
     * <pre>
     *     Example:
     *     {@code
     *     Rectangle rectangle = Rectangle.fromDegrees(0.0, 20.0, 10.0, 30.0);
     *     }
     * </pre>
     * @param west The westernmost longitude in degrees in the range [-180.0, 180.0].
     * @param south The southernmost latitude in degrees in the range [-90.0, 90.0].
     * @param east The easternmost longitude in degrees in the range [-180.0, 180.0].
     * @param north The northernmost latitude in degrees in the range [-90.0, 90.0].
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromDegrees(double west, double south, double east, double north);

    /**
     * Creates an rectangle given the boundary longitude and latitude in degrees.
     * <pre>
     *     Example:
     *     {@code
     *     Rectangle rectangle = Rectangle.fromDegrees(0.0, 20.0, 10.0, 30.0);
     *     }
     * </pre>
     * @param west The westernmost longitude in degrees in the range [-180.0, 180.0].
     * @param south The southernmost latitude in degrees in the range [-90.0, 90.0].
     * @param east The easternmost longitude in degrees in the range [-180.0, 180.0].
     * @param north The northernmost latitude in degrees in the range [-90.0, 90.0].
     * @param result The object onto which to store the result, or undefined if a new instance should be created.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromDegrees(double west, double south, double east, double north, Rectangle result);

    /**
     * Creates an rectangle given the boundary longitude and latitude in radians.
     * @param west The westernmost longitude in radians in the range [-Math.PI, Math.PI]. Default: 0.0.
     * @param south The southernmost latitude in radians in the range [-Math.PI/2, Math.PI/2]. Default: 0.0.
     * @param east The easternmost longitude in radians in the range [-Math.PI, Math.PI]. Default: 0.0.
     * @param north The northernmost latitude in radians in the range [-Math.PI/2, Math.PI/2]. Default: 0.0.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromRadians(double west, double south, double east, double north);

    /**
     * Creates an rectangle given the boundary longitude and latitude in radians.
     * @param west The westernmost longitude in radians in the range [-Math.PI, Math.PI]. Default: 0.0.
     * @param south The southernmost latitude in radians in the range [-Math.PI/2, Math.PI/2]. Default: 0.0.
     * @param east The easternmost longitude in radians in the range [-Math.PI, Math.PI]. Default: 0.0.
     * @param north The northernmost latitude in radians in the range [-Math.PI/2, Math.PI/2]. Default: 0.0.
     * @param result The object onto which to store the result, or undefined if a new instance should be created.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle fromRadians(double west, double south, double east, double north, Rectangle result);

    /**
     * Computes the intersection of two rectangles
     * @param rectangle On rectangle to find an intersection
     * @param otherRectangle Another rectangle to find an intersection
     * @return The modified result parameter, a new Rectangle instance if none was provided or undefined if there is no intersection.
     */
    @JsMethod
    public static native Rectangle intersection(Rectangle rectangle, Rectangle otherRectangle);

    /**
     * Computes the intersection of two rectangles
     * @param rectangle On rectangle to find an intersection
     * @param otherRectangle Another rectangle to find an intersection
     * @param result The object onto which to store the result.
     * @return The modified result parameter, a new Rectangle instance if none was provided or undefined if there is no intersection.
     */
    @JsMethod
    public static native Rectangle intersection(Rectangle rectangle, Rectangle otherRectangle, Rectangle result);

    /**
     * Computes the northeast corner of an rectangle.
     * @param rectangle The rectangle for which to find the corner
     * @return The modified result parameter or a new Cartographic instance if none was provided.
     */
    @JsMethod
    public static native Cartographic northeast(Rectangle rectangle);

    /**
     * Computes the northeast corner of an rectangle.
     * @param rectangle The rectangle for which to find the corner
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Cartographic instance if none was provided.
     */
    @JsMethod
    public static native Cartographic northeast(Rectangle rectangle, Cartographic result);

    /**
     * Computes the northwest corner of an rectangle.
     * @param rectangle The rectangle for which to find the corner
     * @return The modified result parameter or a new Cartographic instance if none was provided.
     */
    @JsMethod
    public static native Cartographic northwest(Rectangle rectangle);

    /**
     * Computes the northwest corner of an rectangle.
     * @param rectangle The rectangle for which to find the corner
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Cartographic instance if none was provided.
     */
    @JsMethod
    public static native Cartographic northwest(Rectangle rectangle, Cartographic result);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Rectangle value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The array to pack into.
     * @param startingIndex The index into the array at which to start packing the elements.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Rectangle value, double[] array, int startingIndex);

    /**
     * Computes the southeast corner of an rectangle.
     * @param rectangle The rectangle for which to find the corner
     * @return The modified result parameter or a new Cartographic instance if none was provided.
     */
    @JsMethod
    public static native Cartographic southeast(Rectangle rectangle);

    /**
     * Computes the southeast corner of an rectangle.
     * @param rectangle The rectangle for which to find the corner
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Cartographic instance if none was provided.
     */
    @JsMethod
    public static native Cartographic southeast(Rectangle rectangle, Cartographic result);

    /**
     * Computes the southwest corner of an rectangle.
     * @param rectangle The rectangle for which to find the corner
     * @return The modified result parameter or a new Cartographic instance if none was provided.
     */
    @JsMethod
    public static native Cartographic southwest(Rectangle rectangle);

    /**
     * Computes the southwest corner of an rectangle.
     * @param rectangle The rectangle for which to find the corner
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Cartographic instance if none was provided.
     */
    @JsMethod
    public static native Cartographic southwest(Rectangle rectangle, Cartographic result);

    /**
     * Samples an rectangle so that it includes a list of Cartesian points suitable for passing to BoundingSphere#fromPoints.
     * Sampling is necessary to account for rectangles that cover the poles or cross the equator.
     * @param rectangle The rectangle to subsample.
     * @return The modified result parameter or a new Array of Cartesians instances if none was provided.
     */
    @JsMethod
    public static native Cartesian3[] subsample(Rectangle rectangle);

    /**
     * Samples an rectangle so that it includes a list of Cartesian points suitable for passing to BoundingSphere#fromPoints.
     * Sampling is necessary to account for rectangles that cover the poles or cross the equator.
     * @param rectangle The rectangle to subsample.
     * @param ellipsoid The ellipsoid to use. Default: {@link Ellipsoid#WGS84()}
     * @return The modified result parameter or a new Array of Cartesians instances if none was provided.
     */
    @JsMethod
    public static native Cartesian3[] subsample(Rectangle rectangle, Ellipsoid ellipsoid);

    /**
     * Samples an rectangle so that it includes a list of Cartesian points suitable for passing to BoundingSphere#fromPoints.
     * Sampling is necessary to account for rectangles that cover the poles or cross the equator.
     * @param rectangle The rectangle to subsample.
     * @param ellipsoid The ellipsoid to use. Default: {@link Ellipsoid#WGS84()}
     * @param surfaceHeight The height of the rectangle above the ellipsoid. Default: 0.0
     * @return The modified result parameter or a new Array of Cartesians instances if none was provided.
     */
    @JsMethod
    public static native Cartesian3[] subsample(Rectangle rectangle, Ellipsoid ellipsoid, double surfaceHeight);

    /**
     * Samples an rectangle so that it includes a list of Cartesian points suitable for passing to BoundingSphere#fromPoints.
     * Sampling is necessary to account for rectangles that cover the poles or cross the equator.
     * @param rectangle The rectangle to subsample.
     * @param ellipsoid The ellipsoid to use. Default: {@link Ellipsoid#WGS84()}
     * @param surfaceHeight The height of the rectangle above the ellipsoid. Default: 0.0
     * @param result The array of Cartesians onto which to store the result.
     * @return The modified result parameter or a new Array of Cartesians instances if none was provided.
     */
    @JsMethod
    public static native Cartesian3[] subsample(Rectangle rectangle, Ellipsoid ellipsoid, double surfaceHeight, Cartesian3[] result);

    /**
     * Computes a rectangle that is the union of two rectangles.
     * @param rectangle A rectangle to enclose in rectangle.
     * @param otherRectangle A rectangle to enclose in a rectangle.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public static native Rectangle union(Rectangle rectangle, Rectangle otherRectangle);

    /**
     * Computes a rectangle that is the union of two rectangles.
     * @param rectangle A rectangle to enclose in rectangle.
     * @param otherRectangle A rectangle to enclose in a rectangle.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    public static native Rectangle union(Rectangle rectangle, Rectangle otherRectangle, Rectangle result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new Rectangle instance if one was not provided.
     */
    @JsMethod
    public static native Rectangle unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Default: 0
     * @return The modified result parameter or a new Rectangle instance if one was not provided.
     */
    @JsMethod
    public static native Rectangle unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked. Default: 0
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new Rectangle instance if one was not provided.
     */
    @JsMethod
    public static native Rectangle unpack(double[] array, int startingIndex, Rectangle result);

    /**
     * Checks an Rectangle's properties and throws if they are not in valid ranges.
     * @param rectangle The rectangle to validate
     */
    @JsMethod
    public static native void validate(Rectangle rectangle);
    /**
     * Duplicates this Rectangle.
     * @return The modified result parameter or a new Rectangle instance if none was provided.
     */
    @JsMethod
    public native Rectangle clone();

    /**
     * Compares the provided Rectangle with this Rectangle componentwise and returns true if they are equal, false otherwise.
     * @param other The Rectangle to compare.
     * @return true if the Rectangles are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(Rectangle other);

    /**
     * Compares the provided Rectangle with this Rectangle componentwise and returns true if they are within the
     * provided epsilon, false otherwise.
     * @param other The Rectangle to compare.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if the Rectangles are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(Rectangle other, double epsilon);
}
