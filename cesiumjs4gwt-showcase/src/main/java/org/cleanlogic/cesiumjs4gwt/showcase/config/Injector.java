/**
 *
 *   Copyright 2015 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.cleanlogic.cesiumjs4gwt.showcase.config;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import org.cleanlogic.cesiumjs4gwt.showcase.components.ShowcaseExamplePanel;
import org.cleanlogic.cesiumjs4gwt.showcase.components.ShowcaseSearchPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.components.ShowcaseTopPanel;
import org.cleanlogic.cesiumjs4gwt.showcase.components.store.ShowcaseExampleStore;
import org.cleanlogic.cesiumjs4gwt.showcase.puregwt.ShowcaseEventBus;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@GinModules(value = {InjectorModule.class})
public interface Injector extends Ginjector {

    public static class MainInjector {

        private static final Injector instance = GWT.create(
                Injector.class);

        private MainInjector() {
        }

        public static Injector getInstance() {
            return instance;
        }

    }

    public ShowcaseEventBus getEventBus();

    public ShowcaseExampleStore getExampleStore();

    public ShowcaseSearchPanel getShowcaseSearchPanel();

    public ShowcaseTopPanel getShowcaseTopPanel();

    public ShowcaseExamplePanel getShowcaseExamplePanel();

}
