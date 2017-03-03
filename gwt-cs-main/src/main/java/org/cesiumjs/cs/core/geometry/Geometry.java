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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.BoundingSphere;
import org.cesiumjs.cs.core.VertexFormat;
import org.cesiumjs.cs.core.enums.PrimitiveType;
import org.cesiumjs.cs.core.options.GeometryOptions;

import java.util.Arrays;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Geometry")
public class Geometry {
    /**
     * Attributes, which make up the geometry's vertices. Each property in this object corresponds to a GeometryAttribute
     * containing the attribute's data.
     *
     * Attributes are always stored non-interleaved in a Geometry.
     * @see GeometryAttribute
     * @see VertexFormat
     */
    @JsProperty
    public GeometryAttributes attributes;
    /**
     * An optional bounding sphere that fully encloses the geometry. This is commonly used for culling.
     */
    @JsProperty
    public BoundingSphere boundingSphere;
    /**
     * Optional index data that - along with Geometry#primitiveType - determines the primitives in the geometry.
     */
    @JsProperty
    public Arrays indices;
    /**
     * {@link PrimitiveType}
     * The type of primitives in the geometry. This is most often PrimitiveType.TRIANGLES, but can varying based on the specific geometry.
     */
    @JsProperty
    public Integer primitiveType;

    /**
     * A geometry representation with attributes forming vertices and optional index data defining primitives.
     * Geometries and an Appearance, which describes the shading, can be assigned to a Primitive for visualization.
     * A Primitive can be created from many heterogeneous - in many cases - geometries for performance.
     * Geometries can be transformed and optimized using functions in GeometryPipeline.
     * @see PolygonGeometry
     * @see RectangleGeometry
     * @see EllipseGeometry
     * @see CircleGeometry
     * @see WallGeometry
     * @see SimplePolylineGeometry
     * @see BoxGeometry
     * @see EllipsoidGeometry
     */
    //TODO: Examples
    @JsConstructor
    public Geometry() {}

    /**
     * A geometry representation with attributes forming vertices and optional index data defining primitives.
     * Geometries and an Appearance, which describes the shading, can be assigned to a Primitive for visualization.
     * A Primitive can be created from many heterogeneous - in many cases - geometries for performance.
     * Geometries can be transformed and optimized using functions in GeometryPipeline.
     * @param options Options
     * @see PolygonGeometry
     * @see RectangleGeometry
     * @see EllipseGeometry
     * @see CircleGeometry
     * @see WallGeometry
     * @see SimplePolylineGeometry
     * @see BoxGeometry
     * @see EllipsoidGeometry
     */
    //TODO: Examples
    @JsConstructor
    public Geometry(GeometryOptions options) {}

    /**
     * Computes the number of vertices in a geometry. The runtime is linear with respect to the number of
     * attributes in a vertex, not the number of vertices.
     * @param geometry The geometry.
     * @return The number of vertices in the geometry.
     */
    @JsMethod
    public static native int computeNumberOfVertices(Geometry geometry);
}
