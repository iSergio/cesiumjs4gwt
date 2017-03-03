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

package org.cesiumjs.cs.datasources.visualizer;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.collections.EntityCollection;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.datasources.updater.GeometryUpdater;
import org.cesiumjs.cs.scene.Scene;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "GeometryVisualizer")
public class GeometryVisualizer implements Visualizer {
    /**
     * A general purpose visualizer for geometry represented by {@link org.cesiumjs.cs.scene.Primitive} instances.
     * @param type The updater to be used for creating the geometry.
     * @param scene The scene the primitives will be rendered in.
     * @param entityCollection The entityCollection to visualize.
     */
    @JsConstructor
    public GeometryVisualizer(GeometryUpdater type, Scene scene, EntityCollection entityCollection) {}

    /**
     * Removes and destroys all primitives created by this instance.
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     * @return True if this object was destroyed; otherwise, false.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Updates the primitives created by this visualizer to match their Entity counterpart at the given time.
     * @param time The time to update to.
     * @return This function always returns true.
     */
    @JsMethod
    public native boolean update(JulianDate time);
}
