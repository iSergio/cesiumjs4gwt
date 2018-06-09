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
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.HeadingPitchRoll;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Rectangle;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ViewOptions {
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
     * An object that contains either direction and up properties or heading, pith and roll properties.
     * By default, the direction will point towards the center of the frame in 3D and in the negative z direction in Columbus view.
     * The up direction will point towards local north in 3D and in the positive y direction in Columbus view.
     * Orientation is not used in 2D when in infinite scrolling mode.
     */
    @JsProperty
    public HeadingPitchRoll orientation;
    /**
     * Transform matrix representing the reference frame of the camera.
     */
    @JsProperty
    public Matrix4 endTransform;

    @JsConstructor
    public ViewOptions() {}
}
