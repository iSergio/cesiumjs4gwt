package org.cesiumjs.cs.core;

import org.cesiumjs.cs.BaseTestCase;
import org.cesiumjs.cs.core.geometry.BoxGeometry;
import org.cesiumjs.cs.core.geometry.GeometryInstance;
import org.cesiumjs.cs.core.geometry.options.BoxGeometryOptions;
import org.cesiumjs.cs.core.options.GeometryInstanceOptions;
import org.cesiumjs.cs.js.JsObject;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class DistanceDisplayConditionGeometryInstanceAttributeTest  extends BaseTestCase {
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
                instanceOptions.modelMatrix = Matrix4.multiplyByTranslation(Transforms.eastNorthUpToFixedFrame(Cartesian3.fromDegrees(-75.59777, 40.03883)), new Cartesian3(0.0, 0.0, 1000000.0), new Matrix4());
                instanceOptions.id = "box";
                instanceOptions.attributes = attributes;

                GeometryInstance instance = new GeometryInstance(instanceOptions);
                assertNotNull(instance);

                finishTest();
            }
        });
    }
}