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

import com.google.gwt.dom.client.CanvasElement;
import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.ImageryLayerCollection;
import org.cesiumjs.cs.collections.PrimitiveCollection;
import org.cesiumjs.cs.core.*;
import org.cesiumjs.cs.core.projection.MapProjection;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.scene.enums.SceneMode;
import org.cesiumjs.cs.scene.options.SceneOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Scene")
public class Scene {
    /**
     * The background color, which is only visible if there is no sky box, i.e., Scene#skyBox is undefined.
     * Default: Color.BLACK
     * @see #skyBox
     */
    @JsProperty
    public Color backgroundColor;
    /**
     * Gets the camera.
     */
    @JsProperty(name = "camera")
    public native Camera camera();
    /**
     * Gets the canvas element to which this scene is bound.
     */
    @JsProperty(name = "canvas")
    public native CanvasElement canvas();
    /**
     * Determines whether or not to instantly complete the scene transition animation on user input.
     * Default: true
     */
    @JsProperty
    public boolean completeMorphOnUserInput;
    /**
     * This property is for debugging only; it is not for production use.
     * A function that determines what commands are executed. As shown in the examples below, the function receives the command's owner as an argument, and returns a boolean indicating if the command should be executed.
     *
     * The default is undefined, indicating that all commands are executed.
     *
     * <pre>
     *     Example:
     *     {@code
     *     _viewer.scene().debugCommandFilter = new Scene.DebugCommandFilter() {
     *         @Override
     *         public boolean function(Object object) {
     *             return ((JsObject)object).getObject("owner") == _viewer.scene().skyAtmosphere;
     *         }
     *     };
     *     }
     * </pre>
     *
     * Default: undefined
     */
    @JsProperty
    public DebugCommandFilter debugCommandFilter;
    /**
     * This property is for debugging only; it is not for production use.
     * When Scene.debugShowFrustums is true, this contains properties with statistics about the number of command
     * execute per frustum. totalCommands is the total number of commands executed, ignoring overlap.
     * commandsInFrustums is an array with the number of times commands are executed redundantly, e.g.,
     * how many commands overlap two or three frustums.
     *
     * Default: undefined
     */
    @JsProperty(name = "debugFrustumStatistics")
    public native Object debugFrustumStatistics();
    /**
     * This property is for debugging only; it is not for production use.
     * When true, commands are randomly shaded. This is useful for performance analysis to see what parts of a scene or
     * model are command-dense and could benefit from batching.
     *
     * Default: false
     */
    @JsProperty
    public boolean debugShowCommands;
    /**
     * This property is for debugging only; it is not for production use.
     * Indicates which frustum will have depth information displayed.
     *
     * Default:  1
     */
    @JsProperty
    public int debugShowDepthFrustum;
    /**
     * This property is for debugging only; it is not for production use.
     * Displays frames per second and time between frames.
     *
     * Default: false
     */
    @JsProperty
    public boolean debugShowFramesPerSecond;
    /**
     * This property is for debugging only; it is not for production use.
     * When true, commands are shaded based on the frustums they overlap. Commands in the closest frustum are tinted red,
     * commands in the next closest are green, and commands in the farthest frustum are blue. If a command overlaps more
     * than one frustum, the color components are combined, e.g., a command overlapping the first two frustums is tinted yellow.
     *
     * Default: false
     */
    @JsProperty
    public boolean debugShowFrustums;
    /**
     * This property is for debugging only; it is not for production use.
     * Displays depth information for the indicated frustum
     *
     * Default: false
     */
    @JsProperty
    public boolean debugShowGlobeDepth;

    /**
     * The drawingBufferWidth of the underlying GL context.
     * @see #drawingBufferHeight
     */
    @JsProperty(name = "drawingBufferHeight")
    public native double drawingBufferHeight();

