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

package org.cesiumjs.cs.core.geometry.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;

/**
 * Options for {@link org.cesiumjs.cs.core.geometry.EllipsoidOutlineGeometry}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class EllipsoidOutlineGeometryOptions {
    /**
     * The radii of the ellipsoid in the x, y, and z directions.
     * Default: Cartesian3(1.0, 1.0, 1.0)
     */
    @JsProperty
    public Cartesian3 radii;
    /**
     * The number of times to partition the ellipsoid into stacks.
     * Default: 64
     */
    @JsProperty
    public Integer stackPartitions;
    /**
     * The number of times to partition the ellipsoid into radial slices.
     * Default: 64
     */
    @JsProperty
    public Integer slicePartitions;
    /**
     * The number of points per line, determining the granularity of the curvature.
     * Default: 128
     */
    @JsProperty
    public int subdivisions;
    /**
     * The inner radii of the ellipsoid in the x, y, and z directions.
     */
    @JsProperty
    public Cartesian3 innerRadii;
    /**
     * The minimum angle lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
     * Default: 0.0
     */
    @JsProperty
    public Number minimumClock;
    /**
     * The maximum angle lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
     * Default: 2 * PI
     */
    @JsProperty
    public Number maximumClock;
    /**
     * The minimum angle measured from the positive z-axis and toward the negative z-axis.
     * Default: 0.0
     */
    @JsProperty
    public Number minimumCone;
    /**
     * The maximum angle measured from the positive z-axis and toward the negative z-axis.
     * Default: PI
     */
    @JsProperty
    public Number maximumCone;

    @JsConstructor
    public EllipsoidOutlineGeometryOptions() {}
}
