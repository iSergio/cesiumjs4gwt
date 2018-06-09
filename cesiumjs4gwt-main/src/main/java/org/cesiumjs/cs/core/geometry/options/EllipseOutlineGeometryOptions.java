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

package org.cesiumjs.cs.core.geometry.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Math;

/**
 * Options for {@link org.cesiumjs.cs.core.geometry.EllipseOutlineGeometry}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class EllipseOutlineGeometryOptions {
    /**
     * The ellipse's center point in the fixed frame.
     */
    @JsProperty
    public Cartesian3 center;
    /**
     * The length of the ellipse's semi-major axis in meters.
     */
    @JsProperty
    public double semiMajorAxis;
    /**
     * The length of the ellipse's semi-minor axis in meters.
     */
    @JsProperty
    public double semiMinorAxis;
    /**
     * The ellipsoid the ellipse will be on.
     * Default: {@link Ellipsoid#WGS84()}
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The distance in meters between the ellipse and the ellipsoid surface.
     * Default: 0.0
     */
    @JsProperty
    public double height;
    /**
     * The distance in meters between the ellipse's extruded face and the ellipsoid surface.
     */
    @JsProperty
    public double extrudedHeight;
    /**
     * The angle of rotation counter-clockwise from north.
     * Default: 0.0
     */
    @JsProperty
    public double rotation;
    /**
     * The angular distance between points on the ellipse in radians.
     * Default: {@link Math#RADIANS_PER_DEGREE()}
     */
    @JsProperty
    public double granularity;
    /**
     * Number of lines to draw between the top and bottom surface of an extruded ellipse.
     * Default: 16
     */
    @JsProperty
    public int numberOfVerticalLines;

    @JsConstructor
    public EllipseOutlineGeometryOptions() {}
}
