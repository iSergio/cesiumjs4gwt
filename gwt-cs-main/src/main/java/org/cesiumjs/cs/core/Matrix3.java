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
@JsType(isNative = true, namespace = "Cesium", name = "Matrix3")
public class Matrix3 {
    /**
     * Gets the number of items in the collection.
     */
    @JsProperty
    public int length;
    /**
     * The index into Matrix3 for column 0, row 0.
     */
    @JsProperty(name = "COLUMN0ROW0")
    public static native int COLUMN0ROW0();
    /**
     * The index into Matrix3 for column 0, row 1.
     */
    @JsProperty(name = "COLUMN0ROW1")
    public static native int COLUMN0ROW1();
    /**
     * The index into Matrix3 for column 0, row 2
     */
    @JsProperty(name = "COLUMN0ROW2")
    public static native int COLUMN0ROW2();
    /**
     * The index into Matrix3 for column 1, row 0.
     */
    @JsProperty(name = "COLUMN1ROW0")
    public static native int COLUMN1ROW0();
    /**
     * The index into Matrix3 for column 1, row 1.
     */
    @JsProperty(name = "COLUMN1ROW1")
    public static native int COLUMN1ROW1();
    /**
     * The index into Matrix3 for column 1, row 2.
     */
    @JsProperty(name = "COLUMN1ROW2")
    public static native int COLUMN1ROW2();
    /**
     * The index into Matrix3 for column 2, row 0.
     */
    @JsProperty(name = "COLUMN2ROW0")
    public static native int COLUMN2ROW0();
    /**
     * The index into Matrix3 for column 2, row 1.
     */
    @JsProperty(name = "COLUMN2ROW1")
    public static native int COLUMN2ROW1();
    /**
     * The index into Matrix3 for column 2, row 2.
     */
    @JsProperty(name = "COLUMN2ROW2")
    public static native int COLUMN2ROW2();
    /**
     * An immutable Matrix3 instance initialized to the identity matrix.
     */
    @JsProperty(name = "IDENTITY")
    public static native Matrix3 IDENTITY();
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public static int packedLength;
    /**
     * An immutable Matrix3 instance initialized to the zero matrix.
     */
    @JsProperty(name = "ZERO")
    public static native Matrix3 ZERO();

    /**
     * A 3x3 matrix, indexable as a column-major order array. Constructor parameters are in row-major order for code readability.
     * @see #fromColumnMajorArray(double[])
     * @see #fromColumnMajorArray(double[], Matrix3)
     * @see #fromRowMajorArray(double[])
     * @see #fromRowMajorArray(double[], Matrix3)
     * @see #fromScale(Cartesian3)
     * @see #fromScale(Cartesian3, Matrix3)
     * @see Matrix2
     * @see Matrix4
     */
    @JsConstructor
    public Matrix3() {}

    /**
     * A 3x3 matrix, indexable as a column-major order array. Constructor parameters are in row-major order for code readability.
     * @param column0Row0 The value for column 0, row 0.
     * @param column1Row0 The value for column 1, row 0.
     * @param column2Row0 The value for column 2, row 0.
     * @param column0Row1 The value for column 0, row 1.
     * @param column1Row1 The value for column 1, row 1.
     * @param column2Row1 The value for column 2, row 1.
     * @param column0Row2 The value for column 0, row 2.
     * @param column1Row2 The value for column 1, row 2.
     * @param column2Row2 The value for column 2, row 2.
     * @see #fromColumnMajorArray(double[])
     * @see #fromColumnMajorArray(double[], Matrix3)
     * @see #fromRowMajorArray(double[])
     * @see #fromRowMajorArray(double[], Matrix3)
     * @see #fromScale(Cartesian3)
     * @see #fromScale(Cartesian3, Matrix3)
     * @see Matrix2
     * @see Matrix4
     */
    @JsConstructor
    public Matrix3(double column0Row0, double column1Row0, double column2Row0,
                   double column0Row1, double column1Row1, double column2Row1,
                   double column0Row2, double column1Row2, double column2Row2) {}

