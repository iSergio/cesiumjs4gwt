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

package org.cesiumjs.cs.datasources.options;

import com.google.gwt.dom.client.CanvasElement;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;

/**
 * Options for {@link org.cesiumjs.cs.datasources.GpxDataSource} load.
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GpxDataSourceOptions {
    /**
     * True if the symbols should be rendered at the same height as the terrain
     */
    @JsProperty
    public boolean clampToGround;
    /**
     * Image to use for waypoint billboards.
     */
    @JsProperty
    public CanvasElement waypointImage;
    /**
     * Image to use for track billboards.
     */
    @JsProperty
    public CanvasElement trackImage;
    /**
     * Color to use for track lines.
     */
    @JsProperty
    public Color trackColor;
    /**
     * Color to use for route lines.
     */
    @JsProperty
    public Color routeColor;

    public GpxDataSourceOptions() {
        //
    }

    @JsOverlay
    public final GpxDataSourceOptions setClampToGround(boolean clampToGround) {
        this.clampToGround = clampToGround;
        return this;
    }

    @JsOverlay
    public final GpxDataSourceOptions setWaypointImage(CanvasElement waypointImage) {
        this.waypointImage = waypointImage;
        return this;
    }

    @JsOverlay
    public final GpxDataSourceOptions setTrackImage(CanvasElement trackImage) {
        this.trackImage = trackImage;
        return this;
    }

    @JsOverlay
    public final GpxDataSourceOptions setTrackColor(Color trackColor) {
        this.trackColor = trackColor;
        return this;
    }

    @JsOverlay
    public final GpxDataSourceOptions setRouteColor(Color routeColor) {
        this.routeColor = routeColor;
        return this;
    }
}
