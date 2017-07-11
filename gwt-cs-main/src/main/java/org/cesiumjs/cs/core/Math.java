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

package org.cesiumjs.cs.core;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Math functions.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Math")
public class Math {
    /**
     * The number of degrees in a radian.
     */
    @JsProperty(name = "DEGREES_PER_RADIAN")
    public static native double DEGREES_PER_RADIAN();
    /**
     * 0.1
     */
    @JsProperty(name = "EPSILON1")
    public static native double EPSILON1();
    /**
     * 0.01
     */
    @JsProperty(name = "EPSILON2")
    public static native double EPSILON2();
    /**
     * 0.001
     */
    @JsProperty(name = "EPSILON3")
    public static native double EPSILON3();
    /**
     * 0.0001
     */
    @JsProperty(name = "EPSILON4")
    public static native double EPSILON4();
    /**
     * 0.00001
     */
    @JsProperty(name = "EPSILON5")
    public static native double EPSILON5();
    /**
     * 0.000001
     */
    @JsProperty(name = "EPSILON6")
    public static native double EPSILON6();
    /**
     * 0.0000001
     */
    @JsProperty(name = "EPSILON7")
    public static native double EPSILON7();
    /**
     * 0.00000001
     */
    @JsProperty(name = "EPSILON8")
    public static native double EPSILON8();
    /**
     * 0.000000001
     */
    @JsProperty(name = "EPSILON9")
    public static native double EPSILON9();
    /**
     * 0.0000000001
     */
    @JsProperty(name = "EPSILON10")
    public static native double EPSILON10();
    /**
     * 0.00000000001
     */
    @JsProperty(name = "EPSILON11")
    public static native double EPSILON11();
    /**
     * 0.000000000001
     */
    @JsProperty(name = "EPSILON12")
    public static native double EPSILON12();
    /**
     * 0.0000000000001
     */
    @JsProperty(name = "EPSILON13")
    public static native double EPSILON13();
    /**
     * 0.00000000000001
     */
    @JsProperty(name = "EPSILON14")
    public static native double EPSILON14();
    /**
     * 0.000000000000001
     */
    @JsProperty(name = "EPSILON15")
    public static native double EPSILON15();
    /**
     * 0.0000000000000001
     */
    @JsProperty(name = "EPSILON16")
    public static native double EPSILON16();
    /**
     * 0.00000000000000001
     */
    @JsProperty(name = "EPSILON17")
    public static native double EPSILON17();
    /**
     * 0.000000000000000001
     */
    @JsProperty(name = "EPSILON18")
    public static native double EPSILON18();
    /**
     * 0.0000000000000000001
     */
    @JsProperty(name = "EPSILON19")
    public static native double EPSILON19();
    /**
     * 0.00000000000000000001
     */
    @JsProperty(name = "EPSILON20")
    public static native double EPSILON20();
    /**
     * 3.986004418e14
     */
    @JsProperty(name = "GRAVITATIONALPARAMETER")
    public static native double GRAVITATIONALPARAMETER();
    /**
     * The mean radius of the moon, according to the "Report of the IAU/IAG Working Group on Cartographic Coordinates and
     * Rotational Elements of the Planets and satellites: 2000", Celestial Mechanics 82: 83-110, 2002.
     */
    @JsProperty(name = "LUNAR_RADIUS")
    public static native double LUNAR_RADIUS();
    /**
     * 1/pi
     */
    @JsProperty(name = "ONE_OVER_PI")
    public static native double ONE_OVER_PI();
    /**
     * 1/2pi
     */
    @JsProperty(name = "ONE_OVER_TWO_PI")
    public static native double ONE_OVER_TWO_PI();
    /**
     * pi
     */
    @JsProperty(name = "PI")
    public static native double PI();
    /**
     * pi/4
     */
    @JsProperty(name = "PI_OVER_FOUR")
    public static native double PI_OVER_FOUR();
    /**
     * pi/6
     */
    @JsProperty(name = "PI_OVER_SIX")
    public static native double PI_OVER_SIX();
    /**
     * pi/3
     */
    @JsProperty(name = "PI_OVER_THREE")
    public static native double PI_OVER_THREE();
    /**
     * pi/2
     */
    @JsProperty(name = "PI_OVER_TWO")
    public static native double PI_OVER_TWO();
    /**
     * The number of radians in an arc second.
     * Default Value:  CesiumMath.RADIANS_PER_DEGREE / 3600.0
     */
    @JsProperty(name = "RADIANS_PER_ARCSECOND")
    public static native double RADIANS_PER_ARCSECOND();
    /**
     * The number of radians in a degree.
     * Default Value:  Math.PI / 180.0
     */
    @JsProperty(name = "RADIANS_PER_DEGREE")
    public static native double RADIANS_PER_DEGREE();
    /**
     * 64 * 1024
     */
    @JsProperty(name = "SIXTY_FOUR_KILOBYTES")
    public static native double SIXTY_FOUR_KILOBYTES();
    /**
     * Radius of the sun in meters: 6.955e8
     */
    @JsProperty(name = "SOLAR_RADIUS")
    public static native double SOLAR_RADIUS();
    /**
     * 3pi/2
     */
    @JsProperty(name = "THREE_PI_OVER_TWO")
    public static native double THREE_PI_OVER_TWO();
    /**
     * 2pi
     */
    @JsProperty(name = "TWO_PI")
    public static native double TWO_PI();

