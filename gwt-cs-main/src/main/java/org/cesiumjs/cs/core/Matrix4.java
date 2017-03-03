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
import org.cesiumjs.cs.scene.Camera;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Matrix4")
public class Matrix4 {
    /**
     * Gets the number of items in the collection.
     */
    @JsProperty
    public int length;
    /**
     * The index into Matrix4 for column 0, row 0.
     */
    @JsProperty(name = "COLUMN0ROW0")
    public static native int COLUMN0ROW0();
    /**
     * The index into Matrix4 for column 0, row 1.
     */
    @JsProperty(name = "COLUMN0ROW1")
    public static native int COLUMN0ROW1();
    /**
     * The index into Matrix4 for column 0, row 2
     */
    @JsProperty(name = "COLUMN0ROW2")
    public static native int COLUMN0ROW2();
    /**
     * The index into Matrix4 for column 0, row 3
     */
    @JsProperty(name = "COLUMN0ROW3")
    public static native int COLUMN0ROW3();
    /**
     * The index into Matrix4 for column 1, row 0.
     */
    @JsProperty(name = "COLUMN1ROW0")
    public static native int COLUMN1ROW0();
    /**
     * The index into Matrix4 for column 1, row 1.
     */
    @JsProperty(name = "COLUMN1ROW1")
    public static native int COLUMN1ROW1();
    /**
     * The index into Matrix4 for column 1, row 2.
     */
    @JsProperty(name = "COLUMN1ROW2")
    public static native int COLUMN1ROW2();
    /**
     * The index into Matrix4 for column 1, row 3.
     */
    @JsProperty(name = "COLUMN1ROW3")
    public static native int COLUMN1ROW3();
    /**
     * The index into Matrix4 for column 2, row 0.
     */
    @JsProperty(name = "COLUMN2ROW0")
    public static native int COLUMN2ROW0();
    /**
     * The index into Matrix4 for column 2, row 1.
     */
    @JsProperty(name = "COLUMN2ROW1")
    public static native int COLUMN2ROW1();
    /**
     * The index into Matrix4 for column 2, row 2.
     */
    @JsProperty(name = "COLUMN2ROW2")
    public static native int COLUMN2ROW2();
    /**
     * The index into Matrix4 for column 2, row 3.
     */
    @JsProperty(name = "COLUMN2ROW3")
    public static native int COLUMN2ROW3();
    /**
     * An immutable Matrix4 instance initialized to the identity matrix.
     */
    @JsProperty(name = "IDENTITY")
    public static native Matrix4 IDENTITY();
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public static int packedLength;
    /**
     * An immutable Matrix4 instance initialized to the zero matrix.
     */
    @JsProperty(name = "ZERO")
    public static native Matrix4 ZERO();

    /**
     * A 4x4 matrix, indexable as a column-major order array. Constructor parameters are in row-major order for code readability.
     */
    @JsConstructor
    public Matrix4() {}
    /**
     * A 4x4 matrix, indexable as a column-major order array. Constructor parameters are in row-major order for code readability.
     * @param column0Row0 The value for column 0, row 0. Default: 0.0.
     * @param column1Row0 The value for column 1, row 0. Default: 0.0.
     * @param column2Row0 The value for column 2, row 0. Default: 0.0.
     * @param column3Row0 The value for column 3, row 0. Default: 0.0.
     * @param column0Row1 The value for column 0, row 1. Default: 0.0.
     * @param column1Row1 The value for column 1, row 1. Default: 0.0.
     * @param column2Row1 The value for column 2, row 1. Default: 0.0.
     * @param column3Row1 The value for column 3, row 1. Default: 0.0.
     * @param column0Row2 The value for column 0, row 2. Default: 0.0.
     * @param column1Row2 The value for column 1, row 2. Default: 0.0.
     * @param column2Row2 The value for column 2, row 2. Default: 0.0.
     * @param column3Row2 The value for column 3, row 2. Default: 0.0.
     * @param column0Row3 The value for column 0, row 3. Default: 0.0.
     * @param column1Row3 The value for column 1, row 3. Default: 0.0.
     * @param column2Row3 The value for column 2, row 3. Default: 0.0.
     * @param column3Row3 The value for column 3, row 3. Default: 0.0.
     * @see #fromColumnMajorArray
     * @see #fromRowMajorArray
     * @see #fromRotationTranslation
     * @see #fromTranslationRotationScale
     * @see #fromTranslationQuaternionRotationScale
     * @see #fromTranslation
     * @see #fromScale
     * @see #fromUniformScale
     * @see #fromCamera
     * @see #computePerspectiveFieldOfView
     * @see #computeOrthographicOffCenter
     * @see #computePerspectiveOffCenter
     * @see #computeInfinitePerspectiveOffCenter
     * @see #computeViewportTransformation
     * @see #computeView
     * @see Matrix2
     * @see Matrix3
     * @see Packable
     */
    @JsConstructor
    public Matrix4(double column0Row0, double column1Row0, double column2Row0, double column3Row0,
                   double column0Row1, double column1Row1, double column2Row1, double column3Row1,
                   double column0Row2, double column1Row2, double column2Row2, double column3Row2,
                   double column0Row3, double column1Row3, double column2Row3, double column3Row3) {}

