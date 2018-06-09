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

package org.cesiumjs.cs.scene.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.scene.Label;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "LabelStyle")
public class LabelStyle {
    /**
     * Fill the text of the label, but do not outline.
     */
    @JsProperty(name = "FILL")
    public static native Number FILL();
    /**
     * Fill and outline the text of the label.
     */
    @JsProperty(name = "FILL_AND_OUTLINE")
    public static native Number FILL_AND_OUTLINE();
    /**
     * Outline the text of the label, but do not fill.
     */
    @JsProperty(name = "OUTLINE")
    public static native Number OUTLINE();

    /**
     * Describes how to draw a label.
     * @see Label#style
     */
    @JsConstructor
    private LabelStyle() {}
}
