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

package org.cesiumjs.cs.js;

import jsinterop.annotations.*;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Array")
public class JsArray<T extends Object> {
    /**
     * Reflects the number of elements in an array.
     */
    @JsProperty(name = "length")
    public native int length();

    @JsConstructor
    public JsArray() {}

    /**
     * Fills all the elements of an array from a start index to an end index with a static value.
     * @param value Value to fill an array.
     */
    @JsMethod
    public native JsArray<T> fill(T value);

    /**
     * Fills all the elements of an array from a start index to an end index with a static value.
     * @param value Value to fill an array.
     * @param start Start index, defaults to 0.
     */
    @JsMethod
    public native JsArray<T> fill(T value, Integer start);

    /**
     * Fills all the elements of an array from a start index to an end index with a static value.
     * @param value Value to fill an array.
     * @param start Start index, defaults to 0.
     * @param end End index, defaults to this.length.
     */
    @JsMethod
    public native JsArray<T> fill(T value, Integer start, Integer end);

    /**
     * Removes the last element from an array and returns that element. This method changes the length of the array.
     * @return The removed element from the array; null if the array is empty.
     */
    @JsMethod
    public native T pop();

    /**
     * Adds one or more elements to the end of an array and returns the new length of the array.
     * @param elementN The elements to add to the end of the array.
     * @return The new {@link #length} property of the object upon which the method was called.
     */
    @JsMethod
    public native Integer push(T ...elementN);

    /**
     * Sorts the elements of an array in place and returns the array. The sort is not necessarily stable.
     * The default sort order is according to string Unicode code points.
     * @return The sorted array.
     */
    @JsMethod
    public native JsArray<T> sort();

    /**
     * Sorts the elements of an array in place and returns the array. The sort is not necessarily stable.
     * The default sort order is according to string Unicode code points.
     * @param compareFunction Specifies a function that defines the sort order. If omitted, the array is sorted
     *                        according to each character's Unicode code point value, according to the string
     *                        conversion of each element.
     * @return The sorted array.
     */
    @JsMethod
    public native JsArray<T> sort(CompareFunction compareFunction);

    /**
     * Returns the first index at which a given element can be found in the array, or -1 if it is not present.
     * @param searchElement Element to locate in the array.
     * @return The first index of the element in the array; -1 if not found.
     */
    @JsMethod
    public native Integer indexOf(T searchElement);

    /**
     * Returns the first index at which a given element can be found in the array, or -1 if it is not present.
     * @param searchElement Element to locate in the array.
     * @param fromElement The index to start the search at. If the index is greater than or equal to the array's length,
     *                    -1 is returned, which means the array will not be searched. If the provided index value is a
     *                    negative number, it is taken as the offset from the end of the array. Note:
     *                    if the provided index is negative, the array is still searched from front to back.
     *                    If the calculated index is less than 0, then the whole array will be searched.
     *                    Default: 0 (entire array is searched).
     * @return The first index of the element in the array; -1 if not found.
     */
    @JsMethod
    public native Integer indexOf(T searchElement, Integer fromElement);

    /**
     * Joins all elements of an array into a string.
     * @param separator Specifies a string to separate each element of the array. The separator is converted to a string
     *                  if necessary. If omitted, the array elements are separated with a comma. If separator is an
     *                  empty string, all elements are joined without any characters in between them. Defaults to ",".
     * @return A string with all array elements joined.
     */
    @JsMethod
    public native String join(String separator);

    /**
     * last index at which a given element can be found in the array, or -1 if it is not present.
     * The array is searched backwards, starting at fromIndex.
     * @param searchElement Element to locate in the array.
     * @param fromIndex The index at which to start searching backwards. Defaults to the array's
     *                  length minus one (arr.length - 1), i.e. the whole array will be searched.
     *                  If the index is greater than or equal to the length of the array, the whole array
     *                  will be searched. If negative, it is taken as the offset from the end of the array.
     *                  Note that even when the index is negative, the array is still searched from back to front.
     *                  If the calculated index is less than 0, -1 is returned, i.e. the array will not be searched.
     * @return The last index of the element in the array; -1 if not found.
     */
    @JsMethod
    public native Integer lastIndexOf(T searchElement, Integer fromIndex);

    /**
     * String representing the specified array and its elements.
     * @return A string representing the elements of the array.
     */
    @JsMethod
    @Override
    public native String toString();

    @JsFunction
    public interface CompareFunction {
        void function(Object ...params);
    }
}
