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
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.VertexFormat;
import org.cesiumjs.cs.scene.apperances.options.PolylineMaterialAppearanceOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "PolylineMaterialAppearance")
public class PolylineMaterialAppearance extends Appearance {
    /**
     * The {@link VertexFormat} that all {@link PolylineMaterialAppearance} instances are compatible with.
     * This requires position and st attributes.
     */
    @JsProperty(name = "VERTEX_FORMAT")
    public static native VertexFormat VERTEX_FORMAT();

    /**
     * The VertexFormat that this appearance instance is compatible with. A geometry can have more vertex attributes and
     * still be compatible - at a potential performance cost - but it can't have less.
     * Default: {@link PolylineMaterialAppearance#VERTEX_FORMAT()}
     */
    @JsProperty(name = "vertexFormat")
    public native VertexFormat vertexFormat();

    /**
     * An appearance for {@link PolylineGeometry} that supports shading with materials.
     */
    @JsConstructor
    public PolylineMaterialAppearance() {}

    /**
     * An appearance for {@link PolylineGeometry} that supports shading with materials.
     * @param options {@link PolylineMaterialAppearanceOptions}
     */
    @JsConstructor
    public PolylineMaterialAppearance(PolylineMaterialAppearanceOptions options) {}
}
