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
@JsType(isNative = true, namespace = "Cesium", name = "Matrix2")
public class Matrix2 {
    /**
     * Gets the number of items in the collection.
     */
    @JsProperty
    public int length;
    /**
     * The index into Matrix2 for column 0, row 0.
     * <pre>
     *     Example:
     *     {@code
     *     Matrix2 matrix = new Matrix2();
     *     matrix[Matrix2.COLUMN0ROW0] = 5.0; // set column 0, row 0 to 5.0
     *     }
     * </pre>
     */
    @JsProperty(name = "COLUMN0ROW0")
    public static native int COLUMN0ROW0();
    /**
     * The index into Matrix2 for column 0, row 0.
     * <pre>
     *     Example:
     *     {@code
     *     Matrix2 matrix = new Matrix2();
     *     matrix[Matrix2.COLUMN0ROW1] = 5.0; // set column 0, row 1 to 5.0
     *     }
     * </pre>
     */
    @JsProperty(name = "COLUMN0ROW1")
    public static native int COLUMN0ROW1();

    /**
     * The index into Matrix2 for column 0, row 0.
     * <pre>
     *     Example:
     *     {@code
     *     Matrix2 matrix = new Matrix2();
     *     matrix[Matrix2.COLUMN1ROW0] = 5.0; // set column 1, row 0 to 5.0
     *     }
     * </pre>
     */
    @JsProperty(name = "COLUMN0ROW0")
    public static native int COLUMN1ROW0();
    /**
     * The index into Matrix2 for column 0, row 0.
     * <pre>
     *     Example:
     *     {@code
     *     Matrix2 matrix = new Matrix2();
     *     matrix[Matrix2.COLUMN1ROW1] = 5.0; // set column 1, row 1 to 5.0
     *     }
     * </pre>
     */
    @JsProperty(name = "COLUMN0ROW0")
    public static native int COLUMN1ROW1();
    /**
     * An immutable Matrix2 instance initialized to the identity matrix.
     */
    @JsProperty(name = "IDENTITY")
    public static native Matrix2 IDENTITY();
    /**
     * The number of elements used to pack the object into an array.
     */
    @JsProperty
    public static int packedLength;
    /**
     * An immutable Matrix2 instance initialized to the zero matrix.
     */
    @JsProperty(name = "ZERO")
    public static native Matrix2 ZERO();

    /**
     * A 2x2 matrix, indexable as a column-major order array. Constructor parameters are in row-major order for code readability.
     * @see #fromColumnMajorArray(double[])
     * @see #fromColumnMajorArray(double[], Matrix2)
     * @see #fromRowMajorArray(double[])
     * @see #fromRowMajorArray(double[], Matrix2)
     * @see #fromScale(Cartesian2)
     * @see #fromScale(Cartesian2, Matrix2)
     * @see Matrix3
     * @see Matrix4
     */
    @JsConstructor
    public Matrix2() {}

    /**
     * A 2x2 matrix, indexable as a column-major order array. Constructor parameters are in row-major order for code readability.
     * @param column0Row0 The value for column 0, row 0.
     * @param column1Row0 The value for column 1, row 0.
     * @param column0Row1 The value for column 0, row 1.
     * @param column1Row1 The value for column 1, row 1.
     * @see #fromColumnMajorArray(double[])
     * @see #fromColumnMajorArray(double[], Matrix2)
     * @see #fromRowMajorArray(double[])
     * @see #fromRowMajorArray(double[], Matrix2)
     * @see #fromScale(Cartesian2)
     * @see #fromScale(Cartesian2, Matrix2)
     * @see Matrix3
     * @see Matrix4
     */
    @JsConstructor
    public Matrix2(double column0Row0, double column1Row0, double column0Row1, double column1Row1) {}

