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

package org.cesiumjs.cs.collections.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.BillboardCollection;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.enums.BlendOption;

/**
 * Options for {@link BillboardCollection}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class BillboardCollectionOptions {
    /**
     * The 4x4 transformation matrix that transforms each billboard from model to
     * world coordinates. Default: {@link org.cesiumjs.cs.core.Matrix4#IDENTITY()}
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * For debugging only. Determines if this primitive's commands' bounding spheres
     * are shown. Default: false
     */
    @JsProperty
    public Boolean debugShowBoundingVolume;
    /**
     * Must be passed in for billboards that use the height reference property or
     * will be depth tested against the globe.
     */
    @JsProperty
    public Scene scene;
    /**
     * The billboard blending option. The default is used for rendering both opaque
     * and translucent billboards. However, if either all of the billboards are
     * completely opaque or all are completely translucent, setting the technique to
     * BillboardRenderTechnique.OPAQUE or BillboardRenderTechnique.TRANSLUCENT can
     * improve performance by up to 2x. Default:
     * {@link BlendOption#OPAQUE_AND_TRANSLUCENT()}
     */
    @JsProperty
    public Number blendOption;

    /**
     * Determines if the billboards in the collection will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;

    /**
     * Options for {@link BillboardCollection}.
     */
    @JsConstructor
    public BillboardCollectionOptions() {
    }

    /**
     * Options for {@link BillboardCollection}.
     */
    @JsConstructor
    public BillboardCollectionOptions(Matrix4 modelMatrix, Boolean debugShowBoundingVolume,
                                      Scene scene) {
    }
}
