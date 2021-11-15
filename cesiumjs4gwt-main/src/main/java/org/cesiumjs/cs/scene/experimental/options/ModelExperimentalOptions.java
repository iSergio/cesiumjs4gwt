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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.scene.Cesium3DTileContent;
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
     * For debugging only. Draws the bounding sphere for each draw command in the model.
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
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
     * The index of the feature ID attribute to use for picking features per-instance or per-primitive.
     * Default: 0
     */
    @JsProperty
    public Number featureIdAttributeIndex;
    /**
     * The index of the feature ID texture to use for picking features per-primitive.
     * Default: 0
     */
    @JsProperty
    public Number featureIdTextureIndex;

    @JsConstructor
    private ModelExperimentalOptions() {}

    public static ModelExperimentalOptions create(Resource resource) {
        ModelExperimentalOptions options = new ModelExperimentalOptions();
        options.resource = resource;
        return options;
    }
}
