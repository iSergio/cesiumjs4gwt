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

package org.cesiumjs.cs.core;

import com.google.gwt.typedarrays.shared.Float32Array;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Value and type information for per-instance geometry attribute that
 * determines if the geometry instance has a distance display condition.
 *
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "DistanceDisplayConditionGeometryInstanceAttribute")
public class DistanceDisplayConditionGeometryInstanceAttribute {
    /**
     * The values for the attributes stored in a typed array. Default: [0.0, 0.0,
     * Number.MAX_VALUE]
     */
    @JsProperty
    public Float32Array value;

    /**
     * Value and type information for per-instance geometry attribute that
     * determines if the geometry instance has a distance display condition.
     *
     * @see org.cesiumjs.cs.core.geometry.GeometryInstance
     * @see GeometryInstanceAttribute
     */
    @JsConstructor
    public DistanceDisplayConditionGeometryInstanceAttribute() {
    }

    /**
     * Value and type information for per-instance geometry attribute that
     * determines if the geometry instance has a distance display condition.
     *
     * @param near The near distance.
     * @see org.cesiumjs.cs.core.geometry.GeometryInstance
     * @see GeometryInstanceAttribute
     */
    @JsConstructor
    public DistanceDisplayConditionGeometryInstanceAttribute(double near) {
    }

    /**
     * Value and type information for per-instance geometry attribute that
     * determines if the geometry instance has a distance display condition.
     *
     * @param near The near distance.
     * @param far  The far distance.
     * @see org.cesiumjs.cs.core.geometry.GeometryInstance
     * @see GeometryInstanceAttribute Example: {@code
     * BoxGeometryOptions boxGeometryOptions = new BoxGeometryOptions();
     * boxGeometryOptions.vertexFormat = VertexFormat.POSITION_AND_NORMAL();
     * boxGeometryOptions.minimum = new Cartesian3(-250000.0, -250000.0, -250000.0);
     * boxGeometryOptions.maximum = new Cartesian3(250000.0, 250000.0, 250000.0);
     * <p>
     * JsObject attributes = JsObject.create();
     * attributes.setProperty("show", new DistanceDisplayConditionGeometryInstanceAttribute(100.0, 10000.0));
     * <p>
     * GeometryInstanceOptions instanceOptions = new GeometryInstanceOptions();
     * instanceOptions.geometry = new BoxGeometry(boxGeometryOptions);
     * instanceOptions.modelMatrix = Matrix4.multiplyByTranslation(Transforms.eastNorthUpToFixedFrame(Cartesian3.fromDegrees(-75.59777, 40.03883)), new Cartesian3(0.0, 0.0, 1000000.0), new Matrix4());
     * instanceOptions.id = "box";
     * instanceOptions.attributes = attributes;
     * <p>
     * GeometryInstance instance = new GeometryInstance(instanceOptions);
     * }
     */
    @JsConstructor
    public DistanceDisplayConditionGeometryInstanceAttribute(double near, double far) {
    }

    /**
     * Creates a new DistanceDisplayConditionGeometryInstanceAttribute instance
     * given the provided an enabled flag and DistanceDisplayCondition.
     *
     * @param distanceDisplayCondition The distance display condition.
     * @return The new DistanceDisplayConditionGeometryInstanceAttribute instance.
     */
    @JsMethod
    public static native DistanceDisplayConditionGeometryInstanceAttribute fromDistanceDisplayCondition(
            DistanceDisplayCondition distanceDisplayCondition);

    /**
     * Converts a distance display condition to a typed array that can be used to
     * assign a distance display condition attribute.
     *
     * @param distanceDisplayCondition The distance display condition value.
     * @return The modified result parameter or a new instance if result was
     * undefined.
     */
    @JsMethod
    public static native Float32Array toValue(DistanceDisplayCondition distanceDisplayCondition);

    /**
     * Converts a distance display condition to a typed array that can be used to
     * assign a distance display condition attribute.
     *
     * @param distanceDisplayCondition The distance display condition value.
     * @param result                   The array to store the result in, if
     *                                 undefined a new instance will be created.
     * @return The modified result parameter or a new instance if result was
     * undefined.
     */
    @JsMethod
    public static native Float32Array toValue(DistanceDisplayCondition distanceDisplayCondition, Float32Array result);

    /**
     * The datatype of each component in the attribute, e.g., individual elements in
     * DistanceDisplayConditionGeometryInstanceAttribute#value. Default:
     * {@link ComponentDatatype#FLOAT()}
     */
    @SuppressWarnings("unusable-by-js")
    @JsProperty(name = "componentDatatype")
    public native Number componentDatatype();

    /**
     * The number of components in the attributes, i.e.,
     * DistanceDisplayConditionGeometryInstanceAttribute#value. Default: 3
     */
    @SuppressWarnings("unusable-by-js")
    @JsProperty(name = "componentsPerAttribute")
    public native int componentsPerAttribute();

    /**
     * When true and componentDatatype is an integer format, indicate that the
     * components should be mapped to the range [0, 1] (unsigned) or [-1, 1]
     * (signed) when they are accessed as floating-point for rendering. Default:
     * false
     */
    @JsProperty(name = "normalize")
    public native boolean normalize();
}
