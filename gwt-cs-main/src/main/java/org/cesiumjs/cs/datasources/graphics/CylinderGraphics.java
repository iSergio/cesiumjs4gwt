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

package org.cesiumjs.cs.datasources.graphics;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOptional;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.datasources.graphics.options.CylinderGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CylinderGraphics")
public class CylinderGraphics {
    /**
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * A numeric Property specifying the length of the cylinder.
     */
    @JsProperty
    public Property length;
    /**
     * A numeric Property specifying the radius of the top of the cylinder.
     */
    @JsProperty
    public Property topRadius;
    /**
     * A numeric Property specifying the radius of the bottom of the cylinder.
     */
    @JsProperty
    public Property bottomRadius;
    /**
     * A boolean Property specifying the visibility of the cylinder.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A boolean Property specifying whether the cylinder is filled with the provided material.
     * Default: true
     */
    @JsProperty
    public Property fill;
    /**
     * A Property specifying the material used to fill the cylinder.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public MaterialProperty material;
    /**
     * A boolean Property specifying whether the cylinder is outlined.
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
     * A numeric Property specifying the number of vertical lines to draw along the perimeter for the outline.
     * Default: 16
     */
    @JsProperty
    public Property numberOfVerticalLines;
    /**
     * The number of edges around the perimeter of the cylinder.
     * Default: 128
     */
    @JsProperty
    public Property slices;
    /**
     * An enum Property specifying whether the cylinder casts or receives shadows from each light source.
     * Default: {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public Property shadows;
    /**
     * A Property specifying at what distance from the camera that this cylinder will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;

    /**
     * Describes a cylinder, truncated cone, or cone defined by a length, top radius, and bottom radius.
     * The center position and orientation are determined by the containing {@link org.cesiumjs.cs.datasources.Entity}.
     */
    @JsConstructor
    public CylinderGraphics() {}

    /**
     * Describes a cylinder, truncated cone, or cone defined by a length, top radius, and bottom radius.
     * The center position and orientation are determined by the containing {@link org.cesiumjs.cs.datasources.Entity}.
     * @param options Options
     */
    @JsConstructor
    public CylinderGraphics(CylinderGraphicsOptions options) {}

    /**
     * Duplicates this instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    public native CylinderGraphics clone(@JsOptional CylinderGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    public native void merge(CylinderGraphics source);
}