    /**
     * Duplicates the provided Matrix3 instance.
     * @return The modified result parameter or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public native Matrix3 clone();

    /**
     * Duplicates the provided Matrix3 instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public native Matrix3 clone(Matrix3 result);

    /**
     * Compares this matrix to the provided matrix componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side matrix.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(Matrix3 right);

    /**
     * Compares this matrix to the provided matrix componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param right The right hand side matrix.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if they are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(Matrix3 right, double epsilon);

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
    public static native Matrix3 abs(Matrix3 matrix, Matrix3 result);

    /**
     * Computes the sum of two matrices.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix3 add(Matrix3 left, Matrix3 right, Matrix3 result);

    /**
     * Duplicates a Matrix3 instance.
     * @param matrix The matrix to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix3 instance if one was not provided. (Returns undefined if matrix is undefined)
     */
    @JsMethod
    public static native Matrix3 clone(Matrix3 matrix, Matrix3 result);

    /**
     * Computes the eigenvectors and eigenvalues of a symmetric matrix.
     *
     * Returns a diagonal matrix and unitary matrix such that: matrix = unitary matrix * diagonal matrix * transpose(unitary matrix)
     *
     * The values along the diagonal of the diagonal matrix are the eigenvalues. The columns of the unitary matrix are
     * the corresponding eigenvectors.
     * @param matrix The matrix to decompose into diagonal and unitary matrix. Expected to be symmetric.
     * @return An object with unitary and diagonal properties which are the unitary and diagonal matrices, respectively.
     */
    @JsMethod
    public static native Object computeEigenDecomposition(Matrix3 matrix);

    /**
     * Computes the eigenvectors and eigenvalues of a symmetric matrix.
     *
     * Returns a diagonal matrix and unitary matrix such that: matrix = unitary matrix * diagonal matrix * transpose(unitary matrix)
     *
     * The values along the diagonal of the diagonal matrix are the eigenvalues. The columns of the unitary matrix are
     * the corresponding eigenvectors.
     * @param matrix The matrix to decompose into diagonal and unitary matrix. Expected to be symmetric.
     * @param result An object with unitary and diagonal properties which are matrices onto which to store the result.
     * @return An object with unitary and diagonal properties which are the unitary and diagonal matrices, respectively.
     */
    @JsMethod
    public static native Object computeEigenDecomposition(Matrix3 matrix, Object result);

    /**
     * Computes the determinant of the provided matrix.
     * @param matrix The matrix to use.
     * @return The value of the determinant of the matrix.
     */
    @JsMethod
    public static native double determinant(Matrix3 matrix);

