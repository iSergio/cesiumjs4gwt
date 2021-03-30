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

package org.cesiumjs.cs.scene.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Determines how input texture to a
 * {@link org.cesiumjs.cs.scene.PostProcessStage} is sampled.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PostProcessStageSampleMode")
public class PostProcessStageSampleMode {
    @JsConstructor
    private PostProcessStageSampleMode() {
    }

    /**
     * Samples the texture through bi-linear interpolation of the four nearest
     * texels.
     */
    @JsProperty(name = "LINEAR")
    public static native Number LINEAR();

    /**
     * Samples the texture by returning the closest texel.
     */
    @JsProperty(name = "NEAREST")
    public static native Number NEAREST();
}
