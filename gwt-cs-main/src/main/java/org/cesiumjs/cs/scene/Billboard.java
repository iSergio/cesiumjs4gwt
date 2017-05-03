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

import com.google.gwt.dom.client.CanvasElement;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.BillboardCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.js.JsImage;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.enums.HeightReference;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Billboard")
public class Billboard {
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
     * Gets or sets the distance from the camera at which to disable the depth test to, for example,
     * prevent clipping against terrain. When set to zero, the depth test is always applied. When set to
     * Number.POSITIVE_INFINITY, the depth test is never applied.
     * Default: 0.0
     */
    @JsProperty
    public double disableDepthTestDistance;
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
    public double height;
    /**
     * Gets or sets the height reference of this billboard.
     * Default: {@link HeightReference#NONE()}
     */
    @JsProperty
    public Number heightReference;
    /**
     * Gets or sets the horizontal origin of this billboard, which determines if the billboard is to the left, center, or right of its position.
     */
    @JsProperty
    public Number horizontalOrigin;
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
    public double rotation;

    /**
     * Gets or sets the uniform scale that is multiplied with the billboard's image size in pixels. A scale of 1.0 does
     * not change the size of the billboard; a scale greater than 1.0 enlarges the billboard; a positive scale
     * less than 1.0 shrinks the billboard.
     */
    @JsProperty
    public double scale;
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

    /**
     * A viewport-aligned image positioned in the 3D scene, that is created and rendered using a {@link BillboardCollection}.
     * A billboard is created and its initial properties are set by calling {@link BillboardCollection#add}.
     * Performance:
     * Reading a property, e.g., Billboard#show, is constant time. Assigning to a property is constant
     * time but results in CPU to GPU traffic when {@link BillboardCollection#update} is called.
     * The per-billboard traffic is the same regardless of how many properties were updated.
     * If most billboards in a collection need to be updated, it may be more efficient to clear the collection
     * with BillboardCollection#removeAll and add new billboards instead of modifying each one.
     * @see BillboardCollection
     * @see BillboardCollection#add
     * @see Label
     */
    @JsConstructor
    public Billboard() {}

    /**
     * Computes the screen-space position of the billboard's origin, taking into account eye and pixel offsets.
     * The screen space origin is the top, left corner of the canvas; x increases from left to right, and y increases from top to bottom.
     * @param scene The scene.
     * @return The screen-space position of the billboard.
     * @see Billboard#eyeOffset
     * @see Billboard#pixelOffset
     */
    public native Cartesian2 computeScreenSpacePosition(Scene scene);

    /**
     * Computes the screen-space position of the billboard's origin, taking into account eye and pixel offsets.
     * The screen space origin is the top, left corner of the canvas; x increases from left to right, and y increases from top to bottom.
     * @param scene The scene.
     * @param result The object onto which to store the result.
     * @return The screen-space position of the billboard.
     * @see Billboard#eyeOffset
     * @see Billboard#pixelOffset
     */
    public native Cartesian2 computeScreenSpacePosition(Scene scene, Cartesian2 result);

    /**
     * Determines if this billboard equals another billboard. Billboards are equal if all their properties are equal. Billboards in different collections can be equal.
     * @param other The billboard to compare for equality.
     * @return true if the billboards are equal; otherwise, false.
     */
    public native boolean equals(Billboard other);

    /**
     * Sets the image to be used for this billboard. If a texture has already been created for the given id, the existing texture is used.
     *
     * This function is useful for dynamically creating textures that are shared across many billboards. Only the first
     * billboard will actually call the function and create the texture, while subsequent billboards created with the same id will simply re-use the existing texture.
     *
     * To load an image from a URL, setting the {@link Billboard#image} property is more convenient.
     * @param id The id of the image. This can be any string that uniquely identifies the image.
     * @param image The image to load. This parameter can either be a loaded Image or Canvas, a URL which will be
     *              loaded as an Image automatically, or a function which will be called to create the image if it hasn't been loaded already.
     */
    public native void setImage(String id, JsImage image);

    /**
     * Sets the image to be used for this billboard. If a texture has already been created for the given id, the existing texture is used.
     *
     * This function is useful for dynamically creating textures that are shared across many billboards. Only the first
     * billboard will actually call the function and create the texture, while subsequent billboards created with the same id will simply re-use the existing texture.
     *
     * To load an image from a URL, setting the {@link Billboard#image} property is more convenient.
     * @param id The id of the image. This can be any string that uniquely identifies the image.
     * @param image The image to load. This parameter can either be a loaded Image or Canvas, a URL which will be
     *              loaded as an Image automatically, or a function which will be called to create the image if it hasn't been loaded already.
     */
    public native void setImage(String id, CanvasElement image);

    /**
     * Sets the image to be used for this billboard. If a texture has already been created for the given id, the existing texture is used.
     *
     * This function is useful for dynamically creating textures that are shared across many billboards. Only the first
     * billboard will actually call the function and create the texture, while subsequent billboards created with the same id will simply re-use the existing texture.
     *
     * To load an image from a URL, setting the {@link Billboard#image} property is more convenient.
     * @param id The id of the image. This can be any string that uniquely identifies the image.
     * @param image The image to load. This parameter can either be a loaded Image or Canvas, a URL which will be
     *              loaded as an Image automatically, or a function which will be called to create the image if it hasn't been loaded already.
     */
    public native void setImage(String id, String image);

    /**
     * Sets the image to be used for this billboard. If a texture has already been created for the given id, the existing texture is used.
     *
     * This function is useful for dynamically creating textures that are shared across many billboards. Only the first
     * billboard will actually call the function and create the texture, while subsequent billboards created with the same id will simply re-use the existing texture.
     *
     * To load an image from a URL, setting the {@link Billboard#image} property is more convenient.
     * @param id The id of the image. This can be any string that uniquely identifies the image.
     * @param image The image to load. This parameter can either be a loaded Image or Canvas, a URL which will be
     *              loaded as an Image automatically, or a function which will be called to create the image if it hasn't been loaded already.
     */
    public native void setImage(String id, CreateImagePromiseCallback image);

    /**
     * Uses a sub-region of the image with the given id as the image for this billboard, measured in pixels from the bottom-left.
     * @param id The id of the image to use.
     * @param subRegion The sub-region of the image.
     */
    public native void setImageSubRegion(String id, BoundingRectangle subRegion);

    /**
     * A function that creates an image.
     */
    @JsFunction
    public interface CreateImagePromiseCallback<T extends Object> {
        /**
         * A function that creates an image.
         * @param id The identifier of the image to load.
         * @return The image, or a promise that will resolve to an image.
         */
        Promise<T, Void> function(String id);
    }
}
