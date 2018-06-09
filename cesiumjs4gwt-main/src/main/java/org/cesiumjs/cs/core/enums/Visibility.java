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
import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Visibility")
public class Visibility {
    /**
     * Represents that an object is visible in its entirety.
     */
    @JsProperty(name = "FULL")
    public static native Number FULL();
    /**
     * Represents that no part of an object is visible.
     */
    @JsProperty(name = "NONE")
    public static native Number NONE();
    /**
     * Represents that part, but not all, of an object is visible
     */
    @JsProperty(name = "PARTIAL")
    public static native Number PARTIAL();


    /**
     * This enumerated type is used in determining to what extent an object, the occludee, is visible during horizon culling.
     * An occluder may fully block an occludee, in which case it has no visibility, may partially block an occludee
     * from view, or may not block it at all, leading to full visibility.
     */
    @JsIgnore
    @JsConstructor
    private Visibility() {}
}
