/*
 * Copyright 2022 iSergio, Gis4Fun.
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

package org.cleanlogic.cesiumjs4gwt.showcase.examples.slider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;

public class PassthroughRenderer extends AbstractRenderer<Double> {

    private static PassthroughRenderer INSTANCE;

    /**
     * Returns the instance of the no-op renderer.
     */
    public static Renderer<Double> instance() {
        if (INSTANCE == null) {
            INSTANCE = new PassthroughRenderer();
        }
        return INSTANCE;
    }

    protected PassthroughRenderer() {
    }

    public String render(Double object) {
        return String.valueOf(object);
    }
}
