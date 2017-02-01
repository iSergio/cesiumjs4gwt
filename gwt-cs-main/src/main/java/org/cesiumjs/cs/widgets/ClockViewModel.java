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

package org.cesiumjs.cs.widgets;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Clock;
import org.cesiumjs.cs.core.JulianDate;

/**
 * A view model which exposes a Clock for user interfaces.
 * @see Clock
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ClockViewModel")
public class ClockViewModel {
    /**
     * Gets or sets whether the clock can animate. See Clock#canAnimate. This property is observable.
     */
    @JsProperty
    public boolean canAnimate;
    /**
     * Gets the underlying Clock.
     */
    @JsProperty
    public Clock clock;
    /**
     * Gets or sets the clock range setting. See Clock#clockRange. This property is observable.
     */
    @JsProperty
    public Number clockRange;
    /**
     * Gets or sets the clock step setting. See Clock#clockStep. This property is observable.
     */
    @JsProperty
    public Number clockStep;
    /**
     * Gets or sets the current time. See Clock#currentTime. This property is observable.
     */
    @JsProperty
    public JulianDate currentTime;
    /**
     * Gets or sets the clock multiplier. See {@link Clock#multiplier}. This property is observable.
     */
    @JsProperty
    public double multiplier;
    /**
     * Gets or sets whether the clock should animate. See {@link Clock#shouldAnimate}. This property is observable.
     */
    @JsProperty
    public boolean shouldAnimate;
    /**
     * Gets or sets the start time of the clock. See {@link Clock#startTime}. This property is observable.
     */
    @JsProperty
    public JulianDate startTime;
    /**
     * Gets or sets the stop time of the clock. See {@link Clock#stopTime}. This property is observable.
     */
    @JsProperty
    public JulianDate stopTime;
    /**
     * Gets the current system time. This property is observable.
     */
    @JsProperty
    public JulianDate systemTime;

    /**
     * A view model which exposes a Clock for user interfaces.
     * @see org.cesiumjs.cs.core.Clock
     */
    @JsConstructor
    public ClockViewModel() {}

    /**
     * A view model which exposes a Clock for user interfaces.
     * @see org.cesiumjs.cs.core.Clock
     * @param clock The clock object wrapped by this view model, if undefined a new instance will be created.
     */
    @JsConstructor
    public ClockViewModel(Clock clock) {}

    /**
     * Destroys the view model. Should be called to properly clean up the view model when it is no longer needed.
     */
    @JsMethod
    public native void destroy();

    /**
     * @return true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Updates the view model with the contents of the underlying clock. Can be called to force an update of the viewModel
     * if the underlying clock has changed and Clock.tick has not yet been called.
     */
    @JsMethod
    public native void synchronize();
}
