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
import org.cesiumjs.cs.core.VertexFormat;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name =  "Object")
public class CircleGeometryOptions {
    /**
     * The circle's center point in the fixed frame.
     */
    @JsProperty
    public Cartesian3 center;
    /**
     * The radius in meters.
     */
    @JsProperty
    public double radius;
    /**
     * The ellipsoid the circle will be on.
     * Default: {@link Ellipsoid#WGS84()}
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The distance in meters between the circle and the ellipsoid surface.
     * Default: 0.0
     */
    @JsProperty
    public double height;
    /**
     * The angular distance between points on the circle in radians.
     * Default: 0.02
     */
    @JsProperty
    public double granularity;
    /**
     * The vertex attributes to be computed.
     * Default: {@link VertexFormat#DEFAULT()}
     */
    @JsProperty
    public VertexFormat vertexFormat;
    /**
     * The distance in meters between the circle's extruded face and the ellipsoid surface.
     * Default: 0.0
     */
    @JsProperty
    public double extrudedHeight;
    /**
     * The rotation of the texture coordinates, in radians. A positive rotation is counter-clockwise.
     * Default: 0.0
     */
    @JsProperty
    public double stRotation;

    /**
     * Options for {@link org.cesiumjs.cs.core.geometry.CircleGeometry}
     */
    @JsConstructor
    public CircleGeometryOptions() {}
}
