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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.datasources.graphics.options.BoxGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "BoxGraphics")
public class BoxGraphics {
    /**
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * Gets or sets Cartesian3 Property property specifying the length, width, and height of the box.
     */
    @JsProperty
    public Property dimensions;
    /**
     * Gets or sets the DistanceDisplayCondition Property specifying at what distance from the camera that this box will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;
    /**
     * Gets or sets the boolean Property specifying whether the box is filled with the provided material.
     * Default: true
     */
    @JsProperty
    public Property fill;
    /**
     * Gets or sets the material used to fill the box.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public MaterialProperty material;
    /**
     * Gets or sets the Property specifying whether the box is outlined.
     * Default: false
     */
    @JsProperty
    public Property outline;
    /**
     * Gets or sets the Property specifying the Color of the outline.
     * Default: {@link Color#BLACK()}
     */
    @JsProperty
    public Property outlineColor;
    /**
     * Gets or sets the numeric Property specifying the width of the outline.
     * Default: 1.0
     */
    @JsProperty
    public Property outlineWidth;
    /**
     * Get or sets the enum Property specifying whether the box casts or receives shadows from each light source.
     * Default: {@link ShadowMode#DISABLED()}
     */
    @JsProperty
    public Property shadows;
    /**
     * Gets or sets the boolean Property specifying the visibility of the box.
     * Default: true
     */
    @JsProperty
    public Property show;

    /**
     * Describes a box. The center position and orientation are determined by the containing {@link Entity}.
     */
    @JsConstructor
    public BoxGraphics() {}

    /**
     * Describes a box. The center position and orientation are determined by the containing {@link Entity}.
     * @param options Options
     */
    @JsConstructor
    public BoxGraphics(BoxGraphicsOptions options) {}

    /**
     * Duplicates this instance.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    public native BoxGraphics clone();

    /**
     * Duplicates this instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    public native BoxGraphics clone(BoxGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    public native void merge(BoxGraphics source);
}
