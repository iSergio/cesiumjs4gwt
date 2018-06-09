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
package org.cleanlogic.cesiumjs4gwt.showcase.components.responsibility;

import com.google.gwt.core.client.GWT;
import org.cleanlogic.cesiumjs4gwt.showcase.config.Injector;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public abstract class ShowcaseBuilderHandler {

    static {
        injector = GWT.create(Injector.class);
    }

    protected static final Injector injector;

    private ShowcaseBuilderHandler successor;

    /**
     * @param theSuccessor the successor to set
     */
    public void setSuccessor(ShowcaseBuilderHandler theSuccessor) {
        this.successor = theSuccessor;
    }

    protected abstract void buildShowcase();

    protected void forwardBuildShowcase() {
        if (successor != null) {
            successor.buildShowcase();
        }
    }

    protected abstract boolean canBuildShowcase();

}
