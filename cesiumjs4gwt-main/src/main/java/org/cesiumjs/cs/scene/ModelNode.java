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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Matrix4;

/**
 * A model node with a transform for user-defined animations. A glTF asset can contain animations that target a
 * node's transform. This class allows changing a node's transform externally so animation can be driven by another source,
 * not just an animation in the glTF asset.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ModelNode")
public class ModelNode {
    /**
     * The name of the glTF JSON property for this node. This is guaranteed to be unique among all nodes.
     * It may not match the node's name property {@link ModelNode#name}, which is assigned by the artist when the asset is created.
     */
    @JsProperty(name = "id")
    public native String id();

    /**
     * The node's 4x4 matrix transform from its local coordinates to its parent's.
     *
     * For changes to take effect, this property must be assigned to; setting individual elements of the matrix will not work.
     */
    @JsProperty
    public Matrix4 matrix;
    /**
     * The value of the name property of this node. This is the name assigned by the artist when the asset is created.
     * This can be different than the name of the node property {@link ModelNode#id}, which is internal to glTF.
     */
    @JsProperty(name = "name")
    public native String name();

    /**
     * Determines if this node and its children will be shown.
     * Default: true.
     */
    @JsProperty
    public boolean show;

    /**
     * Use {@link Model#getNode} to create an instance.
     */
    @JsConstructor
    public ModelNode() {}
}
