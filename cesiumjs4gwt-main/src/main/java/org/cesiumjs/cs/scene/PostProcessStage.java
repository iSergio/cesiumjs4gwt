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

import org.cesiumjs.cs.core.BoundingRectangle;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.core.enums.PixelDatatype;
import org.cesiumjs.cs.core.enums.PixelFormat;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.enums.PostProcessStageSampleMode;
import org.cesiumjs.cs.scene.options.PostProcessStageOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Runs a post-process stage on either the texture rendered by the scene or the
 * output of a previous post-process stage.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PostProcessStage")
public class PostProcessStage implements PostProcess {
  /**
   * The color to clear the output texture to.
   */
  @JsProperty(name = "clearColor")
  public native Color clearColor();

  /**
   * Whether or not to execute this post-process stage when ready.
   */
  @JsProperty
  public boolean enabled;

  /**
   * Whether or not to force the output texture dimensions to be both equal powers
   * of two. The power of two will be the next power of two of the minimum of the
   * dimensions.
   */
  @JsProperty(name = "forcePowerOfTwo")
  public native double forcePowerOfTwo();

  /**
   * The fragment shader to use when execute this post-process stage. The shader
   * must contain a sampler uniform declaration for colorTexture, depthTexture, or
   * both. The shader must contain a vec2 varying declaration for
   * v_textureCoordinates for sampling the texture uniforms.
   */
  @JsProperty(name = "fragmentShader")
  public native String fragmentShader();

  /**
   * The unique name of this post-process stage for reference by other stages in a
   * PostProcessStageComposite.
   */
  @JsProperty(name = "name")
  public native String name();

  /**
   * The pixel data type of the output texture.
   */
  @JsProperty(name = "pixelDatatype")
  public native PixelDatatype pixelDatatype();

  /**
   * The color pixel format of the output texture.
   */
  @JsProperty(name = "pixelFormat")
  public native PixelFormat pixelFormat();

  /**
   * Determines if this post-process stage is ready to be executed. A stage is
   * only executed when both ready and PostProcessStage#enabled are true. A stage
   * will not be ready while it is waiting on textures to load.
   */
  @JsProperty(name = "ready")
  public native boolean ready();

  /**
   * How to sample the input color texture.
   */
  @JsProperty(name = "sampleMode")
  public native PostProcessStageSampleMode sampleMode();

  /**
   * The BoundingRectangle to use for the scissor test. A default bounding
   * rectangle will disable the scissor test.
   */
  @JsProperty(name = "scissorRectangle")
  public native BoundingRectangle scissorRectangle();

  /**
   * A number in the range (0.0, 1.0] used to scale the output texture dimensions.
   * A scale of 1.0 will render this post-process stage to a texture the size of
   * the viewport.
   */
  @JsProperty(name = "textureScale")
  public native double textureScale();

  /**
   * An object whose properties are used to set the uniforms of the fragment
   * shader. The object property values can be either a constant or a function.
   * The function will be called each frame before the post-process stage is
   * executed.
   *
   * A constant value can also be a URI to an image, a data URI, or an HTML
   * element that can be used as a texture, such as HTMLImageElement or
   * HTMLCanvasElement.
   *
   * If this post-process stage is part of a PostProcessStageComposite that does
   * not execute in series, the constant value can also be the name of another
   * stage in a composite. This will set the uniform to the output texture the
   * stage with that name.
   */
  @JsProperty(name = "uniforms")
  public native JsObject uniforms();

  // TODO: Example usage
  @JsConstructor
  public PostProcessStage(PostProcessStageOptions options) {
  }

  /**
   * Simple create instance of {@link PostProcessStage}.
   * 
   * @param fragmentShader The fragment shader to use
   * @return new instance of {@link PostProcessStage}.
   */
  @JsOverlay
  public static PostProcessStage create(String fragmentShader) {
    return new PostProcessStage(PostProcessStageOptions.create(fragmentShader));
  }

  /**
   * Destroys the WebGL resources held by this object. Destroying an object allows
   * for deterministic release of WebGL resources, instead of relying on the
   * garbage collector to destroy this object. Once an object is destroyed, it
   * should not be used; calling any function other than isDestroyed will result
   * in a DeveloperError exception. Therefore, assign the return value (undefined)
   * to the object as done in the example.
   */
  @JsMethod
  public native void destroy();

  /**
   * Returns true if this object was destroyed; otherwise, false. If this object
   * was destroyed, it should not be used; calling any function other than
   * isDestroyed will result in a DeveloperError exception.
   * 
   * @return true if this object was destroyed; otherwise, false.
   */
  @JsMethod
  public native boolean isDestroyed();
}
