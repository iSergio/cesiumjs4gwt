/*
 * Copyright 2018 iserge.
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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.Packable;
import org.cesiumjs.cs.core.enums.ExtrapolationType;
import org.cesiumjs.cs.core.interpolation.InterpolationAlgorithm;
import org.cesiumjs.cs.core.interpolation.LinearApproximation;
import org.cesiumjs.cs.datasources.properties.options.SampledPropertyInterpolationOptions;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "SampledProperty")
public class SampledProperty<T extends Packable> extends Property<T> {
    /**
     * Gets or sets the amount of time to extrapolate backward before the property
     * becomes undefined. A value of 0 will extrapolate forever. Default: 0
     */
    @JsProperty
    public double backwardExtrapolationDuration;
    /**
     * Gets or sets the type of extrapolation to perform when a value is requested
     * at a time before any available samples. Default:
     * {@link ExtrapolationType#NONE()}
     */
    @JsProperty
    public Integer backwardExtrapolationType;
    /**
     * Gets the derivative types used by this property.
     */
    @JsProperty
    public Packable[] derivativeTypes;
    /**
     * Gets or sets the amount of time to extrapolate forward before the property
     * becomes undefined. A value of 0 will extrapolate forever. Default: 0
     */
    @JsProperty
    public double forwardExtrapolationDuration;
    /**
     * Gets or sets the type of extrapolation to perform when a value is requested
     * at a time after any available samples. Default:
     * {@link ExtrapolationType#NONE()}
     */
    @JsProperty
    public Integer forwardExtrapolationType;
    /**
     * Gets the interpolation algorithm to use when retrieving a value. Default:
     * {@link LinearApproximation}
     */
    @JsProperty
    public InterpolationAlgorithm interpolationAlgorithm;
    /**
     * Gets the degree of interpolation to perform when retrieving a value. Default:
     * 1
     */
    @JsProperty
    public double interpolationDegree;
    /**
     * Gets the type of property.
     */
    @JsProperty
    public T type;

    // TODO: Examples

    /**
     * A {@link Property} whose value is interpolated for a given time from the
     * provided set of samples and specified interpolation algorithm and degree.
     *
     * @param type The type of property.
     */
    @JsConstructor
    public SampledProperty(T type) {
    }

    /**
     * A {@link Property} whose value is interpolated for a given time from the
     * provided set of samples and specified interpolation algorithm and degree.
     *
     * @param type            The type of property.
     * @param derivativeTypes When supplied, indicates that samples will contain
     *                        derivative information of the specified types.
     */
    @JsConstructor
    public SampledProperty(T type, T[] derivativeTypes) {
    }

    /**
     * Adds a new sample
     *
     * @param time  The sample time.
     * @param value The value at the provided time.
     */
    @JsMethod
    public native void addSample(JulianDate time, T value);

    /**
     * Adds a new sample
     *
     * @param time        The sample time.
     * @param value       The value at the provided time.
     * @param derivatives The array of derivatives at the provided time.
     */
    @JsMethod
    public native void addSample(JulianDate time, T value, T[] derivatives);

    /**
     * Adds an array of samples
     *
     * @param times  An array of JulianDate instances where each index is a sample
     *               time.
     * @param values The array of values, where each value corresponds to the
     *               provided times index.
     */
    @JsMethod
    public native void addSamples(JulianDate[] times, T[] values);

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
    @JsMethod
    public native void addSamples(JulianDate[] times, T[] values, T[] derivativeValues);

    /**
     * Adds samples as a single packed array where each new sample is represented as
     * a date, followed by the packed representation of the corresponding value and
     * derivatives.
     *
     * @param packedSamples The array of packed samples.
     * @param epoch         If any of the dates in packedSamples are numbers, they
     *                      are considered an offset from this epoch, in seconds.
     */
    @JsMethod
    public native void addSamplesPackedArray(double[] packedSamples, JulianDate epoch);

    /**
     * Removes a sample at the given time, if present.
     *
     * @param time The sample time.
     * @return true if a sample at time was removed, false otherwise.
     */
    @JsMethod
    public native boolean removeSample(JulianDate time);

    /**
     * Removes all samples for the given time interval.
     *
     * @param time The time interval for which to remove all samples.
     */
    @JsMethod
    public native void removeSamples(org.cesiumjs.cs.core.TimeInterval time);

    /**
     * Sets the algorithm and degree to use when interpolating a value.
     *
     * @param options Options
     */
    @JsMethod
    public native void setInterpolationOptions(SampledPropertyInterpolationOptions options);
}
