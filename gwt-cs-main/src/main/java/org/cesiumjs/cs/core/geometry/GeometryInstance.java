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

package org.cesiumjs.cs.core.geometry;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.options.GeometryInstanceOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "GeometryInstance")
public class GeometryInstance {
    /**
     * Per-instance attributes like ColorGeometryInstanceAttribute or ShowGeometryInstanceAttribute.
     * Geometry attributes varying per vertex; these attributes are constant for the entire instance.
     */
    public Object attributes;
    /**
     * The geometry being instanced.
     */
    @JsProperty
    public Geometry geometry;
    /**
     * User-defined object returned when the instance is picked or used to get/set per-instance attributes.
     * @see org.cesiumjs.cs.scene.Scene#pick(Cartesian2)
     * @see org.cesiumjs.cs.scene.Primitive#geometryInstances
     */
    @JsProperty
    public Object id;
    /**
     * The 4x4 transformation matrix that transforms the geometry from model to world coordinates. When this is the identity matrix, the geometry is drawn in world coordinates, i.e., Earth's WGS84 coordinates. Local reference frames can be used by providing a different transformation matrix, like that returned by Transforms.eastNorthUpToFixedFrame.
     * Default:  {@link Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;

    /**
     * Geometry instancing allows one Geometry object to be positions in several different locations and colored uniquely.
     * For example, one BoxGeometry can be instanced several times, each with a different modelMatrix to change its position, rotation, and scale.
     */
    @JsConstructor
    public GeometryInstance() {}

    /**
     * Geometry instancing allows one Geometry object to be positions in several different locations and colored uniquely.
     * For example, one BoxGeometry can be instanced several times, each with a different modelMatrix to change its position, rotation, and scale.
     * @param options Options
     */
    @JsConstructor
    public GeometryInstance(GeometryInstanceOptions options) {}
}
