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

package org.cesiumjs.cs.widgets;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import jsinterop.annotations.*;
import org.cesiumjs.cs.core.Clock;
import org.cesiumjs.cs.core.JulianDate;

/**
 * @author Serge Silaev aka iSergio
 */
@JsType(isNative = true, namespace = "Cesium", name = "Timeline")
public class Timeline {
    /**
     * Gets the parent container.
     */
    @JsProperty
    public Element container;

    /**
     * The Timeline is a widget for displaying and controlling the current scene
     * time.
     *
     * @param element The parent HTML container node for this widget.
     * @param clock   The clock to use.
     */
    @JsConstructor
    public Timeline(Element element, Clock clock) {
    }

    /**
     * Destroys the widget. Should be called if permanently removing the widget from
     * layout.
     */
    @JsMethod
    public native void destroy();

    /**
     * true if the object has been destroyed, false otherwise.
     *
     * @return true if the object has been destroyed, false otherwise.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Resizes the widget to match the container size.
     */
    @JsMethod
    public native void resize();

    /**
     * Sets the view to the provided times.
     *
     * @param startTime The start time.
     * @param stopTime  The stop time.
     */
    @JsMethod
    public native void zoomTo(JulianDate startTime, JulianDate stopTime);

    /**
     * Request for visible of Timeline widget.
     *
     * @return true if widget not hidden, false is hidden
     */
    @JsOverlay
    public final boolean isHidden() {
        return this.container.getStyle().getDisplay().isEmpty()
                || this.container.getStyle().getDisplay().equalsIgnoreCase(Style.Display.BLOCK.name());
    }

    /**
     * Method set visible of Timeline widget
     *
     * @param hidden false to hide Timeline widget, true widget is show.
     */
    @JsOverlay
    public final void setHidden(boolean hidden) {
        Style.Display display = hidden ? Style.Display.NONE : Style.Display.BLOCK;
        this.container.getStyle().setDisplay(display);
    }
}
