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

import org.cesiumjs.cs.BaseTestCase;
import org.cesiumjs.cs.core.Cartesian3;
import org.cesiumjs.cs.core.geometry.options.CoplanarPolygonGeometryFromPositionsOptions;

/**
 * @author Serge Silaev aka iSergio
 */
public class CoplanarPolygonGeometryTest extends BaseTestCase {
  public void testFromPositions() {
    delayTestFinish(10_000);

    super.beginTest(new Test() {
      @Override
      public void execute() {
        Cartesian3[] positions = Cartesian3.fromDegreesArrayHeights(
            new double[] { -90.0, 30.0, 0.0, -90.0, 30.0, 1000.0, -80.0, 30.0, 1000.0, -80.0, 30.0, 0.0 });
        CoplanarPolygonGeometryFromPositionsOptions options = CoplanarPolygonGeometryFromPositionsOptions
            .create(positions);
        CoplanarPolygonGeometry geometry = CoplanarPolygonGeometry.fromPositions(options);

        finishTest();
      }
    });
  }
}