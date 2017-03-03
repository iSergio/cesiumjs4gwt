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

//TODO: Examples
/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "AxisAlignedBoundingBox")
public class AxisAlignedBoundingBox {
    /**
     * The center point of the bounding box.
     */
    @JsProperty
    public Cartesian3 center;
    /**
     * The maximum point defining the bounding box.
     * Default: {@link Cartesian3#ZERO()}
     */
    @JsProperty
    public Cartesian3 maximum;
    /**
     * The minimum point defining the bounding box.
     * Default: {@link Cartesian3#ZERO()}
     */
    @JsProperty
    public Cartesian3 minimum;

    /**
     * Creates an instance of an AxisAlignedBoundingBox from the minimum and maximum points along the x, y, and z axes.
     * @see BoundingSphere
     * @see BoundingRectangle
     */
    @JsConstructor
    public AxisAlignedBoundingBox() {}

    /**
     * Creates an instance of an AxisAlignedBoundingBox from the minimum and maximum points along the x, y, and z axes.
     * @param minimum The minimum point along the x, y, and z axes.
     * @see BoundingSphere
     * @see BoundingRectangle
     */
    @JsConstructor
    public AxisAlignedBoundingBox(Cartesian3 minimum) {}

    /**
     * Creates an instance of an AxisAlignedBoundingBox from the minimum and maximum points along the x, y, and z axes.
     * @param minimum The minimum point along the x, y, and z axes.
     * @param maximum The maximum point along the x, y, and z axes.
     * @see BoundingSphere
     * @see BoundingRectangle
     */
    @JsConstructor
    public AxisAlignedBoundingBox(Cartesian3 minimum, Cartesian3 maximum) {}

    /**
     * Creates an instance of an AxisAlignedBoundingBox from the minimum and maximum points along the x, y, and z axes.
     * @param minimum The minimum point along the x, y, and z axes.
     * @param maximum The maximum point along the x, y, and z axes.
     * @param center The center of the box; automatically computed if not supplied.
     * @see BoundingSphere
     * @see BoundingRectangle
     */
    @JsConstructor
    public AxisAlignedBoundingBox(Cartesian3 minimum, Cartesian3 maximum, Cartesian3 center) {}

    /**
     * Duplicates a AxisAlignedBoundingBox instance.
     * @param box The bounding box to duplicate.
     * @return The modified result parameter or a new AxisAlignedBoundingBox instance if none was provided. (Returns undefined if box is undefined)
     */
    @JsMethod
    public static native AxisAlignedBoundingBox clone(AxisAlignedBoundingBox box);

    /**
     * Duplicates a AxisAlignedBoundingBox instance.
     * @param box The bounding box to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new AxisAlignedBoundingBox instance if none was provided. (Returns undefined if box is undefined)
     */
    @JsMethod
    public static native AxisAlignedBoundingBox clone(AxisAlignedBoundingBox box, AxisAlignedBoundingBox result);

    /**
     * Compares the provided AxisAlignedBoundingBox componentwise and returns true if they are equal, false otherwise.
     * @param left The first AxisAlignedBoundingBox.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(AxisAlignedBoundingBox left);

    /**
     * Compares the provided AxisAlignedBoundingBox componentwise and returns true if they are equal, false otherwise.
     * @param left The first AxisAlignedBoundingBox.
     * @param right The second AxisAlignedBoundingBox.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(AxisAlignedBoundingBox left, AxisAlignedBoundingBox right);

    /**
     * Computes an instance of an AxisAlignedBoundingBox.
     * The box is determined by finding the points spaced the farthest apart on the x, y, and z axes.
     * @param positions List of points that the bounding box will enclose. Each point must have a x, y, and z properties.
     * @param result The object onto which to store the result.
     * @return The object onto which to store the result.
     */
    @JsMethod
    public static native AxisAlignedBoundingBox fromPoints(Cartesian3[] positions, AxisAlignedBoundingBox result);

    /**
     * Determines which side of a plane a box is located.
     * @param box The bounding box to test.
     * @param plane The plane to test against.
     * @return {@link org.cesiumjs.cs.core.enums.Intersect#INSIDE()} if the entire box is on the side of the plane the
     * normal is pointing, {@link Intersect#OUTSIDE()} if the entire box is on the opposite side, and {@link Intersect#INTERSECTING()}
     * if the box intersects the plane.
     */
    @JsMethod
    public static native Integer intersectPlane(AxisAlignedBoundingBox box, Plane plane);

    /**
     * Determines which side of a plane this box is located.
     * @param plane The plane to test against.
     * @return {@link org.cesiumjs.cs.core.enums.Intersect#INSIDE()} if the entire box is on the side of the plane the
     * normal is pointing, {@link Intersect#OUTSIDE()} if the entire box is on the opposite side, and {@link Intersect#INTERSECTING()}
     * if the box intersects the plane.
     */
    @JsMethod
    public native Integer intersectPlane(Plane plane);
}
