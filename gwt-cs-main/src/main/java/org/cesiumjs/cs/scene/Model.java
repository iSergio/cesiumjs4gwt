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
import org.cesiumjs.cs.collections.ModelAnimationCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.enums.ColorBlendMode;
import org.cesiumjs.cs.scene.enums.ShadowMode;
import org.cesiumjs.cs.scene.options.FromGltfOptions;
import org.cesiumjs.cs.scene.options.ModelOptions;

/**
 * A 3D model based on glTF, the runtime asset format for WebGL, OpenGL ES, and OpenGL.
 * Cesium includes support for geometry and materials, glTF animations, and glTF skinning. In addition, individual glTF
 * nodes are pickable with {@link Scene#pick} and animatable with {@link Model#getNode}. glTF cameras and lights are not currently supported.
 *
 * An external glTF asset is created with Model.fromGltf. glTF JSON can also be created at runtime and passed to
 * this constructor function. In either case, the {@link Model#readyPromise} is resolved when the model is ready to render,
 * i.e., when the external binary, image, and shader files are downloaded and the WebGL resources are created.
 *
 * For high-precision rendering, Cesium supports the CESIUM_RTC extension, which introduces the CESIUM_RTC_MODELVIEW
 * parameter semantic that says the node is in WGS84 coordinates translated relative to a local origin.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Model")
public class Model {
    /**
     * The currently playing glTF animations.
     */
    @JsProperty
    public ModelAnimationCollection activeAnimations;
    /**
     * When true, each glTF mesh and primitive is pickable with Scene#pick. When false, GPU memory is saved.
     * Default: true.
     */
    @JsProperty(name = "allowPicking")
    public native boolean allowPicking();
    /**
     * Determines if model WebGL resource creation will be spread out over several frames or block until
     * completion once all glTF files are loaded.
     * Default: true.
     */
    @JsProperty(name = "asynchronous")
    public native boolean asynchronous();
    /**
     * The base path that paths in the glTF JSON are relative to. The base path is the same path as the path containing
     * the .gltf file minus the .gltf file, when binary, image, and shader files are in the same directory as
     * the .gltf. When this is '', the app's base path is used.
     * Default: empty.
     */
    @JsProperty(name = "basePath")
    public native String basePath();
    /**
     * The model's bounding sphere in its local coordinate system. This does not take into account glTF animations and
     * skins nor does it take into account Model#minimumPixelSize.
     * Default:  undefined
     */
    //TODO: example
    @JsProperty(name = "boundingSphere")
    public native BoundingSphere boundingSphere();
    /**
     * A color that blends with the model's rendered color.
     * Default: {@link Color#WHITE()}.
     */
    @JsProperty
    public Color color;
    /**
     * Value used to determine the color strength when the colorBlendMode is MIX. A value of 0.0 results in the model's
     * rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.
     * Default: 0.5.
     */
    @JsProperty
    public double colorBlendAmount;
    /**
     * Defines how the color blends with the model.
     * Default:  {@link ColorBlendMode#HIGHLIGHT()}.
     */
    @JsProperty
    public Number colorBlendMode;
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     * Draws the bounding sphere for each draw command in the model. A glTF primitive corresponds to one draw command.
     * A glTF mesh has an array of primitives, often of length one.
     * Default: false
     */
    @JsProperty
    public double debugShowBoundingVolume;
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     * Draws the model in wireframe.
     * Default: false.
     */
    @JsProperty
    public boolean debugWireframe;
    /**
     * Gets or sets the condition specifying at what distance from the camera that this model will be displayed.
     * Default: undefined
     */
    @JsProperty
    public DistanceDisplayCondition distanceDisplayCondition;
    /**
     * The object for the glTF JSON, including properties with default values omitted from the JSON provided to this model.
     * Default: undefined
     */
    @JsProperty
    public Object gltf;
    /**
     * User-defined object returned when the model is picked.
     * Default: undefined.
     * @see Scene#pick
     */
    @JsProperty
    public Object id;
    /**
     * Determine if textures may continue to stream in after the model is loaded.
     * Default: true.
     */
    @JsProperty
    public boolean incrementallyLoadTextures;
    /**
     * The maximum scale size for a model. This can be used to give an upper limit to the {@link Model#minimumPixelSize},
     * ensuring that the model is never an unreasonable scale.
     */
    @JsProperty
    public double maximumScale;
    /**
     * The approximate minimum pixel size of the model regardless of zoom. This can be used to ensure that a model is
     * visible even when the viewer zooms out. When 0.0, no minimum size is enforced.
     * Default: 0.0
     */
    @JsProperty
    public double minimumPixelSize;
    /**
     * The 4x4 transformation matrix that transforms the model from model to world coordinates. When this is the identity matrix, the model is drawn in world coordinates, i.e., Earth's WGS84 coordinates. Local reference frames can be used by providing a different transformation matrix, like that returned by Transforms.eastNorthUpToFixedFrame.
     * Default: {@link Matrix4#IDENTITY}.
     */
    //TODO: example
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * Return the number of pending texture loads.
     */
    @JsProperty(name = "pendingTextureLoads")
    public native double pendingTextureLoads();
    /**
     * When true, this model is ready to render, i.e., the external binary, image, and shader files were downloaded
     * and the WebGL resources were created. This is set to true right before Model#readyPromise is resolved.
     * Default: false
     */
    @JsProperty(name = "ready")
    public native boolean ready();
    /**
     * Gets the promise that will be resolved when this model is ready to render, i.e., when the external binary,
     * image, and shader files were downloaded and the WebGL resources were created.
     * This promise is resolved at the end of the frame before the first frame the model is rendered in.
     * @see Model#ready
     */
    //TODO: Example
    @JsProperty(name = "readyPromise")
    public native Promise<Model, Void> readyPromise();
    /**
     * A uniform scale applied to this model before the Model#modelMatrix. Values greater than 1.0 increase the size of the model; values less than 1.0 decrease.
     * Default: 1.0
     */
    @JsProperty
    public double scale;
    /**
     * Determines whether the model casts or receives shadows from each light source.
     * Default: {@link ShadowMode#ENABLED()}.
     */
    @JsProperty
    public Number shadows;
    /**
     * Determines if the model primitive will be shown.
     * Default: true.
     */
    @JsProperty
    public boolean show;
    /**
     * The silhouette color.
     * Default: {@link Color#RED()}.
     */
    @JsProperty
    public Color silhouetteColor;
    /**
     * The size of the silhouette in pixels.
     * Default: 0.0
     */
    @JsProperty
    public double silhouetteSize;

    @JsConstructor
    public Model() {}

    @JsConstructor
    public Model(ModelOptions options) {}

    /**
     * Creates a model from a glTF asset. When the model is ready to render, i.e., when the external binary, image,
     * and shader files are downloaded and the WebGL resources are created, the Model#readyPromise is resolved.
     *
     * The model can be a traditional glTF asset with a .gltf extension or a Binary glTF using the KHR_binary_glTF
     * extension with a .glb extension.
     *
     * For high-precision rendering, Cesium supports the CESIUM_RTC extension, which introduces the CESIUM_RTC_MODELVIEW
     * parameter semantic that says the node is in WGS84 coordinates translated relative to a local origin.
     * @param options
     * @return Loaded model.
     */
    @JsMethod
    //TODO: Example
    public static native Model fromGltf(FromGltfOptions options);

    /**
     * Determines if silhouettes are supported.
     * @param scene The scene.
     * @return true if silhouettes are supported; otherwise, returns false
     */
    @JsMethod
    public static native boolean silhouetteSupported(Scene scene);

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of
     * WebGL resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see Model#isDestroyed
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns the glTF material with the given name property.
     * @param name The glTF name of the material.
     * @return The material or undefined if no material with name exists.
     */
    @JsMethod
    public native ModelMaterial getMaterial(String name);

    /**
     * Returns the glTF mesh with the given name property.
     * @param name The glTF name of the mesh.
     * @return The mesh or undefined if no mesh with name exists.
     */
    @JsMethod
    public native ModelMesh getMesh(String name);

    /**
     * Returns the glTF node with the given name property. This is used to modify a node's transform for animation outside of glTF animations.
     * @param name The glTF name of the node.
     * @return The node or undefined if no node with name exists.
     */
    //TODO: Example
    @JsMethod
    public native ModelNode getNode(String name);

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     * @see Model#destroy()
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Called when {@link org.cesiumjs.cs.widgets.Viewer} or {@link org.cesiumjs.cs.widgets.CesiumWidget} render the
     * scene to get the draw commands needed to render this primitive.
     * Do not call this function directly.
     */
    @JsMethod
    public native void update();
}
