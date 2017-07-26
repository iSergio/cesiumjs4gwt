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

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.scene.Scene;

/**
 * The view model for {@link SelectionIndicator}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "SelectionIndicatorViewModel")
public class SelectionIndicatorViewModel {
    /**
     * Gets or sets the function for converting the world position of the object to the screen space position.
     * Default: SceneTransforms.wgs84ToWindowCoordinates
     */
    @JsProperty
    public SelectionIndicatorViewModel computeScreenSpacePosition;
    /**
     * Gets the HTML element containing the selection indicator.
     */
    @JsProperty
    public Element container;
    /**
     * Gets the visibility of the position indicator. This can be false even if an object is selected,
     * when the selected object has no position.
     */
    @JsProperty
    public boolean isVisible;
    /**
     * Gets or sets the world position of the object for which to display the selection indicator.
     */
    @JsProperty
    public Cartesian3 position;
    /**
     * Gets the scene being used.
     */
    @JsProperty
    public Scene scene;
    /**
     * Gets the HTML element that holds the selection indicator.
     */
    @JsProperty
    public Element selectionIndicatorElement;
    /**
     * Gets or sets the visibility of the selection indicator.
     */
    @JsProperty
    public boolean showSelection;

    /**
     * The view model for {@link SelectionIndicator}.
     * @param scene The scene instance to use for screen-space coordinate conversion.
     * @param selectionIndicatorElement The element containing all elements that make up the selection indicator.
     * @param container The DOM element that contains the widget.
     */
    @JsConstructor
    public SelectionIndicatorViewModel(Scene scene, Element selectionIndicatorElement, Element container) {}

    /**
     * Animate the indicator to draw attention to the selection.
     */
    @JsMethod
    public native void animateAppear();

    /**
     * Animate the indicator to release the selection.
     */
    @JsMethod
    public native void animateDepart();

    /**
     * Updates the view of the selection indicator to match the position and content properties of the view model.
     * This function should be called as part of the render loop.
     */
    @JsMethod
    public native void update();

    /**
     * A function that converts the world position of an object to a screen space position.
     */
    @JsFunction
    interface ComputeScreenSpacePosition {
        /**
         * A function that converts the world position of an object to a screen space position.
         * @param position The position in WGS84 (world) coordinates.
         * @param result An object to return the input position transformed to window coordinates.
         * @return The modified result parameter.
         */
        Cartesian2 function(Cartesian3 position, Cartesian2 result);
    }
}
