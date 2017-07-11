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
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.scene.particle.ParticleBurst;
import org.cesiumjs.cs.scene.particle.ParticleSystem;
import org.cesiumjs.cs.scene.emitters.ParticleEmitter;

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
     * An array of force callbacks.
     */
    @JsProperty
    public ParticleSystem.ApplyForce[] forces;
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
     * The color of a particle when it is born.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}.
     */
    @JsProperty
    public Color startColor;
    /**
     * The color of a particle when it dies.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}.
     */
    @JsProperty
    public Color endColor;
    /**
     * The scale of the particle when it is born.
     * Default: 1.0
     */
    @JsProperty
    public double startScale;
    /**
     * The scale of the particle when it dies.
     * Default: 1.0
     */
    @JsProperty
    public double endScale;
    /**
     * The number of particles to emit per second.
     * Default: 5
     */
    @JsProperty
    public double rate;
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
     * Sets the minimum and maximum life of particles in seconds.
     */
    @JsProperty
    public double life;
    /**
     * Sets the minimum life of particles in seconds.
     * Default: 5.0
     */
    @JsProperty
    public double minimumLife;
    /**
     * Sets the maximum life of particles in seconds.
     * Default: 5.0
     */
    @JsProperty
    public double maximumLife;
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
     * Sets the minimum and maximum width of particles in pixels.
     */
    @JsProperty
    public double width;
    /**
     * Sets the minimum width of particles in pixels.
     * Default: 1.0
     */
    @JsProperty
    public double minimumWidth;
    /**
     * Sets the maximum width of particles in pixels.
     * Default: 1.0
     */
    @JsProperty
    public double maximumWidth;
    /**
     * Sets the minimum and maximum height of particles in pixels.
     */
    @JsProperty
    public double height;
    /**
     * Sets the minimum height of particles in pixels.
     * Default: 1.0
     */
    @JsProperty
    public double minimumHeight;
    /**
     * Sets the maximum height of particles in pixels.
     * Default: 1.0
     */
    @JsProperty
    public double maximumHeight;
    /**
     * How long the particle system will emit particles, in seconds.
     */
    @JsProperty
    public double lifeTime;

    /**
     * Options for {@link ParticleSystem}.
     */
    @JsConstructor
    public ParticleSystemOptions() {}
}
