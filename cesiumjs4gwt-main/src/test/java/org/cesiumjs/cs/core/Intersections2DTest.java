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

package org.cesiumjs.cs.core;

import org.cesiumjs.cs.BaseTestCase;

/**
 * @author Serge Silaev aka iSergio
 */
public class Intersections2DTest extends BaseTestCase {
  public void testClipTriangleAtAxisAlignedThreshold() {
    delayTestFinish(10_000);
    super.beginTest(new BaseTestCase.Test() {
      @Override
      public void execute() {
        double[] expected = Intersections2D.clipTriangleAtAxisAlignedThreshold(0.5, false, 0.2, 0.6, 0.4);
        double[] actual = new double[] { 2, 0, -1, 1, 0, 0.25, -1, 1, 2, 0.5 };
        assertEquals(expected[0], actual[0], 0.000001);
        assertEquals(expected[1], actual[1], 0.000001);
        assertEquals(expected[2], actual[2], 0.000001);
        assertEquals(expected[3], actual[3], 0.000001);
        assertEquals(expected[4], actual[4], 0.000001);
        assertEquals(expected[5], actual[5], 0.000001);
        assertEquals(expected[6], actual[6], 0.000001);
        assertEquals(expected[7], actual[7], 0.000001);
        assertEquals(expected[8], actual[8], 0.000001);
        assertEquals(expected[9], actual[9], 0.000001);
        finishTest();
      }
    });
  }

  public void testComputeBarycentricCoordinates() {
    delayTestFinish(10_000);
    super.beginTest(new BaseTestCase.Test() {
      @Override
      public void execute() {
        Cartesian3 expected = Intersections2D.computeBarycentricCoordinates(0.0, 0.0, 0.0, 1.0, -1, -0.5, 1, -0.5);
        Cartesian3 actual = new Cartesian3(1.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0);
        assertEquals(expected.x, actual.x, 0.000001);
        assertEquals(expected.y, actual.y, 0.000001);
        assertEquals(expected.z, actual.z, 0.000001);
        finishTest();
      }
    });
  }

  public void testComputeLineSegmentLineSegmentIntersection() {
    delayTestFinish(10_000);
    super.beginTest(new BaseTestCase.Test() {
      @Override
      public void execute() {
        Cartesian2 expected = Intersections2D.computeLineSegmentLineSegmentIntersection(0.0, 0.0, 0.0, 2.0, -1, 1, 1,
            1);
        Cartesian2 actual = new Cartesian2(0.0, 1.0);
        assertEquals(expected, actual);
        finishTest();
      }
    });
  }
}
