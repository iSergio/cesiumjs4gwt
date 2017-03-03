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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Ellipsoid;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PolylinePipelineOptions {
    /**
     * The array of type {Cartesian3} representing positions.
     */
    @JsProperty
    public Cartesian3[] positions;
    /**
     * A number or array of numbers representing the heights of each position.
     */
    @JsProperty
    public double[] height;
    /**
     * The distance, in radians, between each latitude and longitude. Determines the number of positions in the buffer.
     * Default: {@link org.cesiumjs.cs.core.Math#RADIANS_PER_DEGREE}
     */
    @JsProperty
    public double granularity;
    /**
     * The ellipsoid on which the positions lie.
     * Default: {@link Ellipsoid#WGS84()}
     */
    @JsProperty
    public Ellipsoid ellipsoid;

    /**
     * Options for {@link org.cesiumjs.cs.core.PolylinePipeline#generateCartesianArc(PolylinePipelineOptions)}
     */
    @JsConstructor
    public PolylinePipelineOptions() {}
}
