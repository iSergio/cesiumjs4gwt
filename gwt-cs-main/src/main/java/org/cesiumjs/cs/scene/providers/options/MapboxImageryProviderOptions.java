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

package org.cesiumjs.cs.scene.providers.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Rectangle;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MapboxImageryProviderOptions {
    /**
     * The Mapbox server url.
     * Default: https://api.mapbox.com/v4/
     */
    @JsProperty
    public String url;
    /**
     * The Mapbox Map ID.
     */
    @JsProperty
    public String mapId;
    /**
     * The public access token for the imagery.
     */
    @JsProperty
    public String accessToken;
    /**
     * The format of the image request.
     * Default: png
     */
    @JsProperty
    public String format;
    //TODO: Proxy
//    /**
//     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL.
//     */
//    @JsProperty
//    public Proxy proxy;
    /**
     * The ellipsoid. If not specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The minimum level-of-detail supported by the imagery provider. Take care when specifying this that the number of tiles at the minimum level is small, such as four or less. A larger number is likely to result in rendering problems.
     * Default: 0
     */
    @JsProperty
    public int minimumLevel;
    /**
     * The maximum level-of-detail supported by the imagery provider, or undefined if there is no limit.
     */
    @JsProperty
    public int maximumLevel;
    /**
     * The rectangle, in radians, covered by the image.
     * Default: {@link Rectangle#MAX_VALUE()}
     */
    @JsProperty
    public Rectangle rectangle;
    /**
     * A credit for the data source, which is displayed on the canvas.
     */
    @JsProperty
    public Credit credit;

    /**
     * Options for {@link org.cesiumjs.cs.scene.providers.MapboxImageryProvider}
     */
    @JsConstructor
    public MapboxImageryProviderOptions() {}
}
