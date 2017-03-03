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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.Quaternion;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "VelocityOrientationProperty")
public class VelocityOrientationProperty extends Property<Quaternion> {
    /**
     * Gets or sets the ellipsoid used to determine which way is up.
     */
    @JsProperty
    public Ellipsoid ellipsoid;
    /**
     * Gets or sets the position property used to compute orientation.
     */
    @JsProperty
    public Property position;
    /**
     * A {@link Property} which evaluates to a {@link Quaternion} rotation based on the velocity of the provided {@link PositionProperty}.
     */
    @JsConstructor
    public VelocityOrientationProperty() {}
    /**
     * A {@link Property} which evaluates to a {@link Quaternion} rotation based on the velocity of the provided {@link PositionProperty}.
     * @param position The position property used to compute the orientation.
     */
    @JsConstructor
    public VelocityOrientationProperty(Property position) {}
    /**
     * A {@link Property} which evaluates to a {@link Quaternion} rotation based on the velocity of the provided {@link PositionProperty}.
     * @param position The position property used to compute the orientation.
     * @param ellipsoid The ellipsoid used to determine which way is up.
     */
    @JsConstructor
    public VelocityOrientationProperty(Property position, Ellipsoid ellipsoid) {}
}
