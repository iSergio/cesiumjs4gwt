/**
 * Copyright 2015 sourceforge.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cleanlogic.cesiumjs4gwt.showcase.components.store;

import org.cesiumjs.cs.Cesium;
import org.cleanlogic.cesiumjs4gwt.showcase.ExampleBean;

import javax.inject.Singleton;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@Singleton
public class ShowcaseExampleStore implements ExampleStore {

    private final Map<String, ExampleBean> examples = new HashMap<String, ExampleBean>();

    public final void addExample(ExampleBean example) {
        if (this.examples.containsValue(example)) {
            throw new IllegalStateException("Example with Name : " + example.getName() + " already present in the Store");
        }
        this.examples.put(example.getName(), example);
    }

    public List<ExampleBean> getExamples() {
        List<ExampleBean> list = new ArrayList<ExampleBean>(examples.values());
        Collections.sort(list);
        // Sort by new
        list.sort((e1, e2) -> -Boolean.compare(e1.getExample().isNew(), e2.getExample().isNew()));
        return Collections.unmodifiableList(list);
    }

    public ExampleBean getExample(String exampleName) {
        return this.examples.get(exampleName);
    }

}
