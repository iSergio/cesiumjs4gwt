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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.promise.Promise;

/**
 * Contains functions for transforming positions to various reference frames.
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Transforms")
public class Transforms {
    /**
     * Contains functions for transforming positions to various reference frames.
     */
    @JsConstructor
    private Transforms() {}

    //TODO: Example
    /**
     * Computes a rotation matrix to transform a point or vector from the Earth-Fixed frame axes (ITRF) to the
     * International Celestial Reference Frame (GCRF/ICRF) inertial frame axes at a given time.
     * This function may return undefined if the data necessary to do the transformation is not yet loaded.
     * @param date The time at which to compute the rotation matrix.
     * @return The rotation matrix, or undefined if the data necessary to do the transformation is not yet loaded.
     * @see #preloadIcrfFixed
     */
    @JsMethod
    public static native Matrix3 computeFixedToIcrfMatrix(JulianDate date);

    //TODO: Example
    /**
     * Computes a rotation matrix to transform a point or vector from the Earth-Fixed frame axes (ITRF) to the
     * International Celestial Reference Frame (GCRF/ICRF) inertial frame axes at a given time.
     * This function may return undefined if the data necessary to do the transformation is not yet loaded.
     * @param date The time at which to compute the rotation matrix.
     * @param result The object onto which to store the result. If this parameter is not specified, a new instance is created and returned.
     * @return The rotation matrix, or undefined if the data necessary to do the transformation is not yet loaded.
     * @see #preloadIcrfFixed
     */
    @JsMethod
    public static native Matrix3 computeFixedToIcrfMatrix(JulianDate date, Matrix3 result);

    //TODO: Example
    /**
     * Computes a rotation matrix to transform a point or vector from the International Celestial Reference Frame (GCRF/ICRF)
     * inertial frame axes to the Earth-Fixed frame axes (ITRF) at a given time. This function may return undefined
     * if the data necessary to do the transformation is not yet loaded.
     * @param date The time at which to compute the rotation matrix.
     * @return The rotation matrix, or undefined if the data necessary to do the transformation is not yet loaded.
     * @see #preloadIcrfFixed
     */
    @JsMethod
    public static native Matrix3 computeIcrfToFixedMatrix(JulianDate date);

    //TODO: Example
    /**
     * Computes a rotation matrix to transform a point or vector from the International Celestial Reference Frame (GCRF/ICRF)
     * inertial frame axes to the Earth-Fixed frame axes (ITRF) at a given time. This function may return undefined
     * if the data necessary to do the transformation is not yet loaded.
     * @param date The time at which to compute the rotation matrix.
     * @param result The object onto which to store the result. If this parameter is not specified, a new instance is created and returned.
     * @return The rotation matrix, or undefined if the data necessary to do the transformation is not yet loaded.
     * @see #preloadIcrfFixed
     */
    @JsMethod
    public static native Matrix3 computeIcrfToFixedMatrix(JulianDate date, Matrix3 result);

    //TODO: Example
    /**
     * Computes a rotation matrix to transform a point or vector from True Equator Mean Equinox (TEME) axes to
     * the pseudo-fixed axes at a given time. This method treats the UT1 time standard as equivalent to UTC.
     * @param date The time at which to compute the rotation matrix.
     * @return The modified result parameter or a new Matrix3 instance if none was provided.
     */
    @JsMethod
    public static native Matrix3 computeTemeToPseudoFixedMatrix(JulianDate date);

    //TODO: Example
    /**
     * Computes a rotation matrix to transform a point or vector from True Equator Mean Equinox (TEME) axes to
     * the pseudo-fixed axes at a given time. This method treats the UT1 time standard as equivalent to UTC.
     * @param date The time at which to compute the rotation matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix3 instance if none was provided.
     */
    @JsMethod
    public static native Matrix3 computeTemeToPseudoFixedMatrix(JulianDate date, Matrix3 result);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with an east-north-up axes centered at the provided
     * origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local east direction.
     * The y axis points in the local north direction.
     * The z axis points in the direction of the ellipsoid surface normal which passes through the position.
     * @param origin The center point of the local reference frame.
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 eastNorthUpToFixedFrame(Cartesian3 origin);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with an east-north-up axes centered at the provided
     * origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local east direction.
     * The y axis points in the local north direction.
     * The z axis points in the direction of the ellipsoid surface normal which passes through the position.
     * @param origin The center point of the local reference frame.
     * @param ellipsoid Ellipsoid.WGS84	optional The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 eastNorthUpToFixedFrame(Cartesian3 origin, Ellipsoid ellipsoid);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with an east-north-up axes centered at the provided
     * origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local east direction.
     * The y axis points in the local north direction.
     * The z axis points in the direction of the ellipsoid surface normal which passes through the position.
     * @param origin The center point of the local reference frame.
     * @param ellipsoid Ellipsoid.WGS84	optional The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 eastNorthUpToFixedFrame(Cartesian3 origin, Ellipsoid ellipsoid, Matrix4 result);

    //TODO:Example
    /**
     * Computes a quaternion from a reference frame with axes computed from the heading-pitch-roll angles centered at the
     * provided origin. Heading is the rotation from the local north direction where a positive angle is increasing eastward.
     * Pitch is the rotation from the local east-north plane. Positive pitch angles are above the plane.
     * Negative pitch angles are below the plane. Roll is the first rotation applied about the local east axis.
     * @param origin The center point of the local reference frame.
     * @param headingPitchRoll The heading, pitch, and roll.
     * @return The modified result parameter or a new Quaternion instance if none was provided.
     */
    @JsMethod
    public static native Quaternion headingPitchRollQuaternion(Cartesian3 origin, HeadingPitchRoll headingPitchRoll);

    //TODO:Example
    /**
     * Computes a quaternion from a reference frame with axes computed from the heading-pitch-roll angles centered at the
     * provided origin. Heading is the rotation from the local north direction where a positive angle is increasing eastward.
     * Pitch is the rotation from the local east-north plane. Positive pitch angles are above the plane.
     * Negative pitch angles are below the plane. Roll is the first rotation applied about the local east axis.
     * @param origin The center point of the local reference frame.
     * @param headingPitchRoll The heading, pitch, and roll.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @return The modified result parameter or a new Quaternion instance if none was provided.
     */
    @JsMethod
    public static native Quaternion headingPitchRollQuaternion(Cartesian3 origin, HeadingPitchRoll headingPitchRoll, Ellipsoid ellipsoid);

    //TODO:Example
    /**
     * Computes a quaternion from a reference frame with axes computed from the heading-pitch-roll angles centered at the
     * provided origin. Heading is the rotation from the local north direction where a positive angle is increasing eastward.
     * Pitch is the rotation from the local east-north plane. Positive pitch angles are above the plane.
     * Negative pitch angles are below the plane. Roll is the first rotation applied about the local east axis.
     * @param origin The center point of the local reference frame.
     * @param headingPitchRoll The heading, pitch, and roll.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Quaternion instance if none was provided.
     */
    @JsMethod
    public static native Quaternion headingPitchRollQuaternion(Cartesian3 origin, HeadingPitchRoll headingPitchRoll, Ellipsoid ellipsoid, Quaternion result);

    /**
     * Computes a quaternion from a reference frame with axes computed from the heading-pitch-roll angles centered at the
     * provided origin. Heading is the rotation from the local north direction where a positive angle is increasing eastward.
     * Pitch is the rotation from the local east-north plane. Positive pitch angles are above the plane.
     * Negative pitch angles are below the plane. Roll is the first rotation applied about the local east axis.
     * @param origin The center point of the local reference frame.
     * @param headingPitchRoll The heading, pitch, and roll.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @param transform A 4x4 transformation matrix from a reference frame to the provided ellipsoid's fixed reference frame.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Quaternion instance if none was provided.
     */
    @JsMethod
    public static native Quaternion headingPitchRollQuaternion(Cartesian3 origin, HeadingPitchRoll headingPitchRoll, Ellipsoid ellipsoid, LocalFrameToFixedFrame transform, Quaternion result);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with axes computed from the heading-pitch-roll angles
     * centered at the provided origin to the provided ellipsoid's fixed reference frame. Heading is the rotation
     * from the local north direction where a positive angle is increasing eastward. Pitch is the rotation from the
     * local east-north plane. Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     * Roll is the first rotation applied about the local east axis.
     * @param origin The center point of the local reference frame.
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 headingPitchRollToFixedFrame(Cartesian3 origin, HeadingPitchRoll headingPitchRol);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with axes computed from the heading-pitch-roll angles
     * centered at the provided origin to the provided ellipsoid's fixed reference frame. Heading is the rotation
     * from the local north direction where a positive angle is increasing eastward. Pitch is the rotation from the
     * local east-north plane. Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     * Roll is the first rotation applied about the local east axis.
     * @param origin The center point of the local reference frame.
     * @param headingPitchRoll The heading, pitch, and roll.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation. Default {@link Ellipsoid#WGS84()}
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 headingPitchRollToFixedFrame(Cartesian3 origin, HeadingPitchRoll headingPitchRoll, Ellipsoid ellipsoid);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with axes computed from the heading-pitch-roll angles
     * centered at the provided origin to the provided ellipsoid's fixed reference frame. Heading is the rotation
     * from the local north direction where a positive angle is increasing eastward. Pitch is the rotation from the
     * local east-north plane. Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     * Roll is the first rotation applied about the local east axis.
     * @param origin The center point of the local reference frame.
     * @param headingPitchRoll The heading, pitch, and roll.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation. Default {@link Ellipsoid#WGS84()}
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 headingPitchRollToFixedFrame(Cartesian3 origin, HeadingPitchRoll headingPitchRoll, Ellipsoid ellipsoid, LocalFrameToFixedFrame fixedFrameTransform);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with axes computed from the heading-pitch-roll angles
     * centered at the provided origin to the provided ellipsoid's fixed reference frame. Heading is the rotation
     * from the local north direction where a positive angle is increasing eastward. Pitch is the rotation from the
     * local east-north plane. Positive pitch angles are above the plane. Negative pitch angles are below the plane.
     * Roll is the first rotation applied about the local east axis.
     * @param origin The center point of the local reference frame.
     * @param headingPitchRoll The heading, pitch, and roll.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation. Default {@link Ellipsoid#WGS84()}
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 headingPitchRollToFixedFrame(Cartesian3 origin, HeadingPitchRoll headingPitchRoll, Ellipsoid ellipsoid, LocalFrameToFixedFrame fixedFrameTransform, Matrix4 result);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with an north-east-down axes centered at the
     * provided origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local north direction.
     * The y axis points in the local east direction.
     * The z axis points in the opposite direction of the ellipsoid surface normal which passes through the position.
     * @param origin The center point of the local reference frame.
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 northEastDownToFixedFrame(Cartesian3 origin);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with an north-east-down axes centered at the
     * provided origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local north direction.
     * The y axis points in the local east direction.
     * The z axis points in the opposite direction of the ellipsoid surface normal which passes through the position.
     * @param origin The center point of the local reference frame.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 northEastDownToFixedFrame(Cartesian3 origin, Ellipsoid ellipsoid);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with an north-east-down axes centered at the
     * provided origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local north direction.
     * The y axis points in the local east direction.
     * The z axis points in the opposite direction of the ellipsoid surface normal which passes through the position.
     * @param origin The center point of the local reference frame.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 northEastDownToFixedFrame(Cartesian3 origin, Ellipsoid ellipsoid, Matrix4 result);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with an north-up-east axes centered at the
     * provided origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local north direction.
     * The y axis points in the direction of the ellipsoid surface normal which passes through the position.
     * The z axis points in the local east direction.
     * @param origin The center point of the local reference frame.
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 northUpEastToFixedFrame(Cartesian3 origin);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with an north-up-east axes centered at the
     * provided origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local north direction.
     * The y axis points in the direction of the ellipsoid surface normal which passes through the position.
     * The z axis points in the local east direction.
     * @param origin The center point of the local reference frame.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 northUpEastToFixedFrame(Cartesian3 origin, Ellipsoid ellipsoid);

    //TODO: Example
    /**
     * Computes a 4x4 transformation matrix from a reference frame with an north-up-east axes centered at the
     * provided origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local north direction.
     * The y axis points in the direction of the ellipsoid surface normal which passes through the position.
     * The z axis points in the local east direction.
     * @param origin The center point of the local reference frame.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 northUpEastToFixedFrame(Cartesian3 origin, Ellipsoid ellipsoid, Matrix4 result);

    /**
     * Computes a 4x4 transformation matrix from a reference frame with an north-west-up axes centered at the
     * provided origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local north direction.
     * The y axis points in the local west direction.
     * The z axis points in the direction of the ellipsoid surface normal which passes through the position.
     * @param origin The center point of the local reference frame.
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 northWestUpToFixedFrame(Cartesian3 origin);

    /**
     * Computes a 4x4 transformation matrix from a reference frame with an north-west-up axes centered at the
     * provided origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local north direction.
     * The y axis points in the local west direction.
     * The z axis points in the direction of the ellipsoid surface normal which passes through the position.
     * @param origin The center point of the local reference frame.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 northWestUpToFixedFrame(Cartesian3 origin, Ellipsoid ellipsoid);

    /**
     * Computes a 4x4 transformation matrix from a reference frame with an north-west-up axes centered at the
     * provided origin to the provided ellipsoid's fixed reference frame. The local axes are defined as:
     * The x axis points in the local north direction.
     * The y axis points in the local west direction.
     * The z axis points in the direction of the ellipsoid surface normal which passes through the position.
     * @param origin The center point of the local reference frame.
     * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation.
     *                  Default: {@link Ellipsoid#WGS84()}
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix4 instance if none was provided.
     */
    @JsMethod
    public static native Matrix4 northWestUpToFixedFrame(Cartesian3 origin, Ellipsoid ellipsoid, Matrix4 result);

    //TODO: Check
    /**
     * Generates a function that computes a 4x4 transformation matrix from a reference frame centered at the provided
     * origin to the provided ellipsoid's fixed reference frame.
     * @param firstAxis name of the first axis of the local reference frame. Must be 'east', 'north', 'up', 'west', 'south' or 'down'.
     * @param secondAxis name of the second axis of the local reference frame. Must be 'east', 'north', 'up', 'west', 'south' or 'down'.
     * @return The function that will computes a 4x4 transformation matrix from a reference frame, with first axis and second axis compliant with the parameters,
     */
    @JsMethod
    public static native LocalFrameToFixedFrame localFrameToFixedFrameGenerator(String firstAxis, String secondAxis);

    //TODO: Example
    /**
     * Transform a point from model coordinates to window coordinates.
     * @param modelViewProjectionMatrix The 4x4 model-view-projection matrix.
     * @param viewportTransformation The 4x4 viewport transformation.
     * @param point The point to transform.
     * @return The modified result parameter or a new Cartesian2 instance if none was provided.
     */
    @JsMethod
    public static native Cartesian2 pointToWindowCoordinates(Matrix4 modelViewProjectionMatrix, Matrix4 viewportTransformation, Cartesian3 point);

    //TODO: Example
    /**
     * Transform a point from model coordinates to window coordinates.
     * @param modelViewProjectionMatrix The 4x4 model-view-projection matrix.
     * @param viewportTransformation The 4x4 viewport transformation.
     * @param point The point to transform.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Cartesian2 instance if none was provided.
     */
    @JsMethod
    public static native Cartesian2 pointToWindowCoordinates(Matrix4 modelViewProjectionMatrix, Matrix4 viewportTransformation, Cartesian3 point, Cartesian2 result);

    /**
     * Preloads the data necessary to transform between the ICRF and Fixed axes, in either direction, over a given interval.
     * This function returns a promise that, when resolved, indicates that the preload has completed.
     * @param timeInterval The interval to preload.
     * @return A promise that, when resolved, indicates that the preload has completed and evaluation of the
     * transformation between the fixed and ICRF axes will no longer return undefined for a time inside the interval.
     * @see #computeIcrfToFixedMatrix
     * @see #computeFixedToIcrfMatrix
     */
    @JsMethod
    public static native Promise<Void, Void> preloadIcrfFixed(TimeInterval timeInterval);

    /**
     * Computes a 4x4 transformation matrix from a reference frame centered at the provided origin to the provided ellipsoid's fixed reference frame.
     */
    //TODO: Check
    @JsFunction
    public interface LocalFrameToFixedFrame {
        /**
         * Computes a 4x4 transformation matrix from a reference frame centered at the provided origin to the provided ellipsoid's fixed reference frame.
         * @param origin The center point of the local reference frame.
         * @param ellipsoid The ellipsoid whose fixed frame is used in the transformation.
         * @param result The object onto which to store the result.
         * @return The modified result parameter or a new Matrix4 instance if none was provided.
         */
        Matrix4 function(Cartesian3 origin, Ellipsoid ellipsoid, Matrix4 result);
    }
}
