/*
 * Copyright 2018 iserge.
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

import com.google.gwt.typedarrays.shared.Uint8Array;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.scene.Cesium3DTileContent;
import org.cesiumjs.cs.scene.CustomShader;
import org.cesiumjs.cs.scene.PointCloudShading;
import org.cesiumjs.cs.scene.enums.ClassificationType;
import org.cesiumjs.cs.scene.enums.ColorBlendMode;
import org.cesiumjs.cs.scene.enums.SplitDirection;

/**
 * @author Serge Silaev aka iSergio
 */
// TODO: compare with official docs
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FromGltfOptions {
    /**
     * URL of gltf.
     */
    @JsProperty(name = "gltf")
    public String url;
    /**
     * Resource of gltf.
     */
    @JsProperty(name = "gltf")
    public Resource gltf;
    /**
     * Buffer of gltf.
     */
    @JsProperty(name = "gltf")
    public Uint8Array uarray;
    /**
     * JSON of gltf.
     */
    @JsProperty(name = "gltf")
    public Object gltfObj;

    /**
     * The base path that paths in the glTF JSON are relative to.
     */
    @JsProperty
    public String basePath;
    /**
     * The base path that paths in the glTF JSON are relative to.
     */
    @JsProperty(name = "basePath")
    public Resource basePathResource;
    /**
     * A uniform scale applied to this model.
     * Default: 1.0
     */
    @JsProperty
    public double scale;
    /**
     * The approximate minimum pixel size of the model regardless of zoom.
     * Default: 0.0
     */
    @JsProperty
    public double minimumPixelSize;
    /**
     * The 4x4 transformation matrix that transforms the model from model to world coordinates.
     * Default: {@link Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * Determine if textures may continue to stream in after the model is loaded.
     * Default: true
     */
    @JsProperty
    public boolean incrementallyLoadTextures;
    /**
     * When true, the glTF JSON is released once the glTF is loaded. This is is especially useful for cases like 3D Tiles, where each .gltf model is unique and caching the glTF JSON is not effective.
     * Default: false
     */
    @JsProperty
    public boolean releaseGltfJson;
    /**
     * For debugging only. Draws the bounding sphere for each draw command in the model.
     * Default: false
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
     * Whether or not to cull the model using frustum/horizon culling. If the model is part of a 3D Tiles tileset, this property will always be false, since the 3D Tiles culling system is used.
     * Default: true
     */
    @JsProperty
    public boolean cull;
    /**
     * The pass to use in the DrawCommand for the opaque portions of the model.
     * Default: {@link Pass#OPAQUE()}
     */
    @JsProperty
    public boolean opaquePass;
    /**
     * The up-axis of the glTF model.
     * Default: {@link org.cesiumjs.cs.scene.enums.Axis#Y()}
     */
    @JsProperty
    public Number upAxis;
    /**
     * The forward-axis of the glTF model.
     * Default: {@link org.cesiumjs.cs.scene.enums.Axis#Z()}
     */
    @JsProperty
    public Number forwardAxis;
    /**
     * When true, each primitive is pickable with Scene#pick.
     * Default: true
     */
    @JsProperty
    public boolean allowPicking;
    /**
     * A custom shader. This will add user-defined GLSL code to the vertex and fragment shaders. Using custom shaders with a Cesium3DTileStyle may lead to undefined behavior.
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
     * Default: true
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
     * Default: {@link org.cesiumjs.cs.scene.enums.ColorBlendMode#HIGHLIGHT()}.
     */
    @JsProperty
    public ColorBlendMode colorBlendMode;
    /**
     * Value used to determine the color strength when the colorBlendMode is MIX. A value of 0.0 results in the model's rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.
     * Default: 0.5
     */
    @JsProperty
    public Number colorBlendAmount;
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
    /**
     * Options for constructing a PointCloudShading object to control point attenuation
     * based on geometric error and lighting.
     */
    @JsProperty
    public PointCloudShading pointCloudShading;
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
    /**
     * The SplitDirection split to apply to this model.
     * Default: {@link SplitDirection#NONE()}
     */
    @JsProperty
    public Number splitDirection;
    /**
     * Whether to accurately project the model's positions in 2D. If this is true, the model will be projected accurately
     * to 2D, but it will use more memory to do so. If this is false, the model will use less memory and will still
     * render in 2D / CV mode, but its positions may be inaccurate. This disables minimumPixelSize and prevents future
     * modification to the model matrix. This also cannot be set after the model has loaded.
     * Default: false
     */
    @JsProperty
    public boolean projectTo2D;
    /**
     * Label of the feature ID set to use for picking and styling. For EXT_mesh_features, this is the feature ID's label property,
     * or "featureId_N" (where N is the index in the featureIds array) when not specified. EXT_feature_metadata did
     * not have a label field, so such feature ID sets are always labeled "featureId_N" where N is the index in the
     * list of all feature Ids, where feature ID attributes are listed before feature ID textures. If featureIdLabel is
     * an integer N, it is converted to the string "featureId_N" automatically. If both per-primitive and per-instance
     * feature IDs are present, the instance feature IDs take priority.
     */
    @JsProperty
    public String featureIdLabel;
    /**
     * Label of the instance feature ID set used for picking and styling. If instanceFeatureIdLabel is set to an
     * integer N, it is converted to the string "instanceFeatureId_N" automatically. If both per-primitive and
     * per-instance feature IDs are present, the instance feature IDs take priority.
     */
    @JsProperty
    public String instanceFeatureIdLabel;
    /**
     * Determines whether terrain, 3D Tiles or both will be classified by this model. This cannot be set after the model has loaded.
     */
    @JsProperty
    public ClassificationType classificationType;

    @JsConstructor
    public FromGltfOptions() {}

    @JsOverlay
    public static FromGltfOptions create(String gltf) {
        FromGltfOptions options = new FromGltfOptions();
        options.url = gltf;
        return options;
    }

    @JsOverlay
    public static FromGltfOptions create(Resource gltf) {
        FromGltfOptions options = new FromGltfOptions();
        options.gltf = gltf;
        return options;
    }

    @JsOverlay
    public static FromGltfOptions create(Uint8Array gltf) {
        FromGltfOptions options = new FromGltfOptions();
        options.uarray = gltf;
        return options;
    }

    @JsOverlay
    public static FromGltfOptions create(Object gltf) {
        FromGltfOptions options = new FromGltfOptions();
        options.gltfObj = gltf;
        return options;
    }
}
