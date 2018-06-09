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

package org.cesiumjs.cs.js;

import jsinterop.annotations.*;

/**
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Image")
public class JsImage {
    @JsProperty
    public int width;
    @JsProperty
    public int height;
    @JsProperty
    public String src;
    @JsProperty
    public Listener onload;
    @JsProperty
    public String crossOrigin;

    @JsConstructor
    public JsImage() {}

    @JsConstructor
    public JsImage(int width, int height) {}

    @JsFunction
    public interface Listener {
        void function();
    }
}
