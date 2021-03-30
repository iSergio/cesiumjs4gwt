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

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.*;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.widgets.options.GeocoderOptions;

/**
 * A widget for finding addresses and landmarks, and flying the camera to them.
 * Geocoding is performed using the Bing Maps Locations API.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "Geocoder")
public class Geocoder {
    /**
     * Gets the parent container.
     */
    @JsProperty
    public Element container;
    /**
     * Gets the parent container.
     */
    @JsProperty
    public Element searchSuggestionsContainer;
    /**
     * Gets the view model.
     */
    @JsProperty
    public GeocoderViewModel viewModel;

    @JsConstructor
    private Geocoder() {
    }

    /**
     * Default constructor
     *
     * @param options {@link GeocoderOptions} object
     */
    @JsConstructor
    public Geocoder(GeocoderOptions options) {
    }

    /**
     * Fast create instance of {@link Geocoder} by mandatory params.
     *
     * @param container The DOM element that will contain the widget.
     * @param scene     The Scene instance to use.
     * @return {@link Geocoder} instance
     */
    @JsOverlay
    public static Geocoder create(Element container, Scene scene) {
        return new Geocoder(GeocoderOptions.create(container, scene));
    }

    /**
     * Fast create instance of {@link Geocoder} by mandatory params.
     *
     * @param container The ID that will contain the widget.
     * @param scene     The Scene instance to use.
     * @return {@link Geocoder} instance
     */
    @JsOverlay
    public static Geocoder create(String container, Scene scene) {
        return new Geocoder(GeocoderOptions.create(container, scene));
    }

    /**
     * Destroys the widget. Should be called if permanently removing the widget from
     * layout.
     */
    @JsMethod
    public native void destroy();

    /**
     * @return true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();
}
