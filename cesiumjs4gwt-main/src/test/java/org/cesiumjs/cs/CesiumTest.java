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

package org.cesiumjs.cs;

import org.cesiumjs.cs.core.providers.CesiumTerrainProvider;
import org.cesiumjs.cs.promise.Fulfill;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class CesiumTest extends BaseTestCase {

    public void testCreateWorldTerrain() {
        delayTestFinish(10_000);

        super.beginTest(new Test() {
            @Override
            public void execute() {
                CesiumTerrainProvider terrainProvider = Cesium.createWorldTerrain();
                assertNotNull(terrainProvider);
                assertEquals(false, terrainProvider.requestVertexNormals);
                assertEquals(false, terrainProvider.requestWaterMask);
                finishTest();
            }
        });
    }

    public void testCreateWorldTerrain1() {
        delayTestFinish(10_000);

        super.beginTest(new Test() {
            @Override
            public void execute() {
                final Cesium.CreateWorldTerrainOptions options = new Cesium.CreateWorldTerrainOptions();
                options.requestVertexNormals = true;
                options.requestWaterMask = true;
                final CesiumTerrainProvider terrainProvider = Cesium.createWorldTerrain(options);
                assertNotNull(terrainProvider);
                assertEquals(options.requestVertexNormals, terrainProvider.requestVertexNormals);
                assertEquals(options.requestWaterMask, terrainProvider.requestWaterMask);
                terrainProvider.readyPromise().then(new Fulfill<Boolean>() {
                    @Override
                    public void onFulfilled(Boolean ready) {
                        if (ready) {
                            assertEquals(options.requestVertexNormals, terrainProvider.hasVertexNormals);
                            assertEquals(options.requestWaterMask, terrainProvider.hasWaterMask);
                            finishTest();
                        }
                    }
                });
            }
        });
    }
}