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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Event;

/**
 * The view model for {@link InfoBox}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "InfoBoxViewModel")
public class InfoBoxViewModel {
    /**
     * Gets an Event that is fired when the user clicks the camera icon.
     */
    @JsProperty
    public Event cameraClicked;
    /**
     * Gets the SVG path of the camera icon, which can change to be "crossed out" or not.
     */
    @JsProperty
    public String cameraIconPath;
    /**
     * Gets an Event that is fired when the user closes the info box.
     */
    @JsProperty
    public Event closeClicked;
    /**
     * Gets or sets the description HTML for the info box.
     */
    @JsProperty
    public String description;
    /**
     * Gets or sets whether the camera tracking icon is enabled.
     */
    @JsProperty
    public boolean enableCamera;
    /**
     * Gets or sets the status of current camera tracking of the selected object.
     */
    @JsProperty
    public boolean isCameraTracking;
    /**
     * Gets or sets the maximum height of the info box in pixels. This property is observable.
     */
    @JsProperty
    public double maxHeight;
    /**
     * Gets or sets the visibility of the info box.
     */
    @JsProperty
    public boolean showInfo;
    /**
     * Gets or sets the title text in the info box.
     */
    @JsProperty
    public String titleText;

    /**
     * The view model for {@link InfoBox}.
     */
    @JsConstructor
    public InfoBoxViewModel() {}

    /**
     * Gets the maximum height of sections within the info box, minus an offset, in CSS-ready form.
     * @param offset et in pixels.
     * @return  maximum height of sections within the info box, minus an offset, in CSS-ready form
     */
    @JsMethod
    public native double maxHeightOffset(double offset);
}
