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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Ellipsoid;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class VRTheWorldTerrainProviderOptions {
    /**
     * The URL of the VR-TheWorld TileMap.
     */
    @JsProperty
    public String url;
    /**
     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
     * Optional
     */
    @JsProperty
    public Object proxy;
    /**
     * The ellipsoid. If this parameter is not specified, the WGS84 ellipsoid is used.
     * Default: {@link Ellipsoid#WGS84()}
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * A credit for the data source, which is displayed on the canvas.
     */
    @JsProperty
    public Credit credit;
}
