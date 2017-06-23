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
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.scene.enums.ModelAnimationLoop;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ModelAnimationOptions {
    /**
     * The glTF animation name that identifies this animation.
     */
    @JsProperty
    public String name;
    /**
     * The delay, in seconds, from ModelAnimation#startTime to start playing.
     * Default: undefined
     */
    @JsProperty
    public double delay;
    /**
     * Determines if and how the animation is looped.
     * Default: {@link ModelAnimationLoop#NONE()}
     */
    @JsProperty
    public Number loop;
    /**
     * The scene time to start playing this animation. When this is undefined, the animation starts at the next frame.
     * Default: undefined
     */
    @JsProperty
    public JulianDate startTime;
    /**
     * The scene time to stop playing this animation. When this is undefined, the animation is played for its full
     * duration and perhaps repeated depending on ModelAnimation#loop.
     * Default: undefined
     */
    @JsProperty
    public JulianDate stopTime;
    /**
     * When true, the animation is removed after it stops playing. This is slightly more efficient that not
     * removing it, but if, for example, time is reversed, the animation is not played again.
     * Default: false
     */
    @JsProperty
    public boolean removeOnStop;
    /**
     * When true, the animation is played in reverse.
     * Default: false
     */
    @JsProperty
    public boolean reverse;
    /**
     * Values greater than 1.0 increase the speed that the animation is played relative to the scene clock speed;
     * values less than 1.0 decrease the speed. A value of 1.0 plays the animation at the speed in the glTF animation
     * mapped to the scene clock speed. For example, if the scene is played at 2x real-time, a two-second glTF
     * animation will play in one second even if speedup is 1.0.
     * Default: 1.0
     */
    @JsProperty
    public double speedup;

    /**
     * Options for {@link org.cesiumjs.cs.collections.ModelAnimationCollection#add(ModelAnimationOptions)}
     */
    @JsConstructor
    public ModelAnimationOptions() {}
}
