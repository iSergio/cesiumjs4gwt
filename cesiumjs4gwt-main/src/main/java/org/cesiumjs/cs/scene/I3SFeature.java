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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.js.JsObject;

/**
 * This class implements an I3S Feature.
 * Do not construct this directly, instead access tiles through {@link I3SNode}.
 */
@JsType(isNative = true, namespace = "Cesium", name = "I3SFeature")
public class I3SFeature {
    /**
     * Gets the I3S data for this object.
     */
    @JsProperty(name = "data")
    public native JsObject data();

    /**
     * Gets the resource for the feature
     */
    @JsProperty(name = "resource")
    public native Resource resource();


    @JsConstructor
    private I3SFeature() {}
}
