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

package org.cesiumjs.cs.scene;

import org.cesiumjs.cs.BaseTestCase;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.core.geometry.GroundPolylineGeometry;
import org.cesiumjs.cs.core.geometry.options.GroundPolylineGeometryOptions;
import org.cesiumjs.cs.core.options.GeometryInstanceOptions;
import org.cesiumjs.cs.scene.apperances.PolylineMaterialAppearance;
import org.cesiumjs.cs.scene.apperances.options.PolylineMaterialAppearanceOptions;
import org.cesiumjs.cs.scene.options.GroundPolylinePrimitiveOptions;

/**
 * @author Serge Silaev aka iSergio
 */
public class GroundPolylinePrimitiveTest extends BaseTestCase {
    public void test() {
        delayTestFinish(10_000);

        super.beginTest(() -> {
            Cartesian3[] positions = Cartesian3.fromDegreesArray(
                    new double[]{-112.1340164450331, 36.05494287836128, -112.08821010582645, 36.097804071380715});
            GroundPolylineGeometryOptions groundPolylineGeometryOptions = GroundPolylineGeometryOptions.create(positions);
            groundPolylineGeometryOptions.width = 4;

            GeometryInstanceOptions geometryInstanceOptions = new GeometryInstanceOptions();
            geometryInstanceOptions.geometry = new GroundPolylineGeometry(groundPolylineGeometryOptions);
            geometryInstanceOptions.id = "object returned when this instance is picked and to get/set per-instance attributes";

            PolylineMaterialAppearanceOptions appearanceOptions = new PolylineMaterialAppearanceOptions();
            appearanceOptions.material = Material.fromType("Color");

            GroundPolylinePrimitiveOptions primitiveOptions = new GroundPolylinePrimitiveOptions();
            primitiveOptions.geometryInstances = new GeometryInstance[]{new GeometryInstance(geometryInstanceOptions)};
            primitiveOptions.appearance = new PolylineMaterialAppearance(appearanceOptions);

            GroundPolylinePrimitive groundPolylinePrimitive = new GroundPolylinePrimitive(primitiveOptions);
            assertNotNull(groundPolylinePrimitive);

            finishTest();
        });
    }
}