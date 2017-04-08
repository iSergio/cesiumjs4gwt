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
import org.cesiumjs.cs.scene.Camera;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CameraFlyToOptions {
    /**
     * The final position of the camera in WGS84 (world) coordinates or a rectangle that would be visible from a top-down view.
     */
    @JsProperty(name = "destination")
    public Cartesian3 destinationPos;
    /**
     * The final position of the camera in WGS84 (world) coordinates or a rectangle that would be visible from a top-down view.
     */
    @JsProperty(name = "destination")
    public Rectangle destinationRec;
    /**
     * An object that contains either direction and up properties or heading, pith and roll properties. By default, the direction will point towards the center of the frame in 3D and in the negative z direction in Columbus view. The up direction will point towards local north in 3D and in the positive y direction in Columbus view. Orientation is not used in 2D when in infinite scrolling mode.
     */
    @JsProperty
    public HeadingPitchRoll orientation;
    /**
     * The duration of the flight in seconds.
     * If omitted, Cesium attempts to calculate an ideal duration based on the distance to be traveled by the flight.
     */
    @JsProperty
    public double duration;
    /**
     * The function to execute when the flight is complete.
     */
    @JsProperty
    public Camera.FlightCompleteCallback complete;
    /**
     * The function to execute if the flight is cancelled.
     */
    @JsProperty
    public Camera.FlightCancelledCallback cancel;
    /**
     * Transform matrix representing the reference frame the camera will be in when the flight is completed.
     */
    @JsProperty
    public Matrix4 endTransform;
    /**
     * The maximum height at the peak of the flight.
     */
    @JsProperty
    public double maximumHeight;
    /**
     * If camera flyes higher than that value, adjust pitch duiring the flight to look down, and keep Earth in viewport.
     */
    @JsProperty
    public double pitchAdjustHeight;
    /**
     * There are always two ways between 2 points on globe.
     * This option force camera to choose fight direction to fly over that longitude.
     */
    @JsProperty
    public double flyOverLongitude;
    /**
     * Fly over the lon specifyed via flyOverLongitude only if that way is not longer than short way times flyOverLongitudeWeight.
     */
    @JsProperty
    public double flyOverLongitudeWeight;
    /**
     * Controls how the time is interpolated over the duration of the flight.
     */
    @JsProperty
    public EasingFunction easingFunction;
    /**
     * Controls how the time is interpolated over the duration of the flight.
     */
    @JsProperty(name = "easingFunction")
    public EasingFunction.Callback easingFunctionCallback;
    /**
     * The offset from the target in the local east-north-up reference frame centered at the target.
     */
    @JsProperty
    public HeadingPitchRange offset;

    @JsConstructor
    public CameraFlyToOptions() {}
}
