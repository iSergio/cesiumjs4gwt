package org.cesiumjs.cs.widgets;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Scene;

/**
 * The view model for {@link HomeButton}
 */
@JsType(isNative = true, namespace = "Cesium", name = "HomeButtonViewModel")
public class HomeButtonViewModel {

    /**
     * Gets the {@link Command} that is executed when the button is clicked.
     */
    @JsProperty
    public Command command;

    /**
     * Gets or sets the duration of the camera flight in seconds.  A value of zero causes the camera to instantly
     * switch to home view. The duration will be computed based on the distance when undefined.
     */
    @JsProperty
    public Number duration;

    /**
     * Gets the scene to control.
     */
    @JsProperty
    public Scene scene;

    /**
     * Gets or sets the tooltip.  This property is observable.
     */
    @JsProperty
    public String tooltip;

    /**
     * The view model for {@link HomeButton}.
     * @param scene The scene instance to use.
     * @param duration The duration of the camera flight in seconds.  Optional.
     */
    @JsConstructor
    public HomeButtonViewModel(Scene scene, Number duration) {}

}
