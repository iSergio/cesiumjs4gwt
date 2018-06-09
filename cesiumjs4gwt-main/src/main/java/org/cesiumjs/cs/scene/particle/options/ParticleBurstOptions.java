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
import org.cesiumjs.cs.scene.particle.ParticleBurst;

/**
 * Options for {@link ParticleBurst}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ParticleBurstOptions {
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

    @JsConstructor
    public ParticleBurstOptions() {}
}
