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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Fog")
public class Fog {
    /**
     * A scalar that determines the density of the fog. Terrain that is in full fog are culled.
     * The density of the fog increases as this number approaches 1.0 and becomes less dense as it approaches zero.
     * The more dense the fog is, the more aggressively the terrain is culled. For example, if the camera is
     * a height of 1000.0m above the ellipsoid, increasing the value to 3.0e-3 will cause many tiles close to the viewer
     * be culled. Decreasing the value will push the fog further from the viewer, but decrease performance as
     * more of the terrain is rendered.
     * Default: 2.0e-4
     */
    @JsProperty
    public double density;
    /**
     * true if fog is enabled, false otherwise.
     * Default: true
     */
    @JsProperty
    public boolean enabled;
    /**
     * A factor used to increase the screen space error of terrain tiles when they are partially in fog.
     * The effect is to reduce the number of terrain tiles requested for rendering. If set to zero, the feature will
     * be disabled. If the value is increased for mountainous regions, less tiles will need to be requested,
     * but the terrain meshes near the horizon may be a noticeably lower resolution. If the value is increased in a
     * relatively flat area, there will be little noticeable change on the horizon.
     * Default: 2.0
     */
    @JsProperty
    public double screenSpaceErrorFactor;

    /**
     * Blends the atmosphere to geometry far from the camera for horizon views. Allows for additional performance
     * improvements by rendering less geometry and dispatching less terrain requests.
     */
    @JsConstructor
    public Fog() {}
}
