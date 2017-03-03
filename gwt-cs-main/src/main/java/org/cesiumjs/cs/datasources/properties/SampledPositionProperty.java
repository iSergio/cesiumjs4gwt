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

package org.cesiumjs.cs.datasources.properties;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.JulianDate;
import org.cesiumjs.cs.core.enums.ExtrapolationType;
import org.cesiumjs.cs.core.enums.ReferenceFrame;
import org.cesiumjs.cs.core.interpolation.InterpolationAlgorithm;
import org.cesiumjs.cs.core.interpolation.LinearApproximation;
import org.cesiumjs.cs.datasources.properties.options.SampledPropertyInterpolationOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "SampledPositionProperty")
public class SampledPositionProperty extends PositionProperty {
    /**
     * Gets or sets the amount of time to extrapolate backward before the property becomes undefined. A value of 0 will extrapolate forever.
     * Default: 0
     */
    @JsProperty
    public double backwardExtrapolationDuration;
    /**
     * Gets or sets the type of extrapolation to perform when a value is requested at a time before any available samples.
     * Default: {@link ExtrapolationType#NONE()}
     */
    @JsProperty
    public Integer backwardExtrapolationType;
    /**
     * Gets or sets the amount of time to extrapolate forward before the property becomes undefined. A value of 0 will extrapolate forever.
     * Default: 0
     */
    @JsProperty
    public double forwardExtrapolationDuration;
    /**
     * Gets or sets the type of extrapolation to perform when a value is requested at a time after any available samples.
     * Default: {@link ExtrapolationType#NONE()}
     */
    @JsProperty
    public Integer forwardExtrapolationType;
    /**
     * Gets the interpolation algorithm to use when retrieving a value.
     * Default: {@link LinearApproximation}
     */
    @JsProperty
    public InterpolationAlgorithm interpolationAlgorithm;
    /**
     * Gets the degree of interpolation to perform when retrieving a value.
     * Default: 1
     */
    @JsProperty
    public double interpolationDegree;
    /**
     * The number of derivatives contained by this property; i.e. 0 for just position, 1 for velocity, etc.
     * Default: false
     */
    @JsProperty
    public boolean numberOfDerivatives;
    /**
     * Gets the reference frame in which the position is defined.
     * Default: {@link ReferenceFrame#FIXED()}
     */
    public Integer referenceFrame;

    /**
     * A {@link SampledProperty} which is also a {@link PositionProperty}.
     */
    @JsConstructor
    public SampledPositionProperty() {}

    /**
     * A {@link SampledProperty} which is also a {@link PositionProperty}.
     * @param referenceFrame The reference frame in which the position is defined.
     * @param numberOfDerivatives The number of derivatives that accompany each position; i.e. velocity, acceleration, etc...
     */
    @JsConstructor
    public SampledPositionProperty(Integer referenceFrame, int numberOfDerivatives) {}

    /**
     * Adds a new sample
     * @param time The sample time.
     * @param position The value at the provided time.
     */
    @JsMethod
    public native void addSample(JulianDate time, Cartesian3 position);

    /**
     * Adds a new sample
     * @param time The sample time.
     * @param position The value at the provided time.
     * @param derivatives The array of derivatives at the provided time.
     */
    @JsMethod
    public native void addSample(JulianDate time, Cartesian3 position, Cartesian3[] derivatives);

    /**
     * Adds an array of samples
     * @param times An array of JulianDate instances where each index is a sample time.
     * @param positions The array of values, where each value corresponds to the provided times index.
     */
    public native void addSamples(JulianDate[] times, Cartesian3[] positions);

    /**
     * Adds an array of samples
     * @param times An array of JulianDate instances where each index is a sample time.
     * @param positions The array of values, where each value corresponds to the provided times index.
     * @param derivativeValues An array where each item is the array of derivatives at the equivalent time index.
     */
    public native void addSamples(JulianDate[] times, Cartesian3[] positions, Cartesian3[]derivativeValues);

    /**
     * Adds samples as a single packed array where each new sample is represented as a date,
     * followed by the packed representation of the corresponding value and derivatives.
     * @param packedSamples The array of packed samples.
     * @param epoch If any of the dates in packedSamples are numbers, they are considered an offset from this epoch, in seconds.
     */
    public native void addSamplesPackedArray(double[] packedSamples, JulianDate epoch);

    /**
     * Sets the algorithm and degree to use when interpolating a value.
     * @param options Options
     */
    public native void setInterpolationOptions(SampledPropertyInterpolationOptions options);
}
