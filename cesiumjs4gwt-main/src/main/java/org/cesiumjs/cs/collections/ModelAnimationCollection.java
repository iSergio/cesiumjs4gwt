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

package org.cesiumjs.cs.collections;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.scene.ModelAnimation;
import org.cesiumjs.cs.scene.options.ModelAnimationOptions;

/**
 * A collection of active model animations. Access this using
 * {@link org.cesiumjs.cs.scene.Model#activeAnimations}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "ModelAnimationCollection")
public class ModelAnimationCollection extends Collection<ModelAnimation> {
    /**
     * When true, the animation will play even when the scene time is paused. However, whether animation takes
     * place will depend on the animationTime functions assigned to the model's animations. By default, this is
     * based on scene time, so models using the default will not animate regardless of this setting.
     * Default: false
     */
    @JsProperty
    public boolean animateWhilePaused;
    /**
     * The event fired when an animation is added to the collection. This can be
     * used, for example, to keep a UI in sync. Default: new Event()
     */
    @SuppressWarnings("rawtypes")
    @JsProperty
    public Event animationAdded;
    /**
     * The event fired when an animation is removed from the collection. This can be
     * used, for example, to keep a UI in sync. Default: new Event()
     */
    @SuppressWarnings("rawtypes")
    @JsProperty
    public Event animationRemoved;

    @JsConstructor
    public ModelAnimationCollection() {
    }

    /**
     * Creates and adds an animation with the specified initial properties to the
     * collection. This raises the ModelAnimationCollection#animationAdded event so,
     * for example, a UI can stay in sync.
     *
     * @param options {@link ModelAnimationOptions}
     * @return The animation that was added to the collection.
     */
    @JsMethod
    public native ModelAnimation add(ModelAnimationOptions options);

    /**
     * Creates and adds an animation with the specified initial properties to the
     * collection for each animation in the model. This raises the
     * ModelAnimationCollection#animationAdded event for each model so, for example,
     * a UI can stay in sync.
     *
     * @param options {@link ModelAnimationOptions}
     * @return An array of ModelAnimation objects, one for each animation added to
     * the collection. If there are no glTF animations, the array is empty.
     */
    @JsMethod
    public native ModelAnimation[] addAll(ModelAnimationOptions options);
}
