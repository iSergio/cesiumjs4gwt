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

package org.cesiumjs.cs.scene.apperances;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.VertexFormat;
import org.cesiumjs.cs.core.geometry.PolygonGeometry;
import org.cesiumjs.cs.core.geometry.RectangleGeometry;
import org.cesiumjs.cs.scene.apperances.options.EllipsoidSurfaceAppearanceOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "EllipsoidSurfaceAppearance")
public class EllipsoidSurfaceAppearance extends Appearance {
    /**
     * The VertexFormat that all EllipsoidSurfaceAppearance instances are compatible with, which requires only position
     * and st attributes. Other attributes are procedurally computed in the fragment shader.
     */
    @JsProperty(name = "VERTEX_FORMAT")
    public static native VertexFormat VERTEX_FORMAT();
    /**
     * When true, the geometry is expected to be on the ellipsoid's surface - not at a constant height above it - so EllipsoidSurfaceAppearance#renderState has backface culling enabled.
     * Default: false
     */
    @JsProperty(name = "aboveGround")
    public native boolean aboveGround();
    /**
     * When true, the fragment shader flips the surface normal as needed to ensure that the normal faces the viewer to avoid dark spots. This is useful when both sides of a geometry should be shaded like WallGeometry.
     * Default: true
     */
    @JsProperty(name = "faceForward")
    public native boolean faceForward();
    /**
     * When true, flat shading is used in the fragment shader, which means lighting is not taking into account.
     * Default: false
     */
    @JsProperty(name = "flat")
    public native boolean flat();
    /**
     * The VertexFormat that this appearance instance is compatible with. A geometry can have more vertex attributes and still be compatible - at a potential performance cost - but it can't have less.
     * Default: {@link EllipsoidSurfaceAppearance#VERTEX_FORMAT()}
     */
    @JsProperty(name = "vertexFormat")
    public native VertexFormat vertexFormat();

    /**
     * An appearance for geometry on the surface of the ellipsoid like {@link PolygonGeometry} and {@link RectangleGeometry},
     * which supports all materials like {@link MaterialAppearance} with {@link MaterialAppearance.MaterialSupport#ALL()}.
     * However, this appearance requires fewer vertex attributes since the fragment shader can procedurally compute normal, binormal, and tangent.
     */
    @JsConstructor
    public EllipsoidSurfaceAppearance() {}

    /**
     * An appearance for geometry on the surface of the ellipsoid like {@link PolygonGeometry} and {@link RectangleGeometry},
     * which supports all materials like {@link MaterialAppearance} with {@link MaterialAppearance.MaterialSupport#ALL()}.
     * However, this appearance requires fewer vertex attributes since the fragment shader can procedurally compute normal, binormal, and tangent.
     * @param options {@link EllipsoidSurfaceAppearanceOptions}
     */
    @JsConstructor
    public EllipsoidSurfaceAppearance(EllipsoidSurfaceAppearanceOptions options) {}
}
