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
import org.cesiumjs.cs.core.IonResource;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Promise;
import org.cesiumjs.cs.promise.Reject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class Cesium3DTilesetTest extends BaseTestCase {

    public void testCreateResource() {
        delayTestFinish(10_000);

        super.beginTest(new Test() {
            @Override
            public void execute() {
                Promise<IonResource, Void> promise = IonResource.fromAssetId(3883);
                promise.then(new Fulfill<IonResource>() {
                    @Override
                    public void onFulfilled(IonResource resource) {
                        Cesium3DTileset tileset = Cesium3DTileset.create(resource);
                        tileset.readyPromise().then(new Fulfill<Cesium3DTileset>() {
                            @Override
                            public void onFulfilled(Cesium3DTileset value) {
                                assertNotNull(value);
                                finishTest();
                            }
                        }, new Reject<Void>() {
                            @Override
                            public void onRejected(Void value) {
                                finishTest();
                            }
                        });
                    }
                });
            }
        });
    }

    public void testCreatePromise() {
        delayTestFinish(10_000);

        super.beginTest(new Test() {
            @Override
            public void execute() {
                Promise<IonResource, Void> promise = IonResource.fromAssetId(3883);
                Cesium3DTileset tileset = Cesium3DTileset.create(promise);
                tileset.readyPromise().then(new Fulfill<Cesium3DTileset>() {
                    @Override
                    public void onFulfilled(Cesium3DTileset value) {
                        assertNotNull(value);
                        finishTest();
                    }
                }, new Reject<Void>() {
                    @Override
                    public void onRejected(Void value) {
                        assertTrue(false);
                        finishTest();
                    }
                });
            }
        });
    }
}