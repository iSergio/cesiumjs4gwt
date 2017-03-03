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
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.scene.enums.HeightReference;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class BillboardOptions {
    /**
     * Gets or sets the aligned axis in world space. The aligned axis is the unit vector that the billboard up vector
     * points towards. The default is the zero vector, which means the billboard is aligned to the screen up vector.
     */
    @JsProperty
    public Cartesian3 alignedAxis;
    /**
     * Gets or sets the color that is multiplied with the billboard's texture. This has two common use cases.
     * First, the same white texture may be used by many different billboards, each with a different color,
     * to create colored billboards. Second, the color's alpha component can be used to make the billboard
     * translucent as shown below. An alpha of 0.0 makes the billboard transparent, and 1.0 makes the billboard opaque.
     * The red, green, blue, and alpha values are indicated by value's red, green, blue, and alpha properties as
     * shown in Example 1. These components range from 0.0 (no intensity) to 1.0 (full intensity).
     */
    @JsProperty
    public Color color;
    /**
     * Gets or sets the condition specifying at what distance from the camera that this billboard will be displayed.
     * Default: undefined
     */
    @JsProperty
    public DistanceDisplayCondition distanceDisplayCondition;
    /**
     * Gets or sets the 3D Cartesian offset applied to this billboard in eye coordinates. Eye coordinates is a left-handed
     * coordinate system, where x points towards the viewer's right, y points up, and z points into the screen.
     * Eye coordinates use the same scale as world and model coordinates, which is typically meters.
     *
     * An eye offset is commonly used to arrange multiple billboards or objects at the same position, e.g.,
     * to arrange a billboard above its corresponding 3D model.
     *
     * Below, the billboard is positioned at the center of the Earth but an eye offset makes it always appear on top of
     * the Earth regardless of the viewer's or Earth's orientation.
     */
    @JsProperty
    public Cartesian3 eyeOffset;
    /**
     * Gets or sets a height for the billboard. If undefined, the image height will be used.
     */
    @JsProperty
    public Number height;
    /**
     * Gets or sets the height reference of this billboard.
     * Default: {@link HeightReference#NONE()}
     */
    @JsProperty
    public Integer heightReference;
    /**
     * Gets or sets the horizontal origin of this billboard, which determines if the billboard is to the left, center, or right of its position.
     */
    @JsProperty
    public Integer horizontalOrigin;
    /**
     * Gets or sets the user-defined object returned when the billboard is picked.
     */
    @JsProperty
    public Object id;
    /**
     * Gets or sets the image to be used for this billboard. If a texture has already been created for the given image,
     * the existing texture is used.
     *
     * This property can be set to a loaded Image, a URL which will be loaded as an Image automatically, a canvas, or
     * another billboard's image property (from the same billboard collection).
     */
    @JsProperty
    public String image;
    /**
     * Gets or sets the pixel offset in screen space from the origin of this billboard. This is commonly used to align
     * multiple billboards and labels at the same position, e.g., an image and text. The screen space origin is the top,
     * left corner of the canvas; x increases from left to right, and y increases from top to bottom.
     */
    @JsProperty
    public Cartesian2 pixelOffset;
    /**
     * Gets or sets near and far pixel offset scaling properties of a Billboard based on the billboard's distance from the camera.
     * A billboard's pixel offset will be scaled between the {@link NearFarScalar#nearValue} and {@link NearFarScalar#farValue} while
     * the camera distance falls within the upper and lower bounds of the specified {@link NearFarScalar#near} and {@link NearFarScalar#far}.
     * Outside of these ranges the billboard's pixel offset scale remains clamped to the nearest bound. If undefined,
     * pixelOffsetScaleByDistance will be disabled.
     */
    @JsProperty
    public NearFarScalar pixelOffsetScaleByDistance;
    /**
     * Gets or sets the Cartesian position of this billboard.
     */
    @JsProperty
    public Cartesian3 position;
    /**
     * When true, this billboard is ready to render, i.e., the image has been downloaded and the WebGL resources are created.
     * Default: false
     */
    @JsProperty(name = "ready")
    public native boolean ready();
    /**
     * Gets or sets the rotation angle in radians.
     */
    @JsProperty
    public Number rotation;

    /**
     * Gets or sets the uniform scale that is multiplied with the billboard's image size in pixels. A scale of 1.0 does
     * not change the size of the billboard; a scale greater than 1.0 enlarges the billboard; a positive scale
     * less than 1.0 shrinks the billboard.
     */
    @JsProperty
    public Number scale;
    /**
     * Gets or sets near and far scaling properties of a Billboard based on the billboard's distance from the camera.
     * A billboard's scale will interpolate between the {@link NearFarScalar#nearValue} and {@link NearFarScalar#farValue} while
     * the camera distance falls within the upper and lower bounds of the specified {@link NearFarScalar#near} and {@link NearFarScalar#far}.
     * Outside of these ranges the billboard's scale remains clamped to the nearest bound. If undefined, scaleByDistance will be disabled.
     */
    @JsProperty
    public NearFarScalar scaleByDistance;
    /**
     * Determines if this billboard will be shown. Use this to hide or show a billboard, instead of removing it and re-adding it to the collection.
     */
    @JsProperty
    public boolean show;
    /**
     * Gets or sets if the billboard size is in meters or pixels. true to size the billboard in meters; otherwise, the size is in pixels.
     * Default: false
     */
    @JsProperty
    public boolean sizeInMeters;
    /**
     * Gets or sets near and far translucency properties of a Billboard based on the billboard's distance from the camera.
     * A billboard's translucency will interpolate between the {@link NearFarScalar#nearValue} and {@link NearFarScalar#farValue}
     * while the camera distance falls within the upper and lower bounds of the specified {@link NearFarScalar#near} and
     * {@link NearFarScalar#far}. Outside of these ranges the billboard's translucency remains clamped to the nearest bound.
     * If undefined, translucencyByDistance will be disabled.
     */
    @JsProperty
    public NearFarScalar translucencyByDistance;
    /**
     * Gets or sets the vertical origin of this billboard, which determines if the billboard is to the above, below,
     * or at the center of its position.
     */
    @JsProperty
    public Number verticalOrigin;
    /**
     * Gets or sets a width for the billboard. If undefined, the image width will be used.
     */
    @JsProperty
    public int width;

    @JsConstructor
    public BillboardOptions() {}
}
