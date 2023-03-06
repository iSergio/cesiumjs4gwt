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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.enums.MetadataComponentType;
import org.cesiumjs.cs.core.enums.MetadataType;
import org.cesiumjs.cs.core.enums.VoxelShapeType;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.options.VoxelProviderRequestOptions;

/**
 * Provides voxel data. Intended to be used with {@link VoxelPrimitive}. This type describes an interface and is not
 * intended to be instantiated directly.
 */
@JsType(isNative = true, namespace = "Cesium", name = "VoxelProvider")
public class VoxelProvider {
    /**
     * Gets the metadata component types. This should not be called before VoxelProvider#ready returns true.
     * @see MetadataComponentType
     */
    @JsProperty(name = "componentTypes")
    public native String[] componentTypes();
    /**
     * Gets the number of voxels per dimension of a tile. This is the same for all tiles in the dataset. This should not be called before VoxelProvider#ready returns true.
     */
    @JsProperty(name = "dimensions")
    public native Cartesian3 dimensions();
    /**
     * A transform from local space to global space. If undefined, the identity matrix will be used instead.
     */
    @JsProperty(name = "globalTransform")
    public native Matrix4 globalTransform();
    /**
     * Gets the maximum bounds. If undefined, the shape's default maximum bounds will be used instead. This should not be called before VoxelProvider#ready returns true.
     */
    @JsProperty(name = "maxBounds")
    public native Cartesian3 maxBounds();
    /**
     * The maximum number of tiles that exist for this provider. This value is used as a hint to the voxel renderer to allocate an appropriate amount of GPU memory. If this value is not known it can be undefined. This should not be called before VoxelProvider#ready returns true.
     */
    @JsProperty(name = "maximumTileCount")
    public native int maximumTileCount();
    /**
     * Gets the metadata maximum values. This should not be called before VoxelProvider#ready returns true.
     */
    @JsProperty(name = "maximumValues")
    public native double[][] maximumValues();
    /**
     * Gets the minimum bounds. If undefined, the shape's default minimum bounds will be used instead. This should not be called before VoxelProvider#ready returns true.
     */
    @JsProperty(name = "minBounds")
    public native Cartesian3 minBounds();
    /**
     * Gets the metadata minimum values. This should not be called before VoxelProvider#ready returns true.
     */
    @JsProperty(name = "minimumValues")
    public native double[][] minimumValues();
    /**
     * Gets the metadata names. This should not be called before VoxelProvider#ready returns true.
     */
    @JsProperty(name = "names")
    public native String[] names();
    /**
     * Gets the number of padding voxels after the tile. This improves rendering quality when sampling the edge of a tile, but it increases memory usage. This should not be called before VoxelProvider#ready returns true.
     */
    @JsProperty(name = "paddingAfter")
    public native Cartesian3 paddingAfter();
    /**
     * Gets the number of padding voxels before the tile. This improves rendering quality when sampling the edge of a tile, but it increases memory usage. This should not be called before VoxelProvider#ready returns true.
     */
    @JsProperty(name = "paddingBefore")
    public native Cartesian3 paddingBefore();
    /**
     * Gets a value indicating whether or not the provider is ready for use.
     */
    @JsProperty(name = "ready")
    public native boolean ready();
    /**
     * Gets the promise that will be resolved when the provider is ready for use.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<VoxelProvider, Void> readyPromise();
    /**
     * Gets the VoxelShapeType This should not be called before VoxelProvider#ready returns true.
     * @see VoxelShapeType
     */
    @JsProperty(name = "shape")
    public native String shape();
    /**
     * A transform from shape space to local space. If undefined, the identity matrix will be used instead.
     */
    @JsProperty(name = "shapeTransform")
    public native Matrix4 shapeTransform();
    /**
     * Gets the metadata types. This should not be called before VoxelProvider#ready returns true.
     * @see MetadataType
     */
    @JsProperty(name = "types")
    public native String[] types();

    @JsConstructor
    public VoxelProvider() {}

    /**
     * Requests the data for a given tile. The data is a flattened 3D array ordered by X, then Y, then Z. This function should not be called before VoxelProvider#ready returns true.
     * @param options options
     * @return A promise to an array of typed arrays containing the requested voxel data or undefined if there was a problem loading the data.
     */
    public native Promise<JsObject[][], Void> requestData(VoxelProviderRequestOptions options);
}
