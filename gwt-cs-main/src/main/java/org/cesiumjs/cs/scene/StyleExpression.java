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
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.Color;
import org.cesiumjs.cs.js.JsObject;

/**
 * An expression for a style applied to a {@link Cesium3DTileset}.
 *
 * Derived classes of this interface evaluate expressions in the <a href="https://github.com/AnalyticalGraphicsInc/3d-tiles/tree/master/Styling">3D Tiles Styling language</a>.
 *
 * This type describes an interface and is not intended to be instantiated directly.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = "Cesium", name = "StyleExpression")
public interface StyleExpression {
}
