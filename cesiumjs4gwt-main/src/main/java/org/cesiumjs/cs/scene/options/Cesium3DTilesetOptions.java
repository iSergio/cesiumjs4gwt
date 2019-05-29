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

import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.ClippingPlaneCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.PointCloudShading;
import org.cesiumjs.cs.scene.enums.ClassificationType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class Cesium3DTilesetOptions {
    /**
     * The url to a tileset.json file or to a directory containing a tileset.json file.
     */
    @JsProperty
    public String url;
    @JsProperty(name = "url")
    public Resource resource;
    @JsProperty(name = "url")
    public Promise<?, ?> promise;
    /**
     * Determines if the tileset will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * A 4x4 transformation matrix that transforms the tileset's root tile.
     * Default: {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * Determines whether the tileset casts or receives shadows from each light source.
     * Default: {@link org.cesiumjs.cs.scene.enums.ShadowMode#ENABLED()}
     */
    @JsProperty
    public Number shadows;
    /**
     * The maximum screen space error used to drive level of detail refinement.
     * Default: 16
     */
    @JsProperty
    public double maximumScreenSpaceError;
    /**
     * The maximum amount of memory in MB that can be used by the tileset.
     * Default: 512
     */
    @JsProperty
    public double maximumMemoryUsage;
    /**
     * Optimization option. Whether to cull tiles using the union of their children bounding volumes.
     * Default: true
     */
    @JsProperty
    public boolean cullWithChildrenBounds;
    /**
     * Don't request tiles that will likely be unused when they come back because of the camera's movement.
     * Default: true
     */
    @JsProperty
    public boolean cullRequestsWhileMoving;
    /**
     * Multiplier used in culling requests while moving. Larger is more aggressive culling, smaller less aggressive culling.
     * Defaule: 60.0
     */
    @JsProperty
    public double cullRequestsWhileMovingMultiplier;
    /**
     * Preload tiles when tileset.show is false. Loads tiles as if the tileset is visible but does not render them.
     * Default: false
     */
    @JsProperty
    public boolean preloadWhenHidden;
    /**
     * Preload tiles at the camera's flight destination while the camera is in flight.
     * Default: true
     */
    @JsProperty
    public boolean preloadFlightDestinations;
    /**
     * Optimization option. Prefer loading of leaves first.
     * Default: false
     */
    @JsProperty
    public boolean preferLeaves;
    /**
     * Optimization option. Reduce the screen space error for tiles that are further away from the camera.
     * Defaule: false
     */
    @JsProperty
    public boolean dynamicScreenSpaceError;
    /**
     * Density used to adjust the dynamic screen space error, similar to fog density.
     * Default: 0.00278
     */
    @JsProperty
    public double dynamicScreenSpaceErrorDensity;
    /**
     * A factor used to increase the computed dynamic screen space error.
     * Default: 4.0
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
     * Optimization option. If between (0.0, 0.5], tiles at or above the screen space error for the reduced screen
     * resolution of progressiveResolutionHeightFraction*screenHeight will be prioritized first. This can help get a
     * quick layer of tiles down while full resolution tiles continue to load.
     * Default: 0.3
     */
    @JsProperty
    public double progressiveResolutionHeightFraction;
    /**
     * Optimization option. Prioritize loading tiles in the center of the screen by temporarily raising the screen
     * space error for tiles around the edge of the screen. Screen space error returns to normal once all the tiles
     * in the center of the screen as determined by the {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedConeSize} are loaded.
     * Default: true
     */
    @JsProperty
    public boolean foveatedScreenSpaceError;
    /**
     * Optimization option. Used when {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedScreenSpaceError} is true to control the cone size that
     * determines which tiles are deferred. Tiles that are inside this cone are loaded immediately. Tiles outside the
     * cone are potentially deferred based on how far outside the cone they are and their screen space error.
     * This is controlled by {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedInterpolationCallback} and {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedMinimumScreenSpaceErrorRelaxation}.
     * Setting this to 0.0 means the cone will be the line formed by the camera position and its view direction.
     * Setting this to 1.0 means the cone encompasses the entire field of view of the camera, disabling the effect.
     * Default: 0.1
     */
    @JsProperty
    public double foveatedConeSize;
    /**
     * Optimization option. Used when {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedScreenSpaceError} is true to control the starting screen
     * space error relaxation for tiles outside the foveated cone. The screen space error will be raised starting with
     * tileset value up to {@link org.cesiumjs.cs.scene.Cesium3DTileset#maximumScreenSpaceError} based on the provided {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedInterpolationCallback}.
     * Default: 0.0
     */
    @JsProperty
    public double foveatedMinimumScreenSpaceErrorRelaxation;
    /**
     * Optimization option. Used when {@link Cesium3DTileset#foveatedScreenSpaceError} is true to control how much to
     * raise the screen space error for tiles outside the foveated cone, interpolating
     * between {@link Cesium3DTileset#foveatedMinimumScreenSpaceErrorRelaxation} and {@link Cesium3DTileset#maximumScreenSpaceError}
     */
    @JsProperty
    public Cesium3DTileset.FoveatedInterpolationCallback foveatedInterpolationCallback;
    /**
     * Optimization option. Used when {@link org.cesiumjs.cs.scene.Cesium3DTileset#foveatedScreenSpaceError} is true to control how long in seconds
     * to wait after the camera stops moving before deferred tiles start loading in. This time delay prevents requesting
     * tiles around the edges of the screen when the camera is moving.
     * Setting this to 0.0 will immediately request all tiles in any given view.
     * Default: 0.2
     */
    @JsProperty
    public double foveatedTimeDelay;
    /**
     * Optimization option. Determines if level of detail skipping should be applied during the traversal.
     * Defaule: true
     */
    @JsProperty
    public boolean skipLevelOfDetail;
    /**
     * When skipLevelOfDetail is true, the screen space error that must be reached before skipping levels of detail.
     * Default: 1024
     */
    @JsProperty
    public double baseScreenSpaceError;
    /**
     * When skipLevelOfDetail is true, a multiplier defining the minimum screen space error to skip. Used in conjunction with skipLevels to determine which tiles to load.
     * Default: 16
     */
    @JsProperty
    public double skipScreenSpaceErrorFactor;
    /**
     * When skipLevelOfDetail is true, a constant defining the minimum number of levels to skip when loading tiles. When it is 0, no levels are skipped. Used in conjunction with skipScreenSpaceErrorFactor to determine which tiles to load.
     * Default: 1
     */
    @JsProperty
    public double skipLevels;
    /**
     * When skipLevelOfDetail is true, only tiles that meet the maximum screen space error will ever be downloaded. Skipping factors are ignored and just the desired tiles are loaded.
     * Defaule: false;
     */
    @JsProperty
    public boolean immediatelyLoadDesiredLevelOfDetail;
    /**
     * When skipLevelOfDetail is true, determines whether siblings of visible tiles are always downloaded during traversal.
     * Defaule: false;
     */
    @JsProperty
    public boolean loadSiblings;
    /**
     * The {@link ClippingPlaneCollection} used to selectively disable rendering the tileset.
     * Clipping planes are not currently supported in Internet Explorer.
     */
    @JsProperty
    public ClippingPlaneCollection clippingPlanes;
    /**
     * Determines whether terrain, 3D Tiles or both will be classified by this tileset.
     * See {@link org.cesiumjs.cs.scene.Cesium3DTileset#classificationType} for details about restrictions and limitations.
     */
    @JsProperty
    public ClassificationType classificationType;
    /**
     * The ellipsoid determining the size and shape of the globe.
     * Default: {@link Ellipsoid#WGS84()}
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * Options for constructing a PointCloudShading object to control point attenuation based on geometric error and lighting.
     */
    @JsProperty
    public PointCloudShading pointCloudShading;
    /**
     * Scales the diffuse and specular image-based lighting from the earth, sky, atmosphere and star skybox.
     * Default: new Cartesian2(1.0, 1.0)
     */
    @JsProperty
    public Cartesian2 imageBasedLightingFactor;
    /**
     * The color and intensity of the sunlight used to shade models.
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
    /**
     * For debugging only. Determines if only the tiles from last frame should be used for rendering.
     * Defaule: false;
     */
    @JsProperty
    public boolean debugFreezeFrame;
    /**
     * For debugging only. When true, assigns a random color to each tile.
     * Defaule: false;
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
     * For debugging only. When true, renders the bounding volume for each tile's content.
     * Defaule: false;
     */
    @JsProperty
    public boolean debugShowContentBoundingVolume;
    /**
     * For debugging only. When true, renders the viewer request volume for each tile.
     * Defaule: false;
     */
    @JsProperty
    public boolean debugShowViewerRequestVolume;
    /**
     * For debugging only. When true, draws labels to indicate the geometric error of each tile.
     * Defaule: false;
     */
    @JsProperty
    public boolean debugShowGeometricError;
    /**
     * For debugging only. When true, draws labels to indicate the number of commands, points, triangles and features for each tile.
     * Defaule: false;
     */
    @JsProperty
    public boolean debugShowRenderingStatistics;
    /**
     * For debugging only. When true, draws labels to indicate the texture and geometry memory in megabytes used by each tile.
     * Defaule: false;
     */
    @JsProperty
    public boolean debugShowMemoryUsage;

    @JsConstructor
    private Cesium3DTilesetOptions() {}

    @JsOverlay
    public static Cesium3DTilesetOptions create(String url) {
        Cesium3DTilesetOptions options = new Cesium3DTilesetOptions();
        options.url = url;
        return options;
    }

    @JsOverlay
    public static Cesium3DTilesetOptions create(Resource url) {
        Cesium3DTilesetOptions options = new Cesium3DTilesetOptions();
        options.resource = url;
        return options;
    }

    @JsOverlay
    public static Cesium3DTilesetOptions create(Promise<?, ?> url) {
        Cesium3DTilesetOptions options = new Cesium3DTilesetOptions();
        options.promise = url;
        return options;
    }
}