    /**
     * Compares the provided matrices componentwise and returns true if they are equal, false otherwise.
     * @param left The first matrix.
     * @param right The second matrix.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(Matrix3 left, Matrix3 right);

    /**
     * Compares the provided matrices componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public static native boolean equalsEpsilon(Matrix3 left, Matrix3 right, double epsilon);

    /**
     * Creates a Matrix3 from 4 consecutive elements in an array.
     * <pre>
     *     {@code
     *     // Create the Matrix3:
     *     // [1.0, 2.0, 3.0]
     *     // [1.0, 2.0, 3.0]
     *     // [1.0, 2.0, 3.0]
     *     double[] v = {1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0};
     *     Matrix3 m = Matrix3.fromArray(v);
     *
     *     // Create same Matrix3 with using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0};
     *     Matrix3 m2 = Matrix3.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose 4 consecutive elements correspond to the positions of the matrix. Assumes column-major order.
     * @return parameter or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromArray(double[] array);

    /**
     * Creates a Matrix3 from 4 consecutive elements in an array.
     * <pre>
     *     {@code
     *     // Create the Matrix3:
     *     // [1.0, 2.0, 3.0]
     *     // [1.0, 2.0, 3.0]
     *     // [1.0, 2.0, 3.0]
     *     double[] v = {1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0};
     *     Matrix3 m = Matrix3.fromArray(v);
     *
     *     // Create same Matrix3 with using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0};
     *     Matrix3 m2 = Matrix3.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose 4 consecutive elements correspond to the positions of the matrix. Assumes column-major order.
     * @param startingIndex The offset into the array of the first element, which corresponds to first column first row position in the matrix.
     *                      Default 0
     * @return parameter or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromArray(double[] array, int startingIndex);

    /**
     * Creates a Matrix3 from 4 consecutive elements in an array.
     * <pre>
     *     {@code
     *     // Create the Matrix3:
     *     // [1.0, 2.0, 3.0]
     *     // [1.0, 2.0, 3.0]
     *     // [1.0, 2.0, 3.0]
     *     double[] v = {1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0};
     *     Matrix3 m = Matrix3.fromArray(v);
     *
     *     // Create same Matrix3 with using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 3.0, 3.0, 3.0};
     *     Matrix3 m2 = Matrix3.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose 4 consecutive elements correspond to the positions of the matrix. Assumes column-major order.
     * @param startingIndex The offset into the array of the first element, which corresponds to first column first row position in the matrix.
     *                      Default 0
     * @param result The object onto which to store the result.
     * @return parameter or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromArray(double[] array, int startingIndex, Matrix3 result);

    /**
     * Creates a Matrix3 instance from a column-major order array.
     * @param values The column-major order array.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromColumnMajorArray(double[] values);

    /**
     * Creates a Matrix3 instance from a column-major order array.
     * @param values The column-major order array.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromColumnMajorArray(double[] values, Matrix3 result);

    /**
     * Computes a Matrix3 instance representing the cross product equivalent matrix of a Cartesian3 vector.
     * <pre>
     *     Example:
     *     {@code
     *     // Creates
     *     //   [0.0, -9.0,  8.0]
     *     //   [9.0,  0.0, -7.0]
     *     //   [-8.0, 7.0,  0.0]
     *     Matrix3 m = Matrix3.fromCrossProduct(new Cartesian3(7.0, 8.0, 9.0));
     *     }
     * </pre>
     * @param the vector on the left hand side of the cross product operation.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromCrossProduct(Cartesian3 the);

    /**
     * Computes a Matrix3 instance representing the cross product equivalent matrix of a Cartesian3 vector.
     * <pre>
     *     Example:
     *     {@code
     *     // Creates
     *     //   [0.0, -9.0,  8.0]
     *     //   [9.0,  0.0, -7.0]
     *     //   [-8.0, 7.0,  0.0]
     *     Matrix3 m = Matrix3.fromCrossProduct(new Cartesian3(7.0, 8.0, 9.0));
     *     }
     * </pre>
     * @param the vector on the left hand side of the cross product operation.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromCrossProduct(Cartesian3 the, Matrix3 result);

    /**
     * Computes a 3x3 rotation matrix from the provided quaternion.
     * @param quaternion the quaternion to use.
     * @return The 3x3 rotation matrix from this quaternion.
     */
    @JsMethod
    public static native Matrix3 fromQuaternion(Quaternion quaternion);

    /**
     * Computes a 3x3 rotation matrix from the provided quaternion.
     * @param quaternion the quaternion to use.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The 3x3 rotation matrix from this quaternion.
     */
    @JsMethod
    public static native Matrix3 fromQuaternion(Quaternion quaternion, Matrix3 result);

