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

package org.cesiumjs.cs.widgets;

import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;
import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.DataSourceCollection;
import org.cesiumjs.cs.collections.EntityCollection;
import org.cesiumjs.cs.collections.ImageryLayerCollection;
import org.cesiumjs.cs.core.Clock;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.core.HeadingPitchRange;
import org.cesiumjs.cs.core.ScreenSpaceEventHandler;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.datasources.DataSource;
import org.cesiumjs.cs.datasources.DataSourceDisplay;
import org.cesiumjs.cs.datasources.Entity;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.Camera;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.ShadowMap;
import org.cesiumjs.cs.widgets.options.FlyToOptions;
import org.cesiumjs.cs.widgets.options.ViewerOptions;

/**
 * A base widget for building applications. It composites all of the standard Cesium widgets into one reusable package.
 * The widget can always be extended by using mixins, which add functionality useful for a variety of applications.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Viewer")
public class Viewer {
    /**
     * Gets or sets whether or not data sources can temporarily pause animation in order to avoid showing an incomplete
     * picture to the user. For example, if asynchronous primitives are being processed in the background,
     * the clock will not advance until the geometry is ready.
     */
    @JsProperty
    public boolean allowDataSourcesToSuspendAnimation;
    /**
     * Gets the Animation widget.
     */
    @JsProperty(name = "animation")
    public native Animation animation();
    /**
     * Gets the BaseLayerPicker.
     */
    //TODO: Later
//    @JsProperty(name = "baseLayerPicker")
//    public native BaseLayerPicker baseLayerPicker();
    /**
     * Gets the DOM element for the area at the bottom of the window containing the CreditDisplay and potentially other things.
     */
    @JsProperty(name = "bottomContainer")
    public native Element bottomContainer();
    /**
     * Gets the camera.
     */
    @JsProperty
    public Camera camera;
    /**
     * Gets the canvas.
     */
    @JsProperty(name = "canvas")
    public native CanvasElement canvas();
    /**
     * Gets the Cesium logo element.
     */
    @JsProperty(name = "cesiumLogo")
    public native Element cesiumLogo();
    /**
     * Gets the CesiumWidget.
     */
    @JsProperty
    public CesiumWidget cesiumWidget;
    /**
     * Gets the clock.
     */
    @JsProperty(name = "clock")
    public native Clock clock();

    /**
     * Gets the clock view model.
     * @return clock view model.
     */
    @JsProperty(name = "clockViewModel")
    public native ClockViewModel clockViewModel();
    /**
     * Gets the parent container.
     */
    @JsProperty(name = "container")
    public native Element container();
    /**
     * Gets the display used for DataSource visualization.
     */
    //TODO: Later
    @JsProperty(name = "dataSourceDisplay")
    public native DataSourceDisplay dataSourceDisplay();
    /**
     * Gets the set of DataSource instances to be visualized.
     */
    @JsProperty(name = "dataSources")
    public native DataSourceCollection dataSources();
    /**
     * Gets the collection of entities not tied to a particular data source.
     * This is a shortcut to dataSourceDisplay.defaultDataSource.entities.
     */
    @JsProperty(name = "entities")
    public native EntityCollection entities();
    /**
     * Gets the FullscreenButton.
     */
    //TODO: Later
//    @JsProperty(name = "fullscreenButton")
//    public native FullscreenButton fullscreenButton();
    /**
     * Gets the Geocoder.
     */
    //TODO: Later
    @JsProperty(name = "geocoder")
    public native JsObject geocoder();
    /**
     * Gets the HomeButton.
     */
    //TODO: Later
//    @JsProperty(name = "homeButton")
//    public native HomeButton homeButton();
    /**
     * Gets the collection of imagery layers that will be rendered on the globe.
     */
    @JsProperty(name = "imageryLayers")
    public native ImageryLayerCollection imageryLayers();
    /**
     * Gets the info box.
     */
    @JsProperty(name = "infoBox")
    public native InfoBox infoBox();
    /**
     * Gets the NavigationHelpButton.
     */
    //TODO: Later
//    @JsProperty(name = "navigationHelpButton")
//    public native NavigationHelpButton navigationHelpButton();
    //TODO: ProjectionPicker
