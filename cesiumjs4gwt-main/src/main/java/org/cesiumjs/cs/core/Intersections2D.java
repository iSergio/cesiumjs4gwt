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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Contains functions for operating on 2D triangles.
 *
 * @author Serge Silaev aka iSergio
 */
// TODO: Examples
@JsType(isNative = true, namespace = "Cesium", name = "Intersections2D")
public class Intersections2D {
    /**
     * Splits a 2D triangle at given axis-aligned threshold value and returns the
     * resulting polygon on a given side of the threshold. The resulting polygon may
     * have 0, 1, 2, 3, or 4 vertices.
     *
     * @param threshold The threshold coordinate value at which to clip the
     *                  triangle.
     * @param keepAbove true to keep the portion of the triangle above the
     *                  threshold, or false to keep the portion below.
     * @param u0        The coordinate of the first vertex in the triangle, in
     *                  counter-clockwise order.
     * @param u1        The coordinate of the second vertex in the triangle, in
     *                  counter-clockwise order.
     * @param u2        The coordinate of the third vertex in the triangle, in
     *                  counter-clockwise order.
     * @return The polygon that results after the clip, specified as a list of
     * vertices. The vertices are specified in counter-clockwise order. Each
     * vertex is either an index from the existing list (identified as a 0,
     * 1, or 2) or -1 indicating a new vertex not in the original triangle.
     * For new vertices, the -1 is followed by three additional numbers: the
     * index of each of the two original vertices forming the line segment
     * that the new vertex lies on, and the fraction of the distance from
     * the first vertex to the second one.
     */
    @JsMethod
    public static native double[] clipTriangleAtAxisAlignedThreshold(double threshold, boolean keepAbove, double u0,
                                                                     double u1, double u2);

    /**
     * Splits a 2D triangle at given axis-aligned threshold value and returns the
     * resulting polygon on a given side of the threshold. The resulting polygon may
     * have 0, 1, 2, 3, or 4 vertices.
     *
     * @param threshold The threshold coordinate value at which to clip the
     *                  triangle.
     * @param keepAbove true to keep the portion of the triangle above the
     *                  threshold, or false to keep the portion below.
     * @param u0        The coordinate of the first vertex in the triangle, in
     *                  counter-clockwise order.
     * @param u1        The coordinate of the second vertex in the triangle, in
     *                  counter-clockwise order.
     * @param u2        The coordinate of the third vertex in the triangle, in
     *                  counter-clockwise order.
     * @param result    The array into which to copy the result. If this parameter
     *                  is not supplied, a new array is constructed and returned.
     * @return The polygon that results after the clip, specified as a list of
     * vertices. The vertices are specified in counter-clockwise order. Each
     * vertex is either an index from the existing list (identified as a 0,
     * 1, or 2) or -1 indicating a new vertex not in the original triangle.
     * For new vertices, the -1 is followed by three additional numbers: the
     * index of each of the two original vertices forming the line segment
     * that the new vertex lies on, and the fraction of the distance from
     * the first vertex to the second one.
     */
    @JsMethod
    public static native double[] clipTriangleAtAxisAlignedThreshold(double threshold, boolean keepAbove, double u0,
                                                                     double u1, double u2, double[] result);

    /**
     * Compute the barycentric coordinates of a 2D position within a 2D triangle.
     *
     * @param x  The x coordinate of the position for which to find the barycentric
     *           coordinates.
     * @param y  The y coordinate of the position for which to find the barycentric
     *           coordinates.
     * @param x1 The x coordinate of the triangle's first vertex.
     * @param y1 The y coordinate of the triangle's first vertex.
     * @param x2 The x coordinate of the triangle's second vertex.
     * @param y2 The y coordinate of the triangle's second vertex.
     * @param x3 The x coordinate of the triangle's third vertex.
     * @param y3 The y coordinate of the triangle's third vertex.
     * @return The barycentric coordinates of the position within the triangle.
     */
    @JsMethod
    public static native Cartesian3 computeBarycentricCoordinates(double x, double y, double x1, double y1, double x2,
                                                                  double y2, double x3, double y3);

    /**
     * Compute the barycentric coordinates of a 2D position within a 2D triangle.
     *
     * @param x      The x coordinate of the position for which to find the
     *               barycentric coordinates.
     * @param y      The y coordinate of the position for which to find the
     *               barycentric coordinates.
     * @param x1     The x coordinate of the triangle's first vertex.
     * @param y1     The y coordinate of the triangle's first vertex.
     * @param x2     The x coordinate of the triangle's second vertex.
     * @param y2     The y coordinate of the triangle's second vertex.
     * @param x3     The x coordinate of the triangle's third vertex.
     * @param y3     The y coordinate of the triangle's third vertex.
     * @param result The instance into to which to copy the result. If this
     *               parameter is undefined, a new instance is created and returned.
     * @return The barycentric coordinates of the position within the triangle.
     */
    @JsMethod
    public static native Cartesian3 computeBarycentricCoordinates(double x, double y, double x1, double y1, double x2,
                                                                  double y2, double x3, double y3, Cartesian3 result);

    /**
     * Compute the intersection between 2 line segments
     *
     * @param x00 The x coordinate of the first line's first vertex.
     * @param y00 The y coordinate of the first line's first vertex.
     * @param x01 The x coordinate of the first line's second vertex.
     * @param y01 The y coordinate of the first line's second vertex.
     * @param x10 The x coordinate of the second line's first vertex.
     * @param y10 The y coordinate of the second line's first vertex.
     * @param x11 The x coordinate of the second line's second vertex.
     * @param y11 The y coordinate of the second line's second vertex.
     * @return The intersection point, undefined if there is no intersection point
     * or lines are coincident.
     */
    @JsMethod
    public static native Cartesian2 computeLineSegmentLineSegmentIntersection(double x00, double y00, double x01,
                                                                              double y01, double x10, double y10, double x11, double y11);

    /**
     * Compute the intersection between 2 line segments
     *
     * @param x00    The x coordinate of the first line's first vertex.
     * @param y00    The y coordinate of the first line's first vertex.
     * @param x01    The x coordinate of the first line's second vertex.
     * @param y01    The y coordinate of the first line's second vertex.
     * @param x10    The x coordinate of the second line's first vertex.
     * @param y10    The y coordinate of the second line's first vertex.
     * @param x11    The x coordinate of the second line's second vertex.
     * @param y11    The y coordinate of the second line's second vertex.
     * @param result The instance into to which to copy the result. If this
     *               parameter is undefined, a new instance is created and returned.
     * @return The intersection point, undefined if there is no intersection point
     * or lines are coincident.
     */
    @JsMethod
    public static native Cartesian2 computeLineSegmentLineSegmentIntersection(double x00, double y00, double x01,
                                                                              double y01, double x10, double y10, double x11, double y11, Cartesian2 result);
}
