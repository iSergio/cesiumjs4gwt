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

/**
 * The viewing frustum is defined by 6 planes. Each plane is represented by a {@link org.cesiumjs.cs.core.Cartesian4} object,
 * where the x, y, and z components define the unit vector normal to the plane, and the w component is the
 * distance of the plane from the origin/camera position.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "OrthographicOffCenterFrustum")
public class OrthographicOffCenterFrustum implements Frustum {
    /**
     * The bottom clipping plane.
     * Default Value:  undefined
     */
    @JsProperty
    public double bottom;
    /**
     * The distance of the far plane.
     * Default Value:  500000000.0;
     */
    @JsProperty
    public double far;
    /**
     * The left clipping plane.
     * Default Value:  undefined
     */
    @JsProperty
    public double left;
    /**
     * The distance of the near plane.
     * Default Value:  1.0
     */
    @JsProperty
    public double near;
    /**
     * Gets the orthographic projection matrix computed from the view frustum.
     */
    @JsProperty(name = "projectionMatrix")
    public native Matrix4 projectionMatrix();
    /**
     * The right clipping plane.
     * Default Value:  undefined
     */
    @JsProperty
    public double right;
    /**
     * The top clipping plane.
     * Default Value:  undefined
     */
    @JsProperty
    public double top;

    @JsConstructor
    public OrthographicOffCenterFrustum() {}

    /**
     * Returns a duplicate of a OrthographicOffCenterFrustum instance.
     * @return The modified result parameter or a new OrthographicOffCenterFrustum instance if one was not provided.
     */
    @JsMethod
    public native org.cesiumjs.cs.scene.OrthographicOffCenterFrustum clone();

    /**
     * Returns a duplicate of a OrthographicOffCenterFrustum instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new OrthographicOffCenterFrustum instance if one was not provided.
     */
    @JsMethod
    public native org.cesiumjs.cs.scene.OrthographicOffCenterFrustum clone(org.cesiumjs.cs.scene.OrthographicOffCenterFrustum result);

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
     * Compares the provided OrthographicOffCenterFrustum componentwise and returns true if they are equal, false otherwise.
     * @param other The right hand side OrthographicOffCenterFrustum.
     * @return  true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(org.cesiumjs.cs.scene.OrthographicOffCenterFrustum other);

    /**
     * Returns the pixel's width and height in meters.
     * @param drawingBufferWidth The width of the drawing buffer.
     * @param drawingBufferHeight The height of the drawing buffer.
     * @param distance The distance to the near plane in meters.
     * @return The modified result parameter or a new instance of Cartesian2 with the pixel's
     * width and height in the x and y properties, respectively.
     */
    @JsMethod
    public native Cartesian2 getPixelDimensions(double drawingBufferWidth, double drawingBufferHeight, double distance);

    /**
     * Returns the pixel's width and height in meters.
     * @param drawingBufferWidth The width of the drawing buffer.
     * @param drawingBufferHeight The height of the drawing buffer.
     * @param distance The distance to the near plane in meters.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance of Cartesian2 with the pixel's
     * width and height in the x and y properties, respectively.
     */
    @JsMethod
    public native Cartesian2 getPixelDimensions(double drawingBufferWidth, double drawingBufferHeight, double distance, Cartesian2 result);
}