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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Contains functions for creating common post-process stages.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PostProcessStageLibrary")
public class PostProcessStageLibrary {
    @JsConstructor
    private PostProcessStageLibrary() {
    }

    /**
     * Creates a post-process stage that renders the input texture with black and
     * white gradations. This stage has one uniform value, gradations, which scales
     * the luminance of each pixel.
     *
     * @return A post-process stage that renders the input texture with black and
     * white gradations.
     */
    @JsMethod
    public static native PostProcessStage createBlackAndWhiteStage();

    /**
     * Creates a post-process stage that applies a Gaussian blur to the input
     * texture. This stage is usually applied in conjunction with another stage.
     * This stage has the following uniforms: delta, sigma, and stepSize.
     * <p>
     * delta and sigma are used to compute the weights of a Gaussian filter. The
     * equation is exp((-0.5 * delta * delta) / (sigma * sigma)). The default value
     * for delta is 1.0. The default value for sigma is 2.0. stepSize is the
     * distance to the next texel. The default is 1.0.
     *
     * @return A post-process stage that applies a Gaussian blur to the input
     * texture.
     */
    @JsMethod
    public static native PostProcessStageComposite createBlurStage();

    /**
     * Creates a post-process stage that saturates the input texture. This stage has
     * one uniform value, brightness, which scales the saturation of each pixel.
     *
     * @return A post-process stage that saturates the input texture.
     */
    @JsMethod
    public static native PostProcessStage createBrightnessStage();

    /**
     * Creates a post-process stage that applies a depth of field effect. Depth of
     * field simulates camera focus. Objects in the scene that are in focus will be
     * clear whereas objects not in focus will be blurred. This stage has the
     * following uniforms: focalDistance, delta, sigma, and stepSize.
     * <p>
     * focalDistance is the distance in meters from the camera to set the camera
     * focus. delta, sigma, and stepSize are the same properties as
     * PostProcessStageLibrary#createBlurStage. The blur is applied to the areas out
     * of focus.
     *
     * @return A post-process stage that applies a depth of field effect.
     */
    @JsMethod
    public static native PostProcessStageComposite createDepthOfFieldStage();

    /**
     * Creates a post-process stage that applies an effect simulating light flaring
     * a camera lens. This stage has the following uniforms: dirtTexture,
     * starTexture, intensity, distortion, ghostDispersal, haloWidth, and
     * earthRadius. dirtTexture is a texture sampled to simulate dirt on the lens.
     * starTexture is the texture sampled for the star pattern of the flare.
     * intensity is a scalar multiplied by the result of the lens flare. The default
     * value is 2.0. distortion is a scalar value that affects the chromatic effect
     * distortion. The default value is 10.0. ghostDispesal is a scalar indicating
     * how far the halo effect is from the center of the texture. The default value
     * is 0.4. haloWidth is a scalar representing the width of the halo from the
     * ghost dispersal. The default value is 0.4. earthRadius is the maximum radius
     * of the earth. The default value is Ellipsoid.WGS84.maximumRadius.
     *
     * @return A post-process stage for applying a lens flare effect.
     */
    @JsMethod
    public static native PostProcessStage createLensFlareStage();

    /**
     * Creates a post-process stage that adds a night vision effect to the input
     * texture.
     *
     * @return A post-process stage that adds a night vision effect to the input
     * texture.
     */
    @JsMethod
    public static native PostProcessStage createNightVisionStage();

    /**
     * Creates a post-process stage that applies a silhouette effect. A silhouette
     * effect highlights the edges of an object.
     * <p>
     * This stage has the following uniforms: color and length
     * <p>
     * color is the color of the highlighted edge. The default is Color#BLACK.
     * length is the length of the edges in pixels. The default is 0.5.
     *
     * @return A post-process stage that applies a silhouette effect.
     */
    @JsMethod
    public static native PostProcessStageComposite createSilhouetteStage();

    /**
     * Whether or not an ambient occlusion stage is supported. This stage requires
     * the WEBGL_depth_texture extension.
     *
     * @param scene The scene.
     * @return Whether this post process stage is supported.
     */
    @JsMethod
    public static native boolean isAmbientOcclusionSupported(Scene scene);

    /**
     * Whether or not a depth of field stage is supported. This stage requires the
     * WEBGL_depth_texture extension.
     *
     * @param scene The scene.
     * @return Whether this post process stage is supported.
     */
    @JsMethod
    public static native boolean isDepthOfFieldSupported(Scene scene);

    /**
     * Whether or not an edge detection stage is supported. This stage requires the
     * WEBGL_depth_texture extension.
     *
     * @param scene The scene.
     * @return Whether this post process stage is supported.
     */
    @JsMethod
    public static native boolean isEdgeDetectionSupported(Scene scene);

    /**
     * Whether or not a silhouette stage is supported. This stage requires the
     * WEBGL_depth_texture extension.
     *
     * @param scene The scene.
     * @return Whether this post process stage is supported.
     */
    @JsMethod
    public static native boolean isSilhouetteSupported(Scene scene);
}
