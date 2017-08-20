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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.BoundingSphere;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.enums.Cesium3DTileColorBlendMode;
import org.cesiumjs.cs.scene.options.Cesium3DTilesetOptions;

/**
 * A <a href="https://github.com/AnalyticalGraphicsInc/3d-tiles/blob/master/README.md">3D Tiles tileset</a>,
 * used for streaming massive heterogeneous 3D geospatial datasets.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cesium3DTileset")
public class Cesium3DTileset {
    /**
     * The event fired to indicate that all tiles that meet the screen space error this frame are loaded.
     * The tileset is completely loaded for this view.
     * This event is fired at the end of the frame after the scene is rendered.
     * Default: new Event()
     */
    @JsProperty
    public Event allTilesLoaded;
    /**
     * Gets the tileset's asset object property, which contains metadata about the tileset.
     * See the asset schema in the 3D Tiles spec for the full set of properties.
     */
    @JsProperty(name = "asset")
    public native Object asset();
    /**
     * The base path that non-absolute paths in tileset.json are relative to.
     */
    @JsProperty(name = "basePath")
    public native String basePath();
    /**
     * The screen space error that must be reached before skipping levels of detail.
     * Only used when {@link Cesium3DTileset#skipLevelOfDetail} is true.
     * Default: 1024
     */
    @JsProperty
    public double baseScreenSpaceError;
    /**
     * The tileset's bounding sphere.
     */
    @JsProperty(name = "boundingSphere")
    public native BoundingSphere boundingSphere();
    /**
     * Defines the value used to linearly interpolate between the source color and feature color when the
     * {@link Cesium3DTileset#colorBlendMode} is MIX. A value of 0.0 results in the source color while a value
     * of 1.0 results in the feature color, with any value in-between resulting in a mix of
     * the source color and feature color.
     * Default: 0.5
     */
    @JsProperty
    public double colorBlendAmount;
    /**
     * Defines how per-feature colors set from the Cesium API or declarative styling blend with the source colors from
     * the original feature, e.g. glTF material or per-point color in the tile.
     * @see Cesium3DTileColorBlendMode
     * Default: {@link Cesium3DTileColorBlendMode#HIGHLIGHT()}
     */
    @JsProperty
    public Number colorBlendMode;
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
     * When skipLevelOfDetail is true, only tiles that meet the maximum screen space error will ever be downloaded. Skipping factors are ignored and just the desired tiles are loaded.
     * Defaule: false;
     */
    @JsProperty
    public boolean immediatelyLoadDesiredLevelOfDetail;
    /**
     * The event fired to indicate progress of loading new tiles. This event is fired when a new tile is requested,
     * when a requested tile is finished downloading, and when a downloaded tile has been processed and is ready to render.
     * The number of pending tile requests, numberOfPendingRequests, and number of tiles processing, numberOfTilesProcessing
     * are passed to the event listener.
     *
     * This event is fired at the end of the frame after the scene is rendered.
     * Default: new Event()
     */
    @JsProperty
    public Event loadProgress;
    /**
     * When skipLevelOfDetail is true, determines whether siblings of visible tiles are always downloaded during traversal.
     * Defaule: false;
     */
    @JsProperty
    public boolean loadSiblings;
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
     * A 4x4 transformation matrix that transforms the tileset's root tile.
     * Default: {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * Gets the tileset's properties dictionary object, which contains metadata about per-feature properties.
     * See the properties schema in the 3D Tiles spec for the full set of properties.
     * @see Cesium3DTileFeature#getProperty
     * @see Cesium3DTileFeature#setProperty
     */
    @JsProperty(name = "properties")
    public native Object properties();
    /**
     * When true, the tileset's root tile is loaded and the tileset is ready to render. This is set to true right before Cesium3DTileset#readyPromise is resolved.
     * Default: false
     */
    @JsProperty(name = "ready")
    public native boolean ready();
    /**
     * Gets the promise that will be resolved when the tileset's root tile is loaded and the tileset is ready to render.
     * This promise is resolved at the end of the frame before the first frame the tileset is rendered in.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<Cesium3DTileset, Void> readyPromise();
    /**
     * Determines whether the tileset casts or receives shadows from each light source.
     * Default: {@link org.cesiumjs.cs.scene.enums.ShadowMode#ENABLED()}
     */
    @JsProperty
    public Number shadows;
    /**
     * Determines if the tileset will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * Optimization option. Determines if level of detail skipping should be applied during the traversal.
     * Defaule: true
     */
    @JsProperty
    public boolean skipLevelOfDetail;
    /**
     * When skipLevelOfDetail is true, a constant defining the minimum number of levels to skip when loading tiles. When it is 0, no levels are skipped. Used in conjunction with skipScreenSpaceErrorFactor to determine which tiles to load.
     * Default: 1
     */
    @JsProperty
    public double skipLevels;
    /**
     * When skipLevelOfDetail is true, a multiplier defining the minimum screen space error to skip. Used in conjunction with skipLevels to determine which tiles to load.
     * Default: 16
     */
    @JsProperty
    public double skipScreenSpaceErrorFactor;
    /**
     * The style, defined using the 3D Tiles Styling language, applied to each feature in the tileset.
     * Assign undefined to remove the style, which will restore the visual appearance of the tileset to its default when no style was applied.
     *
     * The style is applied to a tile before the Cesium3DTileset#tileVisible event is raised, so code in tileVisible can manually set a feature's properties (e.g. color and show) after the style is applied. When a new style is assigned any manually set properties are overwritten.
     *
     * Default: undefined
     */
    @JsProperty
    public Cesium3DTileStyle style;
    /**
     * The event fired to indicate that a tile's content was loaded.
     * The loaded Cesium3DTile is passed to the event listener.
     *
     * This event is fired during the tileset traversal while the frame is being rendered so that updates to the tile
     * take effect in the same frame. Do not create or modify Cesium entities or primitives during the event listener.
     *
     * Default: new Event()
     */
    @JsProperty
    public Event tileLoad;
    /**
     * When true, all tiles that meet the screen space error this frame are loaded. The tileset is completely loaded for this view.
     * Default: false
     */
    @JsProperty(name = "tilesLoaded")
    public native boolean tilesLoaded();
    /**
     * The event fired to indicate that a tile's content was unloaded.
     * The unloaded Cesium3DTile is passed to the event listener.
     *
     * This event is fired immediately before the tile's content is unloaded while the frame is being rendered so that
     * the event listener has access to the tile's content. Do not create or modify Cesium entities or primitives during the event listener.
     *
     * Default Value:  new Event()
     */
    @JsProperty
    public Event tileUnload;
    /**
     * This event fires once for each visible tile in a frame. This can be used to manually style a tileset.
     * The visible Cesium3DTile is passed to the event listener.
     *
     * This event is fired during the tileset traversal while the frame is being rendered so that updates to the
     * tile take effect in the same frame. Do not create or modify Cesium entities or primitives during the event listener.
     *
     * Default Value:  new Event()
      */
    @JsProperty
    public Event tileVisible;
    /**
     * Returns the time, in milliseconds, since the tileset was loaded and first updated.
     */
    @JsProperty(name = "timeSinceLoad")
    public native int timeSinceLoad();
    /**
     * The total amount of GPU memory in bytes used by the tileset. This value is estimated from geometry, texture,
     * and batch table textures of loaded tiles. For point clouds, this value also includes per-point metadata.
     * @see Cesium3DTileset#maximumMemoryUsage
     */
    @JsProperty(name = "totalMemoryUsageInBytes")
    public native int totalMemoryUsageInBytes();
    /**
     * The url to a tileset.json file or to a directory containing a tileset.json file.
     */
    @JsProperty(name = "url")
    public native String url();

    /**
     * A <a href="https://github.com/AnalyticalGraphicsInc/3d-tiles/blob/master/README.md">3D Tiles tileset</a>,
     * used for streaming massive heterogeneous 3D geospatial datasets.
     * @param options {@link Cesium3DTilesetOptions}
     */
    @JsConstructor
    private Cesium3DTileset(Cesium3DTilesetOptions options) {}

    @JsOverlay
    public static Cesium3DTileset create(String url) {
        Cesium3DTilesetOptions options = Cesium3DTilesetOptions.create(url);
        return new Cesium3DTileset(options);
    }

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see Cesium3DTileset#isDestroyed
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     * @see Cesium3DTileset#destroy
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Marks the tileset's Cesium3DTileset#style as dirty, which forces all features to re-evaluate
     * the style in the next frame each is visible.
     */
    @JsMethod
    public native void makeStyleDirty();

    /**
     * Unloads all tiles that weren't selected the previous frame. This can be used to explicitly manage the tile cache and reduce the total number of tiles loaded below Cesium3DTileset#maximumMemoryUsage.
     * Tile unloads occur at the next frame to keep all the WebGL delete calls within the render loop.
     */
    @JsMethod
    public native void trimLoadedTiles();

    /**
     * Called when Viewer or CesiumWidget render the scene to get the draw commands needed to render this primitive.
     * Do not call this function directly. This is documented just to list the exceptions that may be propagated when the scene is rendered:
     */
    @JsMethod
    public native void update();
}
