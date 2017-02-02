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

/**
 * The direction to display an ImageryLayer relative to the {@link org.cesiumjs.cs.scene.Scene#imagerySplitPosition}.
 * @see org.cesiumjs.cs.scene.ImageryLayer#splitDirection
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ImagerySplitDirection")
public class ImagerySplitDirection {
    /**
     * Display the ImageryLayer to the left of the Scene#imagerySplitPosition.
     */
    @JsProperty(name = "LEFT")
    public static native Number LEFT();
    /**
     * Always display the ImageryLayer.
     */
    @JsProperty(name = "NONE")
    public static native Number NONE();
    /**
     * Display the ImageryLayer to the right of the Scene#imagerySplitPosition.
     */
    @JsProperty(name = "RIGHT")
    public static native Number RIGHT();

    @JsConstructor
    private ImagerySplitDirection() {}
}
