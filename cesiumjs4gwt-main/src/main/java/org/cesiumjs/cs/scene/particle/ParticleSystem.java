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

package org.cesiumjs.cs.scene.particle;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.scene.emitters.ParticleEmitter;
import org.cesiumjs.cs.scene.particle.options.ParticleSystemOptions;

/**
 * A ParticleSystem manages the updating and display of a collection of particles.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ParticleSystem")
public class ParticleSystem {
    /**
     * Fires an event when the particle system has reached the end of its lifetime.
     */
    @JsProperty
    public Event complete;
    /**
     * The particle emitter for this system.
     * Default: new CircleEmitter(0.5)
     */
    @JsProperty
    public ParticleEmitter emitter;
    /**
     * The 4x4 transformation matrix that transforms the particle system emitter within the particle systems local coordinate system.
     * Default: {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}.
     */
    @JsProperty
    public Matrix4 emitterModelMatrix;
    /**
     * The color of a particle when it dies.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}.
     */
    @JsProperty
    public Color endColor;
    /**
     * The scale of the particle when it dies.
     * Default: 1.0
     */
    @JsProperty
    public double endScale;
    /**
     * The URI, HTMLImageElement, or HTMLCanvasElement to use for the billboard.
     */
    @JsProperty
    public Object image;
    /**
     * When true, the particle system has reached the end of its lifetime; false otherwise.
     */
    @JsProperty
    public boolean isComplete;
    /**
     * How long the particle system will emit particles, in seconds.
     * Default: {@link Double#MAX_VALUE}
     */
    @JsProperty
    public double lifetime;
    /**
     * Whether the particle system should loop it's bursts when it is complete.
     * Default: true
     */
    @JsProperty
    public boolean loop;
    /**
     * Sets the maximum bound, width by height, below which to randomly scale the particle image's dimensions in pixels.
     */
    @JsProperty
    public Cartesian2 maximumImageSize;
    /**
     * Sets the maximum mass of particles in kilograms.
     * Default: 1.0
     */
    @JsProperty
    public double maximumMass;
    /**
     * Sets the maximum bound in seconds for the possible duration of a particle's life below which a particle's actual
     * life will be randomly chosen.
     */
    @JsProperty
    public double maximumParticleLife;
    /**
     * Sets the maximum speed in meters per second.
     * Default: 1.0
     */
    @JsProperty
    public double maximumSpeed;
    /**
     * Sets the minimum bound, width by height, above which to randomly scale the particle image's dimensions in pixels.
     */
    @JsProperty
    public Cartesian2 minimumImageSize;
    /**
     * Sets the minimum mass of particles in kilograms.
     * Default: 1.0
     */
    @JsProperty
    public double minimumMass;
    /**
     * Sets the minimum bound in seconds for the possible duration of a particle's life above which a particle's actual
     * life will be randomly chosen.
     */
    @JsProperty
    public double minimumParticleLife;
    /**
     * Sets the minimum speed in meters per second.
     * Default: 1.0
     */
    @JsProperty
    public double minimumSpeed;
    /**
     * The 4x4 transformation matrix that transforms the particle system from model to world coordinates.
     * Default: {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}.
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * The number of particles to emit per second.
     * Default: 5
     */
    @JsProperty
    public double emissionRate;
    /**
     * Whether to display the particle system.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * Sets if the size of particles is in meters or pixels. true to size the particles in meters; otherwise, the size is in pixels.
     * Default: false
     */
    @JsProperty
    public boolean sizeInMeters;
    /**
     * The color of a particle when it is born.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}.
     */
    @JsProperty
    public Color startColor;
    /**
     * The scale of the particle when it is born.
     * Default: 1.0
     */
    @JsProperty
    public double startScale;

    /**
     * A ParticleSystem manages the updating and display of a collection of particles.
     */
    @JsConstructor
    public ParticleSystem() {}

    /**
     * A ParticleSystem manages the updating and display of a collection of particles.
     * @param options {@link ParticleSystemOptions}.
     */
    @JsConstructor
    public ParticleSystem(ParticleSystemOptions options) {}

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed
     * will result in a DeveloperError exception.
      * @return true if this object was destroyed; otherwise, false.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * @see <a href="https://cesiumjs.org/tutorials/Particle-Systems-Tutorial/">Particle Systems Tutorial</a>
     */
    @JsFunction
    public interface UpdateCallback {
        /**
         * A function used to modify attributes of the particle at each time step.
         * This can include force modifications, color, sizing, etc.
         * @see <a href="https://cesiumjs.org/tutorials/Particle-Systems-Tutorial/">Particle Systems Tutorial</a>
         * @param particle The particle being updated.
         * @param dt The time in seconds since the last update.
         */
        void function(Particle particle, double dt);
    }
}
