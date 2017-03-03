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
import org.cesiumjs.cs.scene.Billboard;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "HorizontalOrigin")
public class HorizontalOrigin {
    /**
     * The origin is at the horizontal center of the object.
     */
    @JsProperty(name = "CENTER")
    public static native Number CENTER();
    /**
     * The origin is on the left side of the object.
     */
    @JsProperty(name = "LEFT")
    public static native Number LEFT();
    /**
     * The origin is on the right side of the object.
     */
    @JsProperty(name = "RIGHT")
    public static native Number RIGHT();

    /**
     * The horizontal location of an origin relative to an object, e.g., a {@link Billboard}. For example, the horizontal
     * origin is used to display a billboard to the left or right (in screen space) of the actual position.
     * @see Billboard#horizontalOrigin
     */
    @JsConstructor
    private HorizontalOrigin() {}
}
