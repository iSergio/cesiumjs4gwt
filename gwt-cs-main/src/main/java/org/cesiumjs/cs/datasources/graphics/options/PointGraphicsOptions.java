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
import org.cesiumjs.cs.datasources.properties.Property;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PointGraphicsOptions {
    /**
     * A Property specifying the Color of the point.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Property color;
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
     * Options for {@link org.cesiumjs.cs.datasources.graphics.PointGraphics}
     */
    @JsConstructor
    public PointGraphicsOptions() {}
}
