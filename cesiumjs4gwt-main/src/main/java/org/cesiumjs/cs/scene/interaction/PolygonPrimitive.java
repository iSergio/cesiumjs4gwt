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

package org.cesiumjs.cs.scene.interaction;

import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.Ellipsoid;
import org.cesiumjs.cs.core.geometry.Geometry;
import org.cesiumjs.cs.core.geometry.PolygonGeometry;
import org.cesiumjs.cs.core.geometry.options.PolygonGeometryOptions;
import org.cesiumjs.cs.scene.apperances.EllipsoidSurfaceAppearance;
import org.cesiumjs.cs.scene.interaction.options.AbstractPrimitiveOptions;

/**
 * @author Serge Silaev aka iSergio
 */
public class PolygonPrimitive extends AbstractPrimitive {
    public PolygonPrimitive(AbstractPrimitiveOptions options) {
        super(options);
        super.options = options;

        ellipsoid = Ellipsoid.WGS84();
        show = true;
        debugShowBoundingVolume = false;

        appearance = EllipsoidSurfaceAppearance.create(false);
        // material = Material.fromType(Material.ColorType());
        // JsObject.setProperty(material.uniforms, "color", options.color);
        granularity = Math.PI / 180.0;

        getGeometry = new GetGeometry() {
            @Override
            public Geometry function() {
                if (getPositions() == null || getPositions().length < 3) {
                    return null;
                }
                PolygonGeometryOptions geometryOptions = new PolygonGeometryOptions();
                geometryOptions.positions = getPositions();
                geometryOptions.vertexFormat = EllipsoidSurfaceAppearance.VERTEX_FORMAT();
                geometryOptions.ellipsoid = ellipsoid;
                geometryOptions.granularity = granularity;
                return PolygonGeometry.fromPositions(geometryOptions);
            }
        };

        super.initialize();
    }

    public Cartesian3[] getPositions() {
        return (Cartesian3[]) getAttribute("positions");
    }

    public void setPositions(Cartesian3[] positions) {
        setAttribute("positions", positions);
    }
}
