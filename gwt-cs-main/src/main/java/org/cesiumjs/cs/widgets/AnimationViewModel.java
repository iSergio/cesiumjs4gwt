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
import org.cesiumjs.cs.core.JulianDate;

/**
 * The view model for the Animation widget.
 * @see Animation
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "AnimationViewModel")
public class AnimationViewModel {
    /**
     * Gets or sets the default date formatter used by new instances.
     */
    @JsProperty
    public static DateFormatter defaultDateFormatter;

    /**
     *  Gets or sets the default array of known clock multipliers associated with new instances of the shuttle ring.
     */
    @JsProperty
    public static double[] defaultTicks;
    /**
     * Gets or sets the default time formatter used by new instances.
     */
    public static TimeFormatter defaultTimeFormatter;
    /**
     * Gets the clock view model.
     */
    @JsProperty
    public ClockViewModel clockViewModel;
    /**
     * Gets or sets the function which formats a date for display.
     * Default:  {@link #defaultDateFormatter}
     */
    @JsProperty
    public DateFormatter dateFormatter;
    /**
     * Gets the string representation of the current date. This property is observable.
     */
    @JsProperty
    public String dateLabel;
    /**
     * Gets a command that increases the speed of animation.
     */
    @JsProperty
    public Command faster;
    /**
     * Gets the string representation of the current multiplier. This property is observable.
     */
    @JsProperty
    public String multiplierLabel;
    /**
     * Gets the pause toggle button view model.
     */
    @JsProperty
    public ToggleButtonViewModel pauseViewModel;
    /**
     * Gets the play toggle button view model.
     */
    @JsProperty
    public ToggleButtonViewModel playForwardViewModel;
    /**
     * Gets the realtime toggle button view model.
     */
    @JsProperty
    public ToggleButtonViewModel playRealtimeViewModel;
    /**
     * Gets the reverse toggle button view model.
     */
    @JsProperty
    public ToggleButtonViewModel playReverseViewModel;
    /**
     * Gets or sets the current shuttle ring angle. This property is observable.
     */
    @JsProperty
    public double shuttleRingAngle;
    /**
     * Gets or sets whether the shuttle ring is currently being dragged. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean shuttleRingDragging;
    /**
     * Gets a command that decreases the speed of animation.
     */
    @JsProperty
    public Command slower;
    /**
     * Gets or sets whether dragging the shuttle ring should cause the multiplier to snap to the defined tick values
     * rather than interpolating between them. This property is observable.
     * Default: false
     */
    @JsProperty
    public boolean snapToTicks;
    /**
     * Gets or sets the function which formats a time for display.
     * Default: {@link #defaultTimeFormatter}
     */
    public TimeFormatter timeFormatter;
    /**
     * Gets the string representation of the current time. This property is observable.
     */
    @JsProperty
    public String timeLabel;

    /**
     * The view model for the Animation widget.
     * @see Animation
     * @param clockViewModel The ClockViewModel instance to use.
     */
    @JsConstructor
    public AnimationViewModel(ClockViewModel clockViewModel) {}

    /**
     * Gets a copy of the array of positive known clock multipliers to associate with the shuttle ring.
     * @return The array of known clock multipliers associated with the shuttle ring.
     */
    @JsMethod
    public native double[] getShuttleRingTicks();

    /**
     * Sets the array of positive known clock multipliers to associate with the shuttle ring. These values will have
     * negative equivalents created for them and sets both the minimum and maximum range of values for the shuttle ring
     * as well as the values that are snapped to when a single click is made. The values need not be in order, as they
     * will be sorted automatically, and duplicate values will be removed.
     * @param positiveTicks The list of known positive clock multipliers to associate with the shuttle ring.
     */
    @JsMethod
    public native void setShuttleRingTicks(double[] positiveTicks);

    /**
     * A function that formats a date for display.
     */
    public interface DateFormatter {
        /**
         * A function that formats a date for display.
         * @param date The date to be formatted
         * @param viewModel The AnimationViewModel instance requesting formatting.
         * @return A function that formats a time for display.
         */
        String function(JulianDate date, AnimationViewModel viewModel);
    }

    /**
     * A function that formats a time for display.
     */
    public interface TimeFormatter {
        /**
         * A function that formats a date for display.
         * @param date The date to be formatted
         * @param viewModel The AnimationViewModel instance requesting formatting.
         * @return The string representation of the time portion of the provided date.
         */
        String function(JulianDate date, AnimationViewModel viewModel);
    }
}
