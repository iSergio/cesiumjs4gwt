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
import org.cesiumjs.cs.core.PolygonHierarchy;

/**
 * Options for {@link org.cesiumjs.cs.core.geometry.PolygonGeometry}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PolygonGeometryOptions extends PolygonOutlineGeometryOptions {
    /**
     * The rotation of the texture coordinates, in radians. A positive rotation is
     * counter-clockwise. Default: 0.0
     */
    @JsProperty
    public double stRotation;
    /**
     * When false, leaves off the top of an extruded polygon open. Default: true
     */
    @JsProperty
    public boolean closeTop;
    /**
     * When false, leaves off the bottom of an extruded polygon open. Default: true
     */
    @JsProperty
    public boolean closeBottom;
    /**
     * Texture coordinates as a PolygonHierarchy of Cartesian2 points. Has no effect for ground primitives.
     */
    @JsProperty
    public PolygonHierarchy textureCoordinates;

    /**
     * Options for {@link org.cesiumjs.cs.core.geometry.PolygonGeometry}
     */
    @JsConstructor
    public PolygonGeometryOptions() {
    }
}
