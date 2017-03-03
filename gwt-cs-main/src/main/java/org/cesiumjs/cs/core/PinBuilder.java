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

package org.cesiumjs.cs.core;

import com.google.gwt.dom.client.CanvasElement;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.promise.Promise;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "PinBuilder")
public class PinBuilder {
    /**
     * A utility class for generating custom map pins as canvas elements.
     */
    @JsConstructor
    public PinBuilder() {}

    /**
     * Creates an empty pin of the specified color and size.
     * @param color The color of the pin.
     * @param size The size of the pin, in pixels.
     * @return The canvas element that represents the generated pin.
     */
    @JsMethod
    public native CanvasElement fromColor(Color color, int size);

    /**
     * Creates a pin with the specified maki icon identifier, color, and size.
     * @param id The id of the maki icon to be stamped onto the pin.
     * @param color The color of the pin.
     * @param size The size of the pin, in pixels.
     * @return The canvas element to the canvas element that represents the generated pin.
     */
    @JsMethod
    public native CanvasElement fromMakiIconId(String id, Color color, int size);

    /**
     * Creates a pin with the specified maki icon identifier, color, and size.
     * @param id The id of the maki icon to be stamped onto the pin.
     * @param color The color of the pin.
     * @param size The size of the pin, in pixels.
     * @return The Promise to the canvas element that represents the generated pin.
     */
    @JsMethod(name = "fromMakiIconId")
    public native Promise<CanvasElement, Void> fromMakiIconIdPromise(String id, Color color, int size);

    /**
     * Creates a pin with the specified text, color, and size. The text will be sized to be as large as
     * possible while still being contained completely within the pin.
     * @param text The text to be stamped onto the pin.
     * @param color The color of the pin.
     * @param size The size of the pin, in pixels.
     * @return The canvas element that represents the generated pin.
     */
    @JsMethod
    public native CanvasElement fromText(String text, Color color, int size);

    /**
     * Creates a pin with the specified icon, color, and size.
     * @param url The url of the image to be stamped onto the pin.
     * @param color The color of the pin.
     * @param size The size of the pin, in pixels.
     * @return The canvas element or a Promise to the canvas element that represents the generated pin.
     */
    @JsMethod
    public native CanvasElement fromUrl(String url, Color color, int size);

    /**
     * Creates a pin with the specified icon, color, and size.
     * @param url The url of the image to be stamped onto the pin.
     * @param color The color of the pin.
     * @param size The size of the pin, in pixels.
     * @return The canvas element or a Promise to the canvas element that represents the generated pin.
     */
    @JsMethod
    public native Promise<CanvasElement, Void> fromUrlPromise(String url, Color color, int size);
}
