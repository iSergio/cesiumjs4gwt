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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.datasources.graphics.options.BillboardGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "BillboardGraphics")
public class BillboardGraphics {
    /**
     * Gets or sets the Cartesian3 Property specifying the unit vector axis of rotation in the fixed frame.
     * When set to Cartesian3.ZERO the rotation is from the top of the screen.
     * Default: {@link Cartesian3#ZERO()}
     */
    @JsProperty
    public Property alignedAxis;
    /**
     * Gets or sets the Property specifying the Color that is multiplied with the imagery.
     * This has two common use cases. First, the same white texture may be used by many different billboards, each with
     * a different color, to create colored billboards. Second, the color's alpha component can be used to
     * make the billboard translucent as shown below. An alpha of 0.0 makes the billboard transparent, and 1.0 makes the billboard opaque.
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
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * Gets or sets the DistanceDisplayCondition Property specifying at what distance from the camera that this billboard will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;
    /**
     * Gets or sets the Cartesian3 Property specifying the billboard's offset in eye coordinates. Eye coordinates is a
     * left-handed coordinate system, where x points towards the viewer's right, y points up, and z points into the screen.
     *
     * An eye offset is commonly used to arrange multiple billboards or objects at the same position, e.g., to arrange
     * a billboard above its corresponding 3D model.
     *
     * Below, the billboard is positioned at the center of the Earth but an eye offset makes it always appear on top of
     * the Earth regardless of the viewer's or Earth's orientation.
     * Default: {@link Cartesian3#ZERO()}
     */
    @JsProperty
    public Property eyeOffset;
    /**
     * Gets or sets the numeric Property specifying the height of the billboard in pixels. When undefined, the native height is used.
     */
    @JsProperty
    public Property height;
    /**
     * Gets or sets the Property specifying the HeightReference.
     * Default: {@link HeightReference#NONE()}
     */
    @JsProperty
    public Property heightReference;
    /**
     * Gets or sets the Property specifying the HorizontalOrigin.
     * Default: {@link HorizontalOrigin#CENTER()}
     */
    @JsProperty
    public Property horizontalOrigin;
    /**
     * Gets or sets the Property specifying the Image, URI, or Canvas to use for the billboard.
     */
    @JsProperty
    public Property image;
    /**
     * Gets or sets the Property specifying a BoundingRectangle that defines a sub-region of the imagery to use for the billboard,
     * rather than the entire imagery, measured in pixels from the bottom-left.
     */
    @JsProperty
    public Property imageSubRegion;
    /**
     * Gets or sets the Cartesian2 Property specifying the billboard's pixel offset in screen space from the origin of
     * this billboard. This is commonly used to align multiple billboards and labels at the same position, e.g., an imagery and text.
     * The screen space origin is the top, left corner of the canvas; x increases from left to right, and y increases from top to bottom.
     * Default Value:  {@link Cartesian2#ZERO()}
     */
    @JsProperty
    public Property pixelOffset;
    /**
     * Gets or sets NearFarScalar Property specifying the pixel offset of the billboard based on the distance from the camera.
     * A billboard's pixel offset will interpolate between the NearFarScalar#nearValue and {@link org.cesiumjs.cs.core.NearFarScalar#farValue}
     * while the camera distance falls within the upper and lower bounds of the specified {@link org.cesiumjs.cs.core.NearFarScalar#near}
     * and {@link org.cesiumjs.cs.core.NearFarScalar#far}. Outside of these ranges the billboard's pixel offset remains
     * clamped to the nearest bound.
     */
    @JsProperty
    public Property pixelOffsetScaleByDistance;
    /**
     * Gets or sets the numeric Property specifying the rotation of the imagery counter clockwise from the alignedAxis.
     * Default Value: 0
     */
    @JsProperty
    public Property rotation;
    /**
     * Gets or sets the numeric Property specifying the uniform scale to apply to the imagery.
     * A scale greater than 1.0 enlarges the billboard while a scale less than 1.0 shrinks it.
     * Default: 1.0
     */
    @JsProperty
    public Property scale;
    /**
     * Gets or sets NearFarScalar Property specifying the scale of the billboard based on the distance from the camera.
     * A billboard's scale will interpolate between the NearFarScalar#nearValue and {@link org.cesiumjs.cs.core.NearFarScalar#farValue} while
     * the camera distance falls within the upper and lower bounds of the specified {@link org.cesiumjs.cs.core.NearFarScalar#near} and {@link org.cesiumjs.cs.core.NearFarScalar#far}.
     * Outside of these ranges the billboard's scale remains clamped to the nearest bound.
     */
    @JsProperty
    public Property scaleByDistance;
    /**
     * Gets or sets the boolean Property specifying the visibility of the billboard.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * Gets or sets the boolean Property specifying if this billboard's size will be measured in meters.
     * Default: false
     */
    @JsProperty
    public Property sizeInMeters;
    /**
     * Gets or sets NearFarScalar Property specifying the translucency of the billboard based on the distance from the camera.
     * A billboard's translucency will interpolate between the {@link org.cesiumjs.cs.core.NearFarScalar#nearValue} and {@link org.cesiumjs.cs.core.NearFarScalar#farValue} while
     * the camera distance falls within the upper and lower bounds of the specified {@link org.cesiumjs.cs.core.NearFarScalar#near} and {@link org.cesiumjs.cs.core.NearFarScalar#far}.
     * Outside of these ranges the billboard's translucency remains clamped to the nearest bound.
     */
    @JsProperty
    public Property translucencyByDistance;
    /**
     * Gets or sets the Property specifying the VerticalOrigin.
     * Default: {@link VerticalOrigin#CENTER()}
     */
    @JsProperty
    public Property verticalOrigin;
    /**
     * Gets or sets the numeric Property specifying the billboard's width in pixels. When undefined, the native width is used.
     */
    @JsProperty
    public Property width;

    @JsConstructor
    public BillboardGraphics() {}

    @JsConstructor
    public BillboardGraphics(BillboardGraphicsOptions options) {}

    /**
     * Duplicates this instance.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    @JsMethod
    public native BillboardGraphics clone();

    /**
     * Duplicates this instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    @JsMethod
    public native BillboardGraphics clone(BillboardGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    @JsMethod
    public native void merge(BillboardGraphics source);
}
