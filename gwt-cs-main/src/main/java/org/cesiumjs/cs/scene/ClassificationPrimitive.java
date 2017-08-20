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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.apperances.Appearance;
import org.cesiumjs.cs.scene.enums.ShadowMode;
import org.cesiumjs.cs.scene.options.ClassificationPrimitiveOptions;

/**
 * A classification primitive represents a volume enclosing geometry in the Scene to be highlighted.
 * The geometry must be from a single GeometryInstance. Batching multiple geometries is not yet supported.
 * A primitive combines the geometry instance with an Appearance that describes the full shading, including Material
 * and RenderState. Roughly, the geometry instance defines the structure and placement, and the appearance defines
 * the visual characteristics. Decoupling geometry and appearance allows us to mix and match most of them and add a
 * new geometry or appearance independently of each other. Only the PerInstanceColorAppearance is supported at this time.
 *
 * For correct rendering, this feature requires the EXT_frag_depth WebGL extension. For hardware that do not
 * support this extension, there will be rendering artifacts for some viewing angles.
 *
 * Valid geometries are BoxGeometry, CylinderGeometry, EllipsoidGeometry, PolylineVolumeGeometry, and SphereGeometry.
 *
 * Geometries that follow the surface of the ellipsoid, such as CircleGeometry, CorridorGeometry, EllipseGeometry,
 * PolygonGeometry, and RectangleGeometry, are also valid if they are extruded volumes; otherwise, they will not be rendered.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ClassificationPrimitive")
public class ClassificationPrimitive {
    /**
     * When true, each geometry instance will only be pickable with Scene#pick. When false, GPU memory is saved.
     * Default: true
     */
    @JsProperty(name = "allowPicking")
    public native boolean allowPicking();
    /**
     * The Appearance used to shade this primitive. Each geometry instance is shaded with the same appearance.
     * Some appearances, like PerInstanceColorAppearance allow giving each instance unique properties.
     * Default: undefined
     */
    @JsProperty
    public Appearance appearance;
    /**
     * Determines if the geometry instances will be created and batched on a web worker.
     * Default: true
     */
    @JsProperty(name = "asynchronous")
    public native boolean asynchronous();
    /**
     * When true, geometry vertices are compressed, which will save memory.
     * Default: true
     */
    @JsProperty(name = "compressVertices")
    public native boolean compressVertices();
    /**
     * When true, the renderer frustum culls and horizon culls the primitive's commands based on their bounding volume. Set this to false for a small performance gain if you are manually culling the primitive.
     * Default: true
     */
    @JsProperty
    public boolean cull;
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     * Draws the bounding sphere for each draw command in the primitive.
     *
     * Default: false
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * The Appearance used to shade this primitive when it fails the depth test. Each geometry instance is shaded with
     * the same appearance. Some appearances, like PerInstanceColorAppearance allow giving each instance unique properties.
     * When using an appearance that requires a color attribute, like PerInstanceColorAppearance, add a depthFailColor
     * per-instance attribute instead.
     *
     * Requires the EXT_frag_depth WebGL extension to render properly. If the extension is not supported, there may be artifacts.
     *
     * Default: undefined
     */
    @JsProperty
    public Appearance depthFailAppearance;
    /**
     * The geometry instances rendered with this primitive. This may be undefined if options.releaseGeometryInstances is
     * true when the primitive is constructed.
     * Changing this property after the primitive is rendered has no effect.
     *
     * Default: undefined
     */
    @JsProperty(name = "geometryInstances")
    public native GeometryInstance[] geometryInstances();
    /**
     * Determines if geometry vertex attributes are interleaved, which can slightly improve rendering performance.
     *
     * Default: false
     */
    @JsProperty(name = "interleave")
    public native boolean interleave();
    /**
     * The 4x4 transformation matrix that transforms the primitive (all geometry instances) from model to world coordinates.
     * When this is the identity matrix, the primitive is drawn in world coordinates, i.e., Earth's WGS84 coordinates.
     * Local reference frames can be used by providing a different transformation matrix, like that returned by
     * {@link org.cesiumjs.cs.core.Transforms#eastNorthUpToFixedFrame}.
     * This property is only supported in 3D mode.
     *
     * Default: {@link Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * Determines if the primitive is complete and ready to render. If this property is true, the primitive will be
     * rendered the next time that Primitive#update is called.
     */
    @JsProperty(name = "ready")
    public native boolean ready();
    /**
     * Gets a promise that resolves when the primitive is ready to render.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<Primitive, Void> readyPromise();
    /**
     * When true, the primitive does not keep a reference to the input geometryInstances to save memory.
     * Default: true
     */
    @JsProperty(name = "releaseGeometryInstances")
    public native boolean releaseGeometryInstances();
    /**
     * Determines whether this primitive casts or receives shadows from each light source.
     * Default: {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public Number shadows;
    /**
     * Determines if the primitive will be shown. This affects all geometry instances in the primitive.
     Default Value:  true
     */
    @JsProperty
    public boolean show;
    /**
     * When true, geometry vertices are optimized for the pre and post-vertex-shader caches.
     * Default: true
     */
    @JsProperty(name = "vertexCacheOptimize")
    public native boolean vertexCacheOptimize();

    @JsConstructor
    public ClassificationPrimitive() {}

    @JsConstructor
    public ClassificationPrimitive(ClassificationPrimitiveOptions options) {}
}
