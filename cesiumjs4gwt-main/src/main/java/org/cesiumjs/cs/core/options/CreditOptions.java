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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for {@link org.cesiumjs.cs.core.Credit}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CreditOptions {
    /**
     * The text to be displayed on the screen if no imageUrl is specified.
     */
    @JsProperty
    public String text;
    /**
     * The source location for an image
     */
    @JsProperty
    public String imageUrl;
    /**
     * A URL location for which the credit will be hyperlinked
     */
    @JsProperty
    public String link;
    /**
     * If true, the credit will be visible in the main credit container. Otherwise, it will appear in a popover
     * Default: false
     */
    @JsProperty
    public boolean showOnScreen;

    @JsConstructor
    public CreditOptions() {}
}
