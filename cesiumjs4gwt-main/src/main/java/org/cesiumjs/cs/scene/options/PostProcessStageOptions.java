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

package org.cesiumjs.cs.scene.options;

import org.cesiumjs.cs.core.BoundingRectangle;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.enums.PixelDatatype;
import org.cesiumjs.cs.core.enums.PixelFormat;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.enums.PostProcessStageSampleMode;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link org.cesiumjs.cs.scene.PostProcessStage}
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PostProcessStageOptions {
  /**
   * The fragment shader to use. The default sampler2D uniforms are colorTexture
   * and depthTexture. The color texture is the output of rendering the scene or
   * the previous stage. The depth texture is the output from rendering the scene.
   * The shader should contain one or both uniforms. There is also a vec2 varying
   * named v_textureCoordinates that can be used to sample the textures.
   */
  @JsProperty
  public String fragmentShader;
  /**
   * An object whose properties will be used to set the shaders uniforms. The
   * properties can be constant values or a function. A constant value can also be
   * a URI, data URI, or HTML element to use as a texture.
   */
  @JsProperty
  public JsObject uniforms;
  /**
   * A number in the range (0.0, 1.0] used to scale the texture dimensions. A
   * scale of 1.0 will render this post-process stage to a texture the size of the
   * viewport. Default: 1.0
   */
  @JsProperty
  public double textureScale;
  /**
   * Whether or not to force the texture dimensions to be both equal powers of
   * two. The power of two will be the next power of two of the minimum of the
   * dimensions. Default: false
   */
  @JsProperty
  public boolean forcePowerOfTwo;
  /**
   * How to sample the input color texture. Default:
   * {@link PostProcessStageSampleMode#NEAREST()}
   */
  @JsProperty
  public PostProcessStageSampleMode sampleMode;
  /**
   * The color pixel format of the output texture. Default:
   * {@link PixelFormat#RGBA()}
   */
  @JsProperty
  public PixelFormat pixelFormat;
  /**
   * The pixel data type of the output texture. Default:
   * {@link PixelDatatype#UNSIGNED_BYTE()}
   */
  @JsProperty
  public PixelDatatype pixelDatatype;
  /**
   * The color to clear the output texture to. Default: {@link Color#BLACK()}
   */
  @JsProperty
  public Color clearColor;
  /**
   * The rectangle to use for the scissor test.
   */
  @JsProperty
  public BoundingRectangle scissorRectangle;
  /**
   * The unique name of this post-process stage for reference by other stages in a
   * composite. If a name is not supplied, a GUID will be generated. Default:
   * createGuid()
   */
  @JsProperty
  public String name;

  @JsConstructor
  private PostProcessStageOptions() {
  }

  @JsOverlay
  public static PostProcessStageOptions create(String fragmentShader) {
    PostProcessStageOptions options = new PostProcessStageOptions();
    options.fragmentShader = fragmentShader;
    return options;
  }
}
