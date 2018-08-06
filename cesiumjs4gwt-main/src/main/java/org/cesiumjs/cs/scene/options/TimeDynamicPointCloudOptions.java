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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.collections.ClippingPlaneCollection;
import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.core.Clock;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Cesium3DTileStyle;
import org.cesiumjs.cs.scene.enums.ShadowMode;

/**
 * Options for {@link org.cesiumjs.cs.scene.TimeDynamicPointCloud}
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TimeDynamicPointCloudOptions {
    /**
     * A Clock instance that is used when determining the value for the time dimension.
     */
    @JsProperty
    public Clock clock;
    /**
     * A TimeIntervalCollection with its data property being an object containing a uri to a 3D Tiles Point Cloud tile
     * and an optional transform.
     */
    @JsProperty
    public TimeIntervalCollection intervals;
    /**
     * Determines if the point cloud will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;
    /**
     * A 4x4 transformation matrix that transforms the point cloud.
     * Default: {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * Determines whether the point cloud casts or receives shadows from each light source.
     * Default: {@link ShadowMode#ENABLED()}
     */
    @JsProperty
    public Number shadows;
    /**
     * The maximum amount of memory in MB that can be used by the point cloud.
     * Default: 256
     */
    @JsProperty
    public int maximumMemoryUsage;
    /**
     * Options for constructing a PointCloudShading object to control point attenuation and eye dome lighting.
     */
    @JsProperty
    public JsObject shading;
    /**
     * The style, defined using the 3D Tiles Styling language, applied to each point in the point cloud.
     */
    @JsProperty
    public Cesium3DTileStyle style;
    /**
     * The ClippingPlaneCollection used to selectively disable rendering the point cloud.
     */
    @JsProperty
    public ClippingPlaneCollection clippingPlanes;

    @JsConstructor
    private TimeDynamicPointCloudOptions() {}

    /**
     * Create options instance
     * @param clock A Clock instance that is used when determining the value for the time dimension.
     * @param intervals A TimeIntervalCollection with its data property being an object containing a uri to a 3D Tiles Point Cloud tile
     *                  and an optional transform.
     * @return options instance
     */
    @JsOverlay
    public static TimeDynamicPointCloudOptions create(Clock clock, TimeIntervalCollection intervals) {
        TimeDynamicPointCloudOptions options = new TimeDynamicPointCloudOptions();
        options.clock = clock;
        options.intervals = intervals;
        return options;
    }
}
