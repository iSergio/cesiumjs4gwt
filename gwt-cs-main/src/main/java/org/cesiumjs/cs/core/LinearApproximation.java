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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * An {@link InterpolationAlgorithm} for performing linear interpolation.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "LinearApproximation")
public class LinearApproximation implements InterpolationAlgorithm {
    /**
     * Given the desired degree, returns the number of data points required for interpolation.
     * @param degree The desired degree of interpolation.
     * @return The number of required data points needed for the desired degree of interpolation.
     */
    @JsMethod
    public static native int getRequiredDataPoints(double degree);

    /**
     * Interpolates values using Lagrange Polynomial Approximation.
     * @param x The independent variable for which the dependent variables will be interpolated.
     * @param xTable The array of independent variables to use to interpolate. The values in this array must be in
     *               increasing order and the same value must not occur twice in the array.
     * @param yTable The array of dependent variables to use to interpolate.
     *               For a set of three dependent values (p,q,w) at time 1 and time 2 this should be as follows: {p1, q1, w1, p2, q2, w2}.
     * @param yStride The number of dependent variable values in yTable corresponding to each independent variable value in xTable.
     * @return The array of interpolated values, or the result parameter if one was provided.
     */
    @JsMethod
    public static native double[] interpolateOrderZero(double x, double[] xTable, double[] yTable, double yStride);

    /**
     * Interpolates values using Lagrange Polynomial Approximation.
     * @param x The independent variable for which the dependent variables will be interpolated.
     * @param xTable The array of independent variables to use to interpolate. The values in this array must be in
     *               increasing order and the same value must not occur twice in the array.
     * @param yTable The array of dependent variables to use to interpolate.
     *               For a set of three dependent values (p,q,w) at time 1 and time 2 this should be as follows: {p1, q1, w1, p2, q2, w2}.
     * @param yStride The number of dependent variable values in yTable corresponding to each independent variable value in xTable.
     * @param result An existing array into which to store the result.
     * @return The array of interpolated values, or the result parameter if one was provided.
     */
    @JsMethod
    public static native double[] interpolateOrderZero(double x, double[] xTable, double[] yTable, double yStride, double[] result);
}
