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

package org.cesiumjs.cs.collections.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.scene.enums.CloudType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CumulusCloudAddOptions {
    @JsProperty
    public boolean show;
    @JsProperty
    public Cartesian3 position;
    @JsProperty
    public Cartesian2 scale;
    @JsProperty
    public Cartesian3 maximumSize;
    @JsProperty
    public double slice;
    /**
     * {@link CloudType}
     */
    @JsProperty
    public Number cloudType;
    @JsProperty
    public Number brightness;
}
