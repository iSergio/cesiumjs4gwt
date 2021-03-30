/*
 * Copyright 2018 iserge.
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

package org.cesiumjs.cs.datasources.updater;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.JulianDate;

/**
 * Defines the interface for a dynamic geometry updater. A
 * {@link DynamicGeometryUpdater} is responsible for handling visualization of a
 * specific type of geometry that needs to be recomputed based on simulation
 * time. This object is never used directly by client code, but is instead
 * created by {@link GeometryUpdater} implementations which contain dynamic
 * geometry. This type defines an interface and cannot be instantiated directly.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "DynamicGeometryUpdater")
public interface DynamicGeometryUpdater {
    /**
     * Destroys and resources used by the object. Once an object is destroyed, it
     * should not be used.
     */
    @JsMethod
    void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * @return True if this object was destroyed; otherwise, false.
     */
    @JsMethod
    boolean isDestroyed();

    /**
     * Updates the geometry to the specified time.
     *
     * @param time The current time.
     */
    @JsMethod
    void update(JulianDate time);
}