    /**
     * Duplicates the provided Matrix4 instance.
     * @return The modified result parameter or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public native Matrix4 clone();

    /**
     * Duplicates the provided Matrix4 instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public native Matrix4 clone(Matrix4 result);

    /**
     * Compares this matrix to the provided matrix componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side matrix.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(Matrix4 right);

    /**
     * Compares this matrix to the provided matrix componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param right The right hand side matrix.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if they are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(Matrix4 right, double epsilon);

    /**
     * Creates a string representing this Matrix with each row being on a separate line and in the format '(column0, column1)'.
     * @return A string representing the provided Matrix with each row being on a separate line and in the format '(column0, column1)'.
     */
    @JsMethod
    public native String toString();

    /**
     * Computes a matrix, which contains the absolute (unsigned) values of the provided matrix's elements.
     * @param matrix The matrix with signed elements.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 abs(Matrix4 matrix, Matrix4 result);

    /**
     * Computes the sum of two matrices.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 add(Matrix4 left, Matrix4 right, Matrix4 result);

    /**
     * Duplicates a Matrix4 instance.
     * @param matrix The matrix to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix4 instance if one was not provided. (Returns undefined if matrix is undefined)
     */
    @JsMethod
    public static native Matrix4 clone(Matrix4 matrix, Matrix4 result);

