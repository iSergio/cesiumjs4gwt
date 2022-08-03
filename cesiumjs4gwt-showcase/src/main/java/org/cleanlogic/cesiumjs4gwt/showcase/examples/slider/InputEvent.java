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

import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.event.dom.client.DomEvent;

public class InputEvent extends DomEvent<InputHandler> {
    private static final Type<InputHandler> TYPE = new Type<>(BrowserEvents.INPUT, new InputEvent());

    public static Type<InputHandler> getType() {
        return TYPE;
    }

    protected InputEvent() {
    }

    @Override
    public final Type<InputHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(InputHandler handler) {
        handler.onInput(this);
    }
}
