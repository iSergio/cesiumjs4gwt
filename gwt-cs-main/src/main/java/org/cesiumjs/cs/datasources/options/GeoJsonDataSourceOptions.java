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

package org.cesiumjs.cs.datasources.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.datasources.GeoJsonDataSource;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeoJsonDataSourceOptions {
    /**
     * Overrides the url to use for resolving relative links.
     */
    @JsProperty
    public String sourceUri;
    /**
     * A function which returns a Property object (or just a string), which converts the properties into an html description.
     */
    @JsProperty
    public GeoJsonDataSource.discribe discribe;
    /**
     * The default size of the map pin created for each point, in pixels.
     * Default: {@link org.cesiumjs.cs.datasources.GeoJsonDataSource#markerSize}
     */
    @JsProperty
    public int markerSize;
    /**
     * The default symbol of the map pin created for each point.
     * Default: {@link org.cesiumjs.cs.datasources.GeoJsonDataSource#markerSymbol}
     */
    @JsProperty
    public String markerSymbol;
    /**
     * The default color of the map pin created for each point.
     * Default: {@link org.cesiumjs.cs.datasources.GeoJsonDataSource#markerColor}
     */
    @JsProperty
    public Color markerColor;
    /**
     * The default color of polylines and polygon outlines.
     * Default: {@link org.cesiumjs.cs.datasources.GeoJsonDataSource#stroke}
     */
    @JsProperty
    public Color stroke;
    /**
     * The default width of polylines and polygon outlines.
     * Default: {@link org.cesiumjs.cs.datasources.GeoJsonDataSource#strokeWidth}
     */
    @JsProperty
    public double strokeWidth;
    /**
     * The default color for polygon interiors.
     * Default: {@link org.cesiumjs.cs.datasources.GeoJsonDataSource#fill}
     */
    @JsProperty
    public Color fill;
    /**
     * true if we want the geometry features (polygons or linestrings) clamped to the ground.
     * If true, lines will use corridors so use Entity.corridor instead of Entity.polyline.
     * Default: {@link org.cesiumjs.cs.datasources.GeoJsonDataSource#clampToGround}
     */
    @JsProperty
    public boolean clampToGround;

    /**
     * Options for {@link org.cesiumjs.cs.datasources.GeoJsonDataSource#load(String, GeoJsonDataSourceOptions)}
     */
    @JsConstructor
    public GeoJsonDataSourceOptions() {}
}
