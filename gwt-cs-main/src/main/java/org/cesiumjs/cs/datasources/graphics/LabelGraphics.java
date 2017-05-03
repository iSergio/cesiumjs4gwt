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
import org.cesiumjs.cs.datasources.graphics.options.LabelGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.cesiumjs.cs.scene.enums.LabelStyle;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "LabelGraphics")
public class LabelGraphics {
    /**
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * A Property specifying the text.
     */
    @JsProperty
    public Property text;
    /**
     * A Property specifying the CSS font.
     * Default: '10px sans-serif'
     */
    @JsProperty
    public Property font;
    /**
     * A Property specifying the LabelStyle.
     * Default: {@link LabelStyle#FILL()}
     */
    @JsProperty
    public Property style;
    /**
     * A Property specifying the fill Color.
     * Default: {@link org.cesiumjs.cs.core.Color#BLACK()}
     */
    @JsProperty
    public Property fillColor;
    /**
     * A Property specifying the outline Color.
     * Default: {@link Color#BLACK()}
     */
    @JsProperty
    public Property outlineColor;
    /**
     * A numeric Property specifying the outline width.
     * Default: 1.0
     */
    @JsProperty
    public Property outlineWidth;
    /**
     * A boolean Property specifying the visibility of the label.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A boolean Property specifying the visibility of the background behind the label.
     * Default: false
     */
    @JsProperty
    public Property showBackground;
    /**
     * A Property specifying the background Color.
     * Default: Color(0.165, 0.165, 0.165, 0.8)
     */
    @JsProperty
    public Property backgroundColor;
    /**
     * A Cartesian2 Property specifying the horizontal and vertical background padding in pixels.
     * Default: Cartesian2(7, 5)
     */
    @JsProperty
    public Property backgroundPadding;
    /**
     * Gets or sets the distance from the camera at which to disable the depth test to, for example,
     * prevent clipping against terrain. When set to zero, the depth test is always applied. When set to
     * Number.POSITIVE_INFINITY, the depth test is never applied.
     * Default: 0.0
     */
    @JsProperty
    public Property disableDepthTestDistance;
    /**
     * A numeric Property specifying the scale to apply to the text.
     * Default: 1.0
     */
    @JsProperty
    public Property scale;
    /**
     * A Property specifying the HorizontalOrigin.
     * Default: {@link VerticalOrigin#CENTER()}
     */
    @JsProperty
    public Property horizontalOrigin;
    /**
     * A Property specifying the VerticalOrigin.
     * Default: {@link VerticalOrigin#CENTER()}
     */
    @JsProperty
    public Property verticalOrigin;
    /**
     * A Cartesian3 Property specifying the eye offset.
     * Default: {@link org.cesiumjs.cs.core.Cartesian3#ZERO()}
     */
    @JsProperty
    public Property eyeOffset;
    /**
     * A Cartesian2 Property specifying the pixel offset.
     * Default: {@link org.cesiumjs.cs.core.Cartesian2#ZERO()}
     */
    @JsProperty
    public Property pixelOffset;
    /**
     * A NearFarScalar Property used to set translucency based on distance from the camera.
     */
    @JsProperty
    public Property translucencyByDistance;
    /**
     * A NearFarScalar Property used to set pixelOffset based on distance from the camera.
     */
    @JsProperty
    public Property pixelOffsetScaleByDistance;
    /**
     * A Property specifying what the height is relative to.
     * Default: {@link HeightReference#NONE()}
     */
    @JsProperty
    public Property heightReference;
    /**
     * A Property specifying at what distance from the camera that this label will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;

    @JsConstructor
    public LabelGraphics() {}

    @JsConstructor
    public LabelGraphics(LabelGraphicsOptions options) {}

    /**
     * Duplicates this instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    public native LabelGraphics clone(@JsOptional LabelGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    public native void merge(LabelGraphics source);
}
