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

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Cartesian2Test extends BaseTestCase {
    private static final Logger LOGGER = LogManager.getLogManager().getLogger(Cartesian2Test.class.getName());
    public void testConstructor() {
        delayTestFinish(10_000);

        super.beginTest(new Test() {
            @Override
            public void execute() {
                Cartesian2 cartesian2 = new Cartesian2(1.0, 2.0);
                assertNotNull(cartesian2);
                assertEquals(1.0, cartesian2.x);
                assertEquals(2.0, cartesian2.y);
                finishTest();
            }
        });
    }
}