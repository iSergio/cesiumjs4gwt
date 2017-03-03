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

package org.cesiumjs.cs.datasources.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class EntityClusterOptions {
    /**
     * Whether or not to enable clustering.
     * Default: false
     */
    @JsProperty
    public boolean enabled;
    /**
     * The pixel range to extend the screen space bounding box.
     * Default: 80
     */
    @JsProperty
    public int pixelRange;
    /**
     * The minimum number of screen space objects that can be clustered.
     * Default: 2
     */
    @JsProperty
    public int minimumClusterSize;
}
