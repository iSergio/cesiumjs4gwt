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

package org.cesiumjs.cs.core.geometry.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.VertexFormat;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class BoxGeometryOptions {
    /**
     * The minimum x, y, and z coordinates of the box.
     */
    @JsProperty
    public Cartesian3 minimum;
    /**
     * The maximum x, y, and z coordinates of the box.
     */
    @JsProperty
    public Cartesian3 maximum;
    /**
     * The vertex attributes to be computed.
     * Default: {@link VertexFormat#DEFAULT()}
     */
    @JsProperty
    public VertexFormat vertexFormat;
    /**
     * The width, depth, and height of the box stored in the x, y, and z coordinates of the Cartesian3, respectively.
     */
    @JsProperty
    public Cartesian3 dimensions;

    /**
     * Options for {@link org.cesiumjs.cs.core.geometry.BoxGeometry}
     */
    @JsConstructor
    public BoxGeometryOptions() {}
}