    /**
     * The drawingBufferHeight of the underlying GL context.
     * @see #drawingBufferHeight
     */
    @JsProperty(name = "drawingBufferWidth")
    public native double drawingBufferWidth();
    /**
     * The far-to-near ratio of the multi-frustum. The default is 1,000.0.
     * Default: 1000.0
     */
    @JsProperty
    public double farToNearRatio;
    /**
     * Blends the atmosphere to geometry far from the camera for horizon views. Allows for additional performance
     * improvements by rendering less geometry and dispatching less terrain requests.
     */
    @JsProperty
    public Fog fog;
    /**
     * When true, enables Fast Approximate Anti-aliasing even when order independent translucency is unsupported.
     * Default:  true
     */
    @JsProperty
    public boolean fxaa;
    /**
     * Gets or sets the depth-test ellipsoid.
     */
    @JsProperty
    public Globe globe;
    /**
     * Gets the collection of ground primitives.
     */
    @JsProperty(name = "groundPrimitives")
    public native PrimitiveCollection groundPrimitives();
    /**
     * Gets the unique identifier for this scene.
     */
    @JsProperty(name = "id")
    public native String id();
    /**
     * Gets the collection of imagery layers that will be rendered on the globe.
     */
    @JsProperty(name = "imageryLayers")
    public native ImageryLayerCollection imageryLayers();
    /**
     * Gets or sets the position of the Imagery splitter within the viewport. Valid values are between 0.0 and 1.0.
     */
    @JsProperty
    public double imagerySplitPosition;
    /**
     * Determines if the 2D map is rotatable or can be scrolled infinitely in the horizontal direction.
     */
    @JsProperty
    public boolean mapMode2D;
    /**
     * Get the map projection to use in 2D and Columbus View modes.
     * Default: {@link org.cesiumjs.cs.core.projection.GeographicProjection}
     */
    @JsProperty(name = "mapProjection")
    public native MapProjection mapProjection();
    /**
     * The maximum aliased line width, in pixels, supported by this WebGL implementation. It will be at least one.
     */
    @JsProperty(name = "maximumAliasedLineWidth")
    public native int maximumAliasedLineWidth();
    /**
     * The maximum length in pixels of one edge of a cube map, supported by this WebGL implementation. It will be at least 16.
     */
    @JsProperty(name = "maximumCubeMapSize")
    public native int maximumCubeMapSize();
    /**
     * Gets or sets the current mode of the scene.
     * Default: {@link SceneMode#SCENE3D()}
     */
    @JsProperty
    public Number mode;
    /**
     * The Moon
     * Default:  undefined
     */
    @JsProperty
    public Moon moon;
    /**
     * The event fired at the completion of a scene transition.
     * Default: Event()
     */
    @JsProperty
    public Event morphComplete;
    /**
     * The event fired at the beginning of a scene transition.
     * Default: Event()
     */
    @JsProperty
    public Event morphStart;
    /**
     * The current morph transition time between 2D/Columbus View and 3D, with 0.0 being 2D or Columbus View and 1.0 being 3D.
     * Default: 1.0
     */
    @JsProperty
    public double morphTime;
    /**
     * Determines the uniform depth size in meters of each frustum of the multifrustum in 2D.
     * If a primitive or model close to the surface shows z-fighting, decreasing this will eliminate the artifact,
     * but decrease performance. On the other hand, increasing this will increase performance but may cause z-fighting
     * among primitives close to thesurface.
     * Default: 1.75e6
     */
    public double nearToFarDistance2D;
    /**
     * Gets whether or not the scene has order independent translucency enabled. Note that this only reflects the original
     * construction option, and there are other factors that could prevent OIT from functioning on a given system configuration.
     */
    @JsProperty(name = "orderIndependentTranslucency")
    public native boolean orderIndependentTranslucency();
    /**
     * Returns true if the pickPosition function is supported.
     */
    @JsProperty(name = "pickPositionSupported")
    public native boolean pickPositionSupported();
    /**
     * When true, enables picking translucent geometry using the depth buffer. {@link Scene#useDepthPicking} must also be
     * true to enable picking the depth buffer. There is a decrease in performance when enabled. There are extra draw
     * calls to write depth for translucent geometry.
     * Default: false
     */
    @JsProperty
    public boolean pickTranslucentDepth;
    /**
     * Gets the event that will be raised at the end of each call to render. Subscribers to the event receive the Scene
     * instance as the first parameter and the current time as the second parameter.
     */
    @JsProperty(name = "postRender")
    public native Event postRender();
    /**
     * Gets the event that will be raised at the start of each call to render. Subscribers to the event receive the Scene
     * instance as the first parameter and the current time as the second parameter.
     */
    @JsProperty(name = "preRender")
    public native Event preRender();
    /**
     * Gets the collection of primitives.
     */
    @JsProperty(name = "primitives")
    public native PrimitiveCollection primitives();
    /**
     * Gets the event that will be raised when an error is thrown inside the render function.
     * The Scene instance and the thrown error are the only two parameters passed to the event handler.
     * By default, errors are not rethrown after this event is raised, but that can be changed by setting the rethrowRenderErrors property.
     */
    @JsProperty(name = "renderError")
    public native Event renderError();
    /**
     * Exceptions occurring in render are always caught in order to raise the renderError event.
     * If this property is true, the error is rethrown after the event is raised. If this property is false,
     * the render function returns normally after raising the event.
     * Default: false
     */
    @JsProperty
    public boolean rethrowRenderErrors;
    /**
     * Gets whether or not the scene is optimized for 3D only viewing.
     */
    @JsProperty(name = "scene3DOnly")
    public native boolean scene3DOnly();
    /**
     * Gets the controller for camera input handling.
     */
    @JsProperty(name = "screenSpaceCameraController")
    public native ScreenSpaceCameraController screenSpaceCameraController();
    /**
     * The shadow map in the scene. When enabled, models, primitives, and the globe may cast and receive shadows.
     * By default the light source of the shadow map is the sun.
     */
    @JsProperty
    public ShadowMap shadowMap;
    /**
     * The sky atmosphere drawn around the globe.
     * Default:  undefined
     */
    @JsProperty
    public SkyAtmosphere skyAtmosphere;
    /**
     * The SkyBox used to draw the stars.
     * Default: undefined
     * @see #backgroundColor
     */
    @JsProperty
    public SkyBox skyBox;
    /**
     * The Sun.
     * Default: undefined
     */
    @JsProperty
    public Sun sun;
    /**
     * Uses a bloom filter on the sun when enabled.
     * Default: true
     */
    @JsProperty
    public boolean sunBloom;
    /**
     * Gets the scalar used to exaggerate the terrain.
     */
    @JsProperty
    public double terrainExaggeration;
    /**
     * The terrain provider providing surface geometry for the globe.
     */
    @JsProperty
    public TerrainProvider terrainProvider;
    /**
     * Gets an event that's raised when the terrain provider is changed
     */
    @JsProperty(name = "terrainProviderChanged")
    public native Event terrainProviderChanged();
    /**
     * When true, enables picking using the depth buffer.
     * Default: true
     */
    @JsProperty
    public boolean useDepthPicking;
    /**
     * When true, splits the scene into two viewports with steroscopic views for the left and right eyes. Used for cardboard and WebVR.
     * Default Value:  false
     */
    @JsProperty
    public boolean useWebVR;

