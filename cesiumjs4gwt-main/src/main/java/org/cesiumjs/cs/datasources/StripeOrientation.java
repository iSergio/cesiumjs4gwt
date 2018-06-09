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

package org.cesiumjs.cs.datasources;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.datasources.properties.StripeMaterialProperty;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "StripeOrientation")
public class StripeOrientation {
    /**
     * Horizontal orientation.
     */
    @JsProperty(name = "HORIZONTAL")
    public static native Integer HORIZONTAL();
    /**
     * Vertical orientation.
     */
    @JsProperty(name = "VERTICAL")
    public static native Integer VERTICAL();

    /**
     * Defined the orientation of stripes in {@link StripeMaterialProperty}.
     */
    @JsConstructor
    private StripeOrientation() {}
}
