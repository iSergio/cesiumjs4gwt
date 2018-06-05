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

package org.cesiumjs.cs.scene.particle.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.scene.emitters.ParticleEmitter;
import org.cesiumjs.cs.scene.particle.ParticleBurst;
import org.cesiumjs.cs.scene.particle.ParticleSystem;

/**
 * Options for {@link ParticleSystem}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ParticleSystemOptions {
    /**
     * Whether to display the particle system.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * The callback function to be called each frame to update a particle.
     */
    @JsProperty
    public ParticleSystem.UpdateCallback updateCallback;
    /**
     * The particle emitter for this system.
     * Default: new CircleEmitter(0.5)
     */
    @JsProperty
    public ParticleEmitter emitter;
    /**
     * The 4x4 transformation matrix that transforms the particle system from model to world coordinates.
     * Default: {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}.
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * The 4x4 transformation matrix that transforms the particle system emitter within the particle systems local coordinate system.
     * Default: {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}.
     */
    @JsProperty
    public Matrix4 emitterModelMatrix;
    /**
     * Sets the color of a particle for the duration of its particleLife.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Color color;
    /**
     * The color of a particle when it is born.
     */
    @JsProperty
    public Color startColor;
    /**
     * The color of a particle when it dies.
     */
    @JsProperty
    public Color endColor;
    /**
     * Sets the scale to apply to the image of the particle for the duration of its particleLife.
     * Default: 1.0
     */
    @JsProperty
    public double scale;
    /**
     * The scale of the particle when it is born.
     */
    @JsProperty
    public double startScale;
    /**
     * The scale of the particle when it dies.
     */
    @JsProperty
    public double endScale;
    /**
     * The number of particles to emit per second.
     * Default: 5
     */
    @JsProperty
    public double emissionRate;
    /**
     * An array of ParticleBurst, emitting bursts of particles at periodic times.
     */
    @JsProperty
    public ParticleBurst[] bursts;
    /**
     * Whether the particle system should loop it's bursts when it is complete.
     * Default: true
     */
    @JsProperty
    public boolean loop;
    /**
     * Sets the minimum and maximum speed in meters per second
     */
    @JsProperty
    public double speed;
    /**
     * Sets the minimum speed in meters per second.
     * Default: 1.0
     */
    @JsProperty
    public double minimumSpeed;
    /**
     * Sets the maximum speed in meters per second.
     * Default: 1.0
     */
    @JsProperty
    public double maximumSpeed;
    /**
     * If set, overrides the minimumParticleLife and maximumParticleLife inputs with this value.
     * Default: 5.0
     */
    @JsProperty
    public double particleLife;
    /**
     * Sets the minimum bound in seconds for the possible duration of a particle's life above which a particle's actual
     * life will be randomly chosen.
     */
    @JsProperty
    public double minimumParticleLife;
    /**
     * Sets the maximum bound in seconds for the possible duration of a particle's life below which a particle's actual
     * life will be randomly chosen.
     */
    @JsProperty
    public double maximumParticleLife;
    /**
     * Sets the minimum and maximum mass of particles in kilograms.
     */
    @JsProperty
    public double mass;
    /**
     * Sets the minimum mass of particles in kilograms.
     * Default: 1.0
     */
    @JsProperty
    public double minimumMass;
    /**
     * Sets the maximum mass of particles in kilograms.
     * Default: 1.0
     */
    @JsProperty
    public double maximumMass;
    /**
     * The URI, HTMLImageElement, or HTMLCanvasElement to use for the billboard.
     */
    @JsProperty
    public Object image;
    /**
     * If set, overrides the minimumImageSize and maximumImageSize inputs that scale the particle image's dimensions in pixels.
     * Default: new Cartesian2(1.0, 1.0)
     */
    @JsProperty
    public Cartesian2 imageSize;
    /**
     * Sets the minimum bound, width by height, above which to randomly scale the particle image's dimensions in pixels.
     */
    @JsProperty
    public Cartesian2 minimumImageSize;
    /**
     * Sets the maximum bound, width by height, below which to randomly scale the particle image's dimensions in pixels.
     */
    @JsProperty
    public Cartesian2 maximumImageSize;
    /**
     * How long the particle system will emit particles, in seconds.
     * Default: {@link Double#MAX_VALUE}
     */
    @JsProperty
    public double lifetime;

    /**
     * Options for {@link ParticleSystem}.
     */
    @JsConstructor
    public ParticleSystemOptions() {}
}
