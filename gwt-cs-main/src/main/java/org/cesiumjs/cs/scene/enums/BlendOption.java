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
 * Determines how opaque and translucent parts of billboards, points, and labels are blended with the scene.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "BlendOption")
public class BlendOption {
    /**
     * The billboards, points, or labels in the collection are completely opaque.
     */
    @JsProperty(name = "OPAQUE")
    public static native Number OPAQUE();
    /**
     * The billboards, points, or labels in the collection are both opaque and translucent.
     */
    @JsProperty(name = "OPAQUE_AND_TRANSLUCENT")
    public static native Number OPAQUE_AND_TRANSLUCENT();
    /**
     * The billboards, points, or labels in the collection are completely translucent.
     */
    @JsProperty(name = "TRANSLUCENT")
    public static native Number TRANSLUCENT();

    /**
     * Determines how opaque and translucent parts of billboards, points, and labels are blended with the scene.
     */
    @JsConstructor
    private BlendOption() {}
}
