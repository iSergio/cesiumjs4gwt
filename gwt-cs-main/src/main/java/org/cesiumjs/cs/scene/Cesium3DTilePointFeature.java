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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.DistanceDisplayCondition;
import org.cesiumjs.cs.core.NearFarScalar;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.enums.LabelStyle;

/**
 * A point feature of a {@link Cesium3DTileset}.
 * Provides access to a feature's properties stored in the tile's batch table, as well as the ability to show/hide a
 * feature and change its point properties
 *
 * Modifications to a Cesium3DTilePointFeature object have the lifetime of the tile's content. If the tile's content
 * is unloaded, e.g., due to it going out of view and needing to free space in the cache for visible tiles, listen to
 * the {@link Cesium3DTileset#tileUnload} event to save any modifications. Also listen to the {@link Cesium3DTileset#tileVisible} event
 * to reapply any modifications.
 *
 * Do not construct this directly. Access it through Cesium3DTileContent#getFeature or picking using Scene#pick and
 * {@link Scene#pickPosition}.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cesium3DTilePointFeature")
public class Cesium3DTilePointFeature {
    /**
     * Gets or sets the color for the anchor line.
     * Only applied when heightOffset is defined.
     */
    @JsProperty
    public Color anchorLineColor;
    /**
     * Gets or sets whether the anchor line is displayed.
     * Only applied when heightOffset is defined.
     */
    @JsProperty
    public boolean anchorLineEnabled;
    /**
     * Gets or sets the background color of the text for this feature.
     Only applied when labelText is defined.
     */
    @JsProperty
    public Color backgroundColor;
    /**
     * Gets or sets whether to display the background of the text for this feature.
     * Only applied when labelText is defined.
     */
    @JsProperty
    public boolean backgroundEnabled;
    /**
     * Gets or sets the background padding of the text for this feature.
     * Only applied when labelText is defined.
     */
    @JsProperty
    public Cartesian2 backgroundPadding;
    /**
     * Gets or sets the color of the point of this feature.
     * Only applied when image is undefined.
     */
    @JsProperty
    public Color color;
    /**
     * Gets or sets the distance where depth testing will be disabled.
     */
    @JsProperty
    public Number disableDepthTestDistance;
    /**
     * Gets or sets the condition specifying at what distance from the camera that this feature will be displayed.
     */
    @JsProperty
    public DistanceDisplayCondition distanceDisplayCondition;
    /**
     * Gets or sets the font of this feature.
     * Only applied when the labelText is defined.
     */
    @JsProperty
    public String font;
    /**
     * Gets or sets the height offset in meters of this feature.
     */
    @JsProperty
    public double heightOffset;
    /**
     * Gets or sets the horizontal origin of this point, which determines if the point is to the left, center, or right of its anchor position.
     */
    @JsProperty
    public Number horizontalOrigin;
    /**
     * Gets or sets the image of this feature.
     */
    @JsProperty
    public String image;
    /**
     * Gets or sets the label color of this feature.
     * */
    @JsProperty
    public Color labelColor;
    /**
     * Gets or sets the horizontal origin of this point's text, which determines if the point's text is to the left,
     * center, or right of its anchor position.
     * @see org.cesiumjs.cs.scene.enums.HorizontalOrigin
     */
    @JsProperty
    public Number labelHorizontalOrigin;
    /**
     * Gets or sets the label outline color of this feature.
     * The outline color will be applied to the label if labelText is defined.
     */
    @JsProperty
    public Color labelOutlineColor;
    /**
     * Gets or sets the outline width in pixels of this feature.
     * The outline width will be applied to the point if labelText is defined.
     */
    @JsProperty
    public double labelOutlineWidth;
    /**
     * Gets or sets the fill and outline style of this feature.
     * Only applied when labelText is defined.
     */
    @JsProperty
    public LabelStyle labelStyle;
    /**
     * Gets or sets the text for this feature.
     */
    @JsProperty
    public String labelText;
    /**
     * Get or sets the vertical origin of this point's text, which determines if the point's text is to the bottom,
     * center, top, or baseline of it's anchor point.
     * @see org.cesiumjs.cs.scene.enums.VerticalOrigin
     */
    @JsProperty
    public Number labelVerticalOrigin;
    /**
     * Gets or sets the point outline color of this feature.
     * Only applied when image is undefined.
     */
    @JsProperty
    public Color pointOutlineColor;
    /**
     * Gets or sets the point outline width in pixels of this feature.
     * Only applied when image is undefined.
     */
    @JsProperty
    public double pointOutlineWidth;
    /**
     * Gets or sets the point size of this feature.
     * Only applied when image is undefined.
     */
    @JsProperty
    public double pointSize;
    /**
     * All objects returned by Scene#pick have a primitive property. This returns the tileset containing the feature.
     */
    @JsProperty
    public Cesium3DTileset readonlyprimitive;
    /**
     * Gets or sets the near and far scaling properties for this feature.
     */
    @JsProperty
    public NearFarScalar scaleByDistance;
    /**
     * Gets or sets if the feature will be shown. This is set for all features when a style's show is evaluated.
     * Default: true
     */
    boolean show;

    /**
     * Gets the tileset containing the feature.
     */
    @JsProperty(name = "tileset")
    public native Cesium3DTileset tileset();
    /**
     * Gets or sets the near and far translucency properties for this feature.
     */
    @JsProperty
    public NearFarScalar translucencyByDistance;
    /**
     * Gets or sets the vertical origin of this point, which determines if the point is to the bottom, center, or top of its anchor position.
     * @see org.cesiumjs.cs.scene.enums.VerticalOrigin
     */
    @JsProperty
    public Number verticalOrigin;

    /**
     * A point feature of a {@link Cesium3DTileset}.
     * Provides access to a feature's properties stored in the tile's batch table, as well as the ability to show/hide a
     * feature and change its point properties
     *
     * Modifications to a Cesium3DTilePointFeature object have the lifetime of the tile's content. If the tile's content
     * is unloaded, e.g., due to it going out of view and needing to free space in the cache for visible tiles, listen to
     * the {@link Cesium3DTileset#tileUnload} event to save any modifications. Also listen to the {@link Cesium3DTileset#tileVisible} event
     * to reapply any modifications.
     *
     * Do not construct this directly. Access it through Cesium3DTileContent#getFeature or picking using Scene#pick and
     * {@link Scene#pickPosition}.
     */
    @JsConstructor
    protected Cesium3DTilePointFeature() {}

    /**
     * Returns a copy of the value of the feature's property with the given name. This includes properties from this
     * feature's class and inherited classes when using a batch table hierarchy.
     * @param name The case-sensitive name of the property.
     * @return The value of the property or undefined if the property does not exist.
     */
    @JsMethod
    public native JsObject getProperty(String name);

    /**
     * Returns an array of property names for the feature. This includes properties from this feature's class and inherited
     * classes when using a batch table hierarchy.
     * @param results The names of the feature's properties.
     * @return The names of the feature's properties.
     */
    @JsMethod
    public native String[] getPropertyNames(String[] results);

    /**
     * Sets the value of the feature's property with the given name.
     * If a property with the given name doesn't exist, it is created.
     * @param name The case-sensitive name of the property.
     * @param value The value of the property that will be copied.
     */
    @JsMethod
    public native void setProperty(String name, JsObject value);
}
