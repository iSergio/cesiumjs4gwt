/*
 * Copyright 2018 iserge.
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

/**
 * Options for {@link org.cesiumjs.cs.datasources.graphics.PlaneGraphics}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PlaneGraphicsOptions {
    /**
     * A Plane Property specifying the normal and distance for the plane.
     */
    @JsProperty
    public Property plane;
    /**
     * A Cartesian2 Property specifying the width and height of the plane.
     */
    @JsProperty
    public Property dimensions;
    /**
     * A boolean Property specifying the visibility of the plane.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A boolean Property specifying whether the plane is filled with the provided material.
     * Default: true
     */
    @JsProperty
    public Property fill;
    /**
     * A Property specifying the material used to fill the plane.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public MaterialProperty material;
    /**
     * A boolean Property specifying whether the plane is outlined.
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
     * An enum Property specifying whether the plane casts or receives shadows from each light source.
     * Default: {@link org.cesiumjs.cs.scene.enums.ShadowMode#DISABLED()}
     */
    @JsProperty
    public Property shadows;
    /**
     * A Property specifying at what distance from the camera that this plane will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;

    /**
     * Options for {@link org.cesiumjs.cs.datasources.graphics.PlaneGraphics}
     */
    @JsConstructor
    public PlaneGraphicsOptions() {}
}