    /**
     * Computes a Matrix4 instance representing an infinite off center perspective transformation.
     * @param left The number of meters to the left of the camera that will be in view.
     * @param right The number of meters to the right of the camera that will be in view.
     * @param bottom The number of meters below of the camera that will be in view.
     * @param top The number of meters above of the camera that will be in view.
     * @param near The distance to the near plane in meters.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 computeInfinitePerspectiveOffCenter(double left, double right, double bottom, double top, double near);

    /**
     * Computes a Matrix4 instance representing an infinite off center perspective transformation.
     * @param left The number of meters to the left of the camera that will be in view.
     * @param right The number of meters to the right of the camera that will be in view.
     * @param bottom The number of meters below of the camera that will be in view.
     * @param top The number of meters above of the camera that will be in view.
     * @param near The distance to the near plane in meters.
     * @param result The object in which the result will be stored.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 computeInfinitePerspectiveOffCenter(double left, double right, double bottom, double top, double near, Matrix4 result);

    /**
     * Computes a Matrix4 instance representing an orthographic transformation matrix.
     * @param left The number of meters to the left of the camera that will be in view.
     * @param right The number of meters to the right of the camera that will be in view.
     * @param bottom The number of meters below of the camera that will be in view.
     * @param top The number of meters above of the camera that will be in view.
     * @param near The distance to the near plane in meters.
     * @param far The distance to the far plane in meters.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 computeOrthographicOffCenter(double left, double right, double bottom, double top, double near, double far);

    /**
     * Computes a Matrix4 instance representing an orthographic transformation matrix.
     * @param left The number of meters to the left of the camera that will be in view.
     * @param right The number of meters to the right of the camera that will be in view.
     * @param bottom The number of meters below of the camera that will be in view.
     * @param top The number of meters above of the camera that will be in view.
     * @param near The distance to the near plane in meters.
     * @param far The distance to the far plane in meters.
     * @param result The object in which the result will be stored.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 computeOrthographicOffCenter(double left, double right, double bottom, double top, double near, double far, Matrix4 result);

    /**
     * Computes a Matrix4 instance representing a perspective transformation matrix.
     * @param fovY The field of view along the Y axis in radians.
     * @param aspectRatio The aspect ratio.
     * @param near The distance to the near plane in meters.
     * @param far The distance to the far plane in meters.
     * @param result The object in which the result will be stored.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 computePerspectiveFieldOfView(double fovY, double aspectRatio, double near, double far, double result);

    /**
     * Computes a Matrix4 instance representing an off center perspective transformation.
     * @param left The number of meters to the left of the camera that will be in view.
     * @param right The number of meters to the right of the camera that will be in view.
     * @param bottom The number of meters below of the camera that will be in view.
     * @param top The number of meters above of the camera that will be in view.
     * @param near The distance to the near plane in meters.
     * @param far The distance to the far plane in meters.
     * @param result The object in which the result will be stored.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 computePerspectiveOffCenter(double left, double right, double bottom, double top, double near, double far, Matrix4 result);

    /**
     * Computes a Matrix4 instance that transforms from world space to view space.
     * @param position The position of the camera.
     * @param direction The forward direction.
     * @param up The up direction.
     * @param right The right direction.
     * @param result The object in which the result will be stored.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 computeView(Cartesian3 position, Cartesian3 direction, Cartesian3 up, Cartesian3 right, Matrix4 result);

    /**
     * Computes a Matrix4 instance that transforms from normalized device coordinates to window coordinates.
     * @param viewport The viewport's corners as shown in Example 1.
     * @param nearDepthRange The near plane distance in window coordinates.
     * @param farDepthRange The far plane distance in window coordinates.
     * @param result The object in which the result will be stored.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 computeViewportTransformation(Viewport viewport, double nearDepthRange, double farDepthRange, Matrix4 result);

    /**
     * Compares the provided matrices componentwise and returns true if they are equal, false otherwise.
     * @param left The first matrix.
     * @param right The second matrix.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(Matrix4 left, Matrix4 right);

    /**
     * Compares the provided matrices componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public static native boolean equalsEpsilon(Matrix4 left, Matrix4 right, double epsilon);

    /**
     * Creates a Matrix4 from 4 consecutive elements in an array.
     * <pre>
     *     {@code
     *     // Create the Matrix4:
     *     // [1.0, 2.0, 3.0]
     *     // [1.0, 2.0, 3.0]
     *     // [1.0, 2.0, 3.0]
     *     double[] v = {1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0};
     *     Matrix4 m = Matrix4.fromArray(v);
     *
     *     // Create same Matrix4 with using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0};
     *     Matrix4 m2 = Matrix4.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose 4 consecutive elements correspond to the positions of the matrix. Assumes column-major order.
     * @return parameter or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromArray(double[] array);

    /**
     * Creates a Matrix4 from 4 consecutive elements in an array.
     * <pre>
     *     {@code
     *     // Create the Matrix4:
     *     // [1.0, 2.0, 3.0, 4.0]
     *     // [1.0, 2.0, 3.0, 4.0]
     *     // [1.0, 2.0, 3.0, 4.0]
     *     // [1.0, 2.0, 3.0, 4.0]
     *     double[] v = {1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0};
     *     Matrix4 m = Matrix4.fromArray(v);
     *
     *     // Create same Matrix4 with using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0};
     *     Matrix4 m2 = Matrix4.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose 4 consecutive elements correspond to the positions of the matrix. Assumes column-major order.
     * @param startingIndex The offset into the array of the first element, which corresponds to first column first row position in the matrix.
     *                      Default 0
     * @return parameter or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromArray(double[] array, int startingIndex);

    /**
     * Creates a Matrix4 from 4 consecutive elements in an array.
     * <pre>
     *     {@code
     *     // Create the Matrix4:
     *     // [1.0, 2.0, 3.0, 4.0]
     *     // [1.0, 2.0, 3.0, 4.0]
     *     // [1.0, 2.0, 3.0, 4.0]
     *     // [1.0, 2.0, 3.0, 4.0]
     *     double[] v = {1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0};
     *     Matrix4 m = Matrix4.fromArray(v);
     *
     *     // Create same Matrix4 with using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0};
     *     Matrix4 m2 = Matrix4.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose 4 consecutive elements correspond to the positions of the matrix. Assumes column-major order.
     * @param startingIndex The offset into the array of the first element, which corresponds to first column first row position in the matrix.
     *                      Default 0
     * @param result The object onto which to store the result.
     * @return parameter or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromArray(double[] array, int startingIndex, Matrix4 result);

    /**
     * Computes a Matrix4 instance from a Camera.
     * @param camera The camera to use.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromCamera(Camera camera);

    /**
     * Computes a Matrix4 instance from a Camera.
     * @param camera The camera to use.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromCamera(Camera camera, Matrix4 result);

    /**
     * Creates a Matrix4 instance from a column-major order array.
     * @param values The column-major order array.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromColumnMajorArray(double[] values);

    /**
     * Creates a Matrix4 instance from a column-major order array.
     * @param values The column-major order array.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromColumnMajorArray(double[] values, Matrix4 result);

    /**
     * Computes a Matrix4 instance from a Matrix3 representing the rotation and a Cartesian3 representing the translation.
     * @param rotation The upper left portion of the matrix representing the rotation.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromRotationTranslation(Matrix3 rotation);

    /**
     * Computes a Matrix4 instance from a Matrix3 representing the rotation and a Cartesian3 representing the translation.
     * @param rotation The upper left portion of the matrix representing the rotation.
     * @param translation The upper right portion of the matrix representing the translation. Default: {@link Cartesian3#ZERO()}
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromRotationTranslation(Matrix3 rotation, Cartesian3 translation);

    /**
     * Computes a Matrix4 instance from a Matrix3 representing the rotation and a Cartesian3 representing the translation.
     * @param rotation The upper left portion of the matrix representing the rotation.
     * @param translation The upper right portion of the matrix representing the translation. Default: {@link Cartesian3#ZERO()}
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromRotationTranslation(Matrix3 rotation, Cartesian3 translation, Matrix4 result);

    /**
     * Creates a Matrix4 instance from a row-major order array. The resulting matrix will be in column-major order.
     * @param values The row-major order array.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromRowMajorArray(double[] values);

    /**
     * Creates a Matrix4 instance from a row-major order array. The resulting matrix will be in column-major order.
     * @param values The row-major order array.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromRowMajorArray(double[] values, Matrix4 result);

    /**
     * Computes a Matrix4 instance representing a non-uniform scale.
     * <pre>
     *     {@code
     *     // Creates
     *     //   [7.0, 0.0, 0.0, 0.0]
     *     //   [0.0, 8.0, 0.0, 0.0]
     *     //   [0.0, 0.0, 9.0, 0.0]
     *     //   [0.0, 0.0, 0.0, 1.0]
     *     Matrix4 m = Matrix4.fromScale(new Cartesian3(7.0, 8.0, 9.0));
     *     }
     * </pre>
     * @param scale The x and y scale factors.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromScale(Cartesian3 scale);

    /**
     * Computes a Matrix4 instance representing a non-uniform scale.
     * <pre>
     *     {@code
     *     // Creates
     *     //   [7.0, 0.0, 0.0, 0.0]
     *     //   [0.0, 8.0, 0.0, 0.0]
     *     //   [0.0, 0.0, 9.0, 0.0]
     *     //   [0.0, 0.0, 0.0, 1.0]
     *     Matrix4 m = Matrix4.fromScale(new Cartesian3(7.0, 8.0, 9.0));
     *     }
     * </pre>
     * @param scale The x and y scale factors.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromScale(Cartesian3 scale, Matrix4 result);

    /**
     * Creates a Matrix4 instance from a Cartesian3 representing the translation.
     * @param translation The upper right portion of the matrix representing the translation.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     * @see #multiplyByTranslation(Matrix4, Cartesian3, Matrix4)
     */
    @JsMethod
    public static native Matrix4 fromTranslation(Cartesian3 translation);

