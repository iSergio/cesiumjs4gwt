/*
 * Copyright 2017 iserge.
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

package org.cesiumjs.cs.widgets;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A widget for displaying information or a description.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "InfoBox")
public class InfoBox {
    /**
     * Gets the parent container.
     */
    @JsProperty
    public Element container;
    //TODO: HTMLIFrameElement
//    /**
//     * Gets the iframe used to display the description.
//     */
//    HTMLIFrameElement frame;
    /**
     * Gets the view model.
     */
    @JsProperty
    public InfoBoxViewModel viewModel;

    /**
     * A widget for displaying information or a description.
     * @param container The DOM element or ID that will contain the widget.
     */
    @JsConstructor
    public InfoBox(Element container) {}

    /**
     * A widget for displaying information or a description.
     * @param container The DOM element or ID that will contain the widget.
     */
    @JsConstructor
    public InfoBox(String container) {}

    /**
     * Destroys the widget. Should be called if permanently removing the widget from layout.
     */
    @JsMethod
    public native void destroy();

    /**
     * true if the object has been destroyed, false otherwise.
     * @return true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();
}
