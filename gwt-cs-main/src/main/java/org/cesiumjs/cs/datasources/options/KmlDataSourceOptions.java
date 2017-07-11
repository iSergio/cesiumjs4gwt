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

import com.google.gwt.dom.client.CanvasElement;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Camera;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class KmlDataSourceOptions {
    /**
     * The camera that is used for viewRefreshModes and sending camera properties to network links.
     */
    @JsProperty
    public Camera camera;
    /**
     * The canvas that is used for sending viewer properties to network links.
     */
    @JsProperty
    public CanvasElement canvas;
//    public DefaultProxy proxy;
    /**
     * Overrides the url to use for resolving relative links and other KML network features.
     */
    @JsProperty
    public String sourceUri;
    /**
     * true if we want the geometry features (Polygons, LineStrings and LinearRings) clamped to the ground. If true,
     * lines will use corridors so use Entity.corridor instead of Entity.polyline.
     * Default: true
     */
    @JsProperty
    public boolean clampToGround;
    /**
     * Key-value pairs which are appended to all URIs in the CZML.
     */
    @JsProperty
    public JsObject query;

    /**
     * Options for {@link org.cesiumjs.cs.datasources.KmlDataSource}
     * @param camera The camera that is used for viewRefreshModes and sending camera properties to network links.
     * @param canvas The canvas that is used for sending viewer properties to network links.
     */
    @JsConstructor
    public KmlDataSourceOptions() {}//Camera camera, CanvasElement canvas) {}
}