    /**
     * Duplicates the provided Matrix2 instance.
     * @return The modified result parameter or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public native Matrix2 clone();

    /**
     * Duplicates the provided Matrix2 instance.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public native Matrix2 clone(Matrix2 result);

    /**
     * Compares this matrix to the provided matrix componentwise and returns true if they are equal, false otherwise.
     * @param right The right hand side matrix.
     * @return true if they are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(Matrix2 right);

    /**
     * Compares this matrix to the provided matrix componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param right The right hand side matrix.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if they are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public native boolean equalsEpsilon(Matrix2 right, double epsilon);

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
    public static native Matrix2 abs(Matrix2 matrix, Matrix2 result);

    /**
     * Computes the sum of two matrices.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix2 add(Matrix2 left, Matrix2 right, Matrix2 result);

    /**
     * Duplicates a Matrix2 instance.
     * @param matrix The matrix to duplicate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter or a new Matrix2 instance if one was not provided. (Returns undefined if matrix is undefined)
     */
    @JsMethod
    public static native Matrix2 clone(Matrix2 matrix, Matrix2 result);

    /**
     * Compares the provided matrices componentwise and returns true if they are equal, false otherwise.
     * @param left The first matrix.
     * @param right The second matrix.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(Matrix2 left, Matrix2 right);

    /**
     * Compares the provided matrices componentwise and returns true if they are within the provided epsilon, false otherwise.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param epsilon The epsilon to use for equality testing.
     * @return true if left and right are within the provided epsilon, false otherwise.
     */
    @JsMethod
    public static native boolean equalsEpsilon(Matrix2 left, Matrix2 right, double epsilon);

