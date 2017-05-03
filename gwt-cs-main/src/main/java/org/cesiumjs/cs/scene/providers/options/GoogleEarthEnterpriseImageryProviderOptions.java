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

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.GoogleEarthEnterpriseMetadata;
import org.cesiumjs.cs.scene.TileDiscardPolicy;
import org.cesiumjs.cs.scene.providers.GoogleEarthEnterpriseImageryProvider;

/**
 * Options for {@link org.cesiumjs.cs.scene.providers.GoogleEarthEnterpriseImageryProvider}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GoogleEarthEnterpriseImageryProviderOptions {
    /**
     * The url of the Google Earth Enterprise server hosting the imagery.
     */
    @JsProperty
    public String url;
    /**
     * A metadata object that can be used to share metadata requests with a GoogleEarthEnterpriseTerrainProvider.
     */
    @JsProperty
    public GoogleEarthEnterpriseMetadata metadata;
    /**
     * A proxy to use for requests. This object is expected to have a getURL function which returns the proxied URL, if needed.
     */
    @JsProperty
    public Object proxy;
    /**
     * The ellipsoid. If not specified, the WGS84 ellipsoid is used.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * The policy that determines if a tile is invalid and should be discarded. If this value is not specified, a default is to discard tiles that fail to download.
     */
    @JsProperty
    public TileDiscardPolicy tileDiscardPolicy;
    /**
     * A credit for the data source, which is displayed on the canvas.
     */
    @JsProperty
    public Credit credit;

    @JsConstructor
    private GoogleEarthEnterpriseImageryProviderOptions() {}

    @JsOverlay
    public static GoogleEarthEnterpriseImageryProviderOptions create(String url) {
        GoogleEarthEnterpriseImageryProviderOptions options = new GoogleEarthEnterpriseImageryProviderOptions();
        options.url = url;
        return options;
    }

    @JsOverlay
    public static GoogleEarthEnterpriseImageryProviderOptions create(GoogleEarthEnterpriseMetadata metadata) {
        GoogleEarthEnterpriseImageryProviderOptions options = new GoogleEarthEnterpriseImageryProviderOptions();
        options.metadata = metadata;
        return options;
    }

    @JsOverlay
    public static GoogleEarthEnterpriseImageryProviderOptions create(String url, GoogleEarthEnterpriseMetadata metadata) {
        GoogleEarthEnterpriseImageryProviderOptions options = new GoogleEarthEnterpriseImageryProviderOptions();
        options.url = url;
        options.metadata = metadata;
        return options;
    }
}
