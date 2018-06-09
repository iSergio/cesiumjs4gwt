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
import org.cesiumjs.cs.scene.apperances.options.MaterialAppearanceOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "MaterialAppearance")
public class MaterialAppearance extends Appearance {
//    public static staticCesium.MaterialAppearance.MaterialSupport Scene/MaterialAppearance.js 287
//
//    Determines the type of Material that is supported by a MaterialAppearance instance. This is a trade-off between flexibility (a wide array of materials) and memory/performance (required vertex format and GLSL shader complexity.
    /**
     * When true, the fragment shader flips the surface normal as needed to ensure that the normal
     * faces the viewer to avoid dark spots. This is useful when both sides of a geometry should be shaded like WallGeometry.
     * Default: true
     */
    @JsProperty(name = "faceForward")
    public native boolean faceForward();

    /**
     * When true, flat shading is used in the fragment shader, which means lighting is not taking into account.
     * Default: false
     */
    @JsProperty(name = "flat")
    public native boolean flat();

    /**
     * The type of materials supported by this instance. This impacts the required VertexFormat and the complexity of
     * the vertex and fragment shaders.
     * Default: MaterialAppearance.MaterialSupport.TEXTURED
     */
    @JsProperty(name = "materialSupport")
    public native MaterialSupport materialSupport();

    /**
     * The VertexFormat that this appearance instance is compatible with. A geometry can have more vertex attributes and
     * still be compatible - at a potential performance cost - but it can't have less.
     * Default: MaterialAppearance.MaterialSupport.TEXTURED.vertexFormat
     */
    @JsProperty(name = "vertexFormat")
    public native VertexFormat vertexFormat();

    /**
     * An appearance for arbitrary geometry (as opposed to {@link EllipsoidSurfaceAppearance}, for example) that supports shading with materials.
     */
    @JsConstructor
    public MaterialAppearance() {}

    /**
     * An appearance for arbitrary geometry (as opposed to {@link EllipsoidSurfaceAppearance}, for example) that supports shading with materials.
     * @param options {@link MaterialAppearanceOptions}
     */
    @JsConstructor
    public MaterialAppearance(MaterialAppearanceOptions options) {}

    @JsType(isNative = true, namespace = "Cesium", name = "MaterialAppearance.MaterialSupport")
    public class MaterialSupport {
        /**
         * Only basic materials, which require just position and normal vertex attributes, are supported.
         */
        @JsProperty(name = "BASIC")
        public native VertexFormat BASIC();
        /**
         * Materials with textures, which require position, normal, and st vertex attributes,
         * are supported.  The vast majority of materials fall into this category.
         */
        @JsProperty(name = "TEXTURED")
        public native VertexFormat TEXTURED();
        /**
         * All materials, including those that work in tangent space, are supported.
         * This requires position, normal, st,
         * binormal, and tangent vertex attributes.
         */
        @JsProperty(name = "ALL")
        public native VertexFormat ALL();

        @JsConstructor
        private MaterialSupport() {}
    }
}
