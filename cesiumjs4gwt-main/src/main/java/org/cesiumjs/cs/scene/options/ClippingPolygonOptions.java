/*
 * Copyright 2024 iSergio, Gis4Fun.
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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Ellipsoid;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ClippingPolygonOptions {
    /**
     * A list of three or more Cartesian coordinates defining the outer ring of the clipping polygon.
     */
    @JsProperty
    public Cartesian3[] positions;

    /**
     * Default: {@link org.cesiumjs.cs.core.Ellipsoid#WGS84()}
     */
    @JsProperty
    public Ellipsoid ellipsoid;

    @JsConstructor
    public ClippingPolygonOptions() {
    }

    @JsOverlay
    public static ClippingPolygonOptions create(Cartesian3[] positions) {
        ClippingPolygonOptions options = new ClippingPolygonOptions();
        options.positions = positions;
        return options;
    }

    @JsOverlay
    public static ClippingPolygonOptions create(Cartesian3[] positions, Ellipsoid ellipsoid) {
        ClippingPolygonOptions options = new ClippingPolygonOptions();
        options.positions = positions;
        options.ellipsoid = ellipsoid;
        return options;
    }
}
