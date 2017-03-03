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
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Ray")
public class Ray {
    /**
     * The direction of the ray.
     */
    @JsProperty
    public Cartesian3 direction;
    /**
     * The origin of the ray.
     * Default:  {@link Cartesian3#ZERO()}
     */
    public Cartesian3 origin;

    /**
     * Represents a ray that extends infinitely from the provided origin in the provided direction.
     */
    @JsConstructor
    public Ray() {}

    /**
     * Represents a ray that extends infinitely from the provided origin in the provided direction.
     * @param origin The origin of the ray. Default: {@link Cartesian3#ZERO()}
     * @param direction The direction of the ray. Default: {@link Cartesian3#ZERO()}
     */
    @JsConstructor
    public Ray(Cartesian3 origin, Cartesian3 direction) {}

    /**
     * Computes the point along the ray given by r(t) = o + t*d, where o is the origin of the ray and d is the direction.
     * <pre>
     *     Example:
     *     {@code
     *     //Get the first intersection point of a ray and an ellipsoid.
     *     var intersection = Cesium.IntersectionTests.rayEllipsoid(ray, ellipsoid);
     *     Cartesian3 point = Ray.getPoint(ray, intersection.start);
     *     }
     * </pre>
     * @param ray The ray.
     * @param t A scalar value.
     * @return The modified result parameter, or a new instance if none was provided.
     */
    @JsMethod
    public static native Cartesian3 getPoint(Ray ray, double t);

    /**
     * Computes the point along the ray given by r(t) = o + t*d, where o is the origin of the ray and d is the direction.
     * <pre>
     *     Example:
     *     {@code
     *     //Get the first intersection point of a ray and an ellipsoid.
     *     var intersection = Cesium.IntersectionTests.rayEllipsoid(ray, ellipsoid);
     *     Cartesian3 point = Ray.getPoint(ray, intersection.start);
     *     }
     * </pre>
     * @param ray The ray.
     * @param t A scalar value.
     * @param result The object in which the result will be stored.
     * @return The modified result parameter, or a new instance if none was provided.
     */
    @JsMethod
    public static native Cartesian3 getPoint(Ray ray, double t, Cartesian3 result);
}