//    @JsProperty(name = "projectionPicker")
//    public native ProjectionPicker projectionPicker();
    /**
     * Gets or sets a scaling factor for rendering resolution. Values less than 1.0 can improve performance on
     * less powerful devices while values greater than 1.0 will render at a higher resolution and then scale down,
     * resulting in improved visual fidelity. For example, if the widget is laid out at a size of 640x480,
     * setting this value to 0.5 will cause the scene to be rendered at 320x240 and then scaled up while setting it to
     * 2.0 will cause the scene to be rendered at 1280x960 and then scaled down.
     * Default: 1.0
     */
    @JsProperty
    public double resolutionScale;
    /**
     * Gets the scene.
     */
    @JsProperty(name = "scene")
    public native Scene scene();
    /**
     * Gets the SceneModePicker.
     */
    //TODO: Later
//    @JsProperty(name = "sceneModePicker")
//    public native SceneModePicker sceneModePicker();
    /**
     * Gets the screen space event handler.
     */
    @JsProperty(name = "screenSpaceEventHandler")
    public native ScreenSpaceEventHandler screenSpaceEventHandler();
    /**
     * Gets or sets the object instance for which to display a selection indicator.
     */
    @JsProperty
    public Entity selectedEntity;
    /**
     * Gets the event that is raised when the selected entity chages
     * @return
     */
    @JsProperty(name = "selectedEntityChanged")
    public native Event selectedEntityChanged();
    /**
     * Gets the selection indicator.
     */
    @JsProperty(name = "selectionIndicator")
    public native SelectionIndicator selectionIndicator();
    /**
     * Get the scene's shadow map
     */
    @JsProperty(name = "shadowMap")
    public native ShadowMap shadowMap();
    /**
     * Determines if shadows are cast by the sun.
     */
    @JsProperty
    public boolean shadows;
    /**
     * Gets or sets the target frame rate of the widget when useDefaultRenderLoop is true.
     * If undefined, the browser's requestAnimationFrame implementation determines the frame rate.
     * If defined, this value must be greater than 0. A value higher than the underlying requestAnimationFrame
     * implementation will have no effect.
     */
    @JsProperty
    public double targetFrameRate;
    /**
     * The terrain provider providing surface geometry for the globe.
     */
    @JsProperty
    public TerrainProvider terrainProvider;
    /**
     * Determines if the terrain casts or shadows from the sun.
     */
    @JsProperty
    public Number terrainShadows;
    /**
     * Gets the Timeline widget.
     */
    @JsProperty(name = "timeline")
    public native Timeline timeline();
    /**
     * Gets or sets the Entity instance currently being tracked by the camera.
     */
    @JsProperty(name = "trackedEntity")
    public Entity trackedEntity;

    /**
     * Gets the event that is raised when the tracked entity chages
     * @return get event for change tracked entity.
     */
    @JsProperty(name = "trackedEntityChanged")
    public native Event trackedEntityChanged();
    /**
     * Gets or sets whether or not this widget should control the render loop. If set to true the widget will use
     * requestAnimationFrame to perform rendering and resizing of the widget, as well as drive the simulation clock.
     * If set to false, you must manually call the resize, render methods as part of a custom render loop.
     * If an error occurs during rendering, Scene's renderError event will be raised and this property will be set to false.
     * It must be set back to true to continue rendering after the error.
     * Default: true
     */
    @JsProperty
    public boolean useDefaultRenderLoop;
    /**
     * Gets the VRButton.
     */
    //TODO: Later
