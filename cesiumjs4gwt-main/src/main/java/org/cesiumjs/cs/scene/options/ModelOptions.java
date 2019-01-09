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

import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.typedarrays.shared.Uint8Array;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.ClippingPlaneCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.scene.Scene;

/**
 * Options for {@link org.cesiumjs.cs.scene.Model}.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ModelOptions {
    /**
     * The object for the glTF JSON or an arraybuffer of Binary glTF defined by the KHR_binary_glTF extension.
     */
    @JsProperty
    public Object gltf;
    /**
     * The object for the glTF JSON or an arraybuffer of Binary glTF defined by the KHR_binary_glTF extension.
     */
    @JsProperty
    public ArrayBuffer gltfArrayBuffer;
    /**
     * The object for the glTF JSON or an arraybuffer of Binary glTF defined by the KHR_binary_glTF extension.
     */
    @JsProperty
    public Uint8Array gltfUint8Array;
    /**
     * The base path that paths in the glTF JSON are relative to.
     * Default: empty.
     */
    @JsProperty
    public String basePath;
    /**
     * Determines if the model primitive will be shown.
     * Default: true.
     */
    @JsProperty
    public boolean show;
    /**
     * The 4x4 transformation matrix that transforms the model from model to world coordinates.
     * Default: {@link Matrix4#IDENTITY()}.
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * A uniform scale applied to this model.
     * Default: 1.0.
     */
    @JsProperty
    public double scale;
    /**
     * The approximate minimum pixel size of the model regardless of zoom.
     * DEfault: 0.0.
     */
    @JsProperty
    public double minimumPixelSize;
    /**
     * The maximum scale size of a model. An upper limit for minimumPixelSize.
     */
    @JsProperty
    public double maximumScale;
    /**
     * A user-defined object to return when the model is picked with Scene#pick.
     */
    @JsProperty
    public Object id;
    /**
     * When true, each glTF mesh and primitive is pickable with {@link org.cesiumjs.cs.scene.Scene#pick}
     * Default: true.
     */
    @JsProperty
    public boolean allowPicking;
    /**
     * Determine if textures may continue to stream in after the model is loaded.
     * Default: true.
     */
    @JsProperty
    public boolean incrementallyLoadTextures;
    /**
     * Determines if model WebGL resource creation will be spread out over several frames or block until completion once all glTF files are loaded.
     * Default: true.
     */
    @JsProperty
    public boolean asynchronous;
    /**
     * Determines if the model's animations should hold a pose over frames where no keyframes are specified.
     * Default: true
     */
    @JsProperty
    boolean clampAnimations;
    /**
     * Determines whether the model casts or receives shadows from each light source.
     * Default: {@link org.cesiumjs.cs.scene.enums.ShadowMode#ENABLED()}.
     */
    @JsProperty
    public Number shadows;
    /**
     * For debugging only. Draws the bounding sphere for each draw command in the model.
     * Default: false.
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * For debugging only. Draws the model in wireframe.
     * Default: false.
     */
    @JsProperty
    public boolean debugWireframe;
    /**
     * Determines how the model is drawn relative to terrain. {@link org.cesiumjs.cs.scene.enums.HeightReference}.
     */
    @JsProperty
    public Number heightReference;
    /**
     * Must be passed in for models that use the height reference property.
     */
    @JsProperty
    public Scene scene;
    /**
     * The condition specifying at what distance from the camera that this model will be displayed.
     */
    @JsProperty
    public DistanceDisplayCondition distanceDisplayCondition;
    /**
     * A color that blends with the model's rendered color.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}.
     */
    @JsProperty
    public Color color;
    /**
     * Defines how the color blends with the model.
     * Default: {@link org.cesiumjs.cs.scene.enums.ColorBlendMode#HIGHLIGHT()}.
     */
    @JsProperty
    public Number colorBlendMode;
    /**
     * Value used to determine the color strength when the colorBlendMode is MIX. A value of 0.0 results in the model's
     * rendered color while a value of 1.0 results in a solid color, with any value in-between resulting in a mix of the two.
     * Default: 0.5.
     */
    @JsProperty
    public double colorBlendAmount;
    /**
     * The silhouette color. If more than 256 models have silhouettes enabled, there is a small chance that overlapping
     * models will have minor artifacts.
     * Default: {@link Color#RED()}.
     */
    @JsProperty
    public Color silhouetteColor;
    /**
     * The size of the silhouette in pixels.
     * Default: 0.0.
     */
    @JsProperty
    public double silhouetteSize;
    /**
     * The ClippingPlaneCollection used to selectively disable rendering the model.
     * Clipping planes are not currently supported in Internet Explorer.
     */
    @JsProperty
    public ClippingPlaneCollection clippingPlanes;
    /**
     * Determines if a Draco encoded model is dequantized on the GPU. This decreases total memory usage for encoded models.
     * Default: true
     */
    @JsProperty
    public boolean dequantizeInShader;
    /**
     * Scales diffuse and specular image-based lighting from the earth, sky, atmosphere and star skybox.
     * Default: new Cartesian2(1.0, 1.0)
     */
    @JsProperty
    public Cartesian2 imageBasedLightingFactor;
    /**
     * The color and intensity of the sunlight used to shade the model.
     */
    @JsProperty
    public Cartesian3 lightColor;
    /**
     * The sun's luminance at the zenith in kilo candela per meter squared to use for this model's procedural environment map.
     * Default: 0.5
     */
    @JsProperty
    public double luminanceAtZenith;
    /**
     * The third order spherical harmonic coefficients used for the diffuse color of image-based lighting.
     */
    @JsProperty
    public Cartesian3[] sphericalHarmonicCoefficients;
    /**
     * A URL to a KTX file that contains a cube map of the specular lighting and the convoluted specular mipmaps.
     */
    @JsProperty
    public String specularEnvironmentMaps;

    @JsConstructor
    public  ModelOptions() {}
}
