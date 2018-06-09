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
 * A ParticleEmitter that emits particles within a sphere. Particles will be positioned randomly within the sphere
 * and have initial velocities emanating from the center of the sphere.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "SphereEmitter")
public class SphereEmitter implements ParticleEmitter {
    /**
     * The radius of the sphere in meters.
     * Default: 1.0
     */
    @JsProperty
    public double radius;
    /**
     * A ParticleEmitter that emits particles within a sphere. Particles will be positioned randomly within
     * the sphere and have initial velocities emanating from the center of the sphere.
     * @param radius The radius of the sphere in meters. Default: 1
     */
    @JsConstructor
    public SphereEmitter(double radius) {}
}
