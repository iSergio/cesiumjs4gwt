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

package org.cesiumjs.cs.core.providers;

import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.typedarrays.shared.Float32Array;
import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Size;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeoserverTerrainProviderFormatArray {
    @JsProperty
    public String format;
    @JsProperty
    public PostProcessArray postProcessArray;

    @JsConstructor
    public GeoserverTerrainProviderFormatArray() {}

    @JsFunction
    public interface PostProcessArray {
        Float32Array function(ArrayBuffer bufferIn, Size size, float highest, float lowest, float offset);
    }
}
