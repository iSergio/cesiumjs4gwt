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
@JsType(isNative = true, namespace = "Cesium", name = "CameraEventType")
public class CameraEventType {
    /**
     * A left mouse button press followed by moving the mouse and releasing the button.
     */
    @JsProperty(name = "LEFT_DRAG")
    public static native Number LEFT_DRAG();
    /**
     * A middle mouse button press followed by moving the mouse and releasing the button.
     */
    @JsProperty(name = "MIDDLE_DRAG")
    public static native Number MIDDLE_DRAG();
    /**
     * A two-finger touch on a touch surface.
     */
    @JsProperty(name = "PINCH")
    public static native Number PINCH();
    /**
     * A right mouse button press followed by moving the mouse and releasing the button.
     */
    @JsProperty(name = "RIGHT_DRAG")
    public static native Number RIGHT_DRAG();
    /**
     * Scrolling the middle mouse button.
     */
    @JsProperty(name = "WHEEL")
    public static native Number WHEEL();

    /**
     * Enumerates the available input for interacting with the camera.
     */
    @JsConstructor
    private CameraEventType() {}
}
