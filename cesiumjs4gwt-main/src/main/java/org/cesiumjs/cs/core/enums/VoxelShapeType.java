/*
 * Copyright 2023 iSergio, Gis4Fun.
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

package org.cesiumjs.cs.core.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * An enum of voxel shapes. The shape controls how the voxel grid is mapped to 3D space.
 */
@JsType(isNative = true, namespace = "Cesium", name = "VoxelShapeType")
public class VoxelShapeType {
    /**
     * A box shape.
     */
    @JsProperty(name = "BOX")
    public static native String BOX();
    /**
     * An ellipsoid shape.
     */
    @JsProperty(name = "ELLIPSOID")
    public static native String ELLIPSOID();
    /**
     * A cylinder shape.
     */
    @JsProperty(name = "CYLINDER")
    public static native String CYLINDER();

    @JsConstructor
    private VoxelShapeType() {}
}
