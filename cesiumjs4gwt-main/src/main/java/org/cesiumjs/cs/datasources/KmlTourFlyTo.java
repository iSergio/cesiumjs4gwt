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
import org.cesiumjs.cs.js.JsObject;
import org.cesiumjs.cs.scene.Camera;

/**
 * Transitions the KmlTour to the next destination. This transition is facilitated using a specified
 * flyToMode over a given number of seconds.
 */
@JsType(isNative = true, namespace = "Cesium", name = "KmlTourFlyTo")
public class KmlTourFlyTo implements KmlTourEntry {
    /**
     * Transitions the KmlTour to the next destination. This transition is facilitated using a specified flyToMode over a given number of seconds.
     * @param duration entry duration
     * @param flyToMode KML fly to mode: bounce, smooth, etc
     * @param view KmlCamera or KmlLookAt
     */
    @JsConstructor
    public KmlTourFlyTo(Number duration, String flyToMode, KmlView view) {}

    /**
     * Returns options for Camera#flyTo or Camera#flyToBoundingSphere depends on this.view type.
     * @param cameraOptions options to merge with generated. See Camera#flyTo
     * @return Camera#flyTo or Camera#flyToBoundingSphere options
     */
    @JsMethod
    public native JsObject getCameraOptions(JsObject cameraOptions);

    /**
     * Play this playlist entry
     * @param done function which will be called when playback ends
     * @param camera Cesium camera
     */
    @JsMethod
    public native void play(DoneCallback done, Camera camera);

    /**
     * Play this playlist entry
     * @param done function which will be called when playback ends
     * @param camera Cesium camera
     * @param cameraOptions which will be merged with camera flyTo options. See Camera#flyTo
     */
    @JsMethod
    public native void play(DoneCallback done, Camera camera, JsObject cameraOptions);

    /**
     * Stop execution of curent entry. Cancel camera flyTo
     */
    @JsMethod
    public native void stop();

    /**
     * A function that will be executed when the flight completes.
     */
    @JsFunction
    interface DoneCallback {
        /**
         * A function that will be executed when the flight completes.
         * @param terminated true if KmlTourFlyTo#stop was called before entry done playback.
         */
        void function(boolean terminated);
    }
}
