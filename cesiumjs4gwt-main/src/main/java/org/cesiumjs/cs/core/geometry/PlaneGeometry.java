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

package org.cesiumjs.cs.core.geometry;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Packable;
import org.cesiumjs.cs.core.VertexFormat;
import org.cesiumjs.cs.core.geometry.options.PlaneGeometryOptions;

/**
 * Describes geometry representing a plane centered at the origin, with a unit width and length.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PlaneGeometry")
public class PlaneGeometry extends Geometry implements Packable {
    /**
     * Describes geometry representing a plane centered at the origin, with a unit width and length.
     * @param options object {@link PlaneGeometryOptions}.
     */
    @JsConstructor
    public PlaneGeometry(PlaneGeometryOptions options) {}

    public static PlaneGeometry create(VertexFormat vertexFormat) {
        PlaneGeometryOptions options = new PlaneGeometryOptions();
        options.vertexFormat = vertexFormat;
        return new PlaneGeometry(options);
    }
}
