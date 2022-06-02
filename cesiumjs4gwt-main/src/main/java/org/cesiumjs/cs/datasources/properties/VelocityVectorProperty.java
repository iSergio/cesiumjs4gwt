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

/**
 * A {@link Property} which evaluates to a
 * {@link org.cesiumjs.cs.core.Cartesian3} vector based on the velocity of the
 * provided {@link PositionProperty}.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "VelocityVectorProperty")
public class VelocityVectorProperty<T extends Cartesian3> extends Property<T> {
    /**
     * Gets or sets whether the vector produced by this property will be normalized
     * or not.
     */
    @JsProperty
    public boolean normalize;
    /**
     * Gets or sets the position property used to compute the velocity vector.
     */
    @JsProperty
    public Property<T> position;

    /**
     * A {@link Property} which evaluates to a
     * {@link org.cesiumjs.cs.core.Cartesian3} vector based on the velocity of the
     * provided {@link PositionProperty}.
     */
    @JsConstructor
    public VelocityVectorProperty() {
    }

    /**
     * A {@link Property} which evaluates to a
     * {@link org.cesiumjs.cs.core.Cartesian3} vector based on the velocity of the
     * provided {@link PositionProperty}.
     *
     * @param position The position property used to compute the velocity.
     */
    @JsConstructor
    public VelocityVectorProperty(Property<T> position) {
    }

    /**
     * A {@link Property} which evaluates to a
     * {@link org.cesiumjs.cs.core.Cartesian3} vector based on the velocity of the
     * provided {@link PositionProperty}.
     *
     * @param position  The position property used to compute the velocity.
     * @param normalize Whether to normalize the computed velocity vector.
     */
    @JsConstructor
    public VelocityVectorProperty(Property<T> position, boolean normalize) {
    }
}
