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
import org.cesiumjs.cs.core.Cartesian2;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.scene.options.ImageBasedLightingOptions;

/**
 * Properties for managing image-based lighting on tilesets and models.
 * Also manages the necessary resources and textures.
 * <p>If specular environment maps are used, ImageBasedLighting#destroy must be called when the
 * image-based lighting is no longer needed to clean up GPU resources properly. If a model or tileset
 * creates an instance of ImageBasedLighting, it will handle this. Otherwise, the application is responsible
 * for calling destroy().</p>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ImageBasedLighting")
public class ImageBasedLighting {
    /**
     * Cesium adds lighting from the earth, sky, atmosphere, and star skybox. This cartesian is used to scale
     * the final diffuse and specular lighting contribution from those sources to the final color. A value of 0.0
     * will disable those light sources.
     * Default: Cartesian2(1.0, 1.0)
     */
    @JsProperty
    public Cartesian2 imageBasedLightingFactor;
    /**
     * The sun's luminance at the zenith in kilo candela per meter squared to use for this model's procedural
     * environment map. This is used when ImageBasedLighting#specularEnvironmentMaps and ImageBasedLighting#sphericalHarmonicCoefficients are not defined.
     * Default: 0.2
     */
    @JsProperty
    public double luminanceAtZenith;
    /**
     * A URL to a KTX2 file that contains a cube map of the specular lighting and the convoluted specular mipmaps.
     * Demo: Sandcastle Image Based Lighting Demo
     * @see ImageBasedLighting#sphericalHarmonicCoefficients
     */
    @JsProperty
    public String specularEnvironmentMaps;
    /**
     * The third order spherical harmonic coefficients used for the diffuse color of image-based lighting.
     * When undefined, a diffuse irradiance computed from the atmosphere color is used.
     * There are nine Cartesian3 coefficients. The order of the coefficients is:
     * L0,0, L1,-1, L1,0, L1,1, L2,-2, L2,-1, L2,0, L2,1, L2,2
     *
     * These values can be obtained by preprocessing the environment map using the cmgen tool of Google's Filament
     * project. This will also generate a KTX file that can be supplied to {@link Model#specularEnvironmentMaps}.
     */
    @JsProperty
    public Cartesian3[] sphericalHarmonicCoefficients;

    @JsConstructor
    public ImageBasedLighting() {}

    @JsConstructor
    public ImageBasedLighting(ImageBasedLightingOptions options) {}
}
