/*
 * Copyright 2021 iserge.
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

package org.cesiumjs.cs.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.scene.Cesium3DTileStyle;

/**
 * Options for {@link org.cesiumjs.cs.Cesium#createOsmBuildings(CreateOsmBuildingsOptions)}.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CreateOsmBuildingsOptions {
    /**
     * The default color to use for buildings that do not have a color. This parameter is ignored if options.style is specified.
     *
     * Default: Color.WHITE
     */
    @JsProperty
    public Color defaultColor;
    /**
     * The style to use with the tileset. If not specified, a default style is used which gives each building or
     * building part a color inferred from its OpenStreetMap tags.
     * If no color can be inferred, options.defaultColor is used.
     */
    @JsProperty
    public Cesium3DTileStyle style;
    /**
     * Whether to show outlines around buildings. When true, outlines are displayed. When false, outlines are not displayed.
     *
     * Default: true
     */
    @JsProperty
    public boolean showOutline;

    @JsConstructor
    public CreateOsmBuildingsOptions() {}

    @JsOverlay
    public static CreateOsmBuildingsOptions create(Color defaultColor) {
        CreateOsmBuildingsOptions options = new CreateOsmBuildingsOptions();
        options.defaultColor = defaultColor;
        return options;
    }

    @JsOverlay
    public static CreateOsmBuildingsOptions create(Color defaultColor, Cesium3DTileStyle style) {
        CreateOsmBuildingsOptions options = new CreateOsmBuildingsOptions();
        options.defaultColor = defaultColor;
        options.style = style;
        return options;
    }

    @JsOverlay
    public static CreateOsmBuildingsOptions create(Color defaultColor, Cesium3DTileStyle style, boolean showOutline) {
        CreateOsmBuildingsOptions options = new CreateOsmBuildingsOptions();
        options.defaultColor = defaultColor;
        options.style = style;
        options.showOutline = showOutline;
        return options;
    }
}