    /**
     * Creates a Matrix2 from 4 consecutive elements in an array.
     * <pre>
     *     {@code
     *     // Create the Matrix2:
     *     // [1.0, 2.0]
     *     // [1.0, 2.0]
     *     double[] v = {1.0, 1.0, 2.0, 2.0};
     *     Matrix2 m = Matrix2.fromArray(v);
     *
     *     // Create same Matrix2 with using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 1.0, 2.0, 2.0};
     *     Matrix2 m2 = Matrix2.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose 4 consecutive elements correspond to the positions of the matrix. Assumes column-major order.
     * @return parameter or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromArray(double[] array);

    /**
     * Creates a Matrix2 from 4 consecutive elements in an array.
     * <pre>
     *     {@code
     *     // Create the Matrix2:
     *     // [1.0, 2.0]
     *     // [1.0, 2.0]
     *     double[] v = {1.0, 1.0, 2.0, 2.0};
     *     Matrix2 m = Matrix2.fromArray(v);
     *
     *     // Create same Matrix2 with using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 1.0, 2.0, 2.0};
     *     Matrix2 m2 = Matrix2.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose 4 consecutive elements correspond to the positions of the matrix. Assumes column-major order.
     * @param startingIndex The offset into the array of the first element, which corresponds to first column first row position in the matrix.
     *                      Default 0
     * @return parameter or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromArray(double[] array, int startingIndex);

    /**
     * Creates a Matrix2 from 4 consecutive elements in an array.
     * <pre>
     *     {@code
     *     // Create the Matrix2:
     *     // [1.0, 2.0]
     *     // [1.0, 2.0]
     *     double[] v = {1.0, 1.0, 2.0, 2.0};
     *     Matrix2 m = Matrix2.fromArray(v);
     *
     *     // Create same Matrix2 with using an offset into an array
     *     double[] v2 = {0.0, 0.0, 1.0, 1.0, 2.0, 2.0};
     *     Matrix2 m2 = Matrix2.fromArray(v2, 2);
     *     }
     * </pre>
     * @param array The array whose 4 consecutive elements correspond to the positions of the matrix. Assumes column-major order.
     * @param startingIndex The offset into the array of the first element, which corresponds to first column first row position in the matrix.
     *                      Default 0
     * @param result The object onto which to store the result.
     * @return parameter or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromArray(double[] array, int startingIndex, Matrix2 result);

    /**
     * Creates a Matrix2 instance from a column-major order array.
     * @param values The column-major order array.
     * @return The modified result parameter, or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromColumnMajorArray(double[] values);

    /**
     * Creates a Matrix2 instance from a column-major order array.
     * @param values The column-major order array.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromColumnMajorArray(double[] values, Matrix2 result);

    /**
     * Creates a rotation matrix.
     * <pre>
     *     Example:
     *     {@code
     *         // Rotate a point 45 degrees counterclockwise.
     *         Cartesian2 p = new Cartesian2(5, 6);
     *         Matrix2 m = Matrix2.fromRotation(Math.toRadians(45.0));
     *         Matrix2 rotated = Matrix2.multiplyByVector(m, p, new Cartesian2());
     *     }
     * </pre>
     * @param angle The angle, in radians, of the rotation. Positive angles are counterclockwise.
     * @return The modified result parameter, or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromRotation(double angle);

    /**
     * Creates a rotation matrix.
     * <pre>
     *     Example:
     *     {@code
     *         // Rotate a point 45 degrees counterclockwise.
     *         Cartesian2 p = new Cartesian2(5, 6);
     *         Matrix2 m = Matrix2.fromRotation(Math.toRadians(45.0));
     *         Matrix2 rotated = Matrix2.multiplyByVector(m, p, new Cartesian2());
     *     }
     * </pre>
     * @param angle The angle, in radians, of the rotation. Positive angles are counterclockwise.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromRotation(double angle, Matrix2 result);

    /**
     * Creates a Matrix2 instance from a row-major order array. The resulting matrix will be in column-major order.
     * @param values The row-major order array.
     * @return The modified result parameter, or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromRowMajorArray(double[] values);

    /**
     * Creates a Matrix2 instance from a row-major order array. The resulting matrix will be in column-major order.
     * @param values The row-major order array.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromRowMajorArray(double[] values, Matrix2 result);

    /**
     * Computes a Matrix2 instance representing a non-uniform scale.
     * <pre>
     *     {@code
     *     // Creates
     *     //   [7.0, 0.0]
     *     //   [0.0, 8.0]
     *     Matrix2 m = Matrix2.fromScale(new Cartesian2(7.0, 8.0));
     *     }
     * </pre>
     * @param scale The x and y scale factors.
     * @return The modified result parameter, or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromScale(Cartesian2 scale);

    /**
     * Computes a Matrix2 instance representing a non-uniform scale.
     * <pre>
     *     {@code
     *     // Creates
     *     //   [7.0, 0.0]
     *     //   [0.0, 8.0]
     *     Matrix2 m = Matrix2.fromScale(new Cartesian2(7.0, 8.0));
     *     }
     * </pre>
     * @param scale The x and y scale factors.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromScale(Cartesian2 scale, Matrix2 result);

    /**
     * Computes a Matrix2 instance representing a uniform scale.
     * <pre>
     *     {@code
     *     // Creates
     *     //   [2.0, 0.0]
     *     //   [0.0, 2.0]
     *     Matrix m = Matrix2.fromUniformScale(2.0);
     *     }
     * </pre>
     * @param scale The uniform scale factor.
     * @return The modified result parameter, or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromUniformScale(double scale);

    /**
     * Computes a Matrix2 instance representing a uniform scale.
     * <pre>
     *     {@code
     *     // Creates
     *     //   [2.0, 0.0]
     *     //   [0.0, 2.0]
     *     Matrix m = Matrix2.fromUniformScale(2.0);
     *     }
     * </pre>
     * @param scale The uniform scale factor.
     * @param result The object in which the result will be stored, if undefined a new instance will be created.
     * @return The modified result parameter, or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 fromUniformScale(double scale, Matrix2 result);

    /**
     * Retrieves a copy of the matrix column at the provided index as a Cartesian2 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the column to retrieve.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 getColumn(Matrix2 matrix, int index, Cartesian2 result);

    /**
     * Computes the array index of the element at the provided row and column.
     * <pre>
     *     {@code
     *         Matrix2 myMatrix = new Matrix2();
     *         int column1Row0Index = Matrix2.getElementIndex(1, 0);
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
     * @param matrix Matrix2	The matrix.
     * @return The maximum scale.
     */
    @JsMethod
    public static native double getMaximumScale(Matrix2 matrix);

