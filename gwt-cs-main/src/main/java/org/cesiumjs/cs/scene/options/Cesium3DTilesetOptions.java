/*
 * Copyright 2017 iserge.
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
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.enums.ShadowMode;

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
}
