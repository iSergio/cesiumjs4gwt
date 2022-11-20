/*
 * Copyright 2022 iSergio, Gis4Fun.
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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.js.JsObject;

/**
 * This class implements an I3S Geometry. Each I3SGeometry generates an in memory glTF to be used as content
 * for a {@link Cesium3DTile}.
 * Do not construct this directly, instead access tiles through {@link I3SNode}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "I3SGeometry")
public class I3SGeometry {
    /**
     * Gets the custom attributes of the geometry.
     */
    @JsProperty(name = "customAttributes")
    public native JsObject customAttributes();

    /**
     * Gets the I3S data for this object.
     */
    @JsProperty(name = "data")
    public native JsObject data();

    /**
     * Gets the resource for the geometry
     */
    @JsProperty(name = "resource")
    public native Resource resource();

    @JsConstructor
    private I3SGeometry() {}

    /**
     * Find a triangle touching the point [px, py, pz], then return the vertex closest to the search point
     * @param px The x component of the point to query
     * @param py The y component of the point to query
     * @param pz The z component of the point to query
     * @return A structure containing the index of the closest point, the squared distance from the queried point
     * to the point that is found, the distance from the queried point to the point that is found, the queried position
     * in local space, the closest position in local space
     */
    @JsMethod
    public native JsObject getClosestPointIndexOnTriangle(Number px, Number py, Number pz);
}
