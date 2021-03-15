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
import org.cesiumjs.cs.scene.Scene;
import org.cesiumjs.cs.scene.apperances.EllipsoidSurfaceAppearance;
import org.cesiumjs.cs.scene.interaction.options.AbstractPrimitiveOptions;

/**
 * @author Serge Silaev aka iSergio
 */
public class PointPrimitive extends AbstractPrimitive {
    public PointPrimitive(Scene scene, AbstractPrimitiveOptions options) {
        super(options);

        options.minPoints = 1;
        options.maxPoints = 1;

        ellipsoid = Ellipsoid.WGS84();
        show = true;
        debugShowBoundingVolume = false;

        appearance = EllipsoidSurfaceAppearance.create(false);
        granularity = Math.PI / 180.0;

        getGeometry = new GetGeometry() {
            @Override
            public Geometry function() {
                return null;
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
