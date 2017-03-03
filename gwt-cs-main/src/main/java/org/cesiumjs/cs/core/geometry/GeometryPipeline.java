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
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.projection.MapProjection;

/**
 * Content pipeline functions for geometries.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
//TODO Examples
@JsType(isNative = true, namespace = "Cesium", name ="GeometryPipeline")
public class GeometryPipeline {
    @JsConstructor
    private GeometryPipeline() {}

    /**
     * Compresses and packs geometry normal attribute values to save memory.
     * @param geometry The geometry to modify.
     * @return The modified geometry argument, with its normals compressed and packed.
     */
    @JsMethod
    public static native Geometry compressVertices(Geometry geometry);

    //TODO: Example
    /**
     * Computes per-vertex tangents and bitangents for a geometry containing TRIANGLES.
     * The result is new tangent and bitangent attributes added to the geometry.
     * This assumes a counter-clockwise winding order.
     * @param geometry The geometry to modify.
     * @return The modified geometry argument with the computed tangent and bitangent attributes.
     */
    @JsMethod
    public static native Geometry computeTangentAndBitangent(Geometry geometry);

    /**
     * Computes per-vertex normals for a geometry containing TRIANGLES by averaging the normals of all triangles incident
     * to the vertex. The result is a new normal attribute added to the geometry. This assumes a counter-clockwise winding order.
     * @param geometry The geometry to modify.
     * @return The modified geometry argument with the computed normal attribute.
     */
    @JsMethod
    public static native Geometry computeNormal(Geometry geometry);

    /**
     * Creates an object that maps attribute names to unique locations (indices) for matching vertex attributes and shader programs.
     * @param geometry The geometry, which is not modified, to create the object for.
     * @return An object with attribute name / index pairs.
     */
    @JsMethod
    public static native Object createAttributeLocations(Geometry geometry);

    /**
     * Creates a new Geometry with LINES representing the provided attribute (attributeName) for the provided geometry.
     * This is used to visualize vector attributes like normals, binormals, and tangents.
     * @param geometry The Geometry instance with the attribute.
     * @return A new Geometry instance with line segments for the vector.
     */
    @JsMethod
    public static native Geometry createLineSegmentsForVectors(Geometry geometry);

    /**
     * Creates a new Geometry with LINES representing the provided attribute (attributeName) for the provided geometry.
     * This is used to visualize vector attributes like normals, binormals, and tangents.
     * @param geometry The Geometry instance with the attribute.
     * @param attributeName The name of the attribute. Default: 'normal'.
     * @return A new Geometry instance with line segments for the vector.
     */
    @JsMethod
    public static native Geometry createLineSegmentsForVectors(Geometry geometry, String attributeName);

    /**
     * Creates a new Geometry with LINES representing the provided attribute (attributeName) for the provided geometry.
     * This is used to visualize vector attributes like normals, binormals, and tangents.
     * @param geometry The Geometry instance with the attribute.
     * @param attributeName The name of the attribute. Default: 'normal'.
     * @param length The length of each line segment in meters. This can be negative to point the vector in the opposite direction. Default: 10000.0
     * @return A new Geometry instance with line segments for the vector.
     */
    @JsMethod
    public static native Geometry createLineSegmentsForVectors(Geometry geometry, String attributeName, double length);

    /**
     * Encodes floating-point geometry attribute values as two separate attributes to improve rendering precision.
     * This is commonly used to create high-precision position vertex attributes.
     * @param geometry The geometry to modify.
     * @param attributeName The name of the attribute.
     * @param attributeHighName The name of the attribute for the encoded high bits.
     * @param attributeLowName The name of the attribute for the encoded low bits.
     * @return The modified geometry argument, with its encoded attribute.
     */
    @JsMethod
    public static native Geometry encodeAttribute(Geometry geometry, String attributeName, String attributeHighName, String attributeLowName);

    /**
     * Splits a geometry into multiple geometries, if necessary, to ensure that indices in the indices fit into unsigned shorts.
     * This is used to meet the WebGL requirements when unsigned int indices are not supported.
     * If the geometry does not have any indices, this function has no effect.
     * @param geometry The geometry to be split into multiple geometries.
     * @return An array of geometries, each with indices that fit into unsigned shorts.
     */
    @JsMethod
    public static native Geometry[] fitToUnsignedShortIndices(Geometry geometry);

    /**
     * Projects a geometry's 3D position attribute to 2D, replacing the position attribute with separate position3D and
     * position2D attributes.
     * If the geometry does not have a position, this function has no effect.
     * @param geometry The geometry to modify.
     * @param attributeName The name of the attribute.
     * @param attributeName3D The name of the attribute in 3D.
     * @param attributeName2D The name of the attribute in 2D.
     * @return The modified geometry argument with position3D and position2D attributes.
     */
    @JsMethod
    public static native Geometry projectTo2D(String geometry, String attributeName, String attributeName3D, String attributeName2D);

    /**
     * Projects a geometry's 3D position attribute to 2D, replacing the position attribute with separate position3D and
     * position2D attributes.
     * If the geometry does not have a position, this function has no effect.
     * @param geometry The geometry to modify.
     * @param attributeName The name of the attribute.
     * @param attributeName3D The name of the attribute in 3D.
     * @param attributeName2D The name of the attribute in 2D.
     * @param projection The projection to use.
     * @return The modified geometry argument with position3D and position2D attributes.
     */
    @JsMethod
    public static native Geometry projectTo2D(String geometry, String attributeName, String attributeName3D, String attributeName2D, MapProjection projection);

    /**
     * Reorders a geometry's indices to achieve better performance from the GPU's post vertex-shader cache by using the
     * Tipsify algorithm. If the geometry primitiveType is not TRIANGLES or the geometry does not have an indices,
     * this function has no effect.
     * @param geometry The geometry to modify.
     * @return The modified geometry argument, with its indices reordered for the post-vertex-shader cache.
     */
    @JsMethod
    public static native Geometry reorderForPostVertexCache(Geometry geometry);

    /**
     * Reorders a geometry's indices to achieve better performance from the GPU's post vertex-shader cache by using the
     * Tipsify algorithm. If the geometry primitiveType is not TRIANGLES or the geometry does not have an indices,
     * this function has no effect.
     * @param geometry The geometry to modify.
     * @param cacheCapacity The number of vertices that can be held in the GPU's vertex cache. Default: 24.
     * @return The modified geometry argument, with its indices reordered for the post-vertex-shader cache.
     * @see #reorderForPreVertexCache
     * @see <a href="http://gfx.cs.princ0eton.edu/pubs/Sander_2007_%253ETR/tipsy.pdf">Fast Triangle Reordering for Vertex Locality and Reduced Overdraw</a> by Sander, Nehab, and Barczak
     */
    @JsMethod
    public static native Geometry reorderForPostVertexCache(Geometry geometry, int cacheCapacity);

    /**
     * Reorders a geometry's attributes and indices to achieve better performance from the GPU's pre-vertex-shader cache.
     * @param geometry The geometry to modify.
     * @return The modified geometry argument, with its attributes and indices reordered for the GPU's pre-vertex-shader cache.
     * @see #reorderForPostVertexCache
     */
    @JsMethod
    public static native Geometry reorderForPreVertexCache(Geometry geometry);

    /**
     * Converts a geometry's triangle indices to line indices. If the geometry has an indices and its primitiveType is
     * TRIANGLES, TRIANGLE_STRIP, TRIANGLE_FAN, it is converted to LINES; otherwise, the geometry is not changed.
     * This is commonly used to create a wireframe geometry for visual debugging.
     * @param geometry The geometry to modify.
     * @return The modified geometry argument, with its triangle indices converted to lines.
     */
    @JsMethod
    public static native Geometry toWireframe(Geometry geometry);

    /**
     * Transforms a geometry instance to world coordinates. This changes the instance's modelMatrix to Matrix4.IDENTITY
     * and transforms the following attributes if they are present: position, normal, binormal, and tangent.
     * @param instance The geometry instance to modify.
     * @return The modified instance argument, with its attributes transforms to world coordinates.
     */
    @JsMethod
    public static native GeometryInstance transformToWorldCoordinates(GeometryInstance instance);
}
