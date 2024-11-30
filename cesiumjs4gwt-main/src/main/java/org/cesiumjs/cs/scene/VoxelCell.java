/*
 * Copyright 2024 iSergio, Gis4Fun.
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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.OrientedBoundingBox;
import org.cesiumjs.cs.js.JsObject;

/**
 * Provides access to properties associated with one cell of a voxel primitive.
 * Do not construct this directly. Access it through picking using {@link Scene#pickVoxel}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "VoxelCell")
public class VoxelCell {
    /**
     * Get a copy of the oriented bounding box containing the cell.
     */
    @JsProperty(name = "orientedBoundingBox")
    public native OrientedBoundingBox orientedBoundingBox();

    /**
     * All objects returned by Scene#pick have a primitive property. This returns the VoxelPrimitive containing the cell.
     */
    @JsProperty(name = "primitive")
    public native VoxelPrimitive primitive();

    /**
     * Get the sample index of the cell.
     */
    @JsProperty(name = "sampleIndex")
    public native Number sampleIndex();

    /**
     * Get the index of the tile containing the cell.
     */
    @JsProperty(name = "tileIndex")
    public native Number tileIndex();

    /**
     * Returns an array of metadata property names for the feature.
     * @return The IDs of the feature's properties.
     */
    @JsMethod
    public native String[] getNames();

    /**
     * Returns a copy of the value of the metadata in the cell with the given name.
     * @param name The case-sensitive name of the property.
     * @return The value of the property or undefined if the feature does not have this property.
     */
    @JsMethod
    public native JsObject getProperty(String name);

    /**
     * Returns true if the feature contains this property.
     * @param name The case-sensitive name of the property.
     * @return Whether the feature contains this property.
     */
    @JsMethod
    public native boolean hasProperty(String name);
}
