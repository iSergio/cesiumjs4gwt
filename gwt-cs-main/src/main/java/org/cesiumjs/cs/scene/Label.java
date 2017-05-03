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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.LabelCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.LabelStyle;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Label")
public class Label {
    /**
     * Gets or sets the background color of this label.
     * Default: new Color(0.165, 0.165, 0.165, 0.8)
     */
    @JsProperty
    public Color backgroundColor;
    /**
     * Gets or sets the background padding, in pixels, of this label. The x value controls horizontal padding,
     * and the y value controls vertical padding.
     * Default: new Cartesian2(7, 5)
     */
    @JsProperty
    public Cartesian2 backgroundPadding;
    /**
     * Gets or sets the distance from the camera at which to disable the depth test to, for example,
     * prevent clipping against terrain. When set to zero, the depth test is always applied. When set to
     * Number.POSITIVE_INFINITY, the depth test is never applied.
     * Default: 0.0
     */
    @JsProperty
    public double disableDepthTestDistance;
    /**
     * Gets or sets the condition specifying at what distance from the camera that this label will be displayed.
     * Default:  undefined
     */
    @JsProperty
    public DistanceDisplayCondition distanceDisplayCondition;
    /**
     * Gets and sets the 3D Cartesian offset applied to this label in eye coordinates. Eye coordinates is a left-handed
     * coordinate system, where x points towards the viewer's right, y points up, and z points into the screen.
     * Eye coordinates use the same scale as world and model coordinates, which is typically meters.
     *
     * An eye offset is commonly used to arrange multiple label or objects at the same position, e.g., to arrange a
     * label above its corresponding 3D model.
     *
     * Below, the label is positioned at the center of the Earth but an eye offset makes it always appear on top of
     * the Earth regardless of the viewer's or Earth's orientation.
     */
    @JsProperty
    public Cartesian3 eyeOffset;
    /**
     * Gets or sets the fill color of this label.
     * @see <a href="https://whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#fill-and-stroke-styles">HTML canvas 2D context fill and stroke styles</a>
     */
    @JsProperty
    public Color fillColor;
    /**
     * Gets or sets the font used to draw this label. Fonts are specified using the same syntax as the CSS 'font' property.
     * @see <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#text-styles">HTML canvas 2D context text styles</a>
     */
    @JsProperty
    public String font;
    /**
     * Gets or sets the height reference of this billboard.
     * @see HeightReference
     */
    @JsProperty
    public int heightReference;
    /**
     * Gets or sets the horizontal origin of this label, which determines if the label is drawn to the left, center, or right of its position.
     * @see HorizontalOrigin
     */
    @JsProperty
    public int horizontalOrigin;
    /**
     * Gets or sets the user-defined object returned when the label is picked.
     */
    @JsProperty
    public Object id;
    /**
     * Gets or sets the outline color of this label.
     * @see <a href="https://whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#fill-and-stroke-styles">HTML canvas 2D context fill and stroke styles</a>
     */
    @JsProperty
    public Color outlineColor;
    /**
     * Gets or sets the outline width of this label.
     * @see <a href="https://whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#fill-and-stroke-styles">HTML canvas 2D context fill and stroke styles</a>
     */
    @JsProperty
    public int outlineWidth;
    /**
     * Gets or sets the pixel offset in screen space from the origin of this label.
     * This is commonly used to align multiple labels and billboards at the same position, e.g., an imagery and text.
     * The screen space origin is the top, left corner of the canvas; x increases from left to right, and y increases from top to bottom.
     */
    @JsProperty
    public Cartesian2 pixelOffset;

