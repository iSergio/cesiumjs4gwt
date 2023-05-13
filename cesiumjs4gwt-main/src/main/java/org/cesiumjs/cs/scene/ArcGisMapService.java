/*
 * Copyright 2023 iSergio, Gis4Fun.
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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Resource;

@JsType(isNative = true, namespace = "Cesium", name = "ArcGisMapService")
public class ArcGisMapService {
    /**
     * Gets or sets the default ArcGIS access token.
     */
    @JsProperty
    public static String defaultAccessToken;
    /**
     * Gets or sets the URL of the ArcGIS World Hillshade tile service.
     * Default: https://ibasemaps-api.arcgis.com/arcgis/rest/services/Elevation/World_Hillshade/MapServer
     */
    @JsProperty
    public static String defaultWorldHillshadeServer;
    /**
     * Gets or sets the URL of the ArcGIS World Hillshade tile service.
     * Default: https://ibasemaps-api.arcgis.com/arcgis/rest/services/Elevation/World_Hillshade/MapServer
     */
    @JsProperty(name = "defaultWorldHillshadeServer")
    public static Resource defaultWorldHillshadeServerResource;
    /**
     * Gets or sets the URL of the ArcGIS World Imagery tile service.
     * Default: https://ibasemaps-api.arcgis.com/arcgis/rest/services/World_Imagery/MapServer
     */
    @JsProperty
    public static String defaultWorldImageryServer;
    /**
     * Gets or sets the URL of the ArcGIS World Imagery tile service.
     * Default: https://ibasemaps-api.arcgis.com/arcgis/rest/services/World_Imagery/MapServer
     */
    @JsProperty(name = "defaultWorldImageryServer")
    public static Resource defaultWorldImageryServerResource;
    /**
     * Gets or sets the URL of the ArcGIS World Oceans tile service.
     * Default: https://ibasemaps-api.arcgis.com/arcgis/rest/services/Ocean/World_Ocean_Base/MapServer
     */
    @JsProperty
    public static String defaultWorldOceanServer;
    /**
     * Gets or sets the URL of the ArcGIS World Oceans tile service.
     * Default: https://ibasemaps-api.arcgis.com/arcgis/rest/services/Ocean/World_Ocean_Base/MapServer
     */
    @JsProperty(name = "defaultWorldOceanServer")
    public static String defaultWorldOceanServerResource;

    @JsConstructor
    public ArcGisMapService() {}

    /**
     *
     * @param providedKey
     * @return
     */
    @JsMethod
    public native String getDefaultTokenCredit(String providedKey);
}
