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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.CullingVolume;
import org.cesiumjs.cs.scene.PerspectiveFrustum;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PerspectiveOffCenterFrustum")
public class PerspectiveOffCenterFrustum implements Frustum {
    /**
     * Defines the bottom clipping plane.
     * Default: undefined
     */
    @JsProperty
    public double bottom;
    /**
     * The distance of the far plane.
     * Default: 500000000.0
     */
    @JsProperty
    public double far;
    /**
     * Gets the perspective projection matrix computed from the view frustum with an infinite far plane.
     * @see #projectionMatrix
     */
    @JsProperty(name = "infiniteProjectionMatrix")
    public native Matrix4 infiniteProjectionMatrix();
    /**
     * Defines the left clipping plane.
     * Default: undefined
     */
    @JsProperty
    public double left;
    /**
     * The distance of the near plane.
     * Default: 1.0
     */
    @JsProperty
    public double near;
    /**
     * Gets the perspective projection matrix computed from the view frustum.
     * @see #infiniteProjectionMatrix()
     */
    @JsProperty(name = "projectionMatrix")
    public native Matrix4 projectionMatrix();
    /**
     * Defines the right clipping plane.
     * Default: undefined
     */
    @JsProperty
    public double right;
    /**
     * Defines the top clipping plane.
     * Default: undefined
     */
    @JsProperty
    public double top;

    /**
     * The viewing frustum is defined by 6 planes. Each plane is represented by a Cartesian4 object, where the x, y, and z
     * components define the unit vector normal to the plane, and the w component is the
     * distance of the plane from the origin/camera position.
     * @see PerspectiveFrustum
     */
    @JsConstructor
    public PerspectiveOffCenterFrustum() {}

    /**
     * Returns a duplicate of a PerspectiveOffCenterFrustum instance.
     * @return The modified result parameter or a new PerspectiveFrustum instance if one was not provided.
     */
    @JsMethod
    public native org.cesiumjs.cs.scene.PerspectiveOffCenterFrustum clone();

    /**
     * Returns a duplicate of a PerspectiveOffCenterFrustum instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new PerspectiveFrustum instance if one was not provided.
     */
    @JsMethod
    public native org.cesiumjs.cs.scene.PerspectiveOffCenterFrustum clone(org.cesiumjs.cs.scene.PerspectiveOffCenterFrustum result);

    //TODO: Example
    /**
     * Creates a culling volume for this frustum.
     * @param position The eye position.
     * @param direction The view direction.
     * @param up The up direction.
     * @return A culling volume at the given position and orientation.
     */
    @JsMethod
    public native CullingVolume computeCullingVolume(Cartesian3 position, Cartesian3 direction, Cartesian3 up);

    /**
     * Compares the provided PerspectiveOffCenterFrustum componentwise and returns true if they are equal, false otherwise.
     * @param other The right hand side PerspectiveOffCenterFrustum.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(org.cesiumjs.cs.scene.PerspectiveOffCenterFrustum other);

    //TODO: Example
    /**
     * Returns the pixel's width and height in meters.
     * @param drawingBufferWidth The width of the drawing buffer.
     * @param drawingBufferHeight The height of the drawing buffer.
     * @param distance The distance to the near plane in meters.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance of Cartesian2 with the pixel's width and height in the x and y properties, respectively.
     */
    @JsMethod
    public native Cartesian2 getPixelDimensions(double drawingBufferWidth, double drawingBufferHeight, double distance, Cartesian2 result);
}