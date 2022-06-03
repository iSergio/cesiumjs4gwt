/*
 * Copyright 2019 iserge.
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

package org.cesiumjs.cs.datasources.properties;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Quaternion;
import org.cesiumjs.cs.core.TranslationRotationScale;
import org.cesiumjs.cs.datasources.properties.options.NodeTransformationPropertyOptions;

/**
 * A {@link Property} that produces {@link TranslationRotationScale} data.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "NodeTransformationProperty")
public class NodeTransformationProperty<T extends TranslationRotationScale> extends Property<T> {
    /**
     * Gets or sets the Quaternion Property specifying the (x, y, z, w) rotation to
     * apply to the node. Default: {@link Quaternion#IDENTITY()}.
     */
    @JsProperty
    public Property<Quaternion> rotation;
    /**
     * Gets or sets the Cartesian3 Property specifying the (x, y, z) scaling to
     * apply to the node. Default: new Cartesian3(1.0, 1.0, 1.0)
     */
    @JsProperty
    public Property<Cartesian3> scale;
    /**
     * Gets or sets the Cartesian3 Property specifying the (x, y, z) translation to
     * apply to the node. Default: {@link Cartesian3#ZERO()}
     */
    @JsProperty
    public Property<Cartesian3> translation;

    @JsConstructor
    public NodeTransformationProperty() {}

    @JsConstructor
    public NodeTransformationProperty(NodeTransformationPropertyOptions options) {
    }
}
