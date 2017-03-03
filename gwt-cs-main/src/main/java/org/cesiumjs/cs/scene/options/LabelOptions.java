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
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.LabelStyle;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class LabelOptions {
    /**
     * Determines if this label will be shown. Use this to hide or show a label, instead of removing it and re-adding it to the collection.
     */
    @JsProperty
    public boolean show;
    /**
     * Gets or sets the Cartesian position of this label.
     */
    @JsProperty
    public Cartesian3 position;
    /**
     * Gets or sets the text of this label.
     */
    @JsProperty
    public String text;
    /**
     * Gets or sets the font used to draw this label. Fonts are specified using the same syntax as the CSS 'font' property.
     * @see <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#text-styles">HTML canvas 2D context text styles</a>
     */
    @JsProperty
    public String font;
    /**
     * Gets or sets the fill color of this label.
     * @see <a href="https://whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#fill-and-stroke-styles">HTML canvas 2D context fill and stroke styles</a>
     */
    @JsProperty
    public Color fillColor;
    /**
     * Gets or sets the outline color of this label.
     * @see <a href="https://whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#fill-and-stroke-styles">HTML canvas 2D context fill and stroke styles</a>
     */
    @JsProperty
    public Color outlineColor;
    /**
     * Gets or sets the style of this label.
     * @see LabelStyle
     */
    @JsProperty
    public int style;
    /**
     * Gets or sets the pixel offset in screen space from the origin of this label.
     * This is commonly used to align multiple labels and billboards at the same position, e.g., an imagery and text.
     * The screen space origin is the top, left corner of the canvas; x increases from left to right, and y increases from top to bottom.
     */
    @JsProperty
    public Cartesian2 pixelOffset;
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
     * Gets or sets the horizontal origin of this label, which determines if the label is drawn to the left, center, or right of its position.
     * @see HorizontalOrigin
     */
    @JsProperty
    public int horizontalOrigin;
    /**
     * Gets or sets the vertical origin of this label, which determines if the label is to the above, below,
     * or at the center of its position.
     * @see VerticalOrigin
     */
    @JsProperty
    public int verticalOrigin;
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

    @JsConstructor
    public LabelOptions() {}
}
