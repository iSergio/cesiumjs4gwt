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
public class IonResourceTest extends BaseTestCase {
    public void testFromAssetId1() {
        delayTestFinish(10_000);

        super.beginTest(() -> IonResource.fromAssetId(3827).then(resource -> {
            assertNotNull(resource);
            finishTest();
            }, value -> fail()));
    }

    public void testFromAssetId2() {
        delayTestFinish(10_000);

        super.beginTest(() -> IonResource.fromAssetId(3956).then(resource -> {
            assertNotNull(resource);
            finishTest();
        }, value -> fail()));
    }
}