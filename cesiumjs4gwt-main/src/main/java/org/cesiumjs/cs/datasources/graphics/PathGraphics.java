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

package org.cesiumjs.cs.datasources.graphics;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOptional;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Event;
import org.cesiumjs.cs.datasources.graphics.options.PathGraphicsOptions;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PathGraphics")
public class PathGraphics {
    /**
     * Gets the event that is raised whenever a property or sub-property is changed or modified.
     */
    @JsProperty(name = "definitionChanged")
    public native Event definitionChanged();
    /**
     * A Property specifying the number of seconds behind the object to show.
     */
    @JsProperty
    public Property leadTime;
    /**
     * A Property specifying the number of seconds in front of the object to show.
     */
    @JsProperty
    public Property trailTime;
    /**
     * A boolean Property specifying the visibility of the path.
     * Default: true
     */
    @JsProperty
    public Property show;
    /**
     * A numeric Property specifying the width in pixels.
     * Default: 1.0
     */
    @JsProperty
    public Property width;
    /**
     * A Property specifying the material used to draw the path.
     * Default: {@link org.cesiumjs.cs.core.Color#WHITE()}
     */
    @JsProperty
    public MaterialProperty material;
    /**
     * A numeric Property specifying the maximum number of seconds to step when sampling the position.
     * Default: 60
     */
    @JsProperty
    public Property resolution;
    /**
     * A Property specifying at what distance from the camera that this path will be displayed.
     */
    @JsProperty
    public Property distanceDisplayCondition;

    /**
     * Describes a polyline defined as the path made by an {@link org.cesiumjs.cs.datasources.Entity} as it moves over time.
     */
    @JsConstructor
    public PathGraphics() {}

    /**
     * Describes a polyline defined as the path made by an {@link org.cesiumjs.cs.datasources.Entity} as it moves over time.
     * @param options Options
     */
    @JsConstructor
    public PathGraphics(PathGraphicsOptions options) {}

    /**
     * Duplicates this instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new instance if one was not provided.
     */
    public native PathGraphics clone(@JsOptional PathGraphics result);

    /**
     * Assigns each unassigned property on this object to the value of the same property on the provided source object.
     * @param source The object to be merged into this object.
     */
    public native void merge(PathGraphics source);
}