    /**
     * Retrieves a copy of the matrix row at the provided index as a Cartesian2 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the row to retrieve.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 getRow(Matrix2 matrix, int index, Cartesian2 result);

    /**
     * Extracts the non-uniform scale assuming the matrix is an affine transformation.
     * @param matrix The matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 getScale(Matrix2 matrix, Cartesian2 result);

    /**
     * Computes the product of two matrices.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix2 multiply(Matrix2 left, Matrix2 right, Matrix2 result);

    /**
     * Computes the product of a matrix and a scalar.
     * @param matrix The matrix.
     * @param scalar The number to multiply by.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix2 multiplyByScalar(Matrix2 matrix, double scalar, Matrix2 result);

    /**
     * Computes the product of a matrix times a (non-uniform) scale, as if the scale were a scale matrix.
     * <pre>
     *     Example:
     *     {@code
     *     // Instead of Cesium.Matrix2.multiply(m, Cesium.Matrix2.fromScale(scale), m);
     *     Matrix2.multiplyByScale(m, scale, m);
     *     }
     * </pre>
     * @param matrix The matrix on the left-hand side.
     * @param scale The non-uniform scale on the right-hand side.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     * @see #fromScale(org.cesiumjs.cs.core.Cartesian2)
     * @see #fromScale(org.cesiumjs.cs.core.Cartesian2, org.cesiumjs.cs.core.Matrix2)
     */
    @JsMethod
    public static native Matrix2 multiplyByScale(Matrix2 matrix, Cartesian2 scale, Matrix2 result);

    /**
     * Computes the product of a matrix and a column vector.
     * @param matrix The matrix.
     * @param cartesian The column.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Cartesian2 multiplyByVector(Matrix2 matrix, Cartesian2 cartesian, Cartesian2 result);

    /**
     * Creates a negated copy of the provided matrix.
     * @param matrix The matrix to negate.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix2 negate(Matrix2 matrix, Matrix2 result);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The value to pack.
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Matrix2 value, double[] array);

    /**
     * Stores the provided instance into the provided array.
     * @param value The value to pack.
     * @param array The value to pack.
     * @param startingIndex The index into the array at which to start packing the elements. Default: 0
     * @return The array that was packed into
     */
    @JsMethod
    public static native double[] pack(Matrix2 value, double[] array, int startingIndex);

    /**
     * Computes a new matrix that replaces the specified column in the provided matrix with the provided Cartesian2 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the column to set.
     * @param cartesian The Cartesian whose values will be assigned to the specified column.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix2 setColumn(Matrix2 matrix, int index, Cartesian2 cartesian, Matrix2 result);

    /**
     * Computes a new matrix that replaces the specified row in the provided matrix with the provided Cartesian2 instance.
     * @param matrix The matrix to use.
     * @param index The zero-based index of the row to set.
     * @param cartesian The Cartesian whose values will be assigned to the specified row.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix2 setRow(Matrix2 matrix, int index, Cartesian2 cartesian, Matrix2 result);

    /**
     * Computes the difference of two matrices.
     * @param left The first matrix.
     * @param right The second matrix.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix2 subtract(Matrix2 left, Matrix2 right, Matrix2 result);

    /**
     * Creates an Array from the provided Matrix2 instance. The array will be in column-major order.
     * @param matrix The matrix to use.
     * @return The modified Array parameter or a new Array instance if one was not provided.
     */
    @JsMethod
    public static native double[] toArray(Matrix2 matrix);

    /**
     * Creates an Array from the provided Matrix2 instance. The array will be in column-major order.
     * @param matrix The matrix to use.
     * @param result The Array onto which to store the result.
     * @return The modified Array parameter or a new Array instance if one was not provided.
     */
    @JsMethod
    public static native double[] toArray(Matrix2 matrix, double[] result);

    /**
     * Computes the transpose of the provided matrix.
     * @param matrix The matrix to transpose.
     * @param result The object onto which to store the result.
     * @return The modified result parameter.
     */
    @JsMethod
    public static native Matrix2 transpose(Matrix2 matrix, Matrix2 result);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @return The modified result parameter or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 unpack(double[] array);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @return The modified result parameter or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 unpack(double[] array, int startingIndex);

    /**
     * Retrieves an instance from a packed array.
     * @param array The packed array.
     * @param startingIndex The starting index of the element to be unpacked.
     * @param result The object into which to store the result.
     * @return The modified result parameter or a new Matrix2 instance if one was not provided.
     */
    @JsMethod
    public static native Matrix2 unpack(double[] array, int startingIndex, Matrix2 result);
}
