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

package org.cesiumjs.cs.scene;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.promise.Promise;

/**
 * A style that is applied to a {@link Cesium3DTileset}.
 *
 * Evaluates an expression defined using the <a href="https://github.com/AnalyticalGraphicsInc/3d-tiles/tree/master/Styling">3D Tiles Styling language</a>.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "Cesium3DTileStyle")
public class Cesium3DTileStyle {
    /**
     * Gets or sets the StyleExpression object used to evaluate the style's color property.
     * The expression must return a Color.
     */
    @JsProperty
    public StyleExpression color;
    /**
     * Gets or sets the object containing application-specific expression that can be explicitly evaluated, e.g., for display in a UI.
     */
    @JsProperty
    public StyleExpression meta;
    /**
     * Gets or sets the StyleExpression object used to evaluate the style's pointSize property.
     * The expression must return or convert to a Number.
     */
    @JsProperty
    public StyleExpression pointSize;
    /**
     * When true, the style is ready and its expressions can be evaluated. When a style is constructed with an object, as opposed to a url, this is true immediately.
     * Default: false
     */
    @JsProperty(name = "ready")
    public native boolean ready();
    /**
     * Gets the promise that will be resolved when the the style is ready and its expressions can be evaluated.
     */
    @JsProperty(name = "readyPromise")
    public native Promise<Cesium3DTileStyle, Void> readyPromise();
    /**
     * Gets or sets the StyleExpression object used to evaluate the style's show property.
     * The expression must return or convert to a Boolean.
     */
    @JsProperty
    public StyleExpression show;
    /**
     * Gets the object defining the style using the 3D Tiles Styling language.
     * Default: undefined
     */
    @JsProperty(name = "style")
    public native Object style();

    @JsConstructor
    public Cesium3DTileStyle() {}
    @JsConstructor
    public Cesium3DTileStyle(String style) {}
}
