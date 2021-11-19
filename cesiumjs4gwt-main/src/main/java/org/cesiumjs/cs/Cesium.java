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

package org.cesiumjs.cs;

import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.EntityCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.providers.CesiumTerrainProvider;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.datasources.graphics.ModelGraphics;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.options.CreateOsmBuildingsOptions;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.Cesium3DTileset;
import org.cesiumjs.cs.scene.Material;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.widgets.Command;

/**
 * @author Serge Silaev aka iSergio
 */
public class Cesium {
    @JsProperty(namespace = JsPackage.GLOBAL, name = "Cesium")
    public static native boolean isInitialized();

    @JsProperty(namespace = "Cesium", name = "VERSION")
    public static native String version();

    @JsProperty(namespace = JsPackage.GLOBAL, name = "CesiumPath")
    public static native String path();

    public static native void log(Object object) /*-{
        console.log(object);
    }-*/;

    /**
     * Fix for SmartGWT Thanks for Mark Erikson
     * (https://groups.google.com/forum/#!msg/cesium-dev/ZfyW0CNRsSU/lP6KTaUpEQAJ)
     */
    public static native void fixSmartGWT() /*-{
        if ($wnd.buildInDataView !== undefined) {
            console.log("Native DataView restored.");
            $wnd.DataView = $wnd.buildInDataView;
        } else {
            console.log("Native DataView not modified.");
        }
    }-*/;

    /**
     * Given a non-relative moduleID, returns an absolute URL to the file
     * represented by that module ID, using, in order of preference, require.toUrl,
     * the value of a global CESIUM_BASE_URL, or the base URL of the Cesium.js
     * script.
     */
    @JsMethod(namespace = "Cesium", name = "buildModuleUrl")
    public static native String buildModuleUrl(String moduleId);

    @JsMethod(namespace = "Cesium")
    public static native boolean defined(Object object);

    /**
     * Initiates a terrain height query for an array of {@link Cartographic}
     * positions by requesting tiles from a terrain provider, sampling, and
     * interpolating. The interpolation matches the triangles used to render the
     * terrain at the specified level. The query happens asynchronously, so this
     * function returns a promise that is resolved when the query completes. Each
     * point height is modified in place. If a height can not be determined because
     * no terrain data is available for the specified level at that location, or
     * another error occurs, the height is set to undefined. As is typical of the
     * {@link Cartographic} type, the supplied height is a height above the
     * reference ellipsoid (such as {@link Ellipsoid#WGS84()}) rather than an
     * altitude above mean sea level. In other words, it will not necessarily be 0.0
     * if sampled in the ocean.
     *
     * @param terrainProvider The terrain provider from which to query heights.
     * @param level           The terrain level-of-detail from which to query
     *                        terrain heights.
     * @param positions       The positions to update with terrain heights.
     * @return A promise that resolves to the provided list of positions when
     * terrain the query has completed.
     */
    @JsMethod(namespace = "Cesium", name = "sampleTerrain")
    public static native Promise<Cartographic[], Void> sampleTerrain(TerrainProvider terrainProvider, int level,
                                                                     Cartographic[] positions);

    /**
     * Create a Command from a given function, for use with ViewModels. A Command is
     * a function with an extra canExecute observable property to determine whether
     * the command can be executed. When executed, a Command function will check the
     * value of canExecute and throw if false. It also provides events for when a
     * command has been or is about to be executed.
     *
     * @param func The function to execute.
     * @return Command function
     */
    @JsMethod(namespace = "Cesium", name = "createCommand")
    public static native Command createCommand(Function func);

    /**
     * Create a Command from a given function, for use with ViewModels. A Command is
     * a function with an extra canExecute observable property to determine whether
     * the command can be executed. When executed, a Command function will check the
     * value of canExecute and throw if false. It also provides events for when a
     * command has been or is about to be executed.
     *
     * @param func       The function to execute.
     * @param canExecute A boolean indicating whether the function can currently be
     *                   executed.
     * @return Command function
     */
    @JsMethod(namespace = "Cesium", name = "createCommand")
    public static native Command createCommand(Function func, boolean canExecute);

    /**
     * A browser-independent function to request a new animation frame. This is used
     * to create an application's draw loop as shown in the example below.
     *
     * @param callback The function to call when the next frame should be drawn.
     * @return An ID that can be passed to {@link #cancelAnimationFrame} to cancel
     * the request.
     */
    // TODO Example
    @JsMethod(namespace = "Cesium", name = "requestAnimationFrame")
    public static native Number requestAnimationFrame(RequestAnimationFrameCallback callback);

