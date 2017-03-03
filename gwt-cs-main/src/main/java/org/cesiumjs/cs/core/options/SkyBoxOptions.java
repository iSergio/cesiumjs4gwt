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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.*;
import org.cesiumjs.cs.core.SkyBoxSources;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SkyBoxOptions {
    /**
     * The source URL or Image object for each of the six cube map faces. See the example below.
     */
    @JsProperty
    public SkyBoxSources sources;
    /**
     * Determines if this primitive will be shown.
     * Default: true
     */
    public boolean show;

    @JsConstructor
    public SkyBoxOptions() {}

    /**
     * Destroys the WebGL resources held by this object. Destroying an object allows for deterministic release of WebGL
     * resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @see #isDestroyed()
     */
    @JsMethod
    public native void destroy();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     *
     * If this object was destroyed, it should not be used; calling any function other than isDestroyed will result in a
     * DeveloperError exception.
     * @return true if this object was destroyed; otherwise, false.
     * @see #destroy()
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Called when Viewer or CesiumWidget render the scene to get the draw commands needed to render this primitive.
     * Do not call this function directly. This is documented just to list the exceptions that may be propagated when the scene is rendered:
     */
    @JsMethod
    public native void update();
}
