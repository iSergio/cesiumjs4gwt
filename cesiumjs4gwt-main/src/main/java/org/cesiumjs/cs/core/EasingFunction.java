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
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "EasingFunction")
public class EasingFunction {
    /**
     * Back in.
     */
    @JsProperty(name = "BACK_IN")
    public static native EasingFunction BACK_IN();
    /**
     * Back in then out.
     */
    @JsProperty(name = "BACK_IN_OUT")
    public static native EasingFunction BACK_IN_OUT();
    /**
     * Back out.
     */
    @JsProperty(name = "BACK_OUT")
    public static native EasingFunction BACK_OUT();
    /**
     * Bounce in.
     */
    @JsProperty(name = "BOUNCE_IN")
    public static native EasingFunction BOUNCE_IN();
    /**
     * Bounce in then out.
     */
    @JsProperty(name = "BOUNCE_IN_OUT")
    public static native EasingFunction BOUNCE_IN_OUT();
    /**
     * Bounce out.
     */
    @JsProperty(name = "BOUNCE_OUT")
    public static native EasingFunction BOUNCE_OUT();
    /**
     * Circular in.
     */
    @JsProperty(name = "CIRCULAR_IN")
    public static native EasingFunction CIRCULAR_IN();
    /**
     * Circular in then out.
     */
    @JsProperty(name = "CIRCULAR_IN_OUT")
    public static native EasingFunction CIRCULAR_IN_OUT();
    /**
     * Circular out.
     */
    @JsProperty(name = "CIRCULAR_OUT")
    public static native EasingFunction CIRCULAR_OUT();
    /**
     * Cubic in.
     */
    @JsProperty(name = "CUBIC_IN")
    public static native EasingFunction CUBIC_IN();
    /**
     * Cubic in then out.
     */
    @JsProperty(name = "CUBIC_IN_OUT")
    public static native EasingFunction CUBIC_IN_OUT();
    /**
     * Cubic out.
     */
    @JsProperty(name = "CUBIC_OUT")
    public static native EasingFunction CUBIC_OUT();
    /**
     * Elastic in.
     */
    @JsProperty(name = "ELASTIC_IN")
    public static native EasingFunction ELASTIC_IN();
    /**
     * Elastic in then out.
     */
    @JsProperty(name = "ELASTIC_IN_OUT")
    public static native EasingFunction ELASTIC_IN_OUT();
    /**
     * Elastic out.
     */
    @JsProperty(name = "ELASTIC_OUT")
    public static native EasingFunction ELASTIC_OUT();
    /**
     * Exponential in.
     */
    @JsProperty(name = "EXPONENTIAL_IN")
    public static native EasingFunction EXPONENTIAL_IN();
    /**
     * Exponential in then out.
     */
    @JsProperty(name = "EXPONENTIAL_IN_OUT")
    public static native EasingFunction EXPONENTIAL_IN_OUT();
    /**
     * Exponential out.
     */
    @JsProperty(name = "EXPONENTIAL_OUT")
    public static native EasingFunction EXPONENTIAL_OUT();
    /**
     * Linear easing.
     */
    @JsProperty(name = "LINEAR_NONE")
    public static native EasingFunction LINEAR_NONE();
    /**
     * Quadratic in.
     */
    @JsProperty(name = "QUADRACTIC_IN")
    public static native EasingFunction QUADRACTIC_IN();
    /**
     * Quadratic in then out.
     */
    @JsProperty(name = "QUADRACTIC_IN_OUT")
    public static native EasingFunction QUADRACTIC_IN_OUT();
    /**
     * Quadratic out.
     */
    @JsProperty(name = "QUADRACTIC_OUT")
    public static native EasingFunction QUADRACTIC_OUT();
    /**
     * Quartic in.
     */
    @JsProperty(name = "QUARTIC_IN")
    public static native EasingFunction QUARTIC_IN();
    /**
     * Quartic in then out.
     */
    @JsProperty(name = "QUARTIC_IN_OUT")
    public static native EasingFunction QUARTIC_IN_OUT();
    /**
     * Quartic out.
     */
    @JsProperty(name = "QUARTIC_OUT")
    public static native EasingFunction QUARTIC_OUT();
    /**
     * Quintic in.
     */
    @JsProperty(name = "QUINTIC_IN")
    public static native EasingFunction QUINTIC_IN();
    /**
     * Quintic in then out.
     */
    @JsProperty(name = "QUINTIC_IN_OUT")
    public static native EasingFunction QUINTIC_IN_OUT();
    /**
     * Quintic out.
     */
    @JsProperty(name = "QUINTIC_OUT")
    public static native EasingFunction QUINTIC_OUT();
    /**
     * Sinusoidal in.
     */
    @JsProperty(name = "SINUSOIDAL_IN")
    public static native EasingFunction SINUSOIDAL_IN();
    /**
     * Sinusoidal in then out.
     */
    @JsProperty(name = "SINUSOIDAL_IN_OUT")
    public static native EasingFunction SINUSOIDAL_IN_OUT();
    /**
     * Sinusoidal out.
     */
    @JsProperty(name = "SINUSOIDAL_OUT")
    public static native EasingFunction SINUSOIDAL_OUT();


    /**
     * Easing functions for use with {@link TweenCollection}. These function are from Tween.js and Robert Penner.
     * See the Tween.js graphs for each function.
     */
    @JsConstructor
    private EasingFunction() {}

    @JsFunction
    public interface Callback {
        double function(float time);
    }
}
