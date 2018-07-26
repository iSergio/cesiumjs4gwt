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

/**
 * A collection of PostProcessStages and/or PostProcessStageComposites.
 * The input texture for each post-process stage is the texture rendered to by the scene or the texture rendered to by
 * the previous stage in the collection.
 *
 * If the ambient occlusion or bloom stages are enabled, they will execute before all other stages.
 *
 * If the FXAA stage is enabled, it will execute after all other stages.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PostProcessStageCollection")
public class PostProcessStageCollection {
    @JsProperty(name = "ambientOcclusion")
    public native PostProcessStageComposite ambientOcclusion();
    @JsProperty(name = "bloom")
    public native PostProcessStageComposite bloom();
    /**
     * A post-process stage for Fast Approximate Anti-aliasing.
     * When enabled, this stage will execute after all others.
     */
    @JsProperty(name = "fxaa")
    public native PostProcessStage fxaa();
    /**
     * The number of post-process stages in this collection.
     */
    @JsProperty(name = "length")
    public native int length();
    /**
     * Determines if all of the post-process stages in the collection are ready to be executed.
     */
    @JsProperty(name = "ready")
    public native boolean ready();

    @JsConstructor
    public PostProcessStageCollection() {}

    /**
     * Adds the post-process stage to the collection.
     * @param stage {@link PostProcessStage} The post-process stage to add to the collection.
     * @return The post-process stage that was added to the collection.
     */
    @JsMethod
    public native PostProcessStage add(PostProcessStage stage);

    /**
     * Adds the post-process stage to the collection.
     * @param stage {@link PostProcessStageComposite} The post-process stage to add to the collection.
     * @return The post-process stage that was added to the collection.
     */
    @JsMethod
    public native PostProcessStageComposite add(PostProcessStageComposite stage);

    /**
     * Returns whether the collection contains a post-process stage.
     * @param stage {@link PostProcessStage} | {@link PostProcessStageComposite} The post-process stage to add to the collection.
     * @return Whether the collection contains the post-process stage.
     */
    @JsMethod
    public native boolean contains(PostProcess stage);

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     */
    @JsMethod
    public native void destroy();

    /**
     * Gets the post-process stage at index.
     * @param index The index of the post-process stage.
     * @return {@link PostProcessStage} | {@link PostProcessStageComposite} The post-process stage at index.
     */
    @JsMethod
    public native PostProcess get(int index);

    /**
     * Returns true if this object was destroyed; otherwise, false.
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Removes a post-process stage from the collection and destroys it.
     * @param stage {@link PostProcessStage} | {@link PostProcessStageComposite} The post-process stage to add to the collection.
     * @return Whether the post-process stage was removed.
     */
    @JsMethod
    public native boolean remove(PostProcess stage);

    /**
     * Removes all post-process stages from the collection and destroys them.
     */
    @JsMethod
    public native void removeAll();
}
