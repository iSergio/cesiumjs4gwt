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
import org.cesiumjs.cs.core.Plane;
import org.cesiumjs.cs.core.Rectangle;

/**
 * A geodesic polygon to be used with ClippingPlaneCollection for selectively hiding regions in a model, a 3D tileset, or the globe.
 */
@JsType(isNative = true, namespace = "Cesium", name = "ClippingPolygon")
public class ClippingPolygon {
    /**
     * Returns the ellipsoid used to project the polygon onto surfaces when clipping.
     */
    @JsProperty(name = "ellipsoid")
    public native Ellipsoid ellipsoid();

    /**
     * Returns the total number of positions in the polygon, include any holes.
     */
    @JsProperty(name = "length")
    public native Number length();

    /**
     * Returns the outer ring of positions.
     */
    @JsProperty(name = "positions")
    public native Cartesian3[] positions();

    @JsConstructor
    public ClippingPolygon(ClippingPolygonOptions options) {
    }

    @JsOverlay
    public static ClippingPolygon create(Cartesian3[] positions) {
        ClippingPolygonOptions options = ClippingPolygonOptions.create(positions);
        return new ClippingPolygon(options);
    }

    /**
     * Clones the ClippingPolygon without setting its ownership.
     * @param polygon The ClippingPolygon to be cloned
     * @return a clone of the input ClippingPolygon
     */
    @JsMethod
    public static native ClippingPolygon clone(ClippingPolygon polygon);

    /**
     * Clones the ClippingPolygon without setting its ownership.
     * @param polygon The ClippingPolygon to be cloned
     * @param result The object on which to store the cloned parameters.
     * @return a clone of the input ClippingPolygon
     */
    @JsMethod
    public static native ClippingPolygon clone(ClippingPolygon polygon, ClippingPolygon result);

    /**
     * Compares the provided ClippingPolygons and returns true if they are equal, false otherwise.
     * @param left The first polygon.
     * @param right The second polygon.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(Plane left, Plane right);

    /**
     * Computes a cartographic rectangle which encloses the polygon defined by the list of positions,
     * including cases over the international date line and the poles.
     * @return The result rectangle
     */
    @JsMethod
    public native org.cesiumjs.cs.core.Rectangle computeRectangle();

    /**
     * Computes a cartographic rectangle which encloses the polygon defined by the list of positions,
     * including cases over the international date line and the poles.
     * @param result An object in which to store the result.
     * @return The result rectangle
     */
    @JsMethod
    public native org.cesiumjs.cs.core.Rectangle computeRectangle(Rectangle result);
}
