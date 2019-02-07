/*
 * Copyright 2019 iserge.
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

import jsinterop.annotations.JsType;

/**
 * ArcType defines the path that should be taken connecting vertices.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "ArcType")
public class ArcType {
    /**
     * Follow geodesic path.
     */
    public static native Number GEODESIC();
    /**
     * Straight line that does not conform to the surface of the ellipsoid.
     */
    public static native Number NONE();
    /**
     * Follow rhumb or loxodrome path.
     */
    public static native Number RHUMB();
}
