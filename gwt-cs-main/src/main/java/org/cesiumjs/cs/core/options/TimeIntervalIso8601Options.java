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

package org.cesiumjs.cs.core.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @see <a href="http://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a>
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TimeIntervalIso8601Options {
    /**
     * An ISO 8601 interval.
     */
    @JsProperty
    public String iso8601;
    /**
     * if options.start is included in the interval, false otherwise.
     * Default: true
     */
    @JsProperty
    public boolean isStartIncluded;
    /**
     * if options.stop is included in the interval, false otherwise.
     * Default: true
     */
    @JsProperty
    public boolean isStopIncluded;
    /**
     * Arbitrary data associated with this interval.
     */
    @JsProperty
    public Object data;
}
