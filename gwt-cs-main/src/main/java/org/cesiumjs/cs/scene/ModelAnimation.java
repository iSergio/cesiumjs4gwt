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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.ModelAnimationCollection;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.scene.enums.ModelAnimationLoop;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ModelAnimation")
public class ModelAnimation {
    /**
     * The delay, in seconds, from ModelAnimation#startTime to start playing.
     * Default: undefined
     */
    @JsProperty(name = "delay")
    public native double delay();
    /**
     * Determines if and how the animation is looped.
     * Default: {@link ModelAnimationLoop#NONE()}
     */
    @JsProperty(name = "loop")
    public native Integer loop();
    /**
     * The glTF animation name that identifies this animation.
     */
    @JsProperty(name = "name")
    public native String name();
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
    @JsProperty(name = "reverse")
    public native boolean reverse();
    /**
     * Values greater than 1.0 increase the speed that the animation is played relative to the scene clock speed;
     * values less than 1.0 decrease the speed. A value of 1.0 plays the animation at the speed in the glTF animation
     * mapped to the scene clock speed. For example, if the scene is played at 2x real-time, a two-second glTF
     * animation will play in one second even if speedup is 1.0.
     * Default: 1.0
     */
    @JsProperty(name = "speedup")
    public native double speedup();
    /**
     * The event fired when this animation is started. This can be used, for example, to play a sound or start a particle system, when the animation starts.
     * This event is fired at the end of the frame after the scene is rendered.
     * Default:  new Event()
     */
    @JsProperty
    public Event start;
    /**
     * The scene time to start playing this animation. When this is undefined, the animation starts at the next frame.
     * Default: undefined
     */
    @JsProperty(name = "startTime")
    public native JulianDate startTime();
    /**
     * The event fired when this animation is stopped. This can be used, for example, to play a sound or start a particle
     * system, when the animation stops.
     * This event is fired at the end of the frame after the scene is rendered.
     * Default: new Event()
     */
    @JsProperty
    public Event stop;
    /**
     * The scene time to stop playing this animation. When this is undefined, the animation is played for its full
     * duration and perhaps repeated depending on ModelAnimation#loop.
     * Default: undefined
     */
    @JsProperty(name = "stopTime")
    public native JulianDate stopTime();
    /**
     * The event fired when on each frame when this animation is updated. The current time of the animation,
     * relative to the glTF animation time span, is passed to the event, which allows, for example, starting new
     * animations at a specific time relative to a playing animation.
     * This event is fired at the end of the frame after the scene is rendered.
     * Default: new Event()
     */
    @JsProperty
    public Event update;

    /**
     * An active glTF animation. A glTF asset can contain animations. An active animation is an animation that is
     * currently playing or scheduled to be played because it was added to a model's {@link ModelAnimationCollection}.
     * An active animation is an instance of an animation; for example, there can be multiple active animations for the
     * same glTF animation, each with a different start time.
     * Create this by calling {@link ModelAnimationCollection#add}.
     *
     * @see: ModelAnimationCollection#add
     */
    @JsConstructor
    public ModelAnimation() {}
}