    /**
     * Creates a rotation matrix around the x-axis.
     * <pre>
     *     {@code
     *         // Rotate a point 45 degrees counterclockwise around the x-axis.
     *         Cartesian3 p = new Cartesian3(5, 6, 7);
     *         Matrix3 m = Matrix3.fromRotationX(Math.toRadians(45.0));
     *         Matrix3 rotated = Matrix3.multiplyByVector(m, p, new Cartesian3());
     *     }
     * </pre>
     * @param angle The angle, in radians, of the rotation. Positive angles are counterclockwise.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromRotationX(double angle);

    /**
     * Creates a rotation matrix around the x-axis.
     * <pre>
     *     {@code
     *         // Rotate a point 45 degrees counterclockwise around the x-axis.
     *         Cartesian3 p = new Cartesian3(5, 6, 7);
     *         Matrix3 m = Matrix3.fromRotationX(Math.toRadians(45.0));
     *         Matrix3 rotated = Matrix3.multiplyByVector(m, p, new Cartesian3());
     *     }
     * </pre>
     * @param angle The angle, in radians, of the rotation. Positive angles are counterclockwise.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromRotationX(double angle, Matrix3 result);

    /**
     * Creates a rotation matrix around the y-axis.
     * <pre>
     *     {@code
     *         // Rotate a point 45 degrees counterclockwise around the y-axis.
     *         Cartesian3 p = new Cartesian3(5, 6, 7);
     *         Matrix3 m = Matrix3.fromRotationY(Math.toRadians(45.0));
     *         Matrix3 rotated = Matrix3.multiplyByVector(m, p, new Cartesian3());
     *     }
     * </pre>
     * @param angle The angle, in radians, of the rotation. Positive angles are counterclockwise.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromRotationY(double angle);

    /**
     * Creates a rotation matrix around the y-axis.
     * <pre>
     *     {@code
     *         // Rotate a point 45 degrees counterclockwise around the y-axis.
     *         Cartesian3 p = new Cartesian3(5, 6, 7);
     *         Matrix3 m = Matrix3.fromRotationY(Math.toRadians(45.0));
     *         Matrix3 rotated = Matrix3.multiplyByVector(m, p, new Cartesian3());
     *     }
     * </pre>
     * @param angle The angle, in radians, of the rotation. Positive angles are counterclockwise.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromRotationY(double angle, Matrix3 result);

    /**
     * Creates a rotation matrix around the z-axis.
     * <pre>
     *     {@code
     *         // Rotate a point 45 degrees counterclockwise around the z-axis.
     *         Cartesian3 p = new Cartesian3(5, 6, 7);
     *         Matrix3 m = Matrix3.fromRotationZ(Math.toRadians(45.0));
     *         Matrix3 rotated = Matrix3.multiplyByVector(m, p, new Cartesian3());
     *     }
     * </pre>
     * @param angle The angle, in radians, of the rotation. Positive angles are counterclockwise.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromRotationZ(double angle, Matrix3 result);

    /**
     * Creates a Matrix3 instance from a row-major order array. The resulting matrix will be in column-major order.
     * @param values The row-major order array.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromRowMajorArray(double[] values);

    /**
     * Creates a Matrix3 instance from a row-major order array. The resulting matrix will be in column-major order.
     * @param values The row-major order array.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromRowMajorArray(double[] values, Matrix3 result);

    /**
     * Computes a Matrix3 instance representing a non-uniform scale.
     * <pre>
     *     {@code
     *     // Creates
     *     //   [7.0, 0.0]
     *     //   [0.0, 8.0]
     *     Matrix3 m = Matrix3.fromScale(new Cartesian3(7.0, 8.0));
     *     }
     * </pre>
     * @param scale The x and y scale factors.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromScale(Cartesian3 scale);

    /**
     * Computes a Matrix3 instance representing a non-uniform scale.
     * <pre>
     *     {@code
     *     // Creates
     *     //   [7.0, 0.0]
     *     //   [0.0, 8.0]
     *     Matrix3 m = Matrix3.fromScale(new Cartesian3(7.0, 8.0));
     *     }
     * </pre>
     * @param scale The x and y scale factors.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromScale(Cartesian3 scale, Matrix3 result);

    /**
     * Computes a Matrix3 instance representing a uniform scale.
     * <pre>
     *     {@code
     *     // Creates
     *     //   [2.0, 0.0]
     *     //   [0.0, 2.0]
     *     Matrix m = Matrix3.fromUniformScale(2.0);
     *     }
     * </pre>
     * @param scale The uniform scale factor.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromUniformScale(double scale);

    /**
     * Computes a Matrix3 instance representing a uniform scale.
     * <pre>
     *     {@code
     *     // Creates
     *     //   [2.0, 0.0]
     *     //   [0.0, 2.0]
     *     Matrix m = Matrix3.fromUniformScale(2.0);
     *     }
     * </pre>
     * @param scale The uniform scale factor.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 fromUniformScale(double scale, Matrix3 result);

    /**
     * Retrieves a copy of the matrix column at the provided index as a Cartesian3 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the column to retrieve.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 getColumn(Matrix3 matrix, int index, Cartesian3 result);

    /**
     * Computes the array index of the element at the provided row and column.
     * <pre>
     *     {@code
     *         Matrix3 myMatrix = new Matrix3();
     *         int column1Row0Index = Matrix3.getElementIndex(1, 0);
     *         int column1Row0 = myMatrix[column1Row0Index]
     *         myMatrix[column1Row0Index] = 10.0;
     *     }
     * </pre>
     * @param row The zero-based index of the row.
     * @param column The zero-based index of the column.
     * @return The index of the element at the provided row and column.
     */
    @JsMethod
    public static native double getElementIndex(int row, int column);

