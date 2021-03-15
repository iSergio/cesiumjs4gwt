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

package org.cesiumjs.cs.widgets;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.widgets.options.GeocoderViewModelOptions;

/**
 * The view model for the {@link Geocoder} widget.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "GeocoderViewModel")
public class GeocoderViewModel {
    /**
     * True if the geocoder should query as the user types to autocomplete Default:
     * true
     */
    @JsProperty
    public boolean autoComplete;
    /**
     * Gets the event triggered on flight completion.
     */
    @JsProperty
    public Event complete;
    /**
     * Gets or sets the the duration of the camera flight in seconds. A value of
     * zero causes the camera to instantly switch to the geocoding location. The
     * duration will be computed based on the distance when undefined. Default:
     * undefined
     */
    @JsProperty
    public double flightDuration;
    /**
     * Gets a value indicating whether a search is currently in progress. This
     * property is observable.
     */
    @JsProperty
    public boolean isSearchInProgress;
    /**
     * Gets or sets a value indicating if this instance should always show its text
     * input field. Default: false
     */
    @JsProperty
    public boolean keepExpanded;
    /**
     * Gets the scene to control.
     */
    @JsProperty
    public Scene scene;
    /**
     * Gets the Command that is executed when the button is clicked.
     */
    @JsProperty
    public Command search;
    /**
     * Gets or sets the text to search for. The text can be an address, or
     * longitude, latitude, and optional height, where longitude and latitude are in
     * degrees and height is in meters.
     */
    @JsProperty
    public String searchText;
    /**
     * Gets the currently selected geocoder search suggestion
     */
    @JsProperty
    public Object selectedSuggestion;
    /**
     * Gets the list of geocoder search suggestions
     */
    @JsProperty
    public Object[] suggestions;

    @JsConstructor
    private GeocoderViewModel() {
    }

    @JsConstructor
    public GeocoderViewModel(GeocoderViewModelOptions options) {
    }

    /**
     * Fast create instance of {@link GeocoderViewModel} by mandatory params
     *
     * @param scene The Scene instance to use.
     * @return {@link GeocoderViewModel} instance
     */
    @JsOverlay
    public static GeocoderViewModel create(Scene scene) {
        return new GeocoderViewModel(GeocoderViewModelOptions.create(scene));
    }

    /**
     * Destroys the widget. Should be called if permanently removing the widget from
     * layout.
     */
    @JsMethod
    public native void destroy();

    /**
     * A function that handles the result of a successful geocode.
     */
    @JsFunction
    public interface DestinationFoundFunction {
        /**
         * A function that handles the result of a successful geocode.
         *
         * @param viewModel   The view model.
         * @param destination {@link org.cesiumjs.cs.core.Cartesian3} |
         *                    {@link org.cesiumjs.cs.core.Rectangle} The destination
         *                    result of the geocode.
         */
        void function(GeocoderViewModel viewModel, Object destination);
    }
}