    /**
     * Creates a Matrix4 instance from a Cartesian3 representing the translation.
     * @param translation The upper right portion of the matrix representing the translation.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     * @see #multiplyByTranslation(Matrix4, Cartesian3, Matrix4)
     */
    @JsMethod
    public static native Matrix4 fromTranslation(Cartesian3 translation, Matrix4 result);

    /**
     * Computes a Matrix4 instance from a translation, rotation, and scale (TRS) representation with the rotation represented as a quaternion.
     * @param translation The translation transformation.
     * @param rotation The rotation transformation.
     * @param scale The non-uniform scale transformation.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    // TODO: examples
    public static native Matrix4 fromTranslationQuaternionRotationScale(Cartesian3 translation, Quaternion rotation, Cartesian3 scale);

    /**
     * Computes a Matrix4 instance from a translation, rotation, and scale (TRS) representation with the rotation represented as a quaternion.
     * @param translation The translation transformation.
     * @param rotation The rotation transformation.
     * @param scale The non-uniform scale transformation.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    // TODO: examples
    public static native Matrix4 fromTranslationQuaternionRotationScale(Cartesian3 translation, Quaternion rotation, Cartesian3 scale, Matrix4 result);

    /**
     * Creates a Matrix4 instance from a TranslationRotationScale instance.
     * @param translationRotationScale The instance.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromTranslationRotationScale(TranslationRotationScale translationRotationScale);

    /**
     * Creates a Matrix4 instance from a TranslationRotationScale instance.
     * @param translationRotationScale The instance.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromTranslationRotationScale(TranslationRotationScale translationRotationScale, Matrix4 result);

    /**
     * Computes a Matrix4 instance representing a uniform scale.
     * @param scale The uniform scale factor.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromUniformScale(double scale);

    /**
     * Computes a Matrix4 instance representing a uniform scale.
     * @param scale The uniform scale factor.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 fromUniformScale(double scale, Matrix4 result);

    /**
     * Retrieves a copy of the matrix column at the provided index as a Cartesian3 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the column to retrieve.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 getColumn(Matrix4 matrix, int index, Cartesian4 result);

    /**
     * Computes the array index of the element at the provided row and column.
     * @param row The zero-based index of the row.
     * @param column The zero-based index of the column.
     * @return The index of the element at the provided row and column.
     */
    // TODO: example
    @JsMethod
    public static native double getElementIndex(int row, int column);

