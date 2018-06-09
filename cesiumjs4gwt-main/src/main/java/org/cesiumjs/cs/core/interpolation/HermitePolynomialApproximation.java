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

package org.cesiumjs.cs.core.interpolation;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * An {@link InterpolationAlgorithm} for performing Hermite interpolation.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true)
public class HermitePolynomialApproximation implements InterpolationAlgorithm {
    /**
     * Get instance if algorithm. In this moment i don't invented more
     * @return Instance instance. See example.
     */
    @JsProperty(namespace = "Cesium", name = "HermitePolynomialApproximation")
    public static native HermitePolynomialApproximation instance();

    /**
     * Given the desired degree, returns the number of data points required for interpolation.
     * @param degree The desired degree of interpolation.
     * @return The number of required data points needed for the desired degree of interpolation.
     */
    @JsMethod(namespace = "Cesium.HermitePolynomialApproximation")
    public static native int getRequiredDataPoints(double degree);

    /**
     * Given the desired degree, returns the number of data points required for interpolation.
     * @param degree The desired degree of interpolation.
     * @param inputOrder The order of the inputs (0 means just the data, 1 means the data and its derivative, etc).
     * @return The number of required data points needed for the desired degree of interpolation.
     */
    @JsMethod(namespace = "Cesium.HermitePolynomialApproximation")
    public static native int getRequiredDataPoints(double degree, int inputOrder);

    /**
     * Interpolates values using Hermite Polynomial Approximation.
     * @param x The independent variable for which the dependent variables will be interpolated.
     * @param xTable The array of independent variables to use to interpolate. The values in this array must be in
     *               increasing order and the same value must not occur twice in the array.
     * @param yTable The array of dependent variables to use to interpolate. For a set of three dependent values (p,q,w)
     *               at time 1 and time 2 this should be as follows: {p1, q1, w1, p2, q2, w2}.
     * @param yStride The number of dependent variable values in yTable corresponding to each independent variable value in xTable.
     * @param inputOrder The number of derivatives supplied for input.
     * @param outputOrder The number of derivatives desired for output.
     * @return The array of interpolated values, or the result parameter if one was provided.
     */
    @JsMethod(namespace = "Cesium.HermitePolynomialApproximation")
    public static native double[] interpolate(double x, double[] xTable, double[] yTable, double yStride, int inputOrder, int outputOrder);

    /**
     * Interpolates values using Hermite Polynomial Approximation.
     * @param x The independent variable for which the dependent variables will be interpolated.
     * @param xTable The array of independent variables to use to interpolate. The values in this array must be in
     *               increasing order and the same value must not occur twice in the array.
     * @param yTable The array of dependent variables to use to interpolate. For a set of three dependent values (p,q,w)
     *               at time 1 and time 2 this should be as follows: {p1, q1, w1, p2, q2, w2}.
     * @param yStride The number of dependent variable values in yTable corresponding to each independent variable value in xTable.
     * @param inputOrder The number of derivatives supplied for input.
     * @param outputOrder The number of derivatives desired for output.
     * @param result An existing array into which to store the result.
     * @return The array of interpolated values, or the result parameter if one was provided.
     */
    @JsMethod(namespace = "Cesium.HermitePolynomialApproximation")
    public static native double[] interpolate(double x, double[] xTable, double[] yTable, double yStride, int inputOrder, int outputOrder, double[] result);

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
    @JsMethod(namespace = "Cesium.HermitePolynomialApproximation")
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
    @JsMethod(namespace = "Cesium.HermitePolynomialApproximation")
    public static native double[] interpolateOrderZero(double x, double[] xTable, double[] yTable, double yStride, double[] result);
}
