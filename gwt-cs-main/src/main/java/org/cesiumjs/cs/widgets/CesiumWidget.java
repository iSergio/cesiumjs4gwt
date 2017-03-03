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
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.ImageryLayerCollection;
import org.cesiumjs.cs.core.Clock;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.scene.Camera;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.widgets.options.CesiumWidgetOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CesiumWidget")
public class CesiumWidget {
    /**
     * Gets the camera.
     */
    @JsProperty(name = "camera")
    public native Camera camera();
    /**
     * Gets the canvas.
     */
    @JsProperty
    public CanvasElement canvas;
    /**
     * Gets the clock.
     */
    @JsProperty
    public Clock clock;
    /**
     * Gets the parent container.
     */
    @JsProperty
    public Element container;
    /**
     * Gets the credit container.
     */
    @JsProperty
    public Element creditContainer;
    /**
     * Gets the collection of imagery layers that will be rendered on the globe.
     */
    @JsProperty(name = "imageryLayers")
    public native ImageryLayerCollection imageryLayers();
    /**
     * Gets or sets a scaling factor for rendering resolution. Values less than 1.0 can improve performance on less
     * powerful devices while values greater than 1.0 will render at a higher resolution and then scale down,
     * resulting in improved visual fidelity. For example, if the widget is laid out at a size of 640x480,
     * setting this value to 0.5 will cause the scene to be rendered at 320x240 and then scaled up while setting
     * it to 2.0 will cause the scene to be rendered at 1280x960 and then scaled down.
     * Default: 1.0
     */
    @JsProperty
    public double resolutionScale;
    /**
     * Gets the scene.
     */
    @JsProperty
    public Scene scene;
    //TODO: ScreenSpaceEventHandler
//    /**
//     * Gets the screen space event handler.
//     */
//    @JsProperty
//    public ScreenSpaceEventHandler screenSpaceEventHandler;
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
     * Gets or sets whether or not this widget should control the render loop. If set to true the widget will use
     * requestAnimationFrame to perform rendering and resizing of the widget, as well as drive the simulation clock.
     * If set to false, you must manually call the resize, render methods as part of a custom render loop.
     * If an error occurs during rendering, Scene's renderError event will be raised and this property will be set to false.
     * It must be set back to true to continue rendering after the error.
     */
    @JsProperty
    public boolean useDefaultRenderLoop;

    /**
     * A widget containing a Cesium scene.
     * @param container The DOM element or ID that will contain the widget.
     */
    @JsConstructor
    public CesiumWidget(Element container) {}

    /**
     * A widget containing a Cesium scene.
     * @param container The DOM element or ID that will contain the widget.
     */
    @JsConstructor
    public CesiumWidget(String container) {}

    /**
     * A widget containing a Cesium scene.
     * @param container The DOM element or ID that will contain the widget.
     * @param options Options.
     */
    @JsConstructor
    public CesiumWidget(Element container, CesiumWidgetOptions options) {}

    /**
     * A widget containing a Cesium scene.
     * @param container The DOM element or ID that will contain the widget.
     * @param options Options.
     */
    @JsConstructor
    public CesiumWidget(String container, CesiumWidgetOptions options) {}

    /**
     * Destroys the widget. Should be called if permanently removing the widget from layout.
     */
    @JsMethod
    public native void destroy();

    /**
     *
     * @return true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Renders the scene. This function is called automatically unless useDefaultRenderLoop is set to false;
     */
    @JsMethod
    public native void render();

    /**
     * Updates the canvas size, camera aspect ratio, and viewport size. This function is called automatically as
     * needed unless useDefaultRenderLoop is set to false.
     */
    @JsMethod
    public native void resize();

    /**
     * Show an error panel to the user containing a title and a longer error message, which can be dismissed using an OK button.
     * This panel is displayed automatically when a render loop error occurs,
     * if showRenderLoopErrors was not false when the widget was constructed.
     * @param title The title to be displayed on the error panel. This string is interpreted as text.
     * @param message A helpful, user-facing message to display prior to the detailed error information. This string is interpreted as HTML.
     */
    @JsMethod
    public native void showErrorPanel(String title, String message);

    /**
     * Show an error panel to the user containing a title and a longer error message, which can be dismissed using an OK button.
     * This panel is displayed automatically when a render loop error occurs,
     * if showRenderLoopErrors was not false when the widget was constructed.
     * @param title The title to be displayed on the error panel. This string is interpreted as text.
     * @param message A helpful, user-facing message to display prior to the detailed error information. This string is interpreted as HTML.
     * @param error The error to be displayed on the error panel. This string is formatted using formatError and then displayed as text.
     */
    @JsMethod
    public native void showErrorPanel(String title, String message, String error);
}
