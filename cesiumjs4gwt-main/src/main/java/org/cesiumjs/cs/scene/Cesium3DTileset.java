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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.ClippingPlaneCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.enums.Cesium3DTileColorBlendMode;
import org.cesiumjs.cs.scene.enums.ClassificationType;
import org.cesiumjs.cs.scene.enums.SplitDirection;
import org.cesiumjs.cs.scene.options.Cesium3DTilesetOptions;

/**
 * A <a href=
 * "https://github.com/AnalyticalGraphicsInc/3d-tiles/blob/master/README.md">3D
 * Tiles tileset</a>, used for streaming massive heterogeneous 3D geospatial
 * datasets.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cesium3DTileset")
public class Cesium3DTileset {
    /**
     * The event fired to indicate that all tiles that meet the screen space error
     * this frame are loaded. The tileset is completely loaded for this view. This
     * event is fired at the end of the frame after the scene is rendered. Default:
     * new Event()
     */
    @JsProperty
    public Event allTilesLoaded;
    /**
     * Whether to cull back-facing geometry. When true, back face culling is
     * determined by the glTF material's doubleSided property; when false, back face
     * culling is disabled. Default: true
     */
    @JsProperty
    public boolean backFaceCulling;
    /**
     * The screen space error that must be reached before skipping levels of detail.
     * Only used when {@link Cesium3DTileset#skipLevelOfDetail} is true. Default:
     * 1024
     */
    @JsProperty
    public double baseScreenSpaceError;
    /**
     * Label of the feature ID set to use for picking and styling.
     * For EXT_mesh_features, this is the feature ID's label property, or "featureId_N" (where N is the index in the
     * featureIds array) when not specified. EXT_feature_metadata did not have a label field, so such feature ID sets
     * are always labeled "featureId_N" where N is the index in the list of all feature Ids, where feature ID attributes
     * are listed before feature ID textures.
     * <p>
     * If featureIdLabel is set to an integer N, it is converted to the string "featureId_N" automatically. If both
     * per-primitive and per-instance feature IDs are present, the instance feature IDs take priority.
     */
    @JsProperty
    public int featureIdLabel;
    /**
     * Optimization option. Used when
     * {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedScreenSpaceError} is
     * true to control the cone size that determines which tiles are deferred. Tiles
     * that are inside this cone are loaded immediately. Tiles outside the cone are
     * potentially deferred based on how far outside the cone they are and their
     * screen space error. This is controlled by
     * {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedInterpolationCallback}
     * and
     * {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedMinimumScreenSpaceErrorRelaxation}.
     * Setting this to 0.0 means the cone will be the line formed by the camera
     * position and its view direction. Setting this to 1.0 means the cone
     * encompasses the entire field of view of the camera, disabling the effect.
     * Default: 0.1
     */
    @JsProperty
    public double foveatedConeSize;
    /**
     * Optimization option. Used when
     * {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedScreenSpaceError} is
     * true to control the starting screen space error relaxation for tiles outside
     * the foveated cone. The screen space error will be raised starting with
     * tileset value up to
     * {@link org.cesiumjs.cs.scene.Cesium3DTileset#maximumScreenSpaceError} based
     * on the provided
     * {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedInterpolationCallback}.
     * Default: 0.0
     */
    @JsProperty
    public double foveatedMinimumScreenSpaceErrorRelaxation;
    /**
     * Optimization option. Used when
     * {@link Cesium3DTileset#foveatedScreenSpaceError} is true to control how much
     * to raise the screen space error for tiles outside the foveated cone,
     * interpolating between
     * {@link Cesium3DTileset#foveatedMinimumScreenSpaceErrorRelaxation} and
     * {@link Cesium3DTileset#maximumScreenSpaceError}
     */
    @JsProperty
    public FoveatedInterpolationCallback foveatedInterpolationCallback;
    /**
     * The {@link ClippingPlaneCollection} used to selectively disable rendering the
     * tileset. Clipping planes are not currently supported in Internet Explorer.
     */
    @JsProperty
    public ClippingPlaneCollection clippingPlanes;
    /**
     * Defines the value used to linearly interpolate between the source color and
     * feature color when the {@link Cesium3DTileset#colorBlendMode} is MIX. A value
     * of 0.0 results in the source color while a value of 1.0 results in the
     * feature color, with any value in-between resulting in a mix of the source
     * color and feature color. Default: 0.5
     */
    @JsProperty
    public double colorBlendAmount;
    /**
     * Defines how per-feature colors set from the Cesium API or declarative styling
     * blend with the source colors from the original feature, e.g. glTF material or
     * per-point color in the tile.
     *
     * @see Cesium3DTileColorBlendMode Default:
     * {@link Cesium3DTileColorBlendMode#HIGHLIGHT()}
     */
    @JsProperty
    public Number colorBlendMode;
    /**
     * Don't request tiles that will likely be unused when they come back because of
     * the camera's movement. Default: true
     */
    @JsProperty
    public boolean cullRequestsWhileMoving;
    /**
     * Multiplier used in culling requests while moving. Larger is more aggressive
     * culling, smaller less aggressive culling. Defaule: 60.0
     */
    @JsProperty
    public double cullRequestsWhileMovingMultiplier;
    /**
     * A custom shader to apply to all tiles in the tileset. Only used for contents that use ModelExperimental. Using
     * custom shaders with a Cesium3DTileStyle may lead to undefined behavior.
     * To enable ModelExperimental, set ExperimentalFeatures.enableModelExperimental to true.
     *
     * Default: undefined
     */
    @JsProperty
    public CustomShader customShader;
    /**
     * The index into the list of primitive feature IDs used for picking and styling. For EXT_feature_metadata,
     * feature ID attributes are listed before feature ID textures. If both per-primitive and per-instance feature
     * IDs are present, the instance feature IDs take priority.
     *
     * Default: 0
     */
    @JsProperty
    public double featureIdIndex;
    /**
     * The index into the list of instance feature IDs used for picking and styling. If both per-primitive and
     * per-instance feature IDs are present, the instance feature IDs take priority.
     *
     * Default: 0
     */
    @JsProperty
    public double instanceFeatureIdIndex;
    /**
     * The tile variable to colorize as a heatmap. All rendered tiles will be colorized relative to each other's
     * specified variable value.
     */
    @JsProperty
    public String debugHeatmapTilePropertyName;
    /**
     * For debugging only. Determines if only the tiles from last frame should be
     * used for rendering. Defaule: false;
     */
    @JsProperty
    public boolean debugFreezeFrame;
    /**
     * For debugging only. When true, assigns a random color to each tile. Defaule:
     * false;
     */
    @JsProperty
    public boolean debugColorizeTiles;
    /**
     * For debugging only. When true, render's each tile's content as a wireframe.
     * Defaule: false;
     */
    @JsProperty
    public boolean debugWireframe;
    /**
     * For debugging only. When true, renders the bounding volume for each tile.
     * Defaule: false;
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * For debugging only. When true, renders the bounding volume for each tile's
     * content. Defaule: false;
     */
    @JsProperty
    public boolean debugShowContentBoundingVolume;
    /**
     * For debugging only. When true, renders the viewer request volume for each
     * tile. Defaule: false;
     */
    @JsProperty
    public boolean debugShowViewerRequestVolume;
    /**
     * For debugging only. When true, draws labels to indicate the geometric error
     * of each tile. Defaule: false;
     */
    @JsProperty
    public boolean debugShowGeometricError;
    /**
     * For debugging only. When true, draws labels to indicate the number of
     * commands, points, triangles and features for each tile. Defaule: false;
     */
    @JsProperty
    public boolean debugShowRenderingStatistics;
    /**
     * For debugging only. When true, draws labels to indicate the texture and
     * geometry memory in megabytes used by each tile. Defaule: false;
     */
    @JsProperty
    public boolean debugShowMemoryUsage;
    /**
     * Optimization option. Reduce the screen space error for tiles that are further
     * away from the camera. Defaule: false
     */
    @JsProperty
    public boolean dynamicScreenSpaceError;
    /**
     * Density used to adjust the dynamic screen space error, similar to fog
     * density. Default: 0.00278
     */
    @JsProperty
    public double dynamicScreenSpaceErrorDensity;
    /**
     * A factor used to increase the computed dynamic screen space error. Default:
     * 4.0
     */
    @JsProperty
    public double dynamicScreenSpaceErrorFactor;
    /**
     * A ratio of the tileset's height at which the density starts to falloff.
     * Default: 0.25
     */
    @JsProperty
    public double dynamicScreenSpaceErrorHeightFalloff;
    /**
     * When skipLevelOfDetail is true, only tiles that meet the maximum screen space
     * error will ever be downloaded. Skipping factors are ignored and just the
     * desired tiles are loaded. Defaule: false;
     */
    @JsProperty
    public boolean immediatelyLoadDesiredLevelOfDetail;
    /**
     * The event fired to indicate that all tiles that meet the screen space error
     * this frame are loaded. This event is fired once when all tiles in the initial
     * view are loaded. This event is fired at the end of the frame after the scene
     * is rendered. Default: new Event();
     *
     * @see Cesium3DTileset#allTilesLoaded
     */
    @JsProperty
    public Event initialTilesLoaded;
    /**
     * The color and intensity of the sunlight used to shade a model. For example,
     * disabling additional light sources by setting model.imageBasedLightingFactor
     * = new Cartesian2(0.0, 0.0) will make the model much darker. Here, increasing
     * the intensity of the light source will make the model brighter. Default
     * Value: undefined
     */
    @JsProperty
    public Cartesian3 lightColor;
    /**
     * The event fired to indicate progress of loading new tiles. This event is
     * fired when a new tile is requested, when a requested tile is finished
     * downloading, and when a downloaded tile has been processed and is ready to
     * render. The number of pending tile requests, numberOfPendingRequests, and
     * number of tiles processing, numberOfTilesProcessing are passed to the event
     * listener.
     * <p>
     * This event is fired at the end of the frame after the scene is rendered.
     * Default: new Event()
     */
    @JsProperty
    public Event loadProgress;
    /**
     * When skipLevelOfDetail is true, determines whether siblings of visible tiles
     * are always downloaded during traversal. Defaule: false;
     */
    @JsProperty
    public boolean loadSiblings;

    /**
     * The maximum additional amount of GPU memory (in bytes) that will be used to cache tiles.
     * <p>
     *     If tiles sized more than cacheBytes plus maximumCacheOverflowBytes are needed to meet the desired screen
     *     space error, determined by Cesium3DTileset#maximumScreenSpaceError for the current view, then
     *     Cesium3DTileset#memoryAdjustedScreenSpaceError will be adjusted until the tiles required to meet the
     *     adjusted screen space error use less than cacheBytes plus maximumCacheOverflowBytes.
     * </p>
     *
     * Default: 536870912
     */
    @JsProperty
    public double maximumCacheOverflowBytes;

    /**
     * The sun's luminance at the zenith in kilo candela per meter squared to use
     * for this model's procedural environment map. This is used when
     * {@link Model#specularEnvironmentMaps} and
     * {@link Model#sphericalHarmonicCoefficients} are not defined. Default: 0.5
     */
    @JsProperty
    public double luminanceAtZenith;
    /**
     * The maximum screen space error used to drive level of detail refinement.
     * Default: 16
     */
    @JsProperty
    public double maximumScreenSpaceError;
    /**
     * A 4x4 transformation matrix that transforms the tileset's root tile. Default:
     * {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * The color to use when rendering outlines. This option is only used when enableModelExperimental is set to true.
     * Default: {@link Color#BLACK()}
     */
    @JsProperty
    public Color outlineColor;
    /**
     * Options for controlling point size based on geometric error and eye dome
     * lighting.
     */
    @JsProperty
    public PointCloudShading pointCloudShading;
    /**
     * Preload tiles at the camera's flight destination while the camera is in
     * flight. Default: true
     */
    @JsProperty
    public boolean preloadFlightDestinations;
    /**
     * Preload tiles when tileset.show is false. Loads tiles as if the tileset is
     * visible but does not render them. Default: false
     */
    @JsProperty
    public boolean preloadWhenHidden;
    /**
     * Optimization option. If between (0.0, 0.5], tiles at or above the screen
     * space error for the reduced screen resolution of
     * progressiveResolutionHeightFraction*screenHeight will be prioritized first.
     * This can help get a quick layer of tiles down while full resolution tiles
     * continue to load. Default: 0.3
     */
    @JsProperty
    public double progressiveResolutionHeightFraction;
    /**
     * Optimization option. Prioritize loading tiles in the center of the screen by
     * temporarily raising the screen space error for tiles around the edge of the
     * screen. Screen space error returns to normal once all the tiles in the center
     * of the screen as determined by the
     * {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedConeSize} are loaded.
     * Default: true
     */
    @JsProperty
    public boolean foveatedScreenSpaceError;
    /**
     * Optimization option. Used when
     * {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedScreenSpaceError} is
     * true to control how long in seconds to wait after the camera stops moving
     * before deferred tiles start loading in. This time delay prevents requesting
     * tiles around the edges of the screen when the camera is moving. Setting this
     * to 0.0 will immediately request all tiles in any given view. Default: 0.2
     */
    @JsProperty
    public double foveatedTimeDelay;
    /**
     * Optimization option. Prefer loading of leaves first. Default: false
     */
    @JsProperty
    public boolean preferLeaves;
    /**
     * Determines whether the tileset casts or receives shadows from each light
     * source. Default: {@link org.cesiumjs.cs.scene.enums.ShadowMode#ENABLED()}
     */
    @JsProperty
    public Number shadows;
    /**
     * Determines if the tileset will be shown. Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * Determines whether the credits of the tileset will be displayed on the screen
     * Default: false
     */
    @JsProperty
    public boolean showCreditsOnScreen;
    /**
     * Whether to display the outline for models using the CESIUM_primitive_outline extension. When true,
     * outlines are displayed. When false, outlines are not displayed.
     * When enableModelExperimental is set to true, this property can be toggled at runtime. However,
     * when enableModelExperimental is false, this property is readonly (it can only be set in the constructor).
     * Default: true
     */
    @JsProperty
    public boolean showOutline;
    /**
     * Optimization option. Determines if level of detail skipping should be applied
     * during the traversal. Defaule: true
     */
    @JsProperty
    public boolean skipLevelOfDetail;
    /**
     * When skipLevelOfDetail is true, a constant defining the minimum number of
     * levels to skip when loading tiles. When it is 0, no levels are skipped. Used
     * in conjunction with skipScreenSpaceErrorFactor to determine which tiles to
     * load. Default: 1
     */
    @JsProperty
    public double skipLevels;
    /**
     * When skipLevelOfDetail is true, a multiplier defining the minimum screen
     * space error to skip. Used in conjunction with skipLevels to determine which
     * tiles to load. Default: 16
     */
    @JsProperty
    public double skipScreenSpaceErrorFactor;
    /**
     * A URL to a KTX file that contains a cube map of the specular lighting and the
     * convoluted specular mipmaps.
     *
     * @see Model#sphericalHarmonicCoefficients
     */
    @JsProperty
    public String specularEnvironmentMaps;
    /**
     * The third order spherical harmonic coefficients used for the diffuse color of
     * image-based lighting. When undefined, a diffuse irradiance computed from the
     * atmosphere color is used. There are nine Cartesian3 coefficients. The order
     * of the coefficients is: L00, L1-1, L10, L11, L2-2, L2-1, L20, L21, L22
     * <p>
     * These values can be obtained by preprocessing the environment map using the
     * cmgen tool of Google's Filament project. This will also generate a KTX file
     * that can be supplied to Model#specularEnvironmentMaps.
     *
     * @see <a href="https://graphics.stanford.edu/papers/envmap/envmap.pdf">An
     * Efficient Representation for Irradiance Environment Maps</a>
     */
    @JsProperty
    public Cartesian3[] sphericalHarmonicCoefficients;
    /**
     * The SplitDirection to apply to this tileset.
     * Default: {@link SplitDirection#NONE()}
     */
    @JsProperty
    public Number splitDirection;
    /**
     * The style, defined using the 3D Tiles Styling language, applied to each
     * feature in the tileset. Assign undefined to remove the style, which will
     * restore the visual appearance of the tileset to its default when no style was
     * applied.
     * <p>
     * The style is applied to a tile before the Cesium3DTileset#tileVisible event
     * is raised, so code in tileVisible can manually set a feature's properties
     * (e.g. color and show) after the style is applied. When a new style is
     * assigned any manually set properties are overwritten.
     * <p>
     * Default: undefined
     */
    @JsProperty
    public Cesium3DTileStyle style;
    /**
     * The event fired to indicate that a tile's content failed to load. If there
     * are no event listeners, error messages will be logged to the console.
     * <p>
     * Default: new Event()
     */
    @JsProperty
    public Event tileFailed;
    /**
     * The event fired to indicate that a tile's content was loaded. The loaded
     * Cesium3DTile is passed to the event listener.
     * <p>
     * This event is fired during the tileset traversal while the frame is being
     * rendered so that updates to the tile take effect in the same frame. Do not
     * create or modify Cesium entities or primitives during the event listener.
     * <p>
     * Default: new Event()
     */
    @JsProperty
    public Event tileLoad;
    /**
     * The event fired to indicate that a tile's content was unloaded. The unloaded
     * Cesium3DTile is passed to the event listener.
     * <p>
     * This event is fired immediately before the tile's content is unloaded while
     * the frame is being rendered so that the event listener has access to the
     * tile's content. Do not create or modify Cesium entities or primitives during
     * the event listener.
     * <p>
     * Default Value: new Event()
     */
    @JsProperty
    public Event tileUnload;
    /**
     * This event fires once for each visible tile in a frame. This can be used to
     * manually style a tileset. The visible Cesium3DTile is passed to the event
     * listener.
     * <p>
     * This event is fired during the tileset traversal while the frame is being
     * rendered so that updates to the tile take effect in the same frame. Do not
     * create or modify Cesium entities or primitives during the event listener.
     * <p>
     * Default Value: new Event()
     */
    @JsProperty
    public Event tileVisible;

    /**
     * A <a href=
     * "https://github.com/AnalyticalGraphicsInc/3d-tiles/blob/master/README.md">3D
     * Tiles tileset</a>, used for streaming massive heterogeneous 3D geospatial
     * datasets.
     *
     * @param options {@link Cesium3DTilesetOptions}
     */
    @JsConstructor
    public Cesium3DTileset(Cesium3DTilesetOptions options) {
    }

    @JsOverlay
    public static Cesium3DTileset create(String url) {
        Cesium3DTilesetOptions options = Cesium3DTilesetOptions.create(url);
        return new Cesium3DTileset(options);
    }

    @JsOverlay
    public static Cesium3DTileset create(Resource url) {
        Cesium3DTilesetOptions options = Cesium3DTilesetOptions.create(url);
        return new Cesium3DTileset(options);
    }

    @JsOverlay
    public static Cesium3DTileset create(Promise<?, ?> url) {
        Cesium3DTilesetOptions options = Cesium3DTilesetOptions.create(url);
        return new Cesium3DTileset(options);
    }

    /**
     * Creates a 3D Tiles tileset, used for streaming massive heterogeneous 3D geospatial datasets, from a Cesium ion asset ID.
     * @param assetId The Cesium ion asset id.
     * @return Cesium3DTileset
     */
    @JsMethod
    public static native Promise<Cesium3DTileset, Void> fromIonAssetId(Number assetId);

    /**
     * Creates a 3D Tiles tileset, used for streaming massive heterogeneous 3D geospatial datasets, from a Cesium ion asset ID.
     * @param assetId The Cesium ion asset id.
     * @param options An object describing initialization options
     * @return Cesium3DTileset
     */
    @JsMethod
    public static native Promise<Cesium3DTileset, Void> fromIonAssetId(Number assetId, Cesium3DTilesetOptions options);

    /**
     * Creates a 3D Tiles tileset, used for streaming massive heterogeneous 3D geospatial datasets.
     * @param resource The url to a tileset JSON file.
     * @return Cesium3DTileset
     */
    @JsMethod
    public static native Promise<Cesium3DTileset, Void> fromUrl(Resource resource);

    /**
     * Creates a 3D Tiles tileset, used for streaming massive heterogeneous 3D geospatial datasets.
     * @param resource The url to a tileset JSON file.
     * @param options An object describing initialization options
     * @return Cesium3DTileset
     */
    @JsMethod
    public static native Promise<Cesium3DTileset, Void> fromUrl(Resource resource, Cesium3DTilesetOptions options);

    /**
     * Creates a 3D Tiles tileset, used for streaming massive heterogeneous 3D geospatial datasets.
     * @param url The url to a tileset JSON file.
     * @return Cesium3DTileset
     */
    @JsMethod
    public static native Promise<Cesium3DTileset, Void> fromUrl(String url);

    /**
     * Creates a 3D Tiles tileset, used for streaming massive heterogeneous 3D geospatial datasets.
     * @param url The url to a tileset JSON file.
     * @param options An object describing initialization options
     * @return Cesium3DTileset
     */
    @JsMethod
    public static native Promise<Cesium3DTileset, Void> fromUrl(String url, Cesium3DTilesetOptions options);

    /**
     * Provides a hook to override the method used to request the tileset json
     * useful when fetching tilesets from remote servers
     *
     * @param tilesetUrl The url of the json file to be fetched
     * @return A promise that resolves with the fetched json data
     */
    @JsMethod
    public static native Promise<JsObject, Void> loadJson(String tilesetUrl);

    /**
     * Gets the tileset's asset object property, which contains metadata about the
     * tileset. See the asset schema in the 3D Tiles spec for the full set of
     * properties.
     */
    @JsProperty(name = "asset")
    public native Object asset();

    /**
     * The base path that non-absolute paths in tileset.json are relative to.
     */
    @JsProperty(name = "basePath")
    public native String basePath();

    /**
     * The tileset's bounding sphere.
     */
    @JsProperty(name = "boundingSphere")
    public native BoundingSphere boundingSphere();

    /**
     * The amount of GPU memory (in bytes) used to cache tiles. This memory usage is estimated from geometry, textures,
     * and batch table textures of loaded tiles. For point clouds, this value also includes per-point metadata.
     * Tiles not in view are unloaded to enforce this.
     * <p>
     * If decreasing this value results in unloading tiles, the tiles are unloaded the next frame.
     * <p>
     * If tiles sized more than cacheBytes are needed to meet the desired screen space error, determined by
     * Cesium3DTileset#maximumScreenSpaceError, for the current view, then the memory usage of the tiles loaded will
     * exceed cacheBytes by up to maximumCacheOverflowBytes. For example, if cacheBytes is 500000, but 600000 bytes of
     * tiles are needed to meet the screen space error, then 600000 bytes of tiles may be loaded
     * (if maximumCacheOverflowBytes is at least 100000). When these tiles go out of view, they will be unloaded.
     * <p>
     * Default: 536870912
     */
    @JsProperty
    public double cacheBytes;

    /**
     * Determines whether terrain, 3D Tiles or both will be classified by this
     * tileset. This option is only applied to tilesets containing batched 3D
     * models, geometry data, or vector data. Even when undefined, vector data and
     * geometry data must render as classifications and will default to rendering on
     * both terrain and other 3D Tiles tilesets.
     * <p>
     * When enabled for batched 3D model tilesets, there are a few
     * requirements/limitations on the glTF:
     * <p>
     * POSITION and _BATCHID semantics are required. All indices with the same batch
     * id must occupy contiguous sections of the index buffer. All shaders and
     * techniques are ignored. The generated shader simply multiplies the position
     * by the model-view-projection matrix. The only supported extensions are
     * CESIUM_RTC and WEB3D_quantized_attributes. Only one node is supported. Only
     * one mesh per node is supported. Only one primitive per mesh is supported.
     */
    @JsProperty(name = "classificationType")
    public native ClassificationType classificationType();

    /**
     * The ellipsoid determining the size and shape of the globe. Default:
     * {@link Ellipsoid#WGS84()}.
     */
    @JsProperty(name = "ellipsoid")
    public native Ellipsoid ellipsoid();

    /**
     * If true, ModelExperimental will be used instead of {@link Model} for each tile with a glTF or 3D Tiles 1.0
     * content (where applicable).
     * The value defaults to {@link org.cesiumjs.cs.Cesium.ExperimentalFeatures#enableModelExperimental}.
     */
    @JsProperty
    public boolean enableModelExperimental;

    /**
     * Gets the tileset's extensions object property.
     */
    @JsProperty(name = "extensions")
    public native Object extensions();

    /**
     * Returns the extras property at the top-level of the tileset JSON, which
     * contains application specific metadata. Returns undefined if extras does not
     * exist.
     */
    @JsProperty(name = "extras")
    public native Object extras();

    /**
     * Gets the tileset's properties dictionary object, which contains metadata
     * about per-feature properties. See the properties schema in the 3D Tiles spec
     * for the full set of properties.
     *
     * @see Cesium3DTileFeature#getProperty
     * @see Cesium3DTileFeature#setProperty
     */
    @JsProperty(name = "properties")
    public native Object properties();

    /**
     * When true, the tileset's root tile is loaded and the tileset is ready to
     * render. This is set to true right before Cesium3DTileset#readyPromise is
     * resolved. Default: false
     */
    @JsProperty(name = "ready")
    public native boolean ready();

    /**
     * Gets the promise that will be resolved when the tileset's root tile is loaded
     * and the tileset is ready to render. This promise is resolved at the end of
     * the frame before the first frame the tileset is rendered in.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<Cesium3DTileset, Void> readyPromise();

    /**
     * The root tile.
     */
    @JsProperty(name = "root")
    public native Cesium3DTile root();

    /**
     * When true, all tiles that meet the screen space error this frame are loaded.
     * The tileset is completely loaded for this view. Default: false
     */
    @JsProperty(name = "tilesLoaded")
    public native boolean tilesLoaded();

    /**
     * Returns the time, in milliseconds, since the tileset was loaded and first
     * updated.
     */
    @JsProperty(name = "timeSinceLoad")
    public native int timeSinceLoad();

    /**
     * The total amount of GPU memory in bytes used by the tileset. This value is
     * estimated from geometry, texture, and batch table textures of loaded tiles.
     * For point clouds, this value also includes per-point metadata.
     *
     * @see Cesium3DTileset#maximumMemoryUsage
     */
    @JsProperty(name = "totalMemoryUsageInBytes")
    public native int totalMemoryUsageInBytes();
    /**
     * Indicates that only the tileset's vector tiles should be used for classification.
     * Default: false
     */
    @JsProperty
    public boolean vectorClassificationOnly;
    /**
     * Whether vector tiles should keep decoded positions in memory. This is used with Cesium3DTileFeature.getPolylinePositions.
     * Default: false
     */
    @JsProperty
    public boolean vectorKeepDecodedPositions;
    /**
     * The resource used to fetch the tileset JSON file.
     */
    @JsProperty(name = "resource")
    public native Resource resource();

    /**
     * Get the height of the loaded surface at a given cartographic. This function will only take into account meshes
     * for loaded tiles, not neccisarily the most detailed tiles available for a tileset. This function will always
     * return undefined when sampling a point cloud.
     * @param cartographic The cartographic for which to find the height.
     * @param scene The scene where visualization is taking place.
     * @return The height of the cartographic or undefined if it could not be found.
     */
    @JsMethod
    public native Number getHeight(Cartographic cartographic, Scene scene);

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows
     * for deterministic release of WebGL resources, instead of relying on the
     * garbage collector to destroy this object.
     * <p>
     * Once an object is destroyed, it should not be used; calling any function
     * other than isDestroyed will result in a DeveloperError exception. Therefore,
     * assign the return value (undefined) to the object as done in the example.
     *
     * @see Cesium3DTileset#isDestroyed
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     * <p>
     * If this object was destroyed, it should not be used; calling any function
     * other than isDestroyed will result in a DeveloperError exception.
     *
     * @return true if this object was destroyed; otherwise, false.
     * @see Cesium3DTileset#destroy
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Marks the tileset's Cesium3DTileset#style as dirty, which forces all features
     * to re-evaluate the style in the next frame each is visible.
     */
    @JsMethod
    public native void makeStyleDirty();

    /**
     * Unloads all tiles that weren't selected the previous frame. This can be used
     * to explicitly manage the tile cache and reduce the total number of tiles
     * loaded below Cesium3DTileset#maximumMemoryUsage. Tile unloads occur at the
     * next frame to keep all the WebGL delete calls within the render loop.
     */
    @JsMethod
    public native void trimLoadedTiles();

    /**
     * Called when Viewer or CesiumWidget render the scene to get the draw commands
     * needed to render this primitive. Do not call this function directly. This is
     * documented just to list the exceptions that may be propagated when the scene
     * is rendered:
     */
    @JsMethod
    public native void update();

    /**
     * Optimization option. Used as a callback when
     * {@link Cesium3DTileset#foveatedScreenSpaceError} is true to control how much
     * to raise the screen space error for tiles outside the foveated cone,
     * interpolating between
     * {@link Cesium3DTileset#foveatedMinimumScreenSpaceErrorRelaxation} and
     * {@link Cesium3DTileset#maximumScreenSpaceError}.
     */
    @JsFunction
    public interface FoveatedInterpolationCallback {
        /**
         * Optimization option. Used as a callback when
         * {@link Cesium3DTileset#foveatedScreenSpaceError} is true to control how much
         * to raise the screen space error for tiles outside the foveated cone,
         * interpolating between
         * {@link Cesium3DTileset#foveatedMinimumScreenSpaceErrorRelaxation} and
         * {@link Cesium3DTileset#maximumScreenSpaceError}.
         *
         * @param p    The start value to interpolate.
         * @param q    The end value to interpolate.
         * @param time The time of interpolation generally in the range [0.0, 1.0].
         * @return The interpolated value.
         */
        double function(double p, double q, double time);
    }
}
