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
@JsType(isNative = true, namespace = "Cesium", name = "VerticalOrigin")
public class VerticalOrigin {
    /**
     * The origin is at the vertical center of the object.
     */
    @JsProperty(name = "CENTER")
    public static native Number CENTER();
    /**
     * The origin is at the bottom of the object.
     */
    @JsProperty(name = "BOTTOM")
    public static native Number BOTTOM();
    /**
     * If the object contains text, the origin is at the baseline of the text,
     * else the origin is at the bottom of the object.
     * @return
     */
    @JsProperty(name = "BASELINE")
    public static native Number BASELINE();
    /**
     * The origin is at the top of the object.
     */
    @JsProperty(name = "TOP")
    public static native Number TOP();

    /**
     * The vertical location of an origin relative to an object, e.g., a {@link org.cesiumjs.cs.datasources.graphics.BillboardGraphics}. For example, the vertical
     * origin is used to display a billboard above or below (in screen space) of the actual position.
     * @see: Billboard#verticalOrigin
     */
    @JsConstructor
    private VerticalOrigin() {}
}
