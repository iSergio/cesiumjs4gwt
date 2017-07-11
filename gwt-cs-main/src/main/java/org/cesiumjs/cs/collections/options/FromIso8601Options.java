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

package org.cesiumjs.cs.collections.options;

import jsinterop.annotations.*;

/**
 * Options for {@link org.cesiumjs.cs.collections.TimeIntervalCollection#fromIso8601}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FromIso8601Options extends FromIso8601OptionsAbstract {
    /**
     * An ISO 8601 interval.
     */
    @JsProperty
    public String iso8601;

    /**
     * Options for {@link org.cesiumjs.cs.collections.TimeIntervalCollection#fromIso8601}.
     */
    @JsConstructor
    private FromIso8601Options() {}

    /**
     * Options for {@link org.cesiumjs.cs.collections.TimeIntervalCollection#fromIso8601}.
     * @param iso8601 An ISO 8601 interval.
     */
    @JsConstructor
    public FromIso8601Options(String iso8601) {}

    @JsFunction
    public interface DataCallback {
        void function();
    }
}