    /**
     * The container for all 3D graphical objects and state in a Cesium virtual scene. Generally,
     * a scene is not created directly; instead, it is implicitly created by CesiumWidget.
     */
    @JsConstructor
    public Scene() {}

    /**
     * The container for all 3D graphical objects and state in a Cesium virtual scene. Generally,
     * a scene is not created directly; instead, it is implicitly created by CesiumWidget.
     * @param options Options.
     */
    @JsConstructor
    public Scene(SceneOptions options) {}

    /**
     * Instantly completes an active transition.
     */
    @JsMethod
    public native void completeMorph();

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed()
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns a list of objects, each containing a `primitive` property, for all primitives at a particular
     * window coordinate position.
     * Other properties may also be set depending on the type of primitive. The primitives in the list are ordered by
     * their visual order in the scene (front to back).
     * @param windowPosition Window coordinates to perform picking on.
     * @return Array of objects, each containing 1 picked primitives.
     */
    @JsMethod
    public native PickedObject[] drillPick(Cartesian2 windowPosition);

    /**
     * Returns a list of objects, each containing a `primitive` property, for all primitives at a particular
     * window coordinate position.
     * Other properties may also be set depending on the type of primitive. The primitives in the list are ordered by
     * their visual order in the scene (front to back).
     * <pre>
     *     Example:
     *     {@code
     *     Object[] pickedObjects = scene.drillPick(new Cartesian2(100.0, 200.0));
     *     }
     * </pre>
     * @param windowPosition Window coordinates to perform picking on.
     * @param limit If supplied, stop drilling after collecting this many picks.
     * @return Array of objects, each containing 1 picked primitives.
     */
    @JsMethod
    public native PickedObject[] drillPick(Cartesian2 windowPosition, double limit);

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will
     * result in a DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Asynchronously transitions the scene to 2D.
     */
    @JsMethod
    public native void morphTo2D();

    /**
     * Asynchronously transitions the scene to 2D.
     * @param duration The amount of time, in seconds, for transition animations to complete. Default: 2.0
     */
    @JsMethod
    public native void morphTo2D(double duration);

    /**
     * Asynchronously transitions the scene to 3D.
     */
    @JsMethod
    public native void morphTo3D();

    /**
     * Asynchronously transitions the scene to 3D.
     * @param duration The amount of time, in seconds, for transition animations to complete. Default: 2.0
     */
    @JsMethod
    public native void morphTo3D(double duration);

    /**
     * Asynchronously transitions the scene to Columbus View.
     */
    @JsMethod
    public native void morphToColumbusView();

    /**
     * Asynchronously transitions the scene to Columbus View.
     * @param duration The amount of time, in seconds, for transition animations to complete. Default: 2.0
     */
    @JsMethod
    public native void morphToColumbusView(double duration);

    /**
     * Returns an object with a `primitive` property that contains the first (top) primitive in the scene at a particular
     * window coordinate or undefined if nothing is at the location. Other properties may potentially
     * be set depending on the type of primitive.
     * @param windowPosition Window coordinates to perform picking on.
     * @return Object containing the picked primitive.
     */
    @JsMethod
    public native PickedObject pick(Cartesian2 windowPosition);

    /**
     * Returns the cartesian position reconstructed from the depth buffer and window position.
     * @param windowPosition Window coordinates to perform picking on.
     * @return The cartesian position.
     */
    @JsMethod
    public native Cartesian3 pickPosition(Cartesian2 windowPosition);

    /**
     * Returns the cartesian position reconstructed from the depth buffer and window position.
     * @param windowPosition Window coordinates to perform picking on.
     * @param result The object on which to restore the result.
     * @return The cartesian position.
     */
    @JsMethod
    public native Cartesian3 pickPosition(Cartesian2 windowPosition, Cartesian3 result);

    @JsFunction
    public interface Listener {
        void function(Scene scene, JulianDate time);
    }

    @JsFunction
    public interface DebugCommandFilter {
        boolean function(Object object);
    }
}
