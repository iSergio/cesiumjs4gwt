/*
 * Copyright 2022 iSergio, Gis4Fun.
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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Resource;
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.promise.Promise;

/**
 * This class implements an I3S Field which is custom data attached to nodes.
 */
@JsType(isNative = true, namespace = "Cesium", name = "I3SField")
public class I3SField {
    /**
     * Gets the header for this field.
     */
    @JsProperty(name = "header")
    public native JsObject header();

    /**
     * Gets the name for the field.
     */
    @JsProperty(name = "name")
    public native String name();

    /**
     * Gets the resource for the fields
     */
    @JsProperty(name = "resource")
    public native Resource resource();

    /**
     * Gets the values for this field.
     */
    @JsProperty(name = "values")
    public native JsObject values();

    @JsConstructor
    private I3SField() {}

    /**
     * Loads the content.
     * @return A promise that is resolved when the field data is loaded
     */
    @JsMethod
    private native Promise<Void, Void> load();
}
