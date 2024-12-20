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
package org.cleanlogic.cesiumjs4gwt.showcase;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * ImageResource stuff.
 *
 * @author fks/Frank Wynants
 */
public interface Resources extends ClientBundle {

    /**
     * The singleton instance.
     */
    Resources INSTANCE = GWT.create(Resources.class);

    /**
     * The GWT-OL logo.
     *
     * @return The imagery resource.
     */
    @Source("resources/gwt-cs.png")
    ImageResource gwtCsLogo();

    /**
     * The info icon
     *
     * @return The imagery resource.
     */
    @Source("resources/icon-info.png")
    ImageResource icon_info();

    @Source("resources/icon-new.png")
    ImageResource icon_new();
}