//    @JsProperty(name = "vrButton")
//    public native VRButton vrButton();
    @JsProperty
    public Cesium3DTilesInspector cesium3DTilesInspector;

    /**
     * A base widget for building applications. It composites all of the standard Cesium widgets into one reusable package.
     * The widget can always be extended by using mixins, which add functionality useful for a variety of applications.
     * @param element The DOM element or ID that will contain the widget.
     */
    @JsConstructor
    public Viewer(Element element) {}

    /**
     * A base widget for building applications. It composites all of the standard Cesium widgets into one reusable package.
     * The widget can always be extended by using mixins, which add functionality useful for a variety of applications.
     * @param element The DOM element or ID that will contain the widget.
     */
    @JsConstructor
    public Viewer(String element) {}

    /**
     * A base widget for building applications. It composites all of the standard Cesium widgets into one reusable package.
     * The widget can always be extended by using mixins, which add functionality useful for a variety of applications.
     * @param element The DOM element or ID that will contain the widget.
     * @param options Options.
     */
    @JsConstructor
    public Viewer(Element element, ViewerOptions options) {}

    /**
     * A base widget for building applications. It composites all of the standard Cesium widgets into one reusable package.
     * The widget can always be extended by using mixins, which add functionality useful for a variety of applications.
     * @param element The DOM element or ID that will contain the widget.
     * @param options {@link ViewerOptions}
     */
    @JsConstructor
    public Viewer(String element, ViewerOptions options) {}

    /**
     * Destroys the widget. Should be called if permanently removing the widget from layout.
     */
    @JsMethod
    public native void destroy();

    /**
     * Extends the base viewer functionality with the provided mixin. A mixin may add additional properties, functions,
     * or other behavior to the provided viewer instance.
     * @param mixin The Viewer mixin to add to this instance.
     */
    @JsMethod
    public native void extend(Object mixin);

    /**
     * Extends the base viewer functionality with the provided mixin. A mixin may add additional properties, functions,
     * or other behavior to the provided viewer instance.
     * @param mixin The Viewer mixin to add to this instance.
     * @param options The options object to be passed to the mixin function.
     */
    @JsMethod
    public native void extend(Object mixin, Object options);

    /**
     * Flies the camera to the provided entity, entities, or data source. If the data source is still in the process of
     * loading or the visualization is otherwise still loading, this method waits for the data to be ready before performing the flight.
     * The offset is heading/pitch/range in the local east-north-up reference frame centered at the center of the bounding sphere.
     * The heading and the pitch angles are defined in the local east-north-up reference frame. The heading is the
     * angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     * The range is the distance from the center. If the range is zero, a range will be computed such that the whole bounding sphere is visible.
     *
     * In 2D, there must be a top down view. The camera will be placed above the target looking down.
     * The height above the target will be the range. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param target The entity, array of entities, entity collection, data source or imagery layer to view.
     *               You can also pass a promise that resolves to one of the previously mentioned types.
     * @return A Promise that resolves to true if the flight was successful or false if the entity is not currently visualized in the scene or the flight was cancelled.
     */
    //TODO: Promise
    public native Promise<Boolean, Void> flyTo(Object target);

    /**
     * Flies the camera to the provided entity, entities, or data source. If the data source is still in the process of
     * loading or the visualization is otherwise still loading, this method waits for the data to be ready before performing the flight.
     * The offset is heading/pitch/range in the local east-north-up reference frame centered at the center of the bounding sphere.
     * The heading and the pitch angles are defined in the local east-north-up reference frame. The heading is the
     * angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     * The range is the distance from the center. If the range is zero, a range will be computed such that the whole bounding sphere is visible.
     *
     * In 2D, there must be a top down view. The camera will be placed above the target looking down.
     * The height above the target will be the range. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param target The entity, array of entities, entity collection, data source or imagery layer to view.
     *               You can also pass a promise that resolves to one of the previously mentioned types.
     * @param options Options.
     * @return A Promise that resolves to true if the flight was successful or false if the entity is not currently visualized in the scene or the flight was cancelled.
     */
    @JsMethod
    public native Promise<Boolean, Void> flyTo(Object target, FlyToOptions options);

    /**
     * This forces the widget to re-think its layout, including widget sizes and credit placement.
     */
    @JsMethod
    public native void forceResize();

    /**
     *
     * @return  true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Renders the scene. This function is called automatically unless useDefaultRenderLoop is set to false;
     */
    @JsMethod
    public native void render();

    /**
     * Resizes the widget to match the container size. This function is called automatically as needed unless
     * useDefaultRenderLoop is set to false.
     */
    @JsMethod
    public native void resize();

    /**
     * Asynchronously sets the camera to view the provided entity, entities, or data source. If the data source is
     * still in the process of loading or the visualization is otherwise still loading, this method waits for the data
     * to be ready before performing the zoom.
     * The offset is heading/pitch/range in the local east-north-up reference frame centered at the center of the bounding sphere.
     * The heading and the pitch angles are defined in the local east-north-up reference frame. The heading is the
     * angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     * The range is the distance from the center. If the range is zero, a range will be computed such that the whole bounding sphere is visible.
     *
     * In 2D, there must be a top down view. The camera will be placed above the target looking down.
     * The height above the target will be the range. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param target The entity, array of entities, entity collection, data source or imagery layer to view.
     *               You can also pass a promise that resolves to one of the previously mentioned types.
     * @return
     */
    @JsMethod
    public native Promise<Boolean, Void> zoomTo(EntityCollection target);

    /**
     * Asynchronously sets the camera to view the provided entity, entities, or data source. If the data source is
     * still in the process of loading or the visualization is otherwise still loading, this method waits for the data
     * to be ready before performing the zoom.
     * The offset is heading/pitch/range in the local east-north-up reference frame centered at the center of the bounding sphere.
     * The heading and the pitch angles are defined in the local east-north-up reference frame. The heading is the
     * angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     * The range is the distance from the center. If the range is zero, a range will be computed such that the whole bounding sphere is visible.
     *
     * In 2D, there must be a top down view. The camera will be placed above the target looking down.
     * The height above the target will be the range. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param target The entity, array of entities, entity collection, data source or imagery layer to view.
     *               You can also pass a promise that resolves to one of the previously mentioned types.
     * @return
     */
    @JsMethod
    public native Promise<Boolean, Void> zoomTo(Entity target);

    @JsMethod
    public native Promise<Boolean, Void> zoomTo(Promise<DataSource, String> target);

    @JsMethod
    public native Promise<Boolean, Void> zoomTo(DataSource target);

    /**
     * Asynchronously sets the camera to view the provided entity, entities, or data source. If the data source is
     * still in the process of loading or the visualization is otherwise still loading, this method waits for the data
     * to be ready before performing the zoom.
     * The offset is heading/pitch/range in the local east-north-up reference frame centered at the center of the bounding sphere.
     * The heading and the pitch angles are defined in the local east-north-up reference frame. The heading is the
     * angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     * The range is the distance from the center. If the range is zero, a range will be computed such that the whole bounding sphere is visible.
     *
     * In 2D, there must be a top down view. The camera will be placed above the target looking down.
     * The height above the target will be the range. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param target The entity, array of entities, entity collection, data source or imagery layer to view.
     *               You can also pass a promise that resolves to one of the previously mentioned types.
     * @param offset The offset from the center of the entity in the local east-north-up reference frame.
     * @return A Promise that resolves to true if the zoom was successful or false if the entity is not currently
     * visualized in the scene or the zoom was cancelled.
     */
    @JsMethod
    public native Promise<Boolean, Void> zoomTo(EntityCollection target, HeadingPitchRange offset);

    /**
     * Asynchronously sets the camera to view the provided entity, entities, or data source. If the data source is
     * still in the process of loading or the visualization is otherwise still loading, this method waits for the data
     * to be ready before performing the zoom.
     * The offset is heading/pitch/range in the local east-north-up reference frame centered at the center of the bounding sphere.
     * The heading and the pitch angles are defined in the local east-north-up reference frame. The heading is the
     * angle from y axis and increasing towards the x axis. Pitch is the rotation from the xy-plane.
     * Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     * The range is the distance from the center. If the range is zero, a range will be computed such that the whole bounding sphere is visible.
     *
     * In 2D, there must be a top down view. The camera will be placed above the target looking down.
     * The height above the target will be the range. The heading will be determined from the offset.
     * If the heading cannot be determined from the offset, the heading will be north.
     * @param target The entity, array of entities, entity collection, data source or imagery layer to view.
     *               You can also pass a promise that resolves to one of the previously mentioned types.
     * @param offset The offset from the center of the entity in the local east-north-up reference frame.
     * @return A Promise that resolves to true if the zoom was successful or false if the entity is not currently
     * visualized in the scene or the zoom was cancelled.
     */
    @JsMethod
    public native Promise<Boolean, Void> zoomTo(Object target, HeadingPitchRange offset);

    /**
     * A function that augments a Viewer instance with additional functionality.
     */
    @JsFunction
    public interface ViewerMixin {
        /**
         * A function that augments a Viewer instance with additional functionality.
         * @param viewer The viewer instance.
         * @param object Options object to be passed to the mixin function.
         */
        void function(Viewer viewer, Object object);
    }
}
