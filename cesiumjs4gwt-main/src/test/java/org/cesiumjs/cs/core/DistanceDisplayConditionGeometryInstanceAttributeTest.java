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
import org.cesiumjs.cs.core.geometry.BoxGeometry;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.core.geometry.options.BoxGeometryOptions;
import org.cesiumjs.cs.core.options.GeometryInstanceOptions;
import org.cesiumjs.cs.js.JsObject;

/**
 * @author Serge Silaev aka iSergio
 */
public class DistanceDisplayConditionGeometryInstanceAttributeTest extends BaseTestCase {
  public void test() {
    delayTestFinish(10_000);

    super.beginTest(new Test() {
      @Override
      public void execute() {
        BoxGeometryOptions boxGeometryOptions = new BoxGeometryOptions();
        boxGeometryOptions.vertexFormat = VertexFormat.POSITION_AND_NORMAL();
        boxGeometryOptions.minimum = new Cartesian3(-250000.0, -250000.0, -250000.0);
        boxGeometryOptions.maximum = new Cartesian3(250000.0, 250000.0, 250000.0);

        JsObject attributes = JsObject.create();
        attributes.setProperty("show", new DistanceDisplayConditionGeometryInstanceAttribute(100.0, 10000.0));

        GeometryInstanceOptions instanceOptions = new GeometryInstanceOptions();
        instanceOptions.geometry = new BoxGeometry(boxGeometryOptions);
        instanceOptions.modelMatrix = Matrix4.multiplyByTranslation(
            Transforms.eastNorthUpToFixedFrame(Cartesian3.fromDegrees(-75.59777, 40.03883)),
            new Cartesian3(0.0, 0.0, 1000000.0), new Matrix4());
        instanceOptions.id = "box";
        instanceOptions.attributes = attributes;

        GeometryInstance instance = new GeometryInstance(instanceOptions);
        assertNotNull(instance);

        finishTest();
      }
    });
  }
}