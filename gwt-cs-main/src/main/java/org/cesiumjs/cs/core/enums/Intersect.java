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
@JsType(isNative = true, namespace = "Cesium", name = "Intersect")
public class Intersect {
    /**
     * Represents that an object is fully within the frustum.
     */
    @JsProperty(name = "INSIDE")
    public static native Number INSIDE();
    /**
     * Represents that an object intersects one of the frustum's planes.
     */
    @JsProperty(name = "INTERSECTING")
    public static native Number INTERSECTING();
    /**
     * Represents that an object is not contained within the frustum.
     */
    @JsProperty(name = "OUTSIDE")
    public static native Number OUTSIDE();

    /**
     * This enumerated type is used in determining where, relative to the frustum, an object is located.
     * The object can either be fully contained within the frustum (INSIDE), partially inside the frustum and partially
     * outside (INTERSECTING), or somwhere entirely outside of the frustum's 6 planes (OUTSIDE).
     */
    @JsConstructor
    private Intersect() {}
}
