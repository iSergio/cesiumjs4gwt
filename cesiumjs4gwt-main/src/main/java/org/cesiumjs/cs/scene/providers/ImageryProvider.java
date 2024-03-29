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

package org.cesiumjs.cs.scene.providers;

import jsinterop.annotations.JsType;

/**
 * Provides imagery to be displayed on the surface of an ellipsoid. This type
 * describes an interface and is not intended to be instantiated directly.
 *
 * @author Serge Silaev aka iSergio
 * @see ArcGisMapServerImageryProvider
 * @see SingleTileImageryProvider
 * @see BingMapsImageryProvider
 * @see GoogleEarthEnterpriseImageryProvider
 * @see MapboxImageryProvider
 * @see WebMapTileServiceImageryProvider
 * @see WebMapServiceImageryProvider
 */
@JsType(isNative = true, namespace = "Cesium", name = "ImageryProvider")
public interface ImageryProvider {
}
