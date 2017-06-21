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

package org.cesiumjs.cs.scene.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Matrix4;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FromGltfOptions {
    /**
     * The url to the .gltf file.
     */
    @JsProperty
    public String url;
    /**
     * HTTP headers to send with the request.
     */
    @JsProperty
    public Object headers;
    /**
     * Determines if the model primitive will be shown.
     * Default: true.
     */
    @JsProperty
    public boolean show;
    /**
     * The 4x4 transformation matrix that transforms the model from model to world coordinates.
     * Default: {@link Matrix4#IDENTITY()}.
     */
    @JsProperty
    public Matrix4 modelMatrix;
    /**
     * A uniform scale applied to this model.
     * Default: 1.0.
     */
    @JsProperty
    public double scale;
    /**
     * The approximate minimum pixel size of the model regardless of zoom.
     * DEfault: 0.0.
     */
    @JsProperty
    public double minimumPixelSize;
    /**
     * The maximum scale size of a model. An upper limit for minimumPixelSize.
     */
    @JsProperty
    public double maximumScale;
    /**
     * A user-defined object to return when the model is picked with Scene#pick.
     */
    @JsProperty
    public Object id;
    /**
     * When true, each glTF mesh and primitive is pickable with {@link org.cesiumjs.cs.scene.Scene#pick}
     * Default: true.
     */
    @JsProperty
    public boolean allowPicking;
    /**
     * Determine if textures may continue to stream in after the model is loaded.
     * Default: true.
     */
    @JsProperty
    public boolean incrementallyLoadTextures;
    /**
     * Determines if model WebGL resource creation will be spread out over several frames or block until completion once all glTF files are loaded.
     * Default: true.
     */
    @JsProperty
    public boolean asynchronous;
    /**
     * Determines whether the model casts or receives shadows from each light source.
     * Default: {@link org.cesiumjs.cs.scene.enums.ShadowMode#ENABLED()}.
     */
    @JsProperty
    public Number shadows;
    /**
     * For debugging only. Draws the bounding sphere for each draw command in the model.
     * Default: false.
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * For debugging only. Draws the model in wireframe.
     * Default: false.
     */
    @JsProperty
    public boolean debugWireframe;
    /**
     * Determines how the model is drawn relative to terrain. {@link org.cesiumjs.cs.scene.enums.HeightReference}.
     */
    @JsProperty
    public Number heightReference;

    @JsConstructor
    public FromGltfOptions() {}
}
