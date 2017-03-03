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

package org.cesiumjs.cs.core.enums;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class PrimitiveType {
    /**
     * Line loop primitive where each vertex (or index) after the first connects a line to the previous vertex,
     * and the last vertex implicitly connects to the first.
     */
    @JsProperty(name = "LINE_LOOP")
    public static native Number LINE_LOOP();
    /**
     * Line strip primitive where each vertex (or index) after the first connects a line to the previous vertex.
     */
    @JsProperty(name = "LINE_STRIP")
    public static native Number LINE_STRIP();
    /**
     * Lines primitive where each two vertices (or indices) is a line segment. Line segments are not necessarily connected.
     */
    @JsProperty(name = "LINES")
    public static native Number LINES();
    /**
     * Points primitive where each vertex (or index) is a separate point.
     */
    @JsProperty(name = "POINTS")
    public static native Number POINTS();
    /**
     * Triangle fan primitive where each vertex (or index) after the first two connect to the previous vertex and the
     * first vertex forming a triangle. For example, this can be used to model a cone or circle.
     */
    @JsProperty(name = "TRIANGLE_FAN")
    public static native Number TRIANGLE_FAN();
    /**
     * Triangle strip primitive where each vertex (or index) after the first two connect to the previous two
     * vertices forming a triangle. For example, this can be used to model a wall.
     */
    @JsProperty(name = "TRIANGLE_STRIP")
    public static native Number TRIANGLE_STRIP();
    /**
     * Triangles primitive where each three vertices (or indices) is a triangle. Triangles do not necessarily share edges.
     */
    @JsProperty(name = "TRIANGLES")
    public static native Number TRIANGLES();

    /**
     * The type of a geometric primitive, i.e., points, lines, and triangles.
     */
    @JsConstructor
    private PrimitiveType() {}
}
