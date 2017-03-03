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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TranslationRotationScale")
public class TranslationRotationScale {
    /**
     * Gets or sets the (x, y, z, w) rotation to apply to the node.
     * Default: {@link Quaternion#IDENTITY()}
     */
    public Quaternion rotation;
    /**
     * Gets or sets the (x, y, z) scaling to apply to the node.
     * Default: new Cartesian3(1.0, 1.0, 1.0)
     */
    public Cartesian3 scale;
    /**
     * Gets or sets the (x, y, z) translation to apply to the node.
     * Default: {@link Cartesian3#ZERO()}
     */
    public Cartesian3 translation;

    /**
     * An affine transformation defined by a translation, rotation, and scale.
     */
    @JsConstructor
    public TranslationRotationScale() {}

    /**
     * An affine transformation defined by a translation, rotation, and scale.
     * @param translation A Cartesian3 specifying the (x, y, z) translation to apply to the node. Default: {@link Cartesian3#ZERO()}
     * @param rotation A Quaternion specifying the (x, y, z, w) rotation to apply to the node. Default: {@link Quaternion#IDENTITY()}
     * @param scale A Cartesian3 specifying the (x, y, z) scaling to apply to the node. Default: new Cartesian3(1.0, 1.0, 1.0)
     */
    @JsConstructor
    public TranslationRotationScale(Cartesian3 translation, Quaternion rotation, Cartesian3 scale) {}

    /**
     * Compares this instance against the provided instance and returns true if they are equal, false otherwise.
     * @param right The right hand side TranslationRotationScale.
     * @return true if they are equal, false otherwise.
     */
    public native boolean equals(TranslationRotationScale right);
}
