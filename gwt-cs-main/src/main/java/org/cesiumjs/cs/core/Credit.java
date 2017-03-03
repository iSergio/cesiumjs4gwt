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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Credit")
public class Credit {
    /**
     * The source location for the imagery.
     */
    @JsProperty(name = "imageUrl")
    public native String imageUrl();
    /**
     * A URL location for the credit hyperlink
     */
    @JsProperty(name = "link")
    public native String link();
    /**
     * The credit text
     */
    @JsProperty(name = "text")
    public native String text();

    /**
     * A credit contains data pertaining to how to display attributions/credits for certain content on the screen.
     */
    @JsConstructor
    public Credit() {}

    /**
     * A credit contains data pertaining to how to display attributions/credits for certain content on the screen.
     * <pre>
     *     Example:
     *     {@code
     *     //Create a credit with a tooltip, imagery and link
     *     Creadit credit = new Credit("Cesium", "/images/cesium_logo.png", "http://cesiumjs.org/");
     *     }
     * </pre>
     * @param text The text to be displayed on the screen if no imageUrl is specified.
     */
    @JsConstructor
    public Credit(String text) {}

    /**
     * A credit contains data pertaining to how to display attributions/credits for certain content on the screen.
     * <pre>
     *     Example:
     *     {@code
     *     //Create a credit with a tooltip, imagery and link
     *     Creadit credit = new Credit("Cesium", "/images/cesium_logo.png", "http://cesiumjs.org/");
     *     }
     * </pre>
     * @param text The text to be displayed on the screen if no imageUrl is specified.
     * @param imageUrl The source location for an imagery
     */
    @JsConstructor
    public Credit(String text, String imageUrl) {}

    /**
     * A credit contains data pertaining to how to display attributions/credits for certain content on the screen.
     * <pre>
     *     Example:
     *     {@code
     *     //Create a credit with a tooltip, imagery and link
     *     Creadit credit = new Credit("Cesium", "/images/cesium_logo.png", "http://cesiumjs.org/");
     *     }
     * </pre>
     * @param text The text to be displayed on the screen if no imageUrl is specified.
     * @param imageUrl The source location for an imagery
     * @param link A URL location for which the credit will be hyperlinked
     */
    @JsConstructor
    public Credit(String text, String imageUrl, String link) {}

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
     * @return true if the credit has an imageUrl
     */
    @JsMethod
    public native boolean hasImage();

    /**
     * Returns true if the credit has a link
     * @return true if the credit has a link
     */
    @JsMethod
    public native boolean hasLink();
}