    /**
     * A browser-independent function to cancel an animation frame requested using
     * requestAnimationFrame.
     *
     * @param requestID The value returned by requestAnimationFrame.
     */
    @JsMethod(namespace = "Cesium", name = "cancelAnimationFrame")
    public static native void cancelAnimationFrame(Number requestID);

    /**
     * Initiates a sampleTerrain() request at the maximum available tile level for a
     * terrain dataset.
     *
     * @param terrainProvider The terrain provider from which to query heights.
     * @param positions       The positions to update with terrain heights.
     * @return A promise that resolves to the provided list of positions when
     * terrain the query has completed. This promise will reject if the
     * terrain provider's `availability` property is undefined.
     *
     * <pre>
     *     Example:
     *     {@code
     *     CesiumTerrainProviderOptions options = new CesiumTerrainProviderOptions();
     *     options.url = "https://assets.agi.com/stk-terrain/world";
     *     CesiumTerrainProvider terrainProvider = new CesiumTerrainProvider(options);
     *     Cartographic[] positions = new Cartographic[] {Cartographic.fromDegrees(86.925145, 27.988257), Cartographic.fromDegrees(87.0, 28.0)};
     *     Promise<Cartographic[], Void> promise = Cesium.sampleTerrainMostDetailed(terrainProvider, positions);
     *     promise.then(new Fulfill<Cartographic[]>() {
     *         {@literal @}Override
     *         public void onFulfilled(Cartographic[] updatedPositions) {
     *             //
     *         }
     *     });
     *     }
     *         </pre>
     */
    @JsMethod(namespace = "Cesium", name = "sampleTerrainMostDetailed")
    public static native Promise<Cartographic[], Void> sampleTerrainMostDetailed(TerrainProvider terrainProvider,
                                                                                 Cartographic[] positions);

    // TODO: Example

    /**
     * Destroys an object. Each of the object's functions, including functions in
     * its prototype, is replaced with a function that throws a DeveloperError,
     * except for the object's isDestroyed function, which is set to a function that
     * returns true. The object's properties are removed with delete.
     * <p>
     * This function is used by objects that hold native resources, e.g., WebGL
     * resources, which need to be
     * <p>
     * explicitly released. Client code calls an object's destroy function, which
     * then releases the native resource and calls destroyObject to put itself in a
     * destroyed state.
     *
     * @param object The object to destroy.
     */
    @JsMethod(namespace = "Cesium", name = "destroyObject")
    public static native void destroyObject(Object object);

    // TODO: Example

    /**
     * Destroys an object. Each of the object's functions, including functions in
     * its prototype, is replaced with a function that throws a DeveloperError,
     * except for the object's isDestroyed function, which is set to a function that
     * returns true. The object's properties are removed with delete.
     * <p>
     * This function is used by objects that hold native resources, e.g., WebGL
     * resources, which need to be
     * <p>
     * explicitly released. Client code calls an object's destroy function, which
     * then releases the native resource and calls destroyObject to put itself in a
     * destroyed state.
     *
     * @param object  The object to destroy.
     * @param message The message to include in the exception that is thrown if a
     *                destroyed object's function is called.
     */
    @JsMethod(namespace = "Cesium", name = "destroyObject")
    public static native void destroyObject(Object object, String message);

    /**
     * Creates a {@link CesiumTerrainProvider} instance for the
     * <a href="https://cesium.com/content/cesiumworldterrain">Cesium World
     * Terrain</a>.
     *
     * @return {@link CesiumTerrainProvider} instance for the
     * <a href="https://cesium.com/content/cesiumworldterrain">Cesium World
     * Terrain</a>.
     */
    @JsMethod(namespace = "Cesium", name = "createWorldTerrain")
    public static native CesiumTerrainProvider createWorldTerrain();

    /**
     * Creates a {@link CesiumTerrainProvider} instance for the
     * <a href="https://cesium.com/content/cesiumworldterrain">Cesium World
     * Terrain</a>.
     *
     * @param options {@link CreateWorldTerrainOptions} object.
     * @return {@link CesiumTerrainProvider} instance for the
     * <a href="https://cesium.com/content/cesiumworldterrain">Cesium World
     * Terrain</a>.
     */
    @JsMethod(namespace = "Cesium", name = "createWorldTerrain")
    public static native CesiumTerrainProvider createWorldTerrain(CreateWorldTerrainOptions options);

