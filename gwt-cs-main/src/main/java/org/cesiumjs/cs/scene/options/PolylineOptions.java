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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.DistanceDisplayCondition;
import org.cesiumjs.cs.scene.Material;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PolylineOptions {
    /**
     * if this polyline will be shown; otherwise, false.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * The width of the polyline in pixels.
     * Default: 1.0
     */
    @JsProperty
    public double width;
    /**
     * Whether a line segment will be added between the last and first line positions to make this line a loop.
     * Default: false
     */
    @JsProperty
    public boolean loop;
    /**
     * The material.
     * Default: {@link Material#ColorType()}
     */
    @JsProperty
    public Material material;
    /**
     * The positions.
     */
    @JsProperty
    public Cartesian3[] positions;
    /**
     * The user-defined object to be returned when this polyline is picked.
     */
    @JsProperty
    public Object id;
    /**
     * The condition specifying at what distance from the camera that this polyline will be displayed.
     */
    @JsProperty
    public DistanceDisplayCondition distanceDisplayCondition;

    /**
     * Options for {@link org.cesiumjs.cs.scene.Polyline}
     */
    @JsConstructor
    public PolylineOptions() {}
}
