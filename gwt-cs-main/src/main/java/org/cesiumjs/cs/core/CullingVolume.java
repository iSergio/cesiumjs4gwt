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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.enums.Intersect;

/**
 * The culling volume defined by planes.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CullingVolume")
public class CullingVolume {
    /**
     * Each plane is represented by a Cartesian4 object, where the x, y, and z components define the unit vector normal
     * to the plane, and the w component is the distance of the plane from the origin.
     * Default: []
     */
    @JsProperty
    public Cartesian4[] planes;

    /**
     * The culling volume defined by planes.
     */
    @JsConstructor
    public CullingVolume() {}

    /**
     * The culling volume defined by planes.
     * @param planes An array of clipping planes.
     */
    @JsConstructor
    public CullingVolume(Cartesian4[] planes) {}

    /**
     * Constructs a culling volume from a bounding sphere. Creates six planes that create a box containing the sphere.
     * The planes are aligned to the x, y, and z axes in world coordinates.
     * @param boundingSphere The bounding sphere used to create the culling volume.
     * @return The culling volume created from the bounding sphere.
     */
    public static native org.cesiumjs.cs.scene.CullingVolume fromBoundingSphere(BoundingSphere boundingSphere);

    /**
     * Constructs a culling volume from a bounding sphere. Creates six planes that create a box containing the sphere.
     * The planes are aligned to the x, y, and z axes in world coordinates.
     * @param boundingSphere The bounding sphere used to create the culling volume.
     * @param result The object onto which to store the result.
     * @return The culling volume created from the bounding sphere.
     */
    public static native org.cesiumjs.cs.scene.CullingVolume fromBoundingSphere(BoundingSphere boundingSphere, org.cesiumjs.cs.scene.CullingVolume result);

    /**
     * Determines whether a bounding volume intersects the culling volume.
     * @param boundingVolume The bounding volume whose intersection with the culling volume is to be tested.
     * @return {@link Intersect#OUTSIDE(), {@link Intersect#INTERSECTING()}, or {@link Intersect#INSIDE()}.
     * @see org.cesiumjs.cs.core.enums.Intersect
     */
    public native int computeVisibility(Object boundingVolume);
}