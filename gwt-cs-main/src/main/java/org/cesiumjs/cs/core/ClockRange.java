/*
 * Copyright 2016 iserge.
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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ClockRange")
public class ClockRange {
    /**
     * When Clock#startTime or Clock#stopTime is reached, Clock#tick will not advance Clock#currentTime any further.
     */
    @JsProperty(name = "CLAMPED")
    public static native int CLAMPED();
    /**
     * When Clock#stopTime is reached, Clock#tick will advance Clock#currentTime to the opposite end of the interval.
     * When time is moving backwards, Clock#tick will not advance past Clock#startTime
     */
    @JsProperty(name = "LOOP_STOP")
    public static native int LOOP_STOP();
    /**
     * Clock#tick will always advances the clock in its current direction.
     */
    @JsProperty(name = "UNBOUNDED")
    public static native int UNBOUNDED();

    @JsConstructor
    private ClockRange() {}
}
