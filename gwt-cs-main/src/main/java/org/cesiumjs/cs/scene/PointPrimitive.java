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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.DistanceDisplayCondition;
import org.cesiumjs.cs.core.NearFarScalar;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PointPrimitive")
public class PointPrimitive {
    /**
     * Gets or sets the inner color of the point. The red, green, blue, and alpha values are indicated by
     * value's red, green, blue, and alpha properties as shown in Example 1.
     * These components range from 0.0 (no intensity) to 1.0 (full intensity).
     */
    @JsProperty
    public Color color;
    /**
     * Gets or sets the distance from the camera at which to disable the depth test to, for example,
     * prevent clipping against terrain. When set to zero, the depth test is always applied. When set to
     * Number.POSITIVE_INFINITY, the depth test is never applied.
     * Default: 0.0
     */
    @JsProperty
    public double disableDepthTestDistance;
    /**
     * Gets or sets the condition specifying at what distance from the camera that this point will be displayed.
     * Default: undefined
     */
    @JsProperty
    public DistanceDisplayCondition distanceDisplayCondition;
    /**
     * Gets or sets the user-defined object returned when the point is picked.
     */
    @JsProperty
    public Object id;
    /**
     * Gets or sets the outline color of the point.
     */
    @JsProperty
    public Color outlineColor;
    /**
     * Gets or sets the outline width in pixels. This width adds to pixelSize, increasing the total size of the point.
     */
    @JsProperty
    public double outlineWidth;
    /**
     * Gets or sets the inner size of the point in pixels.
     */
    @JsProperty
    public int pixelSize;
    /**
     * Gets or sets the Cartesian position of this point.
     */
    @JsProperty
    public Cartesian3 position;
    /**
     * Gets or sets near and far scaling properties of a point based on the point's distance from the camera.
     * A point's scale will interpolate between the {@link NearFarScalar#nearValue} and {@link NearFarScalar#farValue} while the
     * camera distance falls within the upper and lower bounds of the specified {@link NearFarScalar#near} and {@link NearFarScalar#far}.
     * Outside of these ranges the point's scale remains clamped to the nearest bound. This scale multiplies the
     * pixelSize and outlineWidth to affect the total size of the point. If undefined, scaleByDistance will be disabled.
     */
    @JsProperty
    public NearFarScalar scaleByDistance;
    /**
     * Determines if this point will be shown. Use this to hide or show a point, instead of removing it and re-adding it to the collection.
     */
    @JsProperty
    public boolean show;
    /**
     * Gets or sets near and far translucency properties of a point based on the point's distance from the camera.
     * A point's translucency will interpolate between the {@link NearFarScalar#nearValue} and {@link NearFarScalar#farValue} while the
     * camera distance falls within the upper and lower bounds of the specified {@link NearFarScalar#near} and {@link NearFarScalar#far}.
     * Outside of these ranges the point's translucency remains clamped to the nearest bound.
     * If undefined, translucencyByDistance will be disabled.
     */
    @JsProperty
    public NearFarScalar translucencyByDistance;

    /**
     * A graphical point positioned in the 3D scene, that is created and rendered using a PointPrimitiveCollection.
     * A point is created and its initial properties are set by calling PointPrimitiveCollection#add.
     *
     * Performance:
     * Reading a property, e.g., PointPrimitive#show, is constant time. Assigning to a property is constant time
     * but results in CPU to GPU traffic when PointPrimitiveCollection#update is called. The per-pointPrimitive
     * traffic is the same regardless of how many properties were updated. If most pointPrimitives in a collection
     * need to be updated, it may be more efficient to clear the collection with PointPrimitiveCollection#removeAll
     * and add new pointPrimitives instead of modifying each one.
     * @see PointPrimitiveCollection
     * @see PointPrimitiveCollection#add
     */
    @JsConstructor
    public PointPrimitive() {}
}
