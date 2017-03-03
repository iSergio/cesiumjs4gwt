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
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.PickedObject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DebugModelMatrixPrimitiveOptions {
    /**
     * The length of the axes in meters.
     * Default: 10000000.0
     */
    @JsProperty
    public double length;
    /**
     * The width of the axes in pixels.
     * Default: 2.0
     */
    @JsProperty
    public double width;
    /**
     * The 4x4 matrix that defines the reference frame, i.e., origin plus axes, to visualize.
     * Default: {@link Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * Determines if this primitive will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * A user-defined object to return when the instance is picked with {@link org.cesiumjs.cs.scene.Scene#pick(Cartesian2)}
     */
    @JsProperty
    public PickedObject id;

    /**
     * Options for {@link org.cesiumjs.cs.scene.DebugModelMatrixPrimitive}
     */
    @JsConstructor
    public DebugModelMatrixPrimitiveOptions() {}
}
