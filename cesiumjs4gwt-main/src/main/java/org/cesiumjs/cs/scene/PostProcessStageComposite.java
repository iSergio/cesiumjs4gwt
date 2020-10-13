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

import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.options.PostProcessStageCompositeOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A collection of {@link PostProcessStage} or other post-process composite
 * stages that execute together logically. All stages are executed in the order
 * of the array. The input texture changes based on the value of
 * inputPreviousStageTexture. If inputPreviousStageTexture is true, the input to
 * each stage is the output texture rendered to by the scene or of the stage
 * that executed before it. If inputPreviousStageTexture is false, the input
 * texture is the same for each stage in the composite. The input texture is the
 * texture rendered to by the scene or the output texture of the previous stage.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "PostProcessStageComposite")
public class PostProcessStageComposite implements PostProcess {
  /**
   * Whether or not to execute this post-process stage when ready.
   */
  @JsProperty
  public boolean enabled;

  /**
   * All post-process stages are executed in the order of the array. The input
   * texture changes based on the value of inputPreviousStageTexture. If
   * inputPreviousStageTexture is true, the input to each stage is the output
   * texture rendered to by the scene or of the stage that executed before it. If
   * inputPreviousStageTexture is false, the input texture is the same for each
   * stage in the composite. The input texture is the texture rendered to by the
   * scene or the output texture of the previous stage.
   */
  @JsProperty(name = "inputPreviousStageTexture")
  public native boolean inputPreviousStageTexture();

  /**
   * The number of post-process stages in this composite.
   */
  @JsProperty(name = "length")
  public native int length();

  /**
   * The unique name of this post-process stage for reference by other stages in a
   * PostProcessStageComposite.
   */
  @JsProperty(name = "name")
  public native String name();

  /**
   * Determines if this post-process stage is ready to be executed.
   */
  @JsProperty(name = "ready")
  public native boolean ready();

  /**
   * An alias to the uniform values of the post-process stages. May be undefined;
   * in which case, get each stage to set uniform values.
   */
  @JsProperty
  public JsObject uniforms;

  @JsConstructor
  public PostProcessStageComposite(PostProcessStageCompositeOptions options) {
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
   * Gets the post-process stage at index
   * 
   * @param index The index of the post-process stage or composite.
   * @return The post-process stage or composite at index.
   */
  public native PostProcess getPostProcessStage(int index);

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
