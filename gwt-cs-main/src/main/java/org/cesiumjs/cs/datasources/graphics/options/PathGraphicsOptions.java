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

package org.cesiumjs.cs.datasources.graphics.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.datasources.properties.MaterialProperty;
import org.cesiumjs.cs.datasources.properties.Property;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PathGraphicsOptions {
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
     * Options for {@link org.cesiumjs.cs.datasources.graphics.PathGraphics}
     */
    @JsConstructor
    public PathGraphicsOptions() {}
}
