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

package org.cesiumjs.cs.datasources.properties;

import com.google.gwt.core.client.JavaScriptObject;
import jsinterop.annotations.JsMethod;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.js.JsObject;

public class SampledNumberProperty<T extends Number> extends JavaScriptObject {
    protected SampledNumberProperty() {}

    public static native <T extends Number> SampledNumberProperty<T> create() /*-{
        return new $wnd.Cesium.SampledProperty($wnd.Number);
    }-*/;

    /**
     * Adds a new sample
     *
     * @param time  The sample time.
     * @param value The value at the provided time.
     */
    public native final void addSample(JulianDate time, T value) /*-{
        this.addSample(time, value);
    }-*/;

    /**
     * Adds a new sample
     *
     * @param time        The sample time.
     * @param value       The value at the provided time.
     * @param derivatives The array of derivatives at the provided time.
     */
    public native final void addSample(JulianDate time, T value, T[] derivatives) /*-{
        this.addSample(time, value, derivatives);
    }-*/;

    /**
     * Adds an array of samples
     *
     * @param times  An array of JulianDate instances where each index is a sample
     *               time.
     * @param values The array of values, where each value corresponds to the
     *               provided times index.
     */
    public native final void addSamples(JulianDate[] times, T[] values) /*-{
        this.addSamples(times, values);
    }-*/;

    /**
     * Adds an array of samples
     *
     * @param times            An array of JulianDate instances where each index is
     *                         a sample time.
     * @param values           The array of values, where each value corresponds to
     *                         the provided times index.
     * @param derivativeValues An array where each item is the array of derivatives
     *                         at the equivalent time index.
     */
    public native final void addSamples(JulianDate[] times, T[] values, T[] derivativeValues) /*-{
        this.addSamples(times, values, derivativeValues);
    }-*/;

    /**
     * Gets the value of the property at the provided time.
     *
     * @param time The time for which to retrieve the value.
     * @return The modified result parameter or a new instance if the result
     * parameter was not supplied.
     */
    public native final T getValue(JulianDate time) /*-{
        return this.getValue(time);
    }-*/;

    /**
     * Gets the value of the property at the provided time.
     *
     * @param time   The time for which to retrieve the value.
     * @param result The object to store the value into, if omitted, a new instance
     *               is created and returned.
     * @return The modified result parameter or a new instance if the result
     * parameter was not supplied.
     */
    public native final T getValue(JulianDate time, T result) /*-{
        return this.getValue(time, result);
    }-*/;
}
