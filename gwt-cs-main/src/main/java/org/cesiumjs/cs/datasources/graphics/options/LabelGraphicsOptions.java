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
import org.cesiumjs.cs.scene.enums.LabelStyle;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class LabelGraphicsOptions {
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

    /**
     * Options for {@link org.cesiumjs.cs.datasources.graphics.LabelGraphics}
     */
    @JsConstructor
    public LabelGraphicsOptions() {}
}
