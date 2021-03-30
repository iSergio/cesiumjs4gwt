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

import jsinterop.annotations.*;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.PostProcessStage;

/**
 * Options for {@link org.cesiumjs.cs.scene.PostProcessStageComposite}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PostProcessStageCompositeOptions {
    /**
     * An array of {@link PostProcessStage}'s or composites to be executed in order.
     */
    @JsProperty
    public PostProcessStage[] stages;
    /**
     * Whether to execute each post-process stage where the input to one stage is
     * the output of the previous. Otherwise, the input to each contained stage is
     * the output of the stage that executed before the composite. Default: true
     */
    @JsProperty
    public boolean inputPreviousStageTexture;
    /**
     * An alias to the uniforms of post-process stages.
     */
    @JsProperty
    public JsObject uniforms;
    /**
     * The unique name of this post-process stage for reference by other composites.
     * If a name is not supplied, a GUID will be generated. Default: createGuid()
     */
    @JsProperty
    String name;

    @JsConstructor
    private PostProcessStageCompositeOptions() {
    }

    @JsOverlay
    public static PostProcessStageCompositeOptions create(PostProcessStage[] stages) {
        PostProcessStageCompositeOptions options = new PostProcessStageCompositeOptions();
        options.stages = stages;
        return options;
    }
}
