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

package org.cesiumjs.cs.datasources;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * Pauses the KmlTour for a given number of seconds.
 */
@JsType(isNative = true, namespace = "Cesium", name = "KmlTourWait")
public class KmlTourWait implements KmlTourEntry {
    /**
     * Pauses the KmlTour for a given number of seconds.
     * @param duration entry duration
     */
    @JsConstructor
    public KmlTourWait(Number duration) {}

    /**
     * Play this playlist entry
     * @param done function which will be called when playback ends
     */
    @JsMethod
    public native void play(DoneCallback done);

    /**
     * Stop execution of curent entry, cancel curent timeout
     */
    @JsMethod
    public native void stop();

    /**
     * A function which will be called when playback ends.
     */
    @JsFunction
    interface DoneCallback {
        /**
         * A function which will be called when playback ends.
         * @param terminated true if {@link KmlTourWait#stop} was called before entry done playback.
         */
        void function(boolean terminated);
    }
}
