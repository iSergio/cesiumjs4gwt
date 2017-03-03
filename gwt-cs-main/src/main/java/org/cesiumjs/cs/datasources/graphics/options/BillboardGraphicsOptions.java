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
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.datasources.properties.Property;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class BillboardGraphicsOptions {
    /**
     * Property specifying the Image, URI, or Canvas to use for the billboard.
     */
    @JsProperty
    public Property image;
    /**
     * A boolean Property specifying the visibility of the billboard.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A numeric Property specifying the scale to apply to the imagery size.
     * Default: 1.0
     */
    @JsProperty
    public Property scale;
    /**
     * A Property specifying the HorizontalOrigin.
     * Default: {@link HorizontalOrigin#CENTER()}
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
     * Default: {@link Cartesian3#ZERO()}
     */
    @JsProperty
    public Property eyeOffset;
    /**
     * A Cartesian2 Property specifying the pixel offset.
     * Default: {@link Cartesian2#ZERO()}
     */
    @JsProperty
    public Property pixelOffset;
    /**
     * Property specifying the rotation about the alignedAxis.
     * Default: 0
     */
    @JsProperty
    public Property rotation;
    /**
     * A Cartesian3 Property specifying the unit vector axis of rotation.
     * Default: {@link Cartesian3#ZERO()}
     */
    @JsProperty
    public Property alignedAxis;
    /**
     * A numeric Property specifying the width of the billboard in pixels, overriding the native size.
     */
    @JsProperty
    public Property width;
    /**
     * specifying the height of the billboard in pixels, overriding the native size.
     */
    @JsProperty
    public Property height;
    /**
     * A Property specifying the tint Color of the imagery.
     * Default: {@link Color#WHITE()}
     */
    @JsProperty
    public Property color;
    /**
     * A NearFarScalar Property used to scale the point based on distance from the camera.
     */
    @JsProperty
    public Property scaleByDistance;
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
     * A Property specifying a BoundingRectangle that defines a sub-region of the imagery to use for the billboard,
     * rather than the entire imagery, measured in pixels from the bottom-left.
     */
    @JsProperty
    public Property imageSubRegion;
    /**
     * A boolean Property specifying whether this billboard's size should be measured in meters.
     */
    @JsProperty
    public Property sizeInMeters;
    /**
     * A Property specifying what the height is relative to.
     * Default: {@link HeightReference#NONE()}
     */
    @JsProperty
    public Property heightReference;
    /**
     * A Property specifying at what distance from the camera that this billboard will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;

    @JsConstructor
    public BillboardGraphicsOptions() {}
}
