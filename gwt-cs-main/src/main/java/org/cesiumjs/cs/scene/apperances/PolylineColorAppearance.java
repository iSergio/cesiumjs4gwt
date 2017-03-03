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

package org.cesiumjs.cs.scene.apperances;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.VertexFormat;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.scene.Primitive;
import org.cesiumjs.cs.scene.apperances.options.PolylineColorAppearanceOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PolylineColorAppearance")
public class PolylineColorAppearance extends Appearance {
    /**
     * The VertexFormat that all {@link PolylineColorAppearance} instances are compatible with.
     * This requires only a position attribute.
     */
    @JsProperty(name = "VERTEX_FORMAT")
    public static native VertexFormat VERTEX_FORMAT();
    /**
     * The {@link VertexFormat} that this appearance instance is compatible with. A geometry can have more vertex
     * attributes and still be compatible - at a potential performance cost - but it can't have less.
     * Default: {@link PolylineColorAppearance#VERTEX_FORMAT()}
     */
    @JsProperty(name = "vertexFormat")
    public native VertexFormat vertexFormat();

    /**
     * An appearance for {@link GeometryInstance} instances with color attributes and {@link PolylineGeometry}.
     * This allows several geometry instances, each with a different color, to be drawn with the same {@link Primitive}.
     */
    @JsConstructor
    public PolylineColorAppearance() {}

    /**
     * An appearance for {@link GeometryInstance} instances with color attributes and {@link PolylineGeometry}.
     * This allows several geometry instances, each with a different color, to be drawn with the same {@link Primitive}.
     * @param options {@link PolylineColorAppearanceOptions}
     */
    @JsConstructor
    public PolylineColorAppearance(PolylineColorAppearanceOptions options) {}
}
