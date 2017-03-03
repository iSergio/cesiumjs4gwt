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

package org.cesiumjs.cs.collections;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.options.LabelCollectionOptions;
import org.cesiumjs.cs.core.Matrix4;
import org.cesiumjs.cs.scene.Label;
import org.cesiumjs.cs.scene.enums.BlendOption;
import org.cesiumjs.cs.scene.options.LabelOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
//TODO: Example
@JsType(isNative = true, namespace = "Cesium", name = "LabelCollection")
public class LabelCollection extends Collection<Label> {
    /**
     * The billboard blending option. The default is used for rendering both opaque and translucent billboards.
     * However, if either all of the billboards are completely opaque or all are completely translucent, setting the
     * technique to BillboardRenderTechnique.OPAQUE or BillboardRenderTechnique.TRANSLUCENT can improve performance by up to 2x.
     * Default: {@link BlendOption#OPAQUE_AND_TRANSLUCENT()}
     */
    @JsProperty
    public Number blendOption;
    /**
     * This property is for debugging only; it is not for production use nor is it optimized.
     *
     * Draws the bounding sphere for each draw command in the primitive.
     *
     * Default: false
     */
    @JsProperty
    public boolean debugShowBoundingVolume;
    /**
     * The 4x4 transformation matrix that transforms each label in this collection from model to world coordinates.
     * When this is the identity matrix, the labels are drawn in world coordinates, i.e., Earth's WGS84 coordinates.
     * Local reference frames can be used by providing a different transformation matrix, like that returned by Transforms.eastNorthUpToFixedFrame.
     * Default: {@link Matrix4#IDENTITY()}
     */
    //TODO: examples
    @JsProperty
    public Matrix4 modelMatrix;

    @JsConstructor
    public LabelCollection() {}

    @JsConstructor
    public LabelCollection(LabelCollectionOptions options) {}

    /**
     * Creates and adds a label with the specified initial properties to the collection. The added label is returned
     * so it can be modified or removed from the collection later.
     *
     * Calling add is expected constant time. However, the collection's vertex buffer is rewritten; this operations is O(n)
     * and also incurs CPU to GPU overhead. For best performance, add as many billboards as possible before calling update.
     * @param options A template describing the label's properties.
     * @return The label that was added to the collection.
     * @see #remove
     * @see #removeAll
     */
    @JsMethod
    public native Label add(LabelOptions options);
}
