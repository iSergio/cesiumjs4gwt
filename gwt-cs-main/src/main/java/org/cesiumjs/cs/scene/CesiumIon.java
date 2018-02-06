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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.options.CesiumIonOptions;
import org.cesiumjs.cs.scene.providers.ImageryProvider;

/**
 * Utility object for working with the Cesium ion API.
 * See <a href="https://cesium.com">https://cesium.com</a>
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
// TODO: Examples
@JsType(isNative = true, namespace = "Cesium", name = "CesiumIon")
public class CesiumIon {
    /**
     * The default Cesium ion access token to use.
     */
    @JsProperty
    public static String defaultAccessToken;
    /**
     * The default Cesium ion server to use.
     * Default: <a href="https://api.cesium.com">https://api.cesium.com</a>
     */
    @JsProperty
    public static String defaultServerUrl;

    @JsConstructor
    public CesiumIon() {}

    /**
     * Asynchronously creates a Cesium3DTileset representing a Cesium ion 3D Tiles asset and waits for it to become ready.
     * @param assetId The Cesium ion asset id
     * @return A promise to the ready tileset representing the requested Cesium ion Asset.
     */
    @JsMethod
    public static native Promise<Cesium3DTileset, Void> create3DTileset(int assetId);

    /**
     * Asynchronously creates a Cesium3DTileset representing a Cesium ion 3D Tiles asset and waits for it to become ready.
     * @param assetId The Cesium ion asset id
     * @param options {@link CesiumIonOptions} object instance
     * @return A promise to the ready tileset representing the requested Cesium ion Asset.
     */
    @JsMethod
    public static native Promise<Cesium3DTileset, Void> create3DTileset(int assetId, CesiumIonOptions options);

    /**
     * Asynchronously creates an ImageryProvider representing a Cesium ion imagery asset and waits for it to become ready.
     * Unlike CesiumIon.createResource, this function supports external asset functionality.
     * @param assetId The Cesium ion asset id.
     * @return A promise to a ready imagery provider representing the requested Cesium ion Asset.
     */
    @JsMethod
    public static native Promise<ImageryProvider, Void> createImageryProvider(int assetId);

    /**
     * Asynchronously creates an ImageryProvider representing a Cesium ion imagery asset and waits for it to become ready.
     * Unlike CesiumIon.createResource, this function supports external asset functionality.
     * @param assetId The Cesium ion asset id.
     * @param options {@link CesiumIonOptions} object instance.
     * @return A promise to a ready imagery provider representing the requested Cesium ion Asset.
     */
    @JsMethod
    public static native Promise<ImageryProvider, Void> createImageryProvider(int assetId, CesiumIonOptions options);

    /**
     * Asynchronously creates a Resource representing a Cesium ion asset.
     * @param assetId The Cesium ion asset id.
     * @return A Promise to a Resource representing the Cesium ion Asset.
     */
    @JsMethod
    public static native Promise<Resource, Void> createResource(int assetId);

    /**
     * Asynchronously creates a Resource representing a Cesium ion asset.
     * @param assetId The Cesium ion asset id.
     * @param options {@link CesiumIonOptions} object instance.
     * @return A Promise to a Resource representing the Cesium ion Asset.
     */
    @JsMethod
    public static native Promise<Resource, Void> createResource(int assetId, CesiumIonOptions options);
}
