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

package org.cesiumjs.cs.scene.emitters;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A ParticleEmitter that emits particles from a circle. Particles will be positioned within a circle and have
 * initial velocities going along the z vector.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CircleEmitter")
public class CircleEmitter implements ParticleEmitter {
    /**
     * The angle of the cone in radians.
     * Default: Math.toRadians(30.0)
     */
    @JsProperty
    public double angle;
    /**
     * The radius of the circle in meters.
     * Default: 1.0
     */
    @JsProperty
    public double radius;

    /**
     * A ParticleEmitter that emits particles from a circle. Particles will be positioned within a circle and
     * have initial velocities going along the z vector.
     */
    @JsConstructor
    public CircleEmitter() {}

    /**
     * A ParticleEmitter that emits particles from a circle. Particles will be positioned within a circle and
     * have initial velocities going along the z vector.
     * @param radius The radius of the circle in meters.
     */
    @JsConstructor
    public CircleEmitter(double radius) {}
}