    @JsConstructor
    private Math() {
        //
    }

    /**
     * Computes Math.acos(value), but first clamps value to the range [-1.0, 1.0] so that the function will never return NaN.
     * @param value The value for which to compute acos.
     * @return The acos of the value if the value is in the range [-1.0, 1.0], or the acos of -1.0 or 1.0, whichever is closer,
     * if the value is outside the range.
     */
    @JsMethod
    public static native double acosClamped(double value);

    /**
     * Computes Math.asin(value), but first clamps value to the range [-1.0, 1.0] so that the function will never return NaN.
     * @param value The value for which to compute asin.
     * @return The asin of the value if the value is in the range [-1.0, 1.0], or the asin of -1.0 or 1.0,
     * whichever is closer, if the value is outside the range.
     */
    @JsMethod
    public static native double asinClamped(double value);

    /**
     * Finds the chord length between two points given the circle's radius and the angle between the points.
     * @param angle The angle between the two points.
     * @param radius The radius of the circle.
     * @return The chord length.
     */
    @JsMethod
    public static native double chordLength(double angle, double radius);

    /**
     * Constraint a value to lie between two values.
     * @param value The value to constrain.
     * @param min The minimum value.
     * @param max The maximum value.
     * @return The value clamped so that min <= value <= max.
     */
    @JsMethod
    public static native double clamp(double value, double min, double max);

    /**
     * Convenience function that clamps a latitude value, in radians, to the range [-Math.PI/2, Math.PI/2).
     * Useful for sanitizing data before use in objects requiring correct range.
     * @param angle The latitude value, in radians, to clamp to the range [-Math.PI/2, Math.PI/2).
     * @return The latitude value clamped to the range [-Math.PI/2, Math.PI/2).
     * <code>
     *     //Clamp 108 degrees latitude to 90 degrees latitude
     *     double latitude = Math.clampToLatitudeRange(Math.toRadians(108.0));
     * </code>
     */
    @JsMethod
    public static native double clampToLatitudeRange(double angle);

    /**
     * Converts a longitude value, in radians, to the range [-Math.PI, Math.PI).
     * @param angle The longitude value, in radians, to convert to the range [-Math.PI, Math.PI).
     * @return The equivalent longitude value in the range [-Math.PI, Math.PI).
     * <code>
     *     // Convert 270 degrees to -90 degrees longitude
     *     double longitude = Math.convertLongitudeRange(Math.toRadians(270.0));
     * </code>
     */
    @JsMethod
    public static native double convertLongitudeRange(double angle);

    /**
     * Returns the hyperbolic cosine of a number. The hyperbolic cosine of value is defined to be (ex + e-x)/2.0 where e is
     * Euler's number, approximately 2.71828183.
     * Special cases:
     * If the argument is NaN, then the result is NaN.
     * If the argument is infinite, then the result is positive infinity.
     * If the argument is zero, then the result is 1.0.
     * @param value The number whose hyperbolic cosine is to be returned.
     * @return The hyperbolic cosine of value.
     */
    @JsMethod
    public static native double cosh(double value);

    /**
     * Determines if two values are equal using an absolute or relative tolerance test. This is useful to avoid problems
     * due to roundoff error when comparing floating-point values directly. The values are first compared using an
     * absolute tolerance test. If that fails, a relative tolerance test is performed. Use this test if you are
     * unsure of the magnitudes of left and right.
     * @param left The first value to compare.
     * @param right The other value to compare.
     * @param relativeEpsilon The maximum inclusive delta between left and right for the relative tolerance test.
     * @return true if the values are equal within the epsilon; otherwise, false.
     * <code>
     *     boolean a = Math.equalsEpsilon(0.0, 0.01, Math.EPSILON2); // true
     *     boolean b = Math.equalsEpsilon(0.0, 0.1, Math.EPSILON2);  // false
     *     boolean c = Math.equalsEpsilon(3699175.1634344, 3699175.2, Math.EPSILON7); // true
     *     boolean d = Math.equalsEpsilon(3699175.1634344, 3699175.2, Math.EPSILON9); // false
     * </code>
     */
    @JsMethod
    public static native boolean equalsEpsilon(double left, double right, double relativeEpsilon);

