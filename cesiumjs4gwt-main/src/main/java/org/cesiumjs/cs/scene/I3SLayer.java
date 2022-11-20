/*
 * Copyright 2022 iSergio, Gis4Fun.
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
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.providers.I3SDataProvider;

/**
 * This class implements an I3S layer. In CesiumJS each I3SLayer creates a Cesium3DTileset.
 * Do not construct this directly, instead access layers through {@link I3SDataProvider}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "I3SLayer")
public class I3SLayer {
    /**
     * Gets the I3S data for this object.
     */
    @JsProperty(name = "data")
    public native JsObject data();
    /**
     * When true, when the loaded I3S version is 1.6 or older
     */
    @JsProperty(name = "legacyVersion16")
    public native boolean legacyVersion16();
    /**
     * The major version number of the loaded I3S dataset
     */
    @JsProperty(name = "majorVersionl")
    public native int majorVersionl();
    /**
     * The minor version number of the loaded I3S dataset
     */
    @JsProperty(name = "minorVersion")
    public native int minorVersion();
    /**
     * Gets the resource for the layer.
     */
    @JsProperty(name = "resource")
    public native Resource resource();
    /**
     * Gets the root node of this layer.
     */
    @JsProperty(name = "rootNode")
    public native I3SNode rootNode();
    /**
     * Gets the Cesium3DTileset for this layer.
     */
    @JsProperty(name = "tileset")
    public native Cesium3DTileset tileset();
    /**
     * The version string of the loaded I3S dataset.
     */
    @JsProperty(name = "version")
    public native String version();

    @JsConstructor
    private I3SLayer() {}
}
