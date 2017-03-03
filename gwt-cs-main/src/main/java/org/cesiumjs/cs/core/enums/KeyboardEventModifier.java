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

package org.cesiumjs.cs.core.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "KeyboardEventModifier")
public class KeyboardEventModifier {
    /**
     * Represents the alt key being held down.
     */
    @JsProperty(name = "ALT")
    public static native Number ALT();
    /**
     * Represents the control key being held down.
     */
    @JsProperty(name = "CTRL")
    public static native Number CTRL();
    /**
     * Represents the shift key being held down.
     */
    @JsProperty(name = "SHIFT")
    public static native Number SHIFT();

    /**
     * This enumerated type is for representing keyboard modifiers. These are keys that are held down in addition to other event types.
     */
    @JsConstructor
    private KeyboardEventModifier() {}
}
