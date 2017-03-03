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
import org.cesiumjs.cs.core.TimeInterval;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TimeIntervalCollectionProperty")
public class TimeIntervalCollectionProperty extends Property<TimeIntervalCollection> {
    /**
     * Gets the interval collection.
     */
    @JsProperty
    public TimeIntervalCollection intervals;

    //TODO: Example
    /**
     * A {@link Property} which is defined by a {@link TimeIntervalCollection},
     * where the data property of each {@link TimeInterval} represents the value at time.
     */
    @JsConstructor
    public TimeIntervalCollectionProperty() {}

    /**
     * Compares this property to the provided property and returns true if they are equal, false otherwise.
     * @param other The other property.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(TimeIntervalCollectionProperty other);
}
