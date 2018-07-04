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
import org.cesiumjs.cs.core.Rectangle;
import org.cesiumjs.cs.core.geometry.Geometry;
import org.cesiumjs.cs.core.geometry.RectangleGeometry;
import org.cesiumjs.cs.core.geometry.options.RectangleGeometryOptions;
import org.cesiumjs.cs.scene.apperances.EllipsoidSurfaceAppearance;
import org.cesiumjs.cs.scene.interaction.options.AbstractPrimitiveOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class RectanglePrimitive extends AbstractPrimitive {
    public RectanglePrimitive(AbstractPrimitiveOptions options) {
        super(options);
        super.options = options;

        ellipsoid = Ellipsoid.WGS84();
        show = true;
        debugShowBoundingVolume = false;

        appearance = EllipsoidSurfaceAppearance.create(false);
        granularity = Math.PI / 180.0;

        getGeometry = new GetGeometry() {
            @Override
            public Geometry function() {
                Rectangle rectangle = getRectangle();
                if (rectangle == null) {
                    return null;
                }
                RectangleGeometryOptions options = new RectangleGeometryOptions();
                options.rectangle = rectangle;
                options.vertexFormat = EllipsoidSurfaceAppearance.VERTEX_FORMAT();
                options.ellipsoid = ellipsoid;
                return new RectangleGeometry(options);
            }
        };

        super.initialize();
    }

    public Cartesian3[] getPositions() {
        return Rectangle.subsample(getRectangle(), ellipsoid);
    }

    public final void setRectangle(Rectangle rectangle) {
        setAttribute("rectangle", rectangle);
        createPrimitive = true;
    }

    public final Rectangle getRectangle() {
        return (Rectangle) getAttribute("rectangle");
    }
}
