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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.cesiumjs.cs.core.JulianDate;

/**
 * Options for {@link org.cesiumjs.cs.collections.TimeIntervalCollection#fromJulianDateArray}.
 *
 * @author Serge Silaev aka iSergio <s.serge.b@gmail.com>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FromJulianDateArrayOptions extends FromIso8601OptionsAbstract {
    /**
     * An array of ISO 8601 dates.
     */
    @JsProperty
    public JulianDate[] julianDates;

    /**
     * Options for {@link org.cesiumjs.cs.collections.TimeIntervalCollection#fromJulianDateArray}.
     */
    @JsConstructor
    private FromJulianDateArrayOptions() {}

    /**
     * Options for {@link org.cesiumjs.cs.collections.TimeIntervalCollection#fromJulianDateArray}.
     * @param julianDates An array of ISO 8601 dates.
     */
    @JsConstructor
    public FromJulianDateArrayOptions(JulianDate[] julianDates) {}
}
