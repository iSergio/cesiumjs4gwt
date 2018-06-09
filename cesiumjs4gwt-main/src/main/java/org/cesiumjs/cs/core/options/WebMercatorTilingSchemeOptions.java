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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian2;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class WebMercatorTilingSchemeOptions {
    /**
     * The southwest corner of the rectangle covered by the tiling scheme, in meters.
     * If this parameter or rectangleNortheastInMeters is not specified,
     * the entire globe is covered in the longitude direction and an equal distance is
     * covered in the latitude direction, resulting in a square projection.
     */
    @JsProperty
    public Cartesian2 rectangleSouthwestInMeters;
    /**
     * optional The northeast corner of the rectangle covered by the tiling scheme, in meters.
     * If this parameter or rectangleSouthwestInMeters is not specified, the entire globe is
     * covered in the longitude direction and an equal distance is covered in the latitude direction,
     * resulting in a square projection.
     */
    @JsProperty
    public Cartesian2 rectangleNortheastInMeters;

    @JsConstructor
    public WebMercatorTilingSchemeOptions() {}
}