    /**
     * Determines if two values are equal using an absolute or relative tolerance test. This is useful to avoid problems
     * due to roundoff error when comparing floating-point values directly. The values are first compared using an
     * absolute tolerance test. If that fails, a relative tolerance test is performed. Use this test if you are
     * unsure of the magnitudes of left and right.
     *<pre>
     *<b>Example:</b>
     *    {@code
     *    boolean a = Math.equalsEpsilon(0.0, 0.01, Math.EPSILON2); // true
     *    boolean b = Math.equalsEpsilon(0.0, 0.1, Math.EPSILON2);  // false
     *    boolean c = Math.equalsEpsilon(3699175.1634344, 3699175.2, Math.EPSILON7); // true
     *    boolean d = Math.equalsEpsilon(3699175.1634344, 3699175.2, Math.EPSILON9); // false
     *}
     *</pre>
     * @param left The first value to compare.
     * @param right The other value to compare.
     * @param relativeEpsilon The maximum inclusive delta between left and right for the relative tolerance test.
     * @param absoluteEpsilon Default: relativeEpsilon.	The maximum inclusive delta between left and right for the absolute tolerance test.
     * @return true if the values are equal within the epsilon; otherwise, false.
     */
    @JsMethod
    public static native boolean equalsEpsilon(double left, double right, double relativeEpsilon, double absoluteEpsilon);

    /**
     * Computes the factorial of the provided number.
     *<pre>
     *<b>Example:</b>
     *    {@code
     *    //Compute 7!, which is equal to 5040
     *    double computedFactorial = Math.factorial(7);
     *}
     *</pre>
     * @param n The number whose factorial is to be computed.
     * @return The factorial of the provided number or undefined if the number is less than 0.
     * @see <a href="http://en.wikipedia.org/wiki/Factorial">Factorial on Wikipedia</a>
     */
    @JsMethod
    public static native double factorial(double n);

    /**
     * Converts a SNORM value in the range [0, rangeMax] to a scalar in the range [-1.0, 1.0].
     * @param value SNORM value in the range [0, 255]
     * @return Scalar in the range [-1.0, 1.0].
     * @see #toSNorm(double)
     */
    @JsMethod
    public static native double fromSNorm(double value);

    /**
     * Converts a SNORM value in the range [0, rangeMax] to a scalar in the range [-1.0, 1.0].
     * @param value SNORM value in the range [0, 255]
     * @param rangeMax The maximum value in the SNORM range, 255 by default.
     * @return Scalar in the range [-1.0, 1.0].
     * @see #toSNorm(double, double)
     */
    @JsMethod
    public static native double fromSNorm(double value, double rangeMax);

    /**
     * Increments a number with a wrapping to a minimum value if the number exceeds the maximum value.
     * <pre>
     * Example:
     * {@code double n = Math.incrementWrap(5, 10, 0); // returns 6
     * double n = Math.incrementWrap(10, 10, 0); // returns 0
     * }
     * </pre>
     * @param n The number to be incremented.
     * @param maximumValue The maximum incremented value before rolling over to the minimum value.
     * @param minimumValue The number reset to after the maximum value has been exceeded.
     * @return The incremented number.
     */
    @JsMethod
    public static native double incrementWrap(double n, double maximumValue, double minimumValue);

    /**
     * Determines if a positive integer is a power of two.
     * <pre>
     * Example:
     * {@code boolean t = Math.isPowerOfTwo(16); // true
     * boolean f = Math.isPowerOfTwo(20); // false
     * }
     * </pre>
     * @param n The positive integer to test.
     * @return true if the number if a power of two; otherwise, false.
     */
    @JsMethod
    public static native boolean isPowerOfTwo(double n);

    /**
     * Computes the linear interpolation of two values.
     * <pre>
     * Example:
     * {@code double n = Math.lerp(0.0, 2.0, 0.5); // returns 1.0}
     * </pre>
     * @param p The start value to interpolate.
     * @param q The end value to interpolate.
     * @param time The time of interpolation generally in the range [0.0, 1.0].
     * @return The linearly interpolated value.
     */
    @JsMethod
    public static native double lerp(double p, double q, double time);

