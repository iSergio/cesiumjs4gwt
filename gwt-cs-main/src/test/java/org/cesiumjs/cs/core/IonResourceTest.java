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

import junit.framework.TestCase;
import org.cesiumjs.cs.BaseTestCase;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Reject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class IonResourceTest extends BaseTestCase {

    public void testFromAssetId() {
        super.beginTest(new Test() {
            @Override
            public void execute() {
                IonResource.fromAssetId(10890).then(new Fulfill<IonResource>() {
                    @Override
                    public void onFulfilled(IonResource resource) {
                        assertNotNull(resource);
                    }
                }, new Reject<Void>() {
                    @Override
                    public void onRejected(Void value) {
                        Cesium.log("Request rejected");
                        assertTrue(true);
                    }
                });
            }
        });

        super.beginTest(new Test() {
            @Override
            public void execute() {
                IonResource.fromAssetId(3883).then(new Fulfill<IonResource>() {
                    @Override
                    public void onFulfilled(IonResource value) {
                        assertNotNull(value);
                    }
                }, new Reject<Void>() {
                    @Override
                    public void onRejected(Void value) {
                        Cesium.log("Request rejected");
                        assertTrue(true);
                    }
                });
            }
        });
    }
}