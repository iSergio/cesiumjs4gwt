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
package org.cleanlogic.cesiumjs4gwt.showcase.components.responsibility;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class BuilderManager implements ShowcaseBuilderManager {

    private final ShowcaseBuilderHandler kvpHandler = new KvpParameterHandler();

    public void buildShowcase() {
        this.kvpHandler.buildShowcase();
    }

}