    /**
     * Finds the logarithm of a number to a base.
     * @param number The number.
     * @param base The base.
     * @return The result.
     */
    @JsMethod
    public static native double logBase(double number, double base);

    /**
     * The modulo operation that also works for negative dividends.
     * @param m The dividend.
     * @param n The divisor.
     * @return The remainder.
     */
    @JsMethod
    public static native double mod(double m, double n);

    /**
     * Produces an angle in the range -Pi <= angle <= Pi which is equivalent to the provided angle.
     * @param angle in radians
     * @return The angle in the range [-CesiumMath.PI, CesiumMath.PI].
     */
    @JsMethod
    public static native double negativePiToPi(double angle);

    /**
     * Computes the next power-of-two integer greater than or equal to the provided positive integer.
     * <pre>
     * Example:
     * {@code double n = Math.nextPowerOfTwo(29); // 32
     * double m = Math.nextPowerOfTwo(32); // 32}
     * </pre>
     * @param n The positive integer to test.
     * @return The next power-of-two integer.
     */
    @JsMethod
    public static native double nextPowerOfTwo(double n);

    /**
     * Generates a random number in the range of [0.0, 1.0) using a Mersenne twister.
     * @return A random number in the range of [0.0, 1.0).
     * @see #setRandomNumberSeed(int)
     * @see <a href="http://en.wikipedia.org/wiki/Mersenne_twister">Mersenne twister on Wikipedia</a>
     */
    @JsMethod
    public static native double nextRandomNumber();

    /**
     * Generates a random number between two numbers.
     * @param min The minimum value.
     * @param max The maximum value.
     * @return A random number between the min and max.
     */
    @JsMethod
    public static native double randomBetween(double min, double max);

    /**
     * Sets the seed used by the random number generator in {@link #nextRandomNumber()}.
     * @param seed An integer used as the seed.
     */
    @JsMethod
    public static native void setRandomNumberSeed(int seed);

    /**
     * Returns the sign of the value; 1 if the value is positive, -1 if the value is negative, or 0 if the value is 0.
     * @param value The value to return the sign of.
     * @return The sign of value.
     */
    @JsMethod
    public static native double sign(double value);

    /**
     * Returns 1.0 if the given value is positive or zero, and -1.0 if it is negative. This is similar to {@link #sign}
     * except that returns 1.0 instead of 0.0 when the input value is 0.0.
     * @param value The value to return the sign of.
     * @return The sign of value.
     */
    @JsMethod
    public static native double signNotZero(double value);

    /**
     * Returns the hyperbolic sine of a number. The hyperbolic sine of value is defined to be (ex - e-x)/2.0 where e is Euler's number, approximately 2.71828183.
     * Special cases:
     * If the argument is NaN, then the result is NaN.
     * If the argument is infinite, then the result is an infinity with the same sign as the argument.
     * If the argument is zero, then the result is a zero with the same sign as the argument.
     * @param value The number whose hyperbolic sine is to be returned.
     * @return The hyperbolic sine of value.
     */
    @JsMethod
    public static native double sinh(double value);

    /**
     * Converts radians to degrees.
     * @param radians The angle to convert in radians.
     * @return The corresponding angle in degrees.
     */
    @JsMethod
    public static native double toDegrees(double radians);

    /**
     * Converts degrees to radians.
     * @param degrees The angle to convert in degrees.
     * @return The corresponding angle in radians.
     */
    @JsMethod
    public static native double toRadians(double degrees);

    /**
     * Converts a scalar value in the range [-1.0, 1.0] to a SNORM in the range [0, rangeMax]
     * @param value The scalar value in the range [-1.0, 1.0]
     * @return A SNORM value, where 0 maps to -1.0 and rangeMax maps to 1.0.
     * @see #fromSNorm(double, double)
     */
    @JsMethod
    public static native double toSNorm(double value);

    /**
     * Converts a scalar value in the range [-1.0, 1.0] to a SNORM in the range [0, rangeMax]
     * @param value The scalar value in the range [-1.0, 1.0]
     * @param rangeMax The maximum value in the mapped range, 255 by default.
     * @return A SNORM value, where 0 maps to -1.0 and rangeMax maps to 1.0.
     * @see #fromSNorm(double, double)
     */
    @JsMethod
    public static native double toSNorm(double value, double rangeMax);

    /**
     * Produces an angle in the range 0 <= angle <= 2Pi which is equivalent to the provided angle.
     * @param angle in radians
     * @return The angle in the range [0, CesiumMath.TWO_PI].
     */
    @JsMethod
    public static native double zeroToTwoPi(double angle);
}
