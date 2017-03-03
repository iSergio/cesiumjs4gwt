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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartographic;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ImageryLayerFeatureInfo")
public class ImageryLayerFeatureInfo {
    /**
     * Gets or sets the raw data describing the feature. The raw data may be in any number of formats, such as GeoJSON, KML, etc.
     */
    @JsProperty
    public Object data;
    /**
     * Gets or sets an HTML description of the feature. The HTML is not trusted and should be sanitized before display to the user.
     */
    @JsProperty
    public String description;
    /**
     * Gets or sets the image layer of the feature.
     */
    @JsProperty
    public Object imageryLayer;
    /**
     * Gets or sets the name of the feature.
     */
    @JsProperty
    public String name;
    /**
     * Gets or sets the position of the feature, or undefined if the position is not known.
     */
    @JsProperty
    public Cartographic position;

    /**
     * Describes a rasterized feature, such as a point, polygon, polyline, etc., in an imagery layer.
     */
    @JsConstructor
    public ImageryLayerFeatureInfo() {}

    /**
     * Configures the description of this feature by creating an HTML table of properties and their values.
     * @param properties An object literal containing the properties of the feature.
     */
    public native void configureDescriptionFromProperties(Object properties);

    /**
     * Configures the name of this feature by selecting an appropriate property. The name will be obtained from one of
     * the following sources, in this order:
     * 1) the property with the name 'name',
     * 2) the property with the name 'title',
     * 3) the first property containing the word 'name',
     * 4) the first property containing the word 'title'.
     * If the name cannot be obtained from any of these sources, the existing name will be left unchanged.
     * @param properties An object literal containing the properties of the feature.
     */
    public native void configureNameFromProperties(Object properties);
}
