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

package org.cesiumjs.cs.scene.experimental.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.js.JsArray;
import org.cesiumjs.cs.scene.enums.ModelAnimationLoop;
import org.cesiumjs.cs.scene.experimental.ModelExperimental;
import org.cesiumjs.cs.scene.experimental.ModelExperimentalAnimation;

/**
 * Options object for {@link org.cesiumjs.cs.scene.experimental.ModelExperimentalAnimationCollection#add(ModelExperimentalAnimationOptions)}
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ModelExperimentalAnimationOptions {
    /**
     * The glTF animation name that identifies the animation. Must be defined if options.index is undefined.
     */
    @JsProperty
    public String name;
    /**
     * The glTF animation index that identifies the animation. Must be defined if options.name is undefined.
     */
    @JsProperty
    public int index;
    /**
     * The scene time to start playing the animation. When this is undefined, the animation starts at the next frame.
     */
    @JsProperty
    public JulianDate startTime;
    /**
     * The delay, in seconds, from startTime to start playing. This will only affect the animation if options.loop
     * is ModelAnimationLoop.NONE.
     * Default: 0
     */
    @JsProperty
    public double delay;
    /**
     * The scene time to stop playing the animation. When this is undefined, the animation is played for its full duration.
     */
    @JsProperty
    public JulianDate stopTime;
    /**
     * When true, the animation is removed after it stops playing. This will only affect the animation if options.loop is ModelAnimationLoop.NONE.
     * Default: false
     */
    @JsProperty
    public boolean removeOnStop;
    /**
     * Values greater than 1.0 increase the speed that the animation is played relative to the scene clock speed; values less than 1.0 decrease the speed.
     * Default: 1.0
     */
    @JsProperty
    public double multiplier;
    /**
     * When true, the animation is played in reverse.
     * Default: false
     */
    @JsProperty
    public boolean reverse;
    /**
     * Determines if and how the animation is looped.
     * Default: {@link org.cesiumjs.cs.scene.enums.ModelAnimationLoop#NONE()}
     */
    @JsProperty
    public Number loop;
    /**
     * If defined, computes the local animation time for this animation.
     */
    @JsProperty
    public ModelExperimentalAnimation.AnimationTimeCallback animationTime;

    @JsConstructor
    public ModelExperimentalAnimationOptions() {}

    @JsOverlay
    public final ModelExperimentalAnimationOptions setName(String name) {
        this.name = name;
        return this;
    }

    @JsOverlay
    public final ModelExperimentalAnimationOptions setIndex(int index) {
        this.index = index;
        return this;
    }

    @JsOverlay
    public final ModelExperimentalAnimationOptions setStartTime(JulianDate startTime) {
        this.startTime = startTime;
        return this;
    }

    @JsOverlay
    public final ModelExperimentalAnimationOptions setDelay(double delay) {
        this.delay = delay;
        return this;
    }

    @JsOverlay
    public final ModelExperimentalAnimationOptions setStopTime(JulianDate stopTime) {
        this.stopTime = stopTime;
        return this;
    }

    @JsOverlay
    public final ModelExperimentalAnimationOptions setRemoveOnStop(boolean removeOnStop) {
        this.removeOnStop = removeOnStop;
        return this;
    }

    @JsOverlay
    public final ModelExperimentalAnimationOptions setMultiplier(double multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    @JsOverlay
    public final ModelExperimentalAnimationOptions setReverse(boolean reverse) {
        this.reverse = reverse;
        return this;
    }

    @JsOverlay
    public final ModelExperimentalAnimationOptions setLoop(Number loop) {
        this.loop = loop;
        return this;
    }

    @JsOverlay
    public final ModelExperimentalAnimationOptions setAnimationTime(ModelExperimentalAnimation.AnimationTimeCallback animationTime) {
        this.animationTime = animationTime;
        return this;
    }
}
