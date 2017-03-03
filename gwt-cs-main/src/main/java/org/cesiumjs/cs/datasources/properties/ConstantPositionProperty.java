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

package org.cesiumjs.cs.datasources.properties;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.enums.ReferenceFrame;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ConstantPositionProperty")
public class ConstantPositionProperty extends PositionProperty {
    /**
     * Gets the reference frame in which the position is defined.
     * Default: {@link ReferenceFrame#FIXED()};
     */
    @JsProperty
    public Integer referenceFrame;

    /**
     * A {@link PositionProperty} whose value does not change in respect to the {@link ReferenceFrame} in which is it defined.
     */
    @JsConstructor
    public ConstantPositionProperty() {}

    /**
     * A {@link PositionProperty} whose value does not change in respect to the {@link ReferenceFrame} in which is it defined.
     * @param value The property value.
     */
    @JsConstructor
    public ConstantPositionProperty(Cartesian3 value) {}

    /**
     * A {@link PositionProperty} whose value does not change in respect to the {@link ReferenceFrame} in which is it defined.
     * @param value The property value.
     * @param referenceFrame {@link ReferenceFrame}. Default: {@link ReferenceFrame#FIXED()}
     */
    @JsConstructor
    public ConstantPositionProperty(Cartesian3 value, Integer referenceFrame) {}

    /**
     * Sets the value of the property.
     * @param value The property value.
     */
    @JsMethod
    public native void setValue(Cartesian3 value);

    /**
     * Sets the value of the property.
     * @param value The property value.
     * @param referenceFrame {@link ReferenceFrame} The reference frame in which the position is defined. Default: this.referenceFrame
     */
    @JsMethod
    public native void setValue(Cartesian3 value, Integer referenceFrame);
}
