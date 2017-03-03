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

package org.cesiumjs.cs.scene;

import com.google.gwt.user.client.ui.Image;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "TileDiscardPolicy")
public class TileDiscardPolicy {
    /**
     * A policy for discarding tile images according to some criteria.
     * This type describes an interface and is not intended to be instantiated directly.
     */
    @JsConstructor
    public TileDiscardPolicy() {}

    /**
     * Determines if the discard policy is ready to process images.
     * @return True if the discard policy is ready to process images; otherwise, false.
     */
    @JsMethod
    public native boolean isReady();

    /**
     * Given a tile imagery, decide whether to discard that imagery.
     * @param image An imagery to test.
     * @return True if the imagery should be discarded; otherwise, false.
     */
    @JsMethod
    public native boolean shouldDiscardImage(Image image);
}
