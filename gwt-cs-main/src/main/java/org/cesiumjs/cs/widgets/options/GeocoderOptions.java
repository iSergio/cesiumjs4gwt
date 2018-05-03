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

package org.cesiumjs.cs.widgets.options;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.*;
import org.cesiumjs.cs.core.GeocoderService;
import org.cesiumjs.cs.scene.Scene;

/**
 * Options for {@link org.cesiumjs.cs.widgets.Geocoder}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeocoderOptions {
    /**
     * The ID that will contain the widget.
     */
    @JsProperty
    public String container;
    /**
     * The DOM element that will contain the widget.
     */
    @JsProperty
    public Element conteinerElement;
    /**
     * The Scene instance to use.
     */
    @JsProperty
    public Scene scene;
    /**
     * The geocoder services to be used
     */
    @JsProperty
    public GeocoderService[] geocoderServices;
    /**
     * True if the geocoder should query as the user types to autocomplete
     * Default: true
     */
    @JsProperty
    public boolean autoComplete;
    /**
     * The duration of the camera flight to an entered location, in seconds.
     * Default: 1.5
     */
    @JsProperty
    public double flightDuration;

    @JsConstructor
    private GeocoderOptions() {}

    /**
     * Fast create instance of {@link GeocoderOptions} by mandatory params
     * @param container The ID that will contain the widget.
     * @param scene The Scene instance to use.
     * @return {@link GeocoderOptions} instance
     */
    @JsOverlay
    public static GeocoderOptions create(String container, Scene scene) {
        GeocoderOptions options = new GeocoderOptions();
        options.container = container;
        options.scene = scene;
        return options;
    }

    /**
     * Fast create instance of {@link GeocoderOptions} by mandatory params
     * @param container The DOM element that will contain the widget.
     * @param scene The Scene instance to use.
     * @return {@link GeocoderOptions} instance
     */
    @JsOverlay
    public static GeocoderOptions create(Element container, Scene scene) {
        GeocoderOptions options = new GeocoderOptions();
        options.conteinerElement = container;
        options.scene = scene;
        return options;
    }
}
