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
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class PlaneTest extends BaseTestCase {

    public void testProjectPointOntoPlane() {
        super.beginTest(new Test() {
            @Override
            public void execute() {
                Cartesian3 point = new Cartesian3(1, 2, 3);
                Cartesian3 result = Plane.projectPointOntoPlane(Plane.ORIGIN_XY_PLANE(), point);
                assertNotNull(result);
            }
        });
    }
}