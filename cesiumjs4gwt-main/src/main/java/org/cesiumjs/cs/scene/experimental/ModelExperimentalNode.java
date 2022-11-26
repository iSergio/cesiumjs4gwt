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

package org.cesiumjs.cs.scene.experimental;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Matrix4;

/**
 * A model node with a modifiable transform to allow users to define their own animations. While a model's asset can
 * contain animations that target a node's transform, this class allows users to change a node's transform externally.
 * In this way, animation can be driven by another source, not just by the model's asset.
 * Use ModelExperimental#getNode to get an instance from a loaded model.
 *
 * @see ModelExperimental#getNode(String)
 */
@JsType(isNative = true, namespace = "Cesium", name = "ModelExperimentalNode")
public class ModelExperimentalNode {
    /**
     * The index of the node in the glTF.
     */
    @JsProperty(name = "id")
    public native Number id();
    /**
     * The node's 4x4 matrix transform from its local coordinates to its parent's. Setting the matrix to undefined will
     * restore the node's original transform, and allow the node to be animated by any animations in the model again.
     * For changes to take effect, this property must be assigned to; setting individual elements of the
     * matrix will not work.
     */
    @JsProperty
    public Matrix4 matrix;
    /**
     * The value of the name property of this node.
     */
    @JsProperty(name = "name")
    public native String name();
    /**
     * Gets the node's original 4x4 matrix transform from its local coordinates to its parent's, without any node
     * transformations or articulations applied.
     */
    @JsProperty
    public Matrix4 originalMatrix;
    /**
     * Determines if this node and its children will be shown.
     * Default: true
     */
    @JsProperty
    public boolean show;

    @JsConstructor
    private ModelExperimentalNode() {}
}