    /**
     * Exports an EntityCollection as a KML document. Only Point, Billboard, Model,
     * Path, Polygon, Polyline geometries will be exported. Note that there is not a
     * 1 to 1 mapping of Entity properties to KML Feature properties. For example,
     * entity properties that are time dynamic but cannot be dynamic in KML are
     * exported with their values at options.time or the beginning of the
     * EntityCollection's time interval if not specified. For time-dynamic
     * properties that are supported in KML, we use the samples if it is a
     * {@link org.cesiumjs.cs.datasources.properties.SampledProperty} otherwise we
     * sample the value using the options.sampleDuration. Point, Billboard, Model
     * and Path geometries with time-dynamic positions will be exported as gx:Track
     * Features. Not all Materials are representable in KML, so for more advanced
     * Materials just the primary color is used. Canvas objects are exported as PNG
     * images.
     *
     * @param options object with properties
     * @return A promise that resolved to an object containing the KML string and a
     * dictionary of external file blobs, or a kmz file as a blob if
     * options.kmz is true.
     */
    @JsMethod(namespace = "Cesium", name = "exportKml")
    public static native Promise<JsObject, Void> exportKml(ExportKmlOptions options);

    /**
     * Creates a Material that combines multiple layers of color/gradient bands and maps them to terrain heights.
     * The shader does a binary search over all the heights to find out which colors are above and below a given height,
     * and interpolates between them for the final color. This material supports hundreds of entries relatively cheaply.
     *
     * @param options {@link ElevationBandMaterialOptions} with the following properties
     * @return A new Material instance.
     */
    @JsMethod(namespace = "Cesium", name = "createElevationBandMaterial")
    public static native Material createElevationBandMaterial(ElevationBandMaterialOptions options);

    /**
     * Creates a Cesium3DTileset instance for the Cesium OSM Buildings tileset.
     * @return Cesium3DTileset instance
     */
    @JsMethod(namespace = "Cesium", name = "createOsmBuildings")
    public static native Cesium3DTileset createOsmBuildings();

    /**
     * Creates a Cesium3DTileset instance for the Cesium OSM Buildings tileset.
     * @param options parameters
     * @return Cesium3DTileset instance
     */
    @JsMethod(namespace = "Cesium", name = "createOsmBuildings")
    public static native Cesium3DTileset createOsmBuildings(CreateOsmBuildingsOptions options);

    @JsFunction
    public interface Function {
        Object function(Object... args);
    }

    @JsFunction
    public interface RequestAnimationFrameCallback {
        /**
         * A function that will be called when the next frame should be drawn.
         *
         * @param timestamp A timestamp for the frame, in milliseconds.
         */
        @SuppressWarnings("unusable-by-js")
        void Callback(Number timestamp);
    }

    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    public static class CreateWorldTerrainOptions {
        /**
         * Flag that indicates if the client should request additional lighting
         * information from the server if available. Default: false
         */
        @JsProperty
        public boolean requestVertexNormals;
        /**
         * Flag that indicates if the client should request per tile water masks from
         * the server if available. Default: false
         */
        @JsProperty
        public boolean requestWaterMask;

        @JsConstructor
        public CreateWorldTerrainOptions() {
        }

        /**
         * Create instance for {@link Cesium#createWorldTerrain()}.
         *
         * @param requestVertexNormals Flag that indicates if the client should request
         *                             additional lighting information from the server
         *                             if available.
         * @return instance for {@link Cesium#createWorldTerrain()}.
         */
        @JsOverlay
        public static CreateWorldTerrainOptions create(boolean requestVertexNormals) {
            CreateWorldTerrainOptions options = new CreateWorldTerrainOptions();
            options.requestVertexNormals = requestVertexNormals;
            return options;
        }

        /**
         * Create instance for {@link Cesium#createWorldTerrain()}.
         *
         * @param requestVertexNormals Flag that indicates if the client should request
         *                             additional lighting information from the server
         *                             if available.
         * @param requestWaterMask     Flag that indicates if the client should request
         *                             per tile water masks from the server if
         *                             available.
         * @return instance for {@link Cesium#createWorldTerrain()}.
         */
        @JsOverlay
        public static CreateWorldTerrainOptions create(boolean requestVertexNormals, boolean requestWaterMask) {
            CreateWorldTerrainOptions options = new CreateWorldTerrainOptions();
            options.requestVertexNormals = requestVertexNormals;
            options.requestWaterMask = requestWaterMask;
            return options;
        }
    }

