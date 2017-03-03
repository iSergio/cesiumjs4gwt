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

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "SceneMode")
public class SceneMode {
    /**
     * Columbus View mode. A 2.5D perspective view where the map is laid out flat and objects with non-zero height are drawn above it.
     */
    @JsProperty(name = "COLUMBUS_VIEW")
    public static native Number COLUMBUS_VIEW();

    /**
     * Morphing between mode, e.g., 3D to 2D.
     */
    @JsProperty(name = "MORPHING")
    public static native Number MORPHING();

    /**
     * 2D mode. The map is viewed top-down with an orthographic projection.
     */
    @JsProperty(name = "SCENE2D")
    public static native Number SCENE2D();

    /**
     * 3D mode. A traditional 3D perspective view of the globe.
     */
    @JsProperty(name = "SCENE3D")
    public static native Number SCENE3D();

    /**
     * Returns the morph time for the given scene mode.
     * @param value The scene mode
     * @return The morph time
     */
    public static native double getMorphTime(int value);
}