    /**
     * Computes the maximum scale assuming the matrix is an affine transformation. The maximum scale is the maximum length of the column vectors.
     * @param matrix Matrix4	The matrix.
     * @return The maximum scale.
     */
    @JsMethod
    public static native double getMaximumScale(Matrix4 matrix);

    /**
     * Gets the upper left 3x3 rotation matrix of the provided matrix, assuming the matrix is a affine transformation matrix.
     * <pre>
     *     Example:
     *     {@code
     *     // returns a Matrix3 instance from a Matrix4 instance
     *     // m = [10.0, 14.0, 18.0, 22.0]
     *     //     [11.0, 15.0, 19.0, 23.0]
     *     //     [12.0, 16.0, 20.0, 24.0]
     *     //     [13.0, 17.0, 21.0, 25.0]
     *
     *     Matrix4 b = new Matrix4();
     *     Matrix4.getRotation(m,b);
     *     // b = [10.0, 14.0, 18.0]
     *     //     [11.0, 15.0, 19.0]
     *     //     [12.0, 16.0, 20.0]
     *     }
     * </pre>
     * @param matrix The matrix to use.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix3 getRotation(Matrix4 matrix, Matrix3 result);

    /**
     * Retrieves a copy of the matrix row at the provided index as a Cartesian3 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the row to retrieve.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 getRow(Matrix4 matrix, int index, Cartesian4 result);

    /**
     * Extracts the non-uniform scale assuming the matrix is an affine transformation.
     * @param matrix The matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 getScale(Matrix4 matrix, Cartesian3 result);

    /**
     * Gets the translation portion of the provided matrix, assuming the matrix is a affine transformation matrix.
     * @param matrix The matrix to use.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 getTranslation(Matrix4 matrix, Cartesian3 result);

    /**
     * Computes the inverse of the provided matrix.
     * @param matrix The matrix to invert.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 inverse(Matrix4 matrix, Matrix4 result);

    /**
     * Computes the inverse of the provided matrix assuming it is an affine transformation matrix, where the upper left 3x3
     * elements are a rotation matrix, and the upper three elements in the fourth column are the translation.
     * The bottom row is assumed to be [0, 0, 0, 1]. The matrix is not verified to be in the proper form.
     * This method is faster than computing the inverse for a general 4x4 matrix using Matrix4.inverse.
     * @param matrix The matrix to invert.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 inverseTransformation(Matrix4 matrix, Matrix4 result);

    /**
     * Computes the product of two matrices.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 multiply(Matrix4 left, Matrix4 right, Matrix4 result);

    /**
     * Multiplies a transformation matrix (with a bottom row of [0.0, 0.0, 0.0, 1.0]) by a 3x3 rotation matrix.
     * This is an optimization for Matrix4.multiply(m, Matrix4.fromRotationTranslation(rotation), m);
     * with less allocations and arithmetic operations.
     * @param matrix The matrix on the left-hand side.
     * @param rotation The 3x3 rotation matrix on the right-hand side.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    // TODO: example
    public static native Matrix4 multiplyByMatrix3(Matrix4 matrix, Matrix3 rotation, Matrix4 result);

    /**
     * Computes the product of a matrix and a Cartesian3. This is equivalent to calling Matrix4.multiplyByVector with a
     * Cartesian4 with a w component of 1, but returns a Cartesian3 instead of a Cartesian4.
     * <pre>
     *     Example:
     *     {@code
     *     Cartesian3 p = new Cartesian3(1.0, 2.0, 3.0);
     *     Cartesian3 result = Matrix4.multiplyByPoint(matrix, p, new Cartesian3());
     *     }
     * </pre>
     * @param matrix The matrix.
     * @param cartesian The point.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 multiplyByPoint(Matrix4 matrix, Cartesian3 cartesian, Cartesian3 result);

    /**
     * Computes the product of a matrix and a Cartesian3. This is equivalent to calling Matrix4.multiplyByVector with a
     * Cartesian4 with a w component of zero.
     * <pre>
     *     Example:
     *     {@code
     *     Cartesian3 p = new Cartesian3(1.0, 2.0, 3.0);
     *     Cartesian3 result = Matrix4.multiplyByPointAsVector(matrix, p, new Cartesian3());
     *     }
     * </pre>
     * @param matrix The matrix.
     * @param cartesian The point.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 multiplyByPointAsVector(Matrix4 matrix, Cartesian3 cartesian, Cartesian3 result);

    /**
     * Computes the product of a matrix and a scalar.
     * @param matrix The matrix.
     * @param scalar The number to multiply by.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 multiplyByScalar(Matrix4 matrix, double scalar, Matrix4 result);

    /**
     * Computes the product of a matrix times a (non-uniform) scale, as if the scale were a scale matrix.
     * <pre>
     *     Example:
     *     {@code
     *     // Instead of Cesium.Matrix4.multiply(m, Cesium.Matrix4.fromScale(scale), m);
     *     Matrix4.multiplyByScale(m, scale, m);
     *     }
     * </pre>
     * @param matrix The matrix on the left-hand side.
     * @param scale The non-uniform scale on the right-hand side.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     * @see #fromScale(org.cesiumjs.cs.core.Cartesian3)
     * @see #fromScale(org.cesiumjs.cs.core.Cartesian3, org.cesiumjs.cs.core.Matrix4)
     */
    @JsMethod
    public static native Matrix4 multiplyByScale(Matrix4 matrix, Cartesian3 scale, Matrix4 result);