    /**
     * Options for {@link Cesium#exportKml(ExportKmlOptions)}
     */
    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    public static class ExportKmlOptions {
        /**
         * The EntityCollection to export as KML.
         */
        @JsProperty
        public EntityCollection entities;
        /**
         * The ellipsoid for the output file. Default: {@link Ellipsoid#WGS84()}
         */
        @JsProperty
        public Ellipsoid ellipsoid;
        /**
         * A callback that will be called with a ModelGraphics instance and should
         * return the URI to use in the KML. Required if a model exists in the entity
         * collection.
         */
        @JsProperty
        public ModelCallback modelCallback;
        /**
         * The time value to use to get properties that are not time varying in KML.
         */
        @JsProperty
        public JulianDate time;
        /**
         * The interval that will be sampled if an entity doesn't have an availability.
         */
        @JsProperty
        public TimeInterval defaultAvailability;
        /**
         * The number of seconds to sample properties that are varying in KML. Default:
         * 60
         */
        @JsProperty
        public int sampleDuration;
        /**
         * If true KML and external files will be compressed into a kmz file. Default:
         * false
         */
        @JsProperty
        public boolean kmz;

        @JsConstructor
        private ExportKmlOptions() {
        }

        @JsOverlay
        public static ExportKmlOptions create(EntityCollection entities) {
            ExportKmlOptions options = new ExportKmlOptions();
            options.entities = entities;
            return options;
        }

        /**
         * Since KML does not support glTF models, this callback is required to specify
         * what URL to use for the model in the KML document. It can also be used to add
         * additional files to the externalFiles object, which is the list of files
         * embedded in the exported KMZ, or otherwise returned with the KML string when
         * exporting.
         */
        @JsFunction
        public interface ModelCallback {
            /**
             * Since KML does not support glTF models, this callback is required to specify
             * what URL to use for the model in the KML document. It can also be used to add
             * additional files to the externalFiles object, which is the list of files
             * embedded in the exported KMZ, or otherwise returned with the KML string when
             * exporting.
             *
             * @param model         The ModelGraphics instance for an Entity.
             * @param time          The time that any properties should use to get the
             *                      value.
             * @param externalFiles An object that maps a filename to a Blob or a Promise
             *                      that resolves to a Blob.
             * @return The URL to use for the href in the KML document.
             */
            String Callback(ModelGraphics model, org.cesiumjs.cs.core.JulianDate time, JsObject externalFiles);
        }
    }

    /**
     * Options for {@link Cesium#createElevationBandMaterial(ElevationBandMaterialOptions)}.
     */
    @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
    public static class ElevationBandMaterialOptions {
        /**
         * The scene where the visualization is taking place.
         */
        @JsProperty
        public Scene scene;
        /**
         * A list of bands ordered from lowest to highest precedence.
         */
        @JsProperty
        public ElevationBandMaterialBand[] layers;

        @JsConstructor
        protected ElevationBandMaterialOptions() {
        }

        @JsOverlay
        public static ElevationBandMaterialOptions create(Scene scene, ElevationBandMaterialBand[] layers) {
            ElevationBandMaterialOptions options = new ElevationBandMaterialOptions();
            options.scene = scene;
            options.layers = layers;
            return options;
        }
    }

    /**
     * Flags to enable experimental features in CesiumJS. Stability and performance
     * may not be optimal when these are enabled. Experimental features are subject
     * to change without Cesium's standard deprecation policy.
     * <p>
     * Experimental features must still uphold Cesium's quality standards. Here
     * are some guidelines:
     * </p>
     * <ul>
     *   <li>Experimental features must have high unit test coverage like any other feature.</li>
     *   <li>Experimental features are intended for large features where there is benefit of merging some of the
     *   code sooner (e.g. to avoid long-running staging branches)</li>
     *   <li>Experimental flags should be short-lived. Make it clear in the PR what it would take to promote the
     *   feature to a regular feature.</li>
     *   <li>To avoid cluttering the code, check the flag in as few places as possible. Ideally this would be a single place.</li>
     * </ul>
     *
     * experimental: This feature is using part of the 3D Tiles spec that is not final and is subject to change
     * without Cesium's standard deprecation policy.
     */
    @JsType(isNative = true, namespace = "Cesium", name = "ExperimentalFeatures")
    public static class ExperimentalFeatures {
        /**
         * Toggles the usage of the ModelExperimental class.
         */
        public static boolean enableModelExperimental;
    }
}
