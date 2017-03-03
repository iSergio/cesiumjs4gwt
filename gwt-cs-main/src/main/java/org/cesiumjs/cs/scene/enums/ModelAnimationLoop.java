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

package org.cesiumjs.cs.scene.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ModelAnimationLoop")
public class ModelAnimationLoop {
    /**
     * Loop the animation. First, playing it forward, then in reverse, then forward, and so on.
     */
    @JsProperty(name = "MIRRORED_REPEAT")
    public static native Number MIRRORED_REPEAT();
    /**
     * Play the animation once; do not loop it.
     */
    @JsProperty(name = "NONE")
    public static native Number NONE();
    /**
     * Loop the animation playing it from the start immediately after it stops.
     */
    @JsProperty(name = "REPEAT")
    public static native Number REPEAT();

    @JsConstructor
    private ModelAnimationLoop() {}
}
