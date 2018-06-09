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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.JulianDate;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ClockOptions {
    /**
     * The start time of the clock.
     */
    @JsProperty
    public JulianDate startTime;
    /**
     * The stop time of the clock.
     */
    @JsProperty
    public JulianDate stopTime;
    /**
     * The current time.
     */
    @JsProperty
    public JulianDate currentTime;
    /**
     * Determines how much time advances when Clock#tick is called, negative values allow for advancing backwards. Defaults: 1.0.
     */
    @JsProperty
    public double multiplier;
    /**
     * Determines if calls to Clock#tick are frame dependent or system clock dependent. Defaults: ClockStep.SYSTEM_CLOCK_MULTIPLIER.
     */
    @JsProperty
    public int clockStep;
    /**
     * Determines how the clock should behave when Clock#startTime or Clock#stopTime is reached. Defaults: ClockRange.UNBOUNDED.
     */
    @JsProperty
    public int clockRange;
    /**
     * Indicates whether Clock#tick can advance time. This could be false if data is being buffered, for example.
     * The clock will only tick when both Clock#canAnimate and Clock#shouldAnimate are true. Defaults: true.
     */
    @JsProperty
    public boolean canAnimate;
    /**
     * Indicates whether Clock#tick should attempt to advance time. The clock will only tick when both Clock#canAnimate and Clock#shouldAnimate are true.
     * Default: true.
     */
    @JsProperty
    public boolean shouldAnimate;

    @JsConstructor
    public ClockOptions() {}
}