    /**
     * Multiplies a transformation matrix (with a bottom row of [0.0, 0.0, 0.0, 1.0]) by an implicit translation matrix
     * defined by a Cartesian3. This is an optimization for Matrix4.multiply(m, Matrix4.fromTranslation(position), m);
     * with less allocations and arithmetic operations.
     * <pre>
     *     Example:
     *     {@code
     *     // Instead of Matrix4.multiply(m, Matrix4.fromTranslation(position), m);
     *     Matrix4.multiplyByTranslation(m, position, m);
     *     }
     * </pre>
     * @param matrix The matrix on the left-hand side.
     * @param translation The translation on the right-hand side.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 multiplyByTranslation(Matrix4 matrix, Cartesian3 translation, Matrix4 result);

    /**
     * Multiplies an affine transformation matrix (with a bottom row of [0.0, 0.0, 0.0, 1.0]) by an implicit uniform scale matrix.
     * This is an optimization for Matrix4.multiply(m, Matrix4.fromUniformScale(scale), m);, where m must be an affine matrix.
     * This function performs fewer allocations and arithmetic operations.
     * <pre>
     *     {@code
     *     // Instead of Matrix4.multiply(m, Matrix4.fromUniformScale(scale), m);
     *     Matrix4.multiplyByUniformScale(m, scale, m);
     *     }
     * </pre>
     * @param matrix The affine matrix on the left-hand side.
     * @param scale The uniform scale on the right-hand side.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     * @see #fromUniformScale(double)
     * @see #fromUniformScale(double, Matrix4)
     * @see #multiplyByScale(Matrix4, org.cesiumjs.cs.core.Cartesian3, Matrix4)
     */
    @JsMethod
    public static native Matrix4 multiplyByUniformScale(Matrix4 matrix, double scale, Matrix4 result);

