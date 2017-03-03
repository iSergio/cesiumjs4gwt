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

package org.cesiumjs.cs.core.providers.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Ellipsoid;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CesiumTerrainProviderOptions {
    /**
     * The URL of the Cesium terrain server.
     */
    @JsProperty
    public String url;
//TODO: Proxy
//    /**
//     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
//     */
//    @JsProperty
//    public Proxy proxy;
    /**
     * Flag that indicates if the client should request additional lighting information from the server, in the form of per vertex normals if available.
     * Default: false
     */
    @JsProperty
    public boolean requestVertexNormals;
    /**
     * Flag that indicates if the client should request per tile water masks from the server, if available.
     * Default: false
     */
    @JsProperty
    public boolean requestWaterMask;
    /**
     * The ellipsoid. If not specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * A credit for the data source, which is displayed on the canvas.
     */
    @JsProperty
    public Credit credit;

    /**
     * Options for CesiumTerrainProvider
     */
    @JsConstructor
    public CesiumTerrainProviderOptions() {}
}
