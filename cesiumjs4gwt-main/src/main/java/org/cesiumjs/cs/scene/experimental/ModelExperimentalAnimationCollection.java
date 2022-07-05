/*
 * Copyright 2022 iSergio, Gis4Fun.
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
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.js.JsArray;
import org.cesiumjs.cs.scene.experimental.options.ModelExperimentalAnimationOptions;

/**
 * A collection of active model animations. Access this using ModelExperimental#activeAnimations.
 * @see ModelExperimental#activeAnimations
 */
@JsType(isNative = true, namespace = "Cesium", name = "ModelExperimentalAnimationCollection")
public class ModelExperimentalAnimationCollection {
    /**
     * When true, the animation will play even when the scene time is paused. However, whether animation takes place
     * will depend on the animationTime functions assigned to the model's animations. By default,
     * this is based on scene time, so models using the default will not animate regardless of this setting.
     * Default: false
     */
    @JsProperty
    public boolean animateWhilePaused;

    /**
     * The event fired when an animation is added to the collection. This can be used, for example,
     * to keep a UI in sync.
     *  Default: new Event()
     */
    @JsProperty
    public Event<?> animationAdded;
    /**
     * The event fired when an animation is removed from the collection. This can be used, for example, to keep a UI in sync.
     * Default: new Event()
     */
    @JsProperty
    public Event<?> animationRemoved;
    /**
     * The number of animations in the collection.
     */
    @JsProperty(name = "length")
    public native int length();
    /**
     * The model that owns this animation collection.
     */
    @JsProperty(name = "model")
    public native ModelExperimental model();

    @JsConstructor
    public ModelExperimentalAnimationCollection() {}

    /**
     * Creates and adds an animation with the specified initial properties to the collection.
     *
     * This raises the ModelExperimentalAnimationCollection#animationAdded event so, for example, a UI can stay in sync.
     * @param options options object.
     * @return The animation that was added to the collection.
     */
    @JsMethod
    public native ModelExperimentalAnimation add(ModelExperimentalAnimationOptions options);

    /**
     * Creates and adds animations with the specified initial properties to the collection for all animations in the model.
     * This raises the ModelExperimentalAnimationCollection#animationAdded event for each model so, for example, a UI can stay in sync.
     * @param options array of options objects
     * @return An array of ModelExperimentalAnimation objects, one for each animation added to the collection. If there are no glTF animations, the array is empty.
     */
    @JsMethod
    public native JsArray<ModelExperimentalAnimation> addAll(JsArray<ModelExperimentalAnimationOptions> options);

    /**
     * Determines whether this collection contains a given animation.
     * @param runtimeAnimation The runtime animation to check for.
     * @return true if this collection contains the animation, false otherwise.
     */
    @JsMethod
    public native boolean contains(ModelExperimentalAnimation runtimeAnimation);

    /**
     * Returns the animation in the collection at the specified index. Indices are zero-based and increase as animations
     * are added. Removing an animation shifts all animations after it to the left, changing their indices.
     * This function is commonly used to iterate over all the animations in the collection.
     * @param index The zero-based index of the animation.
     * @return The runtime animation at the specified index.
     */
    @JsMethod
    public native ModelExperimentalAnimation get(int index);

    /**
     * Removes an animation from the collection.
     * <p>This raises the ModelExperimentalAnimationCollection#animationRemoved event so, for example, a UI can stay in sync.</p>
     *
     * <p>An animation can also be implicitly removed from the collection by setting ModelExperimentalAnimationCollection#removeOnStop to true. The ModelExperimentalAnimationCollection#animationRemoved event is still fired when the animation is removed.</p>
     * @param runtimeAnimation The runtime animation to remove.
     * @return true if the animation was removed; false if the animation was not found in the collection.
     */
    @JsMethod
    public native boolean remove(ModelExperimentalAnimation runtimeAnimation);

    /**
     * Removes all animations from the collection.
     * This raises the ModelExperimentalAnimationCollection#animationRemoved event for each animation so, for example,
     * a UI can stay in sync.
     */
    @JsMethod
    public native void removeAll();
}
