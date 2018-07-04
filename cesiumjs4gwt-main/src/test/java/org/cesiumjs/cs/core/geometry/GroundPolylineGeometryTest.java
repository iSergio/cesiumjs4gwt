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
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.core.Cartesian3;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class GroundPolylineGeometryTest extends BaseTestCase {
    public void testCreate() {
        delayTestFinish(10_000);

        super.beginTest(new Test() {
            @Override
            public void execute() {
                Cartesian3[] positions = Cartesian3.fromDegreesArray(new double[]{-112.1340164450331, 36.05494287836128,
                        -112.08821010582645, 36.097804071380715,
                        -112.13296079730024, 36.168769146801104});
                GroundPolylineGeometry geometry = GroundPolylineGeometry.create(positions);
                assertNotNull(geometry);
                assertEquals(1.0, geometry.width);
                assertEquals(9999.0, geometry.granularity);
                assertFalse(geometry.loop);
                finishTest();
            }
        });
    }
}