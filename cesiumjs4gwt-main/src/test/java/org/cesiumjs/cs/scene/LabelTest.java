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
import org.cesiumjs.cs.collections.LabelCollection;
import org.cesiumjs.cs.scene.enums.HorizontalOrigin;
import org.cesiumjs.cs.scene.enums.VerticalOrigin;
import org.cesiumjs.cs.scene.options.LabelOptions;

/**
 * @author Serge Silaev aka iSergio
 */
public class LabelTest extends BaseTestCase {
    public void testVerticalOrigin() {
        delayTestFinish(10_000);

        super.beginTest(() -> {
            LabelCollection collection = new LabelCollection();
            LabelOptions options = new LabelOptions();
            options.verticalOrigin = VerticalOrigin.TOP();
            Label label = collection.add(options);
            assertEquals(VerticalOrigin.TOP(), label.verticalOrigin);
            finishTest();
        });
    }

    public void testHorizontalOrigin() {
        delayTestFinish(10_000);

        super.beginTest(() -> {
            LabelCollection collection = new LabelCollection();
            LabelOptions options = new LabelOptions();
            options.horizontalOrigin = HorizontalOrigin.RIGHT();
            Label label = collection.add(options);
            assertEquals(HorizontalOrigin.RIGHT(), label.horizontalOrigin);
            finishTest();
        });
    }
}