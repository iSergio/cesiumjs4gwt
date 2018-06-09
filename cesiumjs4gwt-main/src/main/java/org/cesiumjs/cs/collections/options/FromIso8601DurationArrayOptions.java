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
import org.cesiumjs.cs.core.JulianDate;

/**
 * Options for {@link org.cesiumjs.cs.collections.TimeIntervalCollection#fromIso8601DurationArray}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FromIso8601DurationArrayOptions extends FromIso8601OptionsAbstract {
    /**
     * An date that the durations are relative to.
     */
    @JsProperty
    public JulianDate epoch;
    /**
     * An array of ISO 8601 durations.
     */
    @JsProperty
    public String iso8601Durations;
    /**
     * if durations are relative to previous date, false if always relative to the epoch.
     * Default: false
     */
    @JsProperty
    public boolean relativeToPrevious;

    /**
     * Options for {@link org.cesiumjs.cs.collections.TimeIntervalCollection#fromIso8601DurationArray}.
     */
    @JsConstructor
    private FromIso8601DurationArrayOptions() {}

    /**
     * Options for {@link org.cesiumjs.cs.collections.TimeIntervalCollection#fromIso8601DurationArray}.
     * @param epoch An date that the durations are relative to.
     * @param iso8601Durations An array of ISO 8601 durations.
     */
    @JsConstructor
    public FromIso8601DurationArrayOptions(JulianDate epoch, String iso8601Durations) {}

    @JsFunction
    public interface DataCallback {
        void function();
    }
}
