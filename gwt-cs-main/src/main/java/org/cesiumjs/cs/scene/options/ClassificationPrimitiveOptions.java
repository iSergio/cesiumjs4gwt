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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.scene.apperances.Appearance;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * Options for {@link org.cesiumjs.cs.scene.ClassificationPrimitive}
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ClassificationPrimitiveOptions {
    /**
     * The geometry instances - or a single geometry instance - to render.
     */
    @JsProperty
    public GeometryInstance[] geometryInstances;
    /**
     * The appearance used to render the primitive.
     */
    @JsProperty
    public Appearance appearance;
    /**
     * Determines if this primitive will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * The 4x4 transformation matrix that transforms the primitive (all geometry instances) from model to world coordinates.
     * Default: {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * When true, geometry vertices are optimized for the pre and post-vertex-shader caches.
     * Default: false
     */
    @JsProperty
    public boolean vertexCacheOptimize;
    /**
     * When true, geometry vertex attributes are interleaved, which can slightly improve rendering performance but increases load time.
     * Default: false
     */
    @JsProperty
    public boolean interleave;
    /**
     * When true, the geometry vertices are compressed, which will save memory.
     * Default: true
     */
    @JsProperty
    public boolean compressVertices;
    /**
     * When true, the primitive does not keep a reference to the input geometryInstances to save memory.
     * Default: true
     */
    @JsProperty
    public boolean releaseGeometryInstances;
    /**
     * When true, each geometry instance will only be pickable with Scene#pick. When false, GPU memory is saved.
     * Default: true
     */
    @JsProperty
    public boolean allowPicking;
    /**
     * When true, the renderer frustum culls and horizon culls the primitive's commands based on their bounding volume.
     * Set this to false for a small performance gain if you are manually culling the primitive.
     * Default: true
     */
    @JsProperty
    public boolean cull;
    /**
     * Determines if the primitive will be created asynchronously or block until ready.
     * Default: true
     */
    @JsProperty
    public boolean asynchronous;
    /**
     * For debugging only. Determines if this primitive's commands' bounding spheres are shown.
     * Default: false
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * Determines whether this primitive casts or receives shadows from each light source
     * Default: {@link org.cesiumjs.cs.scene.enums.ShadowMode#DISABLED()}
     */
    @JsProperty
    public Number shadows;

    /**
     * Options for {@link org.cesiumjs.cs.scene.ClassificationPrimitive}
     */
    @JsConstructor
    public ClassificationPrimitiveOptions() {}
}
