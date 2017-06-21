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

/**
 * A model's mesh and its materials.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class ModelMesh {
    /**
     * The name of the glTF JSON property for this mesh. This is guaranteed to be unique among all meshes.
     * It may not match the mesh's name property (@link ModelMesh#name),
     * which is assigned by the artist when the asset is created.
     */
    @JsProperty(name = "id")
    public native String id();

    /**
     * An array of ModelMaterial instances indexed by the mesh's primitive indices.
     */
    @JsProperty(name = "materials")
    public native ModelMaterial[] materials();

    /**
     * The value of the name property of this mesh. This is the name assigned by the artist when the asset is created.
     * This can be different than the name of the mesh property {@link ModelMesh#id}, which is internal to glTF.
     */
    @JsProperty(name = "name")
    public native String name();

    /**
     * Use {@link Model#getMesh} to create an instance.
     */
    @JsConstructor
    public ModelMesh() {}
}
