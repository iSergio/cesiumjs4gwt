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
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.particle.options.ParticleBurstOptions;

/**
 * Represents a burst of {@link Particle} from a {@link ParticleSystem} at a given time in the systems lifetime.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ParticleBurst")
public class ParticleBurst {
    /**
     * true if the burst has been completed; false otherwise.
     */
    @JsProperty
    public boolean complete;
    /**
     * The time in seconds after the beginning of the particle system's lifetime that the burst will occur.
     * Default: 0.0
     */
    @JsProperty
    public double time;
    /**
     * The minimum number of particles emmitted in the burst.
     * Default: 0.0
     */
    @JsProperty
    public double minimum;
    /**
     * The maximum number of particles emitted in the burst.
     * Default: 50.0
     */
    @JsProperty
    public double maximum;

    /**
     * Represents a burst of {@link Particle} from a {@link ParticleSystem} at a given time in the systems lifetime.
     */
    @JsConstructor
    public ParticleBurst() {}

    /**
     * Represents a burst of {@link Particle} from a {@link ParticleSystem} at a given time in the systems lifetime.
     * @param options {@link ParticleBurstOptions}
     */
    @JsConstructor
    public ParticleBurst(ParticleBurstOptions options) {}

    @JsOverlay
    public static ParticleBurst create(double time, double minimum, double maximum) {
        ParticleBurstOptions options = new ParticleBurstOptions();
        options.time = time;
        options.minimum = minimum;
        options.maximum = maximum;
        return new ParticleBurst(options);
    }
}
