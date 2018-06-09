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

package org.cesiumjs.cs.core.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Clock;

/**
 * Constants to determine how much time advances with each call to {@link Clock#tick}.
 * @see Clock
 * @see ClockRange
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ClockStep")
public class ClockStep {
    /**
     * {@link Clock#tick} sets the clock to the current system time; ignoring all other settings.
     */
    @JsProperty(name = "SYSTEM_CLOCK")
    public static native Number SYSTEM_CLOCK();
    /**
     * {@link Clock#tick} advances the current time by the amount of system time elapsed since the previous call multiplied by {@link Clock#multiplier}.
     */
    @JsProperty(name = "SYSTEM_CLOCK_MULTIPLIER")
    public static native Number SYSTEM_CLOCK_MULTIPLIER();
    /**
     * {@link Clock#tick} advances the current time by a fixed step, which is the number of seconds specified by {@link Clock#multiplier}.
     */
    @JsProperty(name = "TICK_DEPENDENT")
    public static native Number TICK_DEPENDENT();

    /**
     * Constants to determine how much time advances with each call to {@link Clock#tick}.
     * @see Clock
     * @see ClockRange
     */
    @JsConstructor
    private ClockStep() {}
}
