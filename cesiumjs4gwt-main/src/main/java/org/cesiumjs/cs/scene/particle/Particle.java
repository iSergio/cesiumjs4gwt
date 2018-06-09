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

package org.cesiumjs.cs.scene.particle;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.scene.particle.options.ParticleOptions;

/**
 * A particle emitted by a {@link ParticleSystem}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Particle")
public class Particle {
    /**
     * Gets the age of the particle in seconds.
     */
    @JsProperty
    public double age;
    /**
     * The mass of particles in kilograms.
     * Default: 1.0
     */
    @JsProperty
    public double mass;
    /**
     * The initial position of the particle in world coordinates.
     * Default: {@link Cartesian3#ZERO()}
     */
    @JsProperty
    public Cartesian3 position;
    /**
     * The velocity vector of the particle in world coordinates.
     * Default: {@link Cartesian3#ZERO()}
     */
    @JsProperty
    public Cartesian3 velocity;
    /**
     * The life of particles in seconds.
     * Default: max value
     */
    @JsProperty
    public double life;
    /**
     * The URI, HTMLImageElement, or HTMLCanvasElement to use for the billboard.
     */
    @JsProperty
    public Object image;
    /**
     * The color of a particle when it is born.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}
     */
    @JsProperty
    public Color startColor;
    /**
     * The color of a particle when it dies.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}
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
     * The dimensions of particles in pixels.
     * Default: new Cartesian2(1.0, 1.0)
     */
    @JsProperty
    public Cartesian2 size;
    /**
     * Gets the age normalized to a value in the range [0.0, 1.0].
     */
    @JsProperty
    public double normalizedAge;

    @JsConstructor
    public Particle(ParticleOptions options) {}
}
