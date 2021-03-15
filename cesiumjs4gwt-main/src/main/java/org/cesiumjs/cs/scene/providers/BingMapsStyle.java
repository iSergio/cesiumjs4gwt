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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "BingMapsStyle")
public class BingMapsStyle {
    @JsConstructor
    private BingMapsStyle() {
    }

    /**
     * Aerial imagery.
     */
    @JsProperty(name = "AERIAL")
    public static native String AERIAL();

    /**
     * Aerial imagery with a road overlay.
     *
     * @deprecated See https://github.com/AnalyticalGraphicsInc/cesium/issues/7128.
     * Use `BingMapsStyle.AERIAL_WITH_LABELS_ON_DEMAND` instead
     */
    @Deprecated
    @JsProperty(name = "AERIAL_WITH_LABELS")
    public static native String AERIAL_WITH_LABELS();

    /**
     * Aerial imagery with a road overlay.
     */
    @JsProperty(name = "AERIAL_WITH_LABELS_ON_DEMAND")
    public static native String AERIAL_WITH_LABELS_ON_DEMAND();

    /**
     * A dark version of the road maps.
     */
    @JsProperty(name = "CANVAS_DARK")
    public static native String CANVAS_DARK();

    /**
     * A grayscale version of the road maps.
     */
    @JsProperty(name = "CANVAS_GRAY")
    public static native String CANVAS_GRAY();

    /**
     * A lighter version of the road maps.
     */
    @JsProperty(name = "CANVAS_LIGHT")
    public static native String CANVAS_LIGHT();

    /**
     * Roads without additional imagery.
     *
     * @deprecated See https://github.com/AnalyticalGraphicsInc/cesium/issues/7128.
     * Use `BingMapsStyle.ROAD_ON_DEMAND` instead
     */
    @Deprecated
    @JsProperty(name = "ROAD")
    public static native String ROAD();

    /**
     * Roads without additional imagery.
     */
    @JsProperty(name = "ROAD_ON_DEMAND")
    public static native String ROAD_ON_DEMAND();

    /**
     * Ordnance Survey imagery
     */
    @JsProperty(name = "ORDNANCE_SURVEY")
    public static native String ORDNANCE_SURVEY();

    /**
     * Collins Bart imagery.
     */
    @JsProperty(name = "COLLINS_BART")
    public static native String COLLINS_BART();
}
