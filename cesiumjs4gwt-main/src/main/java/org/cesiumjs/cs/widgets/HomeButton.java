package org.cesiumjs.cs.widgets;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Scene;

/**
 * A single button widget for returning to the default camera view of the current scene.
 */
@JsType(isNative = true, namespace = "Cesium", name = "HomeButton")
public class HomeButton {

    /**
     * Gets the parent container.
     */
    @JsProperty
    public Element container;

    /**
     * Gets the view model.
     */
    @JsProperty
    public HomeButtonViewModel viewModel;

    /**
     * A single button widget for returning to the default camera view of the current scene.
     * @param container The DOM element or ID that will contain the widget.
     * @param scene The Scene instance to use.
     * @param duration The time, in seconds, it takes to complete the camera flight home. Optional.
     */
    @JsConstructor
    public HomeButton(Element container, Scene scene, Number duration) {}

    /**
     * Destroys the widget.  Should be called if permanently removing the widget from the layout.
     */
    @JsMethod
    public native void destroy();

    /**
     *
     * @return true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();
}
