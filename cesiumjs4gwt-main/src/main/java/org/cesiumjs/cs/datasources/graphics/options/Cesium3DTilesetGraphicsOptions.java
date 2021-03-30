/*
 * Copyright 2020 iSerge.
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

package org.cesiumjs.cs.datasources.graphics.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.datasources.properties.Property;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class Cesium3DTilesetGraphicsOptions {
    /**
     * A boolean Property specifying the visibility of the tileset. Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A string or Resource Property specifying the URI of the tileset.
     */
    @JsProperty
    public Property uri;
    /**
     * A number or Property specifying the maximum screen space error used to drive
     * level of detail refinement.
     */
    @JsProperty
    public Property maximumScreenSpaceError;

    @JsConstructor
    public Cesium3DTilesetGraphicsOptions() {
    }
}