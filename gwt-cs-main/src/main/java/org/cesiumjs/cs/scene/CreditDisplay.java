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

package org.cesiumjs.cs.scene;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Credit;
import org.cesiumjs.cs.js.JsObject;

/**
 * The credit display is responsible for displaying credits on screen.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "CreditDisplay")
public class CreditDisplay {
    /**
     * The HTML element where credits will be displayed.
     */
    @JsProperty
    public Element container;

    @JsConstructor
    protected CreditDisplay() {}

    /**
     * The credit display is responsible for displaying credits on screen.
     * @param container The HTML element where credits will be displayed
     */
    @JsConstructor
    public CreditDisplay(Element container) {}

    /**
     * The credit display is responsible for displaying credits on screen.
     * @param container The HTML element where credits will be displayed
     * @param delimiter The string to separate text credits
     */
    @JsConstructor
    public CreditDisplay(Element container, String delimiter) {}

    /**
     * The credit display is responsible for displaying credits on screen.
     * @param container The HTML element where credits will be displayed
     * @param delimiter The string to separate text credits
     * @param viewport The HTML element that will contain the credits popup
     */
    @JsConstructor
    public CreditDisplay(Element container, String delimiter, Element viewport) {}

    /**
     * Adds a credit to the list of current credits to be displayed in the credit container
     * @param credit The credit to display
     */
    @JsMethod
    public native void addCredit(Credit credit);

    /**
     * Adds credits that will persist until they are removed
     * @param credit The credit to added to defaults
     */
    @JsMethod
    public native void addDefaultCredit(Credit credit);

    /**
     * Resets the credit display to a beginning of frame state, clearing out current credits.
     */
    @JsMethod
    public native void beginFrame();

    /**
     * Destroys the resources held by this object. Destroying an object allows for deterministic release of resources, instead of relying on the garbage collector to destroy this object.
     *
     * Once an object is destroyed, it should not be used; calling any function other than isDestroyed will result in a DeveloperError exception. Therefore, assign the return value (undefined) to the object as done in the example.
     * @return
     */
    @JsMethod
    public native JsObject destroy();

    /**
     * Sets the credit display to the end of frame state, displaying credits from the last frame in the credit container.
     */
    @JsMethod
    public native void endFrame();

    /**
     * Returns true if this object was destroyed; otherwise, false.
     * @return true if this object was destroyed; otherwise, false.
     */
    @JsMethod
    public native boolean isDestroyed();

    /**
     * Removes a default credit
     * @param credit The credit to be removed from defaults
     */
    @JsMethod
    public native void removeDefaultCredit(Credit credit);

    /**
     * Updates the credit display before a new frame is rendered.
     */
    @JsMethod
    public native void update();
}