    /**
     * Computes the maximum scale assuming the matrix is an affine transformation. The maximum scale is the maximum length of the column vectors.
     * @param matrix Matrix3	The matrix.
     * @return The maximum scale.
     */
    @JsMethod
    public static native double getMaximumScale(Matrix3 matrix);

    /**
     * Retrieves a copy of the matrix row at the provided index as a Cartesian3 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the row to retrieve.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 getRow(Matrix3 matrix, int index, Cartesian3 result);

    /**
     * Extracts the non-uniform scale assuming the matrix is an affine transformation.
     * @param matrix The matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 getScale(Matrix3 matrix, Cartesian3 result);

    /**
     * Computes the inverse of the provided matrix.
     * @param matrix The matrix to invert.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix3 inverse(Matrix3 matrix, Matrix3 result);

    /**
     * Computes the product of two matrices.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix3 multiply(Matrix3 left, Matrix3 right, Matrix3 result);

    /**
     * Computes the product of a matrix and a scalar.
     * @param matrix The matrix.
     * @param scalar The number to multiply by.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix3 multiplyByScalar(Matrix3 matrix, double scalar, Matrix3 result);

    /**
     * Computes the product of a matrix times a (non-uniform) scale, as if the scale were a scale matrix.
     * <pre>
     *     Example:
     *     {@code
     *     // Instead of Cesium.Matrix3.multiply(m, Cesium.Matrix3.fromScale(scale), m);
     *     Matrix3.multiplyByScale(m, scale, m);
     *     }
     * </pre>
     * @param matrix The matrix on the left-hand side.
     * @param scale The non-uniform scale on the right-hand side.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     * @see #fromScale(org.cesiumjs.cs.core.Cartesian3)
     * @see #fromScale(org.cesiumjs.cs.core.Cartesian3, org.cesiumjs.cs.core.Matrix3)
     */
    @JsMethod
    public static native Matrix3 multiplyByScale(Matrix3 matrix, Cartesian3 scale, Matrix3 result);

    /**
     * Computes the product of a matrix and a column vector.
     * @param matrix The matrix.
     * @param cartesian The column.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian3 multiplyByVector(Matrix3 matrix, Cartesian3 cartesian, Cartesian3 result);

    /**
     * Creates a negated copy of the provided matrix.
     * @param matrix The matrix to negate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix3 negate(Matrix3 matrix, Matrix3 result);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The value to pack.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Matrix3 value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The value to pack.
     * @param startingIndex The index into the array at which to start packing the elements. Default: 0
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Matrix3 value, double[] array, int startingIndex);

    /**
     * Computes a new matrix that replaces the specified column in the provided matrix with the provided Cartesian3 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the column to set.
     * @param cartesian The Cartesian whose values will be assigned to the specified column.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix3 setColumn(Matrix3 matrix, int index, Cartesian3 cartesian, Matrix3 result);

    /**
     * Computes a new matrix that replaces the specified row in the provided matrix with the provided Cartesian3 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the row to set.
     * @param cartesian The Cartesian whose values will be assigned to the specified row.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix3 setRow(Matrix3 matrix, int index, Cartesian3 cartesian, Matrix3 result);

    /**
     * Computes the difference of two matrices.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix3 subtract(Matrix3 left, Matrix3 right, Matrix3 result);

    /**
     * Creates an Array from the provided Matrix3 instance. The array will be in column-major order.
     * @param matrix The matrix to use.
     * @return The modified Array parameter or a new Array instance if one was not provided.
     */
    @JsMethod
    public static native double[] toArray(Matrix3 matrix);

    /**
     * Creates an Array from the provided Matrix3 instance. The array will be in column-major order.
     * @param matrix The matrix to use.
     * @param result The Array onto which to store the result.
     * @return The modified Array parameter or a new Array instance if one was not provided.
     */
    @JsMethod
    public static native double[] toArray(Matrix3 matrix, double[] result);

    /**
     * Computes the transpose of the provided matrix.
     * @param matrix The matrix to transpose.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix3 transpose(Matrix3 matrix, Matrix3 result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @return The modified result parameter or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new Matrix3 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix3 unpack(double[] array, int startingIndex, Matrix3 result);
}
