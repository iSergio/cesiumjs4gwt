/*
 * Copyright 2021 iserge, Gis4Fun.
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

package org.cesiumjs.cs.scene.experimental.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.ClippingPlaneCollection;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.scene.Cesium3DTileContent;
import org.cesiumjs.cs.scene.ImageBasedLighting;
import org.cesiumjs.cs.scene.PointCloudShading;
import org.cesiumjs.cs.scene.enums.HeightReference;
import org.cesiumjs.cs.scene.enums.ShadowMode;
import org.cesiumjs.cs.scene.experimental.CustomShader;
import org.cesiumjs.cs.scene.enums.ColorBlendMode;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ModelExperimentalOptions {
    /**
     * The Resource to the 3D model.
     */
    @JsProperty
    public Resource resource;
    /**
     * The 4x4 transformation matrix that transforms the model from model to world coordinates.
     * Default: {@link Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * A uniform scale applied to this model.
     * Default: 1.0
     */
    @JsProperty
    public double scale;
    /**
     * The approximate minimum pixel size of the model regardless of zoom.
     * Default: 0
     */
    @JsProperty
    public double minimumPixelSize;
    /**
     * The maximum scale size of a model. An upper limit for minimumPixelSize.
     */
    @JsProperty
    public double maximumScale;
    /**
     * For debugging only. Draws the bounding sphere for each draw command in the model.
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     * Draws the model in wireframe.
     *
     * Default: false
     */
    @JsProperty
    public boolean debugWireframe;
    /**
     * Whether or not to cull the model using frustum/horizon culling. If the model is part of a 3D Tiles tileset,
     * this property will always be false, since the 3D Tiles culling system is used.
     */
    @JsProperty
    public boolean cull;
    /**
     * The pass to use in the DrawCommand for the opaque portions of the model.
     * Default: Pass.OPAQUE
     */
    @JsProperty
    public boolean opaquePass;
    /**
     * When true, each primitive is pickable with {@link org.cesiumjs.cs.scene.Scene#pick}.
     */
    @JsProperty
    public boolean allowPicking;
    /**
     * A custom shader. This will add user-defined GLSL code to the vertex and fragment shaders. Using custom shaders
     * with a Cesium3DTileStyle may lead to undefined behavior.
     */
    @JsProperty
    public CustomShader customShader;
    /**
     * The tile content this model belongs to. This property will be undefined if model is not loaded as part of a tileset.
     */
    @JsProperty
    public Cesium3DTileContent content;
    /**
     * Determines how the model is drawn relative to terrain.
     * Default: {@link HeightReference#NONE()}
     */
    @JsProperty
    public HeightReference heightReference;
    /**
     * Whether or not to render the model.
     */
    @JsProperty
    public boolean show;
    /**
     * A color that blends with the model's rendered color.
     */
    @JsProperty
    public Color color;
    /**
     * Defines how the color blends with the model.
     * Default: {@link ColorBlendMode#HIGHLIGHT()}
     */
    @JsProperty
    public ColorBlendMode colorBlendMode;
    /**
     * Value used to determine the color strength when the colorBlendMode is MIX. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.
     * Default : 0.5
     */
    @JsProperty
    public double colorBlendAmount;
    /**
     * The index into the list of primitive feature IDs used for picking and styling. For EXT_feature_metadata,
     * feature ID attributes are listed before feature ID textures. If both per-primitive and per-instance feature
     * IDs are present, the instance feature IDs take priority.
     *
     * Default: 0
     */
    @JsProperty
    public double featureIdLabel;
    /**
     * The index into the list of instance feature IDs used for picking and styling. If both per-primitive and
     * per-instance feature IDs are present, the instance feature IDs take priority.
     *
     * Default: 0
     */
    @JsProperty
    public double instanceFeatureIdLabel;
    /**
     * Options for constructing a PointCloudShading object to control point attenuation
     * based on geometric error and lighting.
     */
    @JsProperty
    public PointCloudShading pointCloudShading;
    /**
     * The ClippingPlaneCollection used to selectively disable rendering the model.
     */
    @JsProperty
    public ClippingPlaneCollection clippingPlanes;
    /**
     * The light color when shading the model. When undefined the scene's light color is used instead.
     */
    @JsProperty
    public Cartesian3 lightColor;
    /**
     * The properties for managing image-based lighting on this model.
     */
    @JsProperty
    public ImageBasedLighting imageBasedLighting;
    /**
     * Whether to cull back-facing geometry. When true, back face culling is determined by the material's doubleSided
     * property; when false, back face culling is disabled. Back faces are not culled if the model's color is translucent.
     */
    @JsProperty
    public boolean backFaceCulling;
    /**
     * Determines whether the model casts or receives shadows from light sources.
     * Default: {@link org.cesiumjs.cs.scene.enums.ShadowMode#ENABLED()}
     */
    @JsProperty
    public Number shadows;
    /**
     * Whether to display the credits of this model on screen
     * Default: false
     */
    @JsProperty
    public boolean showCreditsOnScreen;

    @JsConstructor
    private ModelExperimentalOptions() {}

    @JsOverlay
    public static ModelExperimentalOptions create(Resource resource) {
        ModelExperimentalOptions options = new ModelExperimentalOptions();
        options.resource = resource;
        return options;
    }
}
