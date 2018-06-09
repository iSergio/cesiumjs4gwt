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
import jsinterop.annotations.JsType;

/**
 * A ParticleEmitter that emits particles within a cone. Particles will be positioned at the tip of the
 * cone and have initial velocities going towards the base.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ConeEmitter")
public class ConeEmitter implements ParticleEmitter {
    /**
     * A ParticleEmitter that emits particles within a cone. Particles will be positioned at the tip of
     * the cone and have initial velocities going towards the base.
     */
    @JsConstructor
    public ConeEmitter() {}

    /**
     * A ParticleEmitter that emits particles within a cone. Particles will be positioned at the tip of
     * the cone and have initial velocities going towards the base.
     * @param angle The angle of the cone in radians. Default: Math.toRadians(30.0).
     */
    @JsConstructor
    public ConeEmitter(double angle) {}
}
