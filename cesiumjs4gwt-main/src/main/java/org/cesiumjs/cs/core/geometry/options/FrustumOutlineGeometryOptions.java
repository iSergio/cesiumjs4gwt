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

package org.cesiumjs.cs.core.geometry.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Frustum;
import org.cesiumjs.cs.core.Quaternion;

/**
 * Options for {@link org.cesiumjs.cs.core.geometry.FrustumOutlineGeometry}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FrustumOutlineGeometryOptions {
    /**
     * The frustum.
     */
    @JsProperty
    public Frustum frustum;
    /**
     * The origin of the frustum.
     */
    @JsProperty
    public Cartesian3 origin;
    /**
     * The orientation of the frustum.
     */
    @JsProperty
    public Quaternion orientation;

    @JsConstructor
    public FrustumOutlineGeometryOptions() {
    }
}
