/*
 * Copyright 2021 iserge, Gis4Fun.
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

package org.cesiumjs.cs.scene.experimental;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.BoundingSphere;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.enums.ColorBlendMode;
import org.cesiumjs.cs.scene.experimental.options.ModelExperimentalFromGltfOptions;
import org.cesiumjs.cs.scene.experimental.options.ModelExperimentalOptions;

/**
 * A 3D model. This is a new architecture that is more decoupled than the older {@link org.cesiumjs.cs.scene.Model}.
 * This class is still experimental.
 * Do not call this function directly, instead use the `from` functions to create the Model from your source data type.
 * Experimental
 */
@JsType(isNative = true, namespace = "Cesium", name = "ModelExperimental")
public class ModelExperimental {
    /**
     * Gets the model's bounding sphere.
     */
    @JsProperty(name = "boundingSphere")
    public native BoundingSphere boundingSphere();
    /**
     * The color to blend with the model's rendered color.
     */
    @JsProperty
    public Color color;
    /**
     * Value used to determine the color strength when the colorBlendMode is MIX. A value of 0.0 results in the model's
     * rendered color while a value of 1.0 results in a solid color, with any value in-between resulting
     * in a mix of the two.
     * Default: 0.5
     */
    @JsProperty
    public Number colorBlendAmount;
    /**
     * Defines how the color blends with the model.
     * Default:  {@link ColorBlendMode#HIGHLIGHT()}
     */
    @JsProperty
    public ColorBlendMode colorBlendMode;
    /**
     * The model's custom shader, if it exists. Using custom shaders with a Cesium3DTileStyle may
     * lead to undefined behavior.
     */
    @JsProperty
    public CustomShader customShader;
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     * Draws the bounding sphere for each draw command in the model.
     *
     * Default: false
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * The index of the feature ID attribute to use for picking features per-instance or per-primitive.
     * Default: 0
     */
    @JsProperty
    public Number featureIdAttributeIndex;
    /**
     * The index of the feature ID texture to use for picking features per-primitive.
     * Default: 0
     */
    @JsProperty
    public Number featureIdTextureIndex;
    /**
     * When true, this model is ready to render, i.e., the external binary, image, and shader files were downloaded and the WebGL resources were created. This is set to true right before ModelExperimental#readyPromise is resolved.
     * Default: false
     */
    @JsProperty(name = "ready")
    public native boolean ready();
    /**
     * Gets the promise that will be resolved when this model is ready to render, i.e. when the external resources have
     * been downloaded and the WebGL resources are created.
     * This promise is resolved at the end of the frame before the first frame the model is rendered in.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<ModelExperimental, Void> readyPromise();
    /**
     * Whether or not to render the model.
     * Default: true
     */
    @JsProperty
    public boolean show;

    @JsConstructor
    public ModelExperimental(ModelExperimentalOptions options) {}

    private ModelExperimental() {}

    /**
     * Creates a model from a glTF asset. When the model is ready to render, i.e., when the external binary, image, and
     * shader files are downloaded and the WebGL resources are created, the Model#readyPromise is resolved.
     *
     * The model can be a traditional glTF asset with a .gltf extension or a Binary glTF using the .glb extension.
     * @param options options for load
     * @return model
     */
    @JsMethod
    public static native ModelExperimental fromGltf(ModelExperimentalFromGltfOptions options);

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     *
     * @see ModelExperimental#isDestroyed()
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     *
     * @see ModelExperimental#destroy()
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Called when Viewer or CesiumWidget render the scene to get the draw commands needed to render this primitive.
     * Do not call this function directly. This is documented just to list the exceptions that may be propagated when
     * the scene is rendered:
     */
    @JsMethod
    public native void update();
}