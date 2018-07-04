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

package org.cesiumjs.cs.core;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.*;
import org.cesiumjs.cs.core.options.CreditOptions;

/**
 * A credit contains data pertaining to how to display attributions/credits for certain content on the screen.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Credit")
public class Credit {
    /**
     * Gets the credit element
     */
    @JsProperty(name = "element")
    public native Element element();
    /**
     * The credit content
     */
    @JsProperty(name = "html")
    public native String html();
    /**
     * The source location for the imagery.
     */
    @Deprecated
    @JsProperty(name = "imageUrl")
    public native String imageUrl();
    /**
     * A URL location for the credit hyperlink
     */
    @Deprecated
    @JsProperty(name = "link")
    public native String link();
    /**
     * The credit text
     */
    @Deprecated
    @JsProperty(name = "text")
    public native String text();

    /**
     * A credit contains data pertaining to how to display attributions/credits for certain content on the screen.
     */
    @Deprecated
    @JsConstructor
    public Credit() {}

    /**
     * A credit contains data pertaining to how to display attributions/credits for certain content on the screen.
     * @param options {@link CreditOptions}
     */
    @Deprecated
    @JsConstructor
    public Credit(CreditOptions options) {}

    /**
     * A credit contains data pertaining to how to display attributions/credits for certain content on the screen.
     * @param html An string representing an html code snippet (can be text only)
     */
    @JsConstructor
    public Credit(String html) {}

    /**
     * A credit contains data pertaining to how to display attributions/credits for certain content on the screen.
     * @param html An string representing an html code snippet (can be text only)
     * @param showOnScreen If true, the credit will be visible in the main credit container.
     *                     Otherwise, it will appear in a popover
     */
    @JsConstructor
    public Credit(String html, boolean showOnScreen) {}

    /**
     * Simple create {@link Credit} instance.
     * @param text {@link CreditOptions#text}.
     * @return {@link Credit} instance.
     */
    @Deprecated
    @JsOverlay
    public static Credit create(String text) {
        CreditOptions options = new CreditOptions();
        options.text = text;
        return new Credit(options);
    }

    /**
     * Returns true if the credits are equal
     * @param left The first credit
     * @param right The second credit
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public static native boolean equals(Credit left, Credit right);

    /**
     * Returns true if the credits are equal
     * @param credit The credit to compare to.
     * @return true if left and right are equal, false otherwise.
     */
    @JsMethod
    public native boolean equals(Credit credit);

    /**
     * Returns true if the credit has an imageUrl
     * @deprecated functions have been deprecated and will be removed in Cesium 1.46.
     * @return true if the credit has an imageUrl
     */
    @Deprecated
    @JsMethod
    public native boolean hasImage();

    /**
     * Returns true if the credit has a link
     * @deprecated functions have been deprecated and will be removed in Cesium 1.46.
     * @return true if the credit has a link
     */
    @Deprecated
    @JsMethod
    public native boolean hasLink();
}
