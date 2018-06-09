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

package org.cesiumjs.cs.datasources.graphics.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class EllipsoidGraphicsOptions {
    /**
     * A Cartesian3 Property specifying the radii of the ellipsoid.
     */
    @JsProperty
    public Property radii;
    /**
     * A boolean Property specifying the visibility of the ellipsoid.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A boolean Property specifying whether the ellipsoid is filled with the provided material.
     * Default: true
     */
    @JsProperty
    public Property fill;
    /**
     * A Property specifying the material used to fill the ellipsoid.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}
     */
    @JsProperty
    public MaterialProperty material;
    /**
     * A boolean Property specifying whether the ellipsoid is outlined.
     * Default: false
     */
    @JsProperty
    public Property outline;
    /**
     * A Property specifying the Color of the outline.
     * Default: {@link Color#BLACK()}
     */
    @JsProperty
    public Property outlineColor;
    /**
     * A numeric Property specifying the width of the outline.
     * Default: 1.0
     */
    @JsProperty
    public Property outlineWidth;
    /**
     * A Property specifying the number of samples per outline ring, determining the granularity of the curvature.
     * Default: 128
     */
    @JsProperty
    public Property subdivisions;
    /**
     * A Property specifying the number of stacks.
     * Default: 64
     */
    @JsProperty
    public Property stackPartitions;
    /**
     * A Property specifying the number of radial slices.
     * Default: 64
     */
    @JsProperty
    public Property slicePartitions;
    /**
     * An enum Property specifying whether the ellipsoid casts or receives shadows from each light source.
     * Default: {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public Property shadows;
    /**
     * A Property specifying at what distance from the camera that this ellipsoid will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;

    /**
     * Options for {@link org.cesiumjs.cs.datasources.graphics.EllipsoidGraphics}
     */
    @JsConstructor
    public EllipsoidGraphicsOptions() {}
}
