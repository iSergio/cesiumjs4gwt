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

package org.cesiumjs.cs.widgets;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true)
public class viewerCesium3DTilesInspectorMixin {
    /**
     * A mixin which adds the Cesium3DTilesInspector widget to the Viewer widget. Rather than being called directly,
     * this function is normally passed as a parameter to {@link Viewer#extend}, as shown in the example below.
     */
    @JsProperty(namespace = "Cesium", name = "viewerCesium3DTilesInspectorMixin")
    public static native Object instance();
}