    /**
     * Computes the product of a matrix and a column vector.
     * @param matrix The matrix.
     * @param cartesian The column.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian4 multiplyByVector(Matrix4 matrix, Cartesian4 cartesian, Cartesian4 result);

    /**
     * Computes the product of two matrices assuming the matrices are affine transformation matrices,
     * where the upper left 3x3 elements are a rotation matrix, and the upper three elements in the fourth column are the translation.
     * The bottom row is assumed to be [0, 0, 0, 1]. The matrix is not verified to be in the proper form.
     * This method is faster than computing the product for general 4x4 matrices using Matrix4.multiply.
     * <pre>
     *     {@code
     *     Matrix4 m1 = new Matrix4(1.0, 6.0, 7.0, 0.0, 2.0, 5.0, 8.0, 0.0, 3.0, 4.0, 9.0, 0.0, 0.0, 0.0, 0.0, 1.0);
     *     var m2 = Transforms.eastNorthUpToFixedFrame(new Cartesian3(1.0, 1.0, 1.0));
     *     Matrix4 m3 = Matrix4.multiplyTransformation(m1, m2, new Matrix4());
     *     }
     * </pre>
     * @param left The first matrix.
     * @param right The second matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 multiplyTransformation(Matrix4 left, Matrix4 right, Matrix4 result);

    /**
     * Creates a negated copy of the provided matrix.
     * @param matrix The matrix to negate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 negate(Matrix4 matrix, Matrix4 result);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The value to pack.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Matrix4 value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The value to pack.
     * @param startingIndex The index into the array at which to start packing the elements. Default: 0
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Matrix4 value, double[] array, int startingIndex);

    /**
     * Computes a new matrix that replaces the specified column in the provided matrix with the provided Cartesian3 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the column to set.
     * @param cartesian The Cartesian whose values will be assigned to the specified column.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 setColumn(Matrix4 matrix, int index, Cartesian4 cartesian, Matrix4 result);

    /**
     * Computes a new matrix that replaces the specified row in the provided matrix with the provided Cartesian3 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the row to set.
     * @param cartesian The Cartesian whose values will be assigned to the specified row.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 setRow(Matrix4 matrix, int index, Cartesian4 cartesian, Matrix4 result);

    /**
     * Computes a new matrix that replaces the translation in the rightmost column of the provided matrix with the provided
     * translation. This assumes the matrix is an affine transformation
     * @param matrix The matrix to use.
     * @param translation The translation that replaces the translation of the provided matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 setTranslation(Matrix4 matrix, Cartesian4 translation, Cartesian4 result);

    /**
     * Computes the difference of two matrices.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 subtract(Matrix4 left, Matrix4 right, Matrix4 result);

    /**
     * Creates an Array from the provided Matrix4 instance. The array will be in column-major order.
     * @param matrix The matrix to use.
     * @return The modified Array parameter or a new Array instance if one was not provided.
     */
    @JsMethod
    public static native double[] toArray(Matrix4 matrix);

    /**
     * Creates an Array from the provided Matrix4 instance. The array will be in column-major order.
     * @param matrix The matrix to use.
     * @param result The Array onto which to store the result.
     * @return The modified Array parameter or a new Array instance if one was not provided.
     */
    @JsMethod
    public static native double[] toArray(Matrix4 matrix, double[] result);

    /**
     * Computes the transpose of the provided matrix.
     * @param matrix The matrix to transpose.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix4 transpose(Matrix4 matrix, Matrix4 result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @return The modified result parameter or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new Matrix4 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix4 unpack(double[] array, int startingIndex, Matrix4 result);
}
