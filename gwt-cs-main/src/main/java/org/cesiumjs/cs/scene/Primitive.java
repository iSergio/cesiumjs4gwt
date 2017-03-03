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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.apperances.Appearance;
import org.cesiumjs.cs.scene.enums.ShadowMode;
import org.cesiumjs.cs.scene.options.PrimitiveOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Primitive")
public class Primitive {
    /**
     * When true, each geometry instance will only be pickable with Scene#pick. When false, GPU memory is saved. *
     * Default: true
     */
    @JsProperty(name = "allowPicking")
    public native boolean allowPicking();
    /**
     * The Appearance used to shade this primitive. Each geometry instance is shaded with the same appearance.
     * Some appearances, like PerInstanceColorAppearance allow giving each instance unique properties.
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
     * When true, the renderer frustum culls and horizon culls the primitive's commands based on their bounding volume.
     * Set this to false for a small performance gain if you are manually culling the primitive.
     * Default: true
     */
    @JsProperty
    public boolean cull;
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     * Draws the bounding sphere for each draw command in the primitive.
     * Default: false
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * The geometry instances rendered with this primitive. This may be undefined if options.releaseGeometryInstances
     * is true when the primitive is constructed.
     * Changing this property after the primitive is rendered has no effect.
     */
    @JsProperty
    public GeometryInstance[] geometryInstances;
    /**
     * Determines if geometry vertex attributes are interleaved, which can slightly improve rendering performance.
     * Default: false
     */
    @JsProperty(name = "interleave")
    public native boolean interleave();
    /**
     * The 4x4 transformation matrix that transforms the primitive (all geometry instances) from model to world coordinates.
     * When this is the identity matrix, the primitive is drawn in world coordinates, i.e., Earth's WGS84 coordinates.
     * Local reference frames can be used by providing a different transformation matrix,
     * like that returned by Transforms.eastNorthUpToFixedFrame.
     *
     * This property is only supported in 3D mode.
     * Default: {@link Matrix4#IDENTITY()}
     */
    //TODO: Examples
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * Determines if the primitive is complete and ready to render.
     * If this property is true, the primitive will be rendered the next time that Primitive#update is called.
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
     * Default {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public int shadows;
    /**
     * Determines if the primitive will be shown. This affects all geometry instances in the primitive.
     * Default: true
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
    public Primitive() {}

    @JsConstructor
    public Primitive(PrimitiveOptions options) {}

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL resources,
     * instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed()
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns the modifiable per-instance attributes for a GeometryInstance.
     * @param id The id of the GeometryInstance.
     * @return The typed array in the attribute's format or undefined if the is no instance with id.
     */
    //TODO: Example
    @JsMethod
    public native Object getGeometryInstanceAttributes(Object id);

    /**
     * Returns true if this object was destroyed; otherwise, false.
     * If this object was destroyed, it should not be used; calling any function other than
     * isDestroyed will result in a DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Called when Viewer or CesiumWidget render the scene to get the draw commands needed to render this primitive.
     * Do not call this function directly. This is documented just to list the exceptions that may be propagated when the scene is rendered:
     */
    @JsMethod
    public native void update();
}
