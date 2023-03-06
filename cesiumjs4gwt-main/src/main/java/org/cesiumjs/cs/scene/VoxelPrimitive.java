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
import org.cesiumjs.cs.collections.ClippingPlaneCollection;
import org.cesiumjs.cs.core.BoundingSphere;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.OrientedBoundingBox;
import org.cesiumjs.cs.core.enums.VoxelShapeType;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.options.VoxelPrimitiveOptions;

/**
 * A primitive that renders voxel data from a {@link VoxelProvider}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "VoxelPrimitive")
public class VoxelPrimitive {
    /**
     * Gets the bounding sphere.
     */
    @JsProperty(name = "boundingSphere")
    public native BoundingSphere boundingSphere();

    /**
     * The ClippingPlaneCollection used to selectively disable rendering the primitive.
     */
    @JsProperty
    public ClippingPlaneCollection clippingPlanes;

    /**
     * Gets or sets the custom shader. If undefined, VoxelPrimitive.DefaultCustomShader is set.
     */
    @JsProperty
    public CustomShader customShader;

    /**
     * Gets an event that is raised whenever a custom shader is compiled.
     */
    @JsProperty(name = "customShaderCompilationEvent")
    public native Event customShaderCompilationEvent();

    /**
     * Gets or sets whether or not to render debug visualizations.
     */
    @JsProperty
    public boolean debugDraw;

    /**
     * Gets or sets whether or not to test against depth when rendering.
     */
    @JsProperty
    public boolean depthTest;

    /**
     * Gets the voxel dimensions.
     */
    @JsProperty(name = "dimensions")
    public native Cartesian3 dimensions();

    /**
     * Gets or sets whether or not the primitive should update when the view changes.
     */
    @JsProperty
    public boolean disableUpdate;

    /**
     * Gets or sets whether or not to jitter the view ray during the raymarch.
     * This reduces stair-step artifacts but introduces noise.
     */
    @JsProperty
    public boolean jitter;

    /**
     * Gets or sets the maximum bounds in the shape's local coordinate system. Voxel data is stretched or squashed to fit the bounds.
     */
    @JsProperty
    public Cartesian3 maxBounds;

    /**
     * Gets or sets the maximum clipping location in the shape's local coordinate system. Any voxel content outside the range is clipped.
     */
    @JsProperty
    public Cartesian3 maxClippingBounds;


    /**
     * Gets the maximum value per channel of the voxel data.
     */
    @JsProperty(name = "maximumValues")
    public native Number[] maximumValues();

    /**
     * Gets or sets the minimum bounds in the shape's local coordinate system. Voxel data is stretched or squashed to fit the bounds.
     */
    @JsProperty
    public Cartesian3 minBounds;

    /**
     * Gets or sets the minimum clipping location in the shape's local coordinate system. Any voxel content outside the range is clipped.
     */
    @JsProperty
    public Cartesian3 minClippingBounds;

    /**
     * Gets the minimum value per channel of the voxel data.
     */
    @JsProperty(name = "minimumValues")
    public native Number[] minimumValues();

    /**
     * Gets the model matrix.
     */
    @JsProperty(name = "modelMatrix")
    public native Matrix4 modelMatrix();

    /**
     * Gets or sets the nearest sampling.
     */
    @JsProperty
    public boolean nearestSampling;

    /**
     * Gets the oriented bounding box.
     */
    @JsProperty(name = "orientedBoundingBox")
    public native OrientedBoundingBox orientedBoundingBox();

    /**
     * Gets the VoxelProvider associated with this primitive.
     */
    @JsProperty(name = "provider")
    public native VoxelProvider provider();

    /**
     * Gets a value indicating whether or not the primitive is ready for use.
     */
    @JsProperty(name = "ready")
    public native boolean ready();

    /**
     * Gets the promise that will be resolved when the primitive is ready for use.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<VoxelPrimitive, Void> readyPromise();

    /**
     * Gets or sets the screen space error in pixels. If the screen space size of a voxel is greater than the screen
     * space error, the tile is subdivided. Lower screen space error corresponds with higher detail rendering,
     * but could result in worse performance and higher memory consumption.
     */
    @JsProperty
    public double screenSpaceError;

    /**
     * Gets the shape type.
     */
    @JsProperty
    public VoxelShapeType shape;

    /**
     * Gets or sets whether or not this primitive should be displayed.
     */
    @JsProperty
    public boolean show;

    /**
     * Gets or sets the step size multiplier used during raymarching. The lower the value, the higher the rendering quality,
     * but also the worse the performance.
     */
    @JsProperty
    public double stepSize;

    @JsConstructor
    public VoxelPrimitive() {}
    @JsConstructor
    public VoxelPrimitive(VoxelPrimitiveOptions options) {}
}
