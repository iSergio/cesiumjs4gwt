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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Clock;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.scene.CustomShader;
import org.cesiumjs.cs.scene.VoxelProvider;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class VoxelPrimitiveOptions {
    /**
     * The voxel provider that supplies the primitive with tile data.
     */
    @JsProperty
    public VoxelProvider provider;
    /**
     * The model matrix used to transform the primitive.
     * Default: {@link Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * The custom shader used to style the primitive.
     */
    @JsProperty
    public CustomShader customShader;
    /**
     * The clock used to control time dynamic behavior.
     */
    @JsProperty
    public Clock clock;
}
