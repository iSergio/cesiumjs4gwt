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

package org.cesiumjs.cs.datasources;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.HeadingPitchRoll;

/**
 * Representation of from KML
 */
@JsType(isNative = true, namespace = "Cesium", name = "KmlCamera")
public class KmlCamera implements KmlView {
    /**
     * Representation of from KML
     * @param position camera position
     * @param headingPitchRoll camera orientation
     */
    @JsConstructor
    public KmlCamera(Cartesian3 position, HeadingPitchRoll headingPitchRoll) {}
}
