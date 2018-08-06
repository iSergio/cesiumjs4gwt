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

import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.TestSuite;
import org.cesiumjs.cs.collections.ClippingPlaneCollectionTest;
import org.cesiumjs.cs.collections.LabelCollectionTest;
import org.cesiumjs.cs.core.Cartesian2Test;
import org.cesiumjs.cs.core.ColorTest;
import org.cesiumjs.cs.core.IonResourceTest;
import org.cesiumjs.cs.core.geometry.CoplanarPolygonGeometryTest;
import org.cesiumjs.cs.core.geometry.GroundPolylineGeometryTest;
import org.cesiumjs.cs.scene.Cesium3DTilesetTest;
import org.cesiumjs.cs.scene.LabelTest;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class CesiumTestSuite extends GWTTestSuite {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite("GWTTestSuite for Cesium Wrapper");

        // Cesium
        suite.addTestSuite(CesiumTest.class);

        // Core
        suite.addTestSuite(ColorTest.class);
        suite.addTestSuite(Cartesian2Test.class);
        suite.addTestSuite(GroundPolylineGeometryTest.class);
        suite.addTestSuite(LabelCollectionTest.class);
        suite.addTestSuite(IonResourceTest.class);
        suite.addTestSuite(CoplanarPolygonGeometryTest.class);

        // Scene
        suite.addTestSuite(LabelTest.class);
        suite.addTestSuite(ClippingPlaneCollectionTest.class);
//        suite.addTestSuite(DataSourceCollectionTest.class);
        suite.addTestSuite(Cesium3DTilesetTest.class);

        // Widgets
        // Not understand how test widgets, in this moment strange error
        // com.google.gwt.core.shared.SerializableThrowable: (InternalError) : TypeError: Cannot convert a Symbol value to a string
//        suite.addTestSuite(ViewerPanelTest.class);

        return suite;
    }
}
