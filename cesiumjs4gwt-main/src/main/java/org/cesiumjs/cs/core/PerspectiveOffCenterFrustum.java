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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PerspectiveOffCenterFrustum")
public class PerspectiveOffCenterFrustum extends Frustum {
    /**
     * Defines the bottom clipping plane. Default: undefined
     */
    @JsProperty
    public double bottom;
    /**
     * Defines the left clipping plane. Default: undefined
     */
    @JsProperty
    public double left;
    /**
     * Defines the right clipping plane. Default: undefined
     */
    @JsProperty
    public double right;
    /**
     * Defines the top clipping plane. Default: undefined
     */
    @JsProperty
    public double top;

    /**
     * The viewing frustum is defined by 6 planes. Each plane is represented by a
     * Cartesian4 object, where the x, y, and z components define the unit vector
     * normal to the plane, and the w component is the distance of the plane from
     * the origin/camera position.
     *
     * @see PerspectiveFrustum
     */
    @JsConstructor
    public PerspectiveOffCenterFrustum() {
    }

    /**
     * Gets the perspective projection matrix computed from the view frustum with an
     * infinite far plane.
     *
     * @see #projectionMatrix
     */
    @JsProperty(name = "infiniteProjectionMatrix")
    public native Matrix4 infiniteProjectionMatrix();

    /**
     * Returns a duplicate of a PerspectiveOffCenterFrustum instance.
     *
     * @return The modified result parameter or a new PerspectiveFrustum instance if
     * one was not provided.
     */
    @JsMethod
    public native PerspectiveOffCenterFrustum clone();

    /**
     * Returns a duplicate of a PerspectiveOffCenterFrustum instance.
     *
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new PerspectiveFrustum instance if
     * one was not provided.
     */
    @JsMethod
    public native PerspectiveOffCenterFrustum clone(PerspectiveOffCenterFrustum result);

    // TODO: Example

    /**
     * Creates a culling volume for this frustum.
     *
     * @param position  The eye position.
     * @param direction The view direction.
     * @param up        The up direction.
     * @return A culling volume at the given position and orientation.
     */
    @JsMethod
    public native CullingVolume computeCullingVolume(Cartesian3 position, Cartesian3 direction, Cartesian3 up);

    /**
     * Compares the provided PerspectiveOffCenterFrustum componentwise and returns
     * true if they are equal, false otherwise.
     *
     * @param other The right hand side PerspectiveOffCenterFrustum.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(PerspectiveOffCenterFrustum other);

    /**
     * Compares the provided PerspectiveOffCenterFrustum componentwise and returns
     * true if they pass an absolute or relative tolerance test, false otherwise.
     *
     * @param other           The right hand side PerspectiveOffCenterFrustum.
     * @param relativeEpsilon The relative epsilon tolerance to use for equality
     *                        testing.
     * @return true if this and other are within the provided epsilon, false
     * otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(PerspectiveOffCenterFrustum other, double relativeEpsilon);

    /**
     * Compares the provided PerspectiveOffCenterFrustum componentwise and returns
     * true if they pass an absolute or relative tolerance test, false otherwise.
     *
     * @param other           The right hand side PerspectiveOffCenterFrustum.
     * @param relativeEpsilon The relative epsilon tolerance to use for equality
     *                        testing.
     * @param absoluteEpsilon The absolute epsilon tolerance to use for equality
     *                        testing.
     * @return true if this and other are within the provided epsilon, false
     * otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(PerspectiveOffCenterFrustum other, double relativeEpsilon,
                                        double absoluteEpsilon);

    // TODO: Example

    /**
     * Returns the pixel's width and height in meters.
     *
     * @param drawingBufferWidth  The width of the drawing buffer.
     * @param drawingBufferHeight The height of the drawing buffer.
     * @param distance            The distance to the near plane in meters.
     * @param pixelRatio          The scaling factor from pixel space to coordinate
     *                            space.
     * @param result              The object onto which to store the result.
     * @return The modified result parameter or a new instance of Cartesian2 with
     * the pixel's width and height in the x and y properties, respectively.
     */
    @JsMethod
    public native Cartesian2 getPixelDimensions(double drawingBufferWidth, double drawingBufferHeight, double distance,
                                                double pixelRatio, Cartesian2 result);
}