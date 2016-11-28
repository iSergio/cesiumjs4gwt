/*
 * Copyright 2016 iserge.
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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.providers.TerrainProvider;
import org.cesiumjs.cs.js.JsImage;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.scene.providers.UrlTemplateImageryProvider;
import org.cesiumjs.cs.scene.providers.options.OpenStreetMapImageryProviderOptions;
import org.cesiumjs.cs.scene.providers.options.TileMapServiceImageryProviderOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true)
public class Utils {
    @JsMethod(name = "setTimeout", namespace = JsPackage.GLOBAL)
    public static native void setTimeout(TimeoutListener listener, int milliseconds);

    @JsFunction
    public interface TimeoutListener {
        void function();
    }
}
