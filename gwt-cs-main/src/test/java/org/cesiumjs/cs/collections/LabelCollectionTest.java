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

import junit.framework.TestCase;
import org.cesiumjs.cs.BaseTestCase;
import org.cesiumjs.cs.scene.Label;
import org.cesiumjs.cs.scene.options.LabelOptions;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
public class LabelCollectionTest extends BaseTestCase {
    private static final String VALUE = "LABEL";

    public void testAdd() {
        super.beginTest(new Test() {
            @Override
            public void execute() {
                LabelCollection collection = new LabelCollection();

                LabelOptions options = new LabelOptions();
                options.text = "ASDDQWEQWEDASDAFQEQWE";
                collection.add(options);

                options = new LabelOptions();
                options.text = VALUE;
                Label label = collection.add(options);

                options = new LabelOptions();
                options.text = "ASDDQWEQWEDASDAFQEQWE";
                collection.add(options);

                assertNotNull(label);
                assertEquals(VALUE, label.text);
            }
        });
    }

    public void testContains() {
        super.beginTest(new Test() {
            @Override
            public void execute() {
                LabelCollection collection = new LabelCollection();

                LabelOptions options = new LabelOptions();
                options.text = "ASDDQWEQWEDASDAFQEQWE";
                collection.add(options);

                options = new LabelOptions();
                options.text = VALUE;
                Label label = collection.add(options);

                options = new LabelOptions();
                options.text = "ASDDQWEQWEDASDAFQEQWE";
                collection.add(options);

                assertTrue(collection.contains(label));
            }
        });
    }

    public void testGet() {
        super.beginTest(new Test() {
            @Override
            public void execute() {
                LabelCollection collection = new LabelCollection();

                LabelOptions options = new LabelOptions();
                options.text = "ASDDQWEQWEDASDAFQEQWE";
                collection.add(options);

                options = new LabelOptions();
                options.text = VALUE;
                Label label = collection.add(options);

                options = new LabelOptions();
                options.text = "ASDDQWEQWEDASDAFQEQWE";
                collection.add(options);

                assertEquals(label, collection.get(1));
            }
        });
    }
}