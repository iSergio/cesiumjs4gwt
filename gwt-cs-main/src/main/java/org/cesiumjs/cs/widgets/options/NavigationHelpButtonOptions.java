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

package org.cesiumjs.cs.widgets.options;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.*;

/**
 * Options for {@link org.cesiumjs.cs.widgets.NavigationHelpButton}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class NavigationHelpButtonOptions {
    /**
     * The DOM element.
     */
    @JsProperty(name = "container")
    public Element containerElement;
    /**
     * ID that will contain the widget.
     */
    @JsProperty(name = "container")
    public String container;
    /**
     * True if the navigation instructions should initially be visible; otherwise, false.
     * Default: false
     */
    @JsProperty
    public boolean instructionsInitiallyVisible;

    @JsConstructor
    public NavigationHelpButtonOptions() {}

    @JsOverlay
    public static NavigationHelpButtonOptions create(String element) {
        NavigationHelpButtonOptions options = new NavigationHelpButtonOptions();
        options.container = element;
        return options;
    }

    @JsOverlay
    public static NavigationHelpButtonOptions create(Element element) {
        NavigationHelpButtonOptions options = new NavigationHelpButtonOptions();
        options.containerElement = element;
        return options;
    }

    @JsOverlay
    public static NavigationHelpButtonOptions create(String element, boolean instructionsInitiallyVisible) {
        NavigationHelpButtonOptions options = new NavigationHelpButtonOptions();
        options.container = element;
        options.instructionsInitiallyVisible = instructionsInitiallyVisible;
        return options;
    }

    @JsOverlay
    public static NavigationHelpButtonOptions create(Element element, boolean instructionsInitiallyVisible) {
        NavigationHelpButtonOptions options = new NavigationHelpButtonOptions();
        options.containerElement = element;
        options.instructionsInitiallyVisible = instructionsInitiallyVisible;
        return options;
    }
}
