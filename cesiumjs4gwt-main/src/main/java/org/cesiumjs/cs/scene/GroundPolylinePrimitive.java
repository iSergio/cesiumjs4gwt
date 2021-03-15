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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.apperances.Appearance;
import org.cesiumjs.cs.scene.enums.ClassificationType;
import org.cesiumjs.cs.scene.options.GroundPolylinePrimitiveOptions;

/**
 * A GroundPolylinePrimitive represents a polyline draped over the terrain in
 * the {@link Scene}.
 * <p>
 * Only to be used with GeometryInstances containing
 * {@link org.cesiumjs.cs.core.geometry.GroundPolylineGeometry}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "GroundPolylinePrimitive")
public class GroundPolylinePrimitive {
    /**
     * The Appearance used to shade this primitive. Each geometry instance is shaded
     * with the same appearance. Some appearances, like
     * {@link org.cesiumjs.cs.scene.apperances.PolylineColorAppearance} allow giving
     * each instance unique properties. Default: undefined
     */
    @JsProperty
    public Appearance appearance;
    /**
     * Determines whether terrain, 3D Tiles or both will be classified. Default:
     * {@link ClassificationType#BOTH()}
     */
    @JsProperty
    public ClassificationType classificationType;
    /**
     * This property is for debugging only; it is not for production use nor is it
     * optimized. Draws the bounding sphere for each draw command in the primitive.
     * Default: false
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * Determines if the primitive will be shown. This affects all geometry
     * instances in the primitive. Default: true
     */
    @JsProperty
    public boolean show;

    @JsConstructor
    public GroundPolylinePrimitive() {
    }

    @JsConstructor
    public GroundPolylinePrimitive(GroundPolylinePrimitiveOptions options) {
    }

    /**
     * Initializes the minimum and maximum terrain heights. This only needs to be
     * called if you are creating the GroundPolylinePrimitive synchronously.
     *
     * @return A promise that will resolve once the terrain heights have been
     * loaded.
     */
    @JsMethod
    public static native Promise<Void, Void> initializeTerrainHeights();

    /**
     * Checks if the given Scene supports GroundPolylinePrimitives.
     * GroundPolylinePrimitives require support for the WEBGL_depth_texture
     * extension.
     *
     * @param scene The current scene.
     * @return Whether or not the current scene supports GroundPolylinePrimitives.
     */
    @JsMethod
    public static native boolean isSupported(Scene scene);

    /**
     * When true, each geometry instance will only be pickable with
     * {@link Scene#pick(Cartesian2)}. When false, GPU memory is saved. Default:
     * true
     */
    @JsProperty(name = "allowPicking")
    public native boolean allowPicking();

    /**
     * Determines if the geometry instances will be created and batched on a web
     * worker. Default: true
     */
    @JsProperty(name = "asynchronous")
    public native boolean asynchronous();

    /**
     * This property is for debugging only; it is not for production use nor is it
     * optimized. If true, draws the shadow volume for each geometry in the
     * primitive. Default: false
     */
    @JsProperty(name = "debugShowShadowVolume")
    public native boolean debugShowShadowVolume();

    /**
     * The geometry instances rendered with this primitive. This may be undefined if
     * options.releaseGeometryInstances is true when the primitive is constructed.
     * Changing this property after the primitive is rendered has no effect.
     * Default: undefined
     */
    @JsProperty(name = "geometryInstances")
    public native GeometryInstance[] geometryInstances();

    /**
     * Determines if geometry vertex attributes are interleaved, which can slightly
     * improve rendering performance. Default: false
     */
    @JsProperty(name = "interleave")
    public native boolean interleave();

    /**
     * Determines if the primitive is complete and ready to render. If this property
     * is true, the primitive will be rendered the next time that
     * {@link GroundPolylinePrimitive#update} is called.
     */
    @JsProperty(name = "ready")
    public native boolean ready();

    /**
     * Gets a promise that resolves when the primitive is ready to render.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<GroundPolylinePrimitive, Void> readyPromise();

    /**
     * When true, the primitive does not keep a reference to the input
     * geometryInstances to save memory. Default: true
     */
    @JsProperty(name = "releaseGeometryInstances")
    public native boolean releaseGeometryInstances();

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows
     * for deterministic release of WebGL resources, instead of relying on the
     * garbage collector to destroy this object. Once an object is destroyed, it
     * should not be used; calling any function other than isDestroyed will result
     * in a DeveloperError exception. Therefore, assign the return value (undefined)
     * to the object as done in the example.
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns the modifiable per-instance attributes for a GeometryInstance.
     *
     * @param id The id of the GeometryInstance.
     * @return The typed array in the attribute's format or undefined if the is no
     * instance with id. Example: {@code
     * JsObject attributes = primitive.getGeometryInstanceAttributes('an id');
     * attributes.setProperty("color", Cesium.ColorGeometryInstanceAttribute.toValue(Cesium.Color.AQUA));
     * attributes.setProperty("show", Cesium.ShowGeometryInstanceAttribute.toValue(true));
     * }
     */
    @JsMethod
    public native JsObject getGeometryInstanceAttributes(JsObject id);

    /**
     * Returns true if this object was destroyed; otherwise, false. If this object
     * was destroyed, it should not be used; calling any function other than
     * isDestroyed will result in a DeveloperError exception.
     *
     * @return true if this object was destroyed; otherwise, false.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Called when Viewer or CesiumWidget render the scene to get the draw commands
     * needed to render this primitive. Do not call this function directly. This is
     * documented just to list the exceptions that may be propagated when the scene
     * is rendered:
     */
    @JsMethod
    public native void update();
}
