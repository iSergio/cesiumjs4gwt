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
import org.cesiumjs.cs.datasources.graphics.options.PointGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.Property;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PointGraphics")
public class PointGraphics {
    /**
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * A Property specifying the Color of the point.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Property color;
    /**
     * Gets or sets the distance from the camera at which to disable the depth test to, for example,
     * prevent clipping against terrain. When set to zero, the depth test is always applied. When set to
     * Number.POSITIVE_INFINITY, the depth test is never applied.
     * Default: 0.0
     */
    @JsProperty
    public Property disableDepthTestDistance;
    /**
     * A numeric Property specifying the size in pixels.
     * Default: 1
     */
    @JsProperty
    public Property pixelSize;
    /**
     * A Property specifying the Color of the outline.
     * Default: {@link Color#BLACK()}
     */
    @JsProperty
    public Property outlineColor;
    /**
     * A numeric Property specifying the the outline width in pixels.
     * Default: 0
     */
    @JsProperty
    public Property outlineWidth;
    /**
     * A boolean Property specifying the visibility of the point.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A NearFarScalar Property used to scale the point based on distance.
     */
    @JsProperty
    public Property scaleByDistance;
    /**
     * A NearFarScalar Property used to set translucency based on distance from the camera.
     */
    @JsProperty
    public Property translucencyByDistance;
    /**
     * A Property specifying what the height is relative to.
     * Default: {@link HeightReference#NONE}
     */
    @JsProperty
    public Property heightReference;
    /**
     * A Property specifying at what distance from the camera that this point will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;

    /**
     * Describes a graphical point located at the position of the containing {@link org.cesiumjs.cs.datasources.Entity}.
     */
    @JsConstructor
    public PointGraphics() {}

    /**
     * Describes a graphical point located at the position of the containing {@link org.cesiumjs.cs.datasources.Entity}.
     * @param options Options
     */
    @JsConstructor
    public PointGraphics(PointGraphicsOptions options) {}

    /**
     * Duplicates this instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    public native PointGraphics clone(@JsOptional PointGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    public native void merge(PointGraphics source);
}
