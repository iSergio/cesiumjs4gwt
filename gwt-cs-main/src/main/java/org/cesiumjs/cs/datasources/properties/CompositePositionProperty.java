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
import org.cesiumjs.cs.collections.TimeIntervalCollection;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.enums.ReferenceFrame;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CompositePositionProperty")
public class CompositePositionProperty extends PositionProperty {
    /**
     * Gets the interval collection.
     */
    @JsProperty
    public TimeIntervalCollection intervals;

    /**
     * A {@link CompositeProperty} which is also a {@link PositionProperty}.
     */
    @JsConstructor
    public CompositePositionProperty() {}

    /**
     * A {@link CompositeProperty} which is also a {@link PositionProperty}.
     * @param referenceFrame {@link ReferenceFrame} The reference frame in which the position is defined.
     */
    @JsConstructor
    public CompositePositionProperty(Integer referenceFrame) {}

    /**
     * Gets the value of the property at the provided time and in the provided reference frame.
     * @param time The time for which to retrieve the value.
     * @param referenceFrame {@link ReferenceFrame} The desired referenceFrame of the result.
     * @return The modified result parameter or a new instance if the result parameter was not supplied.
     */
    @JsMethod
    public native Cartesian3 getValueInReferenceFrame(JulianDate time, Integer referenceFrame);

    /**
     * Gets the value of the property at the provided time and in the provided reference frame.
     * @param time The time for which to retrieve the value.
     * @param referenceFrame {@link ReferenceFrame} The desired referenceFrame of the result.
     * @param result The object to store the value into, if omitted, a new instance is created and returned.
     * @return The modified result parameter or a new instance if the result parameter was not supplied.
     */
    @JsMethod
    public native Cartesian3 getValueInReferenceFrame(JulianDate time, Integer referenceFrame, Cartesian3 result);
}