    /**
     * Gets or sets near and far pixel offset scaling properties of a Label based on the Label's distance from the camera.
     * A label's pixel offset will be scaled between the NearFarScalar#nearValue and NearFarScalar#farValue while the camera
     * distance falls within the upper and lower bounds of the specified NearFarScalar#near and NearFarScalar#far.
     * Outside of these ranges the label's pixel offset scaling remains clamped to the nearest bound. If undefined, pixelOffsetScaleByDistance will be disabled.
     * <pre>
     *     Example:
     *     {@code
     *     // Example 1.
     *     // Set a label's pixel offset scale to 0.0 when the
     *     // camera is 1500 meters from the label and scale pixel offset to 10.0 pixels
     *     // in the y direction the camera distance approaches 8.0e6 meters.
     *     text.pixelOffset = new Cartesian2(0.0, 1.0);
     *     text.pixelOffsetScaleByDistance = new NearFarScalar(1.5e2, 0.0, 8.0e6, 10.0);
     *     // Example 2.
     *     // disable pixel offset by distance
     *     text.pixelOffsetScaleByDistance = undefined;
     *     }
     * </pre>
     */
    @JsProperty
    public NearFarScalar pixelOffsetScaleByDistance;
    /**
     * Gets or sets the Cartesian position of this label.
     */
    @JsProperty
    public Cartesian3 position;
    /**
     * Gets or sets the uniform scale that is multiplied with the label's size in pixels.
     * A scale of 1.0 does not change the size of the label; a scale greater than 1.0 enlarges the label;
     * a positive scale less than 1.0 shrinks the label.
     *
     * Applying a large scale value may pixelate the label. To make text larger without pixelation, use a larger
     * font size when calling Label#font instead.
     */
    @JsProperty
    public double scale;
    /**
     * Gets or sets near and far scaling properties of a Label based on the label's distance from the camera.
     * A label's scale will interpolate between the {@link NearFarScalar#nearValue} and {@link NearFarScalar#farValue} while
     * the camera distance falls within the upper and lower bounds of the specified {@link NearFarScalar#near} and {@link NearFarScalar#far}.
     * Outside of these ranges the label's scale remains clamped to the nearest bound. If undefined, scaleByDistance will be disabled.
     */
    @JsProperty
    public NearFarScalar scaleByDistance;
    /**
     * Determines if this label will be shown. Use this to hide or show a label, instead of removing it and re-adding it to the collection.
     */
    @JsProperty
    public boolean show;
    /**
     * Gets or sets the style of this label.
     * @see LabelStyle
     */
    public int style;
    /**
     * Gets or sets the text of this label.
     */
    @JsProperty
    public String text;

    /**
     * Gets or sets near and far translucency properties of a Label based on the Label's distance from the camera.
     * A label's translucency will interpolate between the NearFarScalar#nearValue and NearFarScalar#farValue while
     * the camera distance falls within the upper and lower bounds of the specified NearFarScalar#near and NearFarScalar#far.
     * Outside of these ranges the label's translucency remains clamped to the nearest bound. If undefined,
     * translucencyByDistance will be disabled.
     */
//    @JsProperty
    //TODO: Example
    public NearFarScalar translucencyByDistance;
    /**
     * Gets or sets the vertical origin of this label, which determines if the label is to the above, below,
     * or at the center of its position.
     * @see VerticalOrigin
     */
    @JsProperty
    public int verticalOrigin;

    /**
     * A Label draws viewport-aligned text positioned in the 3D scene.
     * This constructor should not be used directly, instead create labels by calling {@link LabelCollection#add}.
     *
     * @see LabelCollection
     * @see LabelCollection#add
     */
    @JsConstructor
    public Label() {}

    /**
     * Computes the screen-space position of the label's origin, taking into account eye and pixel offsets.
     * The screen space origin is the top, left corner of the canvas; x increases from left to right, and y increases from top to bottom.
     * @param scene The scene the label is in.
     * @param result The object onto which to store the result.
     * @return The screen-space position of the label.
     * @see #eyeOffset
     * @see #pixelOffset
     */
    @JsMethod
    public native Cartesian2 computeScreenSpacePosition(Scene scene, Cartesian2 result);

    /**
     * Determines if this label equals another label. Labels are equal if all their properties are equal. Labels in different collections can be equal.
     * @param other The label to compare for equality.
     * @return true if the labels are equal; otherwise, false.
     */
    @JsMethod
    public native boolean equals(Label other);

    /**
     * Returns true if this object was destroyed; otherwise, false.
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will result in a DeveloperError exception.
     * @return True if this object was destroyed; otherwise, false.
     */
    @JsMethod
    public native boolean isDestroyed();
}
