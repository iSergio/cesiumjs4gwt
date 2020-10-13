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

package org.cesiumjs.cs.collections;

import com.google.gwt.core.client.GWT;

import org.cesiumjs.cs.BaseTestCase;
import org.cesiumjs.cs.Cesium;
import org.cesiumjs.cs.datasources.DataSource;
import org.cesiumjs.cs.datasources.GeoJsonDataSource;
import org.cesiumjs.cs.promise.Fulfill;
import org.cesiumjs.cs.promise.Reject;

/**
 * @author Serge Silaev aka iSergio
 */
public class DataSourceCollectionTest extends BaseTestCase {
  private DataSourceCollection collection;
  private DataSource geojsonDS;
  private DataSource topojsonDS;

  public void testLower() {
    delayTestFinish(10_000);

    super.beginTest(new Test() {
      @Override
      public void execute() {
        GeoJsonDataSource.load(GWT.getModuleBaseURL() + "SampleData/simplestyles.geojson")
            .then(new Fulfill<GeoJsonDataSource>() {
              @Override
              public void onFulfilled(GeoJsonDataSource dataSource) {
                assertNotNull(dataSource);
                finishTest();
              }
            }, new Reject<String>() {
              @Override
              public void onRejected(String value) {
                Cesium.log("onRejected: " + value);
                finishTest();
              }
            });
      }
    });
  }
}
