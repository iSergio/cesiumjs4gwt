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

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.PolygonHierarchy;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CoplanarPolygonGeometryOptions {
    /**
     * A polygon hierarchy that can include holes.
     */
    @JsProperty
    public PolygonHierarchy polygonHierarchy;
    /**
     * The rotation of the texture coordinates, in radians. A positive rotation is
     * counter-clockwise. Default: 0.0
     */
    @JsProperty
    public double stRotation;
    /**
     * The vertex attributes to be computed. Default:
     * {@link org.cesiumjs.cs.core.VertexFormat#DEFAULT()}
     */
    @JsProperty
    public Number vertexFormat;
    /**
     * Texture coordinates as a {@link PolygonHierarchy} of {@link Cartesian2} points.
     */
    @JsProperty
    public PolygonHierarchy textureCoordinates;

    @JsConstructor
    private CoplanarPolygonGeometryOptions() {
    }

    @JsOverlay
    public static CoplanarPolygonGeometryOptions create(PolygonHierarchy polygonHierarchy) {
        CoplanarPolygonGeometryOptions options = new CoplanarPolygonGeometryOptions();
        options.polygonHierarchy = polygonHierarchy;
        return options;
    }
}
